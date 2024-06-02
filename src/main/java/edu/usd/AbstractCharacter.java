package edu.usd;

import java.io.Serializable;

public abstract class AbstractCharacter implements CharacterStats, Serializable{
    private static final long serialVersionUID = 5L;

// Instance Variables.
    private double baseHealth;
    private double baseMana;
    private double baseEvasion;
    private double baseDefense;
    private Sprite sprite;


// Constructor.
    public AbstractCharacter(Sprite sprite) {
        this.sprite = sprite;
        this.baseHealth = 50.0;
        this.baseMana = 40.0;
        this.baseEvasion = 53.0;
        this.baseDefense = 0.0;
    }

// Abstract methods used by the character classes.
    // Getter Methods.
    public abstract int getStrength();
    public abstract int getDexterity();
    public abstract int getIntelligence();
    
// Getter Methods for abstract class.
    public double getHealth(){
        return this.baseHealth;
    }

    public double getMana(){
        return this.baseMana;
    }

    public double getEvasion(){
        return this.baseEvasion;
    }

    public double getDefense(){
        return baseDefense;
    }

    public String getName() {
        return "";
    }

    public Sprite getSprite() {
        return sprite;
    }
}
