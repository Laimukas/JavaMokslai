package exercises.kandidatai;

public class Kandidatas {

    private String vardas;
    private String pavarde;
    private String pareigos;
    private int profesinePatirtis;
    private double pageidaujamasAtlygis;

    public Kandidatas(String vardas, String pavarde, String pareigos, int profesinePatirtis, double pageidaujamasAtlygis) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.pareigos = pareigos;
        this.profesinePatirtis = profesinePatirtis;
        this.pageidaujamasAtlygis = pageidaujamasAtlygis;
    }

    public Kandidatas() {
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getPareigos() {
        return pareigos;
    }

    public int getProfesinePatirtis() {
        return profesinePatirtis;
    }

    public double getPageidaujamasAtlygis() {
        return pageidaujamasAtlygis;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public void setPareigos(String pareigos) {
        this.pareigos = pareigos;
    }

    public void setProfesinePatirtis(int profesinePatirtis) {
        this.profesinePatirtis = profesinePatirtis;
    }

    public void setPageidaujamasAtlygis(double pageidaujamasAtlygis) {
        this.pageidaujamasAtlygis = pageidaujamasAtlygis;
    }

    @Override
    public String toString() {
        return String.format("Kandidato vardas: %s, pavarde: %s, pareigos: %s, profesine patirtis: %d, pageidaujamas atlygis: %.2f",
                vardas, pavarde, pareigos, profesinePatirtis, pageidaujamasAtlygis);
    }
}
