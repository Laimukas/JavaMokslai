package lt.bit.exercise.ketv;

import lt.bit.exercise.antr.Masina;
import lt.bit.exercise.trec.Puodukas;
import lt.bit.exercise.trec.Termosas;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Object o = new Puodukas('z', 100);
//        Object o1 = new Masina("Subaru", 240);
//
//        o=new Masina("Volvo",220);
//
////        ((Puodukas)o).ipilk(100);
//        System.out.println(o);
////        tas pats kaip
//
//        System.out.println(o.toString());
//--------------------------------------------------------------------------------
//        Termosas t1 = new Termosas('b',1000);
//        Termosas t2 = new Termosas('b',1000);
//        Termosas t3 = new Termosas('z',5000);
//
////        if (t1 == t2){
////            System.out.println("tas pats");
////        }else{
////            System.out.println("ne tas pats");
////        }
//        //arba tas pats  , tarp kitko koregavom Termoso klase,pasikeitimai yra
//        if (t1.equals(t3)){
//            System.out.println("tas pats");
//        }else{
//            System.out.println("ne tas pats");
//        }
        //-----------------------------------------------------
//        String s1 = "labas pasauli";
//        String s2 = "labas pasauli";
//
//        if (s1 == s2) {
//            System.out.println("tokie patys");
//        } else {
//            System.out.println("ne");
//        }
        //bet jei padarysim
//        String s1 = "labas pasauli";
//        String s2 = "labas ";
//        s2=s2+"pasauli";
//
//        System.out.println(s1);
//        System.out.println(s2);
//        if (s1 == s2) {
//            System.out.println("tokie patys");
//        } else {
//            System.out.println("ne");
//        }
        //bet jei
//        String s1 = "labas pasauli";
//        String s2 = "labas ";
//        s2 = s2 + "pasauli";
//
//        System.out.println(s1);
//        System.out.println(s2);
//        if (s1.equals(s2)) {
//            System.out.println("tokie patys");
//        } else {
//            System.out.println("ne");
//        }
        //kitas Stringo metodas
//        String s1 = "labas Pasauli";//Pasauli didziaja raide
//        String s2 = "labas ";
//        s2 = s2 + "pasauli";
//
//        System.out.println(s1);
//        System.out.println(s2);
//        if (s1.equalsIgnoreCase(s2)) {
//            System.out.println("tokie patys");
//        } else {
//            System.out.println("ne");
//        }
        //-----------------------UZDUOTELE--------------------

//        Ivesti 5 studentus (vardas, pavarde, pazymiai)
//
//        vardas: Vardenis
//        pavarde: Pavardenis
//        kiek pazymiu: 3
//        1-as: 8
//        2-as: 10
//        3-as: 6
//
//        surusiuoti studentus pagal pazymiu vidurki mazejimo tvarka
//        atspausdinti surusiuota sarasa:
//        Vardenis Pavardenis (8, 10, 6)


        Scanner sc = new Scanner(System.in);
        Studentas[] studentai = new Studentas[5];
        // studentu ivedimas
        for (int i = 0; i < studentai.length; i++) {
            System.out.println((i + 1) + " Ivesk varda: ");
            String vardas = sc.nextLine();
            System.out.println((i + 1) + " Ivesk pavarde: ");
            String pavarde = sc.nextLine();
            System.out.println((i + 1) + " Ivesk kiek pazymiu: ");
            int kiekPazymiu = sc.nextInt();
            sc.nextLine();
            // vieno studento pazymiu ivedimas
            studentai[i] = new Studentas(vardas, pavarde, kiekPazymiu);
            for (int j = 0; j < studentai[i].getPazymiai().length; j++) {
                System.out.println("Ivesk " + (j + 1) + " pazymi: ");
                System.out.flush();
                studentai[i].getPazymiai()[j] = sc.nextInt();
                sc.nextLine();
            }
        }
        // rusiavimas
        for (int i = 0; i < studentai.length - 1; i++) {
            for (int j = i + 1; j < studentai.length; j++) {
                if (studentai[i].getVidurkis() < studentai[j].getVidurkis()) {
                    Studentas tmp = studentai[i];
                    studentai[i] = studentai[j];
                    studentai[j] = tmp;
                }
            }
        }
        // rezultato atspausdinimas
        for (int i = 0; i < studentai.length; i++) {
            System.out.println(studentai[i]);
        }

    }

}

