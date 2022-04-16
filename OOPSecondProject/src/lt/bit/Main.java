package lt.bit;

import lt.bit.first.example.Cat;
import lt.bit.second.example.Studentas;
import lt.bit.second.example.Universitetas;
import lt.bit.third.example.Knyga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        //      Cat cat = new Cat();
        //     cat.sayGreetings();

        Studentas pirmasStudentas = new Studentas("st1", 2, "Adresas", "LT12345");
        Studentas antrasStudentas = new Studentas("st2", 3, "Adresas2", "LT53435");
        Studentas treciasStudentas = new Studentas("st3", 4, "Adresas3", "LT86787");

        ArrayList<Studentas> studentai = new ArrayList<>();
        studentai.add(pirmasStudentas);
        studentai.add(antrasStudentas);
        studentai.add(treciasStudentas);

        Universitetas universitetas =
                new Universitetas("uni1", "Adresas4", "+37065", studentai);
        ArrayList<Studentas> universitetoStudentai = universitetas.getStudentai();
        //keli budai atprintint studentu sarasus
        //-----------1----------
        /*
        for (int i=0;i< universitetoStudentai.size();i++){
            System.out.println(universitetoStudentai.get(i));
        }*/
        //-----------2-----------
        //sita geriau moket,nes jis daugiausia naudojamas tarp dirbanciu programuotoju

        for (Studentas universitetoStudentas : universitetoStudentai) {
            System.out.println(universitetoStudentas);
        }
        //-----------3-----------
        //cia jau pazengusiem ir tokio nebutina moket
        /*
        universitetoStudentai.forEach(studentas -> System.out.println(studentas));
         */
        //********** Naujiena *********
        // HashSet -> Saugomos tik unikalios reiksmes. Nepamatysit tokiu paciu elementu cia.

        int[] skaiciai = {10, 10, 23, 23123, 123, 324, 10, 23, 324};
        //norim gaut lista be dublikatu
        HashSet<Integer> skaiciaiBeDublikato = new HashSet<>();
        /*
        for (int skaicius : skaiciai){
            if (skaiciaiBeDublikato.add(skaicius)){
                System.out.println("Yey, pridejom i HashSeta: "+skaicius);
            }else{
                System.out.println("Rastas dublikatas: "+skaicius);
            }

        }
        for (Integer skaicius : skaiciaiBeDublikato){
            System.out.println(skaicius);
        }*/
        //arba maziau rasliavos kad butu like
        /*
        for (int skaicius : skaiciai) {
            skaiciaiBeDublikato.add(skaicius);

        }
        for (Integer skaicius : skaiciaiBeDublikato) {
            System.out.println(skaicius);
        }
        */

        //******* Naujiena **********
        // HashMap -> key - unikalus, value - neunikalus,keiciamas

        HashMap<String,Studentas> studentoInformacija = new HashMap<>();
        studentoInformacija.put("39516461564", pirmasStudentas);
        studentoInformacija.put("16516161661", antrasStudentas);

        System.out.println("Asmens kodas: 39516461564, informacija: " +studentoInformacija.get("39516461564"));



    }
}

