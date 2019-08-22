package com.codefun.common.util;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimeUtil {

    private static String YYYY_MM_DD_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static String DD_MMM_LAYOUT_YYYY_FORMAT = "dd-MMM-yyyy";

    public static String uiDisplayDateFormat(String currentDateInString) {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_FORMAT);
        Date d = null;
        try {
            d = sdf.parse(currentDateInString);
            sdf.applyPattern(DD_MMM_LAYOUT_YYYY_FORMAT);
            return sdf.format(d);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
