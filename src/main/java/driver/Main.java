package driver;

import java.io.IOException;
import java.util.Properties;

import db.MySQLConnectionFactory;

/**
 * ONLY FOR INTERNAL TESTING!
 * 
 * @author walia-mac
 *
 */
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
		//
		// DeviceService.addDevice(new Device("mark.zuckerburg@facebook.com",
		// Timestamp.valueOf(LocalDateTime.now())));
		// DeviceService.addDevice(new Device("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now())));
		//
		// DeviceService.removeDevice("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()));
		//
		// DeviceService.getAll();

		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Facebook",
		// "How are you");
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Facebook",
		// "Nice");
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Facebook",
		// "Whats up");
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Facebook",
		// "Cool");
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Facebook",
		// "Goodnight");
		// System.out.println("done");
		//
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Gmail",
		// "Dear Sir,");
		// MessageService.addMessage("gaurav.walia@cmu.edu",
		// Timestamp.valueOf(LocalDateTime.now()), "Gmail",
		// "Hope you're doing good.");
		// System.out.println("done");

	}

}
