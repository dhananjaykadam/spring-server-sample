package org.server.rest.resources.users;

import java.util.List;

import org.server.core.dtos.common.Entry;
import org.server.core.entities.user.User;
import org.server.core.exceptions.handleradvice.NoPermissionException;
import org.server.core.exceptions.handleradvice.NotFoundException;
import org.server.security.accessmanager.AccessManager;
import org.server.security.accessmanager.RoleManager;
import org.server.services.external.social.SocialMediaService;
import org.server.services.user.SocialUserService;
import org.server.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author {@link <a href="mailto:jaykadam90@gmail.com">Dhananjay Kadam</a>}
 *
 */
@RestController
@RequestMapping("/users")
public class UserResource {
	@Autowired
	UserService userService;
	@Autowired
	private SocialUserService userSocialAuthDetailService;
	@Autowired
	private SocialMediaService socialMediaService;
	@Autowired
	private AccessManager accessManager;
	@Autowired
	RoleManager roleManager;

	public RoleManager getRoleManager() {
		return roleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public AccessManager getAccessManager() {
		return accessManager;
	}

	public void setAccessManager(AccessManager accessManager) {
		this.accessManager = accessManager;
	}

	public SocialMediaService getSocialMediaService() {
		return socialMediaService;
	}

	public void setSocialMediaService(SocialMediaService socialMediaService) {
		this.socialMediaService = socialMediaService;
	}

	public SocialUserService getUserSocialAuthDetailService() {
		return userSocialAuthDetailService;
	}

	public void setUserSocialAuthDetailService(SocialUserService userSocialAuthDetailService) {
		this.userSocialAuthDetailService = userSocialAuthDetailService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Entry<List<User>>> users() throws Exception {
		List<User> users = getUserService().getAll(null);
		Entry<List<User>> entry = new Entry<>(users);
		if (users != null)
			return ResponseEntity.status(HttpStatus.OK).body(entry);
		throw new NotFoundException("User not found");
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public ResponseEntity<User> users(User user) throws Exception {
	// user = getUserService().create(user);
	// return ResponseEntity.status(HttpStatus.CREATED).body(user);
	// }

	@PreAuthorize("#username == authentication.principal.username or hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable String username) throws NoPermissionException {
		User user = getUserService().findByUsername(username);
		if (user == null) {
			throw new NotFoundException("User not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@RequestMapping(value = "actions/ishoteladmin", method = RequestMethod.GET)
	public ResponseEntity<Void> isHotelAdmin() throws Exception {
		User user = getUserService().getLoggedInUser();
		if (getAccessManager().hasRole(user, getRoleManager().getHotelAdminRoleName())) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
