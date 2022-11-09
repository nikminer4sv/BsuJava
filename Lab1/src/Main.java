import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<TriangleTypes, ArrayList<Triangle>> sortedTriangles = GenerateTrianglesMap();

        ArrayList<Triangle> triangles = GenerateBaseDataCollection();
        for (var element : triangles.get(0).getSides())
            System.out.println(element);

        for (Triangle triangle : triangles) {
            TriangleTypes type = DetectTriangleType(triangle);
            sortedTriangles.get(type).add(triangle);
        }

        for (var key : sortedTriangles.keySet()) {
            System.out.println(String.format("%s: %d", key, sortedTriangles.get(key).size()));
        }

    }

    public static HashMap<TriangleTypes, ArrayList<Triangle>> GenerateTrianglesMap() {
        HashMap<TriangleTypes, ArrayList<Triangle>> map = new HashMap<>();
        for (var type : TriangleTypes.values())
            map.put(type, new ArrayList<>());
        return map;
    }

    public static ArrayList<Triangle> GenerateBaseDataCollection() {
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

    public static TriangleTypes DetectTriangleType(Triangle triangle) {
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

}