package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MarauderClassTest {
    // Tester MarauderClass object.
    private AbstractCharacter marauder;

    // Creating new MarauderClass object before every test.
    @BeforeEach
    void setUp(){
        marauder = new MarauderClass(null);
    }

// AbstractCharacter abstract class tests. Refer to AbstractCharacter.java for base stats being used in unit tests.
    @Test
    @DisplayName("Testing getHealth")
    void getHealthTest(){
        assertEquals(50.0, marauder.getHealth());
    }

    @Test
    @DisplayName("Testing getMana")
    void getManaTest(){
        assertEquals(40.0, marauder.getMana());
    }

    @Test
    @DisplayName("Testing getEvasion")
    void getEvasionTest(){
        assertEquals(53.0, marauder.getEvasion());
    }

    @Test
    @DisplayName("Testing getDefense")
    void getDefenseTest(){
        assertEquals(0.0, marauder.getDefense());
    }

    // MarauderClass tests. Base stats can be found under MarauderClass.java
    @Test
    @DisplayName("Testing getStrength")
    void getStrengthTest(){
        assertEquals(32, marauder.getStrength());
    }

    @Test
    @DisplayName("Testing getDexterity")
    void getDexterityTest(){
        assertEquals(14, marauder.getDexterity());
    }

    @Test
    @DisplayName("Testing getIntelliegence")
    void getIntelligenceTest(){
        assertEquals(14, marauder.getIntelligence());
    }

}
