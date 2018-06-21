package org.server.services.notifications.push;

import org.server.core.entities.notifications.PushNotificationTypeInfo;
import org.server.core.enums.notifications.NotificationType;
import org.server.core.repositories.notification.PushNotificationTypeInfoRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationTypeInfoService
		extends DefaultJpaServiceImpl<PushNotificationTypeInfo, Long, PushNotificationTypeInfoRepository>
		implements JpaService<PushNotificationTypeInfo, Long> {

	public PushNotificationTypeInfo addPushNotificationTypeInfo(NotificationType notificationType) {
		PushNotificationTypeInfo pushNotificationTypeInfo = new PushNotificationTypeInfo();
		pushNotificationTypeInfo.setNotificationType(notificationType);
		pushNotificationTypeInfo = create(pushNotificationTypeInfo);
		return pushNotificationTypeInfo;
	}

}
