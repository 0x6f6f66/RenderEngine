package com.hideaway.RenderEngine.graphics.coordinates;

import com.hideaway.RenderEngine.graphics.coordinates.matricies.Matrix;

/**
 * Vertex is a collection of 3 float coordinates: x, y, z.
 * */
public class Vertex {
    public float x;
    public float y;
    public float z;
    @Deprecated
    public float[] vec3d;

    public Vertex(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
        //this.vec3d = new float[]{x,y,z};
    }

    public Vertex(float... vertices){
        this.x = vertices[0];
        this.y = vertices[1];
        this.z = vertices[2];
        //this.vec3d = new float[]{vertices[0], vertices[1], vertices[2]};
    }

    public Vertex(){
        //this.vec3d = new float[3];
    }

    public void setX(float x){
        this.x = x;
        //this.vec3d[0] = x;
    }

    public void setY(float y){
        this.y = y;
        //this.vec3d[1] = y;
    }

    public void setZ(float z){
        this.z = z;
        //this.vec3d[2] = z;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }
    public float getZ(){
        return this.z;
    }

    /**
     * Vertex is essentially a 1x3 matrix (organised list of numbers), this function allows us to multiply each element
     * of the Vertex by each element in the Matrix (object), and outputs the result in form of a new Vertex.
     * Because Vertex is a 1x3 matrix, and Matrix (object) is a 4x4 matrix, we assume as if the Vertex had a forth element,
     * 1. We also collect a 4th variable w, as a sum of products of the 4th elements of the matrix, which we then use to
     * divide each element in the Vertex matrix. Thus transforming it into cartesian space.
     * @param input is the Vertex we wish to transform.
     * @param matrix is the Matrix we wish to use for our transformation
     * @return resulting Vertex from the Matrix multiplication.
     * @see Matrix
     */
    public static Vertex MultiplyMatrixVector(Vertex input, Matrix matrix){
        Vertex output = new Vertex();
        output.setX(input.x * matrix.mat4x4[0][0] + input.y * matrix.mat4x4[1][0] + input.z * matrix.mat4x4[2][0] + matrix.mat4x4[3][0]);
        output.setY(input.x * matrix.mat4x4[0][1] + input.y * matrix.mat4x4[1][1] + input.z * matrix.mat4x4[2][1] + matrix.mat4x4[3][1]);
        output.setZ(input.x * matrix.mat4x4[0][2] + input.y * matrix.mat4x4[1][2] + input.z * matrix.mat4x4[2][2] + matrix.mat4x4[3][2]);
        //Fourth, imaginary variable w.
        float w = (input.x * matrix.mat4x4[0][3] + input.y * matrix.mat4x4[1][3] + input.z * matrix.mat4x4[2][3] + matrix.mat4x4[3][3]);
        //Transformation into cartesian space.
        if (w != 0.0f){
            output.setX(output.x/w);
            output.setY(output.y/w);
            output.setZ(output.z/w);
        }
        return output;
    }

}
