package lt.bit;
//Linas nori nupirkti vienos rūšies atvirukus savo m draugams. Parduotuvėje yra n
//rūšių atvirukų, kurių kiekvienos rūšies kiekiai yra k1, k2, k3,...,kn. Parašykite programą, kuri
//apskaičiuotų, kelių rūšių atvirukų x iš parduotuvėje esančių n rūšių užtektų visiems Lino
//draugams.

import java.util.Scanner;

public class Atvirukai {
    public static void main(String[] args) {
        System.out.println("Keliems draugams Linas nori dovanoti atvirukus?");
        Scanner in = new Scanner(System.in);
        int drauguKiekis = in.nextInt();
        System.out.println("Kiek rusiu atviruku yra parduotuveje?");
        int atvirukuRusiuKiekis = in.nextInt();
        int counter=0;
        for (int i=1;i<=atvirukuRusiuKiekis;i++){
            System.out.println("Kiek yra "+i+" rusies atviruku?");
            int atvirukuKiekisPagalRusi = in.nextInt();
            if (atvirukuKiekisPagalRusi>=drauguKiekis){
                counter++;
            }
        }
        System.out.println(counter+" rusiu atviruku uztektu visiems Lino draugams");
    }
}
