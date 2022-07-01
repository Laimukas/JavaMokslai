package lt.bit.ketv;

import javax.swing.*;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run2 {
    public static void main(String[] args) {
        //HashMap

//        Map m = new HashMap();
//        m.put("labas", "pasauli");
//        m.put("linksmas", "gyvenimas");
//        m.put("!", ".");
//        System.out.println(m);
//        m.put("!", "pasauli");
//        System.out.println(m);
//        System.out.println(m.get("!"));
//        System.out.println(m.get("neegzistuojantis"));
//        m.put("egzistuojantis", null);
//        System.out.println(m.get("egzistuojantis"));
//        System.out.println("------");
//        System.out.println(m.containsKey("egzistuojantis"));
//        System.out.println(m.containsKey("neegzistuojantis"));
//        System.out.println(m);

//        for (Entry entry : m.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }
//        System.out.println("=========");

//        for (Object key : m.keySet()) {
//            Object value = m.get(key);
//            System.out.println(key + " = " + value);
//        }
//        m.remove("egzistuojantis");
//        System.out.println(m);





        String st = "About halfway through the production of this version, many dollar values doubled. This description focuses on the later version with the larger dollar amounts. The late 1980s version also replaced the convertibles from earlier versions with minivans. Early 1960s-era convertibles were still used in the 1978 edition. The \"Poor Farm\" was renamed \"Bankrupt!\" in which losing players would \"Retire to the country and become a philosopher\", and \"Millionaire Acres\" was shortened to \"Millionaire!\" in which the winner can \"Retire in style\". Like the 1960s version, there were spaces that forced a player to go back; in the case a player landed on one of these, they were forced to take the shortest route and pay no attention to any penalties and rewards in doing so.";
        String[] zodziai = st.split(" ");
        Map<Integer, List<String>> zi = new HashMap();
        for (String zodis : zodziai) {
            List<String> vienoIlgioZodziai = zi.get(zodis.length());
            if (vienoIlgioZodziai == null) {
                vienoIlgioZodziai = new ArrayList();
                zi.put(zodis.length(), vienoIlgioZodziai);
            }
            vienoIlgioZodziai.add(zodis);
        }
        System.out.println(zi);

    }
}
/*

sukurti klase studentas (vardas, pavarde, pazymiai)

sarasas studentu (surasom rankutem daug studentu ir ju pazymiu)

1. sudeti i Map'a, kur key yra pazimys, o value yra studentu sarasas turintis toki pazymi (sarase tas pats studentas neturi kartotis
2. sudeti i Map'a, kur key yra pazimiu kiekis, o value yra studentu sarasas turintis toki pazymiu kieki

ziureti i RunStud
 */