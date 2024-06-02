package edu.usd;

public class WitchClass extends AbstractCharacter {
// Instance variables.
    private int strength;
    private int dexterity;
    private int intelligence;
    private final String name = "Witch";

// Constructor.
    public WitchClass(Sprite sprite){
        super(sprite);
        this.strength = 14;
        this.dexterity = 14;
        this.intelligence = 32;
    }

// Getter Methods.
    public int getStrength(){
        return this.strength;
    }

    public int getDexterity(){
        return this.dexterity;
    }

    public int getIntelligence(){
        return this.intelligence;
    }

    public String getName() {
        return name;
    }
}