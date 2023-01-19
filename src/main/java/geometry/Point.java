package geometry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public double distance(Point other) {
//        return Math.sqrt((x-other.x)*(x-other.x) + (y-other.y)*(y-other.y));
        return Math.hypot(x-other.x, y-other.y);
    }
}
