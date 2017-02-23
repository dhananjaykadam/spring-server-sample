package org.realx.core.entities.profile.preferences;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class ProfilePreferences extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	private Long timeZoneOffset;

	public Long getTimeZoneOffset() {
		return timeZoneOffset;
	}

	public void setTimeZoneOffset(Long timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
