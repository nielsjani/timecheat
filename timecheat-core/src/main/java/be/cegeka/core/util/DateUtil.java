package be.cegeka.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import static java.util.Date.from;

public class DateUtil {

    private DateUtil(){}

    public static Date toDate(String date) {
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date date(int year, int month, int dayOfMonth) {
        return from(LocalDate.of(year, month, dayOfMonth).atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
