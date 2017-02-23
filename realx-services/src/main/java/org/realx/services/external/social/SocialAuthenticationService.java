package org.realx.services.external.social;

import java.util.Map;

import org.realx.core.entities.social.SocialUser;
import org.realx.core.exceptions.handleradvice.BadRequestException;

public interface SocialAuthenticationService {
	public String getAccessToken(String uri, String clientId, String clientSecret);

	public SocialUser getUserInfo(String url, Map<String, ?> urlVariables,String accessToken) throws BadRequestException;
}
