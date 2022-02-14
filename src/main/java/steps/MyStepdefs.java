package steps;

import cucumber.api.Format;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import find_courses.FindCoursesByDate;
import find_courses.FindCoursesByName;
import find_courses.FindCoursesByPrice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import settings.EndPoints;
import settings.WebDriverFactory;

import java.text.ParseException;


public class MyStepdefs {
    private static WebDriver driver;
    protected static Actions actions;


    @Given("^user starts browser '(.*)'")
    public void getBrowserName(String browserName) {
        driver = WebDriverFactory.getWebDriver(browserName);
    }

    @Then("user open main page")
    public void userOpenPageOtus() {
        driver.get(EndPoints.mainpage);
    }

    @Then("^user find course with name '(.*)'$")
    public void userFindCourseWithNameNameOfTheCourse(String courseName) {
        new FindCoursesByName().findCourseWithNameNameOfTheCourse(driver, courseName);
    }

    @Then("user find course, witch start after (.*)")
    public void someDateValue(@Format("dd MMMM") String oldDateString) throws ParseException {
        new FindCoursesByDate().findEarliestCourses(driver, oldDateString);
    }

    @Then("user find course, witch start in (.*)")
    public void exactDateValue(@Format("dd MMMM") String exactDate) {
        new FindCoursesByDate().findCoursesByExactDate(driver, exactDate);
    }

    @Then("user open preparatory courses")
    public void userOpenPreparatoryCourses() {
        driver.get(EndPoints.preparatory_courses);
    }

    @Then("^user find the most expensive and the cheapest course$")
    public void userFindTheMostExpensiveAndTheCheapestCourse() {
        new FindCoursesByPrice().findCheapestAndMostExpensiveCourse(driver);
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

