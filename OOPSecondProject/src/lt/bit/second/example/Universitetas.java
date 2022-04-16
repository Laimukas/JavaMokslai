package lt.bit.second.example;

import java.util.ArrayList;

public class Universitetas {
    private String universitetoID;
    private String adresas;
    private String telefonoNumeris; // +3706...
    //Kompozicija -> Composition
    private ArrayList<Studentas>studentai;

    public Universitetas(String universitetoID, String adresas, String telefonoNumeris, ArrayList<Studentas> studentai) {
        this.universitetoID = universitetoID;
        this.adresas = adresas;
        this.telefonoNumeris = telefonoNumeris;
        this.studentai = studentai;
    }

    public String getUniversitetoID() {
        return universitetoID;
    }

    public String getAdresas() {
        return adresas;
    }

    public String getTelefonoNumeris() {
        return telefonoNumeris;
    }

    public ArrayList<Studentas> getStudentai() {
        return studentai;
    }
}
