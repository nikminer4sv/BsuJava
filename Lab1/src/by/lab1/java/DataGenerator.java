package by.lab1.java;

import java.util.ArrayList;
import java.util.HashMap;

public class DataGenerator {
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

    public static HashMap<TriangleType, ArrayList<Triangle>> generateTrianglesMap() {
        HashMap<TriangleType, ArrayList<Triangle>> map = new HashMap<>();
        for (var type : TriangleType.values())
            map.put(type, new ArrayList<>());
        return map;
    }
}
