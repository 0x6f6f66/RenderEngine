package com.hideaway.RenderEngine.util;

import com.hideaway.RenderEngine.RenderEngine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager extends KeyAdapter {
    private RenderEngine engine;

    public KeyManager(RenderEngine engine){
        this.engine = engine;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.engine.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.engine.keyReleased(e);
    }
}
