package lt.bit;

import java.util.Scanner;

public class EdvinoPirmaPamoka {
    public static void main(String[] args) {
        //Primityvus duomenu tipai - ju yra 8

        //skirtumas tarp ju - koks ilgis
        //Default reiksme yra 0.
        byte bytuSkaicius = 122;
        short trumpasSkaicius = 1231;
        // int skaiciai nuo -2147483648 iki 2147483647
        int a = 1002;       //dazniausia naudojama int , byte ir short dazniausia nenaudojama nes jau 21 amzius
        long ilgasSkaicius = 12312332132L;

        //Konvertavimas
        //Downcasting ir uppercasting
        //is aukstesnio tipo lengvai galim keist i zemesni
        int kazkoksSkaicius = bytuSkaicius;
        //is zemesnio i aukstesni reik apsirasyt taip
        int darKazkoksSkaicius = (int) ilgasSkaicius;



        //default -> 0.0
        //skaiciai su kableliu
        double b = 132.24;
        float d = 123.34F;

        //false default reiksme
        //loginis kintamasis (true arba false)
        boolean c = true;

        //cia gali priimti ASCI Code
        char simbolis = 'x';

        //jei final tai galutinis, jo pakeist nebus galima
        final int galutinisSkaicius = 123;

        //Matematines operacijos
        // + - * / %
        int suma = 5 + 2;
        int atimti = 6 - 3;
        int daugyba = 4 * 10;
        int dalyba = 100 / 20;
        int modulus = 7 % 2; //liekana, cia is 7 dalinam po 2 ir liekana gaunasi 1


        //----------   konvertavimas
        /*
        int skaiciusPoKonvertavimo = (int) b; //cia lieka tik sveikoji dalis,nesvarbu kas buvo po kablelio
        // konvertuojant galima uzsiraut nes reik jei konvertuojat didelius skaicius ir int gali paduot klaidinga reiksme nes int turi remus
        System.out.println("Skaicius po konvertavimo: " +skaiciusPoKonvertavimo);
*/
        //------ increament and decreament
        /*
        int randomSkaicius = ++suma; //cia didinam vienetu
        int kitasRandomSkaicius = suma--; //cia sumazinam vienetu

        System.out.println(randomSkaicius++);
        System.out.println(randomSkaicius);
        System.out.println(++randomSkaicius);
        System.out.println(kitasRandomSkaicius);
*/
        //paprasta uzduotele dnb darbinantis jiuniorui
        //duotas masyvas is kurio reik rasti antra is eiles einamas skaicius
        //(152, 312, 265, 845 , 521);

        //----------- salyginiai sakiniai
       // if(5>=10){

      //  }
        /*
        Scanner manoScanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu:");
        int ivestasSkaicius = manoScanner.nextInt();

        if (ivestasSkaicius>0){
            System.out.println("Skaicius yra didesnis uz 0");
        }else if (ivestasSkaicius<0) {
            System.out.println("Skaicius yra mazesnis uz 0");
        }else{
            System.out.println("Skaicius yra 0");
        }
*/
        // reik nepamirst jog negerai naudot kelis if iskart,reik naudot ir else

        // ---------  Switch
        /*
        Scanner manoScanner = new Scanner(System.in);
        System.out.println("Iveskite menesio pavadinima");
        String menesioPavadinimas = manoScanner.next();
        switch (menesioPavadinimas){*/
           /* case "Sausis":
                System.out.println("Ziema");
                break;
            case "Vasaris":
                System.out.println("Ziema");
                break;
            case "Kovas":
                System.out.println("Pavasaris");
                break;
            default:
                System.out.println("Nesupratau, koks menuo?");*/
                //galima aprasyti ir taip
        /*
            case "Sausis", "Vasaris" ->  System.out.println("Ziema");
            case "Kovas"-> System.out.println("Pavasaris");
            default->  System.out.println("Nesupratau, koks menuo?");
            */

        //-------- String
        // default reiksme -> null
/*
        String tekstas = "Mano tekstas";
        String tekstas1 = "Mano tekstas";
        String tekstas2 = new String("Mano tekstas") ;
        System.out.println(tekstas.toUpperCase());

        //reik atsargiau su juo nes jei reiksme null,pastrigt gali.Pasitikrinant apsirasyt geriau taip
        String manoKitasTekstas = null;
        if (manoKitasTekstas !=null){
            System.out.println(manoKitasTekstas.concat(manoKitasTekstas));
        }
        System.out.println(tekstas == tekstas1);
        System.out.println(tekstas == tekstas2);
        //visiems metodams naudojame equals metoda
        System.out.println(tekstas.equals(tekstas2));

 */
        //stringo modifikuot negalima,tad (immutable)
        /*
        String manoTekstas = "labukas";
        manoTekstas.toUpperCase();
        System.out.println(manoTekstas);
        System.out.println(manoTekstas.toUpperCase());
        //bet jei priskirsim reiksme,tada keisis String
        manoTekstas = manoTekstas.toUpperCase();
        System.out.println(manoTekstas);
         */

        //---------- Ciklai -------------
        // --- For -> inicilizuoja kintamaji 1 karta, tikrina salyga kiekviena karta, vykdo komanda, padidina vienu ir t.t.
        /*for (int i=0; i<5; i++) {
            System.out.println("*");
        }*/
        // pvz
        /*
        for(int i=1;i<=10;i++){
            if(i%2==0){
                System.out.println("Skaicius "+ i +" yra lyginis");
            }else{
                System.out.println("Skaicius "+ i +" yra nelyginis");
            }
        }
*/

        // --- While

       // int manoSkaicius = 0;
       /* while (manoSkaicius<100){
            System.out.println(manoSkaicius);
            manoSkaicius++;
        }*/

        // ------ do While
/*
        do{
            System.out.println(manoSkaicius);
            manoSkaicius++;
        }while (manoSkaicius<100);
*/
        // ----begalinis ciklas-----------gali nusprogt kompas
        /*
        while (true){
            System.out.println("hello");
        }*/

        // ------- statinis masyvas
        //masyvas prasideda nuo 0. Indeksas nuo 0
        //
        /*
        int [] skaiciai = new int[10];
        skaiciai[0]=12;
        skaiciai[1]=13;
        skaiciai[2]=14;
        skaiciai[3]=15;
        skaiciai[4]=16;
        skaiciai[5]=17;
        skaiciai[6]=18;
        skaiciai[7]=19;
        skaiciai[8]=222;*/
     /*   System.out.println(skaiciai[5]);
        // ilgis yra lygus tiek kiek esam apsirase elementu
        int [] skaicia1 = {10,5,23};
        //masyvo paskutinis indeksas yra = masyvo ilgis -1
        for (int i=0;i<skaiciai.length;i++){
            System.out.println("Skaicius indekse : " +i+ " yra: " +skaiciai[i]);
        }
*/
        //CTRL + ALT + L -> formatavimas
/*
        String [] pasisveikinimai = new String[4];
        pasisveikinimai[0]="Labas";
        pasisveikinimai[1]="Czesc";
        pasisveikinimai[2]="Hello";
        pasisveikinimai[3]="Bonjour";

        //for each
        for (String pasisveikinimas : pasisveikinimai){
            System.out.println(pasisveikinimas);
        }
        for (int skaicius : skaiciai){
            System.out.println("Skaicius: "+skaicius);
        }*/
        int skaiciuSuma = suma(10,20);

        skaiciuSuma = suma(1, 2, 3, 4, 5);
        skaiciuSuma = suma(1, 2, 3);

        int[] skaiciuMasyvas = {1, 2, 3, 4};
        skaiciuSuma = sumaIsMasyvo(skaiciuMasyvas);

        dalyba = divide(10, 0);

        String[] kandidatoKompetencijos = {"Komandiskumas", "Programavimas", "Duomenu bazes"};
        int siulomaAlga = 0;

//        if(arTuriKompetencija("Komandiskumas", kandidatoKompetencijos)) {
//            siulomaAlga = 1200;
//        } else {
//            siulomaAlga = 500;
//        }

        // -------- Ternory operation
        siulomaAlga = arTuriKompetencija("Komandiskumas", kandidatoKompetencijos) ? 1200 : 500;

        int randomNumber = 123123 < 1301 ? 12312 : 123123 > 234324 ? 234123 : 123123;
    }

    private static boolean arTuriKompetencija(String ieskomaKompetencija, String[] kandidatoKompetencijos) {
        for (String kompetencija : kandidatoKompetencijos) {
            if (kompetencija.equals(ieskomaKompetencija)){
                return true;
            }
        }

        return false;
    }

    // void - čia tiesiog grąžinimo tipas, kuris negrąžina nieko.
    public static void pasisveikink() {
        System.out.println("Hello");
    }

    public static int suma(int a, int b) {
        return a + b;
    }

    // varargs
    public static int suma(int... skaiciai) {
        int suma = 0;
        for (int skaicius : skaiciai) {
            suma += skaicius;
        }
        return suma;
    }

    public static int sumaIsMasyvo(int[] skaiciai) {
        int suma = 0;
        for (int skaicius : skaiciai) {
            suma += skaicius;
        }

        return suma;
    }

    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Įvyko klaida, nes : " + e.getMessage());
        }

        return 0;
    }
}
