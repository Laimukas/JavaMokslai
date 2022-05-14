package Exercise23;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ZooTest {

    @Test
    void testAddAnimals(){
        Zoo zoo = new Zoo();
        zoo.addAnimals("Zinduolis",20);
        Map<String ,Integer> animals = zoo.getAnimalsCount();
        assertTrue(animals.keySet().contains("Zinduolis"));
        int value = animals.get("Zinduolis");
        assertEquals(20,value);
    }

    @Test
    void testCount(){
        Zoo zoo=new Zoo();
        zoo.addAnimals("Zinduolis",20);
        zoo.addAnimals("Paukstis",30);
        assertEquals(50,zoo.getNumberOfAllAnimals());
    }

    @Test
    void testOrder(){
        Zoo zoo=new Zoo();
        zoo.addAnimals("Zinduolis",20);
        zoo.addAnimals("Paukstis",30);

        Map<String,Integer> animals = zoo.getAnimalsCountSorted();
        Map.Entry<String,Integer> entry = animals.entrySet().iterator().next();

        assertEquals("Paukstis",entry.getKey());
        assertEquals(30,(int) entry.getValue());
    }

}
