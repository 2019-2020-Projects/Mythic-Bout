
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * The PlayerOne class lets
 * the player create a Pokemon.
 * Then the class calls PlayerTwo.PCharTwo().
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */

public class PlayerOne extends StartHere
{
    private static Button nickEnterBTN;
    private static JCheckBox[] bulbasaurMoves;
    private static JCheckBox[] charmanderMoves;
    private static JCheckBox[] charmeleonMoves;
    private static JCheckBox[] charizardMoves;
    private static JCheckBox[] squirtleMoves;
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public static void PCharOne()
    {
        pokemonPanel.removeAll();
        pokemonPanel.repaint();
        JLabel PokemonChooser = new JLabel("Choose your Pokemon:");
        PokemonChooser.setBounds(20,10,300,25);
        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 25));
        pokemonPanel.add(PokemonChooser);

        //Create bulbasaurBTN select button.
        Button bulbasaurBTN = createButton("Bulbasaur", 20, 55, 160, 85,
                Color.green, Color.white, new Font("Arial", Font.BOLD, 25));

        //If bulbasaurBTN button is clicked the game will continue to the nickname selection screen.
        bulbasaurMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Vine Whip"),
                new JCheckBox("Sleep Powder"), new JCheckBox("Take Down"), new JCheckBox("Razor Leaf")};
        Color[] bulbasaurColors = {Color.lightGray, Color.green, Color.green, Color.lightGray, Color.green};
        addPokeButtonListener(bulbasaurBTN, 1, bulbasaurMoves, bulbasaurColors);
        // Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(bulbasaurBTN);


        //Create Charmander select button.
        Button charmanderBTN = createButton("Charmander", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        charmanderMoves = new JCheckBox[] {new JCheckBox("Scratch"), new JCheckBox("Ember"),
                new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"), new JCheckBox("Slash")};
        Color[] charmanderColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        addPokeButtonListener(charmanderBTN, 4, charmanderMoves, charmanderColors);
        // Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charmanderBTN);

        //Create charmeleonBTN select button.
        Button charmeleonBTN = createButton("Charmeleon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        charmeleonMoves = new JCheckBox[] {new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"),
                new JCheckBox("Slash"), new JCheckBox("Flamethrower"), new JCheckBox("Fire Spin")};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
        addPokeButtonListener(charmeleonBTN, 5, charmeleonMoves, charmeleonColors);
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charmeleonBTN);


        //Create charizardBTN select button.
        Button charizardBTN = createButton("Charizard", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        charizardMoves = new JCheckBox[] {new JCheckBox("Air Slash"), new JCheckBox("Dragon Claw"),
                new JCheckBox("Flamethrower"), new JCheckBox("Inferno"), new JCheckBox("Flare Blitz")};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
        addPokeButtonListener(charizardBTN, 6, charizardMoves, charizardColors);
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charizardBTN);

        //Create squirtleBTN select button.
        Button squirtleBTN = createButton("Squirtle", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        squirtleMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Bubble"),
                new JCheckBox("Water Gun"), new JCheckBox("Bite"), new JCheckBox("Bubble Beam")};
        Color[] squirtleColors = {Color.lightGray, Color.blue, Color.blue, Color.black, Color.blue};
        addPokeButtonListener(squirtleBTN, 7, squirtleMoves, squirtleColors);

        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(squirtleBTN);
    }

    private static Button createButton(String label, int x, int y, int width,
                                      int height, Color bColor, Color fColor, Font font) {
        Button btn = new Button(label);
        btn.setBounds(x, y, width, height);
        btn.setBackground(bColor);
        btn.setForeground(fColor);
        btn.setFont(font);
        return btn;
    }

   private static Button addPokeButtonListener(Button btn, int pokeNum,
                                               JCheckBox[] pokemonMoves, Color[] pokemonColors) {
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //This sets what number of Pokemon in the pokedex player one will be.
               pokemonNumber = pokeNum;
               pokemonPanel.removeAll();
               pokemonPanel.repaint();

               JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
               PokemonChooser.setBounds(5,5,600,50);
               PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
               pokemonPanel.add(PokemonChooser);

               //Input your Pokemon nickname here.
               pokeNickName = new JTextField();
               pokeNickName.setBounds(175,150,250,50);
               pokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
               //Make Pokemon nickname entry only accept 12 characters.
               pokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                   public void keyTyped(java.awt.event.KeyEvent evt) {
                       if(pokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                           evt.consume();
                       }
                   }
               });
               pokemonPanel.add(pokeNickName);

               nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                       Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

               //Make game continue to Pokemon move selection screen.
               nickEnterBTN.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       // This counts how many Pokemon Moves are checked.
                       pokemonCount = 0;

                       // This sets pokemonNick to equal the input of the nickname entry.
                       pokemonNick = pokeNickName.getText();
                       pokemonPanel.removeAll();
                       pokemonPanel.repaint();

                       JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                       PokemonChooser.setBounds(5,5,600,50);
                       PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                       pokemonPanel.add(PokemonChooser);
                       // Add all moves to a list to later be disabled when the amount of selected exceeds four.
                       disableMoves = new LinkedList<JCheckBox>();
                       // Pokemon Move Button Selection
                       // Creates button to add tackle attack to the attacks list in the battle class.
                       for(int i = 0; i < pokemonMoves.length; i++) {
                           if(i == 0) {
                               pokemonMoves[i].setBounds(170, 70, 240, 40);
                           }
                           else if(i == 1) {
                               pokemonMoves[i].setBounds(170, 150, 240, 40);
                           }
                           else if(i == 2) {
                               pokemonMoves[i].setBounds(170, 230, 240, 40);
                           }
                           else if(i == 3) {
                               pokemonMoves[i].setBounds(170, 310, 240, 40);
                           }
                           else if(i == 4) {
                               pokemonMoves[i].setBounds(170, 390, 240, 40);
                           }
                           pokemonMoves[i].setBackground(pokemonColors[i]);
                           pokemonMoves[i].setForeground(Color.white);
                           pokemonMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                           pokemonPanel.add(pokemonMoves[i]);
                           pokemonMoves[i].setSelected(false);
                           //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                           int finalI = i;
                           pokemonMoves[i].addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   MoveDisabler(pokemonMoves[finalI],5);
                               }
                           });
                           disableMoves.add(pokemonMoves[i]);
                       }
                       doneMoves = new Button("Continue");
                       doneMoves.setBounds(200,500,200,60);
                       doneMoves.setBackground(Color.green);
                       doneMoves.setForeground(Color.white);
                       doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                       // Continue game to player two Pokemon selection screen.
                       doneMoves.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {

                               // Starts Player Two Pokemon Selection
                               PlayerTwo.PCharTwo();
                           }
                       });
                       pokemonPanel.add(doneMoves);

                   }
               });

               pokemonPanel.add(nickEnterBTN);
           }
       });

        return btn;
    }


    //This method disables moves when four or more are selected and re-enables them when there are less than four selected.
    public static void MoveDisabler(JCheckBox Checker,int MoveNum)
    {
        try {
            //This for loop enables all attack buttons.
            for (int x = 0; x < MoveNum; x++) {
                disableMoves.get(x).setEnabled(true);
            }
            //The pokemonCount will count how many moves are selected.
            if (Checker.isSelected()) {
                pokemonCount++;
            }
            if (!Checker.isSelected()) {
                pokemonCount--;
            }
            //If there are four Pokemon Moves selected all the attack buttons will get disabled.
            if (pokemonCount == 4) {
                for (int x = 0; x < MoveNum; x++) {
                    if (!disableMoves.get(x).isSelected()) {
                        disableMoves.get(x).setEnabled(false);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException
                    ("Number of moves for MoveDisabler exceeds or is less than the number of available moves for the Pokemon");
        }
    }

    public static JCheckBox[] getBulbasaurMoves () {
        return bulbasaurMoves;
    }

    public static JCheckBox[] getCharmanderMoves () {
        return charmanderMoves;
    }

    public static JCheckBox[] getCharmeleonMoves () {
        return charmeleonMoves;
    }

    public static JCheckBox[] getCharizardMoves () {
        return charizardMoves;
    }

    public static JCheckBox[] getSquirtleMoves () {
        return squirtleMoves;
    }

}



