package edu.usd;

public class MenuButton extends Rectangle implements Clickable {
    private boolean clicked = false;
    private boolean enabled = true;
    private Rectangle background;
    private Text text;

    public MenuButton(String string, int x, int y, int width, int height, float[] color) {
        super(x, y, width, height, color);

        if (!string.isEmpty()) {
            text = new Text(x, y, string, 3);
            // center text by default
            centerText();
        }
    }

    public MenuButton(String string, float[] stringColor, int x, int y, int width, int height, float[] color) {
        super(x, y, width, height, color);

        // set size of background based on size of button
        if (width < 100 || height < 100) {
            background = new Rectangle(x + 10, y + 10, width - 20, height - 20, stringColor);
        }
        else {
            background = new Rectangle(x + 15, y + 15, width - 30, height - 30, stringColor);
        }

        if (!string.isEmpty()) {
            text = new Text(x, y, string, 3);
            // center text by default
            centerText();
        }
    }

    public void update(int mouseX, int mouseY) {
        // click functionality
        float r = getDefaultColor()[0];
        float g = getDefaultColor()[1];
        float b = getDefaultColor()[2];

        // click functionality
        if (clicked) {
            float darken = 0.35f;
            setColor(new float[]{r - darken, g - darken, b - darken});

            if (background != null) {
                float[] paddingColors = background.getDefaultColor();
                background.setColor(new float[]{paddingColors[0] - darken, paddingColors[1] - darken, paddingColors[1] - darken});
            }
        }
        // hover functionality
        else if (isColliding(mouseX, mouseY)) {
            float darken = 0.20f;
            setColor(new float[]{r - darken, g - darken, b - darken});

            if (background != null) {
                float[] paddingColors = background.getDefaultColor();
                background.setColor(new float[]{paddingColors[0] - darken, paddingColors[1] - darken, paddingColors[1] - darken});
            }
        }
        // default functionality
        else {
            setColor(new float[]{r, g, b});

            if (background != null) {
                float[] paddingColors = background.getDefaultColor();
                background.setColor(new float[]{paddingColors[0], paddingColors[1], paddingColors[1]});
            }
        }

        render();
        displayBackground();
        displayText();
    }

    public boolean isClicked() {
        return clicked;
    }

    public void displayBackground() {
        if (background != null) {
            // render background if our button has a background
            background.render();
        }
    }

    public void displayText() {
        if (text != null) {
            // render text if our button has text
            text.render();
        }
    }

    public void click(int mouseX, int mouseY) {
        // if mouse position collides with button while clickButton is called
        if (isColliding(mouseX, mouseY) && enabled) {
            clicked = true;
        }
    }

    public void release() {
        clicked = false;
    }

    public Text getText() {
        return text;
    }

    // Center the text in the button
    public void centerText() {
        text.setXY(getX() + getWidth()/2 - text.getTotalWidth()/2, getY() + getHeight()/2 - text.getTotalHeight()/2);
    }

    // Left align text in the button, given a padding. Maintains text's y positioning
    public void leftAlignText(int leftPadding) {
        text.setXY(getX() + leftPadding, text.getY());
    }

    // Moves text within the button using relative coordinates ([0, 0] is the top left of the button, not the screen)
    public void moveText(int x, int y) {
        text.setXY(getX() + x, getY() + y);
    }

    // Since MenuButton needs to handle its button rectangle and the text, we need to apply these
    // transformations to both the button itself, and its text
    @Override
    public void setXY(int x, int y) {
        // save text's relative position in the button
        int textRelativeX = text.getX() - getX();
        int textRelativeY = text.getY() - getY();

        // move button
        super.setXY(x, y);

        // move background to same relative position
        if(background != null) {
            background.setXY(x + getWidth()/2 - background.getWidth()/2, y + getHeight()/2 - background.getHeight()/2);
        }

        // move text to same relative position
        text.setXY(x + textRelativeX, y + textRelativeY);
    }

    @Override
    public void setMask(Rectangle r) {
        super.setMask(r);
        if (background != null) {
            background.setMask(r);
        }
        text.setMask(r);
    }

    public void setEnabled(boolean e) {
        enabled = e;
    }
}
