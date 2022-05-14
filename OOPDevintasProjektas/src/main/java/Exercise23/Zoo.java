package Exercise23;

import java.util.*;
import java.util.stream.Collectors;

public class Zoo {

    private HashMap<String,Integer> animals;

    public Zoo(){
        animals=new HashMap<>();
    }

    public void addAnimals(String specy, int number){
        animals.put(specy,number);
    }

    public int getNumberOfAllAnimals(){
        int count = 0;

        for (int animalCount : animals.values()){
            count +=animalCount;
        }
        return count;
    }

    public Map<String ,Integer> getAnimalsCount(){
        return animals;
    }

    public Map<String,Integer> getAnimalsCountSorted (){

        List<Map.Entry<String,Integer>> sortedEntryList = animals.entrySet()
                .stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(),o1.getValue()))
                .collect(Collectors.toList());

        TreeMap<String,Integer> sortedMap = new TreeMap<>();

        sortedEntryList.forEach(entry -> sortedMap.put(entry.getKey(),entry.getValue()));

        return sortedMap;
    }
}
