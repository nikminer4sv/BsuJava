public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[3];
        points[0] = new Point(3,241);
        points[1] = new Point(123,5);
        points[2] = new Point(-13,8);
        Triangle t = new Triangle(points);
        System.out.println(t.getPerimeter());
        System.out.println(t.getArea());
    }
}