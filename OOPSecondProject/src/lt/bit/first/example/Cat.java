package lt.bit.first.example;

public class Cat extends Animal implements NoiseImplementation{
    @Override
    public void makeNoise() {
        System.out.println("Miau miau");
    }

    @Override
    public void makeBiggerNoise() {
        System.out.println("MIAU MIAU MIAU");
    }

}
