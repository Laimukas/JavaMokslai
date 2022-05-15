package exercise32;

public class Car {
    private String model;
    private double height;
    private double weight;
    private int years;

    public Car(String model, double height, double weight, int years) {
        this.model = model;
        this.height = height;
        this.weight = weight;
        this.years = years;

    }

    public String getModel() {
        return model;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public int getYears() {
        return years;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", years=" + years +
                '}';
    }
}
