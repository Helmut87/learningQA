import cucumber.api.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseDateTest {

    private final String URL = "https://otus.ru";
    private static WebDriver driver;

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

    @Test
    public void findCourseInDate() throws ParseException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        HashMap<String, String> hm = new HashMap<>();

        for (WebElement listOfCourse : listOfCourses) {
            String title = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
            String startDate = listOfCourse.findElement(By.className("lessons__new-item-time")).getText();
            hm.put(title, startDate);
        }

//        System.out.println(hm);

        hm.entrySet()
                .removeIf(entry -> entry.getValue().equals("О дате старта будет объявлено позже"));
        hm.entrySet()
                .removeIf(entry -> entry.getValue().startsWith("В"));
        hm.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяцев"));

        System.out.println(hm.values());

        if (driver != null) {
            driver.quit();
        }

    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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
