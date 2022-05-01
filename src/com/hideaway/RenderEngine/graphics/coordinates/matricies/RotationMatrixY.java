package com.hideaway.RenderEngine.graphics.coordinates.matricies;

public class RotationMatrixY extends RotationMatrix{
    public static double fTheta = 0.0d;
    public static double cosf = Math.cos(fTheta);
    public static double sinf = Math.sin(fTheta);

    public RotationMatrixY() {
        super(new double[][] {
                {cosf,0,sinf,0},
                {0,1,0,0},
                {-sinf,0,cosf,0},
                {0,0,0,1},
        });
    }
}
