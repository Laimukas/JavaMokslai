package lt.bit;

public class Transportas {
    int ratai;
    boolean variklis;

    public Transportas(int ratai, boolean variklis) {
        this.ratai = ratai;
        this.variklis = variklis;
    }

    public int getRatai() {
        return ratai;
    }

    public void setRatai(int ratai) {
        this.ratai = ratai;
    }

    public boolean isVariklis() {
        return variklis;
    }

    public void setVariklis(boolean variklis) {
        this.variklis = variklis;
    }

    @Override
    public String toString() {
        return "Transportas{" +
                "ratai=" + ratai +
                ", variklis=" + variklis +
                '}';
    }
}
