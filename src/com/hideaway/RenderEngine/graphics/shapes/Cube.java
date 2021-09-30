package com.hideaway.RenderEngine.graphics.shapes;

import com.hideaway.RenderEngine.graphics.coordinates.Mesh;
import com.hideaway.RenderEngine.graphics.coordinates.Triangle;
import com.hideaway.RenderEngine.graphics.coordinates.Vertex;

/**
 * This is a static Cube which is not changeable, and is used purely for testing purposes. All the coordinates
 * values are hard coded.
 *
 * Collection of vertices of triangles for a cube. There must always be a multiple of 3.
 * */
public class Cube {
    private static final Mesh cubeMesh = new Mesh();

    public static float[][] vertices = {
            /*
            The cube gets rendered in the sequence each side is presented. I have not chosen a particular
            for this cube, but that may be needed to be addressed later. Each side consists of 2 triangles,
            each consisting of 3 vertices, each consisting of 3 coordinate points: x, y, z.
             */

            //front
            {-0.5f, 0.5f, -0.5f}, {-0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, -0.5f},
            {-0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, -0.5f}, {0.5f, 0.5f, -0.5f},

            //top
            {-0.5f, -0.5f, -0.5f}, {-0.5f, -0.5f, 0.5f}, {0.5f, -0.5f, 0.5f},
            {-0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, 0.5f}, {0.5f, -0.5f, -0.5f},

            //right
            {0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, -0.5f}, {0.5f, -0.5f, 0.5f},
            {0.5f, 0.5f, -0.5f}, {0.5f, -0.5f, 0.5f}, {0.5f, 0.5f, 0.5f},

            //left
            {-0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f}, {-0.5f, -0.5f, -0.5f},
            {-0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, -0.5f}, {-0.5f, 0.5f, -0.5f},

            //bottom
            {-0.5f, 0.5f, 0.5f}, {-0.5f, 0.5f, -0.5f}, {0.5f, 0.5f, -0.5f},
            {-0.5f, 0.5f, 0.5f}, {0.5f, 0.5f, -0.5f}, {0.5f, 0.5f, 0.5f},

            //back
            {0.5f, 0.5f, 0.5f}, {0.5f, -0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f},
            {0.5f, 0.5f, 0.5f}, {-0.5f, -0.5f, 0.5f}, {-0.5f, 0.5f, 0.5f}
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