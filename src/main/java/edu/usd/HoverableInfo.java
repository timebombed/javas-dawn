package edu.usd;

public class HoverableInfo extends Rectangle implements Hoverable, Scrollable {
    TextBox infoBox;

    public HoverableInfo(int x, int y, int width, int height, float[] color, String infoString) {
        super(x, y, width, height, color);

        // create our info box
        infoBox = new TextBox(0, 0, 300, 200, new float[]{1f, 1f, 1f, 0.5f}, new Text(0, 0, infoString, 2));
        infoBox.setVisible(false);
        // Set the text within our textbox to get masked
        infoBox.getText().setMask(infoBox);
    }

    // Alternate constructor gives option to make any Rectangle object display info by setting rect to clear
    // and setting its x, y, width, height to follow the Rectangle type object
    public HoverableInfo(Rectangle bg, String infoString) {
        // we don't want our parent rectangle displaying, rather keep it transparent and use parameter as a background
        super(bg.getX(), bg.getY(), bg.getWidth(), bg.getHeight(), Constants.TRANSPARENT);

        // create our info box
        infoBox = new TextBox(0, 0, 275, 200, new float[]{0.95f, 0.95f, 0.95f, 0.8f}, new Text(0, 0, infoString, 2));
        infoBox.setVisible(false);
        // Set the text within our textbox to get masked
        infoBox.getText().setMask(infoBox);
    }

    public void update(int mouseX, int mouseY) {
        // If we hover, display our info box and have it follow the mouse pos
        if (isColliding(mouseX, mouseY)) {
            // offset by 30 so user can read the text without mouse blocking
            infoBox.setXY(mouseX + 30, mouseY);
            // if infoText is going off the right side of the screen, have it flip to the left side of the mouse instead
            if (infoBox.getX() + infoBox.getWidth() > Constants.WINDOW_SIZE[0]) {
                infoBox.setXY(mouseX - infoBox.getWidth() - 30, mouseY);
            }
            // if infoText going off bottom of screen, flip to be above the mouse instead
            if (infoBox.getY() + infoBox.getHeight() > Constants.WINDOW_SIZE[1]) {
                infoBox.setXY(infoBox.getX(), mouseY - infoBox.getHeight());
            }

            // reset the mask based on infoBox's new coords
            infoBox.getText().setMask(infoBox);
            if (!infoBox.isVisible()) infoBox.setVisible(true);
        }
        // otherwise the info should be invisible
        else {
            if (infoBox.isVisible()) infoBox.setVisible(false);
        }

        // at the end of update render our box and then the info on top
        render();
        infoBox.render();
    }

    public void scroll(double dy) {
        // since our infoBox is offset from the mouse, the mouse will never hover the TextBox for the user to scroll
        // so instead if the user "scrolls" the HoverableInfo, it will just call the scroll method of the TextBox
        infoBox.scroll(dy);
    }

    public TextBox getTextBox() {
        return infoBox;
    }
}
