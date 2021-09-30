package com.hideaway.RenderEngine;

import com.hideaway.RenderEngine.graphics.render.Renderable;
import com.hideaway.RenderEngine.util.Handler;
import com.hideaway.RenderEngine.util.Window;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.concurrent.TimeUnit;

public class RenderEngine extends Canvas implements Runnable {
    public static final int width =750;
    public static final int height = 750;
    public final String title = "Render Engine o.o";

    public RenderEngine(){
        //Creates a new game window with a set width, height and title.
        new Window(width, height, title, this);

        //this starts the main game loop, and we cant add objects to render AFTER the game loop has started.
        run();
    }

    /**
     * Main Game loop.
     */
    //Currently a simple while loop, but could be imporved to an actual gam loop.
    @Override
    public void run() {
        while(true){
            try {
                render();
                tick();
                TimeUnit.MILLISECONDS.sleep(0); // Temp sleep function
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *  Tick method, invokes Handler.tick() which invokes each tick() method of a Renderable object.
     * @see Handler
     * @see Renderable
     */
    public  void tick(){
        Handler.tick();
    }

    /**
     * Render method, invokes Handler.render() which invokes each render() method of a Renderable object.
     * @see Handler
     * @see Renderable
     */
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
        do {
            this.createBufferStrategy(3);
            bs = this.getBufferStrategy();
            } while (bs == null);
        }
        Graphics graphics = bs.getDrawGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,width,height);
        Handler.render(graphics);
        graphics.dispose();
        bs.show();
    }
}
