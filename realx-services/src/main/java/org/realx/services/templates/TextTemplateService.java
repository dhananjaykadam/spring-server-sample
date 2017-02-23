package org.realx.services.templates;

import org.realx.core.entities.templates.TextTemplate;
import org.realx.core.repositories.templates.TextTemplateRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
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
