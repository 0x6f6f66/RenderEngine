package com.hideaway.RenderEngine;

import com.hideaway.RenderEngine.graphics.render.figures.Figure;
import com.hideaway.RenderEngine.graphics.shapes.Cube;
import com.hideaway.RenderEngine.graphics.coordinates.Mesh;
import com.hideaway.RenderEngine.graphics.shapes.Icosahedron;

/**
 * new Figure(); is a renderable object which accepts a mesh of values. Behaviour of the mesh of values is defined
 * in the figure object itself. Behaviour is configurable on tick() or render() methods.
 *
 * Cube.getMesh() simply returns a mesh object, which has all the coordinate details of vertexes.
 *
 * new RenderEngine(); creates a game window in which the figure will render.
 *
 * @see Figure
 * @see Cube
 * @see Mesh
 * @see RenderEngine
 * */
public class Main {
    public static void main(String[] args){
        //New game window in which said figure will render
        new RenderEngine();
    }
}
