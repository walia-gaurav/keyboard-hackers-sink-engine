package model;

import java.time.LocalDateTime;

public class Message {

	LocalDateTime messageTime;
	String message;
	String appName;

	public Message(LocalDateTime messageTime, String appName, String message) {
		this.messageTime = messageTime;
		this.appName = appName;
		this.message = message;
	}

}
