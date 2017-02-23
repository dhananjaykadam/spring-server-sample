package org.realx.core.repositories.templates;

import org.realx.core.entities.templates.EmailTemplate;
import org.realx.core.enums.email.EmailNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
	public EmailTemplate findByEmailName(EmailNameEnum emailNameEnum);
}
