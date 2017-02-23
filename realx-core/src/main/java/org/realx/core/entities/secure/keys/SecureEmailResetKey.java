package org.realx.core.entities.secure.keys;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.realx.core.entities.abstracts.VersionableEntity;
import org.realx.core.entities.user.User;
import org.realx.core.enums.secure.keys.AccountResetKeyType;

@Table
@Entity
public class SecureEmailResetKey extends VersionableEntity {

	private static final long serialVersionUID = 1L;
	@OneToOne
	private SecureKey secureKey;
	@ManyToOne
	private User user;
	@Enumerated(EnumType.STRING)
	private AccountResetKeyType emailResetKeyType;

	public SecureKey getSecureKey() {
		return secureKey;
	}

	public void setSecureKey(SecureKey secureKey) {
		this.secureKey = secureKey;
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

	public AccountResetKeyType getEmailResetKeyType() {
		return emailResetKeyType;
	}

	public void setEmailResetKeyType(AccountResetKeyType emailResetKeyType) {
		this.emailResetKeyType = emailResetKeyType;
	}

}
