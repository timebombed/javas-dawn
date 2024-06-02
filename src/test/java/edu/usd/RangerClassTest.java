package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RangerClassTest {
    // Tester RangerClass object.
    private AbstractCharacter ranger;

    // Creating new RangerClass object before every test.
    @BeforeEach
    void setUp(){
        ranger = new RangerClass(null);
    }

// AbstractCharacter abstract class tests. Refer to AbstractCharacter.java for base stats being used in unit tests.
    @Test
    @DisplayName("Testing getHealth")
    void getHealthTest(){
        assertEquals(50.0, ranger.getHealth());
    }

    @Test
    @DisplayName("Testing getMana")
    void getManaTest(){
        assertEquals(40.0, ranger.getMana());
    }

    @Test
    @DisplayName("Testing getEvasion")
    void getEvasionTest(){
        assertEquals(53.0, ranger.getEvasion());
    }

    @Test
    @DisplayName("Testing getDefense")
    void getDefenseTest(){
        assertEquals(0.0, ranger.getDefense());
    }

    // MarauderClass tests. Base stats can be found under RangerClass.java
    @Test
    @DisplayName("Testing getStrength")
    void getStrengthTest(){
        assertEquals(14, ranger.getStrength());
    }

    @Test
    @DisplayName("Testing getDexterity")
    void getDexterityTest(){
        assertEquals(32, ranger.getDexterity());
    }

    @Test
    @DisplayName("Testing getIntelliegence")
    void getIntelligenceTest(){
        assertEquals(14, ranger.getIntelligence());
    }

}
