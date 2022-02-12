import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import settings.BasePage;

public class MainPage extends BasePage {

    @FindBy(xpath = ".//div[contains(@class, 'lessons__new-item-container')]")
    WebElement listOfCourses;

    @FindBy(xpath = "//div[contains(@class, 'lessons__new-item-title')]")
    WebElement lessonsTitle;
    
    public MainPage(WebDriver driver) {
        super(driver);
    }
}
