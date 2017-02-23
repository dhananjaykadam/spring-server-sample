package org.realx.services.templates;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.realx.core.config.freemaker.FreemakerTemplateConfig;
import org.realx.core.entities.profile.common.Profile;
import org.realx.core.entities.templates.EmailTemplate;
import org.realx.core.entities.templates.TextTemplate;
import org.realx.core.enums.email.EmailNameEnum;
import org.realx.core.enums.email.TemplateDataTypeEnum;
import org.realx.core.repositories.entitymanager.EntityManagerRepository;
import org.realx.services.email.EmailService;
import org.realx.services.profile.ProfileService;
import org.realx.services.util.datetime.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class TemplateUtilService {
	@Autowired
	private FreemakerTemplateConfig fconfig;
	@Autowired
	private EmailTemplateService emailTemplateService;
	@Autowired
	private EntityManagerRepository entityManagerRepository;
	@Autowired
	private DateTimeUtil dateTimeUtil;
	@Autowired
	private EmailService emailService;
	@Autowired
	private NotificationTemplateService NotificationTemplateService;
	@Autowired
	private ProfileService profileService;

	public EmailTemplate getPasswordResetTemplate(EmailNameEnum emailNameEnum, Profile profile, String email,
			String passwordReseKey) throws IOException, TemplateException {
		EmailTemplate passwordResetTemplate = getEmailTemplateService()
				.findByEmailName(EmailNameEnum.PASSWORD_RESET_BY_EMAIL_LINK);
		Template template = new Template(EmailNameEnum.PASSWORD_RESET_BY_EMAIL_LINK.getValue(),
				new StringReader(passwordResetTemplate.getTextTemplate().getContent()), fconfig);

		Map<String, Object> model = new HashMap<>();
		model.put("profile", profile);
		model.put("secretKey", passwordReseKey);

		Writer out = new StringWriter();
		template.process(model, out);
		passwordResetTemplate.getTextTemplate().setContent(out.toString());
		return passwordResetTemplate;
	}

//	public EmailTemplate getNoShowNotificationTemplate(EmailNameEnum emailNameEnum, Profile profile, String email,
//			FoodSpaceUnitReservationOrder foodSpaceUnitReservationOrder, SpaceProvider spaceProvider) throws IOException, TemplateException {
//
//		EmailTemplate closeOrderTemplate = getEmailTemplateService()
//				.findByEmailName(EmailNameEnum.CLOSE_ORDER_NOTIFICATION_EMAIL);
//		Template template = new Template(EmailNameEnum.CLOSE_ORDER_NOTIFICATION_EMAIL.getValue(),
//				new StringReader(closeOrderTemplate.getTextTemplate().getContent()), fconfig);
//		Map<String, Object> model = new HashMap<>();
//		model.put("profile", profile);
//		model.put("foodSpaceUnitReservationOrder", foodSpaceUnitReservationOrder);
//		model.put("spaceProvider", spaceProvider);
//		Writer out = new StringWriter();
//		template.process(model, out);
//		closeOrderTemplate.getTextTemplate().setContent(out.toString());
//		return closeOrderTemplate;
//	}
	public FreemakerTemplateConfig getFconfig() {
		return fconfig;
	}

	public void setFconfig(FreemakerTemplateConfig fconfig) {
		this.fconfig = fconfig;
	}

	public EmailTemplateService getEmailTemplateService() {
		return emailTemplateService;
	}

	public void setEmailTemplateService(EmailTemplateService emailTemplateService) {
		this.emailTemplateService = emailTemplateService;
	}

	public boolean isHtmlTemplate(TextTemplate textTemplate) {
		return (textTemplate.getTemplateDataType() == TemplateDataTypeEnum.HTML);
	}

	public EntityManagerRepository getEntityManagerRepository() {
		return entityManagerRepository;
	}

	public void setEntityManagerRepository(EntityManagerRepository entityManagerRepository) {
		this.entityManagerRepository = entityManagerRepository;
	}

	public DateTimeUtil getDateTimeUtil() {
		return dateTimeUtil;
	}

	public void setDateTimeUtil(DateTimeUtil dateTimeUtil) {
		this.dateTimeUtil = dateTimeUtil;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public NotificationTemplateService getNotificationTemplateService() {
		return NotificationTemplateService;
	}

	public void setNotificationTemplateService(NotificationTemplateService notificationTemplateService) {
		NotificationTemplateService = notificationTemplateService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

}
