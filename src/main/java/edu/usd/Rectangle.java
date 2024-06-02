package edu.usd;

import java.io.Serializable;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glVertex2i;

public class Rectangle implements Serializable {
    private static final long serialVersionUID = 7L;
    private int x, y, width, height;
    private int maskX, maskY, maskW, maskH;
    private float[] color;
    private float[] defaultColor;
    private boolean isVisible = true;
    private boolean isMasked = false;
    private Rectangle mask;

    public Rectangle(int x, int y, int width, int height, float[] color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        defaultColor = color;
        maskX = 0;
        maskY = 0;
        maskW = 0;
        maskH = 0;
    }

    // Use openGL to draw our rectangle
    public void drawQuad() {
        glBegin(GL_QUADS);
            if (color.length == 3) glColor3f(color[0], color[1], color[2]);
            // if our color has an alpha component we use the 4 parameter method instead
            else if (color.length == 4) glColor4f(color[0], color[1], color[2], color[3]);

            glVertex2i(x, y);
            glVertex2i(x + width, y);
            glVertex2i(x + width, y + height);
            glVertex2i(x, y+height);
        glEnd();
    }

    public void render() {
        // if not visible, do nothing during render call
        if (!isVisible) return;

        // If a mask is applied, enable it before drawing our quad
        if (isMasked) {
            glEnable(GL_SCISSOR_TEST);
            glScissor(maskX, maskY, maskW, maskH);
        }
        // If we have alpha, enable blending before we draw the quad
        if (color.length == 4) {
            glEnable(GL_BLEND);
            glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        }

        drawQuad();

        // Disable the mask after we draw the image
        if (isMasked) {
            glDisable(GL_SCISSOR_TEST);
        }
        // Disable blending after we draw
        if (color.length == 4) {
            glDisable(GL_BLEND);
        }
    }

    public boolean isColliding(int x, int y) {
        if (isMasked) {
            // If masked, limit by the visible potions of the rectangle based on the mask
            return (y >= Math.max(this.y, mask.getY()) && y <= Math.min(mask.getY() + maskH, this.y + height)) && (x >= Math.max(this.x, maskX) && x <= Math.min(maskX + maskW, this.x + width));
        }

        return (x >= this.x && x <= this.x + width) && (y >= this.y && y <= this.y + height);
    }

    public boolean isMasked() {
        return isMasked;
    }

// Getter methods
    public Rectangle getMask() {
        return mask;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float[] getDefaultColor() {
        return defaultColor;
    }

    public boolean isVisible() {
        return isVisible;
    }

// Setter methods
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setVisible(boolean v) {
        isVisible = v;
    }

    public void setColor(float[] color) {
        this.color = color;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    /**
     * Allow a rectangle to be masked by another rectangle, only render current rectangle when it is inside the other
     * if null is passed as a parameter, reset the mask to 0
     */
    public void setMask(Rectangle r) {
        if (r != null) {
            maskX = r.getX();
            // OpenGL uses bottom left for origin in the scissor test instead of top right as is typical, so transform
            maskY = Constants.WINDOW_SIZE[1] - (r.getY() + r.getHeight());
            maskW = r.getWidth();
            maskH = r.getHeight();

            mask = r;
            isMasked = true;
        } else {
            maskX = 0;
            maskY = 0;
            maskW = 0;
            maskH = 0;

            mask = null;
            isMasked = false;
        }
    }
}
