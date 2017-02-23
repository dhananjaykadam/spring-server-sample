package org.realx.services.user;

import java.util.List;

import org.realx.core.entities.profile.common.Profile;
import org.realx.core.entities.user.User;
import org.realx.core.enums.common.UserType;
import org.realx.core.exceptions.handleradvice.BadRequestException;
import org.realx.core.repositories.user.UserRepository;
import org.realx.security.authentication.SocialAuthenticationProvider;
import org.realx.security.services.SecurityManagerService;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.realx.services.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@Service
public class UserService extends DefaultJpaServiceImpl<User, Long, UserRepository>
		implements JpaService<User, Long>, UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityManagerService securityManagerService;
	@Autowired
	private SocialAuthenticationProvider socialAuthenticationProvider;
	@Autowired
	private ProfileService profileService;

	public SocialAuthenticationProvider getSocialAuthenticationProvider() {
		return socialAuthenticationProvider;
	}

	public void setSocialAuthenticationProvider(SocialAuthenticationProvider socialAuthenticationProvider) {
		this.socialAuthenticationProvider = socialAuthenticationProvider;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public SecurityManagerService getSecurityManagerService() {
		return securityManagerService;
	}

	public void setSecurityManagerService(SecurityManagerService securityManagerService) {
		this.securityManagerService = securityManagerService;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getLoggedInUser() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		User user = null;
		if (authentication != null) {
			if (authentication.getPrincipal() instanceof UserDetails)
				user = (User) authentication.getPrincipal();
		}
		return user;
	}

	@PostFilter("filterObject.username == authentication.principal.username or hasRole('ROLE_ADMIN')")
	public List<User> getAll(String type) throws Exception {
		return getUserRepository().findAll();
	}

	public User findByUsername(String key) {
		return getUserRepository().findByUsername(key);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUserRepository().findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		user.setAuthorities(getSecurityManagerService().findGrantedAuthoritiesForUser(user));
		return user;
	}

	public void authenticateUser(User user) {
		if (socialAuthenticationProvider != null) {
			List<GrantedAuthority> authorities = getSecurityManagerService().findGrantedAuthoritiesForUser(user);
			Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
			Authentication authenticated = socialAuthenticationProvider.authenticate(authentication);
			SecurityContextHolder.getContext().setAuthentication(authenticated);
		}
	}

	public User addNewUserStaffUser(User user, UserType userType) throws BadRequestException {
		user.setAuthorities(null);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		user = create(user);
		getSecurityManagerService().associateDefaultSecurityGroupToUsersByUserType(userType, user);
		return user;
	}

	public User findByEmail(String email) {
		Profile profile = getProfileService().findSingleProfileByEmail(email);
		return profile.getUser();
	}

	public User updatePasswd(User user, String passwd) {
		user.setPassword(passwd);
		user = update(user);
		return user;
	}
}
