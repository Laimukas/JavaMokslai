package lt.bit;

import java.sql.SQLOutput;

public class Dog {

    private String veisle;
    private int amzius;
    private String spalva;

    public Dog(String veisle, int amzius, String spalva) {
        this.veisle = veisle;
        this.amzius = amzius;
        this.spalva = spalva;

    }

    public String getVeisle() {
        return veisle;
    }

    public void setVeisle(String veisle) {
        this.veisle = veisle;
    }

    public int getAmzius() {
        return amzius;
    }

    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }

    public String getSpalva() {
        return spalva;
    }

    public void setSpalva(String spalva) {
        this.spalva = spalva;
    }

    public void bark() {
        System.out.println("bark()");
    }

    public void sleep() {
        System.out.println("sleep()");
    }
}
