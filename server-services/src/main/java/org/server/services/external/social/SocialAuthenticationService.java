package org.server.services.external.social;

import java.util.Map;

import org.server.core.entities.social.SocialUser;
import org.server.core.exceptions.handleradvice.BadRequestException;

public interface SocialAuthenticationService {
	public String getAccessToken(String uri, String clientId, String clientSecret);

	public SocialUser getUserInfo(String url, Map<String, ?> urlVariables,String accessToken) throws BadRequestException;
}
