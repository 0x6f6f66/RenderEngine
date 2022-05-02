package com.hideaway.RenderEngine.coordinates;

import java.util.LinkedList;

/**
 * Mesh class is a way to contain all triangles of vertices.
 * @see Triangle
 * @see Vertex
 */
public class Mesh {
    public LinkedList<Triangle> triangles = new LinkedList<>();

    public Mesh(Triangle... triangles){
        if (triangles != null){
            for (Triangle triangle : triangles){
                this.triangles.add(triangle);
            }
        }
    }

    public Mesh(LinkedList<Triangle> triangles){
        if (triangles != null){
            for (Triangle triangle : triangles){
                this.triangles.add(triangle);
            }
        }
    }

    public void add(Triangle triangle){
        triangles.add(triangle);
    }
}
