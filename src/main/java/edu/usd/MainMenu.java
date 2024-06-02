package edu.usd;

public class MainMenu extends Menu {
    private MenuButton saves, settings, exitButton;
    private Sprite background, title;

    //Use the constructor to initialize the menu layout
    public MainMenu() {
        background = new Sprite("./textures/title_background.png", 0, 0, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1]);
        sprites.add(background);

        title = new Sprite("./textures/logo.png", Constants.WINDOW_SIZE[0]/2 - 1100/2, 100, 1100, 300);
        sprites.add(title);

        saves = new MenuButton("Saves", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 250/2, Constants.WINDOW_SIZE[1]/2 - 100/2, 250, 100, Constants.BROWN);
        clickables.add(saves);

        settings = new MenuButton("Settings", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 250/2, Constants.WINDOW_SIZE[1]/2 - 100/2 + 150, 250, 100, Constants.BROWN);
        clickables.add(settings);

        exitButton = new MenuButton("Exit", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 250/2, Constants.WINDOW_SIZE[1]/2 - 100/2 + 300, 250 , 100, Constants.BROWN);
        clickables.add(exitButton);
    }

    public void update() {
        if (!anyButtonPressed()) {
            pressed = false;
        }

        if (saves.isClicked() && !pressed) {
            pressed = true;
            events.add("switchMenu:save");
        } else if (settings.isClicked() && !pressed) {
            pressed = true;
            events.add("switchMenu:settings");
        } else if(exitButton.isClicked() && !pressed) {
            pressed = true;
            events.add("exit");
        }
    }
}
