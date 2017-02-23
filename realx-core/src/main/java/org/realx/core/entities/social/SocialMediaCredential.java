package org.realx.core.entities.social;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.enums.common.LoginClientType;
import org.realx.core.enums.common.SocialMediaProvider;

@Table
@Entity
public class SocialMediaCredential extends VersionableEntity {
	private static final long serialVersionUID = 1L;
	@Enumerated(EnumType.STRING)
	private SocialMediaProvider socialMediaProvider;
	@Column(columnDefinition = "TEXT")
	private String clientId;
	@Column(columnDefinition = "TEXT")
	private String clientSecret;
	@Column(columnDefinition = "TEXT")
	private String appId;
	private String scopes;
	private String authorizedRedirectURL;
	@Enumerated(EnumType.STRING)
	private LoginClientType loginClientType;
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean enabled;
	private String userDetailAPI;

	public String getUserDetailAPI() {
		return userDetailAPI;
	}

	public void setUserDetailAPI(String userDetailAPI) {
		this.userDetailAPI = userDetailAPI;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public LoginClientType getLoginClientType() {
		return loginClientType;
	}

	public void setLoginClientType(LoginClientType loginClientType) {
		this.loginClientType = loginClientType;
	}

	public String getAuthorizedRedirectURL() {
		return authorizedRedirectURL;
	}

	public void setAuthorizedRedirectURL(String authorizedRedirectURL) {
		this.authorizedRedirectURL = authorizedRedirectURL;
	}

	public String getScopes() {
		return scopes;
	}

	public void setScopes(String scopes) {
		this.scopes = scopes;
	}

	public SocialMediaProvider getSocialMediaProvider() {
		return socialMediaProvider;
	}

	public void setSocialMediaProvider(SocialMediaProvider socialMediaProvider) {
		this.socialMediaProvider = socialMediaProvider;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
