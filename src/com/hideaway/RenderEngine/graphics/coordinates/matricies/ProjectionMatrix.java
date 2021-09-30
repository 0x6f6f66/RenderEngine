package com.hideaway.RenderEngine.graphics.coordinates.matricies;

import com.hideaway.RenderEngine.RenderEngine;

public class ProjectionMatrix extends Matrix {
    //Projection Matrix components.
    private static final float fNear = 0.1f;
    private static final float fFar = 1000f;
    private static final float q = fFar/(fFar - fNear);
    private static final float fFov = 90.0f;
    private static final float fAspectRatio = (float)RenderEngine.height / (float)RenderEngine.width;
    private static final float fFovRad = 1.0f / (float)Math.tan(fFov * 0.5f);

    //The actual projection matrix which we can call from a static context of Matrix
    public static float[][] projection = {
            {fAspectRatio*fFovRad, 0, 0, 0},
            {0, fFovRad, 0, 0},
            {0, 0, q, 1},
            {0, 0, -fNear*q, 0},
    };

    public ProjectionMatrix() {
        super(projection);
    }
}
