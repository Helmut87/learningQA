import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashMapFindElements {

    private static final String URL = "https://otus.ru/online/";
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

        Pattern pattern = Pattern.compile("\\d{1,5}");

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        HashMap<String, String> hm = new HashMap<>();

        for (WebElement listOfCourse : listOfCourses) {
            String title = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
            String prices = listOfCourse.findElement(By.className("lessons__new-item-price")).getText().replace(" ", "");
            hm.put(title, prices);
        }

        System.out.println(hm.values());

        OptionalInt toReturn = hm.values().stream()
                .filter(pattern.asPredicate())
                .mapToInt(HashMapFindElements::applyAsInt)
                .min();

        System.out.println(toReturn.getAsInt());

        for (Map.Entry<String, String> entry : hm.entrySet()) {
            if (entry.getValue().contains(String.valueOf(toReturn.getAsInt()))) {
                System.out.println("Курс: " + entry.getKey() + " с ценой - " + toReturn.getAsInt());

            }
        }

        if (driver != null) {
            driver.quit();
        }
    }

     static int applyAsInt(String str) {
        Pattern pattern = Pattern.compile("\\d{1,5}");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return Integer.parseInt(matcher.group(0));
    }

}
