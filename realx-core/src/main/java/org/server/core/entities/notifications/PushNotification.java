package org.server.core.entities.notifications;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.user.User;
import org.server.core.enums.notifications.NotificationUniqueName;

@Entity
@Table
public class PushNotification extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@OneToOne
	private User sender;
	@OneToOne
	private PushNotificationReceiver reciever;
	@OneToOne
	private PushNotificationTypeInfo notificationType;
	@Enumerated(EnumType.STRING)
	private NotificationUniqueName notificationUniqueName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public NotificationUniqueName getNotificationUniqueName() {
		return notificationUniqueName;
	}

	public void setNotificationUniqueName(NotificationUniqueName notificationUniqueName) {
		this.notificationUniqueName = notificationUniqueName;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public PushNotificationReceiver getReciever() {
		return reciever;
	}

	public void setReciever(PushNotificationReceiver reciever) {
		this.reciever = reciever;
	}

	public PushNotificationTypeInfo getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(PushNotificationTypeInfo notificationType) {
		this.notificationType = notificationType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
