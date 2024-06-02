package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RectangleTest {
    // Tester Rectangle object.
    private Rectangle rectangle;
    
    // Creating new Rectangle object before every test.
    @BeforeEach
    void setUp(){
        rectangle = new Rectangle(0, 0, 0, 0, new float[] {0, 0, 0});
    }

    // Testing getter methods
    @Test
    @DisplayName("Testing getX")
    void getXTest(){
        assertEquals(0, rectangle.getX());
    }

    @Test
    @DisplayName("Testing getY")
    void getYTest(){
        assertEquals(0, rectangle.getY());
    }

    @Test
    @DisplayName("Testing getWidth")
    void getWidthTest(){
        assertEquals(0, rectangle.getWidth());
    }

    @Test
    @DisplayName("Testing getHeight")
    void getHeightTest(){
        assertEquals(0, rectangle.getHeight());
    }

    @Test
    @DisplayName("Testing isVisible")
    void isVisibleTest(){
        assertEquals(true, rectangle.isVisible());
    }

    // Testing setter methods
    @Test
    @DisplayName("Testing setXY")
    void setXYTest(){
        int x = 2;
        int y = 2;
        rectangle.setXY(x, y);
        assertEquals(x + y, rectangle.getX() + rectangle.getY());
    }

    @Test
    @DisplayName("Testing setVisible")
    void setVisibleTest(){
        boolean v = false;
        rectangle.setVisible(v);
        assertEquals(v, rectangle.isVisible());
    }

    @Test
    @DisplayName("Testing setWidth")
    void setWidthTest(){
        int w = 2;
        rectangle.setWidth(w);
        assertEquals(w, rectangle.getWidth());
    }

    @Test
    @DisplayName("Testing setHeight")
    void setHeightTest(){
        int h = 2;
        rectangle.setHeight(h);
        assertEquals(h, rectangle.getHeight());
    }
}
