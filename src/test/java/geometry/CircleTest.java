package geometry;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;
import static org.testng.Assert.*;

public class CircleTest {

    @Test(dataProvider = "testPointInsideParameters")
    public void testPointInside(double a, double b, double radius) {
        Circle circle = new Circle(radius);
        Point p = new Point(a, b);
        assertThat(circle.pointInside(p)).isTrue();
    }

    @DataProvider(name = "testPointInsideParameters")
    public Object[][] testPointInsideParameters() {
        return new Object[][]{
                {1, -1, 3},
                {1, 1, 2},
                {2, 4, 33}
        };
    }

    @Test(dataProvider = "testPointNotInsideParameters")
    public void testPointNotInside(double a, double b, double radius) {
        Circle circle = new Circle(radius);
        Point p = new Point(a, b);
        assertThat(circle.pointInside(p)).isFalse();
    }

    @DataProvider(name = "testPointNotInsideParameters")
    public Object[][] testPointNotInsideParameters() {
        return new Object[][]{
                {7, 7, 3},
                {6, 6, 2},
                {5, 5, 1}
        };
    }
}