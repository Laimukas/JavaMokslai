package exercises.sportininkai;

public class Main {
    public static void main(String[] args) throws SportininkuKomanduKlaida{

        SportininkuKomanda sportininkuKomanda = new SportininkuKomanda();
        sportininkuKomanda.perziuretiSportininkus();
        System.out.println("------------------------------------------------------------------------------------");
        Sportininkas sportininkas =
                new Sportininkas("Tadas","Vaiciunas","DakaroZvaigzdes",178,90);
        sportininkuKomanda.papildytiSarasa(sportininkas);
        sportininkuKomanda.perziuretiSportininkus();
        System.out.println("------------------------------------------------------------------------------------");
        sportininkuKomanda.pasalintiIsSaraso(sportininkas);
        sportininkuKomanda.perziuretiSportininkus();
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Paieska nurodzius varda,pavarde,komanda.->");
        sportininkuKomanda.paieskaPagalVardaPavardeKomanda("Deivis","Blazys","Alpes");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Auksciausio nario paieska nurodytoje komandoje.->");
        sportininkuKomanda.didziausioNarioPaieskaNurodziusKomanda("Alpes");
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Sportininku komandos saraso paieska,nurodzius komandos pavadinima, kartu pateikiant ir komandos nariu kieki.->");
        sportininkuKomanda.komandosSarasasPagalPavadinimaPateikiantIrNariuKieki("Alpes");
    }
}
