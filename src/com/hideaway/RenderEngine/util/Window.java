package com.hideaway.RenderEngine.util;

import com.hideaway.RenderEngine.RenderEngine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {
    public Window(int width, int height, String title, RenderEngine engine){
        //Actual Window creation methods
        JFrame frame = new JFrame(title);
        frame.setMinimumSize(new Dimension(width, height));
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(engine);
        frame.setVisible(true);
    }
}
