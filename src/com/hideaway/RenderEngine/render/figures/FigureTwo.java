package com.hideaway.RenderEngine.render.figures;

import com.hideaway.RenderEngine.RenderEngine;
import com.hideaway.RenderEngine.coordinates.Mesh;
import com.hideaway.RenderEngine.coordinates.Triangle;
import com.hideaway.RenderEngine.coordinates.Vertex;
import com.hideaway.RenderEngine.coordinates.matricies.ProjectionMatrix;
import com.hideaway.RenderEngine.coordinates.matricies.RotationMatrixZ;
import com.hideaway.RenderEngine.render.Renderable;
import com.hideaway.RenderEngine.util.RenderHandler;

import java.awt.*;
import java.util.LinkedList;

/**
 * This is a temporary class to test how two objects with differently defined tick() and render() methods behave
 * alongside each other.
 * */
@Deprecated
public class FigureTwo implements Renderable {
    public Mesh mesh;

    public FigureTwo(Mesh mesh){
        RenderHandler.RenderList.add(this); //adds this to be rendered by the rendered
        this.mesh = mesh;
    }

    /**
     * Get's called on every tick update.
     * */
    @Override
    public void tick() {
    }

    /**
     * Get's called on every render update.
     * */
    @Override
    public void render(Graphics graphics) {
        draw(mesh, graphics);
    }

    //Actually draw the thing (temp)
    private static void draw(Mesh mesh, Graphics graphics){
        LinkedList<Triangle> trianglesScaled = new LinkedList<>();
        for(Triangle triangle: mesh.triangles){

            Triangle triRotatedZ = new Triangle(
                    Vertex.MultiplyMatrixVector(triangle.getVer1(), new RotationMatrixZ()),
                    Vertex.MultiplyMatrixVector(triangle.getVer2(), new RotationMatrixZ()),
                    Vertex.MultiplyMatrixVector(triangle.getVer3(), new RotationMatrixZ())
            );

            //Offset by z by n amount. (in this case 2.0f)
            Triangle triTranslated = new Triangle(triRotatedZ.getVer1(), triRotatedZ.getVer2(), triRotatedZ.getVer3());
            triTranslated.getVer1().setZ(triTranslated.getVer1().getZ() + 2.0f);
            triTranslated.getVer2().setZ(triTranslated.getVer2().getZ() + 2.0f);
            triTranslated.getVer3().setZ(triTranslated.getVer3().getZ() + 2.0f);

            Triangle triProjected = new Triangle(
                    Vertex.MultiplyMatrixVector(triTranslated.getVer1(), new ProjectionMatrix()),
                    Vertex.MultiplyMatrixVector(triTranslated.getVer2(), new ProjectionMatrix()),
                    Vertex.MultiplyMatrixVector(triTranslated.getVer3(), new ProjectionMatrix())
            );

            //Scale into view
            triProjected.getVer1().setX(triProjected.getVer1().getX() + 1f);
            triProjected.getVer1().setY(triProjected.getVer1().getY() + 1f);
            triProjected.getVer2().setX(triProjected.getVer2().getX() + 1f);
            triProjected.getVer2().setY(triProjected.getVer2().getY() + 1f);
            triProjected.getVer3().setX(triProjected.getVer3().getX() + 1f);
            triProjected.getVer3().setY(triProjected.getVer3().getY() + 1f);

            //Adjust for screen width and height
            triProjected.getVer1().x *= 0.5f * (float)RenderEngine.width;
            triProjected.getVer1().y *= 0.5f * (float)RenderEngine.height;
            triProjected.getVer2().x *= 0.5f * (float)RenderEngine.width;
            triProjected.getVer2().y *= 0.5f * (float)RenderEngine.height;
            triProjected.getVer3().x *= 0.5f * (float)RenderEngine.width;
            triProjected.getVer3().y *= 0.5f * (float)RenderEngine.height;

            trianglesScaled.add(triProjected);
        }
        drawTriangle(trianglesScaled, graphics);
    }

    private static void drawTriangle(LinkedList<Triangle> triangles, Graphics graphics){
        for (Triangle triangle: triangles){
            //graphics.setColor(Color.white);
            //graphics.fillPolygon(new int [] {(int) triangle.ver1.x, (int) triangle.ver2.x, (int) triangle.ver3.x}, new int[] {(int) triangle.ver1.y, (int) triangle.ver2.y, (int) triangle.ver3.y}, 3);
            graphics.setColor(Color.RED);
            graphics.drawLine((int) triangle.getVer1().x, (int) triangle.getVer1().y, (int) triangle.getVer2().x, (int) triangle.getVer2().y);
            graphics.setColor(Color.GREEN);
            graphics.drawLine((int) triangle.getVer2().x, (int) triangle.getVer2().y, (int) triangle.getVer3().x, (int) triangle.getVer3().y);
            graphics.setColor(Color.BLUE);
            graphics.drawLine((int) triangle.getVer3().x, (int) triangle.getVer3().y, (int) triangle.getVer1().x, (int) triangle.getVer1().y);
        }
    }
}

