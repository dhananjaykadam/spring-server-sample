package org.server.rest.resources.social;

import java.util.List;

import org.server.core.dtos.common.Entry;
import org.server.core.entities.social.SocialMediaCredential;
import org.server.core.enums.common.SocialMediaProvider;
import org.server.core.exceptions.handleradvice.NotFoundException;
import org.server.services.social.SocialLoginCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/socialmedia")
public class SocialResource {

	@Autowired
	private SocialLoginCredentialService SocialLoginCredentialService;

	@RequestMapping(value = "/providers/single/{socialMediaProvider}")
	public ResponseEntity<SocialMediaCredential> findBySocialMediaProvider(
			@PathVariable SocialMediaProvider socialMediaProvider) {
		SocialMediaCredential socialLoginCredential = getSocialLoginCredentialService()
				.findBySocialMediaProviderAndEnabled(socialMediaProvider, true);
		if (socialLoginCredential == null) {
			throw new NotFoundException("Social Media Provider not found");
		}
		return ResponseEntity.ok(socialLoginCredential);
	}

	@RequestMapping(value = "/providers/all")
	public ResponseEntity<Entry<List<SocialMediaCredential>>> findAllSocialMediaProviders() {
		List<SocialMediaCredential> socialLoginCredentials = getSocialLoginCredentialService().findAll();
		Entry<List<SocialMediaCredential>> entry = new Entry<>(socialLoginCredentials);
		return ResponseEntity.ok(entry);
	}

	public SocialLoginCredentialService getSocialLoginCredentialService() {
		return SocialLoginCredentialService;
	}

	public void setSocialLoginCredentialService(SocialLoginCredentialService socialLoginCredentialService) {
		SocialLoginCredentialService = socialLoginCredentialService;
	}

}
