package edu.usd;

import java.util.ArrayList;

public class ScrollingSelection extends Rectangle implements Scrollable {
    private ArrayList<MenuButton> options = new ArrayList<>();
    private int yOffset = 0;
    private int minScroll = 0;
    private int maxScroll = 0;
    private int padding;
    private int scrollMultiplier = 40;
    private int optionsHeight;

    public ScrollingSelection(int x, int y, int width, int height, float[] color, int padding) {
        super(x, y, width, height, color);
        this.padding = padding;
        optionsHeight = (padding * 2);
    }

    public void update() {
        // Move each button where it should go in the order of the list
        // where the top of the button list starts, give a padding from top of selection menu
        int yTotal = (int)(padding * 1.5);

        for (int i = 0; i < options.size(); i++) {
            MenuButton m = options.get(i);

            int x = getX() + (getWidth() - m.getWidth())/2;
            int y = getY() + yTotal;
            yTotal += m.getHeight() + padding;

            m.setXY(x, y + yOffset);
        }
    }

    public void addOption(MenuButton option) {
        options.add(option);
        // when we add an option to the list, set it to be masked by the menu
        option.setMask(this);

        // optionsHeight keeps track of the height of all the options combined
        optionsHeight += option.getHeight() + padding;
        minScroll = getHeight() - optionsHeight;
        // we only want to set minScroll if we have enough items to go past our bounds, e.g. when it would be negative
        if (minScroll > 0) {
            minScroll = 0;
        }
    }

    public void scroll(double dy) {
        int scrollAmount = (int)(dy * scrollMultiplier);
        // if adding the scrollAmount would set us over the min/max, set offset to the min/max
        if (yOffset + scrollAmount < minScroll) {
            yOffset = minScroll;
        } else if (yOffset + scrollAmount > maxScroll) {
            yOffset = maxScroll;
        } else if (yOffset >= minScroll && yOffset <= maxScroll) {
            yOffset += scrollAmount;
        }
    }

    public ArrayList<MenuButton> getOptions() {
        return options;
    }

}
