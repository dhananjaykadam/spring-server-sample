package org.realx.services.notifications.push;

import org.realx.core.entities.notifications.PushNotification;
import org.realx.core.repositories.common.NotificationRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.realx.services.devices.MobileDeviceService;
import org.realx.services.profile.ProfileService;
import org.realx.services.templates.TemplateUtilService;
import org.realx.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService extends DefaultJpaServiceImpl<PushNotification, Long, NotificationRepository>
		implements JpaService<PushNotification, Long> {

	@Autowired
	private FCMNotificationService fcmNotificationService;
	@Autowired
	private MobileDeviceService mobileDeviceService;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private PushNotificationReceiverService pushNotificationReceiverService;
	@Autowired
	private PushNotificationTypeInfoService pushNotificationTypeInfoService;

	@Autowired
	private TemplateUtilService templateUtilService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private UserService userService;

	public FCMNotificationService getFcmNotificationService() {
		return fcmNotificationService;
	}

	public void setFcmNotificationService(FCMNotificationService fcmNotificationService) {
		this.fcmNotificationService = fcmNotificationService;
	}

	public MobileDeviceService getMobileDeviceService() {
		return mobileDeviceService;
	}

	public void setMobileDeviceService(MobileDeviceService mobileDeviceService) {
		this.mobileDeviceService = mobileDeviceService;
	}

	public NotificationRepository getNotificationRepository() {
		return notificationRepository;
	}

	public void setNotificationRepository(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
	}

	public PushNotificationReceiverService getPushNotificationReceiverService() {
		return pushNotificationReceiverService;
	}

	public void setPushNotificationReceiverService(PushNotificationReceiverService pushNotificationReceiverService) {
		this.pushNotificationReceiverService = pushNotificationReceiverService;
	}

	public PushNotificationTypeInfoService getPushNotificationTypeInfoService() {
		return pushNotificationTypeInfoService;
	}

	public void setPushNotificationTypeInfoService(PushNotificationTypeInfoService pushNotificationTypeInfoService) {
		this.pushNotificationTypeInfoService = pushNotificationTypeInfoService;
	}

	public TemplateUtilService getTemplateUtilService() {
		return templateUtilService;
	}

	public void setTemplateUtilService(TemplateUtilService templateUtilService) {
		this.templateUtilService = templateUtilService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// public boolean sendFCMOrderPlacedNotification(User user, String title,
	// String body, Map<String, ?> data) {
	// List<MobileDevice> mobileDevices =
	// getMobileDeviceService().findByUser(user);
	// if (mobileDevices == null || mobileDevices.isEmpty()) {
	// return false;
	// }
	// MobileDevice mobileDevice = mobileDevices.get(0);
	// FCMNotification fcmNotification = new FCMNotification();
	// fcmNotification.setTo(mobileDevice.getPushRegistrationId());
	// NotificationContent notificationContent = new NotificationContent();
	// notificationContent.setTitle(title);
	// notificationContent.setBody(body);
	// notificationContent.setSound("default");
	// notificationContent.setClick_action("");
	// // fromHtml(String)
	// fcmNotification.setNotification(notificationContent);
	//
	// fcmNotification.setData(data);
	// getFcmNotificationService().sendOrderPlacedPushNotification(fcmNotification);
	// return true;
	// }

}
