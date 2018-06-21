package org.server.rest.resources.verification.otp;

import org.server.core.dtos.otp.OTPObject;
import org.server.services.verification.otp.OTPDBService;
import org.server.services.verification.otp.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("otp/")
public class OTPResource {

	@Autowired
	private OTPService otpService;
	@Autowired
	private OTPDBService otdpService;

	public OTPDBService getOtdpService() {
		return otdpService;
	}

	public void setOtdpService(OTPDBService otdpService) {
		this.otdpService = otdpService;
	}

	public OTPService getOtpService() {
		return otpService;
	}

	public void setOtpService(OTPService otpService) {
		this.otpService = otpService;
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<OTPObject> sendOTPToNumber(@RequestBody OTPObject otpObject) {
		getOtdpService().sendPersistOtpProd(otpObject.getContactNumber(), otpObject.getCountryCode(), true, null);
		return ResponseEntity.ok().body(otpObject);
	}

}
