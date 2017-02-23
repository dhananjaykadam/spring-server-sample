package org.realx.services.external.social;

import java.util.LinkedHashMap;

import org.realx.core.entities.social.SocialMediaCredential;
import org.realx.core.entities.social.SocialUser;
import org.realx.core.enums.common.SocialMediaProvider;
import org.realx.services.social.SocialLoginCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaService {
	@Autowired
	private SocialLoginCredentialService socialLoginCredentialService;

	@Autowired
	private GoogleAuthenticationService googleAuthenticationService;
	@Autowired
	private FacebookAuthenticationService facebookAuthenticationService;
	@Autowired
	private LinkedInAuthenticationService linkedInAuthenticationService;

	public SocialLoginCredentialService getSocialLoginCredentialService() {
		return socialLoginCredentialService;
	}

	public void setGoogleAuthenticationService(GoogleAuthenticationService googleAuthenticationService) {
		this.googleAuthenticationService = googleAuthenticationService;
	}

	public void setFacebookAuthenticationService(FacebookAuthenticationService facebookAuthenticationService) {
		this.facebookAuthenticationService = facebookAuthenticationService;
	}

	public void setLinkedInAuthenticationService(LinkedInAuthenticationService linkedInAuthenticationService) {
		this.linkedInAuthenticationService = linkedInAuthenticationService;
	}

	public GoogleAuthenticationService getGoogleAuthenticationService() {
		return googleAuthenticationService;
	}

	public FacebookAuthenticationService getFacebookAuthenticationService() {
		return facebookAuthenticationService;
	}

	public LinkedInAuthenticationService getLinkedInAuthenticationService() {
		return linkedInAuthenticationService;
	}

	public SocialUser getUserInfo(String accessToken, SocialMediaProvider socialMediaProvider) {
		SocialMediaCredential socialLoginCredential = getSocialLoginCredentialService()
				.findBySocialMediaProviderAndEnabled(socialMediaProvider, true);
		if (socialLoginCredential != null) {
			LinkedHashMap<String, String> uriVariables = new LinkedHashMap<String, String>();
			switch (socialMediaProvider) {
			case FACEBOOK:
				return getFacebookAuthenticationService().getUserInfo(socialLoginCredential.getUserDetailAPI(),
						uriVariables, accessToken);
			case GOOGLE:
				return getGoogleAuthenticationService().getUserInfo(socialLoginCredential.getUserDetailAPI(),
						uriVariables, accessToken);
			case LINKEDIN:
				return getLinkedInAuthenticationService().getUserInfo(socialLoginCredential.getUserDetailAPI(),
						uriVariables, accessToken);
			case TWITTER:
				break;
			default:
				break;
			}
		}
		return null;
	}
}
