package edu.usd;

public class MarauderClass extends AbstractCharacter {
// Instance variables.
    private int strength;
    private int dexterity;
    private int intelligence;
    private final String name = "Marauder";

// Constructor.
    public MarauderClass(Sprite sprite){
        super(sprite);
        this.strength = 32;
        this.dexterity = 14;
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