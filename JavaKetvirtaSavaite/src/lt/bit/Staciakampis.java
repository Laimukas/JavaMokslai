package lt.bit;

public class Staciakampis {
    private String id;
    private double x;
    private double y;

    public Staciakampis(String id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Staciakampis " +
                 id +
                " x=" + x +
                ", y=" + y+
                ",perimetras="+perimetras()+
                ",plotas="+plotas();
    }

    public double perimetras() {
        return 2 * (x + y);
    }

    public double plotas() {
        return x * y;
    }
}
