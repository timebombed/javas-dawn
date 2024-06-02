package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WitchClassTest {
    // Tester WitchClass object.
    private AbstractCharacter witch;

    // Creating new WitchClass object before every test.
    @BeforeEach
    void setUp(){
        witch = new WitchClass(null);
    }

// AbstractCharacter abstract class tests. Refer to AbstractCharacter for base stats being used in unit tests.
    @Test
    @DisplayName("Testing getHealth")
    void getHealthTest(){
        assertEquals(50.0, witch.getHealth());
    }

    @Test
    @DisplayName("Testing getMana")
    void getManaTest(){
        assertEquals(40.0, witch.getMana());
    }

    @Test
    @DisplayName("Testing getEvasion")
    void getEvasionTest(){
        assertEquals(53.0, witch.getEvasion());
    }

    @Test
    @DisplayName("Testing getDefense")
    void getDefenseTest(){
        assertEquals(0.0, witch.getDefense());
    }

    // WitchClass tests. Base stats can be found under WitchClass.java
    @Test
    @DisplayName("Testing getStrength")
    void getStrengthTest(){
        assertEquals(14, witch.getStrength());
    }

    @Test
    @DisplayName("Testing getDexterity")
    void getDexterityTest(){
        assertEquals(14, witch.getDexterity());
    }

    @Test
    @DisplayName("Testing getIntelliegence")
    void getIntelligenceTest(){
        assertEquals(32, witch.getIntelligence());
    }
 
}
