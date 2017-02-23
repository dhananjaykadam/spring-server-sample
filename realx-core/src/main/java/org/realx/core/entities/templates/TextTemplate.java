package org.realx.core.entities.templates;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.enums.email.TemplateDataTypeEnum;

@Table
@Entity
public class TextTemplate extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@Column(columnDefinition = "TEXT")
	private String content;
	private String templateType;
	@Enumerated(EnumType.STRING)
	private TemplateDataTypeEnum templateDataType;
	private String uniqueName;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public TemplateDataTypeEnum getTemplateDataType() {
		return templateDataType;
	}

	public void setTemplateDataType(TemplateDataTypeEnum templateDataType) {
		this.templateDataType = templateDataType;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

}
