package com.hideaway.RenderEngine.coordinates.matricies;

public class RotationMatrixX extends RotationMatrix {
    public static double fTheta = 0.0d;
    public static double cosf = Math.cos(fTheta);
    public static double sinf = Math.sin(fTheta);

    public RotationMatrixX() {
        super(new double[][] {
                {1,0,0,0},
                {0,cosf,-sinf,0},
                {0,sinf,cosf,0},
                {0,0,0,1},
        });
    }
}
