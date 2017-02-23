package org.realx.services.verification.otp;

import java.util.Date;
import java.util.List;

import org.realx.core.dtos.otp.OTPObject;
import org.realx.core.entities.user.User;
import org.realx.core.entities.verification.otp.ISOCountryCode;
import org.realx.core.entities.verification.otp.OTPVerification;
import org.realx.core.enums.verification.otp.OTPVerificationStatus;
import org.realx.core.repositories.verification.otp.ISOCountryCodeRepository;
import org.realx.core.repositories.verification.otp.OTPVerificationRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPDBService extends DefaultJpaServiceImpl<OTPVerification, Long, OTPVerificationRepository>
		implements JpaService<OTPVerification, Long> {
	@Autowired
	private OTPVerificationRepository oTPVerificationRepository;
	@Autowired
	private ISOCountryCodeRepository iSOCountryCodeRepository;
	@Autowired
	private OTPService oTPService;

	public OTPService getoTPService() {
		return oTPService;
	}

	public void setoTPService(OTPService oTPService) {
		this.oTPService = oTPService;
	}

	public OTPVerificationRepository getoTPVerificationRepository() {
		return oTPVerificationRepository;
	}

	public void setoTPVerificationRepository(OTPVerificationRepository oTPVerificationRepository) {
		this.oTPVerificationRepository = oTPVerificationRepository;
	}

	public ISOCountryCodeRepository getiSOCountryCodeRepository() {
		return iSOCountryCodeRepository;
	}

	public void setiSOCountryCodeRepository(ISOCountryCodeRepository iSOCountryCodeRepository) {
		this.iSOCountryCodeRepository = iSOCountryCodeRepository;
	}

	public OTPVerification mapOTPObjectToOTPVerification(OTPVerification otpVerification, OTPObject otpObject) {
		otpVerification.setContactNumber(otpObject.getContactNumber());
		otpVerification.setDate(new Date());
		otpVerification.setCountryCode(otpObject.getCountryCode());
		otpVerification.setVerificationSystem(otpObject.getGenerationSystem());
		otpVerification.setVerificationId(otpObject.getVerificationId());
		return otpVerification;
	}

	public ISOCountryCode findFirstByISONumericCode(String ISONumericCode) {
		List<ISOCountryCode> isoCountryCodes = getiSOCountryCodeRepository().findByIsonumericcode(ISONumericCode);
		if (isoCountryCodes != null && !isoCountryCodes.isEmpty()) {
			return isoCountryCodes.get(0);
		}
		return null;
	}

	public ISOCountryCode findFirstByISOAlpha2Code(String ISOAlpha2Code) {
		List<ISOCountryCode> isoCountryCodes = getiSOCountryCodeRepository().findByIsoalpha2code(ISOAlpha2Code);
		if (isoCountryCodes != null && !isoCountryCodes.isEmpty()) {
			return isoCountryCodes.get(0);
		}
		return null;
	}

	public ISOCountryCode findFirstByISOAlpha3Code(String ISOAlpha3Code) {
		List<ISOCountryCode> isoCountryCodes = getiSOCountryCodeRepository().findByIsoalpha3code(ISOAlpha3Code);
		if (isoCountryCodes != null && !isoCountryCodes.isEmpty()) {
			return isoCountryCodes.get(0);
		}
		return null;
	}

	public OTPVerification findByContactNumberAndCountryId(String contactNumber, String countryId) {
		List<OTPVerification> isoCountryCodes = null;
		isoCountryCodes = getoTPVerificationRepository().findByContactNumberAndCountryCode(contactNumber, countryId);
		if (isoCountryCodes != null && !isoCountryCodes.isEmpty()) {
			return isoCountryCodes.get(0);
		}
		return null;
	}

	public OTPVerification sendPersistOtp(String contactNumber, String countryCode, boolean isNumericCode, User user) {
		if (contactNumber != null && !contactNumber.isEmpty() && countryCode != null && !countryCode.isEmpty()) {
			ISOCountryCode iSOCountryCode = null;
			if (isNumericCode) {
				int ISONumericCode = Integer.parseInt(countryCode);
				iSOCountryCode = findFirstByISONumericCode(String.valueOf(ISONumericCode));
			} else {
				iSOCountryCode = findFirstByISOAlpha2Code(countryCode);
			}
			if (iSOCountryCode != null) {
				deleteOldRecordsByNumberAndCountryCode(contactNumber, iSOCountryCode.getIsoalpha2code());
				OTPObject otpObject = getoTPService().sendOTP(contactNumber, iSOCountryCode.getIsoalpha2code(), true);
				if (otpObject.isSucess()) {
					OTPVerification otpVerification = new OTPVerification();
					otpVerification.setUser(user);
					otpVerification = mapOTPObjectToOTPVerification(otpVerification, otpObject);
					otpVerification.setVerificationStatus(OTPVerificationStatus.SENT);
					otpVerification = update(otpVerification);
					return otpVerification;
				}
			}
		}
		return null;
	}

	public OTPVerification sendPersistOtpProd(String contactNumber, String countryCode, boolean isNumericCode,
			User user) {
		if (contactNumber != null && !contactNumber.isEmpty() && countryCode != null && !countryCode.isEmpty()) {
			deleteOldRecordsByNumberAndCountryCode(contactNumber, countryCode);
			OTPObject otpObject = getoTPService().sendOTPProd(contactNumber, countryCode, false);
			if (otpObject.isSucess()) {
				OTPVerification otpVerification = new OTPVerification();
				otpVerification.setUser(user);
				otpVerification = mapOTPObjectToOTPVerification(otpVerification, otpObject);
				otpVerification.setVerificationStatus(OTPVerificationStatus.SENT);
				otpVerification = update(otpVerification);
				return otpVerification;
			}
		}
		return null;
	}

	public OTPVerification verifyPersistOtp(String contactNumber, String countryCode, String otp,
			boolean isNumericCode) {
		if (contactNumber != null && !contactNumber.isEmpty() && countryCode != null && !countryCode.isEmpty()) {
			ISOCountryCode iSOCountryCode = null;
			if (isNumericCode) {
				int ISONumericCode = Integer.parseInt(countryCode);
				iSOCountryCode = findFirstByISONumericCode(String.valueOf(ISONumericCode));
			} else {
				iSOCountryCode = findFirstByISOAlpha2Code(countryCode);
			}
			if (iSOCountryCode != null) {
				OTPVerification otpVerification = findByContactNumberAndCountryId(contactNumber,
						iSOCountryCode.getIsoalpha2code());
				OTPObject otpObject = getoTPService().verifyOTP(otp, otpVerification.getVerificationId());
				if (otpObject.isSucess()) {
					otpVerification.setVerificationStatus(OTPVerificationStatus.VERIFIED);
					otpVerification = update(otpVerification);
					return otpVerification;
				} else if (otpObject.getResponseCode() == OTPVerificationStatus.TRYING_FALLBACK_SMS_DELIVERED) {
					otpVerification.setVerificationStatus(OTPVerificationStatus.TRYING_FALLBACK_SMS_DELIVERED);
					return otpVerification;
				}
			}
		}
		return null;
	}

	public OTPVerification verifyPersistOtpProd(String contactNumber, String countryCode, String otp,
			boolean isNumericCode) {
		if (contactNumber != null && !contactNumber.isEmpty() && countryCode != null && !countryCode.isEmpty()) {
			OTPVerification otpVerification = findByContactNumberAndCountryId(contactNumber, countryCode);
			OTPObject otpObject = getoTPService().verifyOTP(otp, otpVerification.getVerificationId());
			if (otpObject.isSucess()) {
				otpVerification.setVerificationStatus(OTPVerificationStatus.VERIFIED);
				otpVerification = update(otpVerification);
				return otpVerification;
			} else if (otpObject.getResponseCode() == OTPVerificationStatus.TRYING_FALLBACK_SMS_DELIVERED) {
				otpVerification.setVerificationStatus(OTPVerificationStatus.TRYING_FALLBACK_SMS_DELIVERED);
				return otpVerification;
			}
		}
		return null;
	}

	public boolean deleteOldRecordsByNumberAndCountryCode(String contactNumber, String alpha2code) {
		List<OTPVerification> isoCountryCodes = getoTPVerificationRepository()
				.findByContactNumberAndCountryCode(contactNumber, alpha2code);
		for (OTPVerification otpVerification : isoCountryCodes) {
			otpVerification.setDeletedAt(new Date());
			getoTPVerificationRepository().save(otpVerification);
		}
		return true;
	}

	public OTPVerification findVerificationDetailByContactNoAndStatus(String contactNo, String countryAlpha2Code,
			OTPVerificationStatus otpVerificationStatus) {
		List<OTPVerification> otpVerifications = getoTPVerificationRepository()
				.findByContactNumberAndCountryCodeAndVerificationStatus(contactNo, countryAlpha2Code,
						otpVerificationStatus);
		if (otpVerifications != null && !otpVerifications.isEmpty()) {
			return otpVerifications.get(0);
		}
		return null;
	}
}
