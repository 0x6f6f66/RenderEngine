package com.hideaway.RenderEngine.graphics.shapes;

import com.hideaway.RenderEngine.graphics.render.Renderable;
import com.hideaway.RenderEngine.util.Handler;

import java.awt.*;

public class Line implements Renderable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2){
        Handler.RenderList.add(this);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawLine(x1, y1, x2, y2);
    }
}
