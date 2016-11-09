package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.MySQLConnectionFactory;
import model.Device;
import utility.DeviceIdentifier;

public class DeviceService {

	private static final String ADD_QUERY = "INSERT INTO Device VALUES (?,?, NULL, ?);";
	private static final String REMOVE_QUERY = "UPDATE Device SET deleteDate = ? WHERE idDevice = ?;";
	private static final String GET_ALL_QUERY = "SELECT * FROM Device;";

	public static void addDevice(Device device) {
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

	public static void removeDevice(String idDevice, LocalDateTime deleteDate) {
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_QUERY);
			preparedStatement.setTimestamp(1, Timestamp.valueOf(deleteDate));
			preparedStatement.setString(2, idDevice);
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static List<Device> getAll() {
		List<Device> devices = new ArrayList<>();
		try (Connection connection = MySQLConnectionFactory.getConnection()) {
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_QUERY);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				LocalDateTime installationDate = timestampToLocalDateTime(resultSet.getTimestamp("installationDate"));
				LocalDateTime deleteDate = timestampToLocalDateTime(resultSet.getTimestamp("deleteDate"));

				Device device = new Device(resultSet.getString("idDevice"), installationDate);
				device.setDeleteDate(deleteDate);

				devices.add(device);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return devices;
	}

	private static LocalDateTime timestampToLocalDateTime(Timestamp timestamp) throws SQLException {
		return (timestamp == null ? null : timestamp.toLocalDateTime());
	}
}
