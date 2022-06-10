package exercise.ketv;

import java.util.Arrays;

public class main {
    public static int skaiciuSuma (int from, int till) {
        int sum = 0;
        for (int i = from; i <= till; i++) {
            sum += i;
        }
        return sum;
    }
    public static void spausdinamSkaicius (int nuo, int iki){
        while (nuo <= iki){
            System.out.println(nuo++);
        }
    }
    public static void atsitiktinisGrazintasSkaiciusIsReziu (int nuo,int iki){
        int atsitiktinis=0;
        int skaicius = (int) (Math.random()*(iki+1))+nuo;
         atsitiktinis=skaicius-nuo;
            System.out.println(atsitiktinis);

    }
    public static long atsitiktinis(int nuo, int iki) {
        if (nuo > iki) {
            int tmp = nuo;
            nuo = iki;
            iki = tmp;
        }
        return (int) (Math.random() * (iki - nuo + 1) + nuo);
    }

    public static void main(String[] args) {
// **************-------------------metodas apskaiciuojantis skaiciu esanciu reziuose suma(aprasyta pries main)
//        int nuo = 5;
//        int iki = 7;
//
//        System.out.println(skaiciuSuma(nuo, iki));
//
//        nuo = 15;
//        iki = 5416;
//        System.out.println(skaiciuSuma(nuo, iki));
//
//        nuo = 452;
//        iki = 48966;
//        System.out.println(skaiciuSuma(nuo, iki));
//
//        System.out.println(skaiciuSuma(6, 15648));
//
//        System.out.println(skaiciuSuma(1,10));
//
//        int s = skaiciuSuma(1,10)+skaiciuSuma(100,200);
//        System.out.println(s);
        // ***********----------------metodas kuris spausdina skaicius esancius nurodytuose reziuose(aprasyta pries main)
//
//        spausdinamSkaicius(1,10);

        //****************------------metodas, kuris grazina atsitiktini sveika skaiciu is nurodyto rezio
//t.y. 10-153 gali grazinti 10, 11, 12, ..., 152, 153

//atsitiktinisGrazintasSkaiciusIsReziu(15,153);
// Aliaus varijantas
//        System.out.println(atsitiktinis(65,23));
        //*************--------Masyvai-------------------
//        int[] masyvas = {11,12,33,45,56};
//        masyvas[0]=25;
//        masyvas[2]=56;
////        System.out.println(masyvas[0]);
////        System.out.println(masyvas[1]);
////        System.out.println(masyvas[2]);
////        System.out.println(masyvas[3]);
////        System.out.println(masyvas[4]);
////        System.out.println(masyvas.length);
//        //arba
//        for (int i=0;i<masyvas.length;i++){
//            System.out.println(masyvas[i]);
//        }
        //*************------Uzduotis
        //  int[] masyvas = {4, 81, 321, 44, 1, 87, 22};
//surusiuoti masyva didejimo tvarka ir atspausdinti
//        int[] masyvas = {4, 81, 321, 44, 1, 87, 22};

//        sortArray(masyvas, masyvas.length);
//        for(int i = 0; i <masyvas.length; i++)
//        {
//            System.out.println(masyvas[i]);
//        }
//    }
//
//    private static void sortArray(int[] array, int n) {
//
//        for (int i = 1; i < n; i++)
//        {
//            int j = i;
//            int a = array[i];
//            while ((j > 0) && (array[j-1] > a))   //returns true when both conditions are true
//            {
//                array[j] = array[j-1];
//                j--;
//            }
//            array[j] = a;
//        }
        //Aliaus varijantas

//        int[] masyvas = {4, 321, 44, 1};
//
//        for (int i = 0; i < masyvas.length - 1; i++) {
//            for (int j = i + 1; j < masyvas.length; j++) {
//                if (masyvas[i] > masyvas[j]) {
//                    int tmp = masyvas[i];
//                    masyvas[i] = masyvas[j];
//                    masyvas[j] = tmp;
//                }
//            }
//        }
//
//        for (int i = 0; i < masyvas.length; i++) {
//            System.out.println(masyvas[i]);
//        }

        //***********-----------NamuDarbas-----------------

        //startuoja 8 masinos
        //apie kiekviena masina mes zinom greiti ir nuvaziuota kelia
        //
        //kiekvienos iteracijos metu kiekvienos masinos (atskirai) greitis gali pasikeisti nuo -3 iki +10
        //(masina atbulai nevaziuoja)
        //kiekvienos iteracijos metu masina pavaziuoja per tiek km koks dabar yra jos greitis
        //
        //lenktynes baigiasi, kai bent viena masina nuvaziuoja 3000 km
        //
        //pabaigoj reikia atspausdinti laimetojo numeri, nuvaziuota kelia
        //
        //*) kas 200 km reikia atspausdinti lyderio numeri ir greiti

        int[] greitis = new int[8];
        int[] kelias = new int[8];

        boolean lenktynesBaigesi = false;
        int ratas = 1;

        while (!lenktynesBaigesi) {
            // cia visu masinu greitis pasikeite
            for (int i = 0; i < greitis.length; i++) {
                greitis[i] += atsitiktinis(-3, 10);
                if (greitis[i] < 0) {
                    greitis[i] = 0;
                }
            }
            // visos masinos pavaziuoja
            for (int i = 0; i < greitis.length; i++) {
                kelias[i] += greitis[i];
            }
            //komentatorius
            //randam lyderi
            int lyderis = 0;
            for (int i = 1; i < kelias.length; i++) {
                if (kelias[i] > kelias[lyderis]) {
                    lyderis = i;
                }
            }
            // jei lyderis apvaziavo rata - atspausdinam ir startuojam kita rata
            if (kelias[lyderis] > ratas * 200) {
                System.out.println("po " + (ratas * 200) + " pirmauja " + lyderis);
                System.out.println("jis nuvaziavo " + kelias[lyderis]);
                System.out.println("jo greitis " + greitis[lyderis]);
                System.out.println("---------");
                ratas++;
            }

            // ar bent viena masina nuvaziavo 3000 km
            for (int i = 0; i < kelias.length; i++) {
                if (kelias[i] >= 3000) {
                    lenktynesBaigesi = true;
                    break;
                }
            }
        }

        // surandam laimetoja
        int laimetojas = 0;
        for (int i = 1; i < kelias.length; i++) {
            if (kelias[i] > kelias[laimetojas]) {
                laimetojas = i;
            }
        }

        System.out.println("Laimejo " + laimetojas);
        System.out.println("Jis nuvaziavo " + kelias[laimetojas]);
        System.out.println("Jo greitis " + greitis[laimetojas]);


    }

}

