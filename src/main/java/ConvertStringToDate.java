import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConvertStringToDate {

    public String convertDate(String oldDateString) throws ParseException {

        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM", Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        return newDateFormat.format(date);
    }

    public static void main(String[] args) throws ParseException {

        ConvertStringToDate convertStringToDate = new ConvertStringToDate();

        Map<String, String> map = new HashMap<>();
        map.put("Специализация QA Automation Engineer", "11 марта 10 месяцев");
        map.put("Буткемп Java", "31 марта 14 месяцев");
        map.put("Специализация Fullstack Developer", "26 января 10 месяцев");
        map.put("Специализация PHP Developer", "13 месяцев");
        map.put("Специализация Системный аналитик", "19 октября");
        map.put("Специализация Python", "25 февраля 10 месяцев");

        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяцев"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String tab = convertStringToDate.convertDate(entry.getValue());
            map.put(key, tab);
        }
        System.out.println(map.values());

//        Optional<String> o = map.entrySet()
//                .stream()
//                .filter(e -> e.getValue().contains("31.01"))
//                .map(Map.Entry::getValue)
//                .findFirst();
//        System.out.println(o.get());

        Map.Entry<String, String> a =  map.entrySet()
                .stream().min(Map.Entry.comparingByValue()).get();
        System.out.println(a);

//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            if (entry.getValue().contains(o.get())) {
//                System.out.println(o.get()+ " " + entry.getKey());
//            }
//        }
//        ordered.stream().distinct().collect(Collectors.toList());

//        Map< Date, Object> sortedMap = new TreeMap< Date, Object>(m);
// not yet sorted
//        List<String> peopleByAge = new ArrayList<>(map.values());

//        Collections.sort(peopleByAge);
//        System.out.println(peopleByAge);
//        Collections.sort(peopleByAge, Comparator.comparing(map::getAge));
//
//        for (Person p : peopleByAge) {
//            System.out.println(p.getName() + "\t" + p.getAge());
//        }
    }
}
