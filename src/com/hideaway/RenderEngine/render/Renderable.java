package com.hideaway.RenderEngine.render;

import java.awt.*;

public interface Renderable {
    void tick();
    void render(Graphics graphics);
}
