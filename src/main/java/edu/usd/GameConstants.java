package edu.usd;

/*
 * Holds our constants related to gameplay, mainly item data, class data, and their respective sprites
 */
public final class GameConstants {
    // Character Sprite Constants
    public static final Sprite marauderSprite = new Sprite("./textures/MarauderBase.png", 0, 0, 0, 0);
    public static final Sprite witchSprite = new Sprite("./textures/WitchBase.png", 0, 0, 0, 0);
    public static final Sprite rangerSprite = new Sprite("./textures/RangerBase.png", 0, 0, 0, 0);

    // Item instance constants
    // Accessory
    public static final Sprite dailyBugleSprite = new Sprite("./textures/dailyBugle.png", 0, 0, 0, 0);
    public static final Accessory dailyBugle = new Accessory(dailyBugleSprite, "Daily Bugle", 12, 5, 1);
    public static final Sprite markOfSubmissionSprite = new Sprite("./textures/markOfSubmission.png", 0, 0, 0, 0);
    public static final Accessory markOfSubmission = new Accessory(markOfSubmissionSprite, "Mark of Submission", 0, 20, 10);
    public static final Sprite powerOfFriendshipSprite = new Sprite("./textures/powerOfFriendship.png", 0, 0, 0, 0);
    public static final Accessory powerOfFriendship = new Accessory(powerOfFriendshipSprite, "Power of Friendship!", 10, 10, 10);
    // Helmet
    private static final Sprite ironHelmetSprite = new Sprite("./textures/IronHelmet.png",0,0,0,0);
    public static final Helmet ironHelmet = new Helmet(ironHelmetSprite, "Iron Helmet", 5, -2, 0, 0, 2, 0, -2);
    private static final Sprite lausCapSprite = new Sprite("./textures/lausCap.png",0,0,0,0);
    public static final Helmet lausCap = new Helmet(lausCapSprite, "Lau's Cap", 1, 0, 25, 20, 0, 30, 3);
    private static final Sprite gorbolHelmetSprite = new Sprite("./textures/ViolatedGorbolHelmet.png",0,0,0,0);
    public static final Helmet violatedGorbolHelmet = new Helmet(gorbolHelmetSprite, "Violated Gorbol Helmet",50, 0, 10, 0, 50, 0, 0);
    // BodyArmor
    private static final Sprite kairosChestplateSprite = new Sprite("./textures/KairosChestplate.png",0,0,0,0);
    public static final BodyArmor kairosChestplate = new BodyArmor(kairosChestplateSprite,"Kairo's Chestplate", 15, -5, 70, 0, 10, 10, -3);
    private static final Sprite glicksSweaterSprite = new Sprite("./textures/GlicksSweater.png",0,0,0,0);
    public static final BodyArmor glicksSweater = new BodyArmor(glicksSweaterSprite, "Glick's Sweater", 1, 0, 0, 25, 0, 20, 0);
    private static final Sprite gorbolArmorSprite = new Sprite("./textures/ViolatedGorbolArmor.png",0,0,0,0);
    public static final BodyArmor violatedGorbolArmor = new BodyArmor(gorbolArmorSprite, "Violated Gorbol Armor",50, 0, 10, 0, 50, 0, 0);
    // Boots
    private static final Sprite glicksReeboksSprite = new Sprite("./textures/glicksReeboks2.png",0,0,0,0);
    public static final Boots glicksReeboks = new Boots(glicksReeboksSprite, "Glick's Reeboks", 0, 25, 0, 5, 0, 10, 5);
    private static final Sprite iceBootsSprite = new Sprite("./textures/iceBoots.png",0,0,0,0);
    public static final Boots iceBoots = new Boots(iceBootsSprite, "Ice Boots", 10, 10, 15, 15, 0, 0, 10);
    private static final Sprite gorbolBootsSprite = new Sprite("./textures/ViolatedGorbolBoots.png",0,0,0,0);
    public static final Boots violatedGorbolBoots = new Boots(gorbolBootsSprite,"Violated Gorbol Boots",50, 0, 10, 0, 50, 0, 0);
    // Weapons
    public static final Sprite groggleWandSprite = new Sprite("./textures/groggleWand.png", 0, 0, 0, 0);
    public static final Wand groggleWand = new Wand(groggleWandSprite, "Groggle Wand", 20, 0, 10);
    public static final Sprite poisonAxeSprite = new Sprite("./textures/poisonAxe.png", 0, 0, 0, 0);
    public static final Axe poisonAxe = new Axe(poisonAxeSprite, "Poison Axe", 20, 0, -2);
    public static final Sprite guardBreakerSprite = new Sprite("./textures/GuardBreaker.png", 0, 0, 0, 0);
    public static final Axe guardBreaker = new Axe(guardBreakerSprite, "Guard Breaker", 30, 0, -5);
    public static final Sprite magnoliasReckoningSprite = new Sprite("./textures/magnoliasReckoning.png", 0, 0, 0, 0);
    public static final Bow magnoliasReckoning = new Bow(magnoliasReckoningSprite, "Magnolia's Reckoning", 15, 2, 3);
    public static final Sprite longBowSprite = new Sprite("./textures/LongBow.png", 0, 0, 0, 0);
    public static final Bow longBow = new Bow(longBowSprite, "Long Bow", 10, 5, 5);

}
