package org.realx.rest.resources.profile;

import java.util.List;

import org.realx.core.dtos.common.Entry;
import org.realx.core.entities.profile.customer.CustomerProfile;
import org.realx.core.entities.user.User;
import org.realx.services.profile.customer.CustomerProfileService;
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
@RequestMapping("profiles/customers/")
public class CustomerProfileResource {

	@Autowired
	private CustomerProfileService customerProfileService;
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CustomerProfileService getCustomerProfileService() {
		return customerProfileService;
	}

	public void setCustomerProfileService(CustomerProfileService customerProfileService) {
		this.customerProfileService = customerProfileService;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<CustomerProfile> create(@RequestBody CustomerProfile profile) {
		profile = getCustomerProfileService().createNewCustomerProfile(profile);
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}

	@RequestMapping(value = "put", method = RequestMethod.PUT)
	public ResponseEntity<CustomerProfile> update(@RequestBody CustomerProfile profile) {
		profile = getCustomerProfileService().updateCustomerProfile(profile);
		return ResponseEntity.ok().body(profile);
	}

	@RequestMapping(value = "currentuser", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<CustomerProfile>>> getCurrentUserProfile() {
		List<CustomerProfile> customerProfiles = getCustomerProfileService()
				.findByProfileUser(getUserService().getLoggedInUser());
		Entry<List<CustomerProfile>> entry = new Entry<List<CustomerProfile>>();
		entry.setEntry(customerProfiles);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "username/{username}", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<CustomerProfile>>> findUserProfileByUsername(
			@PathVariable("username") String username) {
		List<CustomerProfile> profiles = getCustomerProfileService().findByUsername(username);
		Entry<List<CustomerProfile>> entry = new Entry<List<CustomerProfile>>();
		entry.setEntry(profiles);
		return ResponseEntity.ok().body(entry);
	}

	@RequestMapping(value = "user/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Entry<List<CustomerProfile>>> findUserProfileByUserId(@PathVariable("userId") Long userId) {
		User user = getUserService().findById(userId);
		List<CustomerProfile> profiles = getCustomerProfileService().findByProfileUser(user);
		Entry<List<CustomerProfile>> entry = new Entry<List<CustomerProfile>>();
		entry.setEntry(profiles);
		return ResponseEntity.ok().body(entry);
	}
}
