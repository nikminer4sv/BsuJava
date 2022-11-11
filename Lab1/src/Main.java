import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<TriangleTypes, ArrayList<Triangle>> sortedTriangles = DataGenerator.generateTrianglesMap();

        ArrayList<Triangle> triangles = DataGenerator.generateBaseDataCollection();
        for (var element : triangles.get(0).getSides())
            System.out.println(element);

        for (Triangle triangle : triangles) {
            TriangleTypes type = TriangleTypeDetector.detect(triangle);
            sortedTriangles.get(type).add(triangle);
        }

        for (var key : sortedTriangles.keySet()) {
            System.out.println(String.format("%s: %d", key, sortedTriangles.get(key).size()));
            ArrayList<Triangle> temp = sortedTriangles.get(key);
            Collections.sort(temp, new Triangle.TriangleAreaComparator());
            System.out.println("Max area: ");
            System.out.println(temp.get(temp.size() - 1));
            System.out.println("Min area: ");
            System.out.println(temp.get(0));

            Collections.sort(temp, new Triangle.TrianglePerimeterComparator());
            System.out.println("Max perimeter: ");
            System.out.println(temp.get(temp.size() - 1));
            System.out.println("Min perimeter: ");
            System.out.println(temp.get(0));
            System.out.println("-------------");
        }
    }
}