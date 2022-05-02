package com.hideaway.RenderEngine.graphics.coordinates;

import java.awt.*;

public class Triangle {
    private Vertex ver1;
    private Vertex ver2;
    private Vertex ver3;
    public Vertex[] ver3d;

    public Triangle(Vertex ver1, Vertex ver2, Vertex ver3){
        this.ver1 = new Vertex(ver1.getX(), ver1.getY(), ver1.getZ());
        this.ver2 = new Vertex(ver2.getX(), ver2.getY(), ver2.getZ());
        this.ver3 = new Vertex(ver3.getX(), ver3.getY(), ver3.getZ());
        this.ver3d = new Vertex[]{this.ver1, this.ver2, this.ver3};
    }

    public Vertex getVer1(){
        return this.ver1;
    }

    public Vertex getVer2(){
        return this.ver2;
    }

    public Vertex getVer3(){
        return this.ver3;
    }
}
