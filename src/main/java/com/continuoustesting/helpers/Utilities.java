package com.continuoustesting.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilities {
    private Utilities() {
    }

    public static String currentDateTime() {
        var date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        return dateFormat.format(date);
    }
}