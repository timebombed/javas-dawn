package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {
    // Instance Variables 
    private Player player;
    private Armor helmet;
    private Armor bodyArmor;
    private Armor boots;
    private Armor[] armor;
    private Accessory accessory;
    private Weapon weapon;
    private AbstractCharacter characterClass;
    private String name;


    // Creating a new Player object before each test.
    @BeforeEach
    void setUp(){
        name = "joe";
        characterClass = new MarauderClass(null);
        weapon = new Axe(null,"testWeapon", 0, 0, 0);
        accessory = new Accessory(null,"testAccessory", 0, 0, 0);
        boots = new Boots(null,"testBoots", 0, 0, 0, 0, 0, 0, 0);
        bodyArmor = new BodyArmor(null,"testBodyArmor", 0, 0, 0, 0, 0, 0, 0);
        helmet = new Helmet(null,"testHelmet", 0, 0, 0, 0, 0, 0, 0);
        armor = new Armor[3];
        armor[0] = helmet;
        armor[1] = bodyArmor;
        armor[2] = boots;
        player = new Player(name, armor, accessory, weapon, characterClass);
    }

    // Getter Methods.
    @Test
    @DisplayName("Testing getName")
    void getNameTest(){
        assertEquals("joe", player.getName());
    }

    @Test
    @DisplayName("Testing getArmor")
    void getArmorTest(){
        assertEquals(armor, player.getArmor());
    }

    @Test
    @DisplayName("Testing getAccessory")
    void getAccessoryTest(){
        assertEquals(accessory, player.getAccessory());
    }

    @Test
    @DisplayName("Testing getWeapon")
    void getWeaponTest(){
        assertEquals(weapon, player.getWeapon());
    }

    @Test
    @DisplayName("Testing getCharacterClass")
    void getCharacterClassTest(){
        assertEquals(characterClass, player.getCharacterClass());
    }

    @Test
    @DisplayName("Testing getTotalHealth")
    void getTotalHealthTest(){
        double testTotalHealth = characterClass.getHealth() + accessory.getHEALTH() + weapon.getHEALTH();
        for (Armor armor : armor){
            testTotalHealth += armor.getHEALTH();
        }
        assertEquals(testTotalHealth, player.getTotalHealth());
    }

    @Test
    @DisplayName("Testing getTotalMana")
    void getTotalManaTest(){
        double testTotalMana = characterClass.getMana() + accessory.getMANA() + weapon.getMANA();
        for (Armor armor : armor){
            testTotalMana += armor.getMANA();
        }
        assertEquals(testTotalMana, player.getTotalMana());
    }

    @Test
    @DisplayName("Testing getTotalEvasion")
    void getTotalEvasionTest(){
        double testTotalEvasion = characterClass.getEvasion() + accessory.getEVASION() + weapon.getEVASION();
        for (Armor armor : armor){
            testTotalEvasion += armor.getEVASION();
        }
        assertEquals(testTotalEvasion, player.getTotalEvasion());
    }

    @Test
    @DisplayName("Testing getTotalDefense")
    void getTotalDefenseTest(){
        double testTotalDefense = characterClass.getDefense() + accessory.getDEFENSE() + weapon.getDEFENSE();
        for (Armor armor : armor){
            testTotalDefense += armor.getDEFENSE();
        }
        assertEquals(testTotalDefense, player.getTotalDefense());
    }

    @Test
    @DisplayName("Testing getTotalStrength")
    void getTotalStrengthTest(){
        double testTotalStrength = characterClass.getStrength() + accessory.getSTRENGTH() + weapon.getSTRENGTH();
        for (Armor armor : armor){
            testTotalStrength += armor.getSTRENGTH();
        }
        assertEquals(testTotalStrength, player.getTotalStrength());
    }

    @Test
    @DisplayName("Testing getTotalDexterity")
    void getTotalDexterityTest(){
        double testTotalDexterity = characterClass.getDexterity() + accessory.getDEXTERITY() + weapon.getDEXTERITY();
        for (Armor armor : armor){
            testTotalDexterity += armor.getDEXTERITY();
        }
        assertEquals(testTotalDexterity, player.getTotalDexterity());
    }

    @Test
    @DisplayName("Testing getTotalIntelligence")
    void getTotalIntelligenceTest(){
        double testTotalIntelligence = characterClass.getIntelligence() + accessory.getINTELLIGENCE() + weapon.getINTELLIGENCE();
        for (Armor armor : armor){
            testTotalIntelligence += armor.getINTELLIGENCE();
        }
        assertEquals(testTotalIntelligence, player.getTotalIntelligence());
    }

    // Setter Methods.
    @Test
    @DisplayName("Testing setName")
    void setNameTest(){
        String testName = "aditya";
        player.setName(testName);
        assertEquals(testName, player.getName());
    }

    @Test
    @DisplayName("Testing setArmor")
    void setArmorTest(){
        Armor[] testArmor = new Armor[3];
        player.setArmor(testArmor);
        assertEquals(testArmor, player.getArmor());
    }

    @Test
    @DisplayName("Testing setAccessory")
    void setAccessoryTest(){
        Accessory testAccessory = new Accessory(null, "newAccessory", 0, 0, 0);
        player.setAccessory(testAccessory);
        assertEquals(testAccessory, player.getAccessory());
    }

    @Test
    @DisplayName("Testing setWeapon")
    void setWeaponTest(){
        Weapon testWeapon = new Bow(null, "newBow", 0, 0, 0);
        player.setWeapon(testWeapon);
        assertEquals(testWeapon, player.getWeapon());
    }

    @Test
    @DisplayName("Testing setCharacterClass")
    void setCharacterClassTest(){
        AbstractCharacter testCharacter = new RangerClass(null);
        player.setCharacterClass(testCharacter);
        assertEquals(testCharacter, player.getCharacterClass());
    }
}
