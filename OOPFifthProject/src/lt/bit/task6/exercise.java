package lt.bit.task6;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class exercise {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("id1", "Labas");
        map.put("id2", "Bonjour");
        map.put("id3", "Witam");


        print(map);
    }

    private static void print(TreeMap<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();

        int i = 1;
        for (Map.Entry<String, String> entry : entries) {
            if(i==1 || i == map.size()){
                System.out.println(String.format("Key:%s,Value:%s", entry.getKey(),entry.getValue()));
            }
            i++;
        }
    }
}
