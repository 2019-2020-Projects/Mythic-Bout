
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

/**
 * The PlayerTwo class lets the
 * player create a Pokemon for the cpu.
 * Then the class calls Battle.StartBattle().
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */



public class PlayerTwo extends StartHere
{
    private  Button nickEnterBTN;
    //This variable contains the Pokemon battle background image.
    private  ImageIcon PokemonBackground;
    //This JLabel contains the PokemonBackground ImageIcon.
    public  JLabel PokemonBox;
    //This Panel contains the Pokemon text output of the battle and next buttons to continue the battle.
    public Panel TextBox;
    //This Panel contains the Pokemon attacks buttons.
    public  Panel MovesBox;
    private  JCheckBox[] bulbasaurMoves;
    private  JCheckBox[] charmanderMoves;
    private  JCheckBox[] charmeleonMoves;
    private  JCheckBox[] charizardMoves;
    private  JCheckBox[] squirtleMoves;

    public PlayerTwo() {
        this.nickEnterBTN = nickEnterBTN;
        this.PokemonBackground = PokemonBackground;
        this.PokemonBox = PokemonBox;
        this.TextBox = TextBox;
        this.MovesBox = MovesBox;
        this.bulbasaurMoves = bulbasaurMoves;
        this.charmanderMoves = charmanderMoves;
        this.charmeleonMoves = charmeleonMoves;
        this.charizardMoves = charizardMoves;
        this.squirtleMoves = squirtleMoves;

    }
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public  void PCharTwo(StartHere startHere, PlayerOne playerOne, PlayerTwo playerTwo)
    {
        startHere.pokemonPanel.removeAll();
        startHere.pokemonPanel.repaint();

        JLabel PokemonChooser = new JLabel("Choose Pokemon CPU:");
        PokemonChooser.setBounds(20,10,300,25);
        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 25));
        startHere.pokemonPanel.add(PokemonChooser);

        //Create bulbasaurBTN select button.
        Button bulbasaurBTN = createButton("Bulbasaur", 20, 55, 160, 85,
                Color.green, Color.white, new Font("Arial", Font.BOLD, 25));

        //If bulbasaurBTN button is clicked the game will continue to the nickname selection screen.
        bulbasaurMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Vine Whip"),
                new JCheckBox("Sleep Powder"), new JCheckBox("Take Down"), new JCheckBox("Razor Leaf")};
        Color[] bulbasaurColors = {Color.lightGray, Color.green, Color.green, Color.lightGray, Color.green};
        addPokeButtonListener(bulbasaurBTN, 1, bulbasaurMoves, bulbasaurColors,
                startHere, playerOne, playerTwo);
        //Add Pokemon Buttons to pokemonPanel here
        startHere.pokemonPanel.add(bulbasaurBTN);

        //Create charmanderBTN select button.
        Button charmanderBTN = createButton("Charmander", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        charmanderMoves = new JCheckBox[] {new JCheckBox("Scratch"), new JCheckBox("Ember"),
                new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"), new JCheckBox("Slash")};
        Color[] charmanderColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        addPokeButtonListener(charmanderBTN, 4, charmanderMoves, charmanderColors,
                startHere, playerOne, playerTwo);

        startHere.pokemonPanel.add(charmanderBTN);


        //Create charmeleonBTN select button.
        Button charmeleonBTN = createButton("Charmeleon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        charmeleonMoves = new JCheckBox[] {new JCheckBox("Dragon Breath"), new JCheckBox("Fire Fang"),
                new JCheckBox("Slash"), new JCheckBox("Flamethrower"), new JCheckBox("Fire Spin")};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
        addPokeButtonListener(charmeleonBTN, 5, charmeleonMoves, charmeleonColors,
                startHere, playerOne, playerTwo);
        //Add Pokemon Buttons to pokemonPanel here
        startHere.pokemonPanel.add(charmeleonBTN);


        //Create charizardBTN select button.
        Button charizardBTN = createButton("Charizard", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        charizardMoves = new JCheckBox[] {new JCheckBox("Air Slash"), new JCheckBox("Dragon Claw"),
                new JCheckBox("Flamethrower"), new JCheckBox("Inferno"), new JCheckBox("Flare Blitz")};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
        addPokeButtonListener(charizardBTN, 6, charizardMoves, charizardColors,
                startHere, playerOne, playerTwo);
        //Add Pokemon Buttons to pokemonPanel here
        startHere.pokemonPanel.add(charizardBTN);

        //Create squirtleBTN select button.
        Button squirtleBTN = createButton("Squirtle", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        squirtleMoves = new JCheckBox[] {new JCheckBox("Tackle"), new JCheckBox("Bubble"),
                new JCheckBox("Water Gun"), new JCheckBox("Bite"), new JCheckBox("Bubble Beam")};
        Color[] squirtleColors = {Color.lightGray, Color.blue, Color.blue, Color.black, Color.blue};
        addPokeButtonListener(squirtleBTN, 7, squirtleMoves, squirtleColors,
                startHere, playerOne, playerTwo);
        //Add Pokemon Buttons to pokemonPanel here
        startHere.pokemonPanel.add(squirtleBTN);
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

    private  Button addPokeButtonListener(Button btn, int pokeNum, JCheckBox[] pokemonMoves, Color[] pokemonColors,
                                          StartHere startHere, PlayerOne playerOne, PlayerTwo playerTwo) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                startHere.pokemonNumber2 = pokeNum;
                startHere.pokemonPanel.removeAll();
                startHere.pokemonPanel.repaint();

                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                startHere.pokemonPanel.add(PokemonChooser);

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
                startHere.pokemonPanel.add(pokeNickName);

                nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                        Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

                //Make game continue to Pokemon move selection screen.
                nickEnterBTN.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        startHere.pokemonCount = 0;

                        //This sets pokemonNick to equal the input of the nickname entry.
                        startHere.pokemonNick2 = pokeNickName.getText();
                        startHere.pokemonPanel.removeAll();
                        startHere.pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        startHere.pokemonPanel.add(PokemonChooser);
                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        startHere.disableMoves = new LinkedList<JCheckBox>();
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
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
                            startHere.pokemonPanel.add(pokemonMoves[i]);
                            pokemonMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            pokemonMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    playerOne.MoveDisabler(pokemonMoves[finalI],5, startHere);
                                }
                            });
                            startHere.disableMoves.add(pokemonMoves[i]);
                        }
                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                startHere.pokemonPanel.removeAll();
                                startHere.pokemonPanel.repaint();

                                //PokemonBackground will contain an image png.
                                PokemonBackground = new ImageIcon(getClass().getResource("PokemonImages/PokemonBackground.png"));
                                Image PokeBack = PokemonBackground.getImage();
                                //Resize PokemonBackground png.
                                Image PokeBackReSize = PokeBack.getScaledInstance(600,600, Image.SCALE_SMOOTH);
                                PokemonBackground = new ImageIcon(PokeBackReSize);
                                PokemonBox = new JLabel();
                                PokemonBox.setBounds(0,-80,600,700);
                                //Set PokemonBackground to appear.
                                PokemonBox.setIcon(PokemonBackground);
                                startHere.pokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle battle = new Battle();
                                battle.StartBattle(startHere, playerOne, playerTwo, battle);
                                startHere.pokemonPanel.repaint();
                            }
                        });
                        startHere.pokemonPanel.add(doneMoves);
                    }
                });
                startHere.pokemonPanel.add(nickEnterBTN);
            }
        });
        return btn;
    }

    public  JCheckBox[] getBulbasaurMoves () {
        return bulbasaurMoves;
    }

    public  JCheckBox[] getCharmanderMoves () {
        return charmanderMoves;
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
