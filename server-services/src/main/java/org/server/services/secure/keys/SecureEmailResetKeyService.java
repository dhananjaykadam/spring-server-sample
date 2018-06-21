package org.server.services.secure.keys;

import org.server.core.entities.profile.common.Profile;
import org.server.core.entities.secure.keys.SecureEmailResetKey;
import org.server.core.entities.secure.keys.SecureKey;
import org.server.core.entities.user.User;
import org.server.core.enums.secure.keys.AccountResetKeyType;
import org.server.core.repositories.secure.keys.SecureEmailResetKeyRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.server.services.keys.uuid.UUIDService;
import org.server.services.profile.ProfileService;
import org.server.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecureEmailResetKeyService
		extends DefaultJpaServiceImpl<SecureEmailResetKey, Long, SecureEmailResetKeyRepository>
		implements JpaService<SecureEmailResetKey, Long> {
	@Autowired
	private SecureEmailResetKeyRepository emailResetKeyRepository;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private UUIDService uuidService;
	@Autowired
	private SecureKeyService secureKeyService;
	@Autowired
	private UserService userService;

	public SecureKeyService getSecureKeyService() {
		return secureKeyService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSecureKeyService(SecureKeyService secureKeyService) {
		this.secureKeyService = secureKeyService;
	}

	public SecureEmailResetKeyRepository getEmailResetKeyRepository() {
		return emailResetKeyRepository;
	}

	public void setEmailResetKeyRepository(SecureEmailResetKeyRepository emailResetKeyRepository) {
		this.emailResetKeyRepository = emailResetKeyRepository;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public UUIDService getUuidService() {
		return uuidService;
	}

	public void setUuidService(UUIDService uuidService) {
		this.uuidService = uuidService;
	}

	public SecureEmailResetKey generateKeyForUserByUsername(String username) {
		User user = getUserService().findByUsername(username);
		SecureKey secureKey = getNewSecureKey();
		secureKey = getSecureKeyService().create(secureKey);
		SecureEmailResetKey secureEmailResetKey = getNewSecureEmailResetKey(secureKey, user,
				AccountResetKeyType.GENERATED_BY_USERNAME);
		secureEmailResetKey = this.create(secureEmailResetKey);
		return secureEmailResetKey;
	}

	public SecureEmailResetKey generateKeyForUserByEmail(String email) {
		Profile profile = getProfileService().findSingleProfileByEmail(email);
		SecureKey secureKey = getNewSecureKey();
		secureKey = getSecureKeyService().create(secureKey);
		SecureEmailResetKey secureEmailResetKey = getNewSecureEmailResetKey(secureKey, profile.getUser(),
				AccountResetKeyType.GENERATED_BY_EMAIL);
		secureEmailResetKey = this.create(secureEmailResetKey);
		return secureEmailResetKey;
	}

	private SecureKey getNewSecureKey() {
		String secureUUID = getUuidService().getNewUUIDNoDashes();
		SecureKey secureKey = new SecureKey();
		secureKey.setKeyContent(secureUUID);
		secureKey.setKeyNonExpired(true);
		return secureKey;
	}

	private SecureEmailResetKey getNewSecureEmailResetKey(SecureKey secureKey, User user,
			AccountResetKeyType emailResetKeyType) {
		SecureEmailResetKey emailResetKey = new SecureEmailResetKey();
		emailResetKey.setSecureKey(secureKey);
		emailResetKey.setEmailResetKeyType(emailResetKeyType);
		emailResetKey.setUser(user);
		return emailResetKey;
	}

	public SecureEmailResetKey findBySecureKeyAndExpire(String key) {
		SecureEmailResetKey secureEmailResetKey = getEmailResetKeyRepository()
				.findBySecureKeyKeyContentAndSecureKeyKeyNonExpired(key, true);
		if (secureEmailResetKey != null)
			getSecureKeyService().expireKey(secureEmailResetKey.getSecureKey());
		return secureEmailResetKey;
	}
}
