package driver;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Properties;

import db.MySQLConnectionFactory;
import model.Device;
import service.DeviceService;
import service.MessageService;

public class Main {

	static {
		Properties boneCPConfigProperties = new Properties();
		try {
			boneCPConfigProperties.load(Main.class.getResourceAsStream("/bonecp.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MySQLConnectionFactory.init(boneCPConfigProperties);
	}

	public static void main(String[] args) {

		DeviceService.addDevice(new Device("gaurav.walia@andrew.cmu.edu", Timestamp.valueOf(LocalDateTime.now())));
		DeviceService.addDevice(new Device("gaurav.walia@cmu.edu", Timestamp.valueOf(LocalDateTime.now())));

		DeviceService.removeDevice("gaurav.walia@cmu.edu", Timestamp.valueOf(LocalDateTime.now()));

		DeviceService.getAll();

		MessageService.addMessage("gaurav.walia@cmu.edu", Timestamp.valueOf(LocalDateTime.now()), "Facebook",
				"How are you");

		System.out.println("done");

	}

}
