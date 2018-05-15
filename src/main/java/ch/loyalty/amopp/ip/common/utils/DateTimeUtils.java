package ch.loyalty.amopp.ip.common.utils;

import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


/**
 * Helps convert and parse dates
 *
 * @author Denis Kuhta
 * @since JDK1.8
 */
public final class DateTimeUtils {

    /**
     * The constant SIMPLE_DATE_FORMAT.
     */
    public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DateTimeUtils() {
        /*Prevent creating instance of class!*/
    }

    /**
     * Parse simple date date.
     *
     * @param ddmmyyyy the ddmmyyyy
     * @return the date
     */
    public static Date parseSimpleDate(final String ddmmyyyy) {
        if (StringUtils.isBlank(ddmmyyyy)) {
            return null;
        }
        try {
            return SIMPLE_DATE_FORMAT.parse(ddmmyyyy);
        } catch (ParseException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Format simple date string.
     *
     * @param date the date
     * @return the string
     */
    public static String formatSimpleDate(final Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return SIMPLE_DATE_FORMAT.format(date);
    }

    public static Date setTime(final Date date, final int hour, final int minute, final int second) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar.getTime();
    }

    public static Date startOfDay(final Date date) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date endOfDay(final Date date) {
        return setTime(date, 23, 59, 59);
    }

    public static Date getYesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getTomorrow(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, +1);
        return calendar.getTime();
    }

    public static XMLGregorianCalendar getXMLGregorianCalendarNow() {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        } catch (DatatypeConfigurationException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static Date getDateUtc() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        return Date.from(utc.toInstant());
    }

    public static Date minusMinutes(final Integer minutes) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, (-1)*minutes);
        return cal.getTime();
    }
}
