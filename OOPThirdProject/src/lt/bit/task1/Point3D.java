package lt.bit.task1;

public class Point3D extends Point2D {

    private float z;

    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ(){
        return z;
    }

    public float[] getXYZ(){
        float[] masyvas = {super.x, super.y, z};
        return masyvas;
    }

    public void setZ(float z){
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        super.setXY(x, y);
        setZ(z);
    }

    public String toString(){
        return String.format("(%f,%f,%f)", super.x, super.y, z);
    }
}
