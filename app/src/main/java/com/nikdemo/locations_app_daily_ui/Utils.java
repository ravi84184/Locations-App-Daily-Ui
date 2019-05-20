package com.nikdemo.locations_app_daily_ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String changeDatePattern(String date,String outputDatePattern){
        String returnDate = "";
        String inputDatePattern = "dd/MM/yyyy";
        if (outputDatePattern.equals("")){
            throw new IllegalArgumentException("Output Pattern is empty");
        }

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputDatePattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputDatePattern);
        Date date1 = null;
        try {
            date1 = inputFormat.parse(date);
            returnDate = outputFormat.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
        return returnDate;
    }
}
