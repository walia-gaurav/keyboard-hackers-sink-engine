package model;

import java.util.Date;

public class Message {

	Date messageTime;
	String message;
	String appName;

	public Message(Date messageTime, String appName, String message) {
		this.messageTime = messageTime;
		this.appName = appName;
		this.message = message;
	}

}
