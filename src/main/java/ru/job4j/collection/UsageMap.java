package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("gmail@gmail.com", "Третий");
        map.put("ram@gmail.com", "Третий");
        map.put("mail@mail.ru", "Первый");
        map.put("yandex@yandex.ru", "Четвертый");
        map.put("yandex@yandex.ru", "Второй");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
