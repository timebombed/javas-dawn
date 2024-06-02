package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccessoryTest {
    // Tester Accessory object.
    private Accessory accessory;

    // Creating new Accessory object before every test.
    @BeforeEach
    void setUp(){
        accessory = new Accessory(null,"testAccessory", 10, 10, 10);
    }

    // getDEFENSE, getEVASION, getHEALTH, getMANA have a base stat of 0 for all accessories.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest(){
        int testDefense = 0;
        assertEquals(testDefense, accessory.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest(){
        int testEvasion = 0;
        assertEquals(testEvasion, accessory.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest(){
        int testHealth = 0;
        assertEquals(testHealth, accessory.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest(){
        int testMana = 0;
        assertEquals(testMana, accessory.getMANA());
    }

    // All stats are preset to 10 for testing purposes.
    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest(){
        assertEquals(10, accessory.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest(){
        assertEquals(10, accessory.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest(){
        assertEquals(10, accessory.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest(){
        assertEquals("testAccessory", accessory.getNAME());
    }

}
