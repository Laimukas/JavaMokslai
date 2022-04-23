package lt.bit.exercises;

public abstract class Shape {

    protected String color;
    protected boolean isFilled;

    public Shape(){
        color = "unknown";
        isFilled = false;
    }

    public Shape(String color, boolean isFilled){
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor(){
        return color;
    }

    public boolean getIsFilled(){
        return isFilled;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setIsFilled(boolean isFilled){
        this.isFilled = isFilled;
    }

    public String toString(){
        // ternary operation
        String tekstas = isFilled ? "filled" : "NoFilled";
        return String.format("Shape with color of %s and %s", color, tekstas);
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
