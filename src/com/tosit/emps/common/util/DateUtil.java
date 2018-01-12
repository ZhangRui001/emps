package com.tosit.emps.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月");
    private static SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @param date
     * @return
     */
    public static String FormatDate4Pattern1(Date date){
        return df1.format(date);
    }

    public static Date parseDateFromStr(String strDate){
        try {
            return df2.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
