package lt.bit.variantas6;

public class Imone {

    public String imonesPavadinimas;
    public String direktoriausPavarde;
    public int darbuotojuSkaicius;
    public String miestas;
    public String telefonoNumeris;

    public Imone(String imonesPavadinimas, String direktoriausPavarde, int darbuotojuSkaicius,
                 String miestas, String telefonoNumeris){
        this.imonesPavadinimas = imonesPavadinimas;
        this.direktoriausPavarde = direktoriausPavarde;
        this.darbuotojuSkaicius = darbuotojuSkaicius;
        this.miestas = miestas;
        this.telefonoNumeris = telefonoNumeris;
    }

    public String getImonesPavadinimas(){
        return imonesPavadinimas;
    }

    public String getDirektoriausPavarde(){
        return direktoriausPavarde;
    }

    public int getDarbuotojuSkaicius(){
        return darbuotojuSkaicius;
    }

    public String getMiestas(){
        return miestas;
    }

    public String getTelefonoNumeris(){
        return telefonoNumeris;
    }

    public String toString(){
        return String.format("Imones pavadinimas: %s, direktoriaus pavarde: %s, darbuotoju skaicius: %d, miestas: %s, telefono numeris: %s",
                imonesPavadinimas, direktoriausPavarde, darbuotojuSkaicius, miestas, telefonoNumeris);
    }
}
