package org.realx.core.entities.address;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.realx.core.dtos.geolocation.GeolocationDTO;
import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.enums.address.AddressType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vividsolutions.jts.geom.Point;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Entity
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	private String state;
	private String country;
	private String addressNickName;
	private String city;
	private String district;
	private String region;
	private String landmark;
	private String street;
	private String addressLine1;
	private String addressLine2;
	private String postalCode;
	@ManyToOne
	private Area areaMaster;
	@ManyToOne
	private City cityMaster;
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	@JsonIgnore
	private Point geolocation;
	// Assuming that x is the latitude and y in the longitude

	@JsonProperty // Do not remove this method
	public GeolocationDTO getGeoLocation() {
		if (geolocation != null) {
			GeolocationDTO geolocationDTO = new GeolocationDTO();
			geolocationDTO.setLatitude(geolocation.getX());
			geolocationDTO.setLongitude(geolocation.getY());
			return geolocationDTO;
		}
		return null;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public City getCityMaster() {
		return cityMaster;
	}

	public void setCityMaster(City cityMaster) {
		this.cityMaster = cityMaster;
	}

	public String getState() {
		return state;
	}

	public Area getAreaMaster() {
		return areaMaster;
	}

	public void setAreaMaster(Area areaMaster) {
		this.areaMaster = areaMaster;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getDistrict() {
		return district;
	}

	public String getRegion() {
		return region;
	}

	public String getLandmark() {
		return landmark;
	}

	public String getStreet() {
		return street;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public Point getGeolocation() {
		return geolocation;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressNickName() {
		return addressNickName;
	}

	public void setAddressNickName(String addressNickName) {
		this.addressNickName = addressNickName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public void setGeolocation(Point geolocation) {
		this.geolocation = geolocation;
	}

}
