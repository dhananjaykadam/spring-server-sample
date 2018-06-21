package org.server.core.repositories.other;

import org.server.core.entities.other.DayOfWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayOfWeekRepository extends JpaRepository<DayOfWeek, Long> {

}
