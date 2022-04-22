package lt.bit.task1;

public class Point2D {

    protected float x, y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float[] getXY(){
        float[] masyvas = {x,y};
        return masyvas;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setXY(float x, float y){
        setX(x);
        setY(y);
    }

    public String toString(){
        return String.format("(%f,%f)", x, y);
    }
}
