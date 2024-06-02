package edu.usd;

import java.util.ArrayList;

public class Text extends Rectangle {
    private static final String fontFile = "./textures/text_texture.png";
    private ArrayList<Rectangle> characters = new ArrayList<>();
    private int x, y;
    private int totalWidth, totalHeight;
    private String string;
    private double scale;
    private int padding;

    public Text(int x, int y, String text, double scale) {
        super(0, 0, 0, 0, new float[] {0f, 0f, 0f, 0f});
        // if no background color provided set background to be invisible
        super.setVisible(false);

        this.x = x;
        this.y = y;

        this.string = text;
        this.scale = scale;

        generateSprites();
    }

    public Text(int x, int y, String text, double scale, float[] backgroundColor) {
        // if provided a backgroundColor create a rectangle to be placed behind the text
        super(x, y, 0, 0, backgroundColor);

        this.x = x;
        this.y = y;

        this.string = text;
        this.scale = scale;
        // set our background x and y based on our padding
        generateSprites();

        // After we have calculated our totalWidth and totalHeight
        // from generateSprites() we can resize the backgrounds
        resizeBackground();
    }

    public void generateSprites() {
        int currentX = x;
        int currentY = y;
        // how big the text will be on the screen based on our scale factor
        int screenWidth = (int)(Constants.FONT_WIDTH*scale);
        int screenHeight = (int)(Constants.FONT_HEIGHT*scale);
        // we need to keep track of the largest line, as that determines our text's width;
        int maxWidth = 0;

        for (int i = 0; i < string.length(); i++) {
            int charIndex = (int)(string.charAt(i)) - 33;

            // valid character indices are 0-93 (ascii 33 - 126)
            if (charIndex >= 0 && charIndex <= 93) {
                characters.add(new Sprite(fontFile, Constants.FONT_WIDTH * charIndex, 0,
                        Constants.FONT_WIDTH, Constants.FONT_HEIGHT, currentX, currentY, screenWidth, screenHeight));
            } else if (string.charAt(i) == ' ') {
                // if it's a space we don't need to load any image, and the text will get offset below to
                // account for the space, so we do nothing
            } else if (string.charAt(i) == '\n') {
                // before resetting line x and y, keep track of our maxWidth
                if (currentX - x > maxWidth) {
                    maxWidth = currentX - x;
                }
                // if we see a newline, increase y by height of our chars and reset x, since we want to add
                // screenWidth to currentX every time, we set subtract screenWidth to account
                currentY += screenHeight;
                currentX = x - screenWidth;
            } else {
                System.out.println("Cannot display: " + string.charAt(i));
                // else it's a char we don't recognize, load a missing texture
                characters.add(new Sprite("./textures/test.png", currentX, currentY, screenWidth, screenHeight));
            }


            // once we create a character, offset the currentX by the width of the character
            currentX += screenWidth;
        }

        // currentX - startingX gives us the total width of the text
        totalWidth = Math.max(maxWidth, currentX - x);
        // since we don't add screenHeight by default, add the character height to get our total height
        totalHeight = (currentY - y)  + screenHeight;
    }

    // Resize background to fit text
    public void resizeBackground() {
        super.setWidth(totalWidth+padding);
        super.setHeight(totalHeight+padding);
    }

    @Override
    // override render to render all of our text sprites alongside the background
    public void render() {
        // render our background
        super.render();
        // render our text
        for (Rectangle s : characters) {
            s.render();
        }
    }

    public int getTotalWidth() {
        return totalWidth;
    }

    public int getTotalHeight() {
        return totalHeight;
    }

    public String getString() {
        return string;
    }

    public double getScale() {
        return scale;
    }

    public void setText(String s) {
        string = s;
        // when we set the text, we need to delete our old sprites and regenerate them
        characters.clear();
        generateSprites();
        // then we need to resize the background if we have one/if it's visible
        if(super.isVisible()) resizeBackground();
        // we need to re-mask the new chars, if we have a mask
        if(super.isMasked()) setMask(super.getMask());
    }

    @Override
    // Override setXY to move all our text sprites as well
    public void setXY(int x, int y) {
        // first delta's based on current pos
        int dX = x - this.x;
        int dY = y - this.y;

        // Move background
        super.setXY(x - (padding/2), y - (padding/2));
        // Update text x, y
        this.x = x;
        this.y = y;
        // Move all the text sprites
        for (Rectangle r : characters) {
            r.setXY(r.getX() + dX, r.getY() + dY);
        }
    }

    @Override
    // Override setMask to set a mask on all of our text sprites as well
    public void setMask(Rectangle r) {
        super.setMask(r);
        // set mask for each of our text sprites as well
        for (Rectangle s : characters) {
            s.setMask(r);
        }
    }

    public void setScale(float s) {
        scale = s;
        // if we change scale regenerate sprites and background
        characters.clear();
        generateSprites();
        resizeBackground();
    }
}
