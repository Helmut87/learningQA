import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CourseDateTest extends BaseSetUp {

    private static final String URL = "https://otus.ru";
//    @Test
    public String findCourse(String oldDateString) throws ParseException {

        LocalDate current_date = LocalDate.now();
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM." + current_date.getYear(), Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        return newDateFormat.format(date);
    }

    public static void main(String[] args) throws ParseException {

        driver.get(URL);
        Date nowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        ConvertStringToDate convertStringToDate = new ConvertStringToDate();

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        Map<String, String> map = new HashMap<>();
        Map<String, Long> map1 = new HashMap<>();

        for (WebElement listOfCourse : listOfCourses) {
            String courseTitle = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
            String courseDate = listOfCourse.findElement(By.className("lessons__new-item-time")).getText();
            map.put(courseTitle, courseDate);
        }

        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяцев"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяц"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяца"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().startsWith("В"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().startsWith("О"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
//            String tab = convertStringToDate.convertDate(entry.getValue());
            Date date = formatter.parse(convertStringToDate.convertDate(entry.getValue()));
//            map.put(key, tab);
            map1.put(key, date.getTime());
        }
        System.out.println(map1);
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

//    List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));
//
//    Map<String, String> map = new HashMap<>();
//    Map<String, Date> map1 = new HashMap<>();
//
//        for (WebElement listOfCourse : listOfCourses) {
//                String courseTitle = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
//                String courseDate = listOfCourse.findElement(By.className("lessons__new-item-time")).getText();
//                map.put(courseTitle, courseDate);
//                }
//
//                map.entrySet()
//                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяцев"));
//                map.entrySet()
//                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяц"));
//                map.entrySet()
//                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяца"));
//                map.entrySet()
//                .removeIf(entry -> entry.getValue().startsWith("В"));
//                map.entrySet()
//                .removeIf(entry -> entry.getValue().startsWith("О"));
//
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//        String key = entry.getKey();
//        Date date = oldDateFormat.parse(entry.getValue());
//        map1.put(key, date);
//        }
//
//        List<Date> od = map1.values().stream()
//        .filter(d -> d.after(typedDate))
//        .collect(Collectors.toList());

//TO DO Use stream.reduce to find max/min course start date
