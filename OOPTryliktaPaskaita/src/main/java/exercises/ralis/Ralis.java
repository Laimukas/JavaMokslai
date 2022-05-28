package exercises.ralis;

public class Ralis {

    private String automobilioMarke;
    private String modelis;
    private double variklioTuris;
    private double maksimalusGreitis;

    public Ralis(String automobilioMarke, String modelis, double variklioTuris, double maksimalusGreitis) {
        this.automobilioMarke = automobilioMarke;
        this.modelis = modelis;
        this.variklioTuris = variklioTuris;
        this.maksimalusGreitis = maksimalusGreitis;
    }

    public Ralis (){}

    public String getAutomobilioMarke() {
        return automobilioMarke;
    }

    public void setAutomobilioMarke(String automobilioMarke) {
        this.automobilioMarke = automobilioMarke;
    }

    public String getModelis() {
        return modelis;
    }

    public void setModelis(String modelis) {
        this.modelis = modelis;
    }

    public double getVariklioTuris() {
        return variklioTuris;
    }

    public void setVariklioTuris(double variklioTuris) {
        this.variklioTuris = variklioTuris;
    }

    public double getMaksimalusGreitis() {
        return maksimalusGreitis;
    }

    public void setMaksimalusGreitis(double maksimalusGreitis) {
        this.maksimalusGreitis = maksimalusGreitis;
    }

    @Override
    public String toString() {
        return String.format("Auto marke: %-10s, modelis: %-10s, variklio turis: %.2f cm3, max greitis: %.2f km/h",
                automobilioMarke,modelis,variklioTuris,maksimalusGreitis);
    }
}
