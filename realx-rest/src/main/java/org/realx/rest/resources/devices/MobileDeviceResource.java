package org.realx.rest.resources.devices;

import org.realx.core.entities.devices.MobileDevice;
import org.realx.core.enums.devices.DeviceType;
import org.realx.services.devices.MobileDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("devices/mobiles")
public class MobileDeviceResource {

	@Autowired
	private MobileDeviceService mobileDeviceService;

	public MobileDeviceService getMobileDeviceService() {
		return mobileDeviceService;
	}

	public void setMobileDeviceService(MobileDeviceService mobileDeviceService) {
		this.mobileDeviceService = mobileDeviceService;
	}

	@RequestMapping("android/deviceid")
	public ResponseEntity<MobileDevice> putDeviceId(@RequestBody MobileDevice mobileDevice) {
		mobileDevice.setDeviceType(DeviceType.ANDROID_MOBILE);
		mobileDevice = getMobileDeviceService().addNewMobileDeviceForCurrentUser(mobileDevice);
		getMobileDeviceService().topicsSubscriptionForNewMobileDeviceForCurrentUser(mobileDevice);
		return ResponseEntity.ok().body(mobileDevice);
	}
}
