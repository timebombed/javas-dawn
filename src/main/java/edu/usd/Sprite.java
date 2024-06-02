package edu.usd;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.opengl.GL11.*;

public class Sprite extends Rectangle {
    private String textureFile;
    private int textureId;
    private int textureX, textureY, textureW, textureH;

    public Sprite(String textureFile, int textureX, int textureY, int textureW, int textureH, int x, int y, int width, int height) {
        super(x, y ,width, height, Constants.WHITE);
        this.textureX = textureX;
        this.textureY = textureY;
        this.textureW = textureW;
        this.textureH = textureH;
        this.textureFile = textureFile;

        loadTexture(textureFile);
    }

    // If we want to use the whole image as a sprite, and not specify an area in the image
    public Sprite(String textureFile, int x, int y, int width, int height) {
        super(x, y ,width, height, Constants.WHITE);
        this.textureFile = textureFile;

        loadTexture(textureFile);
    }

    private ByteBuffer imageToByteBuffer(String filename) {
        ByteBuffer pixels = null;

        try {
            BufferedImage imageBuffer = ImageIO.read(new File(filename));
            // if provided a width and height to crop by we get a subimage of our complete texture
            if (textureW != 0 && textureH != 0) {
                    imageBuffer = imageBuffer.getSubimage(textureX, textureY, textureW, textureH);
            } else {
                // else we set the width and height to the full image width and height
                textureW = imageBuffer.getWidth();
                textureH = imageBuffer.getHeight();
            }

            // create an array to store the image data, which includes x,y, and rgba value
            int[] pixelData = imageBuffer.getRGB(0, 0, textureW, textureH, null, 0, textureW);

            pixels = BufferUtils.createByteBuffer(textureW * textureH * 4);

            for (int i = 0; i < pixelData.length; i++) {
                int pixel = pixelData[i];

                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = (pixel) & 0xFF;
                int a = (pixel >> 24) & 0xFF;

                pixels.put((byte)(r));  // Red
                pixels.put((byte)(g));  // Green
                pixels.put((byte)(b));  // Blue
                pixels.put((byte)(a));   // Alpha
            }

            // OpenGL expects flipped pixel buffer
            pixels.flip();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pixels;
    }

    public void loadTexture(String filename) {
        // Create data buffers for our image
        ByteBuffer image = imageToByteBuffer(filename);

        // Load the image in openGL using our byte buffer
        // Generate texture id
        textureId = glGenTextures();

        // Bind textureId to a 2D texture after we create it
        glBindTexture(GL_TEXTURE_2D, textureId);
        // OpenGL texture parameters
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);

        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, textureW, textureH, 0, GL_RGBA, GL_UNSIGNED_BYTE, image);
    }

    @Override
    public void drawQuad() {
        glEnable(GL_TEXTURE_2D);
        // Enable alpha channel for texture transparency
        glEnable(GL_BLEND);
        glBlendFunc( GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA );

        // Before we draw, bind the textureId to drawing the correct we intend to
        glBindTexture(GL_TEXTURE_2D, textureId);

        // Draw the quad
        glBegin(GL_QUADS);
            glTexCoord2i(0, 0);
            glVertex2i(getX(), getY());

            glTexCoord2i(1, 0);
            glVertex2i(getX() + getWidth(), getY());

            glTexCoord2i(1, 1);
            glVertex2i(getX() + getWidth(), getY() + getHeight());

            glTexCoord2i(0, 1);
            glVertex2i(getX(), getY()+getHeight());
        glEnd();

        //Disable texture_2d when we are done to allow for us to continue to draw plain rectangles
        glDisable(GL_TEXTURE_2D);
        glDisable(GL_BLEND);
    }

    public String getTextureFile() {
        return textureFile;
    }

    public void reloadTexture() {
        loadTexture(textureFile);
    }
}
