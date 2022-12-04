package by.lab1.java;

import java.util.Arrays;

public class TriangleTypeDetector {
    public static TriangleType detect(Triangle triangle) {
        // need for double compare
        final double THRESHOLD = .001;
        double[] sides = triangle.getSides();
        if (Math.abs(sides[0] - sides[1]) < THRESHOLD && Math.abs(sides[1] - sides[2]) < THRESHOLD)
            return TriangleType.EQUILATERAL;
        else if (Math.abs(sides[0] - sides[1]) < THRESHOLD ||
                Math.abs(sides[1] - sides[2]) < THRESHOLD ||
                Math.abs(sides[2] - sides[0]) < THRESHOLD)
            return TriangleType.ISOSCELES;
        else if (isRectangular(sides))
            return TriangleType.RECTANGULAR;
        else
            return TriangleType.ARBITRARY;
    }

    private static boolean isRectangular(double[] sides) {
        Arrays.sort(sides);
        if (Math.pow(sides[2], 2) == Math.pow(sides[0], 2) + Math.pow(sides[1], 2))
            return true;
        return false;
    }
}
