package com.hideaway.RenderEngine.graphics.coordinates.matricies;

public class RotationMatrixX extends RotationMatrix {
    public static float fTheta = 0;
    public static float cosf = (float) Math.cos(fTheta);
    public static float sinf = (float) Math.sin(fTheta);

    public RotationMatrixX() {
        super(new float[][] {
                {1,0,0,0},
                {0,cosf,-sinf,0},
                {0,sinf,cosf,0},
                {0,0,0,1},
        });
    }
}
