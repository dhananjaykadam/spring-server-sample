package org.server.rest.resources.login;

import org.server.core.dtos.social.SocialDetailDTO;
import org.server.core.entities.social.SocialUser;
import org.server.core.entities.user.User;
import org.server.core.exceptions.handleradvice.BadRequestException;
import org.server.services.user.SocialUserService;
import org.server.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "login")
public class LoginResource {
	@Autowired
	private UserService userService;
	@Autowired
	private SocialUserService socialUserService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public SocialUserService getSocialUserService() {
		return socialUserService;
	}

	public void setSocialUserService(SocialUserService socialUserService) {
		this.socialUserService = socialUserService;
	}

	@RequestMapping(value = "customers")
	public ResponseEntity<User> customers() {
		User user = getUserService().getLoggedInUser();
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@RequestMapping(value = "providers")
	public ResponseEntity<User> providers() {
		User user = getUserService().getLoggedInUser();
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@RequestMapping(value = "social")
	public ResponseEntity<SocialUser> createSocialUser(@RequestBody SocialDetailDTO socialDetailDTO) {
		SocialUser socialUser = getSocialUserService().trySocialUserLogin(socialDetailDTO);
		if (socialUser != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(socialUser);
		}
		throw new BadRequestException("Incorrect OTP");
	}

	@RequestMapping(value = "social/silent")
	public ResponseEntity<SocialUser> socialSilentLogin(@RequestBody SocialDetailDTO socialDetailDTO) {
		SocialUser socialUser = getSocialUserService().trySocialUserSilentLogin(socialDetailDTO);
		if (socialUser != null) {
			return ResponseEntity.ok().body(socialUser);
		}
		throw new BadRequestException("User not found Or Not Verified yet!");
	}
}
