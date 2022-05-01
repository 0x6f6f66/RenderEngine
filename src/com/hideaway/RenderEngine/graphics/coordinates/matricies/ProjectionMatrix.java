package com.hideaway.RenderEngine.graphics.coordinates.matricies;

import com.hideaway.RenderEngine.RenderEngine;

public class ProjectionMatrix extends Matrix {
    //Projection Matrix components.
    private static final double fNear = 0.1d;
    private static final double fFar = 1000d;
    private static final double q = fFar/(fFar - fNear);
    private static final double fFov = 90.0d;
    private static final double fAspectRatio = (double)RenderEngine.height / (double)RenderEngine.width;
    private static final double fFovRad = 1.0d / Math.tan(fFov * 0.5d);

    //The actual projection matrix which we can call from a static context of Matrix
    public static double[][] projection = {
            {fAspectRatio*fFovRad, 0, 0, 0},
            {0, fFovRad, 0, 0},
            {0, 0, q, 1},
            {0, 0, -fNear*q, 0},
    };

    public ProjectionMatrix() {
        super(projection);
    }
}
