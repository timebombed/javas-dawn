package edu.usd;

public interface Hoverable {
    // things that are hoverable need to implement an update method that uses
    // mouse position to detect if it is hovered, and do something
    public void update(int mouseX, int mouseY);
}
