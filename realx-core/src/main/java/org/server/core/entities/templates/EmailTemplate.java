package org.server.core.entities.templates;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.enums.email.EmailNameEnum;

@Entity
@Table
public class EmailTemplate extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@OneToOne
	private TextTemplate textTemplate;
	private String subject;
	private String emailType;
	@Enumerated(EnumType.STRING)
	private EmailNameEnum emailName;

	public TextTemplate getTextTemplate() {
		return textTemplate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setTextTemplate(TextTemplate textTemplate) {
		this.textTemplate = textTemplate;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmailNameEnum getEmailName() {
		return emailName;
	}

	public void setEmailName(EmailNameEnum emailName) {
		this.emailName = emailName;
	}

}
