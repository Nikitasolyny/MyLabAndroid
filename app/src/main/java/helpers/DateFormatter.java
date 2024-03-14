package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    public static String formatDateString(String dateString, String format) {
        SimpleDateFormat inputFormat = new SimpleDateFormat(format, Locale.US);
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.US);

        try {
            Date date = inputFormat.parse(dateString);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
    }
}
