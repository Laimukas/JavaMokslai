package lt.bit;

public class Dog extends Animal {

    public Dog(int weight, int height){
        super(weight, height);
    }

    public void makeNoise(){
        System.out.println("Dog making noise");
    }
}
