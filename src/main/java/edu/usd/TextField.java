package edu.usd;

public class TextField extends Rectangle implements Clickable {
    private boolean selected = true;
    private boolean clicked = false;
    String input;
    Text text;
    Rectangle background;

    public TextField(int x, int y, double textScale, int textCharLength, float[] color) {
        super(x, y, 0, 0, color);
        input = "";
        text = new Text(x, y, input, 4);
        // Set height of the TextField based on text scale
        super.setHeight(text.getTotalHeight());
        // Set width of the TextField based on textLength parameter
        super.setWidth(Constants.FONT_WIDTH * (int)(textScale * textCharLength));
        // Set the text to be masked by the TextField
        text.setMask(this);
    }

    public TextField(int x, int y, double textScale, int textCharLength, float[] color, float[] backgroundColor, int bgPadding) {
        super(x, y, 0, 0, color);
        input = "";
        text = new Text(x, y, input, 4);
        // Set height of the TextField based on text scale
        super.setHeight(text.getTotalHeight());
        // Set width of the TextField based on textLength parameter
        super.setWidth(Constants.FONT_WIDTH * (int)(textScale * textCharLength));
        // Set the text to be masked by the TextField
        text.setMask(this);
        // setup background
        background = new Rectangle(x - bgPadding/2, y - bgPadding/2, getWidth() + bgPadding, getHeight() + bgPadding, backgroundColor);
    }

    public void inputCharacter(char c) {
        // if character is backspace (08 ASCII code), remove last char from input
        if ((int)c == 8) {
            // only backspace if input has text
            if (!input.isEmpty()) input = input.substring(0, input.length() - 1);
        } else {
            // Else add the input char to our input string
            input += c;
        }
        // Update the text
        updateText();
    }

    public String getString() {
        return input;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public void render() {
        // if we have a background render it
        if(background != null) background.render();
        // render the TextField
        super.render();
        // render our text
        text.render();
    }

    public void updateText() {
        //change the text
        text.setText(input);

        // if text width is wider than our current width, move end of text to the end of our TextField
        int overflow_size = text.getTotalWidth() - getWidth();
        if (overflow_size > 0) {
            text.setXY(getX() - overflow_size, getY());
        }
        // if we no longer have overflow, reset text position
        else {
            text.setXY(getX(), getY());
        }
    }

    @Override
    public void setXY(int x, int y) {
        int dx = x - super.getX();
        int dy = y - super.getY();

        super.setXY(x, y);
        text.setXY(x, y);
        background.setXY(background.getX() + dx, background.getY() + dy);
    }

    public void setText(String text) {
        input = text;
        updateText();
    }

    @Override
    public void update(int mouseX, int mouseY) {
        render();
    }

    @Override
    public void click(int mouseX, int mouseY) {
        // if the user clicks on field select, else, deselect
        selected = super.isColliding(mouseX, mouseY);
    }

    @Override
    public void release() {
        clicked = false;
    }

    @Override
    public boolean isClicked() {
        return clicked;
    }
}
