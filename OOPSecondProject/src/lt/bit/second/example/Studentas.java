package lt.bit.second.example;

public class Studentas {
    private String studentoId;
    private int kursas;
    private String adresas;
    private String saskaita;

    //Alt+insert+Constructor
    public Studentas(String studentoId, int kursas, String adresas, String saskaita) {
        this.studentoId = studentoId;
        this.kursas = kursas;
        this.adresas = adresas;
        this.saskaita = saskaita;
    }

    //Alt+insert+setter
    public void setStudentoId(String studentoId) {
        this.studentoId = studentoId;
    }

    public void setKursas(int kursas) {
        this.kursas = kursas;
    }

    public void setAdresas(String adresas) {
        this.adresas = adresas;
    }

    public void setSaskaita(String saskaita) {
        this.saskaita = saskaita;
    }
    //Alt+insert+toString

    @Override
    public String toString() {
        return
                "studentoId='" + studentoId + '\'' +
                        ", kursas=" + kursas +
                        ", adresas='" + adresas + '\'' +
                        ", saskaita='" + saskaita;
    }
}
