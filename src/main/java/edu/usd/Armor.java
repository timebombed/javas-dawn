package edu.usd;

import java.io.Serializable;

public abstract class Armor implements ItemStats, Serializable{
    private static final long serialVersionUID = 2L;
    private Sprite sprite;

    public Armor(Sprite sprite) {
        this.sprite = sprite;
    }

    public abstract int getDEFENSE();
    public abstract int getEVASION();
    public abstract int getHEALTH();
    public abstract int getMANA();
    public abstract int getINTELLIGENCE();
    public abstract int getSTRENGTH();
    public abstract int getDEXTERITY();
    public abstract String getNAME();
    public Sprite getSprite() {
        return sprite;
    }
}

// Implementation for helmet
class Helmet extends Armor{
    private final String name;
    private int DEFENSE = 2;
    private int EVASION = 1;
    private int HEALTH = 2;
    private int MANA = 3;
    private int STRENGTH = 1;
    private int INTELLIGENCE = 4;
    private int DEXTERITY = 1;
    public Helmet(Sprite s, String name, int BASE_DEFENSE, int BASE_EVASION, int BASE_HEALTH, int BASE_MANA, int BASE_STRENGTH, int BASE_INTELLIGENCE, int BASE_DEXTERITY) {
        super(s);
        this.name = name;
        this.DEFENSE = (BASE_DEFENSE != 0) ? this.DEFENSE + BASE_DEFENSE : 0;
        this.EVASION = (BASE_EVASION != 0) ? this.EVASION + BASE_EVASION : 0;
        this.HEALTH = (BASE_HEALTH != 0) ? this.HEALTH + BASE_HEALTH : 0;
        this.MANA = (BASE_MANA != 0) ? this.MANA + BASE_MANA : 0;
        this.STRENGTH = (BASE_STRENGTH != 0) ? this.STRENGTH + BASE_STRENGTH : 0;
        this.INTELLIGENCE = (BASE_INTELLIGENCE != 0) ? this.INTELLIGENCE + BASE_INTELLIGENCE : 0;
        this.DEXTERITY = (BASE_DEXTERITY != 0) ? this.DEXTERITY + BASE_DEXTERITY : 0;
    }

    @Override
    public int getDEFENSE() {
        return DEFENSE;
    }

    @Override
    public int getEVASION() {
        return EVASION;
    }

    @Override
    public int getHEALTH() {
        return HEALTH;
    }

    @Override
    public int getMANA() {
        return MANA;
    }

    @Override
    public int getSTRENGTH() {
        return STRENGTH;
    }

    @Override
    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    @Override
    public int getDEXTERITY() {
        return DEXTERITY;
    }

    @Override
    public String getNAME() {
        return name;
    }
}

// Implementation for body armor
class BodyArmor extends Armor{
    private final String name;
    private int DEFENSE = 4;
    private int EVASION = 2;
    private int HEALTH = 4;
    private int MANA = 2;
    private int STRENGTH = 3;
    private int INTELLIGENCE = 2;
    private int DEXTERITY = 4;
    public BodyArmor(Sprite s, String name, int BASE_DEFENSE, int BASE_EVASION, int BASE_HEALTH, int BASE_MANA, int BASE_STRENGTH, int BASE_INTELLIGENCE, int BASE_DEXTERITY) {
        super(s);
        this.name = name;
        this.DEFENSE = (BASE_DEFENSE != 0) ? this.DEFENSE + BASE_DEFENSE : 0;
        this.EVASION = (BASE_EVASION != 0) ? this.EVASION + BASE_EVASION : 0;
        this.HEALTH = (BASE_HEALTH != 0) ? this.HEALTH + BASE_HEALTH : 0;
        this.MANA = (BASE_MANA != 0) ? this.MANA + BASE_MANA : 0;
        this.STRENGTH = (BASE_STRENGTH != 0) ? this.STRENGTH + BASE_STRENGTH : 0;
        this.INTELLIGENCE = (BASE_INTELLIGENCE != 0) ? this.INTELLIGENCE + BASE_INTELLIGENCE : 0;
        this.DEXTERITY = (BASE_DEXTERITY != 0) ? this.DEXTERITY + BASE_DEXTERITY : 0;
    }

    @Override
    public int getDEFENSE() {
        return DEFENSE;
    }

    @Override
    public int getEVASION() {
        return EVASION;
    }

    @Override
    public int getHEALTH() {
        return HEALTH;
    }

    @Override
    public int getMANA() {
        return MANA;
    }

    @Override
    public int getSTRENGTH() {
        return STRENGTH;
    }

    @Override
    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    @Override
    public int getDEXTERITY() {
        return DEXTERITY;
    }

    @Override
    public String getNAME() {
        return name;
    }
}

// Implementation for boots
class Boots extends Armor{
    private final String name;
    private int DEFENSE = 1;
    private int EVASION = 4;
    private int HEALTH = 1;
    private int MANA = 1;
    private int STRENGTH = 2;
    private int INTELLIGENCE = 1;
    private int DEXTERITY = 1;
    public Boots(Sprite s, String name, int BASE_DEFENSE, int BASE_EVASION, int BASE_HEALTH, int BASE_MANA, int BASE_STRENGTH, int BASE_INTELLIGENCE, int BASE_DEXTERITY) {
        super(s);
        this.name = name;
        this.DEFENSE = (BASE_DEFENSE != 0) ? this.DEFENSE + BASE_DEFENSE : 0;
        this.EVASION = (BASE_EVASION != 0) ? this.EVASION + BASE_EVASION : 0;
        this.HEALTH = (BASE_HEALTH != 0) ? this.HEALTH + BASE_HEALTH : 0;
        this.MANA = (BASE_MANA != 0) ? this.MANA + BASE_MANA : 0;
        this.STRENGTH = (BASE_STRENGTH != 0) ? this.STRENGTH + BASE_STRENGTH : 0;
        this.INTELLIGENCE = (BASE_INTELLIGENCE != 0) ? this.INTELLIGENCE + BASE_INTELLIGENCE : 0;
        this.DEXTERITY = (BASE_DEXTERITY != 0) ? this.DEXTERITY + BASE_DEXTERITY : 0;
    }

    @Override
    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    @Override
    public int getDEXTERITY() {
        return DEXTERITY;
    }

    @Override
    public int getSTRENGTH() {
        return STRENGTH;
    }

    @Override
    public int getMANA() {
        return MANA;
    }

    @Override
    public int getHEALTH() {
        return HEALTH;
    }

    @Override
    public int getEVASION() {
        return EVASION;
    }

    @Override
    public int getDEFENSE() {
        return DEFENSE;
    }

    @Override
    public String getNAME() {
        return name;
    }
}