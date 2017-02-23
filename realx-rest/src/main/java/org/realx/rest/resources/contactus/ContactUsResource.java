package org.realx.rest.resources.contactus;

import org.realx.core.entities.contactus.RegistrationRequest;
import org.realx.services.contactus.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("contactus")
public class ContactUsResource {
	@Autowired
	private RegistrationRequestService registrationRequestService;

	public RegistrationRequestService getRegistrationRequestService() {
		return registrationRequestService;
	}

	public void setRegistrationRequestService(RegistrationRequestService registrationRequestService) {
		this.registrationRequestService = registrationRequestService;
	}

	@RequestMapping(value = "registration-requests", method = RequestMethod.POST)
	public ResponseEntity<RegistrationRequest> addRegistrationRequests(
			@RequestBody RegistrationRequest registrationRequest) {
		registrationRequest = getRegistrationRequestService().create(registrationRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(registrationRequest);
	}
}
