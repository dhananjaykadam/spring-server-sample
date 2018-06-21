package org.server.core.repositories.notification;

import org.server.core.entities.notifications.PushNotificationTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushNotificationTypeInfoRepository extends JpaRepository<PushNotificationTypeInfo, Long>{

}
