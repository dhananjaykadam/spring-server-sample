package org.realx.services.templates;

import org.realx.core.entities.templates.NotificationTemplate;
import org.realx.core.enums.notifications.NotificationNameEnum;
import org.realx.core.repositories.templates.NotificationTemplateRepository;
import org.realx.services.abstracts.DefaultJpaServiceImpl;
import org.realx.services.abstracts.JpaService;
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
