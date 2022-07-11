package lt.bit.pirm;
import java.util.Scanner;
/**
 * Parasyti programa, kuri skaiciuoja skaiciu sumas:
 * ivedam nuo ir iki
 *
 * suskaldom rezi kas 10000 ir paleidziam atskirus Thread'us su savo nuo/iki
 * kiekvienas Thread'as pabaigoje atspausdina skaiciu nuo/iki suma
 */

//Vyto metodas

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Skaicius nuo: ");
        int skaiciusNuo = Integer.parseInt(scanner.nextLine());
        System.out.print("Skaicius iki: ");
        int skaiciusIki = Integer.parseInt(scanner.nextLine());
        class Worker implements Runnable{
            private int skaiciusNuo, skaiciusIki;
            private String name;
            public Worker(int skaiciusNuo, int skaiciusIki, String name) {
                this.skaiciusNuo = skaiciusNuo;
                this.skaiciusIki = skaiciusIki;
                this.name = name;
            }
            @Override
            public void run() {
                skaiciuoja();
            }
            public void skaiciuoja(){
                int skaicius = 0;
                for (int i = this.skaiciusNuo; i <= this.skaiciusIki; i++) {
                    skaicius = skaicius + i;
                }
                System.out.println(name+" suma="+skaicius);
            }
        }
        if((skaiciusIki - skaiciusNuo) > 10000){
            int skaicius = 1;
            do {
                int skaiciusIKII = skaiciusNuo+(10000*skaicius);
                if(skaiciusIKII > skaiciusIki){ skaiciusIKII = skaiciusIki;}
                Worker worker = new Worker(skaiciusNuo,skaiciusIKII,String.valueOf(skaicius+"-as threadas"));
                Thread thread = new Thread(worker);
                thread.start();
                skaiciusNuo = skaiciusNuo+( 10000*skaicius);
                skaicius ++;
            } while ( skaiciusNuo <= skaiciusIki);
        } else {
            System.out.println("Per mazas skaiciu rezis");
        }
    }
}
