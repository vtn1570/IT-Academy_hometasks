package by.it.voytsekhovskiy.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class CurrentDate {
    static String getCurrentDate(String language, String country) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(language, country));
        return df.format(new Date());
    }
}
