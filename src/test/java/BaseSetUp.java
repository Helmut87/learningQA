import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSetUp {

    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static EventFiringWebDriver driver;

    @BeforeAll
    public static void setupWebDriverFactory() {
        String browser = System.getProperty("browser");
        driver = new EventFiringWebDriver(WebDriverFactory.getWebDriver(browser)).register(new BeforeClickAndAfterClickListener());
        actions = new Actions(driver);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
