package edu.usd;

public interface Clickable {
    public void update(int mouseX, int mouseY);
    public void click(int mouseX, int mouseY);
    public void release();
    public boolean isClicked();
}
