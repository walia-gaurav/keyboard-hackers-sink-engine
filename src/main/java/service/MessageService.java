package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import db.MySQLConnectionFactory;
import model.Device;
import utility.DeviceIdentifier;

public class MessageService {

	private static final String ADD_QUERY = "INSERT INTO Message VALUES (NULL,?,?,?,?);";

	public static void addMessage(String deviceId, LocalDateTime messageTime, String appName, String content) {

		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
			preparedStatement.setString(1, appName);
			preparedStatement.setString(2, content);
			preparedStatement.setTimestamp(3, Timestamp.valueOf(messageTime));
			preparedStatement.setString(4, deviceId);

			preparedStatement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void addDevice(Device device) {
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
			preparedStatement.setString(1, device.getIdDevice());
			preparedStatement.setTimestamp(2, Timestamp.valueOf(device.getInstallationDate()));
			preparedStatement.setString(3, DeviceIdentifier.generateRandomTokenValue());
			preparedStatement.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
