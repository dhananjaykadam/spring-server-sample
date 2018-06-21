package org.server.rest.resources.help;

import java.io.IOException;

import javax.mail.MessagingException;

import org.server.core.dtos.help.password.AccountRecoveryDTO;
import org.server.core.dtos.social.SocialDetailDTO;
import org.server.core.entities.social.SocialUser;
import org.server.core.enums.secure.keys.AccountResetKeyType;
import org.server.core.exceptions.handleradvice.BadRequestException;
import org.server.services.help.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import freemarker.template.TemplateException;

@RestController
@RequestMapping("help")
public class HelpResource {
	@Autowired
	private HelpService helpService;

	@RequestMapping(value = "passwords/reset", method = RequestMethod.POST)
	public ResponseEntity<SocialUser> passwordReset(@RequestBody SocialDetailDTO socialDetailDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@RequestMapping(value = "passwords/create", method = RequestMethod.POST)
	public ResponseEntity<SocialUser> newPassword(@RequestBody SocialDetailDTO socialDetailDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@RequestMapping(value = "passwords/recover/initiate/email", method = RequestMethod.POST)
	public ResponseEntity<Void> generateSecureKeyByEmail(@RequestBody AccountRecoveryDTO accountRecoveryDTO)
			throws IOException, TemplateException, MessagingException {
		getHelpService().sendPasswordResetEmail(accountRecoveryDTO.getEmail(), AccountResetKeyType.GENERATED_BY_EMAIL);
		return ResponseEntity.ok().build();
	}
 
	@RequestMapping(value = "passwords/recover/reset/email/secretkey", method = RequestMethod.POST)
	public ResponseEntity<Void> resetPasswordByEmailSecretKey(@RequestBody AccountRecoveryDTO accountRecoveryDTO)
			throws IOException, TemplateException, MessagingException {
		boolean response = getHelpService().resetPasswordByEmailSecretKey(accountRecoveryDTO);
		if (response == false) {
			throw new BadRequestException("Incomplete data");
		}
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "passwords/recover/initiate/username", method = RequestMethod.POST)
	public ResponseEntity<Void> generateSecureKeyByUsername(@RequestBody AccountRecoveryDTO accountRecoveryDTO)
			throws IOException, TemplateException, MessagingException {
		getHelpService().sendPasswordResetEmail(accountRecoveryDTO.getEmail(),
				AccountResetKeyType.GENERATED_BY_USERNAME);
		return ResponseEntity.ok().build();
	}

	public HelpService getHelpService() {
		return helpService;
	}

	public void setHelpService(HelpService helpService) {
		this.helpService = helpService;
	}

}
