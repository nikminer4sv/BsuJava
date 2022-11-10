import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<TriangleTypes, ArrayList<Triangle>> sortedTriangles = generateTrianglesMap();

        ArrayList<Triangle> triangles = generateBaseDataCollection();
        for (var element : triangles.get(0).getSides())
            System.out.println(element);

        for (Triangle triangle : triangles) {
            TriangleTypes type = detectTriangleType(triangle);
            sortedTriangles.get(type).add(triangle);
        }

        for (var key : sortedTriangles.keySet()) {
            System.out.println(String.format("%s: %d", key, sortedTriangles.get(key).size()));
            ArrayList<Triangle> temp = sortedTriangles.get(key);
            Collections.sort(temp, new triangleAreaComparator());
            System.out.println("Max area: ");
            System.out.println(temp.get(temp.size() - 1));
            System.out.println("Min area: ");
            System.out.println(temp.get(0));

            Collections.sort(temp, new trianglePerimeterComparator());
            System.out.println("Max perimeter: ");
            System.out.println(temp.get(temp.size() - 1));
            System.out.println("Min perimeter: ");
            System.out.println(temp.get(0));
            System.out.println("-------------");
        }

    }

    public static HashMap<TriangleTypes, ArrayList<Triangle>> generateTrianglesMap() {
        HashMap<TriangleTypes, ArrayList<Triangle>> map = new HashMap<>();
        for (var type : TriangleTypes.values())
            map.put(type, new ArrayList<>());
        return map;
    }

    public static ArrayList<Triangle> generateBaseDataCollection() {
        ArrayList<Triangle> triangles = new ArrayList<Triangle>();
        triangles.add(new Triangle(5,0,0,0,1.8,2.4));
        triangles.add(new Triangle(1,1,1,2,3,3));
        triangles.add(new Triangle(1,1,3,1,2,5));
        triangles.add(new Triangle(1,5,2,1,3,5));
        triangles.add(new Triangle(52,11,34,21,78,1));
        triangles.add(new Triangle(2,2,4,4,-6,6));
        triangles.add(new Triangle(5,0,0,0,2.5,4.33));
        return triangles;
    }

    public static TriangleTypes detectTriangleType(Triangle triangle) {
        // need for double compare
        final double THRESHOLD = .001;
        double[] sides = triangle.getSides();
        if (Math.abs(sides[0] - sides[1]) < THRESHOLD && Math.abs(sides[1] - sides[2]) < THRESHOLD)
            return TriangleTypes.EQUILATERAL;
        else if (Math.abs(sides[0] - sides[1]) < THRESHOLD ||
                 Math.abs(sides[1] - sides[2]) < THRESHOLD ||
                 Math.abs(sides[2] - sides[0]) < THRESHOLD)
            return TriangleTypes.ISOSCELES;
        else if (isRectangular(sides))
            return TriangleTypes.RECTANGULAR;
        else
            return TriangleTypes.ARBITRARY;
    }

    public static boolean isRectangular(double[] sides) {
        Arrays.sort(sides);
        if (Math.pow(sides[2], 2) == Math.pow(sides[0], 2) + Math.pow(sides[1], 2))
            return true;
        return false;
    }

    public static class triangleAreaComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return Double.compare(o1.getArea(), o2.getArea());
        }
    }

    public static class trianglePerimeterComparator implements Comparator<Triangle> {
        @Override
        public int compare(Triangle o1, Triangle o2) {
            return Double.compare(o1.getPerimeter(), o2.getPerimeter());
        }
    }
}