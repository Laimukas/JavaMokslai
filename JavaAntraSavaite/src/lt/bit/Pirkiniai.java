package lt.bit;
//Mama liepė Petriukui nupirkti n pirkinių. Kiekvienas pirkinys turi savo kainą
//(centais) ir svorį (gramais). Petriukas gali panešti tik iki 5 kg. Parašykite programą, kuri
//suskaičiuotų, kiek vidutiniškai kainuoja vienas pirkinys, ir ar Petriukas galės parnešti visus
//pirkinius iš parduotuvės.

import java.util.Scanner;

public class Pirkiniai {
    public static void main(String[] args) {
        Scanner saugom = new Scanner(System.in);
           int kainuSuma=0;
        int prekiuSvoris=0;
        System.out.println("Kiek buvo pirkiniu: ");
        int pirkiniuKiekis = saugom.nextInt();
        for (int i = 1; i <= pirkiniuKiekis; i++) {
            System.out.println("Iveskite " + i + " pirkinio kaina cnt.:");
            int kaina = saugom.nextInt();
            System.out.println("Iveskite " + i + " pirkinio svori gr.:");
            int svoris = saugom.nextInt();
            kainuSuma=kainuSuma+kaina;
            prekiuSvoris=prekiuSvoris+svoris;
        }
        int vidutineKaina=kainuSuma/pirkiniuKiekis;
        int kainosDalisLitais=vidutineKaina/100;
        int kainosDalisCnt=vidutineKaina-kainosDalisLitais*100;
        if (prekiuSvoris>5000){
            System.out.println("Pirkinio vidutine kaina: "+kainosDalisLitais+" Lt "+kainosDalisCnt+" ct.");
            System.out.println("Petriukas negales parnesti pirkiniu.");
        }else{
            System.out.println("Pirkinio vidutine kaina: "+kainosDalisLitais+" Lt "+kainosDalisCnt+" ct.");
            System.out.println("Petriukas gales parnesti pirkinius.");
        }
    }
}

