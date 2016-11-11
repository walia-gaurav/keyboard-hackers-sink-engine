package model;

import java.util.Date;

public class Message {

	int idMessage;
	Date messageTime;
	String message;
	String appName;

	public Message(int idMessage, Date messageTime, String appName, String message) {
		this.idMessage = idMessage;
		this.messageTime = messageTime;
		this.appName = appName;
		this.message = message;
	}

	public int getIdMessage() {
		return idMessage;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public String getMessage() {
		return message;
	}

	public String getAppName() {
		return appName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [idMessage=");
		builder.append(idMessage);
		builder.append(", messageTime=");
		builder.append(messageTime);
		builder.append(", message=");
		builder.append(message);
		builder.append(", appName=");
		builder.append(appName);
		builder.append("]");
		return builder.toString();
	}

}
