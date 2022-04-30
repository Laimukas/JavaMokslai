package lt.bit;

import java.util.*;

public class RaidziuRikiavimas {
    public static void main(String[] args) {
        ArrayList<String> listas = new ArrayList<>(List.of("a", "g", "d", "h", "t", "v", "z", "k", "l"));

        System.out.println(listas);

        System.out.println(grazintiSortinta(listas));
    }
//    public static List<String> grazintiSortinta(List<String>x){
//        Collections.sort(x,((o1,o2)->o2.compareTo(o1)));
//        return x;
//    }

    //arba

    public static List<String> grazintiSortinta(ArrayList<String> x) {
        //bubble sort
        for (int i = 0; i < x.size(); i++) {
            for (int j = i + 1; j < x.size(); j++) {

                String raide = x.get(i);
                String sekantiRaide = x.get(j);

                if (raide.charAt(0) < sekantiRaide.charAt(0)) {
                    x.remove(i);
                    x.add(i, sekantiRaide);
                    x.remove(j);
                    x.add(j, raide);
                }
            }
        }
        return x;
    }
}
