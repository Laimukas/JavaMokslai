package exercises.kates;

public class Main {

    public static void main(String[] args) throws KaciuParodosServisoKlaida {
        KaciuParoda kaciuParoda = new KaciuParoda();
        kaciuParoda.perziuretiKates();
        System.out.println("------------------------------------------------------------------------------------");
        Kate kate = new Kate("Burbulis", "Bengaliskas","V", 2.67, 1);
        kaciuParoda.papildytiSarasa(kate);
        kaciuParoda.perziuretiKates();
        System.out.println("-------------------------------------------------------------------------------------");
        kaciuParoda.pasalintiIsSaraso(kate);
        kaciuParoda.perziuretiKates();
        System.out.println("-------------------------------------------------------------------------------------");
        kaciuParoda.paieska();


    }
}
