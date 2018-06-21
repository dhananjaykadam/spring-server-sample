package org.server.core.repositories.notification;

import java.util.List;

import org.server.core.entities.notifications.PushNotificationReceiver;
import org.server.core.enums.notifications.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushNotificationReceiverRepository extends JpaRepository<PushNotificationReceiver, Long>{

	List<PushNotificationReceiver> findByStatus(NotificationStatus notificationStatus);

}
