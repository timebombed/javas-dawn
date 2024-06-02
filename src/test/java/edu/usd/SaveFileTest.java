package edu.usd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SaveFileTest {
    // Instance Variables.
    Player player;

    // Creating new Player object before each test.
    @BeforeEach
    void setUp(){
        player = new Player("(For Unit Testing Only)", null, null, null, null);
    }

    @Test
    @DisplayName("Testing readFile")
    void readFileTest(){
        SaveFile.saveFile(player, true);
        Player testPlayer = SaveFile.readFile("./savefiles/(For Unit Testing Only).dat");
        assertEquals(player.getName(), testPlayer.getName());
    }

}
