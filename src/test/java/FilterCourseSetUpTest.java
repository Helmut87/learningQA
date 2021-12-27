import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterCourseSetUpTest extends BaseSetUp {

    private final String URL = "https://otus.ru";

    @ParameterizedTest
    @EnumSource(CoursesList.class)
    void filterExistCoursesTest(CoursesList coursesList) throws InterruptedException {

        driver.get(URL);

        List<WebElement> listOfCourses = driver.findElements(By.className("lessons__new-item-title"));

        WebElement correct = listOfCourses.stream()
                .filter((element) -> element.getText().contains(String.valueOf(coursesList)))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(correct, "There is no Course with that name");

        actions
                .moveToElement(correct)
                .pause(1000)
                .perform();

        JavascriptExecutor jsExecutor = driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:3px solid red')", correct);
        Thread.sleep(2000);
    }
}
