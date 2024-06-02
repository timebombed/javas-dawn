package edu.usd;

import java.io.Serializable;

public class Accessory implements ItemStats, Serializable{
    private static final long serialVersionUID = 3L;

// Instance variables
    private final String name;
    private final Sprite sprite;
    private final int INTELLIGENCE;
    private final int STRENGTH;
    private final int DEXTERITY;
    public Accessory(Sprite s, String name, int INTELLIGENCE, int STRENGTH, int DEXTERITY){
        sprite = s;
        this.name = name;
        this.INTELLIGENCE = INTELLIGENCE;
        this.STRENGTH = STRENGTH;
        this.DEXTERITY = DEXTERITY;
    }

// Getter methods
    public int getDEFENSE(){
        return 0;
    }

    public int getEVASION(){
        return 0;
    }

    public int getHEALTH(){
        return 0;
    }

    public int getMANA(){
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

    @Override
    public String getNAME() {
        return name;
    }

    public Sprite getSprite() {
        return sprite;
    }
}