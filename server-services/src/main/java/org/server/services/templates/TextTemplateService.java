package org.server.services.templates;

import org.server.core.entities.templates.TextTemplate;
import org.server.core.repositories.templates.TextTemplateRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextTemplateService extends DefaultJpaServiceImpl<TextTemplate, Long, TextTemplateRepository>
		implements JpaService<TextTemplate, Long> {
	@Autowired
	private TextTemplateRepository textTemplateRepository;

	public TextTemplateRepository getTextTemplateRepository() {
		return textTemplateRepository;
	}

	public void setTextTemplateRepository(TextTemplateRepository textTemplateRepository) {
		this.textTemplateRepository = textTemplateRepository;
	}

	public TextTemplate findByUniqueName(String uniqueName) {

		return getTextTemplateRepository().findByUniqueName(uniqueName);
	}

}
