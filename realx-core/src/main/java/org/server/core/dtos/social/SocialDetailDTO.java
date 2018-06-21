package org.server.core.dtos.social;

import org.server.core.dtos.otp.OTPObject;
import org.server.core.enums.common.SocialMediaProvider;

public class SocialDetailDTO {
	private OTPObject otpObject;
	private String accessToken;
	private SocialMediaProvider socialMediaProvider;
	private Long timeZoneOffset;

	public Long getTimeZoneOffset() {
		return timeZoneOffset;
	}

	public void setTimeZoneOffset(Long timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public SocialMediaProvider getSocialMediaProvider() {
		return socialMediaProvider;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setSocialMediaProvider(SocialMediaProvider socialMediaProvider) {
		this.socialMediaProvider = socialMediaProvider;
	}

	public OTPObject getOtpObject() {
		return otpObject;
	}

	public void setOtpObject(OTPObject otpObject) {
		this.otpObject = otpObject;
	}

}
