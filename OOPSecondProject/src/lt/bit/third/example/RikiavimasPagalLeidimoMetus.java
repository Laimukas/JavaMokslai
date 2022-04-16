package lt.bit.third.example;

import java.util.Comparator;

public class RikiavimasPagalLeidimoMetus implements Comparator<Knyga> {
    @Override
    public int compare(Knyga o1, Knyga o2) {
        return Integer.compare(o1.getLeidimoMetai(), o2.getLeidimoMetai()); // ASC
        // return Integer.compare(o2.getLeidimoMetai(), o1.getLeidimoMetai()); // DESC, iš didėjančio į mažėjantį
    }
}
