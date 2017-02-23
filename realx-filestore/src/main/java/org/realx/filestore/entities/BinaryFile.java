package org.realx.filestore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.realx.filestore.entities.abstracts.AbstractFile;

@Entity
@Table
public class BinaryFile extends AbstractFile {
	private static final long serialVersionUID = 1L;
	@Column(length = 1000000)
	private byte[] content;
	private String fileType;
	private String contentType;
	private String fileId;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
