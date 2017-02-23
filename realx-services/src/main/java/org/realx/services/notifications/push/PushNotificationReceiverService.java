package org.realx.services.notifications.push;

import java.util.List;

import org.realx.core.entities.notifications.PushNotificationGroup;
import org.realx.core.entities.notifications.PushNotificationReceiver;
import org.realx.core.entities.user.User;
import org.realx.core.enums.notifications.NotificationStatus;
import org.realx.core.repositories.notification.PushNotificationReceiverRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationReceiverService
		extends DefaultJpaServiceImpl<PushNotificationReceiver, Long, PushNotificationReceiverRepository>
		implements JpaService<PushNotificationReceiver, Long> {

	@Autowired
	private PushNotificationService pushNotificationService;

	@Autowired
	private PushNotificationReceiverRepository pushNotificationReceiverRepository;

	public PushNotificationService getPushNotificationService() {
		return pushNotificationService;
	}

	public void setPushNotificationService(PushNotificationService pushNotificationService) {
		this.pushNotificationService = pushNotificationService;
	}

	public PushNotificationReceiver addPushNotificationReceiver(User user, PushNotificationGroup group) {

		PushNotificationReceiver pushNotificationReceiver = new PushNotificationReceiver();
		pushNotificationReceiver.setIndividualReceiver(user);
		pushNotificationReceiver.setGroup(group);
		pushNotificationReceiver.setStatus(NotificationStatus.CREATED);
		pushNotificationReceiver = create(pushNotificationReceiver);
		return pushNotificationReceiver;
	}

	public List<PushNotificationReceiver> findByStatus(NotificationStatus notificationStatus) {

		return pushNotificationReceiverRepository.findByStatus(notificationStatus);
	}

}
