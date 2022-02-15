import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class CourseDateTest extends BaseSetUp {

    private static final String URL = "https://otus.ru";

    @Test
    public void findCourse() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM", Locale.getDefault());

        driver.get(URL);

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
            Date date = formatter.parse(entry.getValue());
            map1.put(key, date.getTime());
        }

        Long max = map1.values()
                .stream()
                .reduce(Long::max).orElse((long) -1);

        for (Map.Entry<String, Long> entry : map1.entrySet()) {
            if (entry.getValue().toString().contains(String.valueOf(max))) {
                System.out.println("Самый поздний курс: " + entry.getKey());
            }
        }

        Long min = map1.values()
                .stream()
                .reduce(Long::min).orElse((long) -1);

        for (Map.Entry<String, Long> entry : map1.entrySet()) {
            if (entry.getValue().toString().contains(String.valueOf(min))) {
                System.out.println("Самый ранний курс: " + entry.getKey());
            }
        }
    }
}