package org.server.core.entities.other;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;

@Table
@Entity
public class DayOfWeek extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean sunday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean monday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean tuesday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean wednesday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean thursday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean friday;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean saturday;

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThursday() {
		return thursday;
	}

	public void setThursday(boolean thursday) {
		this.thursday = thursday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
