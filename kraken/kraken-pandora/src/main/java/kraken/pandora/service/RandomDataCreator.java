package kraken.pandora.service;

import org.apache.catalina.startup.Catalina;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

public class RandomDataCreator {

    public static void main(String[] args) throws ParseException {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) / 15 * 15);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
//        calendar.set(Calendar.HOUR_OF_DAY);
//        calendar.set(Calendar.DAY_OF_WEEK);
        calendar.getTimeInMillis();

        java.text.SimpleDateFormat simpleDateFormat
                = new java.text.SimpleDateFormat("yyyyMMddhhmmssSSS");

        calendar = Calendar.getInstance();
//        calendar.set(Calendar.DATE, 7);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        System.out.println(calendar.getTime() + " : " + calendar.get(Calendar.DAY_OF_WEEK));
    }
}
