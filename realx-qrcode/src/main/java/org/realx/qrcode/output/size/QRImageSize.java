package org.realx.qrcode.output.size;

public class QRImageSize {
	public int width;
	public int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public QRImageSize setQRWidth(int width) {
		this.width = width;
		return this;
	}

	public QRImageSize setQRHeight(int height) {
		this.height = height;
		return this;
	}

	public QRImageSize setQRWidthHeight(int width, int height) {
		this.width = width;
		this.height = height;
		return this;
	}
}
