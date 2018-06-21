package org.server.core.entities.secure.keys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Table
@Entity
public class SecureKey extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	private String keyContent;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean keyNonExpired;

	public boolean isKeyNonExpired() {
		return keyNonExpired;
	}

	public void setKeyNonExpired(boolean keyNonExpired) {
		this.keyNonExpired = keyNonExpired;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getKeyContent() {
		return keyContent;
	}

	public void setKeyContent(String keyContent) {
		this.keyContent = keyContent;
	}

}
