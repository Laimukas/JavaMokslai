package lt.bit;
//Siuntų pervežimo įmonėje dirbantis kurjeris gavo užduotį parengti pervežimų
//statistiką:
//1. kiek įvykdė užsakymų, kurių suma viršijo 100 Lt;
//2. už kokią vidutinę sumą per dieną išvežiojo prekių;
//3. kiek iš viso prekių išvežiojo.
//Jis nežino, kiek užsakymų įvykdys per dieną, todėl baigęs darbą į programą įves nulį (0), tai
//reikš, kad darbo diena baigta ir reikia pateikti rezultatus. Parenkite programą, kuri leistų
//nežinomą skaičių kartų kurjeriui įvesti užsakymo sumą (skaičiavimai baigiami įvedus nulį, nulis
//skaičiuojant vidurkį ir kiekį nebus pridėtas) ir pateiktų skaičiavimų rezultatus.

import java.util.Scanner;

public class Kurjeris {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        double suma=0;
        int didesniuUz100=0;
        int prekiuKiekis=0;
        System.out.println("Iveskite suma: ");
        for (int i =1;i<max;i++){
            Scanner in = new Scanner(System.in);
            double sum = in.nextDouble();
            if (sum != 0 && sum>100){
                suma=suma+sum;
                didesniuUz100++;
                prekiuKiekis++;
            }else if (sum != 0){
                suma=suma+sum;
                prekiuKiekis++;
            }else{
                max=i;
            }
        }
        System.out.println("suma: "+suma+" Lt.");
        System.out.println("prekiu kiekis: "+prekiuKiekis);
        System.out.println("Uzsakymu didesniu uz 100 Lt. buvo: "+didesniuUz100);
        System.out.println("Vidutine uzsakymu suma: "+suma/prekiuKiekis+" Lt.");

    }
}
