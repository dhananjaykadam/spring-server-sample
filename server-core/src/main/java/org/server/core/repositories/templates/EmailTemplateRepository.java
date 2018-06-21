package org.server.core.repositories.templates;

import org.server.core.entities.templates.EmailTemplate;
import org.server.core.enums.email.EmailNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long> {
	public EmailTemplate findByEmailName(EmailNameEnum emailNameEnum);
}
