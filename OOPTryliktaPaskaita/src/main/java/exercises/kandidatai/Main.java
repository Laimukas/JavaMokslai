package exercises.kandidatai;

public class Main {

    public static void main(String[] args) throws KandidatuServisoKlaida {
        KandidatuServisas kandidatuServisas = new KandidatuServisas();
        kandidatuServisas.perziuretiKandidatus();
        Kandidatas kandidatas =
                new Kandidatas("Tomas", "Pavardenis", "Software Engineer", 3, 2540);
        System.out.println("-----------------------------------------------------------------------------------------");
        kandidatuServisas.papildytiSarasa(kandidatas);
        kandidatuServisas.perziuretiKandidatus();
        System.out.println("-----------------------------------------------------------------------------------------");
        kandidatuServisas.pasalintiIsSaraso(kandidatas);
        kandidatuServisas.perziuretiKandidatus();
        System.out.println("----------------------------------------------------------------------------------");
        kandidatuServisas.paieska();
    }
}
