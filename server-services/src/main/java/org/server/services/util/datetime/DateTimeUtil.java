package org.server.services.util.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class DateTimeUtil {
	/**
	 * Consideration that If offset is in minus that will be added to the UTC
	 * minus indicates time is ahead of UTC and positive indicates time is
	 * behind UTC(And so sign of offset will be changed)
	 * 
	 * @param timeZoneOffset
	 * @param date
	 * @return
	 */
	public Date getDateFromTimeZoneOffset(Long timeZoneOffset, Date date) {
		if (timeZoneOffset != null) {
			Date date2 = new Date();
			TimeZone timeZone = TimeZone.getDefault();
			date2.setTime(date.getTime() + (-timeZoneOffset) - timeZone.getRawOffset());
			return date2;
		}
		return date;
	}

	/**
	 * Will add days to the current date
	 * 
	 * @param days
	 * @return
	 */
	public Date getMidnightByAddingDaysToCurrentDate(int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_YEAR, days);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
}
