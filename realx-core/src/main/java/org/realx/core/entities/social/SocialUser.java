package org.realx.core.entities.social;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.entities.user.User;
import org.realx.core.enums.common.SocialMediaProvider;

@Entity
@Table
public class SocialUser extends VersionableEntity {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private SocialMediaProvider socialMediaProvider;
	private String userSocialId;
	private String email;
	private String firstName;
	private String lastName;
	private String url;
	@Column(columnDefinition = "TEXT")
	private String accessToken;
	private String pictureUrl;

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SocialMediaProvider getSocialMediaProvider() {
		return socialMediaProvider;
	}

	public void setSocialMediaProvider(SocialMediaProvider socialMediaProvider) {
		this.socialMediaProvider = socialMediaProvider;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserSocialId() {
		return userSocialId;
	}

	public void setUserSocialId(String userSocialId) {
		this.userSocialId = userSocialId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
