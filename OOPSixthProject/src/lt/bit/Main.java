package lt.bit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//REGEX
// Regex ivairiu panaudojimo varijantu yra google aptinkama
        //1 pvz
//        Pattern pattern = Pattern.compile("as");
//        Matcher matcher = pattern.matcher("Labas");
        //2 pvz
//        Pattern pattern = Pattern.compile(".s");
//        Matcher matcher = pattern.matcher("as");
        //3 pvz
//        Pattern pattern = Pattern.compile("[a-d1-7]");
//        Matcher matcher = pattern.matcher("A9");
        //4 pvz su e-mail
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher matcher = pattern.matcher("zigmas@gmail.com");
       // System.out.println(matcher.find());
//jei kartojam matcher.find tai jis jau rasys kaip netinkama,tad ankstesni matcher.find uzkomentinau
        if (matcher.find()){
            //logika gali prisijungti
            System.out.println("El.pastas tinkamas");
        }else {
            System.out.println("Atsiprasome bet el.pastas netinka");
        }

//        String tekstas = "Labas";
//        tekstas.matches("as");
//        System.out.println(tekstas.matches("as"));
    }
}
