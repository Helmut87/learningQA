import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

abstract class BasePage {

    protected EventFiringWebDriver driver;

    public BasePage(EventFiringWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.register(new BeforeClickAndAfterClickListener());
    }
}