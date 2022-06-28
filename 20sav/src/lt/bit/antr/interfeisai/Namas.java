package lt.bit.antr.interfeisai;

public class Namas implements Elektra,Vanduo {

    private String adresas;
    private boolean sviesaDega;

    public Namas(String addr) {
        this.adresas = addr;
        this.sviesaDega = false;
    }

    public void ijunk() {
        this.sviesaDega = true;
    }

    public void isjunk() {
        this.sviesaDega = false;
    }

    @Override
    public void atsuk() {
        System.out.println("Name vanduo teka");
    }

    @Override
    public void uzsuk() {
        System.out.println("Name vanduo neteka");
    }

    @Override
    public void nuleiskVandeni() {
        System.out.println("Name tualetas atsilaisvino");
    }

    @Override
    public String toString() {
        return "Namas{" +
                "adresas='" + adresas + '\'' +
                ", sviesaDega=" + sviesaDega +
                '}';
    }

    public String getAdresas() {
        return adresas;
    }
}
