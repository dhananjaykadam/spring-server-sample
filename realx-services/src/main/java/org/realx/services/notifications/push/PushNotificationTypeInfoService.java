package org.realx.services.notifications.push;

import org.realx.core.entities.notifications.PushNotificationTypeInfo;
import org.realx.core.enums.notifications.NotificationType;
import org.realx.core.repositories.notification.PushNotificationTypeInfoRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
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
