package lt.bit;

public class Zmogus {

    // atributai /laukai -> class fields. (attributes)
    // access modifiers -> private -> default -> protected -> public

    private String vardas;
    String pavarde;
    int gimimoMetai;
    double svoris;
    int ugis;
    String ZodiakoZenklas;
    String adresas;
    String telefonoNumeris;
    String tautybe;

    // Konstruktorius -> constructor  metodas kuris yra issaukiamas kai yra sukuriamas naujas objektas
    public Zmogus(String vardas, String pavarde, int gimimoMetai, double svoris,
                  int ugis, String zodiakoZenklas, String adresas, String telefonoNumeris){
        this(vardas,pavarde,gimimoMetai,svoris,ugis,zodiakoZenklas,adresas,telefonoNumeris,"Lietuvos");
    }
    //overloading
    public Zmogus(String vardas, String pavarde, int gimimoMetai, double svoris,
                  int ugis, String zodiakoZenklas, String adresas, String telefonoNumeris, String tautybe) {

        this.vardas = vardas;
        this.pavarde = pavarde;
        this.gimimoMetai = gimimoMetai;
        this.svoris = svoris;
        this.ugis = ugis;
        this.ZodiakoZenklas = zodiakoZenklas;
        this.adresas = adresas;
        this.telefonoNumeris = telefonoNumeris;
        this.tautybe = tautybe;


    }
    // Overloading ->
    //kai argumentu kintamieji skiriasi
    //parametru skaicius skirtingas
    //parametru tipas skiriasi
    //grazinimo tipas skirtingas
    public Zmogus(){

    }


    //Enkapsuliacija -> Encapsulation
    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }
    public String getZodiakoZenklas() {
        return ZodiakoZenklas;
    }

    public void setZodiakoZenklas(String zodiakoZenklas) {
        this.ZodiakoZenklas = zodiakoZenklas;
    }
    //ALT + INSERT yra toks varijantas iskviesti is atminties atributus

    //toliau mokinames kitka

    //jei norim apribot naujo objekto kurima tai aprasom taip
    //tada prie konstruktoriaus aprasytas metodas reik komentint nes neleis jo kurt
   /* private Zmogus(){

    }*/

}
