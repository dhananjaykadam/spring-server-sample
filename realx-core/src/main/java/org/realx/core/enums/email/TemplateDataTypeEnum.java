package org.realx.core.enums.email;

public enum TemplateDataTypeEnum {
	TEXT("TEXT"), HTML("HTML"), XML("XML");
	TemplateDataTypeEnum(String value) {
		this.value = value;
	}

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
