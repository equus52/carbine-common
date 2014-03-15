package equus.carbine.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateSupport {

    private static final String DATE_PATTERN = "yyyyMMdd";

    private static final long ONE_DATE_TIME_MILLIS = 1000 * 60 * 60 * 24;

    private final DateFormat dateFormat;

    public DateSupport() {
        this.dateFormat = new SimpleDateFormat(DATE_PATTERN);
    }

    public DateSupport(String datePattern) {
        checkNotNull(datePattern, "datePattern must not be null.");
        this.dateFormat = new SimpleDateFormat(datePattern);
    }

    public DateSupport(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getCurrentDate() {
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Get difference date count.
     * 
     * @param from from date
     * @param to to date
     * @return difference date count
     */
    public long getDifDate(String from, String to) {
        Date fromDate = toDate(from);
        Date toDate = toDate(to);
        return getDifDate(fromDate, toDate);
    }

    private long getDifDate(Date from, Date to) {
        long fromTime = from.getTime();
        long toTime = to.getTime();
        return (toTime - fromTime) / ONE_DATE_TIME_MILLIS;
    }

    /**
     * Add year.
     * 
     * @param date date
     * @param year year
     * @return year added date
     */
    public String addYear(String date, int year) {
        Date baseDate = toDate(date);
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(baseDate);
        calDate.add(Calendar.YEAR, year);
        return dateFormat.format(calDate.getTime());
    }

    private Date toDate(String dateString) {
        Preconditions2.checkNotEmpty(dateString);
        Date date;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("illegal format date. " + dateString, e);
        }
        return date;
    }

}
