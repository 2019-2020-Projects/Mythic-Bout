
import javax.swing.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * The PlayerOne class lets
 * the player create a Monster.
 * Then the class calls PlayerTwo.PCharTwo().
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */

public class PlayerOne extends StartHere
{
    private  Button nickEnterBTN;
    private  JCheckBox[] bulbasaurMoves;
    private  JCheckBox[] dragonCubMoves;
    private  JCheckBox[] charmeleonMoves;
    private  JCheckBox[] charizardMoves;
    private  JCheckBox[] squirtleMoves;

    public PlayerOne() {
        this.nickEnterBTN = nickEnterBTN;
        this.bulbasaurMoves = bulbasaurMoves;
        this.dragonCubMoves = dragonCubMoves;
        this.charmeleonMoves = charmeleonMoves;
        this.charizardMoves = charizardMoves;
        this.squirtleMoves = squirtleMoves;

    }

    //This method creates the Monster on the gui based on what buttons are clicked.
    public void PCharOne(StartHere startHere, PlayerOne playerOne)
    {
        startHere.getMonsterPanel().removeAll();
        startHere.getMonsterPanel().repaint();
        JLabel MonsterChooser = new JLabel("Choose your Monster:");
        MonsterChooser.setBounds(20,10,300,25);
        MonsterChooser.setFont(new Font("Arial", Font.BOLD, 25));
        startHere.getMonsterPanel().add(MonsterChooser);

        //Create bulbasaurBTN select button.
        Button bulbasaurBTN = createButton("Wyrmling", 20, 55, 160, 85,
                Color.green, Color.white, new Font("Arial", Font.BOLD, 25));

        //If bulbasaurBTN button is clicked the game will continue to the nickname selection screen.
        bulbasaurMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Vine Whip"),
                new JCheckBox("Sleep Powder"), new JCheckBox("Take Down"), new JCheckBox("Razor Leaf")};
        Color[] bulbasaurColors = {Color.lightGray, Color.green, Color.green, Color.lightGray, Color.green};
        addPokeButtonListener(bulbasaurBTN, 1, bulbasaurMoves, bulbasaurColors, startHere, playerOne);
        // Add Monster Buttons to monsterPanel here
        startHere.getMonsterPanel().add(bulbasaurBTN);


        //Create dragonCub select button.
        Button dragonCubBTN = createButton("Dragon Cub", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If dragonCubBTN button is clicked the game will continue to the nickname selection screen.
        dragonCubMoves = new JCheckBox[] {new JCheckBox("Scratch"), new JCheckBox("Ember"),
                new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"), new JCheckBox("Slash")};
        Color[] dragonCubColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        addPokeButtonListener(dragonCubBTN, 4, dragonCubMoves, dragonCubColors, startHere, playerOne);
        // Add Monster Buttons to monsterPanel here
        startHere.getMonsterPanel().add(dragonCubBTN);

        //Create charmeleonBTN select button.
        Button charmeleonBTN = createButton("Young Dragon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        charmeleonMoves = new JCheckBox[] {new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"),
                new JCheckBox("Slash"), new JCheckBox("Flamethrower"), new JCheckBox("Fire Spin")};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
        addPokeButtonListener(charmeleonBTN, 5, charmeleonMoves, charmeleonColors, startHere, playerOne);
        //Add Monster Buttons to monsterPanel here
        startHere.getMonsterPanel().add(charmeleonBTN);


        //Create charizardBTN select button.
        Button charizardBTN = createButton("Dragon", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        charizardMoves = new JCheckBox[] {new JCheckBox("Air Slash"), new JCheckBox("Dragon Claw"),
                new JCheckBox("Flamethrower"), new JCheckBox("Inferno"), new JCheckBox("Flare Blitz")};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
        addPokeButtonListener(charizardBTN, 6, charizardMoves, charizardColors, startHere, playerOne);
        //Add Monster Buttons to monsterPanel here
        startHere.getMonsterPanel().add(charizardBTN);

        //Create squirtleBTN select button.
        Button squirtleBTN = createButton("Sea Serpentling", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        squirtleMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Bubble"),
                new JCheckBox("Water Gun"), new JCheckBox("Bite"), new JCheckBox("Bubble Beam")};
        Color[] squirtleColors = {Color.lightGray, Color.blue, Color.blue, Color.black, Color.blue};
        addPokeButtonListener(squirtleBTN, 7, squirtleMoves, squirtleColors, startHere, playerOne);

        //Add Monster Buttons to monsterPanel here
        startHere.getMonsterPanel().add(squirtleBTN);
    }

    private  Button createButton(String label, int x, int y, int width,
                                      int height, Color bColor, Color fColor, Font font) {
        Button btn = new Button(label);
        btn.setBounds(x, y, width, height);
        btn.setBackground(bColor);
        btn.setForeground(fColor);
        btn.setFont(font);
        return btn;
    }

   private  Button addPokeButtonListener(Button btn, int pokeNum, JCheckBox[] monsterMoves,
                                         Color[] monsterColors, StartHere startHere, PlayerOne playerOne) {
       btn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //This sets what number of Monster in the pokedex player one will be.
               startHere.monsterNumber = pokeNum;
               startHere.getMonsterPanel().removeAll();
               startHere.getMonsterPanel().repaint();

               JLabel MonsterChooser = new JLabel("<html>Choose your Monster nickname:<br/>Leave the entry blank if you do not want a Monster nickname.<html>");
               MonsterChooser.setBounds(5,5,600,50);
               MonsterChooser.setFont(new Font("Arial", Font.BOLD, 19));
               startHere.getMonsterPanel().add(MonsterChooser);

               //Input your Monster nickname here.
               startHere.pokeNickName = new JTextField();
               startHere.pokeNickName.setBounds(175,150,250,50);
               startHere.pokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
               //Make Monster nickname entry only accept 12 characters.
               startHere.pokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                   public void keyTyped(java.awt.event.KeyEvent evt) {
                       if(startHere.pokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {
                           evt.consume();
                       }
                   }
               });
               startHere.getMonsterPanel().add(startHere.pokeNickName);

               nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                       Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

               // Make game continue to Monster move selection screen.
               nickEnterBTN.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       // This counts how many Monster Moves are checked.
                       startHere.monsterCount = 0;

                       // This sets monsterNick to equal the input of the nickname entry.
                       startHere.monsterNick = startHere.pokeNickName.getText();
                       startHere.getMonsterPanel().removeAll();
                       startHere.getMonsterPanel().repaint();

                       JLabel MonsterChooser = new JLabel("<html>Choose four Monster moves:<html>");
                       MonsterChooser.setBounds(5,5,600,50);
                       MonsterChooser.setFont(new Font("Arial", Font.BOLD, 20));
                       startHere.getMonsterPanel().add(MonsterChooser);
                       // Add all moves to a list to later be disabled when the amount of selected exceeds four.
                       startHere.disableMoves = new LinkedList<JCheckBox>();
                       // Monster Move Button Selection
                       // Creates button to add tackle attack to the attacks list in the battle class.
                       for(int i = 0; i < monsterMoves.length; i++) {
                           if(i == 0) {
                               monsterMoves[i].setBounds(170, 70, 240, 40);
                           }
                           else if(i == 1) {
                               monsterMoves[i].setBounds(170, 150, 240, 40);
                           }
                           else if(i == 2) {
                               monsterMoves[i].setBounds(170, 230, 240, 40);
                           }
                           else if(i == 3) {
                               monsterMoves[i].setBounds(170, 310, 240, 40);
                           }
                           else if(i == 4) {
                               monsterMoves[i].setBounds(170, 390, 240, 40);
                           }
                           monsterMoves[i].setBackground(monsterColors[i]);
                           monsterMoves[i].setForeground(Color.white);
                           monsterMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                           startHere.getMonsterPanel().add(monsterMoves[i]);
                           monsterMoves[i].setSelected(false);
                           //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                           int finalI = i;
                           monsterMoves[i].addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                   MoveDisabler(monsterMoves[finalI],5, startHere);
                               }
                           });
                           startHere.disableMoves.add(monsterMoves[i]);
                       }
                       doneMoves = new Button("Continue");
                       doneMoves.setBounds(200,500,200,60);
                       doneMoves.setBackground(Color.green);
                       doneMoves.setForeground(Color.white);
                       doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                       // Continue game to player two Monster selection screen.
                       doneMoves.addActionListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent e) {

                               // Starts Player Two Monster Selection
                               PlayerTwo playerTwo = new PlayerTwo();
                               playerTwo.PCharTwo(startHere, playerOne, playerTwo);
                           }
                       });
                       startHere.getMonsterPanel().add(doneMoves);

                   }
               });

               startHere.getMonsterPanel().add(nickEnterBTN);
           }
       });

        return btn;
    }


    //This method disables moves when four or more are selected and re-enables them when there are less than four selected.
    public  void MoveDisabler(JCheckBox Checker,int MoveNum, StartHere startHere)
    {
        try {
            //This for loop enables all attack buttons.
            for (int x = 0; x < MoveNum; x++) {
                startHere.disableMoves.get(x).setEnabled(true);
            }
            //The monsterCount will count how many moves are selected.
            if (Checker.isSelected()) {
                startHere.monsterCount++;
            }
            if (!Checker.isSelected()) {
                startHere.monsterCount--;
            }
            //If there are four Monster Moves selected all the attack buttons will get disabled.
            if (startHere.monsterCount == 4) {
                for (int x = 0; x < MoveNum; x++) {
                    if (!startHere.disableMoves.get(x).isSelected()) {
                        startHere.disableMoves.get(x).setEnabled(false);
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new IllegalArgumentException
                    ("Number of moves for MoveDisabler exceeds or is less than the number of available moves for the Monster");
        }
    }

    public  JCheckBox[] getBulbasaurMoves () {
        return bulbasaurMoves;
    }

    public  JCheckBox[] getdragonCubMoves () {
        return dragonCubMoves;
    }

    public  JCheckBox[] getCharmeleonMoves () {
        return charmeleonMoves;
    }

    public  JCheckBox[] getCharizardMoves () {
        return charizardMoves;
    }

    public  JCheckBox[] getSquirtleMoves () {
        return squirtleMoves;
    }

}



