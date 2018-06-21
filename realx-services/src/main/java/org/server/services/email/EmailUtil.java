package org.server.services.email;

import java.io.IOException;

import javax.mail.MessagingException;

import org.server.core.entities.profile.common.Profile;
import org.server.core.entities.secure.keys.SecureEmailResetKey;
import org.server.core.entities.templates.EmailTemplate;
import org.server.core.enums.email.EmailNameEnum;
import org.server.services.secure.keys.SecureEmailResetKeyService;
import org.server.services.templates.EmailTemplateService;
import org.server.services.templates.TemplateUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.TemplateException;

@Service
public class EmailUtil {
	@Autowired
	private EmailTemplateService emailTemplateService;
	@Autowired
	private SecureEmailResetKeyService emailResetKeyService;
	@Autowired
	private TemplateUtilService templateUtilService;
	@Autowired
	private EmailService emailService;

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public TemplateUtilService getTemplateUtilService() {
		return templateUtilService;
	}

	public void setTemplateUtilService(TemplateUtilService templateUtilService) {
		this.templateUtilService = templateUtilService;
	}

	public SecureEmailResetKeyService getEmailResetKeyService() {
		return emailResetKeyService;
	}

	public void setEmailResetKeyService(SecureEmailResetKeyService emailResetKeyService) {
		this.emailResetKeyService = emailResetKeyService;
	}

	public EmailTemplateService getEmailTemplateService() {
		return emailTemplateService;
	}

	public void setEmailTemplateService(EmailTemplateService emailTemplateService) {
		this.emailTemplateService = emailTemplateService;
	}

	public boolean sendPasswordResetEmail(String email, Profile profile)
			throws IOException, TemplateException, MessagingException {
		SecureEmailResetKey secureEmailResetKey = getEmailResetKeyService().generateKeyForUserByEmail(email);
		EmailTemplate formatedTemplate = getTemplateUtilService().getPasswordResetTemplate(
				EmailNameEnum.PASSWORD_RESET_BY_EMAIL_LINK, profile, email,
				secureEmailResetKey.getSecureKey().getKeyContent());
		getEmailService().sendEmail(email, null, formatedTemplate.getSubject(),
				formatedTemplate.getTextTemplate().getContent(),
				getTemplateUtilService().isHtmlTemplate(formatedTemplate.getTextTemplate()));
		return true;
	}

}
