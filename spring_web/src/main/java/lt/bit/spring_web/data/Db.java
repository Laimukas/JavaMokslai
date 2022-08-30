package lt.bit.spring_web.data;

import java.util.ArrayList;
import java.util.List;

public class Db {

    private static final List<Preke> prekes;
    
    static {
        prekes = new ArrayList();
        Preke p;
        p = new Preke("Duona", 10.0F);
        prekes.add(p);
        p = new Preke("Pienas", 5.0F);
        prekes.add(p);
    }
    
    public static List<Preke> list() {
        return prekes;
    }
    
    public static Preke getOne(Integer id) {
        if (id == null) {
            throw new NullPointerException("Prekes id privalomas");
        }
        for (Preke preke : prekes) {
            if (id.equals(preke.getId())) {
                return preke;
            }
        }
        throw new IllegalArgumentException("Preke nerasta");
    }
    
    public static Preke add(Preke p) {
        if (p == null) {
            throw new NullPointerException("Preke privaloma");
        }
        if (p.getId() == null) {
            p.assignId();
        }
        if (prekes.contains(p)) {
            throw new IllegalArgumentException("Id dubliuojasi");
        }
        prekes.add(p);
        return p;
    }
    
    public static Preke update(Preke p) {
        if (p == null) {
            throw new NullPointerException("Preke privaloma");
        }
        Preke orig = null;
        for (Preke preke : prekes) {
            if (preke.getId().equals(p.getId())) {
                orig = preke;
                break;
            }
        }
        if (orig == null) {
            throw new IllegalArgumentException("Nera prekes su tokiu id");
        }
        orig.setPavadinimas(p.getPavadinimas());
        orig.setKiekis(p.getKiekis());
        return orig;
    }
    
    public static Preke delete(Integer id) {
        if (id == null) {
            throw new NullPointerException("Prekes id privalomas");
        }
        for (Preke preke : prekes) {
            if (id.equals(preke.getId())) {
                prekes.remove(preke);
                return preke;
            }
        }
        throw new IllegalArgumentException("Preke nerasta");
    }
}
