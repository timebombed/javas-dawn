package edu.usd;

public class TextBox extends Rectangle implements Scrollable {
    Text text;
    private int scrollMultiplier = 40;

    public TextBox(int x, int y, int width, int height, float[] color, Text text) {
        super(x, y, width, height, color);
        this.text = text;
        // move text inside box
        text.setXY(x, y);
        // If text is too large fit it to the box, call fitText()
        if (text.getTotalWidth() > this.getWidth()) fitText();
        // mask text by the box by default
        text.setMask(this);
    }

    public void setString(String newText) {
        text.setText(newText);
        // refit text if we need to
        if (text.getTotalWidth() > this.getWidth()) fitText();
    }

    @Override
    public void setXY(int x, int y) {
        int dX = x - getX();
        int dY = y - getY();

        super.setXY(x, y);
        // we do not want to modify scroll offset, so move text through relative values
        text.setXY(text.getX() + dX, text.getY() + dY);
    }

    @Override
    public void render() {
        super.render();
        if (isVisible()) text.render();
    }

    public void centerText() {
        text.setXY(getX() + getWidth()/2 - text.getTotalWidth()/2, getY() + getHeight()/2 - text.getTotalHeight()/2);
    }

    // Fit text within the width of the box by changing the text
    public void fitText() {
        int characterWidth = (int)(Constants.FONT_WIDTH*text.getScale());
        // calculate how many character can fit per line
        int charsPerLine = this.getWidth() / characterWidth;

        // modify string to add newlines where needed
        String originalString = text.getString();
        String modifiedString = "";

        // for each word in our string check if it can fit in the row and if not add a newline
        int currentLineLen = 0;
        for (String word : originalString.split("((?<=[ \n]))")) {
            // if this word would put us over the max line length, and we don't already have a newline, add a newline and reset counts
            if (currentLineLen + word.replace("\n", "").replace(" ", "").length() > charsPerLine) {
                modifiedString += "\n";
                currentLineLen = 0;
            }
            // if there is already a newline in our text, reset counts
            if (word.charAt(word.length() - 1) == '\n') {
                currentLineLen = 0;
            }

            currentLineLen += word.replace("\n", "").length(); // Don't include newlines in line length count
            modifiedString += word; // build up modifiedString
        }

        // change Text object to have our new text
        text.setText(modifiedString);
    }

    public void scroll(double dy) {
        int scrollAmount = (int)(dy * scrollMultiplier);

        // if scrolling up would move text past bottom of the box, snap to bottom
        if (text.getY() + text.getTotalHeight() + scrollAmount < getY() + getHeight()) {
            text.setXY(text.getX(), getY() + getHeight() - text.getTotalHeight());
        }
        // else, if scrolling down would move text past the top of the box, snap to top
        else if (text.getY() + scrollAmount > getY()) {
            text.setXY(text.getX(), getY());
        }
        // else, let user scroll
        else {
            text.setXY(text.getX(), text.getY() + scrollAmount);
        }
    }

    public Text getText() {
        return text;
    }
}
