package org.realx.qrcode.enums;

public enum ImageFormat {
	GIF("gif"), PNG("png"), JPG("jpg");
	String format;

	ImageFormat(String value) {
		this.format = value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
}
