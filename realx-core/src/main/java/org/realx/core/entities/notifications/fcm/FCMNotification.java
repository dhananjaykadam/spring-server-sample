package org.realx.core.entities.notifications.fcm;

import java.util.Map;

import org.realx.core.entities.notifications.NotificationContent;

public class FCMNotification {
	String to;
	private NotificationContent notification;
	private Map<String, ?> data;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public NotificationContent getNotification() {
		return notification;
	}

	public void setNotification(NotificationContent notification) {
		this.notification = notification;
	}

	public Map<String, ?> getData() {
		return data;
	}

	public void setData(Map<String, ?> data) {
		this.data = data;
	}

}
