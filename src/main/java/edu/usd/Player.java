package edu.usd;

import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;

// Instance Variables.
    private String name;
    private Armor[] armor;
    private Accessory accessory;
    private Weapon weapon;
    private AbstractCharacter characterClass;

// Instance Variables for total stats.
    private double totalHealth;
    private double totalMana;
    private double totalEvasion;
    private double totalDefense;
    private int totalStrength;
    private int totalDexterity;
    private int totalIntelligence;

// Constructor.
    public Player(String name, Armor[] armor, Accessory accessory, Weapon weapon, AbstractCharacter characterClass){
        this.name = name;
        this.armor = armor;
        this.accessory = accessory;
        this.weapon = weapon;
        this.characterClass = characterClass;
        
        this.totalHealth = 0;
        this.totalMana = 0;
        this.totalEvasion = 0;
        this.totalDefense = 0;
        this.totalStrength = 0;
        this.totalDexterity = 0;
        this.totalIntelligence = 0;
    }

// Getter Methods.
    public String getName(){
        return this.name;
    }

    public Armor[] getArmor(){
        return this.armor;
    }

    public Accessory getAccessory(){
        return this.accessory;
    }

    public Weapon getWeapon(){
        return this.weapon;
    }

    public AbstractCharacter getCharacterClass(){
        return this.characterClass;
    }

    public double getTotalHealth(){
        this.totalHealth = this.accessory.getHEALTH() + this.weapon.getHEALTH() + this.characterClass.getHealth();

        for (Armor armor : this.armor){
            this.totalHealth += armor.getHEALTH();
        }
        return this.totalHealth;
    }

    public double getTotalMana(){
        this.totalMana = this.accessory.getMANA() + this.weapon.getMANA() + this.characterClass.getMana();

        for (Armor armor : this.armor){
            this.totalMana += armor.getMANA();
        }
        return this.totalMana;
    }

    public double getTotalEvasion(){
        this.totalEvasion = this.accessory.getEVASION() + this.weapon.getEVASION() + this.characterClass.getEvasion();

        for (Armor armor : this.armor){
            this.totalEvasion += armor.getEVASION();
        }
        return this.totalEvasion;
    }

    public double getTotalDefense(){
        this.totalDefense = this.accessory.getDEFENSE() + this.weapon.getDEFENSE() + this.characterClass.getDefense();

        for (Armor armor : this.armor){
            this.totalDefense += armor.getDEFENSE();
        }
        return this.totalDefense;
    }

    public int getTotalStrength(){
        this.totalStrength = this.accessory.getSTRENGTH() + this.weapon.getSTRENGTH() + this.characterClass.getStrength();

        for (Armor armor : this.armor){
            this.totalStrength += armor.getSTRENGTH();
        }
        return this.totalStrength;
    }

    public int getTotalDexterity(){
        this.totalDexterity = this.accessory.getDEXTERITY() + this.weapon.getDEXTERITY() + this.characterClass.getDexterity();

        for (Armor armor : this.armor){
            this.totalDexterity += armor.getDEXTERITY();
        }
        return this.totalDexterity;
    }

    public int getTotalIntelligence(){
        this.totalIntelligence = this.accessory.getINTELLIGENCE() + this.weapon.getINTELLIGENCE() + this.characterClass.getIntelligence();

        for (Armor armor : this.armor){
            this.totalIntelligence += armor.getINTELLIGENCE();
        }
        return this.totalIntelligence;
    }

// Setter Methods.
    public void setName(String name){
        this.name = name;
    }

    public void setArmor(Armor[] armor){
        this.armor = armor;
    }

    public void setAccessory(Accessory accessory){
        this.accessory = accessory;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setCharacterClass(AbstractCharacter characterClass){
        this.characterClass = characterClass;
    }

}