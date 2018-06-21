package org.server.core.entities.notifications;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@SuppressWarnings("serial")

@Entity
@Table
public class PushNotificationGroup extends VersionableEntity {
	private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
