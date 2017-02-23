package org.realx.core.repositories.verification.otp;

import java.util.List;

import org.realx.core.entities.verification.otp.OTPVerification;
import org.realx.core.enums.verification.otp.OTPVerificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPVerificationRepository extends JpaRepository<OTPVerification, Long> {
	public OTPVerification findByVerificationId(String verificationId);

	@Query("select c from OTPVerification c where c.countryCode= ?2 And c.contactNumber = ?1 And c.deletedAt is null")
	public List<OTPVerification> findByContactNumberAndCountryCode(String contactNumber, String countryCode);

	@Query("select c from OTPVerification c where c.countryCode= ?2 And c.contactNumber = ?1 And verificationStatus=?3 And c.deletedAt is null")
	public List<OTPVerification> findByContactNumberAndCountryCodeAndVerificationStatus(String contactNumber,
			String countryCode, OTPVerificationStatus otpVerificationStatus);

}
