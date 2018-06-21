package org.server.core.entities.notifications;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.enums.notifications.NotificationType;

@Entity
@Table
public class PushNotificationTypeInfo extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private NotificationType notificationType;

	public NotificationType getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(NotificationType notificationType) {
		this.notificationType = notificationType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
