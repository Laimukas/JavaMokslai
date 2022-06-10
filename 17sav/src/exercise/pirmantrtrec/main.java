package exercise.pirmantrtrec;

import java.util.Map;
import java.util.Scanner;

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
//
//        int sk = 15;
//        long sumLyg = 0;
//        long sumNelyg = 0;
//        int countLyg = 0;
//        int countNelyg = 0;
//        double vidLyg = 0;
//        double vidNelyg = 0;
//
//        while (sk <= 1651965) {
//
//            if (sk % 2 == 0) {
//                sumLyg = sumLyg + sk;
//                countLyg++;
//                sk++;
//            }sumNelyg=sumNelyg+sk;
//            countNelyg++;
//            sk++;
//
//        }
//        vidLyg = sumLyg / (double)countLyg;
//        vidNelyg=sumNelyg/(double)countNelyg;
//        System.out.println("Lyginiu suma: "+sumLyg+" ,o vidurkis: "+vidLyg+" Lyginiu intervale yra: "+countLyg+" vnt.");
//        System.out.println("Nelyginiu suma: "+sumNelyg+" ,o vidurkis: "+vidNelyg+" Nelyginiu intervale yra: "+countNelyg+" vnt.");

        //------------------4-----------------------------------

//        int i = 10;
//
////        while (i<5){
////            System.out.println(i);
////            i++;
////        }
//        do {
//            System.out.println(i);
//            i++;
//        }while (i<5);
//        System.out.println("pabaiga");

        //--------------------5--------------------
//
//        int x = 2;
//        for (int i =1;i<=5;i++)
//            System.out.println(x+i);
//        System.out.println("pabaiga");

        //------------------------6----------------

//        for (int i=1;i<10;i++){
//            if(i==4){
//             //   break;
//                continue;
//            }
//            System.out.println(i);
//        }
//        System.out.println("pabaiga");

        //-----------------7------------------

//        int i = 5;
//        int j = i++;
//        int k = ++i;
//        int l = ++j + k--;
//
//        System.out.println(i);
//        System.out.println(j);
//        System.out.println(k);
//        System.out.println(l);
//        System.out.println("pabaiga");

        //-------------------8-----------------------------

//        Scanner sc = new Scanner(System.in);
//        System.out.println("ivesk skaiciu:");
//        int sk= sc.nextInt();
//        System.out.println("tu ivedei: "+sk);

        //-------------------------9------------------

//        paprasytu ivesti:
//        1. akmuo
//        2. popierius
//        3. zirkles
//        0. nezaidziu
//
//        jei ivede 1, 2, 3,
//                kompas random sugeneruoja 1, 2, 3
//        atspausdinti kas laimejo (ar lygiosios)
//        ir vel zaisti is naujo
//
//        jei ivede 0,
//                baigti zaidima

//        Scanner sc = new Scanner(System.in);
//
//       for (int sk=0;sk<=Integer.MAX_VALUE;sk++ ){
//           System.out.println("ivesk skaiciu 1-akmuo,2-popierius,3-zirkles,0-baigti:");
//           sk = sc.nextInt();
//           if (sk==0) {
//               break;
//           }
//            double kompoSk = Math.random() * 4;
//            int verstasSkaicius = (int) kompoSk;
//            if (verstasSkaicius==0) {
//            verstasSkaicius=1;
//            }
//            System.out.println("kompas sugeneravo: " + verstasSkaicius);
//            System.out.println("tu ivedei: " + sk);
//            if (verstasSkaicius == 1 && sk == 2) {
//                System.out.println("kompo akmuo, tavo popierius -> laimi akmuo -> kompas");
//            } else if (verstasSkaicius == 2 && sk == 1) {
//                System.out.println("kompo popierius, tavo akmuo -> laimi akmuo -> tu");
//            } else if (verstasSkaicius == 3 && sk == 1) {
//                System.out.println("kompo zirkles, tavo akmuo -> laimi akmuo -> tu");
//            } else if (verstasSkaicius == 2 && sk == 3) {
//                System.out.println("kompo popierius, tavo zirkles -> laimi zirkles -> tu");
//            } else if (verstasSkaicius == 3 && sk == 2) {
//                System.out.println("kompo zirkles, tavo popierius -> laimi zirkles -> kompas");
//            } else if (verstasSkaicius == 1 && sk == 3) {
//                System.out.println("kompo akmuo, tavo zirkles -> laimi akmuo -> kompas");
//            } else if (verstasSkaicius == sk) {
//                System.out.println("lygiosios");
//            } else
//                System.out.println("kazkas su skaiciukais negerai :)");
//        }
//        System.out.println("pabaiga");

        //Aliaus varijantas:

//        Scanner sc = new Scanner(System.in);
//        int zmogus;
//        do {
//            System.out.println("pasirink: 1 akmuo, 2 popierius, 3 zirkles, 0 pabaiga: ");
//            zmogus = sc.nextInt();
//            if (zmogus >= 1 && zmogus <= 3) {
//                int kompas = (int) (Math.random() * 3 + 1);
//                if (kompas == 1) {
//                    System.out.println("kompas - akmuo");
//                } else if (kompas == 2) {
//                    System.out.println("kompas - popierius");
//                } else if (kompas == 3) {
//                    System.out.println("kompas - zirkles");
//                }
//                if (zmogus == kompas) {
//                    System.out.println("lygiosios");
//                } else {
//                    if (zmogus == 1) {
//                        if (kompas == 2) {
//                            System.out.println("laimejo kompas");
//                        } else {
//                            System.out.println("laimejo zmogus");
//                        }
//                    } else if (zmogus == 2) {
//                        if (kompas == 1) {
//                            System.out.println("laimejo zmogus");
//                        } else {
//                            System.out.println("laimejo kompas");
//                        }
//                    } else {
//                        if (kompas == 1) {
//                            System.out.println("laimejo kompas");
//                        } else {
//                            System.out.println("laimejo zmogus");
//                        }
//                    }
//                }
//            }
//        } while (zmogus != 0);

        //--------------------------10-------------------------------------------
//
////        paklausia kiek zaidimu reikia zaist.
////                kompas zaidzia pats pries save
////        pabaigoj reikia atspausdint:
////        kiek kartu laimejo kompas1
////        kiek kartu laimejo kompas2
////        kiek buvo lygiuju
////        kiek iskrito akmuo
////        kiek iskrito popierius
////        kiek iskrito zirkles
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Kiek kartu reikia suzaist? : ");
//        int c1 = 0;
//        int c2 = 0;
//        int draw = 0;
//        int rock = 0;
//        int paper = 0;
//        int scissor = 0;
//        int kiek = sc.nextInt();
//        for (int i = 1; i <= kiek; i++) {
//            int kompas1 = (int) (Math.random() * 3 + 1);
//            int kompas2 = (int) (Math.random() * 3 + 1);
//            if (kompas1 == 1) {
//                rock++;
//            } else if (kompas1 == 2) {
//                paper++;
//            } else {
//                scissor++;
//            }
//            if (kompas2 == 1) {
//                rock++;
//            } else if (kompas2 == 2) {
//                paper++;
//            } else {
//                scissor++;
//            }
//            if (kompas1 == kompas2) {
//                draw++;
//            } else {
//                if (kompas1 == 1) {
//                    if (kompas2 == 2) {
//                        c2++;
//                    } else {
//                        c1++;
//                    }
//                } else if (kompas1 == 2) {
//                    if (kompas2 == 1) {
//                        c1++;
//                    } else {
//                        c2++;
//                    }
//                } else {
//                    if (kompas2 == 1) {
//                        c2++;
//                    } else {
//                        c1++;
//                    }
//                }
//            }
//        }
//        System.out.println("kompas1 laimejo " + c1);
//        System.out.println("kompas2 laimejo " + c2);
//        System.out.println("lygiosios " + draw);
//        System.out.println("akmuo " + rock);
//        System.out.println("popierius " + paper);
//        System.out.println("zirkles " + scissor);
        //-----------------------11---------------------------------------
        //ivedus numeri kompas meta kokia tai sav diena
//        System.out.println("ivesk numeri,pagal ji kompas parasys kokia tai sav diena.");
//        System.out.print(":");
//        Scanner sc = new Scanner(System.in);
//        int savDiena = sc.nextInt();
//
//        switch (savDiena){
//            case 1:
//                System.out.println("pirmadienis");
//                break;
//            case 2:
//                System.out.println("antradienis");
//                break;
//            case 3:
//                System.out.println("treciadienis");
//                break;
//            case 4:
//                System.out.println("ketvirtadienis");
//                break;
//            case 5:
//                System.out.println("penktadienis");
//                break;
//            case 6:
//                System.out.println("sestadienis");
//                break;
//            case 7:
//                System.out.println("sekmadienis");
//                break;
//            default:
//                System.out.println("tokiu dienu nebuna");

                //kita uzduotis,kad parasytu ar darbo diena ar savaitgalis
//                switch (savDiena){
////                    case 1:
////                    case 2:
////                    case 3:
////                    case 4:
////                    case 5:
//                        //arba
//                    case 1,2,3,4,5:
//                        System.out.println("darbo diena");
//                        break;
////                    case 6:
////                    case 7:
//                        //arba
//                    case 6,7:
//                        System.out.println("savaitgalis");
//                        break;
//                    default:
//                        System.out.println("tokiu dienu nebuna");
//        }
//        System.out.println("pabaiga");

//-----------------------12------------------------------
//        System.out.println("ivesk numeri,pagal ji kompas nuspres koks tai menuo ir kiek dienu yra nuo metu pradzios " +
//                "iki to men paskutines dienos");
//        System.out.print(":");
//        Scanner sc = new Scanner(System.in);
//        int menuo = sc.nextInt();
//        int dienos=0;
//        switch (menuo) {
//            case 12:
//                dienos += 31;
//            case 11:
//                dienos += 30;
//            case 10:
//                dienos += 31;
//            case 9:
//                dienos += 30;
//            case 8:
//                dienos += 31;
//            case 7:
//                dienos += 31;
//            case 6:
//                dienos += 30;
//            case 5:
//                dienos += 31;
//            case 4:
//                dienos += 30;
//            case 3:
//                dienos += 31;
//            case 2:
//                dienos += 28;
//            case 1:
//                dienos += 31;
//// jei pastebejot be break todel sudeda nestabdydamas
//        }
//        System.out.println(dienos);
//        System.out.println("pabaiga");



    }
}

