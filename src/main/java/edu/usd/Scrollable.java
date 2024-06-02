package edu.usd;


public interface Scrollable {
    public void scroll(double dy);
    public boolean isColliding(int mouseX, int mouseY);
}
