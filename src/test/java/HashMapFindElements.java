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

        Pattern pattern = Pattern.compile("\\d{1,5}");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        HashMap<String, String> hm = new HashMap<>();

        driver.manage().window().maximize();
        driver.get(URL);

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));
        for (int i = 0; i < listOfCourses.size(); i++) {
            String title = listOfCourses.get(i).findElement(By.className("lessons__new-item-title")).getText();
            String prices = listOfCourses.get(i).findElement(By.className("lessons__new-item-price")).getText();
            hm.put(title, prices);
        }

        if (driver != null) {
            driver.quit();
        }

        OptionalInt toReturn = hm.values().stream()
                .filter(pattern.asPredicate())
                .mapToInt(HashMapTest::applyAsInt)
                .max();

        System.out.println(toReturn.getAsInt());

        for (Map.Entry<String, String> entry : hm.entrySet()) {
            if (entry.getValue().contains(String.valueOf(toReturn.getAsInt()))) {
                System.out.println(entry.getKey());
            }
        }
    }

    private static int applyAsInt(String str) {
        Pattern pattern = Pattern.compile("\\d{1,4}");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return Integer.parseInt(matcher.group(0));
    }

}
