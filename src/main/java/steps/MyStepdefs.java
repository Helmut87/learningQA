package steps;

import cucumber.api.Format;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import java.util.Date;
import java.util.List;

public class MyStepdefs {

    private static WebDriver driver;
    protected static Actions actions;

    @Given("^user starts browser '(.*)'")

    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return driver = new ChromeDriver();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "opera":
                WebDriverManager.operadriver().setup();
                return driver = new OperaDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

    @Then("user open main page")
    public void userOpenPageOtus() {
        driver.get("https://otus.ru");
    }


    @Then("^user find course with name '(.*)'$")
    public void userFindCourseWithNameNameOfTheCourse(String courseName) {
        driver.manage().window().maximize();
        List<WebElement> listOfCourses = driver.findElements(By.className("lessons__new-item-title"));

        WebElement correct = listOfCourses.stream()
                .filter((element) -> element.getText().contains(String.valueOf(courseName)))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(correct, "There is no Course with that name");

        actions = new Actions(driver);

        actions
                .moveToElement(correct)
                .pause(1000)
                .click()
                .perform();
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("^some date value (.*)")
    public void someDateValue(@Format("dd.MM.yyyy") Date date) {

        System.out.println(date);
    }
}
