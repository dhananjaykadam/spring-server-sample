package org.server.services.notifications.push;

import java.util.List;

import org.server.core.entities.notifications.PushNotificationGroup;
import org.server.core.entities.notifications.PushNotificationReceiver;
import org.server.core.entities.user.User;
import org.server.core.enums.notifications.NotificationStatus;
import org.server.core.repositories.notification.PushNotificationReceiverRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
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
