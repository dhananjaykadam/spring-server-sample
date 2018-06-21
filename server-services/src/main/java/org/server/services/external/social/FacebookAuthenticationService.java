package org.server.services.external.social;

import java.util.Map;

import org.server.core.dtos.social.FacebookUserResponse;
import org.server.core.entities.social.SocialUser;
import org.server.core.enums.common.SocialMediaProvider;
import org.server.core.exceptions.handleradvice.BadRequestException;
import org.server.services.resttemplate.SpringRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FacebookAuthenticationService implements SocialAuthenticationService {

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
		ResponseEntity<FacebookUserResponse> responseEntity = getSpringRestTemplate()
				.getForEntity(buildUri(url, accessToken), FacebookUserResponse.class, urlVariables);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			return buildFacebookUser(responseEntity.getBody(), accessToken);
		}
		throw new BadRequestException(responseEntity.getStatusCode().toString());
	}

	private SocialUser buildFacebookUser(FacebookUserResponse facebookUserResponse, String accessToken) {
		SocialUser userSocialAuthDetail = new SocialUser();
		userSocialAuthDetail.setAccessToken(accessToken);
		userSocialAuthDetail.setEmail(facebookUserResponse.getEmail());
		userSocialAuthDetail.setFirstName(facebookUserResponse.getFirst_name());
		userSocialAuthDetail.setLastName(facebookUserResponse.getLast_name());
		userSocialAuthDetail.setPictureUrl(facebookUserResponse.getPictureUrl());
		userSocialAuthDetail.setUrl(facebookUserResponse.getLink());
		userSocialAuthDetail.setSocialMediaProvider(SocialMediaProvider.FACEBOOK);
		userSocialAuthDetail.setUserSocialId(facebookUserResponse.getId());
		return userSocialAuthDetail;
	}

	private String buildUri(String url, String accessToken) {
		return url + accessToken;
	}

}
