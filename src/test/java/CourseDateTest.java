import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CourseDateTest extends BaseSetUp {

    private final String URL = "https://otus.ru";

    @Test
    public void findCourse() throws ParseException {
        ConvertStringToDate convertStringToDate = new ConvertStringToDate();
//        convertStringToDate.convertDate("15 мая 2015");

        driver.get(URL);

        List<String> allDates = new ArrayList<>();
        List<String> newDates = new ArrayList<>();

        driver.findElements(By.className("lessons__new-item-time"))
                .stream()
                .forEach(dates -> allDates.add(dates.getText()));
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
