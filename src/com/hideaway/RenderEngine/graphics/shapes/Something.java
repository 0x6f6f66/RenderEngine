package com.hideaway.RenderEngine.graphics.shapes;

import com.hideaway.RenderEngine.graphics.coordinates.Mesh;
import com.hideaway.RenderEngine.graphics.coordinates.Triangle;
import com.hideaway.RenderEngine.graphics.coordinates.Vertex;



@Deprecated
public class Something {
    private static final Mesh mesh = new Mesh();
    private static final float a = 0.8f;
    private static final float b = 0.2f;
    private static final float c = 0.2f;

    /*
            {c, a, b},
            {c, -a, b},
            {-c, -a, b},
            {-c, a, b},
            {a, b, c},
            {-a, b, c},
            {-a, b, -c},
            {a, b, -c},
            {b, c, a},
            {b, c, -a},
            {b, -c, -a},
            {b, -c, a}



            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {}
    */

    public static float[][] vertices = {

    };

    public static Mesh getMesh() {
        for(int i = 0; i < vertices.length; i+= 3){
            Triangle tri = new Triangle(new Vertex(vertices[i]), new Vertex(vertices[i+1]), new Vertex(vertices[i+2]));
            mesh.add(tri);
        }
        return mesh();
    }

    private static Mesh mesh(){
        return mesh;
    }
}