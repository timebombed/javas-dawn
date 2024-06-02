package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WeaponTest {
    // Tester Weapon object.
    private Weapon wand;
    private Weapon axe;
    private Weapon bow;

    // Creating new Weapon object before every test.
    @BeforeEach
    void setUp(){
        wand = new Wand(null,"testWand", 10, 10, 10);
        axe = new Axe(null,"testAxe", 10, 10, 10);
        bow = new Bow(null,"testBow", 10, 10, 10);
    }

// Wand class tests. Denoted by 'Test1'
    // All stats are preset to (base + 0) for testing purposes. Refer to Weapon.Wand class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest1(){
        assertEquals(0, wand.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest1(){
        assertEquals(0, wand.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest1(){
        assertEquals(0, wand.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest1(){
        assertEquals(0, wand.getMANA());
    }

    // All remaining starts are set to (base + 10) for testing purposes. Refer to Weapon.Wand for base stats.
    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest1(){
        assertEquals(10, wand.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest1(){
        assertEquals(50, wand.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest1(){
        assertEquals(10, wand.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest1(){
        assertEquals("testWand", wand.getNAME());
    }


// Axe class tests. Denoted by 'Test2'
    // All stats are preset to (base + 0) for testing purposes. Refer to Weapon.Axe class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest2(){
        assertEquals(0, axe.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest2(){
        assertEquals(0, axe.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest2(){
        assertEquals(0, axe.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest2(){
        assertEquals(0, axe.getMANA());
    }

    // All remaining starts are set to (base + 10) for testing purposes. Refer to Weapon.Axe for base stats.
    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest2(){
        assertEquals(50, axe.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest2(){
        assertEquals(10, axe.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest2(){
        assertEquals(10, axe.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest2(){
        assertEquals("testAxe", axe.getNAME());
    }


// Bow class tests. Denoted by 'Test3'
    // All stats are preset to (base + 0) for testing purposes. Refer to Weapon.Bow class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest3(){
        assertEquals(0, bow.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest3(){
        assertEquals(0, bow.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest3(){
        assertEquals(0, bow.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest3(){
        assertEquals(0, bow.getMANA());
    }

    // All remaining starts are set to (base + 10) for testing purposes. Refer to Weapon.Bow for base stats.
    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest3(){
        assertEquals(10, bow.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest3(){
        assertEquals(10, bow.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest3(){
        assertEquals(50, bow.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest3(){
        assertEquals("testBow", bow.getNAME());
    }
}
