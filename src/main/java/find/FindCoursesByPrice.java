package find;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindCoursesByPrice {

    public void findCheapestAndMostExpensiveCourse(@NotNull WebDriver driver)  {

        Pattern pattern = Pattern.compile("\\d{1,5}");

        List<WebElement> listOfCourses = driver.findElements(By.xpath(".//div[@class = 'lessons__new-item-container']"));

        HashMap<String, String> hm = new HashMap<>();

        for (WebElement listOfCourse : listOfCourses) {
            String title = listOfCourse.findElement(By.className("lessons__new-item-title")).getText();
            String prices = listOfCourse.findElement(By.className("lessons__new-item-price")).getText().replace(" ", "");
            hm.put(title, prices);
        }

        OptionalInt toReturnMin = hm.values().stream()
                .filter(pattern.asPredicate())
                .mapToInt(FindCoursesByPrice::applyAsInt)
                .min();

        for (
                Map.Entry<String, String> entry : hm.entrySet()) {
            if (entry.getValue().contains(String.valueOf(toReturnMin.getAsInt()))) {
                System.out.println("Самый дешевый курс: " + "\"" + entry.getKey() + "\"" + " с ценой - " + toReturnMin.getAsInt());

            }
        }

        OptionalInt toReturnMax = hm.values().stream()
                .filter(pattern.asPredicate())
                .mapToInt(FindCoursesByPrice::applyAsInt)
                .max();

        for (Map.Entry<String, String> entry : hm.entrySet()) {
            if (entry.getValue().contains(String.valueOf(toReturnMax.getAsInt()))) {
                System.out.println("Самый дорогой курс: " + "\"" + entry.getKey() + "\"" + " с ценой - " + toReturnMax.getAsInt());

            }
        }

    }

    static int applyAsInt(String str) {
        Pattern pattern = Pattern.compile("\\d{1,5}");
        Matcher matcher = pattern.matcher(str);
        matcher.find();
        return Integer.parseInt(matcher.group(0));
    }
}

