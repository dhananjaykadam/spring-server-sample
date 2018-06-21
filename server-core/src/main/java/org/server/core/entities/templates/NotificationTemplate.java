package org.server.core.entities.templates;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.enums.email.TemplateDataTypeEnum;
import org.server.core.enums.notifications.NotificationNameEnum;

@Entity
@Table
public class NotificationTemplate extends VersionableEntity {
	private static final long serialVersionUID = 1L;

	private String title;

	@OneToOne
	private TextTemplate bodyTextTemplate;

	@Enumerated(EnumType.STRING)
	private NotificationNameEnum notificationName;

	@Enumerated(EnumType.STRING)
	private TemplateDataTypeEnum templateDataType;
	
	private String sound;

	

	public TextTemplate getBodyTextTemplate() {
		return bodyTextTemplate;
	}

	public void setBodyTextTemplate(TextTemplate bodyTextTemplate) {
		this.bodyTextTemplate = bodyTextTemplate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public NotificationNameEnum getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(NotificationNameEnum notificationName) {
		this.notificationName = notificationName;
	}

	public TemplateDataTypeEnum getTemplateDataType() {
		return templateDataType;
	}

	public void setTemplateDataType(TemplateDataTypeEnum templateDataType) {
		this.templateDataType = templateDataType;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	

}
