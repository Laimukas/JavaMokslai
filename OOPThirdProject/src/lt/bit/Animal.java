package lt.bit;

public class Animal {

    private int weight;
    private int height;

    public Animal(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public void makeNoise(){
        System.out.println("Animal making noise");
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }


}
