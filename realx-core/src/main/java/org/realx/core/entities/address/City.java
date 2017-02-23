package org.realx.core.entities.address;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

@Entity
@Table(name = "master_city")
public class City extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	private String name;
	@ManyToOne
	private States state;
	@Column(columnDefinition = "tinyint(1) default 1")
	private Boolean enabled;
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<Area> areas;

	public String getName() {
		return name;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public void setName(String name) {
		this.name = name;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
