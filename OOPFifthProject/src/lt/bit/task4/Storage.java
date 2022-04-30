package lt.bit.task4;

import com.sun.source.tree.IfTree;

import java.lang.reflect.Array;
import java.util.*;

public class Storage {

    private Map<String, ArrayList<String>> map;

    public Storage() {
        map = new HashMap<>();

    }

    public void addToStorage(String key, String value) {
        ArrayList<String> values;
        if (map.get(key) != null) {
            values = map.get(key);
            values.add(value);
        } else {
            values = new ArrayList<>(List.of(value));
        }
        map.put(key, values);
    }

    public void printValues(String key) {
        ArrayList<String> values = map.get(key);
        values.forEach(value -> System.out.println(value));
    }

    public void findValues(String value) {

        Set<Map.Entry<String, ArrayList<String>>> entrySet = map.entrySet();

        for (Map.Entry<String, ArrayList<String>> entry : entrySet) {
            ArrayList<String> values = entry.getValue();

            for (String element : values) {
                if (element == value) {
                    System.out.println(entry.getKey());
                }
            }
        }

//kitas varijantas

//        map.forEach((k, v) -> {
//            if (v.contains(value)) {
//                System.out.println(k);
//            }
//        });
    }
}
