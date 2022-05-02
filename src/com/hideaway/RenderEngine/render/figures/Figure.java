package com.hideaway.RenderEngine.render.figures;

import com.hideaway.RenderEngine.RenderEngine;
import com.hideaway.RenderEngine.coordinates.Mesh;
import com.hideaway.RenderEngine.coordinates.Triangle;
import com.hideaway.RenderEngine.coordinates.Vertex;
import com.hideaway.RenderEngine.coordinates.matricies.*;
import com.hideaway.RenderEngine.render.Renderable;
import com.hideaway.RenderEngine.util.RenderHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Figure implements Renderable {
    private final Mesh mesh;
    private static double zOffset = 3.1d;
    private static double xOffset = 0.0d;
    private static double yOffset = 0.0d;

    public Figure(Mesh mesh){
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
    public void render(Graphics graphics){
        draw(mesh, graphics);
    }

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();

        double rotationStep = 0.01d;

        switch (keyCode) {
            //Rotate on X axis
            case KeyEvent.VK_X -> {
                RotationMatrixX.fTheta += rotationStep;
                RotationMatrixX.cosf = (double) Math.cos(RotationMatrixX.fTheta);
                RotationMatrixX.sinf = (double) Math.sin(RotationMatrixX.fTheta);
                System.out.println(RotationMatrixX.fTheta);
            }
            //Counter-Rotate on X axis
            case KeyEvent.VK_C -> {
                RotationMatrixX.fTheta -= rotationStep;
                RotationMatrixX.cosf = (double) Math.cos(RotationMatrixX.fTheta);
                RotationMatrixX.sinf = (double) Math.sin(RotationMatrixX.fTheta);
                System.out.println(RotationMatrixX.fTheta);
            }
            //Rotate on Y axis
            case KeyEvent.VK_E -> {
                RotationMatrixY.fTheta += rotationStep;
                RotationMatrixY.cosf = (double) Math.cos(RotationMatrixY.fTheta);
                RotationMatrixY.sinf = (double) Math.sin(RotationMatrixY.fTheta);
                System.out.println(RotationMatrixY.fTheta);
            }
            //Counter-Rotate on Y axis
            case KeyEvent.VK_Q -> {
                RotationMatrixY.fTheta -= rotationStep;
                RotationMatrixY.cosf = (double) Math.cos(RotationMatrixY.fTheta);
                RotationMatrixY.sinf = (double) Math.sin(RotationMatrixY.fTheta);
                System.out.println(RotationMatrixY.fTheta);
            }
            //Rotate on Z axis
            case KeyEvent.VK_Z -> {
                RotationMatrixZ.fTheta += rotationStep;
                RotationMatrixZ.cosf = (double) Math.cos(RotationMatrixZ.fTheta);
                RotationMatrixZ.sinf = (double) Math.sin(RotationMatrixZ.fTheta);
                System.out.println(RotationMatrixZ.fTheta);
            }
            //Counter-Rotate on Z axis
            case KeyEvent.VK_V -> {
                RotationMatrixZ.fTheta -= rotationStep;
                RotationMatrixZ.cosf = (double) Math.cos(RotationMatrixZ.fTheta);
                RotationMatrixZ.sinf = (double) Math.sin(RotationMatrixZ.fTheta);
                System.out.println(RotationMatrixZ.fTheta);
            }
            //Move Forwards
            case KeyEvent.VK_W -> {
                zOffset -= 0.2d;
                System.out.println("zOffset: " + zOffset);
            }
            //Move Backwards
            case KeyEvent.VK_S -> {
                zOffset += 0.2d;
            System.out.println("zOffset: " + zOffset);
            }
            //Move Left
            case KeyEvent.VK_A -> {
                xOffset += 0.05d;
                System.out.println("xOffset: " + xOffset);
            }
            //Move Right
            case KeyEvent.VK_D -> {
                xOffset -= 0.05d;
                System.out.println("xOffset: " + xOffset);
            }
            //Move Up
            case KeyEvent.VK_SPACE -> {
                yOffset += 0.05d;
                System.out.println("yOffset: " + yOffset);
            }
            //Move Down
            case KeyEvent.VK_SHIFT -> {
                yOffset -= 0.05d;
                System.out.println("yOffset: " + yOffset);
            }
            default -> System.out.println("Unused Key");
        }
    }

    public void keyReleased(KeyEvent e){
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

            //Offset x, y, z based on key logs, which creates movement.
            Triangle triTranslated = new Triangle(triRotatedZXY.getVer1(), triRotatedZXY.getVer2(), triRotatedZXY.getVer3());

            //Offset z
            triTranslated.getVer1().setZ(triTranslated.getVer1().getZ() + zOffset);
            triTranslated.getVer2().setZ(triTranslated.getVer2().getZ() + zOffset);
            triTranslated.getVer3().setZ(triTranslated.getVer3().getZ() + zOffset);


            Color red = Color.RED;
            Color white = Color.WHITE;
            Color yellow = Color.YELLOW;
            Color blue = Color.BLUE;

            Color color1 = white;
            Color color2 = red;

            //Temp, We're coloring verticies if they are out of our view (AKA, Z <= 0)
            if (triTranslated.getVer1().getZ() <= 0.0f){
                triTranslated.getVer1().setColor(color1);
            } else{
                triTranslated.getVer1().setColor(color2);
            }

            if (triTranslated.getVer2().getZ() <= 0.0f){
                triTranslated.getVer2().setColor(color1);
            } else {
                triTranslated.getVer2().setColor(color2);

            }

            if (triTranslated.getVer3().getZ() <= 0.0f){
                triTranslated.getVer3().setColor(color1);
            } else {
                triTranslated.getVer3().setColor(color2);
            }

            //Offset x
            triTranslated.getVer1().setX(triTranslated.getVer1().getX() + xOffset);
            triTranslated.getVer2().setX(triTranslated.getVer2().getX() + xOffset);
            triTranslated.getVer3().setX(triTranslated.getVer3().getX() + xOffset);

            //Offset y
            triTranslated.getVer1().setY(triTranslated.getVer1().getY() + yOffset);
            triTranslated.getVer2().setY(triTranslated.getVer2().getY() + yOffset);
            triTranslated.getVer3().setY(triTranslated.getVer3().getY() + yOffset);

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
            triProjected.getVer1().x *= 0.5f * (double)RenderEngine.width;
            triProjected.getVer1().y *= 0.5f * (double)RenderEngine.height;
            triProjected.getVer2().x *= 0.5f * (double)RenderEngine.width;
            triProjected.getVer2().y *= 0.5f * (double)RenderEngine.height;
            triProjected.getVer3().x *= 0.5f * (double)RenderEngine.width;
            triProjected.getVer3().y *= 0.5f * (double)RenderEngine.height;

            //Re-Set the color for each vertex, as it gets reset due to consructors
            triProjected.getVer1().setColor(triTranslated.getVer1().getColor());
            triProjected.getVer2().setColor(triTranslated.getVer2().getColor());
            triProjected.getVer3().setColor(triTranslated.getVer3().getColor());

            trianglesScaled.add(triProjected);
        }
        drawTriangles(trianglesScaled, graphics);
    }

    //This will actually draw the triangles onto the screen using graphics.drawLine()
    private static void drawTriangles(LinkedList<Triangle> triangles, Graphics graphics){
        for (Triangle triangle: triangles){
            graphics.setColor(triangle.getVer1().getColor());
            graphics.drawLine((int) triangle.getVer1().x, (int) triangle.getVer1().y, (int) triangle.getVer2().x, (int) triangle.getVer2().y);
            graphics.setColor(triangle.getVer2().getColor());
            graphics.drawLine((int) triangle.getVer2().x, (int) triangle.getVer2().y, (int) triangle.getVer3().x, (int) triangle.getVer3().y);
            graphics.setColor(triangle.getVer3().getColor());
            graphics.drawLine((int) triangle.getVer3().x, (int) triangle.getVer3().y, (int) triangle.getVer1().x, (int) triangle.getVer1().y);
            //graphics.setColor(Color.white);
            //graphics.fillPolygon(new int [] {(int) triangle.getVer1().x, (int) triangle.getVer2().x, (int) triangle.getVer3().x}, new int[] {(int) triangle.getVer1().y, (int) triangle.getVer2().y, (int) triangle.getVer3().y}, 3);
        }
    }
}
