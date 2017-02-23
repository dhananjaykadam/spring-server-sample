package org.realx.filestore.entities.abstracts;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import org.realx.core.entities.abstracts.VersionableEntity;

@MappedSuperclass
public abstract class AbstractFile extends VersionableEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
