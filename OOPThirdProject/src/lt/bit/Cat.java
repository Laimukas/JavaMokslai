package lt.bit;

public class Cat extends Animal {

    private String veisle;

    public Cat(int weight, int height, String veisle){
        super(weight, height);
        this.veisle = veisle;
    }

    public void makeNoise(){
        System.out.println("Cat making noise");
    }

    public String getVeisle() {
        return veisle;
    }
}
