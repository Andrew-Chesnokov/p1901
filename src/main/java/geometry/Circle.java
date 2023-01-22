package geometry;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    public boolean pointInside(Point p) {
        double hypot = Math.abs(Math.sqrt((p.getX() * p.getX()) + (p.getY() * p.getY())));
        return hypot <= radius;
    }
}