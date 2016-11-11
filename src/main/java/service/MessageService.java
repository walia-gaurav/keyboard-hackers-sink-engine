package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.MySQLConnectionFactory;
import model.Message;
import utility.Helper;

public class MessageService {

	private static final String ADD_QUERY = "INSERT INTO Message VALUES (NULL,?,?,?,?);";
	private static final String DISTINCT_APP_QUERY = "SELECT DISTINCT appName FROM Message WHERE idDevice=?;";
	private static final String GET_ALL_QUERY = "SELECT * FROM Message WHERE idDevice=? ORDER BY idMessage DESC;";
	private static final String GET_ALL_FOR_APP_QUERY = "SELECT * FROM Message WHERE idDevice=? AND appName=? "
			+ "ORDER BY idMessage DESC;";

	public static void addMessage(String deviceId, Date messageTime, String appName, String content)
			throws SQLException {
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
			preparedStatement.setString(1, appName.toLowerCase());
			preparedStatement.setString(2, content);
			preparedStatement.setString(3, Helper.toSQLDate(messageTime));
			preparedStatement.setString(4, deviceId);

			preparedStatement.execute();
		}
	}

	public static List<String> getDistinctApplications(String deviceId) {
		List<String> applications = new ArrayList<>();
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(DISTINCT_APP_QUERY);
			preparedStatement.setString(1, deviceId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				applications.add(resultSet.getString("appName"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return applications;
	}

	public static List<Message> getAllMessages(String deviceId) {
		List<Message> messages = new ArrayList<>();
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
			preparedStatement.setString(1, deviceId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Message message = new Message(resultSet.getInt("idMessage"),
						Helper.toJavaDate(resultSet.getString("timestamp")), resultSet.getString("appName"),
						resultSet.getString("content"));
				messages.add(message);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return messages;
	}

	public static List<Message> getAllMessagesPerApplication(String deviceId, String appName) {
		List<Message> messages = new ArrayList<>();
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FOR_APP_QUERY);
			preparedStatement.setString(1, deviceId);
			preparedStatement.setString(2, appName);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Message message = new Message(resultSet.getInt("idMessage"),
						Helper.toJavaDate(resultSet.getString("timestamp")), resultSet.getString("appName"),
						resultSet.getString("content"));
				messages.add(message);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return messages;
	}
}
