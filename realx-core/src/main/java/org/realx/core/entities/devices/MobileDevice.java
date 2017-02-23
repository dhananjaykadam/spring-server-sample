package org.realx.core.entities.devices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.entities.user.User;
import org.realx.core.enums.devices.DeviceType;

@Entity
@Table
public class MobileDevice extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private DeviceType deviceType;
	@Column(length = 2000)
	private String pushRegistrationId;
	@ManyToOne
	private User user;
	private String deviceId;
	private String deviceModel;
	private String deviceOSVersion;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceOSVersion() {
		return deviceOSVersion;
	}

	public void setDeviceOSVersion(String deviceOSVersion) {
		this.deviceOSVersion = deviceOSVersion;
	}

	public DeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public String getPushRegistrationId() {
		return pushRegistrationId;
	}

	public void setPushRegistrationId(String deviceId) {
		this.pushRegistrationId = deviceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
