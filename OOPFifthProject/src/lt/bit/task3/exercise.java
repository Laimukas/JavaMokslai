package lt.bit.task3;

import java.util.Map;
import java.util.Set;

public class exercise {
    public static void main(String[] args) {
        print(Map.of("Java", 18, "Python", 1, "PHP", 0));

    }

    public static void print(Map<String, Integer> map) {
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        int i = 1;
        for (Map.Entry<String, Integer> pair : entries) {
            String tekstas = "Key:%s,Value:%d%s";
            System.out.println(String.format(tekstas, pair.getKey(), pair.getValue(), i == map.size() ? "." : ","));
            i++;

        }

    }
}
