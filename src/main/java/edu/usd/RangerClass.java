package edu.usd;

public class RangerClass extends AbstractCharacter{
    // Instance variables.
    private int strength;
    private int dexterity;
    private int intelligence;
    private final String name = "Ranger";

// Constructor.
    public RangerClass(Sprite sprite){
        super(sprite);
        this.strength = 14;
        this.dexterity = 32;
        this.intelligence = 14;
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