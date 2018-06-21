package org.server.services.verification.otp;

import org.server.core.dtos.otp.OTPObject;
import org.server.services.verification.otp.foneverify.FoneverifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

	@Autowired
	private FoneverifyService verificationService;

	public OTPObject sendOTP(String msisdn, String isoCountryCode, boolean isCountryCodeInChars) {
		if (isCountryCodeInChars) {
			return getVerificationService().sendOTP(msisdn, isoCountryCode);
		}
		return null;
	}

	public OTPObject sendOTPProd(String msisdn, String isoCountryCode, boolean isCountryCodeInChars) {
		if (!isCountryCodeInChars) {
			return getVerificationService().sendOTPProd(msisdn, isoCountryCode);
		}
		return null;
	}

	public OTPObject verifyOTP(String otp, String verificationId) {
		return getVerificationService().verifyOTP(otp, verificationId);
	}

	public OTPObject VerifyDelivery(String otp, String verificationId) {
		return null;
	}

	public FoneverifyService getVerificationService() {
		return verificationService;
	}

	public void setVerificationService(FoneverifyService verificationService) {
		this.verificationService = verificationService;
	}

	public OTPObject OTPViaCall(String msisdn, String isoCountryCode, boolean isCountryCodeInChars) throws Exception {
		if (isCountryCodeInChars) {
			return getVerificationService().OTPViaCall(msisdn, isoCountryCode);
		}
		return null;
	}

}
