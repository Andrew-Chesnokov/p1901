package geometry;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test(dataProvider = "lineContainsPointProvider")
    public void testContainsPoint(double a, double b, double c, double x, double y) {
        Line line = new Line(a,b,c);
        Point p = new Point(x,y);
//        assertTrue(line.containsPoint(p));
        assertThat(line.containsPoint(p)).isTrue();
    }

    @DataProvider(name = "lineContainsPointProvider")
    public Object[][] lineContainsPointProvider() {
        return new Object[][] {
                {1, -1, 0, 1, 1},
                {1, -1, 0, 2, 2},
                {2, 0, 5, 2.5, 1000}
        };
    }

    @Test(dataProvider = "lineNotContainsPointProvider")
    public void testNotContainsPoint(double a, double b, double c, double x, double y) {
        Line line = new Line(a,b,c);
        Point p = new Point(x,y);
//        assertTrue(line.containsPoint(p));
        assertThat(line.containsPoint(p)).isFalse();
    }

    @DataProvider(name = "lineNotContainsPointProvider")
    public Object[][] lineNotContainsPointProvider() {
        return new Object[][] {
                {1, -1, 0, 1, 1.2},
                {1, -1, 0, 2.1, 2},
                {2, 0, 5, 2.6, 1000}
        };
    }

    @Test(dataProvider = "lineIntersectionProvider")
    public void testLineIntersection(double a1, double b1, double c1, double a2, double b2, double c2, double x, double y) {
        Line line1 = new Line(a1, b1, c1);
        Line line2 = new Line(a2, b2, c2);
        Point p = new Point(x, y);
        assertEquals(line1.intersection(line2), p);
    }

    @DataProvider(name = "lineIntersectionProvider")
    public Object[][] lineIntersectionProvider() {
        return new Object[][] {
                {1, -1, 0, 2, 0, 5, 2.5, 2.5},
                {1, -1, 0, 2, -1, 3, 3, 3}
        };
    }

    @Test
    public void testLineByTwoPoints() {
        double x1 = 0;
        double y1 = -3;
        double x2 = 1.5;
        double y2 = 0;

        double a = 20;
        double b = -10;
        double c = 30;

        Line actual = Line.lineByTwoPoints(new Point(x1, y1), new Point(x2, y2));
        Line expected = new Line(a, b, c);

        assertThat(actual).isEqualTo(expected);
    }
}