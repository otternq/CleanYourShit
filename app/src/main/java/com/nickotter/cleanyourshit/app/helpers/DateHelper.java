package com.nickotter.cleanyourshit.app.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helpful date functions
 */
public class DateHelper {

    public static SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
    public static Date d = new Date();

    public static String getCurrentDayString()
    {
        return sdf.format(d);
    }

}
