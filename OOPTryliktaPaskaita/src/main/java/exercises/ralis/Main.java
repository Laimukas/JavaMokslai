package exercises.ralis;

public class Main {
    public static void main(String[] args) throws RalioLenktyniuKlaida {

        RalioLenktynes ralioLenktynes = new RalioLenktynes();
        ralioLenktynes.perziuretiRalius();
        System.out.println("------------------------------------------------------------------------------------");
        Ralis ralis = new Ralis("Lambo","Aventador",8.0,330);
        ralioLenktynes.papildytiSarasa(ralis);
        ralioLenktynes.perziuretiRalius();
        System.out.println("------------------------------------------------------------------------------------");
        ralioLenktynes.pasalintiIsSaraso(ralis);
        ralioLenktynes.perziuretiRalius();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Paieska pagal variklio turiu intervala.");
        ralioLenktynes.paieskaPagalVariklioTuriuIntervala(3,5);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Paieska nurodzius modeli.");
        ralioLenktynes.paieskaPagalModeli("RS6");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Paieska nurodzius marke,modeli,max greiti.");
        ralioLenktynes.paieskaPagalMarkeModeliMaxGreiti("Ford","Mustang",299);

    }
}
