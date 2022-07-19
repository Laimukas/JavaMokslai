package lt.bit.zmones;

import java.util.ArrayList;
import java.util.List;

public class Db {

    private static final List<Zmogus> list;

    static {
        list = new ArrayList();
        list.add(new Zmogus("Jonas", "Jonaitis"));
        list.add(new Zmogus("Petras", "Petraitis"));
        list.add(new Zmogus("Antanas", "Antanaitis"));
    }

    public static List<Zmogus> getList() {
        return list;
    }

    public static Zmogus getById(int id) {
        for (Zmogus zmogus : list) {
            if (zmogus != null && zmogus.getId() == id) {
                return zmogus;
            }
        }
        return null;
    }

    public static void add(Zmogus z) {
        list.add(z);
    }

    public static void delete(Zmogus z) {
        list.remove(z);
    }
}
