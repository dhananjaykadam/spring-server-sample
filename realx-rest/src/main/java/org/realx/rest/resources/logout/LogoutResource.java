package org.realx.rest.resources.logout;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logout")
public class LogoutResource {
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Void> logout() {
		SecurityContextHolder.clearContext();
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
}
