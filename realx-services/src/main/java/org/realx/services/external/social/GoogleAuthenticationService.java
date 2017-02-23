package org.realx.services.external.social;

import java.util.Map;

import org.realx.core.dtos.social.GoogleUserResponse;
import org.realx.core.entities.social.SocialUser;
import org.realx.core.enums.common.SocialMediaProvider;
import org.realx.core.exceptions.handleradvice.BadRequestException;
import org.realx.services.resttemplate.SpringRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthenticationService implements SocialAuthenticationService {
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
		ResponseEntity<GoogleUserResponse> responseEntity = getSpringRestTemplate()
				.getForEntity(buildUri(url, accessToken), GoogleUserResponse.class, urlVariables);
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			return buildGoogleUser(responseEntity.getBody(), accessToken);
		}
		throw new BadRequestException(responseEntity.getStatusCode().toString());
	}

	private SocialUser buildGoogleUser(GoogleUserResponse googleUserResponse, String accessToken) {
		SocialUser userSocialAuthDetail = new SocialUser();
		userSocialAuthDetail.setAccessToken(accessToken);
		userSocialAuthDetail.setEmail(googleUserResponse.getEmail());
		userSocialAuthDetail.setFirstName(googleUserResponse.getGiven_name());
		userSocialAuthDetail.setLastName(googleUserResponse.getFamily_name());
		userSocialAuthDetail.setPictureUrl(googleUserResponse.getPicture());
		userSocialAuthDetail.setUrl(googleUserResponse.getLink());
		userSocialAuthDetail.setSocialMediaProvider(SocialMediaProvider.GOOGLE);
		userSocialAuthDetail.setUserSocialId(googleUserResponse.getSub());
		return userSocialAuthDetail;
	}

	private String buildUri(String url, String accessToken) {
		return url + accessToken;
	}
}
