package org.realx.core.repositories.common;

import java.util.Date;
import java.util.List;

import org.realx.core.entities.notifications.PushNotification;
import org.realx.core.enums.notifications.NotificationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NotificationRepository extends JpaRepository<PushNotification, Long> {
	
	@Query("select p from PushNotification p JOIN FETCH p.reciever r JOIN FETCH p.foodSpaceUnitReservationOrder f where p.dateTime <= ?1 And r.status =?2 And p.deletedAt is null")
	List<PushNotification> findByDateTimeIsBeforeAndRecieverStatus(Date date,NotificationStatus notificationStatus);

	
}
