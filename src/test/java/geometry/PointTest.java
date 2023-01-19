package geometry;

import org.assertj.core.data.Percentage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PointTest {

    @BeforeMethod
    public void setUp() {

    }

    @Test
    public void testDistance() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0, 10);
        assertThat(p1.distance(p2)).isCloseTo(10.0, Percentage.withPercentage(0.1));
//        assertThat(p1.equals(p2)).isTrue();
    }

    @Test(dataProvider = "pointDistanceProvider")
    public void testDistanceParameterized(double x1, double y1, double x2, double y2, double expectedDistance) {
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        assertThat(p1.distance(p2)).isCloseTo(expectedDistance, Percentage.withPercentage(0.1));
    }

    @DataProvider(name = "pointDistanceProvider")
    public Object[][] pointDistanceProvider() {
        return new Object[][] {
                {0, 0, 0, 10, 10},
                {10, 0, 0, 0, 10},
                {1, 1, 2, 2, 1.4142}
        };
    }
}