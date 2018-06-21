package org.server.core.repositories.templates;

import org.server.core.entities.templates.NotificationTemplate;
import org.server.core.enums.notifications.NotificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {

	NotificationTemplate findByNotificationName(NotificationNameEnum meetingCancellationByHotelNotification);
	
}

