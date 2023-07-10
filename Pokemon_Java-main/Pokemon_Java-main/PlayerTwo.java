
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
    private static Button nickEnterBTN;
    //This variable contains the Pokemon battle background image.
    public static ImageIcon PokemonBackground;
    //This JLabel contains the PokemonBackground ImageIcon.
    public static JLabel PokemonBox;
    //This Panel contains the Pokemon text output of the battle and next buttons to continue the battle.
    public static Panel TextBox;
    //This Panel contains the Pokemon attacks buttons.
    public static Panel MovesBox;
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public static void PCharTwo()
    {
        scratch2Box = new JCheckBox("Scratch");
        ember2Box = new JCheckBox("Ember");
        dragonBreath2Box = new JCheckBox("Dragon Breath");
        fireFang2Box = new JCheckBox("Fire Fang");
        slash2Box = new JCheckBox("Slash");
        flamethrower2Box = new JCheckBox("Flamethrower");
        fireSpin2Box = new JCheckBox("Fire Spin");
        airSlash2Box = new JCheckBox("Air Slash");
        dragonClaw2Box = new JCheckBox("Dragon Claw");
        inferno2Box = new JCheckBox("Inferno");
        flareBlitz2Box = new JCheckBox("Flare Blitz");
        tackle2Box = new JCheckBox("Tackle");
        vineWhip2Box = new JCheckBox("Vine Whip");
        sleepPowder2Box = new JCheckBox("Sleep Powder");
        takeDown2Box = new JCheckBox("Take Down");
        razorLeaf2Box = new JCheckBox("Razor Leaf");
        bubble2Box = new JCheckBox("Bubble");
        waterGun2Box = new JCheckBox("Water Gun");
        bite2Box = new JCheckBox("Bite");
        bubbleBeam2Box = new JCheckBox("Bubble Beam");

        pokemonPanel.removeAll();
        pokemonPanel.repaint();

        JLabel PokemonChooser = new JLabel("Choose Pokemon CPU:");
        PokemonChooser.setBounds(20,10,300,25);
        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 25));
        pokemonPanel.add(PokemonChooser);

        //Create bulbasaurBTN select button.
        Button bulbasaurBTN = createButton("Bulbasaur", 20, 55, 160, 85,
                Color.green, Color.white, new Font("Arial", Font.BOLD, 25));

        //If bulbasaurBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] bulbasaurMoves = {tackle2Box, vineWhip2Box, sleepPowder2Box, takeDown2Box, razorLeaf2Box};
        Color[] bulbasaurColors = {Color.lightGray, Color.green, Color.green, Color.lightGray, Color.green};
        addPokeButtonListener(bulbasaurBTN, 1, bulbasaurMoves, bulbasaurColors);
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(bulbasaurBTN);

        //Create charmanderBTN select button.
        Button charmanderBTN = createButton("Charmander", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmanderMoves = {scratch2Box, ember2Box, dragonBreath2Box, fireFang2Box, slash2Box};
        Color[] charmanderColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        addPokeButtonListener(charmanderBTN, 4, charmanderMoves, charmanderColors);

        pokemonPanel.add(charmanderBTN);


        //Create charmeleonBTN select button.
        Button charmeleonBTN = createButton("Charmeleon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmeleonMoves = {dragonBreath2Box, fireFang2Box, slash2Box, flamethrower2Box, fireSpin2Box};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
        addPokeButtonListener(charmeleonBTN, 5, charmeleonMoves, charmeleonColors);
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charmeleonBTN);


        //Create charizardBTN select button.
        Button charizardBTN = createButton("Charizard", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charizardMoves = {airSlash2Box, dragonClaw2Box, flamethrower2Box, inferno2Box, flareBlitz2Box};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
        addPokeButtonListener(charizardBTN, 6, charizardMoves, charizardColors);
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charizardBTN);

        //Create squirtleBTN select button.
        Button squirtleBTN = createButton("Squirtle", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] squirtleMoves = {tackle2Box, bubble2Box, waterGun2Box, bite2Box, bubbleBeam2Box};
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
                pokemonNumber2 = pokeNum;
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
                        //This counts how many Pokemon Moves are checked.
                        pokemonCount = 0;

                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemon2Nick = pokeNickName.getText();
                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
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
                            pokemonPanel.add(pokemonMoves[i]);
                            pokemonMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            pokemonMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(pokemonMoves[finalI],5);
                                }
                            });
                            disableMoves.add(pokemonMoves[i]);
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

                                pokemonPanel.removeAll();
                                pokemonPanel.repaint();

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
                                pokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                pokemonPanel.repaint();
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

}
