package com.hideaway.RenderEngine.graphics.shapes;

import com.hideaway.RenderEngine.graphics.coordinates.Mesh;
import com.hideaway.RenderEngine.graphics.coordinates.Triangle;
import com.hideaway.RenderEngine.graphics.coordinates.Vertex;
import com.hideaway.RenderEngine.graphics.render.figures.FigureTwo;

/**
 * This is a temporary class made for debugging, but the mesh is also usable.
 * Another temp class is FigureTwo
 *
 * @see FigureTwo
 * */

public class CubeTwo {
    private static final Mesh cubeMesh = new Mesh();
    private static final double a = 10.3f; //Manually change the X coordinate
    private static final double b = 10.3f; //Manually change the Y coordinate
    private static final double c = 0f; //Manually change the Z coordinate

    public static double[][] vertices = {
            //front
            {-0.5f+a, 0.5f+b, -0.5f+c}, {-0.5f+a, -0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, -0.5f+c},
            {-0.5f+a, 0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, -0.5f+c}, {0.5f+a, 0.5f+b, -0.5f+c},

            //top
            {-0.5f+a, -0.5f+b, -0.5f+c}, {-0.5f+a, -0.5f+b, 0.5f+c}, {0.5f+a, -0.5f+b, 0.5f+c},
            {-0.5f+a, -0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, 0.5f+c}, {0.5f+a, -0.5f+b, -0.5f+c},

            //right
            {0.5f+a, 0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, 0.5f+c},
            {0.5f+a, 0.5f+b, -0.5f+c}, {0.5f+a, -0.5f+b, 0.5f+c}, {0.5f+a, 0.5f+b, 0.5f+c},

            //left
            {-0.5f+a, 0.5f+b, 0.5f+c}, {-0.5f+a, -0.5f+b, 0.5f+c}, {-0.5f+a, -0.5f+b, -0.5f+c},
            {-0.5f+a, 0.5f+b, 0.5f+c}, {-0.5f+a, -0.5f+b, -0.5f+c}, {-0.5f+a, 0.5f+b, -0.5f+c},

            //bottom
            {-0.5f+a, 0.5f+b, 0.5f+c}, {-0.5f+a, 0.5f+b, -0.5f+c}, {0.5f+a, 0.5f+b, -0.5f+c},
            {-0.5f+a, 0.5f+b, 0.5f+c}, {0.5f+a, 0.5f+b, -0.5f+c}, {0.5f+a, 0.5f+b, 0.5f+c},

            //back
            {0.5f+a, 0.5f+b, 0.5f+c}, {0.5f+a, -0.5f+b, 0.5f+c}, {-0.5f+a, -0.5f+b, 0.5f+c},
            {0.5f+a, 0.5f+b, 0.5f+c}, {-0.5f+a, -0.5f+b, 0.5f+c}, {-0.5f+a, 0.5f+b, 0.5f+c}
    };

    /**
     * This method returns the Mesh of the cube, which was specified in the nested array of vertices "vertices". This method acts
     * as an assembler of the nested array "vertices" into a Mesh object.
     * @return the mesh of the cube.
     * @see Mesh
     * */
    public static Mesh getMesh() {
        for(int i = 0; i < vertices.length; i+= 3){
            Triangle tri = new Triangle(new Vertex(vertices[i]), new Vertex(vertices[i+1]), new Vertex(vertices[i+2]));
            cubeMesh.add(tri);
        }
        return getCubeMesh();
    }

    private static Mesh getCubeMesh(){
        return cubeMesh;
    }
}