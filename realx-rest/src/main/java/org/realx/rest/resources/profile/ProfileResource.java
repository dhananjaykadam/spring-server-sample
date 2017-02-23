package org.realx.rest.resources.profile;

import java.util.List;

import org.realx.core.dtos.common.Entry;
import org.realx.core.entities.profile.common.Profile;
import org.realx.services.profile.ProfileService;
import org.realx.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profiles")
public class ProfileResource {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<Profile> create(@RequestBody Profile profile) {
		profile = getProfileService().createNewProfile(profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}

	@RequestMapping(value = "put", method = RequestMethod.PUT)
	public ResponseEntity<Profile> update(@RequestBody Profile profile) {
		profile = getProfileService().updateProfile(profile);
		return ResponseEntity.ok().body(profile);
	}

	@RequestMapping(value = "currentuser", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<Profile>>> getCurrentUserProfile() {
		List<Profile> profiles = getProfileService().findByUserId(getUserService().getLoggedInUser().getId());
		Entry<List<Profile>> entry = new Entry<List<Profile>>();
		entry.setEntry(profiles);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<Profile>>> findUserProfileByUsername(@PathVariable("username") String username) {
		List<Profile> profiles = getProfileService().findProfileByUsername(username);
		Entry<List<Profile>> entry = new Entry<List<Profile>>();
		entry.setEntry(profiles);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<Profile>>> findUserProfileByUserId(@PathVariable("userId") Long userId) {
		List<Profile> profiles = getProfileService().findByUserId(userId);
		Entry<List<Profile>> entry = new Entry<List<Profile>>();
		entry.setEntry(profiles);
		return ResponseEntity.ok().body(entry);
	}
}
