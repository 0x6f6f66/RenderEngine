package com.hideaway.RenderEngine.graphics.coordinates.matricies;

public class RotationMatrixX extends RotationMatrix {
    public static double fTheta = 0.0d;
    public static double cosf = (double) Math.cos(fTheta);
    public static double sinf = (double) Math.sin(fTheta);

    public RotationMatrixX() {
        super(new double[][] {
                {1,0,0,0},
                {0,cosf,-sinf,0},
                {0,sinf,cosf,0},
                {0,0,0,1},
        });
    }
}
