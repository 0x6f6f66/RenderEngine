package com.hideaway.RenderEngine.graphics.render.figures;

import com.hideaway.RenderEngine.RenderEngine;
import com.hideaway.RenderEngine.graphics.coordinates.Mesh;
import com.hideaway.RenderEngine.graphics.coordinates.Triangle;
import com.hideaway.RenderEngine.graphics.coordinates.Vertex;
import com.hideaway.RenderEngine.graphics.coordinates.matricies.*;
import com.hideaway.RenderEngine.graphics.render.Renderable;
import com.hideaway.RenderEngine.util.Handler;
import java.awt.*;
import java.util.LinkedList;

public class Figure implements Renderable {
    private final Mesh mesh;
    RotationMatrixZ rotationMatrixZ = new RotationMatrixZ();
    RotationMatrixZ rotationMatrixX = new RotationMatrixZ();
    RotationMatrixZ rotationMatrixY = new RotationMatrixZ();

    public Figure(Mesh mesh){
        Handler.RenderList.add(this); //adds this to be rendered by the rendered
        this.mesh = mesh;
    }

    /**
     * Get's called on every tick update.
     * */
    @Override
    public void tick() {
        RotationMatrixZ.fTheta += 0.001f;
        RotationMatrixZ.cosf = (float) Math.cos(RotationMatrixZ.fTheta);
        RotationMatrixZ.sinf = (float) Math.sin(RotationMatrixZ.fTheta);
        RotationMatrixX.fTheta += 0.001f;
        RotationMatrixX.cosf = (float) Math.cos(RotationMatrixX.fTheta);
        RotationMatrixX.sinf = (float) Math.sin(RotationMatrixX.fTheta);
        RotationMatrixY.fTheta += 0.001f;
        RotationMatrixY.cosf = (float) Math.cos(RotationMatrixY.fTheta);
        RotationMatrixY.sinf = (float) Math.sin(RotationMatrixY.fTheta);
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

            Triangle triRotatedZX = new Triangle(
                    Vertex.MultiplyMatrixVector(triRotatedZ.getVer1(), new RotationMatrixX()),
                    Vertex.MultiplyMatrixVector(triRotatedZ.getVer2(), new RotationMatrixX()),
                    Vertex.MultiplyMatrixVector(triRotatedZ.getVer3(), new RotationMatrixX())
            );

            Triangle triRotatedZXY = new Triangle(
                    Vertex.MultiplyMatrixVector(triRotatedZX.getVer1(), new RotationMatrixY()),
                    Vertex.MultiplyMatrixVector(triRotatedZX.getVer2(), new RotationMatrixY()),
                    Vertex.MultiplyMatrixVector(triRotatedZX.getVer3(), new RotationMatrixY())
            );

            //Offset by z by n amount. (in this case 2.0f)
            Triangle triTranslated = new Triangle(triRotatedZXY.getVer1(), triRotatedZXY.getVer2(), triRotatedZXY.getVer3());
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

    //This will actually draw the triangles onto the screen using graphics.drawLine()
    private static void drawTriangle(LinkedList<Triangle> triangles, Graphics graphics){
        for (Triangle triangle: triangles){

            //graphics.setColor(Color.white);
            //graphics.fillPolygon(new int [] {(int) triangle.getVer1().x, (int) triangle.getVer2().x, (int) triangle.getVer3().x}, new int[] {(int) triangle.getVer1().y, (int) triangle.getVer2().y, (int) triangle.getVer3().y}, 3);
            graphics.setColor(Color.RED);
            graphics.drawLine((int) triangle.getVer1().x, (int) triangle.getVer1().y, (int) triangle.getVer2().x, (int) triangle.getVer2().y);
            graphics.setColor(Color.GREEN);
            graphics.drawLine((int) triangle.getVer2().x, (int) triangle.getVer2().y, (int) triangle.getVer3().x, (int) triangle.getVer3().y);
            graphics.setColor(Color.BLUE);
            graphics.drawLine((int) triangle.getVer3().x, (int) triangle.getVer3().y, (int) triangle.getVer1().x, (int) triangle.getVer1().y);
        }
    }
}
