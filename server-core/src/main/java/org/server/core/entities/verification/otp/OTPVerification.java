package org.server.core.entities.verification.otp;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.user.User;
import org.server.core.enums.verification.otp.OTPVerificationStatus;
import org.server.core.enums.verification.otp.VerificationType;

@Entity
@Table
public class OTPVerification extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	private User user;
	private String verificationId;
	@Enumerated(EnumType.STRING)
	private OTPVerificationStatus verificationStatus;
	private String contactNumber;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String verificationSystem;
	private String countryCode;
	@Enumerated(EnumType.STRING)
	private VerificationType verificationType;

	public User getUser() {
		return user;
	}

	public VerificationType getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(VerificationType verificationType) {
		this.verificationType = verificationType;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVerificationId() {
		return verificationId;
	}

	public void setVerificationId(String verificationId) {
		this.verificationId = verificationId;
	}

	public OTPVerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(OTPVerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVerificationSystem() {
		return verificationSystem;
	}

	public void setVerificationSystem(String verificationSystem) {
		this.verificationSystem = verificationSystem;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
