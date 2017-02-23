package org.realx.core.entities.profile.common;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.entities.images.ProfileImageInfo;
import org.realx.core.entities.profile.preferences.ProfilePreferences;
import org.realx.core.entities.user.User;
import org.realx.core.enums.profile.ProfileType;

@Entity
@Table
public class Profile extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@OneToOne
	private ContactInfo contactInfo;
	@Enumerated(EnumType.STRING)
	private ProfileType profileType;
	@OneToOne
	private User user;
	private boolean isDefault;
	@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
	private List<ProfileImageInfo> photos;
	@OneToOne
	private ProfilePreferences preferences;

	public User getUser() {
		return user;
	}

	public ProfilePreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(ProfilePreferences preferences) {
		this.preferences = preferences;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public ProfileType getProfileType() {
		return profileType;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void setProfileType(ProfileType profileType) {
		this.profileType = profileType;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public List<ProfileImageInfo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ProfileImageInfo> photos) {
		this.photos = photos;
	}

}
