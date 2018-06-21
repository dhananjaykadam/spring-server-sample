package org.server.services.templates;

import org.server.core.entities.templates.EmailTemplate;
import org.server.core.enums.email.EmailNameEnum;
import org.server.core.repositories.templates.EmailTemplateRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
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
