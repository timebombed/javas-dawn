package edu.usd;

import java.util.ArrayList;

public abstract class Menu {
    ArrayList<Rectangle> sprites = new ArrayList<>();
    ArrayList<Clickable> clickables = new ArrayList<>();
    ArrayList<Scrollable> scrollables = new ArrayList<>();
    ArrayList<Hoverable> hoverables = new ArrayList<>();
    ArrayList<TextField> textFields = new ArrayList<>();

    ArrayList<String> events = new ArrayList<>();
    boolean pressed = false;

    public abstract void update();

    // One update method to run all the UI related updates (e.g. updates that require mouse pos)
    public void updateUI(int mouseX, int mouseY) {
        updateClickables(mouseX, mouseY);
        updateHovers(mouseX, mouseY);
    }

    public void updateClickables(int mouseX, int mouseY) {
        for (Clickable c : clickables) {
            c.update(mouseX, mouseY);
        }
    }

    public void updateHovers(int mouseX, int mouseY) {
        for (Hoverable h : hoverables) {
            h.update(mouseX, mouseY);
        }
    }

    public void clickEvent(int mouseX, int mouseY) {
        //when there is a click, set any button that collides with the mouse
        for (Clickable c : clickables) {
            c.click(mouseX, mouseY);
        }
    }

    public void unclickEvent() {
        for (Clickable c : clickables) {
            c.release();
        }
    }

    // return true if any of the buttons are pressed, otherwise return false
    public boolean anyButtonPressed() {
        boolean any_pressed = false;
        for (Clickable c : clickables) {
            any_pressed = any_pressed || c.isClicked();
        }
        return any_pressed;
    }

    public void scrollEvent(double dy, int mouseX, int mouseY) {
        for (Scrollable s : scrollables) {
            if (s.isColliding(mouseX, mouseY)) {
                s.scroll(dy);
            }
        }
    }

    public void textInputEvent(char inputChar) {
        for (TextField t : textFields) {
            if (t.isSelected()) {
                t.inputCharacter(inputChar);
            }
        }
    }

    public void backspaceEvent() {
        for (TextField t : textFields) {
            if (t.isSelected()) {
                t.inputCharacter((char)8);
            }
        }
    }

    public void renderSprites() {
        for (Rectangle r : sprites) {
            // only render sprites that are on screen (with padding of 100), save on performance
            boolean withinX = r.getX() < Constants.WINDOW_SIZE[0] + 100 && r.getX() + r.getWidth() > -100;
            boolean withinY = r.getY() < Constants.WINDOW_SIZE[1] + 100 && r.getY() + r.getHeight() > -100;
            if (withinX && withinY) {
                r.render();
            }
        }
    }

    // Once we handle all the events from our list we need to clear it so they do not handled twice
    public void clearEvents() {
        events.clear();
    }

    public ArrayList<String> getWindowEvents() {
        return events;
    }
}
