package org.server.core.dtos.otp;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OTPResponse {
	private String verificationId;
	private String timeout;
	private String mobileNumber;
	private String responseCode;
	private String didAssigned;
	private String errorMessage;

	public String getAssignedDID() {
		return didAssigned;
	}

	public void setAssignedDID(String assignedDID) {
		this.didAssigned = assignedDID;
	}

	public String getDidAssigned() {
		return didAssigned;
	}

	public void setDidAssigned(String didAssigned) {
		this.didAssigned = didAssigned;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public String getTimeout() {
		return timeout;
	}

	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "OTPResponse [verificationId=" + verificationId + ", timeout=" + timeout + ", mobileNumber="
				+ mobileNumber + ", responseCode=" + responseCode + ", didAssigned=" + didAssigned + ", errorMessage="
				+ errorMessage + "]";
	}

}
