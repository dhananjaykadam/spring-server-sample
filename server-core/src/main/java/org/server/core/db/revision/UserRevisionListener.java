package org.server.core.db.revision;

import org.hibernate.envers.RevisionListener;
import org.server.core.entities.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		UserRevEntity entity = (UserRevEntity) revisionEntity;
		final SecurityContext ctx = SecurityContextHolder.getContext();
		if (ctx != null) {
			final Authentication auth = ctx.getAuthentication();
			if (auth != null) {
				final Object obj = auth.getPrincipal();
				if (obj != null && obj instanceof User) {
					final User user = (User) auth.getPrincipal();
					entity.setUser(user);
				} else if (obj instanceof String) {
					entity.setUsername((String) auth.getPrincipal());
				}
			}
		}
	}
}