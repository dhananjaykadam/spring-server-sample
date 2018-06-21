package org.server.core.entities.images;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.server.core.entities.abstracts.VersionableEntity;
import org.server.core.entities.profile.common.Profile;
import org.server.core.enums.profile.ProfileImageType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity
public class ProfileImageInfo extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Profile profile;
	private String imageId;
	@Enumerated(EnumType.STRING)
	private ProfileImageType profileImageType;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public ProfileImageType getProfileImageType() {
		return profileImageType;
	}

	public void setProfileImageType(ProfileImageType profileImageType) {
		this.profileImageType = profileImageType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
