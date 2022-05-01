package lt.bit.task9;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public double getRadius() {
        double rezultatasBeSaknies = Math.pow(point.getX() - center.getX(), 2) + Math.pow(point.getY() - center.getY(), 2);
        return Math.sqrt(rezultatasBeSaknies); //cia r
    }

    public double getPerimeter() {

        return 2 * Math.PI * getRadius(); //
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public List<Point2D> getPoints90() {
        ArrayList<Point2D> points = new ArrayList<>();

        Point2D rotatingVector = new Point2D(point.getX() - center.getX(),
                point.getY() - center.getY());

        Point2D rotatedPoint = null;

        for (int i = 0; i < 3; i++) {
            rotatedPoint = new Point2D(rotatingVector.getY(),
                    (rotatingVector.getX()) * (-1));
            points.add(rotatedPoint);
            rotatingVector = rotatedPoint;
        }
        return points;
    }

}
