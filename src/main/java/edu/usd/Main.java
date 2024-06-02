package edu.usd;

public class Main {
    public static void main(String[] args) {
        GameWindow gamewindow = new GameWindow();

        // //creates window to display the game
        gamewindow.openWindow();

        // //starts the window's main loop
        gamewindow.windowLoop();    
    }
}
