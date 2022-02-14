package find_courses;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FindCoursesByName {
    public void findCourseWithNameNameOfTheCourse(@NotNull WebDriver driver, String courseName){

        driver.manage().window().maximize();
        List<WebElement> listOfCourses = driver.findElements(By.className("lessons__new-item-title"));

        WebElement correct = listOfCourses.stream()
                .filter((element) -> element.getText().contains(String.valueOf(courseName)))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(correct, "There is no Course with that name");

        Actions actions = new Actions(driver);

        actions
                .moveToElement(correct)
                .pause(1000)
                .click()
                .perform();
    }
}
