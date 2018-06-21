package org.server.core.repositories.verification.otp;

import java.util.List;

import org.server.core.entities.verification.otp.ISOCountryCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISOCountryCodeRepository extends JpaRepository<ISOCountryCode, Long> {

	public List<ISOCountryCode> findByCountryName(String countryName);

	public List<ISOCountryCode> findByIsoalpha2code(String iSOAlpha2Code);

	public List<ISOCountryCode> findByIsoalpha3code(String iSOAlpha2Code);

	public List<ISOCountryCode> findByIsonumericcode(String iSONumericCode);
}
