import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CourseDateTest extends BaseSetUp {

    private static final String URL = "https://otus.ru";

    @Test
    public String findCourse(String oldDateString) throws ParseException {

        LocalDate current_date = LocalDate.now();
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM." + current_date.getYear(), Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        return newDateFormat.format(date);
    }

    public static void main(String[] args) {

        driver.get(URL);
        Date nowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        ConvertStringToDate convertStringToDate = new ConvertStringToDate();

        Map<String, String> map = new HashMap<>();
        Map<String, Date> map1 = new HashMap<>();

        driver.findElements(By.className("lessons__new-item-time"));

    }
}


//        allDates.removeIf(s -> s.equals("О дате старта будет объявлено позже"));
//        allDates.removeIf(x -> x.startsWith("В"));
//
//        Stream<String> stringStream = stringList.stream();
//        String coolest = stringStream.reduce((a,b)->
//                coolnessIndex(a) > coolnessIndex(b) ? a:b;).get()
//
//

//TO DO Use stream.reduce to find max/min course start date
