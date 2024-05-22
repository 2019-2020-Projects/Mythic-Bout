# Mythic Bout
Mythic Bout is a Monster battle game built with Java Swing for the GUI. The game allows the player to battle a CPU opponent using Monster of their choice.

## Features
* Single player gameplay against a CPU opponent
* Choice of starting Monster
  * Wyrmling
  * Dragon Cub
  * Young Dragon
  * Dragon
  * Sea Serpentling
* Monster battles with turn-based attacking
* Type effectiveness and weaknesses between Monster types
* Monster abilities that boost attacks under certain conditions
* Animated Monster sprites and battle background
* Nickname and customize your Monster's moves
* Win by defeating the opponent's Monster
## Code Overview
The main classes and files:

* StartHere - Sets up the initial JFrame and contains the main method to launch the game
* PlayerOne - Handles the player's Monster selection and customization
* PlayerTwo - Handles the CPU opponent's Monster selection
* Monster - Base Monster class for creating Monster objects
* Monster_Abilities - Subclass of Monster that adds abilities
* MonsterType - Enum containing the different Monster types
* Attack - Interface for attacks
* DamageAttack - Attack implementation for damaging moves
* StatusAttack - Attack implementation for status effect moves
* Battle - Manages the battle gameplay logic and turn sequence
The battle system calculates type effectiveness and processes turn order. Monster can have various statuses applied to them including falling asleep. Each Monster also has an ability that can boost attacks based on certain conditions like low health.

The player progresses through selecting their Monster, customizing moves, and nicknaming them. Then the battle phase begins where the player takes turns selecting attacks against the CPU opponent. The battle ends when one player's Monster faints.

## How to Run
This project requires Java 11 or higher. To run the game:

1. Clone the repository
2. Navigate to the project directory
3. Compile with javac *.java
4. Run java StartHere
5. Click the "Play" button to begin
The game window will initialize and you can begin your Monster journey!

## Future Improvements
Some potential expansions for the game:

* Add more Monster types and selections
* Improve battle animations and effects
* Expand movepool variety and add new status effects
* Implement trainable stats that grow as Monster level up
* Support additional gameplay modes like multiplayer
* Add persistent saving of Monster teams and progression
## Credits
Mythic Bout was created by Wilson Neira. The project serves as a code sample to demonstrate Java skills.
