package org.server.services.dayofweek;

import java.util.Calendar;

import org.server.core.entities.other.DayOfWeek;
import org.server.core.repositories.other.DayOfWeekRepository;
import org.server.services.abstracts.DefaultJpaServiceImpl;
import org.server.services.abstracts.JpaService;
import org.springframework.stereotype.Service;

@Service
public class DayOfWeekService extends DefaultJpaServiceImpl<DayOfWeek, Long, DayOfWeekRepository>
		implements JpaService<DayOfWeek, Long> {
	/**
	 * return true if provided {@link Calendar} instance day is true under
	 * {@link DayOfWeek} instance
	 * 
	 * @param dayOfWeek
	 * @param calendar
	 * @return
	 */
	public boolean checkDayAvailable(DayOfWeek dayOfWeek, Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		return isDayAvailable(day, dayOfWeek);
	}

	/**
	 * check if provided {@link Calendar} day {@link Integer} is true under
	 * {@link DayOfWeek}
	 * 
	 * @param day
	 * @param dayOfWeek
	 * @return
	 */
	public boolean isDayAvailable(int day, DayOfWeek dayOfWeek) {
		switch (day) {
		case Calendar.SUNDAY:
			return dayOfWeek.isSunday();
		case Calendar.MONDAY:
			return dayOfWeek.isMonday();
		case Calendar.TUESDAY:
			return dayOfWeek.isTuesday();
		case Calendar.WEDNESDAY:
			return dayOfWeek.isWednesday();
		case Calendar.THURSDAY:
			return dayOfWeek.isThursday();
		case Calendar.FRIDAY:
			return dayOfWeek.isFriday();
		case Calendar.SATURDAY:
			return dayOfWeek.isSaturday();
		}
		return false;
	}
}
