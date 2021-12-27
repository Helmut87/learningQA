import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertStringToDate {

    public String convertDate(String oldDateString) throws ParseException {

        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        String result = newDateFormat.format(date);
        System.out.println(result);
        return result;
    }
}
