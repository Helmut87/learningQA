package find_courses;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FindCoursesByDate {

    public void findEarliestCourses(@NotNull WebDriver driver, String oldDateString) throws ParseException {

        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date typedDate = oldDateFormat.parse(oldDateString);

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        Map<String, String> map = new HashMap<>();
        Map<String, Date> map1 = new HashMap<>();

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
            Date date = oldDateFormat.parse(entry.getValue());
            map1.put(key, date);
        }

        List<Date> od = map1.values().stream()
                .filter(d -> d.after(typedDate))
                .collect(Collectors.toList());

        System.out.println("Курсы, стартующие после " + formatter.parse(String.valueOf(typedDate).replace("1970", "2022")));
        for (Map.Entry<String, Date> entry : map1.entrySet()) {
            for (Date date : od) {
                if (entry.getValue().toString().equals(String.valueOf(date))) {
                    System.out.println("Курс: " + "\"" + entry.getKey() + " " + "стартует " + entry.getValue().toString().replace("1970", "2022"));
                }
            }
        }
    }

    public void findCoursesByExactDate(@NotNull WebDriver driver, String exactDate) {

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        Map<String, String> map = new HashMap<>();

        for (WebElement listOfCourse : listOfCourses) {
            String courseTitle = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
            String courseDate = listOfCourse.findElement(By.className("lessons__new-item-time")).getText();
            map.put(courseTitle, courseDate);
        }
        Optional<String> o = map.entrySet()
                .stream()
                .filter(e -> e.getValue().contains(exactDate))
                .map(Map.Entry::getValue)
                .findFirst();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().contains((o.get()))) {
                System.out.println("Курс: " + "\"" + entry.getKey() + "\"" + " стартует - " + o.get());
            }
        }
    }
}
