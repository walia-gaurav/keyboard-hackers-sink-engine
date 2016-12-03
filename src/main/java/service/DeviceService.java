package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.MySQLConnectionFactory;
import model.Device;
import utility.Helper;

public class DeviceService {

	private static final String ADD_QUERY = "INSERT INTO Device VALUES (?,?, NULL, ?);";
	private static final String REMOVE_QUERY = "UPDATE Device SET deleteDate = ? WHERE idDevice = ?;";
	private static final String GET_ALL_QUERY = "SELECT * FROM Device ORDER BY installationDate DESC;";

	public static void addDevice(Device device) throws SQLException {
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(ADD_QUERY);
			preparedStatement.setString(1, device.getIdDevice());
			preparedStatement.setString(2, Helper.toSQLDate(device.getInstallationDate()));
			preparedStatement.setString(3, Helper.generateRandomTokenValue());
			preparedStatement.execute();
		}
	}

	public static void removeDevice(String idDevice, Date deleteDate) throws SQLException {
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY);
			preparedStatement.setString(1, Helper.toSQLDate(deleteDate));
			preparedStatement.setString(2, idDevice);
			preparedStatement.executeUpdate();
		}
	}

	public static List<Device> getAll() {
		List<Device> devices = new ArrayList<>();
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Device device = new Device(resultSet.getString("idDevice"),
						Helper.toJavaDate(resultSet.getString("installationDate")));
				device.setDeleteDate(Helper.toJavaDate(resultSet.getString("deleteDate")));

				devices.add(device);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return devices;
	}

}
