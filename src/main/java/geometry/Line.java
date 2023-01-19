package geometry;

import java.util.Objects;
import static geometry.Constants.EPS;

public class Line {
    private double a;
    private double b;
    private double c;

    private double an, bn, cn;

    public Line(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        // a*a + b*b = 1
        double r = Math.hypot(a,b);
        an = a / r;
        bn = b / r;
        cn = c / r;

        if (an < 0) {
            an = -an;
            bn = -bn;
            cn = -cn;
        }
    }

    // x + y = 1
    // 2*x + 2*y = 2


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Math.abs(line.an - an) < EPS && Math.abs(line.bn - bn) < EPS && Math.abs(line.cn - cn) < EPS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(an, bn, cn);
    }

    public static Line lineByTwoPoints(Point p1, Point p2) {
        // (x - x1)/(x2 - x1) = (y - y1)/(y2 - y1)
        // (y2-y1)(x-x1) = (x2-x1)(y-y1)
        // (y2-y1)(x-x1) - (x2-x1)(y-y1) = 0     a * x + b * y = c
        // a = y2-y1
        // b = x1-x2
        // c = a * x1 + b * y1
        double a = p2.getY() - p1.getY();
        double b = p1.getX() - p2.getX();
        double c = a * p1.getX() + b * p1.getY();
        return new Line(a, b, c);
    }

    public boolean containsPoint(Point p) {
        return Math.abs(a * p.getX() + b * p.getY() - c) < EPS;
    }

    public Point intersection(Line line) {
        double a1 = a;
        double b1 = b;
        double c1 = c;
        double a2 = line.a;
        double b2 = line.b;
        double c2 = line.c;
        // a1 * x + b1 * y = c1
        // a2 * x + b2 * y = c2
        double d = a1*b2 - a2*b1;
        if (Math.abs(d) < EPS) {  // d == 0 -> Math.abs(d) < EPS
            return null;
        }
        double x = (c1*b2 - c2*b1)/d;
        double y = (a1*c2 - a2*c1)/d;
        return new Point(x,y);
    }
}
