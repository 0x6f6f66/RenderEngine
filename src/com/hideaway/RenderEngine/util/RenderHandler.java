package com.hideaway.RenderEngine.util;

import com.hideaway.RenderEngine.render.Renderable;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public static LinkedList<Renderable> RenderList = new LinkedList<>();

    //Invokes tick() method of each Renderable object that has been put in a RenderList
    public static void tick(){
        for (Renderable renderable : RenderList) {
            renderable.tick();
        }
    }

    //Invokes render() method of each Renderable object that has been put in a RenderList
    public static void render(Graphics graphics){
        for (Renderable renderable : RenderList) {
            renderable.render(graphics);
        }
    }
}

