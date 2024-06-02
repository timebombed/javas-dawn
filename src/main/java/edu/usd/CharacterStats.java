package edu.usd;

public interface CharacterStats {
// Getter Methods to be implemented for each character class.
    // Base stats; same for all character classes.
    double getHealth();
    double getMana();
    double getEvasion();
    double getDefense();

    // Char. Class stats; different per character class.
    int getStrength();
    int getDexterity();
    int getIntelligence();
    
}