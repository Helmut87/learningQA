import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapFindElements extends BaseSetUp {

    private static final String URL = "https://otus.ru";

    public static void main(String[] args) {

        HashMap<Integer, String> passportsAndNames = new HashMap<>();

        driver.manage().window().maximize();
        driver.get(URL);

        driver.findElements(By.className("lessons__new-item-time"));


        List<WebElement> listOfCourses = driver.findElements(By.className("lessons__new-item-title"));
//
//        WebElement correct = listOfCourses.stream()
//                .filter((element) -> element.getText().contains(String.valueOf(courseName)))
//                .findFirst()
//                .orElse(null);

//        HashMap<String,String> hm= new HashMap<String,String>();
//        List<WebElement> locations = driver.findElements(By.xpath("//div[@data-metadata-id='locations']//div[@data-automation-id='facetValue']"));  //get list of locations
//        for(int i=0; i<locations.size();i++) //iterate over list
//        {
//            String cities = locations.get(i).findElement(By.cssSelector("label[id*=CheckBox-locations]")).getText(); //get location name
//            String jobNumber = locations.get(i).findElement(By.cssSelector("span[id*=CountLabel-locations]")).getText().replaceAll("[^0-9]", ""); // get no. of jobs in that particular location
//            hm.put(cities, jobNumber);  // put it as key-value pair in hashmap
//
//        }
//        Set s=hm.entrySet();
//        Iterator is=s.iterator();
//        while(is.hasNext())
//        {
//            Map.Entry m= (Map.Entry)is.next();
//            System.out.println(m.getKey()+"  =>  "+m.getValue()); //get values
//        }
    }
}
