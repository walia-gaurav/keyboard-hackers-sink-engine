package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * Load BoneCP connection pool.
 */
public class MySQLConnectionFactory {

	private static BoneCP connectionPool = null;

	/**
	 * Load configuration from a file an create a connection pool with it.
	 */
	public static void init(Properties boneCPConfigProperties) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Problems loading MySQL driver" + ex);
			return;
		}

		try {
			BoneCPConfig config = new BoneCPConfig();

			config.setUser(boneCPConfigProperties.getProperty("username"));
			config.setPassword(boneCPConfigProperties.getProperty("password"));
			config.setJdbcUrl(boneCPConfigProperties.getProperty("jdbcUrl") + "?autoReconnect=true");
			config.setMinConnectionsPerPartition(
					Integer.parseInt(boneCPConfigProperties.getProperty("minConnectionsPerPartition")));
			config.setMaxConnectionsPerPartition(
					Integer.parseInt(boneCPConfigProperties.getProperty("maxConnectionsPerPartition")));
			config.setPartitionCount(Integer.parseInt(boneCPConfigProperties.getProperty("partitionCount")));
			config.setAcquireIncrement(Integer.parseInt(boneCPConfigProperties.getProperty("acquireIncrement")));
			config.setMaxConnectionAgeInSeconds(
					Integer.parseInt(boneCPConfigProperties.getProperty("maxConnectionAgeInSeconds")));

			connectionPool = new BoneCP(config);
		} catch (SQLException ex) {
			System.out.println("Problems creating connection pool" + ex);
		}
	}

	/**
	 * Get a SQL connection.
	 */
	public static Connection getConnection() throws SQLException {
		return connectionPool.getConnection();
	}

	/**
	 * Shutdown connection pool.
	 */
	public static void shutdown() {
		connectionPool.shutdown();
	}

}