package com.hideaway.RenderEngine.graphics.coordinates.matricies;

/**The Matrix defines a 4x4 matrix (which is essentially a nested 4x4 array). We have a static component projection,
 * which is a constant projection matrix that allows us to transform vertices in regards to our perspective.
 * */
public class Matrix {
    public float[][] mat4x4 = new float[4][4];
    public Matrix(float[][] floats){
        //Must take a maximum of 16 floating point numbers, because this is a 4x4 matrix.
        for (int i = 0; i <=3; i++){
            for (int l = 0; l <=3; l++){
                mat4x4[i][l] = floats[i][l];
            }
        }
    }
}
