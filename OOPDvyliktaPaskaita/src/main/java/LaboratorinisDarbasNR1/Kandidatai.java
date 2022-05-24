package LaboratorinisDarbasNR1;

public class Kandidatai {

    private String vardas;
    private String pavarde;
    private String pareigos;
    private int profesinePatirtis;
    private double pageidaujamasAtlygis;

    public Kandidatai(String vardas, String pavarde, String pareigos, int profesinePatirtis, double pageidaujamasAtlygis) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pareigos = pareigos;
        this.profesinePatirtis = profesinePatirtis;
        this.pageidaujamasAtlygis = pageidaujamasAtlygis;
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

    public String getPareigos() {
        return pareigos;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }

    public int getProfesinePatirtis() {
        return profesinePatirtis;
    }

    public void setProfesinePatirtis(int profesinePatirtis) {
        this.profesinePatirtis = profesinePatirtis;
    }

    public double getPageidaujamasAtlygis() {
        return pageidaujamasAtlygis;
    }

    public void setPageidaujamasAtlygis(double pageidaujamasAtlygis) {
        this.pageidaujamasAtlygis = pageidaujamasAtlygis;
    }

    @Override
    public String toString() {
        return "kandidatai{" +
                "vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", pareigos='" + pareigos + '\'' +
                ", profesinePatirtis=" + profesinePatirtis +
                ", pageidaujamasAtlygis=" + pageidaujamasAtlygis +
                '}';
    }
}
