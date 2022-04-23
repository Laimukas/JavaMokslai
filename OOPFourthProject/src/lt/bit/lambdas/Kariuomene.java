package lt.bit.lambdas;

public class Kariuomene {

    public void arTinkateKariuomenei(Zmogus zmogus, KariuomenesValidatorius kariuomenesValidatorius){
        if(kariuomenesValidatorius.arTinkaKariuomenei(zmogus)){
            System.out.println("Tinkate kariuomenei");
        } else {
            System.out.println("Deja, bet netinkate kariuomenei");
        }
    }
}
