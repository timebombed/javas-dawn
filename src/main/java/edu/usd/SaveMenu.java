package edu.usd;

import java.io.File;
import java.util.ArrayList;

public class SaveMenu extends Menu {
    private MenuButton newSave;
    private ScrollingSelection savesSelection;
    private Sprite background;
    private MenuButton returnButton;

    ArrayList<String> saveFiles = new ArrayList<>();

    public SaveMenu() {
        background = new Sprite("./textures/save_background.png", 0, 0, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[0]);
        sprites.add(background);

        savesSelection = new ScrollingSelection(250, 50, Constants.WINDOW_SIZE[0] - 500, Constants.WINDOW_SIZE[1] - 100, Constants.GRAY, 50);
        scrollables.add(savesSelection);
        sprites.add(savesSelection);

        returnButton = new MenuButton("<", Constants.PALE, 50, 50, 90, 90, Constants.BROWN);
        returnButton.moveText(30,17);
        clickables.add(returnButton);

        newSave = new MenuButton("New Save", 0, 0, 1200, 150, Constants.LAVENDER);
        newSave.leftAlignText(50);
        clickables.add(newSave);
        savesSelection.addOption(newSave);

        // Store all the filenames in the savefiles directory into our saveFiles list
        File saveDirectory = new File("./savefiles");
        File[] saves = saveDirectory.listFiles();
        for (File save : saves) {
            // only want .dat files
            if (save.getPath().substring(save.getPath().lastIndexOf(".")).equals(".dat")) saveFiles.add(save.getName());
        }

        // Add button to scroll menu for each filename
        for (String filename : saveFiles) {
            MenuButton saveFile = new MenuButton(filename.replaceAll(".dat", ""), Constants.PALE, 100, 100, 1200, 150, Constants.BROWN);
            saveFile.leftAlignText(50);
            clickables.add(saveFile);
            savesSelection.addOption(saveFile);
        }
    }

    @Override
    public void update() {
        savesSelection.update();

        if (!anyButtonPressed()) {
            pressed = false;
        }

        // return back to main menu
        if (returnButton.isClicked() && !pressed) {
            pressed = true;
            events.add("switchMenu:main");
        } else if (newSave.isClicked() && !pressed) {
            pressed = true;
            events.add("switchMenu:create,new");
        } else {
            // skip first option as it is the new save button
            for (int i = 1; i < savesSelection.getOptions().size(); i++) {
                if (savesSelection.getOptions().get(i).isClicked() && !pressed) {
                    pressed = true;
                    events.add("switchMenu:create,load," + saveFiles.get(i-1));
                }
            }
        }

    }
}
