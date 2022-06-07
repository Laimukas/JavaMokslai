package com.example.oopsesioliktapaskaita.LaboratorinisNR3;

public class Adresas {
    private String vardas;
    private String pavarde;
    private String miestas;
    private String telNumeris;

    public Adresas(String vardas, String pavarde, String miestas, String telNumeris) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.miestas = miestas;
        this.telNumeris = telNumeris;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public String getMiestas() {
        return miestas;
    }

    public void setMiestas(String miestas) {
        this.miestas = miestas;
    }

    public String getTelNumeris() {
        return telNumeris;
    }

    public void setTelNumeris(String telNumeris) {
        this.telNumeris = telNumeris;
    }

    @Override
    public String toString() {
        return String.format("Adresato vardas: %-8s, pavarde: %-12s, miestas: %-8s, telefono numeris: %s",
                vardas,pavarde,miestas,telNumeris);

    }
}
