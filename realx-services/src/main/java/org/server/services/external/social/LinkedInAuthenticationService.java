package org.server.services.external.social;

import java.util.Map;

import org.server.core.dtos.social.LinkedInUserResponse;
import org.server.core.entities.social.SocialUser;
import org.server.core.enums.common.SocialMediaProvider;
import org.server.core.exceptions.handleradvice.BadRequestException;
import org.server.services.resttemplate.SpringRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LinkedInAuthenticationService implements SocialAuthenticationService {

	@Autowired
	private SpringRestTemplate springRestTemplate;

	private SpringRestTemplate getSpringRestTemplate() {
		return springRestTemplate;
	}

	@Override
	public String getAccessToken(String uri, String clientId, String clientSecret) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SocialUser getUserInfo(String url, Map<String, ?> urlVariables, String accessToken)
			throws BadRequestException {
		ResponseEntity<LinkedInUserResponse> responseEntity = getSpringRestTemplate()
				.getForEntity(buildUri(url, accessToken), LinkedInUserResponse.class, urlVariables);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			return buildFacebookUser(responseEntity.getBody(), accessToken);
		}
		throw new BadRequestException(responseEntity.getStatusCode().toString());
	}

	private SocialUser buildFacebookUser(LinkedInUserResponse LinkedInUserResponse, String accessToken) {
		SocialUser userSocialAuthDetail = new SocialUser();
		userSocialAuthDetail.setAccessToken(accessToken);
		userSocialAuthDetail.setEmail(LinkedInUserResponse.getEmailAddress());
		userSocialAuthDetail.setFirstName(LinkedInUserResponse.getFirstName());
		userSocialAuthDetail.setLastName(LinkedInUserResponse.getLastName());
		userSocialAuthDetail.setPictureUrl(LinkedInUserResponse.getPictureUrl());
		userSocialAuthDetail.setUrl(LinkedInUserResponse.getPublicProfileUrl());
		userSocialAuthDetail.setSocialMediaProvider(SocialMediaProvider.LINKEDIN);
		userSocialAuthDetail.setUserSocialId(LinkedInUserResponse.getId());
		return userSocialAuthDetail;
	}

	private String buildUri(String url, String accessToken) {
		return url + accessToken;
	}

}
