package org.upc.examination.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeFormat {
    String strFormat = null;
    Date date = null;


    public String TimeConvert(String str) {
        try {
            if(str.contains("/")) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = simpleDateFormat.parse(str);
                strFormat = simpleDateFormat2.format(date);
            }else if(str.contains("-")){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = simpleDateFormat2.parse(str);
                strFormat = simpleDateFormat.format(date);
            }

        } catch (ParseException e) {
              e.printStackTrace();
        }
        return strFormat;

    }
}
