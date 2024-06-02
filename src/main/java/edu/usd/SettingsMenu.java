package edu.usd;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SettingsMenu extends Menu {
    private MenuButton returnButton;
    private MenuButton soundLeft, soundRight;
    private MenuButton musicLeft, musicRight;
    private MenuButton difficultyLeft, difficultyRight;
    private Text sound, music, difficulty;
    private int soundValue, musicValue, difficultyValue;
    private Sprite background;
    
    public SettingsMenu() {
        // Set up the layout for the menu
        background = new Sprite("./textures/setting_background.png", 0, 0, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1]);
        sprites.add(background);

        String soundLabel = "Sound";
        Text soundText = new Text(0, 0, soundLabel, 5);
        TextBox soundBox = new TextBox(Constants.WINDOW_SIZE[0]/2 - soundText.getTotalWidth()/2, 100, soundText.getTotalWidth(), soundText.getTotalHeight(), Constants.LIGHT_GRAY, soundText);
        sprites.add(soundBox);

        String musicLabel = "Music";
        Text musicText = new Text(0, 0, musicLabel, 5);
        TextBox musicBox = new TextBox(Constants.WINDOW_SIZE[0]/2 - musicText.getTotalWidth()/2, 400, musicText.getTotalWidth(), musicText.getTotalHeight(), Constants.LIGHT_GRAY, musicText);
        sprites.add(musicBox);

        String difficultyLabel = "Difficulty Level";
        Text difficultyText = new Text(0, 0, difficultyLabel, 5);
        TextBox difficultyBox = new TextBox(Constants.WINDOW_SIZE[0]/2 - difficultyText.getTotalWidth()/2, 700, difficultyText.getTotalWidth(), difficultyText.getTotalHeight(), Constants.LIGHT_GRAY, difficultyText);
        sprites.add(difficultyBox);

        soundLeft = new MenuButton("<", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 200, soundText.getTotalHeight() + 140, 100, 100, Constants.BROWN);
        soundLeft.moveText(35, 22);
        clickables.add(soundLeft);
        soundRight = new MenuButton(">", Constants.PALE, Constants.WINDOW_SIZE[0]/2 + 100, soundText.getTotalHeight() + 140, 100, 100, Constants.BROWN);
        soundRight.moveText(40, 22);
        clickables.add(soundRight);

        musicLeft = new MenuButton("<", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 200, musicText.getTotalHeight() + 440, 100, 100, Constants.BROWN);
        musicLeft.moveText(35, 22);
        clickables.add(musicLeft);
        musicRight = new MenuButton(">", Constants.PALE, Constants.WINDOW_SIZE[0]/2 + 100, musicText.getTotalHeight() + 440, 100, 100, Constants.BROWN);
        musicRight.moveText(40, 22);
        clickables.add(musicRight);

        difficultyLeft = new MenuButton("<", Constants.PALE, Constants.WINDOW_SIZE[0]/2 - 200, difficultyText.getTotalHeight() + 740, 100, 100, Constants.BROWN);
        clickables.add(difficultyLeft);
        difficultyLeft.moveText(35, 22);
        difficultyRight = new MenuButton(">", Constants.PALE, Constants.WINDOW_SIZE[0]/2 + 100, difficultyText.getTotalHeight() + 740, 100, 100, Constants.BROWN);
        difficultyRight.moveText(40, 22);
        clickables.add(difficultyRight);

        soundValue = 5;
        sound = new Text(0, 0, String.valueOf(soundValue), 5, Constants.WHITE);
        sound.setXY(Constants.WINDOW_SIZE[0]/2 - sound.getTotalWidth()/2, soundText.getTotalHeight() + 140);
        sprites.add(sound);

        musicValue = 5;
        music = new Text(0, 0, String.valueOf(musicValue), 5, Constants.WHITE);
        music.setXY(Constants.WINDOW_SIZE[0]/2 - music.getTotalWidth()/2, soundText.getTotalHeight() + 440);
        sprites.add(music);

        difficultyValue = 5;
        difficulty = new Text(0, 0, String.valueOf(difficultyValue), 5, Constants.WHITE);
        difficulty.setXY(Constants.WINDOW_SIZE[0]/2 - difficulty.getTotalWidth()/2, soundText.getTotalHeight() + 740);
        sprites.add(difficulty);

        returnButton = new MenuButton("<", Constants.PALE, 50, 50, 90, 90, Constants.BROWN);
        returnButton.moveText(30,17);
        clickables.add(returnButton);

        loadSettings();
    }

    @Override
    public void update() {
        if (!anyButtonPressed()) {
            pressed = false;
        }

        // Increment or decrement the values based on the button clicked
        if (soundLeft.isClicked() && !pressed) {
            pressed = true;

            if (soundValue > 0) {
                soundValue--;
                sound.setText(String.valueOf(soundValue));
            }
        }
        else if (soundRight.isClicked() && !pressed) {
            pressed = true;

            if (soundValue < 9) {
                soundValue++;
                sound.setText(String.valueOf(soundValue));
            }
        }
        else if (musicLeft.isClicked() && !pressed) {
            pressed = true;

            if (musicValue > 0) {
                musicValue--;
                music.setText(String.valueOf(musicValue));
            }
        }
        else if (musicRight.isClicked() && !pressed) {
            pressed = true;

            if (musicValue < 9) {
                musicValue++;
                music.setText(String.valueOf(musicValue));
            }
        }
        else if (difficultyLeft.isClicked() && !pressed) {
            pressed = true;

            if (difficultyValue > 0) {
                difficultyValue--;
                difficulty.setText(String.valueOf(difficultyValue));
            }
        }
        else if (difficultyRight.isClicked() && !pressed) {
            pressed = true;

            if (difficultyValue < 9) {
                difficultyValue++;
                difficulty.setText(String.valueOf(difficultyValue));
            }
        }
        else if (returnButton.isClicked() && !pressed) {
            // return back to main menu
            pressed = true;
            saveSettings(soundValue, musicValue, difficultyValue);
            events.add("switchMenu:main");
        }
    }

    private void loadSettings() {
        // Load the current settings
        try{
            File settings = new File("./settingsfile/settings.txt");
            Scanner reader = new Scanner(settings);
            
            soundValue = Integer.parseInt(reader.nextLine());
            musicValue = Integer.parseInt(reader.nextLine());
            difficultyValue = Integer.parseInt(reader.nextLine());

            sound.setText(String.valueOf(soundValue));
            music.setText(String.valueOf(musicValue));
            difficulty.setText(String.valueOf(difficultyValue));
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    private void saveSettings(int sound, int music, int difficulty) {
        // Save the current settings in a text file
        try {
            FileWriter writer = new FileWriter("./settingsfile/settings.txt");
            writer.write(String.valueOf(sound) + "\n");
            writer.write(String.valueOf(music) + "\n");
            writer.write(String.valueOf(difficulty) + "\n");
            writer.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
