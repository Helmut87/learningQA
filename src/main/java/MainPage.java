import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'container container-lessons')]//a[contains(@href, '/promo/specializacija-fullstack-dev/')]")
    WebElement courseFullStackDeveloperMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'container container-lessons')]//a[contains(@href, '/promo/qa-auto-java-specialization/')]")
    WebElement courseQaAutoJavaMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'container container-lessons')]//a[contains(@href, '/promo/ml-specialization/')]")
    WebElement courseMlMenuItem;

    @FindBy(xpath = "//div[contains(@class, 'container container-lessons')]//a[contains(@href, ' /promo/spec-data-engineer/')]")
    WebElement courseDataEngeneerMenuItem;

    public MainPage(EventFiringWebDriver driver) {
        super(driver);
    }
}
