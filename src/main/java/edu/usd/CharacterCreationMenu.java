package edu.usd;

import java.util.Arrays;

public class CharacterCreationMenu extends Menu {
    // Instance variables
    private float[] uiBackgroundColor = new float[] {0.45f, 0.45f, 0.45f, 0.9f};
    private MenuButton roleLeft, roleRight;
    private MenuButton helmetRight, helmetLeft;
    private MenuButton chestplateLeft, chestplateRight;
    private MenuButton bootsLeft, bootsRight;
    private MenuButton saveData, cancelButton;

    private Sprite background;
    private Rectangle nameRoleBox;
    private TextField nameInput;
    private Text roleText;
    private TextBox statsDisplay;
    private String stats = "";
    private Rectangle characterDisplayBg;
    private ScrollingSelection weaponSelect, accessorySelect;
    private Sprite characterDisplay, helmetDisplay, armorDisplay, bootsDisplay, weaponDisplay, accessoryDisplay;
    private HoverableInfo weaponInfo, accessoryInfo;

    private final AbstractCharacter[] roles = {new MarauderClass(GameConstants.marauderSprite), new WitchClass(GameConstants.witchSprite), new RangerClass(GameConstants.rangerSprite)};
    private final Helmet[] helmets = {GameConstants.ironHelmet, GameConstants.violatedGorbolHelmet, GameConstants.lausCap};
    private final BodyArmor[] chestplates = {GameConstants.kairosChestplate, GameConstants.violatedGorbolArmor, GameConstants.glicksSweater};
    private final Boots[] boots = {GameConstants.iceBoots, GameConstants.violatedGorbolBoots, GameConstants.glicksReeboks};
    private final Accessory[] accessories = {GameConstants.dailyBugle, GameConstants.markOfSubmission, GameConstants.powerOfFriendship};
    private final Weapon[] weapons = {GameConstants.poisonAxe, GameConstants.groggleWand, GameConstants.guardBreaker, GameConstants.magnoliasReckoning, GameConstants.longBow};

    private AbstractCharacter selectedRole = roles[0];
    private Helmet selectedHelmet = helmets[0];
    private BodyArmor selectedChestplate = chestplates[0];
    private Boots selectedBoots = boots[0];
    private Accessory selectedAccessory = accessories[0];
    private Weapon selectedWeapon = weapons[0];

    private boolean pressed;
    private boolean newSave = true;
    private Player player = new Player("", null, null , null, null);

    // Constructor for a new save
    public CharacterCreationMenu() {
        setupMenu();

        // set default value for name input
        nameInput.setText("Name");
        System.out.println("Character Creation Menu: New Save");
    }

    // Constructor for loading an existing save
    public CharacterCreationMenu(String filename) {
        setupMenu();
        newSave = false;
        // load up our player object
        System.out.println("Reading " + filename);
        player = SaveFile.readFile("./savefiles/" + filename);

        // since we are editing an existing save, set all the selected items to be what the player has equipped
        nameInput.setText(player.getName());
        selectedRole = player.getCharacterClass();
        selectedAccessory = player.getAccessory();
        selectedWeapon = player.getWeapon();
        Armor[] selectedArmor = player.getArmor();
        selectedHelmet = (Helmet) selectedArmor[0];
        selectedChestplate = (BodyArmor) selectedArmor[1];
        selectedBoots = (Boots) selectedArmor[2];

        // update all our ui elements
        updateAllUI();

        // reload sprites after reading file
        reloadTextures();

        System.out.println("Character Creation Menu: " + filename);
    }

    // Shared method to set up the basic creation menu
    public void setupMenu() {
        background = new Sprite("./textures/creation_background.png", 0, 0, Constants.WINDOW_SIZE[0], Constants.WINDOW_SIZE[1]);
        sprites.add(background);

        // Name and role select box
        nameRoleBox = new Rectangle(30, 175, 500, 200, uiBackgroundColor);
        sprites.add(nameRoleBox);

        roleLeft = new MenuButton("<", nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - (50/2) - 175, nameRoleBox.getY() + nameRoleBox.getHeight() - 80, 45, 40, Constants.WHITE);
        roleLeft.moveText(8, -7);
        roleRight = new MenuButton(">", nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - (50/2) + 175, nameRoleBox.getY() + nameRoleBox.getHeight() - 80, 45, 40, Constants.WHITE);
        roleRight.moveText(12, -7);
        clickables.add(roleLeft);
        clickables.add(roleRight);

        roleText = new Text(0, 0, selectedRole.getName(), 3);
        roleText.setXY(nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - roleText.getTotalWidth()/2, nameRoleBox.getY() + nameRoleBox.getHeight() - 85);
        sprites.add(roleText);

        nameInput = new TextField( 0, 0, 3.5, 15, Constants.WHITE, Constants.BLACK, 4);
        nameInput.setXY(nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - (nameInput.getWidth()/2), nameRoleBox.getY() + 30);
        textFields.add(nameInput);
        clickables.add(nameInput);

        // Stat display
        Text statText = new Text(0, 0, stats, 3, Constants.WHITE);
        statsDisplay = new TextBox(60, 410, 440, 480, uiBackgroundColor, statText);
        sprites.add(statsDisplay);
        updateStats();

        // Character Display
        characterDisplayBg = new Rectangle(0, 0, 550, 900, uiBackgroundColor);
        characterDisplayBg.setXY(Constants.WINDOW_SIZE[0]/2 - characterDisplayBg.getWidth()/2, Constants.WINDOW_SIZE[1]/2 - characterDisplayBg.getHeight()/2);
        sprites.add(characterDisplayBg);

        characterDisplay = new Sprite("./textures/test.png", 0, 0, 900, 900);
        sprites.add(characterDisplay);
        characterDisplay.setXY(Constants.WINDOW_SIZE[0]/2 - characterDisplay.getWidth()/2, Constants.WINDOW_SIZE[1]/2 - characterDisplay.getHeight()/2);
        characterDisplay = updateItemDisplay(selectedRole.getSprite(), characterDisplay);

        // Armor Selection
        helmetLeft = new MenuButton("<", (characterDisplayBg.getX() - 50) - 25, characterDisplayBg.getY() + 140, 50, 45, Constants.WHITE);
        helmetRight = new MenuButton(">", (characterDisplayBg.getX() + characterDisplayBg.getWidth()) + 25, characterDisplayBg.getY() + 140, 50, 45, Constants.WHITE);
        clickables.add(helmetLeft);
        clickables.add(helmetRight);

        helmetDisplay = new Sprite("./textures/test.png", 0, 0, 900, 900);
        sprites.add(helmetDisplay);
        helmetDisplay.setXY(characterDisplay.getX(), characterDisplay.getY());
        helmetDisplay = updateItemDisplay(selectedHelmet.getSprite(), helmetDisplay);

        chestplateLeft = new MenuButton("<", (characterDisplayBg.getX() - 50) - 25, characterDisplayBg.getY() + 450, 50, 45, Constants.WHITE);
        chestplateRight = new MenuButton(">", (characterDisplayBg.getX() + characterDisplayBg.getWidth()) + 25, characterDisplayBg.getY() + 450, 50, 45, Constants.WHITE);
        clickables.add(chestplateLeft);
        clickables.add(chestplateRight);

        armorDisplay = new Sprite("./textures/test.png", 0, 0, 900, 900);
        sprites.add(armorDisplay);
        armorDisplay.setXY(characterDisplay.getX(), characterDisplay.getY());
        armorDisplay = updateItemDisplay(selectedChestplate.getSprite(), armorDisplay);

        bootsLeft = new MenuButton("<", (characterDisplayBg.getX() - 50) - 25, characterDisplayBg.getY() + 700, 50, 45, Constants.WHITE);
        bootsRight = new MenuButton(">", (characterDisplayBg.getX() + characterDisplayBg.getWidth()) + 25, characterDisplayBg.getY() + 700, 50, 45, Constants.WHITE);
        clickables.add(bootsLeft);
        clickables.add(bootsRight);

        bootsDisplay = new Sprite("./textures/test.png", 0, 0, 900, 900);
        sprites.add(bootsDisplay);
        bootsDisplay.setXY(characterDisplay.getX(), characterDisplay.getY());
        bootsDisplay = updateItemDisplay(selectedBoots.getSprite(), bootsDisplay);

        // Weapon Selection
        Rectangle weaponAccessoryBg = new Rectangle(Constants.WINDOW_SIZE[0] - 530, Constants.WINDOW_SIZE[1] - 955, 500, 775, uiBackgroundColor);
        sprites.add(weaponAccessoryBg);

        weaponSelect = new ScrollingSelection(Constants.WINDOW_SIZE[0] - 505, 345, 450, 250, new float[] {0.3f, 0.3f, 0.3f}, 10);
        scrollables.add(weaponSelect);
        sprites.add(weaponSelect);

        for (Weapon w : weapons) {
            MenuButton weaponButton = new MenuButton(w.getNAME(), 0,0,375, 75, Constants.WHITE);
            // Format button
            weaponButton.getText().setScale(2);
            weaponButton.centerText();
            weaponButton.leftAlignText(15);
            clickables.add(weaponButton);
            weaponSelect.addOption(weaponButton);
        }


        // Accessory Selection
        accessorySelect = new ScrollingSelection(Constants.WINDOW_SIZE[0] - 505, 620, 450, 250, new float[] {0.3f, 0.3f, 0.3f}, 10);
        sprites.add(accessorySelect);
        scrollables.add(accessorySelect);

        for (Accessory a : accessories) {
            MenuButton accessoryButton = new MenuButton(a.getNAME(), 0,0,375, 75, Constants.WHITE);
            // Format button
            accessoryButton.getText().setScale(2);
            accessoryButton.centerText();
            accessoryButton.leftAlignText(15);
            clickables.add(accessoryButton);
            accessorySelect.addOption(accessoryButton);
        }

        // Weapon and Accessory Display
        weaponDisplay = new Sprite("./textures/test.png", weaponAccessoryBg.getX() + 30, weaponAccessoryBg.getY() + 30, 150, 150);
        sprites.add(weaponDisplay);
        weaponDisplay = updateItemDisplay(selectedWeapon.getSprite(), weaponDisplay);

        weaponInfo = new HoverableInfo(weaponDisplay, "");
        updateItemDescription(selectedWeapon, weaponInfo);
        hoverables.add(weaponInfo);
        scrollables.add(weaponInfo);


        accessoryDisplay = new Sprite("./textures/test.png", weaponAccessoryBg.getX() + 210, weaponAccessoryBg.getY() + 30, 150, 150);
        sprites.add(accessoryDisplay);
        accessoryDisplay = updateItemDisplay(selectedAccessory.getSprite(), accessoryDisplay);

        accessoryInfo = new HoverableInfo(accessoryDisplay, "");
        updateItemDescription(selectedAccessory, accessoryInfo);
        hoverables.add(accessoryInfo);
        scrollables.add(accessoryInfo);

        // Save button
        saveData = new MenuButton("Save\nCharacter", Constants.PALE, Constants.WINDOW_SIZE[0] - 417, Constants.WINDOW_SIZE[1] - 150, 275, 125, Constants.BROWN);
        clickables.add(saveData);

        // Cancel changes button
        cancelButton = new MenuButton("Cancel Changes", Constants.PALE, 50, 50, 400, 90, Constants.BROWN);
        clickables.add(cancelButton);
    }

    @Override
    public void update() {
        accessorySelect.update();
        weaponSelect.update();

        // if no button is pressed currently, reset pressed
        if (!anyButtonPressed()) {
            pressed = false;
        }

        // return back to main menu
        if (cancelButton.isClicked() && !pressed) {
            pressed = true;
            events.add("switchMenu:save");
        }

        // Role Select
        else if (roleLeft.isClicked() && !pressed) {
            pressed = true;
            selectedRole = roles[getAdjacentIndex(roles, selectedRole, -1)];
            roleText.setText(selectedRole.getName());
            // recenter text
            roleText.setXY(nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - roleText.getTotalWidth()/2, roleText.getY());

            updateStats();
            characterDisplay = updateItemDisplay(selectedRole.getSprite(), characterDisplay);
        } else if (roleRight.isClicked() && !pressed) {
            pressed = true;
            selectedRole = roles[getAdjacentIndex(roles, selectedRole, 1)];
            roleText.setText(selectedRole.getName());
            // recenter text
            roleText.setXY(nameRoleBox.getX() + (nameRoleBox.getWidth()/2) - roleText.getTotalWidth()/2, roleText.getY());

            updateStats();
            characterDisplay = updateItemDisplay(selectedRole.getSprite(), characterDisplay);
        }

        // Helmet Select
        else if (helmetLeft.isClicked() && !pressed) {
            pressed = true;
            selectedHelmet = helmets[getAdjacentIndex(helmets, selectedHelmet, -1)];

            updateStats();
            helmetDisplay = updateItemDisplay(selectedHelmet.getSprite(), helmetDisplay);
        } else if (helmetRight.isClicked() && !pressed) {
            pressed = true;
            selectedHelmet = helmets[getAdjacentIndex(helmets, selectedHelmet, 1)];

            updateStats();
            helmetDisplay = updateItemDisplay(selectedHelmet.getSprite(), helmetDisplay);
        }

        // BodyArmor Select
        else if (chestplateLeft.isClicked() && !pressed) {
            pressed = true;
            selectedChestplate = chestplates[getAdjacentIndex(chestplates, selectedChestplate, -1)];

            updateStats();
            armorDisplay = updateItemDisplay(selectedChestplate.getSprite(), armorDisplay);
        }
        else if (chestplateRight.isClicked() && !pressed) {
            pressed = true;
            selectedChestplate = chestplates[getAdjacentIndex(chestplates, selectedChestplate, 1)];

            updateStats();
            armorDisplay = updateItemDisplay(selectedChestplate.getSprite(), armorDisplay);
        }

        // Boots Select
        else if (bootsLeft.isClicked() && !pressed) {
            pressed = true;
            selectedBoots = boots[getAdjacentIndex(boots, selectedBoots, -1)];

            updateStats();
            bootsDisplay = updateItemDisplay(selectedBoots.getSprite(), bootsDisplay);
        } else if (bootsRight.isClicked() && !pressed) {
            pressed = true;
            selectedBoots = boots[getAdjacentIndex(boots, selectedBoots, 1)];

            updateStats();
            bootsDisplay = updateItemDisplay(selectedBoots.getSprite(), bootsDisplay);
        }



        else if (saveData.isClicked() && !pressed) {
            pressed = true;
            // Finalize all the "selected" stats/items to our player object
            setPlayerOptions();

            // Use the savefile class to save our player object to a file, second parameter is the overwrite flag,
            // and we want to overwrite our save if we are not making a new save (!newSave)
            SaveFile.saveFile(player, !newSave);

            // switch back to the saves menu
            events.add("switchMenu:save");
        } else {
            // Weapon Select
            for (int i = 0; i < weaponSelect.getOptions().size(); i++) {
                MenuButton m = weaponSelect.getOptions().get(i);
                if (m.isClicked() && !pressed) {
                    pressed = true;
                    selectedWeapon = weapons[i];

                    updateStats();
                    updateItemDescription(selectedWeapon, weaponInfo);
                    weaponDisplay = updateItemDisplay(selectedWeapon.getSprite(), weaponDisplay);
                }
            }

            // Accessory Select
            for (int i = 0; i < accessorySelect.getOptions().size(); i++) {
                MenuButton m = accessorySelect.getOptions().get(i);
                if (m.isClicked() && !pressed) {
                    pressed = true;
                    selectedAccessory = accessories[i];

                    updateStats();
                    updateItemDescription(selectedAccessory, accessoryInfo);
                    accessoryDisplay = updateItemDisplay(selectedAccessory.getSprite(), accessoryDisplay);
                }
            }
        }
    }

    private void setPlayerOptions() {
        player.setName(nameInput.getString());
        player.setWeapon(selectedWeapon);
        player.setAccessory(selectedAccessory);
        Armor[] selectedArmor = {selectedHelmet, selectedChestplate, selectedBoots};
        player.setArmor(selectedArmor);
        player.setCharacterClass(selectedRole);
    }

    private void updateStats() {
        // first set all currently selected options to our player class
        setPlayerOptions();
        // use the player class to calculate stats and set our stat String
        stats = "    Stats\n HP:    " + player.getTotalHealth() + " \n Mana:  " + player.getTotalMana() + "\n Eva:   " + player.getTotalEvasion() +
                "\n Def:   " + player.getTotalDefense() + "\n Str:   " + player.getTotalStrength() + "\n Int:   " + player.getTotalIntelligence() +
                "\n Dex:   " + player.getTotalDexterity();
        statsDisplay.setString(stats);
        statsDisplay.centerText();
    }

    private void updateItemDescription(ItemStats item, HoverableInfo h) {
        String s = "\"" + item.getNAME() + "\"\n\nBonus HP: " + item.getHEALTH() + "\nMana: " + item.getMANA() +
                "\nEvasion: " + item.getEVASION() + "\nDefense: " + item.getDEFENSE() + "\nStrength: " + item.getSTRENGTH() +
                "\nIntelligence: " + item.getINTELLIGENCE() + "\nDexterity: " + item.getDEXTERITY();
        h.getTextBox().setString(s);
    }

    private Sprite updateItemDisplay(Sprite updateSprite, Sprite displaySprite) {
        // transform our new sprite, updateSprite, and set it to match our displaySprite
        updateSprite.setWidth(displaySprite.getWidth());
        updateSprite.setHeight(displaySprite.getHeight());
        updateSprite.setXY(displaySprite.getX(), displaySprite.getY());
        // remove the old sprite from our render list, and replace it with our new sprite
        sprites.set(sprites.indexOf(displaySprite), updateSprite);
        // returns the new sprite so that we can update our display sprite
        return updateSprite;
    }

    private void updateAllUI() {
        updateStats();
        updateItemDescription(selectedAccessory, accessoryInfo);
        updateItemDescription(selectedWeapon, weaponInfo);
        characterDisplay = updateItemDisplay(selectedRole.getSprite(), characterDisplay);
        helmetDisplay = updateItemDisplay(selectedHelmet.getSprite(), helmetDisplay);
        armorDisplay = updateItemDisplay(selectedChestplate.getSprite(), armorDisplay);
        bootsDisplay = updateItemDisplay(selectedBoots.getSprite(), bootsDisplay);

        weaponDisplay = updateItemDisplay(selectedWeapon.getSprite(), weaponDisplay);
        accessoryDisplay = updateItemDisplay(selectedAccessory.getSprite(), accessoryDisplay);
    }

    private void reloadTextures() {
        characterDisplay.reloadTexture();
        helmetDisplay.reloadTexture();
        armorDisplay.reloadTexture();
        bootsDisplay.reloadTexture();
        weaponDisplay.reloadTexture();
        accessoryDisplay.reloadTexture();
    }

    private int getAdjacentIndex(Object[] array, Object o, int indexOffset) {
        // indexOffset +1 for next item, -1 for previous, any integer offset is possible as well
        int nextIndex = Arrays.asList(array).indexOf(o) + indexOffset;
        // if nextIndex would go out of top range, reset to 0
        if (nextIndex >= array.length) {
            nextIndex = 0;
        }
        // if nextIndex would go out of bottom range, reset to top (length - 1)
        else if (nextIndex < 0) {
            nextIndex = array.length - 1;
        }

        return nextIndex;
    }

}
