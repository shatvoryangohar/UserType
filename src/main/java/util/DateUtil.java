package util;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static String dateToString(Date date) {
        return sdf.format(date);
    }
public static Date stringToDate(String dateStr) throws ParseException {
        return  new Date(sdf.parse(dateStr).getTime());
}

}
