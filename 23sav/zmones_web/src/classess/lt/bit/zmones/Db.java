package lt.bit.zmones;

import java.util.ArrayList;
import java.util.List;

public class Db {

    private static final List<Zmogus> list;

    static {
        list = new ArrayList();
        Zmogus z = new Zmogus("Jonas", "Jonaitis");
        z.getKontaktai().add(new Kontaktas("mob", "+37069920001"));
        z.getKontaktai().add(new Kontaktas("email", "jonas@gmail.com"));
        list.add(z);
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
        if (
                z != null &&
                        z.getVardas() != null &&
                        !"".equals(z.getVardas()) &&
                        z.getPavarde() != null &&
                        !"".equals(z.getPavarde())
        ) {
            list.add(z);
        }
    }

    public static void delete(Zmogus z) {
        list.remove(z);
    }

    public static Kontaktas getKontaktasById(int id) {
        for (Zmogus zmogus : list) {
            for (Kontaktas kontaktas : zmogus.getKontaktai()) {
                if (kontaktas != null && kontaktas.getId() == id) {
                    return kontaktas;
                }
            }
        }
        return null;
    }

    public static void deleteKontaktas(Kontaktas k) {
        if (k == null) {
            return;
        }
        for (Zmogus zmogus : list) {
            for (Kontaktas kontaktas : zmogus.getKontaktai()) {
                if (kontaktas != null && kontaktas.getId() == k.getId()) {
                    zmogus.getKontaktai().remove(kontaktas);
                    return;
                }
            }
        }
    }

    public static Zmogus getZmogusByKontaktas(Kontaktas k) {
        if (k == null) {
            return null;
        }
        for (Zmogus zmogus : list) {
            for (Kontaktas kontaktas : zmogus.getKontaktai()) {
                if (kontaktas != null && kontaktas.getId() == k.getId()) {
                    return zmogus;
                }
            }
        }
        return null;
    }
    public static void addKontaktas(Zmogus z,Kontaktas k) {
        if (
                k != null &&
                        k.getTipas() != null &&
                        !"".equals(k.getTipas()) &&
                        k.getReiksme() != null &&
                        !"".equals(k.getReiksme())
        ) {
            z.getKontaktai().add(new Kontaktas(k.getTipas(), k.getReiksme()));
        }
    }
}