package org.server.services.templates;

import org.server.core.entities.templates.NotificationTemplate;
import org.server.core.enums.notifications.NotificationNameEnum;
import org.server.core.repositories.templates.NotificationTemplateRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationTemplateService extends DefaultJpaServiceImpl<NotificationTemplate, Long, NotificationTemplateRepository>
			implements JpaService<NotificationTemplate, Long> {

	@Autowired
	private NotificationTemplateRepository notificationTemplateRepository;
	
	public NotificationTemplateRepository getNotificationTemplateRepository() {
		return notificationTemplateRepository;
	}

	public void setNotificationTemplateRepository(NotificationTemplateRepository notificationTemplateRepository) {
		this.notificationTemplateRepository = notificationTemplateRepository;
	}

	public NotificationTemplate findByNotificationName(NotificationNameEnum meetingCancellationByHotelNotification) {
		return getNotificationTemplateRepository().findByNotificationName(meetingCancellationByHotelNotification);
	}
}
