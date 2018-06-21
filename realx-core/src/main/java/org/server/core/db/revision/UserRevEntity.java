package org.server.core.db.revision;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.server.core.entities.user.User;

@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity extends DefaultRevisionEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	private User user;
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}