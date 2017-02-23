package org.realx.services.templates;

import org.realx.core.entities.templates.EmailTemplate;
import org.realx.core.enums.email.EmailNameEnum;
import org.realx.core.repositories.templates.EmailTemplateRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailTemplateService extends DefaultJpaServiceImpl<EmailTemplate, Long, EmailTemplateRepository>
		implements JpaService<EmailTemplate, Long> {
	@Autowired
	private EmailTemplateRepository emailTemplateRepository;

	public EmailTemplateRepository getEmailTemplateRepository() {
		return emailTemplateRepository;
	}

	public void setEmailTemplateRepository(EmailTemplateRepository emailTemplateRepository) {
		this.emailTemplateRepository = emailTemplateRepository;
	}

	public EmailTemplate findByEmailName(EmailNameEnum emailNameEnum) {
		return getEmailTemplateRepository().findByEmailName(emailNameEnum);
	}
}
