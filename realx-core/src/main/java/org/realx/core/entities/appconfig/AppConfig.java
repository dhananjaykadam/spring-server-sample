package org.realx.core.entities.appconfig;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Table
@Entity
public class AppConfig extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	private String metaKey;
	private String metaValue;
	private String description;

	public String getMetaKey() {
		return metaKey;
	}

	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	public String getMetaValue() {
		return metaValue;
	}

	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
