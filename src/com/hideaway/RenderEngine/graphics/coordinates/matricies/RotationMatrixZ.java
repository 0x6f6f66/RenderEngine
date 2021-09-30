package com.hideaway.RenderEngine.graphics.coordinates.matricies;

public class RotationMatrixZ extends RotationMatrix {
    public static float fTheta = 0.f;
    public static float cosf = (float) Math.cos(fTheta);
    public static float sinf = (float) Math.sin(fTheta);

    public RotationMatrixZ() {
        super(new float[][] {
                {cosf,-sinf,0,0},
                {sinf,cosf,0,0},
                {0,0,1,0},
                {0,0,0,1},
        });
    }
}