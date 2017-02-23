package org.realx.core.repositories.templates;

import org.realx.core.entities.templates.TextTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextTemplateRepository extends JpaRepository<TextTemplate, Long> {

	public TextTemplate findByUniqueName(String uniqueName);

}
