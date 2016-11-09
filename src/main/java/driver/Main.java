package driver;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import db.MySQLConnectionFactory;
import db.ServerContext;
import model.Device;
import service.DeviceService;
import service.MessageService;

public class Main {

	static {
		Properties boneCPConfigProperties = new Properties();
		try {
			boneCPConfigProperties.load(ServerContext.class.getResourceAsStream("/bonecp.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		MySQLConnectionFactory.init(boneCPConfigProperties);
	}

	public static void main(String[] args) {

		DeviceService.addDevice(new Device("gaurav.walia@andrew.cmu.edu", LocalDateTime.now()));
		DeviceService.addDevice(new Device("gaurav.walia@cmu.edu", LocalDateTime.now()));

		DeviceService.removeDevice("gaurav.walia@cmu.edu", LocalDateTime.now());

		DeviceService.getAll();

		MessageService.addMessage("gaurav.walia@cmu.edu", LocalDateTime.now(), "Facebook", "How are you");

		System.out.println("done");

	}

}
