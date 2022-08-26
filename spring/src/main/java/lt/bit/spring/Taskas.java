package lt.bit.spring;

public class Taskas {

    private float x;
    private float y;

    public Taskas() {
        System.out.println("kuriam taska");
    }

    public Taskas(float x, float y) {
        System.out.println("kuriam taska su x = " + x + " ,y = " + y);
        this.x = x;
        this.y = y;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        System.out.println("Setting y = " + y);
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        System.out.println("Setting x = " + x);
        this.x = x;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Float.floatToIntBits(this.x);
        hash = 97 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Taskas other = (Taskas) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        return Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y);
    }

    @Override
    public String toString() {
        return "Taskas{" + "x=" + x + ", y=" + y + '}';
    }

}
