package lt.bit.fourth.example;

import java.util.Comparator;

public class RikiavimasPagalKaina implements Comparator<Kompiuteris> {
    @Override
    public int compare(Kompiuteris o1, Kompiuteris o2) {
        return Integer.compare(o1.getKaina(), o2.getKaina());
    }
}
