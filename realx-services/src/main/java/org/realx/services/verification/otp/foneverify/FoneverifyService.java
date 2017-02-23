package org.realx.services.verification.otp.foneverify;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.realx.core.dtos.otp.OTPObject;
import org.realx.core.dtos.otp.OTPResponse;
import org.realx.core.enums.verification.otp.OTPVerificationStatus;
import org.realx.services.resttemplate.SpringRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class FoneverifyService {
	@Resource
	private Environment environment;

	private static String OTP_GENERATOR_SYSTEM = "FONEVERIFY";
	@Autowired
	private SpringRestTemplate restTemplate;
	private static String REQUEST_ALREADY_EXISTS = "506";
	private static String ALREADY_VERIFIED = "703";
	public String SUCCESS_STATUS = "200";
	public String TRYING_FALLBACK_SMS_DELIVERED = "705";
	public String TRYING_FALLBACK_SMS_NOT_DELIVERED = "706";

	public MultiValueMap<String, String> getMultiValueMapBody() {
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("customerId", getAppConfigProperties().getProperty("otp.foneverify.customerId"));
		body.add("appid", getAppConfigProperties().getProperty("otp.foneverify.appId"));
		body.add("appKey", getAppConfigProperties().getProperty("otp.foneverify.appKey"));
		return body;
	}

	public Map<String, String> getMapBody() {
		Map<String, String> body = new HashMap<String, String>();
		body.put("customerId", getAppConfigProperties().getProperty("otp.foneverify.customerId"));
		body.put("appid", getAppConfigProperties().getProperty("otp.foneverify.appId"));
		body.put("appKey", getAppConfigProperties().getProperty("otp.foneverify.appKey"));
		return body;
	}

	public OTPObject sendOTP(String msisdn, String isoCountryCode) {
		MultiValueMap<String, String> body = getMultiValueMapBody();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		String url = getFoneverifySendOTPURL();
		body.add("isoCountryCode", isoCountryCode);
		body.add("msisdn", msisdn);
		ResponseEntity<OTPResponse> response = getRestTemplate().post(url, headers, body, OTPResponse.class);
		OTPObject otpObject = new OTPObject();
		otpObject.setSucess(false);
		otpObject.setResponseCode(OTPVerificationStatus.NOT_SENT);
		if (response.getBody() != null) {
			if (response.getBody().getResponseCode().equals(SUCCESS_STATUS)) {
				otpObject.setSucess(true);
				otpObject.setResponseCode(OTPVerificationStatus.SENT);
			} else if (response.getBody().getResponseCode().equals(REQUEST_ALREADY_EXISTS)) {
				otpObject.setResponseCode(OTPVerificationStatus.WAITING);
				otpObject.setSucess(true);
			}
			otpObject.setTimeout(response.getBody().getTimeout());
			otpObject.setContactNumber(response.getBody().getMobileNumber());
			otpObject.setVerificationId(response.getBody().getVerificationId());
			otpObject.setGenerationSystem(OTP_GENERATOR_SYSTEM);
			otpObject.setDidAssigned(response.getBody().getAssignedDID());
			otpObject.setCountryCode(isoCountryCode);
		}
		return otpObject;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @param countryCode
	 *            , Ex: 91 for India
	 * @return
	 */
	public OTPObject sendOTPProd(String phoneNumber, String countryCode) {
		MultiValueMap<String, String> body = getMultiValueMapBody();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		headers.put("customerId", getAppConfigProperties().getProperty("otp.foneverify.customerId"));
		headers.put("appid", getAppConfigProperties().getProperty("otp.foneverify.appId"));
		headers.put("appKey", getAppConfigProperties().getProperty("otp.foneverify.appKey"));

		String url = getFoneverifySendOTPURL();
		body.add("countryCode", countryCode);
		body.add("phoneNumber", phoneNumber);
		ResponseEntity<OTPResponse> response = getRestTemplate().post(url, headers, body, OTPResponse.class);
		OTPObject otpObject = new OTPObject();
		otpObject.setSucess(false);
		otpObject.setResponseCode(OTPVerificationStatus.NOT_SENT);
		if (response.getBody() != null) {
			if (response.getBody().getResponseCode().equals(SUCCESS_STATUS)) {
				otpObject.setSucess(true);
				otpObject.setResponseCode(OTPVerificationStatus.SENT);
			} else if (response.getBody().getResponseCode().equals(REQUEST_ALREADY_EXISTS)) {
				otpObject.setResponseCode(OTPVerificationStatus.WAITING);
				otpObject.setSucess(true);
			}
			otpObject.setTimeout(response.getBody().getTimeout());
			otpObject.setContactNumber(response.getBody().getMobileNumber());
			otpObject.setVerificationId(response.getBody().getVerificationId());
			otpObject.setGenerationSystem(OTP_GENERATOR_SYSTEM);
			otpObject.setDidAssigned(response.getBody().getAssignedDID());
			otpObject.setCountryCode(countryCode);
		}
		return otpObject;
	}

	public OTPObject verifyOTP(String otp, String verificationId) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		headers.put("customerId", getAppConfigProperties().getProperty("otp.foneverify.customerId"));
		headers.put("appid", getAppConfigProperties().getProperty("otp.foneverify.appId"));
		headers.put("appKey", getAppConfigProperties().getProperty("otp.foneverify.appKey"));

		Map<String, String> request = getMapBody();
		String url = getFoneverifyUpdateURL();
		request.put("verificationId", verificationId);
		request.put("code", otp);

		ResponseEntity<OTPResponse> response = getRestTemplate().getForEntity(url, OTPResponse.class, headers, request);
		OTPObject otpObject = new OTPObject();
		otpObject.setSucess(false);
		otpObject.setResponseCode(OTPVerificationStatus.NOT_VERIFIED);
		if (response.getBody() != null) {
			if (response.getBody().getResponseCode().equals(SUCCESS_STATUS)
					|| response.getBody().getResponseCode().equals(ALREADY_VERIFIED)) {
				otpObject.setSucess(true);
				otpObject.setResponseCode(OTPVerificationStatus.VERIFIED);
			} else if (response.getBody().getResponseCode().equals(TRYING_FALLBACK_SMS_DELIVERED)
					|| response.getBody().getResponseCode().equals(TRYING_FALLBACK_SMS_NOT_DELIVERED)) {
				otpObject.setResponseCode(OTPVerificationStatus.TRYING_FALLBACK_SMS_DELIVERED);
			}
			otpObject.setTimeout(response.getBody().getTimeout());
			otpObject.setContactNumber(response.getBody().getMobileNumber());
			otpObject.setVerificationId(response.getBody().getVerificationId());
			otpObject.setGenerationSystem(OTP_GENERATOR_SYSTEM);
			otpObject.setDidAssigned(response.getBody().getAssignedDID());
		}
		return otpObject;
	}

	public String getFoneverifySendOTPURL() {
		return getAppConfigProperties().getProperty("otp.foneverify.sms.sendOTPURL");
	}

	public SpringRestTemplate getRestTemplate() {
		return restTemplate;
	}

	public String getFoneverifyUpdateURL() {
		return getAppConfigProperties().getProperty("otp.foneverify.sms.verifyOTPURL");
	}

	public String getFoneverifyCallOTPURL() {
		return getAppConfigProperties().getProperty("otp.foneverify.call.dialURL");
	}

	public OTPObject OTPViaCall(String msisdn, String isoCountryCode) {
		MultiValueMap<String, String> body = getMultiValueMapBody();
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		String url = getFoneverifyCallOTPURL();
		body.add("isoCountryCode", isoCountryCode);
		body.add("msisdn", msisdn);
		ResponseEntity<OTPResponse> response = getRestTemplate().post(url, headers, body, OTPResponse.class);
		OTPObject otpObject = new OTPObject();
		otpObject.setSucess(false);
		if (response.getBody() != null) {
			if (response.getBody().getResponseCode().equals(SUCCESS_STATUS)) {
				otpObject.setSucess(true);
			} else if (response.getBody().getResponseCode().equals(REQUEST_ALREADY_EXISTS)) {
				otpObject.setResponseCode(OTPVerificationStatus.WAITING);
			}
			otpObject.setTimeout(response.getBody().getTimeout());
			otpObject.setContactNumber(response.getBody().getMobileNumber());
			otpObject.setVerificationId(response.getBody().getVerificationId());
			otpObject.setGenerationSystem(OTP_GENERATOR_SYSTEM);
			otpObject.setDidAssigned(response.getBody().getAssignedDID());
			otpObject.setCountryCode(isoCountryCode);
		}
		return otpObject;
	}

	public void setRestTemplate(SpringRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Environment getAppConfigProperties() {
		return environment;
	}
}
