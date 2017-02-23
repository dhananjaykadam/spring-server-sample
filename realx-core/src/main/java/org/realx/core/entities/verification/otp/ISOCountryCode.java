package org.realx.core.entities.verification.otp;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;

@Entity
@Table
public class ISOCountryCode extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	private String countryName;
	private String isoalpha2code;
	private String isoalpha3code;
	private String isonumericcode;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsoalpha2code() {
		return isoalpha2code;
	}

	public void setIsoalpha2code(String isoalpha2code) {
		this.isoalpha2code = isoalpha2code;
	}

	public String getIsoalpha3code() {
		return isoalpha3code;
	}

	public void setIsoalpha3code(String isoalpha3code) {
		this.isoalpha3code = isoalpha3code;
	}

	public String getIsonumericcode() {
		return isonumericcode;
	}

	public void setIsonumericcode(String isonumericcode) {
		this.isonumericcode = isonumericcode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
