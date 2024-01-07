# Pokemon_Java

Pokemon Java is a Pokemon battle game built with Java Swing for the GUI. The game allows the player to battle a CPU opponent using Pokemon of their choice.

## Features

* Single player gameplay against a CPU opponent
* Choice of starting Pokemon
  * Bulbasaur
  * Charmander
  * Charmeleon
  * Charizard
  * Squirtle
* Pokemon battles with turn-based attacking
* Type effectiveness and weaknesses between Pokemon types
* Pokemon abilities that boost attacks under certain conditions
* Animated Pokemon sprites and battle background
* Nickname and customize your Pokemon's moves
* Win by defeating the opponent's Pokemon

## Code Overview

The main classes and files:

* StartHere - Sets up the initial JFrame and contains the main method to launch the game
* PlayerOne - Handles the player's Pokemon selection and customization
* PlayerTwo - Handles the CPU opponent's Pokemon selection
* Pokemon - Base Pokemon class for creating Pokemon objects
* Pokemon_Abilities - Subclass of Pokemon that adds abilities
* PokemonType - Enum containing the different Pokemon types
* Attack - Interface for attacks
* DamageAttack - Attack implementation for damaging moves
* StatusAttack - Attack implementation for status effect moves
* Battle - Manages the battle gameplay logic and turn sequence
  
The battle system calculates type effectiveness and processes turn order. Pokemon can have various statuses applied to them including falling asleep. Each Pokemon also has an ability that can boost attacks based on certain conditions like low health.

The player progresses through selecting their Pokemon, customizing moves, and nicknaming them. Then the battle phase begins where the player takes turns selecting attacks against the CPU opponent. The battle ends when one player's Pokemon faints.

## How to Run

This project requires Java 11 or higher. To run the game:

1. Clone the repository
2. Navigate to the project directory
3. Compile with javac *.java
4. Run java StartHere
5. Click the "Play" button to begin
   
The game window will initialize and you can begin your Pokemon journey!

## Future Improvements

Some potential expansions for the game:
* Add more Pokemon types and selections
* Improve battle animations and effects
* Expand movepool variety and add new status effects
* Implement trainable stats that grow as Pokemon level up
* Support additional gameplay modes like multiplayer
* Add persistent saving of Pokemon teams and progression
## Credits

Pokemon Java was created by Wilson Neira. The project serves as a code sample to demonstrate Java skills.
