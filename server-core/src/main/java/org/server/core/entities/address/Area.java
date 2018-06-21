package org.server.core.entities.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "master_area")
public class Area extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JsonIgnore
	private City city;
	private String name;
	@Column(columnDefinition = "tinyint(1) default 1")
	private Boolean enabled;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
