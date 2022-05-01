package com.hideaway.RenderEngine;

import com.hideaway.RenderEngine.graphics.render.Renderable;
import com.hideaway.RenderEngine.graphics.render.figures.Figure;
import com.hideaway.RenderEngine.graphics.render.figures.FigureTwo;
import com.hideaway.RenderEngine.graphics.shapes.Cube;
import com.hideaway.RenderEngine.graphics.shapes.CubeTwo;
import com.hideaway.RenderEngine.graphics.shapes.Icosahedron;
import com.hideaway.RenderEngine.util.Handler;
import com.hideaway.RenderEngine.util.KeyManager;
import com.hideaway.RenderEngine.util.Window;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class RenderEngine extends Canvas implements Runnable {
    public static final int width = 1400;
    public static final int height = 800;
    public final String title = "Render Engine o.o";
    private Figure figure;

    public RenderEngine(){
        addKeyListener(new KeyManager(this));
        //Creates a new game window with a set width, height and title.
        new Window(width, height, title, this);

        //Add figure we want to render
        this.figure = new Figure(Icosahedron.getMesh());
        new Figure(CubeTwo.getMesh());

        //this starts the main game loop, and we cant add objects to render AFTER the game loop has started.
        run();
    }

    /**
     * Main Game loop.
     */
    //Currently a simple while loop, but could be imporved to an actual game loop.
    @Override
    public void run() {
        while(true){
            try {
                render();
                tick();
                TimeUnit.MILLISECONDS.sleep(100); // Temp sleep function
            } catch (Exception e) {
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

    public void keyPressed(KeyEvent e){
        this.figure.keyPressed(e);
    }

    /**
     * Currently not being used
     * */
    public void keyReleased(KeyEvent e){

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
