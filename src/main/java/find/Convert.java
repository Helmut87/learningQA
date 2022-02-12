package find;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Convert {

    public String convertDate(String oldDateString) throws ParseException {

        LocalDate current_date = LocalDate.now();

        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM." + current_date.getYear(), Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        System.out.println(newDateFormat.format(date));
        return newDateFormat.format(date);


    }
}
