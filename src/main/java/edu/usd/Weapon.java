package edu.usd;

import java.io.Serializable;

public abstract class Weapon implements ItemStats, Serializable {
    private static final long serialVersionUID = 4L;
    private Sprite sprite;

    public Weapon(Sprite s) {
        sprite = s;
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

// Implementation for wand
class Wand extends Weapon{
    private String name;
    private int INTELLIGENCE = 40;
    private int STRENGTH;
    private int DEXTERITY;
    public Wand(Sprite s, String name, int INTELLIGENCE, int STRENGTH, int DEXTERITY) {
        super(s);
        this.name = name;
        this.INTELLIGENCE += INTELLIGENCE;
        this.STRENGTH = STRENGTH;
        this.DEXTERITY = DEXTERITY;
    }

    @Override
    public String getNAME() {
        return name;
    }

    @Override
    public int getDEFENSE() {
        return 0;
    }

    @Override
    public int getEVASION() {
        return 0;
    }

    @Override
    public int getHEALTH() {
        return 0;
    }

    @Override
    public int getMANA() {
        return 0;
    }

    @Override
    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    @Override
    public int getSTRENGTH() {
        return STRENGTH;
    }

    @Override
    public int getDEXTERITY() {
        return DEXTERITY;
    }

}

// Implementation for axe
class Axe extends Weapon{
    private String name;
    private int STRENGTH = 40;
    private int INTELLIGENCE;
    private int DEXTERITY;
    public Axe(Sprite s, String name, int STRENGTH, int INTELLIGENCE, int DEXTERITY) {
        super(s);
        this.name = name;
        this.STRENGTH += STRENGTH;
        this.INTELLIGENCE = INTELLIGENCE;
        this.DEXTERITY = DEXTERITY;
    }
    @Override
    public int getDEFENSE() {
        return 0;
    }

    @Override
    public int getHEALTH() {
        return 0;
    }

    @Override
    public int getEVASION() {
        return 0;
    }

    @Override
    public int getMANA() {
        return 0;
    }

    @Override
    public int getDEXTERITY() {
        return DEXTERITY;
    }

    @Override
    public int getINTELLIGENCE() {
        return INTELLIGENCE;
    }

    @Override
    public int getSTRENGTH() {
        return STRENGTH;
    }

    @Override
    public String getNAME() {
        return name;
    }
}

// Implementation for bow
class Bow extends Weapon{
    private String name;
    private int DEXTERITY = 40;
    private int INTELLIGENCE;
    private int STRENGTH;
    public Bow(Sprite s, String name, int DEXTERITY, int INTELLIGENCE, int STRENGTH) {
        super(s);
        this.name = name;
        this.DEXTERITY += DEXTERITY;
        this.INTELLIGENCE = INTELLIGENCE;
        this.STRENGTH = STRENGTH;
    }

    @Override
    public String getNAME() {
        return name;
    }

    @Override
    public int getDEFENSE() {
        return 0;
    }

    @Override
    public int getHEALTH() {
        return 0;
    }

    @Override
    public int getMANA() {
        return 0;
    }

    @Override
    public int getEVASION() {
        return 0;
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
}