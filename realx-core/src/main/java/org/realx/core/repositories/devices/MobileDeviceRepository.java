package org.realx.core.repositories.devices;

import java.util.Date;
import java.util.List;

import org.realx.core.entities.devices.MobileDevice;
import org.realx.core.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MobileDeviceRepository extends JpaRepository<MobileDevice, Long> {
	@Transactional
	@Modifying
	@Query("Update MobileDevice m SET m.deletedAt = ?2 WHERE m.user = ?1")
	public void removeOldMobileDetail(User user, Date deleteDate);

	@Query("select c from MobileDevice c where c.user = ?1 And c.deletedAt is null")
	public List<MobileDevice> getActiveDeviceIdForUser(User user);

	public List<MobileDevice> findByUser(User user);
}
