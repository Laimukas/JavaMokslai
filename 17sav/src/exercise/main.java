package exercise;

public class main {
    public static void main(String[] args) {

        //-----------------1------------------

//        int suma = 0;
//        int sk = 5;
//        while (sk <= 15464) {
//            if (sk % 2 == 0) {
//                // suma = suma + sk;
//                suma += sk;
//            }
//            // sk = sk + 1;
//            sk += 1;
//        }
//        System.out.println(suma);

        //------------------2-----------------

//        int sk =3;
//        while(sk <=7){
//            System.out.print(sk*3+" ");
//            System.out.print(sk*4+" ");
//            System.out.print(sk*5+" ");
//            System.out.print(sk*6+" ");
//            System.out.print(sk*7+" ");
//            sk++;
//            System.out.println();
//        }
        //arba pagal Aliu
//        int nuo = 3;
//        int iki = 7;
//
//        int i = nuo;
//        while (i <= iki) {
//            int j = nuo;
//            while (j <= iki) {
//                System.out.print(i * j);
//                System.out.print('\t');
//                j += 1;
//            }
//            System.out.println();
//            i += 1;
//        }
        //---------------------3--------------------

        int sk = 15;
        long sumLyg = 0;
        long sumNelyg = 0;
        int countLyg = 0;
        int countNelyg = 0;
        double vidLyg = 0;
        double vidNelyg = 0;

        while (sk <= 1651965) {

            if (sk % 2 == 0) {
                sumLyg = sumLyg + sk;
                countLyg++;
                sk++;
            }sumNelyg=sumNelyg+sk;
            countNelyg++;
            sk++;

        }
        vidLyg = sumLyg / countLyg;
        vidNelyg=sumNelyg/countNelyg;
        System.out.println("Lyginiu suma: "+sumLyg+" ,o vidurkis: "+vidLyg+" Lyginiu intervale yra: "+countLyg+" vnt.");

        System.out.println("Nelyginiu suma: "+sumNelyg+" ,o vidurkis: "+vidNelyg+" Nelyginiu intervale yra: "+countNelyg+" vnt.");

    }
}
