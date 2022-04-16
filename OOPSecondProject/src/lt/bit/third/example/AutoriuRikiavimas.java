package lt.bit.third.example;

import java.util.Comparator;

public class AutoriuRikiavimas implements Comparator<Knyga> {
    @Override
    public int compare(Knyga o1, Knyga o2) {
        return o1.getAutorius().compareTo(o2.getAutorius()); // ASC
        // iš Z į A -> o2.getAutorius().compareTo(o1.getAutorius()); DESC
    }
}
