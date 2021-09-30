package com.hideaway.RenderEngine.graphics.coordinates.matricies;

public class RotationMatrixY extends RotationMatrix{
    public static float fTheta = 0.f;
    public static float cosf = (float) Math.cos(fTheta);
    public static float sinf = (float) Math.sin(fTheta);

    public RotationMatrixY() {
        super(new float[][] {
                {cosf,0,sinf,0},
                {0,1,0,0},
                {-sinf,0,cosf,0},
                {0,0,0,1},
        });
    }
}
