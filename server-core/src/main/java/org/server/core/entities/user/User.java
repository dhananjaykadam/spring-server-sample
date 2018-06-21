package org.server.core.entities.user;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.server.core.entities.abstracts.VersionableEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Entity
@Table
public class User extends VersionableEntity implements UserDetails {
	private static final long serialVersionUID = 1L;
	@Transient
	@JsonIgnore
	private Collection<GrantedAuthority> authorities;
	@NotNull
	@Column(unique = true)
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonIgnore
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean enabled;
	@JsonIgnore
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean accountNonExpired;
	@JsonIgnore
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean accountNonLocked;
	@JsonIgnore
	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean credentialsNonExpired;

	public boolean getAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean getAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
