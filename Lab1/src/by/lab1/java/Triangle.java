package by.lab1.java;

import java.util.Arrays;
import java.util.Comparator;

public class Triangle extends Figure {
    private Point[] points;

    public Triangle() {
        points = new Point[3];
    }

    public Triangle (double x1, double y1, double x2, double y2, double x3, double y3) {
        Point[] points = new Point[]{new Point(x1, y1), new Point(x2, y2), new Point(x3, y3)};
        setPoints(points);
    }

    public Triangle(Point[] points) {
        setPoints(points);
    }

    public Point[] getPoints() {
        Point[] copy = new Point[points.length];
        for (int i = 0; i < points.length; i++)
            copy[i] = points[i].clone();
        return copy;
    }

    public void setPoints(Point[] points) {
        if (points.length != 3)
            throw new IllegalArgumentException("Invalid points array");
        this.points = points;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        double temp = halfPerimeter;
        for (int i = 0; i < 3; i++) {
            double lineLength = Math.sqrt(Math.pow(points[(i + 1) % 3].getX() - points[i].getX(), 2) +
                    Math.pow(points[(i + 1) % 3].getY() - points[i].getY(), 2));
            temp *= halfPerimeter - lineLength;
        }
        return Math.sqrt(temp);
    }

    @Override
    public String toString() {
        return "by.java.core.Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }

    @Override
    public double getPerimeter() {
        double result = 0;
        for (int i = 0; i < 3; i++) {
            double lineLength = 0;
            lineLength = Math.sqrt(Math.pow(points[(i + 1) % 3].getX() - points[i].getX(), 2) +
                    Math.pow(points[(i + 1) % 3].getY() - points[i].getY(), 2));
            result += lineLength;
        }
        return result;
    }

    public double[] getSides() {
        double[] sides = new double[3];
        for (int i = 0; i < 3; i++) {
            sides[i] = Math.sqrt(Math.pow(points[(i + 1) % 3].getX() - points[i].getX(), 2) +
                    Math.pow(points[(i + 1) % 3].getY() - points[i].getY(), 2));
        }
        return sides;
    }

    public static class TriangleAreaComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return Double.compare(o1.getArea(), o2.getArea());
        }
    }

    public static class TrianglePerimeterComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return Double.compare(o1.getPerimeter(), o2.getPerimeter());
        }
    }
}
