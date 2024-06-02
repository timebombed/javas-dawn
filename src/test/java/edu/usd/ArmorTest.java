package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArmorTest {
    // Tester Armor object.
    private Armor helmet;
    private Armor bodyArmor;
    private Armor boots;

    // Creating new Armor object before every test.
    @BeforeEach
    void setUp(){
        helmet = new Helmet(null,"testHelmet", 10, 10, 10 , 10, 10, 10, 10);
        bodyArmor = new BodyArmor(null,"testBodyArmor", 10, 10, 10 , 10, 10, 10, 10);
        boots = new Boots(null,"testBoots", 10, 10, 10 , 10, 10, 10, 10);    
    }

// Helmet class tests. Denoted by 'Test1'
    // All stats are preset to (base + 10) for testing purposes. Refer to Armor.Helmet class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest1(){
        assertEquals(12, helmet.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest1(){
        assertEquals(11, helmet.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest1(){
        assertEquals(12, helmet.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest1(){
        assertEquals(13, helmet.getMANA());
    }

    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest1(){
        assertEquals(11, helmet.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest1(){
        assertEquals(14, helmet.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest1(){
        assertEquals(11, helmet.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest1(){
        assertEquals("testHelmet", helmet.getNAME());
    }


// BodyArmor class tests. Denoted by 'Test2'
    // All stats are preset to (base + 10) for testing purposes. Refer to Armor.BodyArmor class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest2(){
        assertEquals(14, bodyArmor.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest2(){
        assertEquals(12, bodyArmor.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest2(){
        assertEquals(14, bodyArmor.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest2(){
        assertEquals(12, bodyArmor.getMANA());
    }

    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest2(){
        assertEquals(13, bodyArmor.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest2(){
        assertEquals(12, bodyArmor.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest2(){
        assertEquals(14, bodyArmor.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest2(){
        assertEquals("testBodyArmor", bodyArmor.getNAME());
    }


// Boots class tests. Denoted by 'Test3'
    // All stats are preset to (base + 10) for testing purposes. Refer to Armor.Boots class for base stats.
    @Test
    @DisplayName("Testing getDEFENSE")
    void getDEFENSETest3(){
        assertEquals(11, boots.getDEFENSE());
    }

    @Test
    @DisplayName("Testing getEVASION")
    void getEVASIONTest3(){
        assertEquals(14, boots.getEVASION());
    }

    @Test
    @DisplayName("Testing getHEALTH")
    void getHEALTHTest3(){
        assertEquals(11, boots.getHEALTH());
    }

    @Test
    @DisplayName("Testing getMANA")
    void getMANATest3(){
        assertEquals(11, boots.getMANA());
    }

    @Test
    @DisplayName("Testing getSTRENGTH")
    void getSTRENGTHTest3(){
        assertEquals(12, boots.getSTRENGTH());
    }

    @Test
    @DisplayName("Testing getINTELLIGENCE")
    void getINTELLIGENCETest3(){
        assertEquals(11, boots.getINTELLIGENCE());
    }

    @Test
    @DisplayName("Testing getDEXTERITY")
    void getDEXTERITYTest3(){
        assertEquals(11, boots.getDEXTERITY());
    }

    @Test
    @DisplayName("Testing getNAME")
    void getNAMETest3(){
        assertEquals("testBoots", boots.getNAME());
    }
}
