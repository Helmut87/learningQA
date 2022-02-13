package find;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ConvertStringToDate {

    public String convertDate(String oldDateString) throws ParseException {
        LocalDate current_date = LocalDate.now();
        SimpleDateFormat oldDateFormat = new SimpleDateFormat("dd MMMM", Locale.getDefault());
        SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM." + current_date.getYear(), Locale.getDefault());

        Date date = oldDateFormat.parse(oldDateString);
        return newDateFormat.format(date);
    }

    public static void main(String[] args) throws ParseException {
        Date nowDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        ConvertStringToDate convertStringToDate = new ConvertStringToDate();

        Map<String, String> map = new HashMap<>();
        Map<String, Date> map1 = new HashMap<>();
        map.put("Специализация QA Automation Engineer", "11 марта 10 месяцев");
        map.put("Буткемп Java", "31 марта 14 месяцев");
        map.put("Специализация Fullstack Developer", "26 января 10 месяцев");
        map.put("Специализация PHP Developer", "13 месяцев");
        map.put("Специализация Developer", "2 месяца");
        map.put("Специализация Eveloper", "1 месяц");
        map.put("Специализация Системный аналитик", "19 октября");
        map.put("Специализация Python", "07 февраля 10 месяцев");

        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяцев"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяц"));
        map.entrySet()
                .removeIf(entry -> entry.getValue().matches("^\\d{1,3}\\s\\\\?месяца"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
//            String tab = convertStringToDate.convertDate(entry.getValue());
            Date date = formatter.parse(convertStringToDate.convertDate(entry.getValue()));
//            map.put(key, tab);
            map1.put(key, date);
        }

        List<Date> od = map1.values().stream()
                .filter(date -> date.after(nowDate))
                .collect(Collectors.toList());

        for (Map.Entry<String, Date> entry : map1.entrySet()) {
            for (Date date : od) {
                if (entry.getValue().toString().equals(String.valueOf(date))) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }

        }

//        final Date maxDate = map1.values()
//                .stream()
//                .reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);
////                .min(Date::compareTo)
////                .get();
//        System.out.println(maxDate);

//        Optional<Date> o = map1.entrySet()
//                .stream()
//                .filter( e -> e.getValue().before(new Date()))
//                .map(Map.Entry::getValue)
//                        .findAny();

//
//        System.out.println(o.get());

//        int maxDate = map.values()
//                .stream()
//                .mapToInt()
//                .reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);

//        System.out.println(maxDate);

//        Optional<String> o = map.entrySet()
//                .stream()
//                .filter(e -> e.getValue().contains("31.01"))
//                .map(Map.Entry::getValue)
//                .findFirst();
//        System.out.println(o.get());

//        Map.Entry<String, String> a = map.entrySet()
////        collection.stream().reduce(Integer::max).orElse(-1)
//        .stream().reduce((s1, s2) -> s1).get();
////                .stream().min(Map.Entry.comparingByValue()).get();
//        System.out.println(a);

//
//        int maxAge = users.stream().mapToInt(User::getAge)
//                .reduce(0, (a1, a2) -> a1 > a2 ? a1 : a2);

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
