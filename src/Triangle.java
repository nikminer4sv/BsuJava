import java.util.Arrays;

public class Triangle extends Figure {
    private Point[] points;

    public Triangle() {
        points = new Point[3];
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
}
