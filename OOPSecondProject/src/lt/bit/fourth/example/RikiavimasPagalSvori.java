package lt.bit.fourth.example;

import java.util.Comparator;

public class RikiavimasPagalSvori implements Comparator<Kompiuteris> {
    @Override
    public int compare(Kompiuteris o1, Kompiuteris o2) {
        return Integer.compare(o1.getSvoris(), o2.getSvoris());
    }
}
