package org.realx.services.help;

import java.io.IOException;

import javax.mail.MessagingException;

import org.realx.core.dtos.help.password.AccountRecoveryDTO;
import org.realx.core.entities.profile.common.Profile;
import org.realx.core.entities.secure.keys.SecureEmailResetKey;
import org.realx.core.enums.secure.keys.AccountResetKeyType;
import org.realx.services.email.EmailUtil;
import org.realx.services.profile.ProfileService;
import org.realx.services.secure.keys.SecureEmailResetKeyService;
import org.realx.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.TemplateException;

@Service
public class HelpService {
	@Autowired
	private EmailUtil emailUtil;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private SecureEmailResetKeyService emailResetKeyService;
	@Autowired
	private UserService userService;

	public boolean sendPasswordResetEmail(String email, AccountResetKeyType accountResetKeyType)
			throws IOException, TemplateException, MessagingException {
		Profile profile = getProfileService().findSingleProfileByEmail(email);
		switch (accountResetKeyType) {
		case GENERATED_BY_EMAIL:
			return getEmailUtil().sendPasswordResetEmail(email, profile);
		case GENERATED_BY_USERNAME:
			break;
		default:
			break;
		}
		return false;
	}

	public boolean resetPasswordByEmailSecretKey(AccountRecoveryDTO accountRecoveryDTO) {
		SecureEmailResetKey secureEmailResetKey = getEmailResetKeyService()
				.findBySecureKeyAndExpire(accountRecoveryDTO.getSecureKey());
		if (secureEmailResetKey != null) {
			getUserService().updatePasswd(secureEmailResetKey.getUser(), accountRecoveryDTO.getPassword());
			return true;
		}
		return false;
	}

	public EmailUtil getEmailUtil() {
		return emailUtil;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setEmailUtil(EmailUtil emailUtil) {
		this.emailUtil = emailUtil;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public SecureEmailResetKeyService getEmailResetKeyService() {
		return emailResetKeyService;
	}

	public void setEmailResetKeyService(SecureEmailResetKeyService emailResetKeyService) {
		this.emailResetKeyService = emailResetKeyService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

}
