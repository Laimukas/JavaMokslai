package lt.bit.ketv;

import java.util.*;

public class RunStud {


    public static void main(String[] args) {

        Studentas s1 = new Studentas("Jonas", "Jonaitis", 5, 4, 7, 6, 9, 8);
        Studentas s2 = new Studentas("Petras", "Petraitis", 9, 8, 7, 6, 5, 4);
        Studentas s3 = new Studentas("Arnas", "Arnaitis", 3, 6, 5, 4);
        Studentas s4 = new Studentas("Vytas", "Vytaitis", 3, 2, 1);
        Studentas s5 = new Studentas("Simas", "Simaitis", 9, 9, 9, 9, 9, 9);
        Studentas s6 = new Studentas("Laimis", "Laimauskas", 6, 5, 4, 3, 2, 1);
        Studentas s7 = new Studentas("Tomas", "Tomauskas", 8, 6, 3, 5, 4, 7, 8, 9, 6);
        Studentas s8 = new Studentas("Lukas", "Lukauskas", 1, 2, 3, 4, 5);
        Studentas s9 = new Studentas("Andrius", "Andriauskas", 10, 9);
        Studentas s10 = new Studentas("Vaidas", "Vaidauskas", 8, 6, 4, 8);

        List<Studentas> studentai = new ArrayList<>();
        studentai.add(s1);
        studentai.add(s2);
        studentai.add(s3);
        studentai.add(s4);
        studentai.add(s5);
        studentai.add(s6);
        studentai.add(s7);
        studentai.add(s8);
        studentai.add(s9);
        studentai.add(s10);

        System.out.println(studentai);
        System.out.println("---------------------------");

//---- 2 ----sudeti i Map'a, kur key yra pazimiu kiekis, o value yra studentu sarasas turintis toki pazymiu kieki

        Map<Integer, List<Studentas>> pk = new HashMap(); //sitas pazymiu kiekiui

        for (Studentas studentas : studentai) {
            List<Studentas> studentaiTurintysPazymiuKieki = pk.get(studentas.getPazymiai().size());
            if (studentaiTurintysPazymiuKieki == null) {
                studentaiTurintysPazymiuKieki = new ArrayList();
                pk.put(studentas.getPazymiai().size(), studentaiTurintysPazymiuKieki);
            }
            studentaiTurintysPazymiuKieki.add(studentas);
        }
        System.out.println("2: Budas kai sudedam i Map'a, kur key yra pazimiu kiekis, o value yra studentu sarasas turintis toki pazymiu kieki");
        System.out.println(pk);
        System.out.println("-------------------------------");

        //----1----sudeti i Map'a, kur key yra pazimys, o value yra studentu sarasas turintis toki pazymi (sarase tas pats studentas neturi kartotis
//        System.out.println(studentai.get(1));

        Map<Integer, List<Studentas>> ps = new HashMap<>();   //sitas pazymiams
        Set<Integer> pazymys = new HashSet<Integer>();
        for (int i = 0; i < studentai.size(); i++) {
            int j;
            for (j = 0; j < studentai.get(i).getPazymiai().size(); j++) {
                pazymys.add(studentai.get(i).getPazymiai().get(j));
                List<Studentas> studentaiTurintysPazymi = ps.get(studentai.get(i).getPazymiai().get(j));
                if (studentaiTurintysPazymi == null) {
                    studentaiTurintysPazymi = new ArrayList();
                    ps.put(studentai.get(i).getPazymiai().get(j), studentaiTurintysPazymi);
                }
                studentaiTurintysPazymi.add(studentai.get(i));
            }
        }
        System.out.println("Gavau pazymiu sarasa is visu studentu :)");
        System.out.println(pazymys);
        System.out.println("-----------------------------------------");
        System.out.println("1: Budas kai sudedam i Map'a, kur key yra pazymys, o value yra studentu sarasas turintis toki pazymi (sarase tas pats studentas neturi kartotis");
        System.out.println(ps);
    }
}
/*

sukurti klase studentas (vardas, pavarde, pazymiai)                                                                  DONE

sarasas studentu (surasom rankutem daug studentu ir ju pazymiu)                                                      DONE

1. sudeti i Map'a, kur key yra pazimys, o value yra studentu sarasas turintis toki pazymi (sarase tas pats studentas neturi kartotis
2. sudeti i Map'a, kur key yra pazimiu kiekis, o value yra studentu sarasas turintis toki pazymiu kieki              DONE

ziureti i RunStud klase
 */