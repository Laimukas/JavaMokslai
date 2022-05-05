package lt.bit;
//Petriukas gavo n saldainių. Kiekvieną dieną jis nori suvalgyti skirtingą skaičių
//saldainių x. Kelias dienas Petriukas galės mėgautis saldainiais ir kiek jam dar liks nesuvalgytų
//saldainių tuo atveju, jei paskutinei dienai saldainių nebeužtektų.
//Pastaba: kiekvieną dieną suvalgomi saldainiai turi būti įvedinėjami atskirai, jie turi būti
//įvedinėjami tol, kol Petriukas nebus suvalgęs visų saldainių.

import java.util.Scanner;

public class Saldainiai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Petriukas gavo saldainiu: ");
        int saldainiuKiekis = in.nextInt();
        //su salyga jog jis bent minimaliai suvalgys po 1 saldaini i diena
        int maxDienu = saldainiuKiekis;
        int suvalgytaSaldainiu=0;
        int dienos=0;
        int liksSaldainiu=0;
        for (int i =1;i<=maxDienu;i++){
            if (suvalgytaSaldainiu<=saldainiuKiekis){
                liksSaldainiu=saldainiuKiekis-suvalgytaSaldainiu;
                System.out.println("Per diena suvalge: ");
                int perDienaSuvalge = in.nextInt();
                suvalgytaSaldainiu=suvalgytaSaldainiu+perDienaSuvalge;
                dienos++;
            }

        }
        System.out.println("Petriukui saldainiu uzteks "+(dienos-1)+" dienoms ir jam liks "+liksSaldainiu+ " saldainiai.");

    }
}
