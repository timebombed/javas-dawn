# Character Creation

This application allows a user to create a character and customize its armor, accessories, weapon, and class. The character's information will be saved into a file that can be opened up later.

## Description

This application provides a seamless and efficient way to create and save a custom character. This application is not tailored to a specific population of users. Anyone interested in character customization is free to use this application.

The user starts at the main menu of the application. They are given the option to create a save file through the "Saves" button, check the settings through the "Settings" button, or exit the application through the "Exit" button.

By clicking on the "Saves" button, the user is provided with a list of new save files they can create. When the user clicks on "New Save", they are taken to the character customization screen. On this screen, the user can type in their name as well as select their desired armor, accessory, weapon, and class. The character the user creates will have stats that depend on the selected armor, accessory, weapon, and class.

The user can then save the character or cancel the changes. If the user cancels the changes, no save file is created and the user goes back to the list of new save files. If the user saves the character, a new save file is created with the newly created character. The user can then load up the character later to make further edits.

## Getting Started

1. Once the code has been downloaded, navigate to the Group3FinalProject folder (either through the command line or another method if desired).

2. If using the command line, type in "./gradlew run". This should build the code and run the application. If using IntelliJ, pressing the play button should run the application.

### Prerequisites

The IDE used to run the application should either Visual Studio Code or IntelliJ. Additionally, the application requires Gradle for building the code. The application also utilizes JUnit for testing as well as Lightweight Java Game Library version 3.3.3.

### Dependencies

The application code uses Lightweight Java Game Library version 3.3.3 along with JUnit for testing. More information about the dependencies can be found in the gradle.build file.

### Installing

The application can be run on Visual Studio Code or IntelliJ. Visual Studio Code can be installed using this link: https://code.visualstudio.com/. IntelliJ can be installed using this link: https://www.jetbrains.com/idea/download/?section=windows. Once either IDE has been installed and set up, the application code can be downloaded through GitHub. Then, in either IDE, the code can be opened up and run.

## Usage

After the application is downloaded and executed, the user will start at the main menu. The user then clicks on "Saves" to go to the save menu. Then, the user clicks on a new save file, which takes them to the character creation menu. The user then enters a name for the character. Then, the user chooses the character's weapon, armor, accessory, and class by clicking the left and right buttons to toggle through the selection. Once the user is satisfied with the name and character, they click "Save Character". By doing so, a save file is created containing the name and character. The user is then taken to the save menu, where they can choose to create another new save file. Alternatively, the user can click on the save file they previously created to edit the previously created name and character.

## Testing

Testing for the application utilizes JUnit. Make sure that the gradle.build file includes support for JUnit. Tests can be found and run in the test\java\edu\usd folder in the src folder. New tests should be written in the test\java\edu\usd folder in the src folder. Additionally, new tests can be added to existing test java files.

# Note for MacOS users #
Modify the following line in the gradle.build file

*project.ext.lwjglNatives = "natives-windows"*

To

*project.ext.lwjglNatives = "natives-macos-arm64"*



You will also need to pass "-XstartOnFirstThread" and "-Djava.awt.headless=true" as VM options for GLFW to work properly.

In IntelliJ VM options can be accessed by clicking the three dots next to run, and clicking "edit" under "Configuration."
