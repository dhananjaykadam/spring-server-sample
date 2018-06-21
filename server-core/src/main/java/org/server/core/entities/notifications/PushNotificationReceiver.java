package org.server.core.entities.notifications;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.user.User;
import org.server.core.enums.notifications.NotificationStatus;
import org.server.core.enums.notifications.ReceiverType;

@Table
@Entity
public class PushNotificationReceiver extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private User individualReceiver;
	@Enumerated(EnumType.STRING)
	private NotificationStatus status;
	@Enumerated(EnumType.STRING)
	private ReceiverType ReceiverType;
	@OneToOne
	private PushNotificationGroup group;

	public NotificationStatus getStatus() {
		return status;
	}

	public void setStatus(NotificationStatus status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getIndividualReceiver() {
		return individualReceiver;
	}

	public void setIndividualReceiver(User individualReceiver) {
		this.individualReceiver = individualReceiver;
	}

	public ReceiverType getReceiverType() {
		return ReceiverType;
	}

	public void setReceiverType(ReceiverType receiverType) {
		ReceiverType = receiverType;
	}

	public PushNotificationGroup getGroup() {
		return group;
	}

	public void setGroup(PushNotificationGroup group) {
		this.group = group;
	}

}
