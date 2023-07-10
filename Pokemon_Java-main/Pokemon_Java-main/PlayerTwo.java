
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
    public static int pokemonCount;
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
        bulbasaurBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2 = 1;
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

                        //This sets pokemon2Nick to equal the input of the nickname entry.
                        pokemon2Nick = pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();
                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.


                        for(int i = 0; i < bulbasaurMoves.length; i++) {
                            if(i == 0) {
                                bulbasaurMoves[i].setBounds(170, 70, 240, 40);
                            }
                            else if(i == 1) {
                                bulbasaurMoves[i].setBounds(170, 150, 240, 40);
                            }
                            else if(i == 2) {
                                bulbasaurMoves[i].setBounds(170, 230, 240, 40);
                            }
                            else if(i == 3) {
                                bulbasaurMoves[i].setBounds(170, 310, 240, 40);
                            }
                            else if(i == 4) {
                                bulbasaurMoves[i].setBounds(170, 390, 240, 40);
                            }
                            bulbasaurMoves[i].setBackground(bulbasaurColors[i]);
                            bulbasaurMoves[i].setForeground(Color.white);
                            bulbasaurMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                            pokemonPanel.add(bulbasaurMoves[i]);
                            bulbasaurMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            bulbasaurMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(bulbasaurMoves[finalI],5);
                                }
                            });
                        }

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(tackle2Box);
                        disableMoves.add(vineWhip2Box);
                        disableMoves.add(sleepPowder2Box);
                        disableMoves.add(takeDown2Box);
                        disableMoves.add(razorLeaf2Box);


                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to the Pokemon battle sequence.
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
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(bulbasaurBTN);

        //Create charmanderBTN select button.
        Button charmanderBTN = createButton("Charmander", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmanderMoves = {scratch2Box, ember2Box, dragonBreath2Box, fireFang2Box, slash2Box};
        Color[] charmanderColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        charmanderBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2 = 4;
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
                        pokemonCount= 0;

                        //This sets pokemon2Nick to equal the input of the nickname entry.
                        pokemon2Nick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();
                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);

                        //Pokemon Move Button Selection
                        //Creates button to add scratch attack to the attacks list in the battle class.
                        for(int i = 0; i < charmanderMoves.length; i++) {
                            if(i == 0) {
                                charmanderMoves[i].setBounds(170, 70, 240, 40);
                            }
                            else if(i == 1) {
                                charmanderMoves[i].setBounds(170, 150, 240, 40);
                            }
                            else if(i == 2) {
                                charmanderMoves[i].setBounds(170, 230, 240, 40);
                            }
                            else if(i == 3) {
                                charmanderMoves[i].setBounds(170, 310, 240, 40);
                            }
                            else if(i == 4) {
                                charmanderMoves[i].setBounds(170, 390, 240, 40);
                            }
                            charmanderMoves[i].setBackground(charmanderColors[i]);
                            charmanderMoves[i].setForeground(Color.white);
                            charmanderMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                            pokemonPanel.add(charmanderMoves[i]);
                            charmanderMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            charmanderMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(charmanderMoves[finalI],5);
                                }
                            });
                        }

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(scratch2Box);
                        disableMoves.add(ember2Box);
                        disableMoves.add(dragonBreath2Box);
                        disableMoves.add(fireFang2Box);
                        disableMoves.add(slash2Box);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to the Pokemon battle sequence.
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

        pokemonPanel.add(charmanderBTN);



        //Create charmeleonBTN select button.
        Button charmeleonBTN = createButton("Charmeleon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmeleonMoves = {dragonBreath2Box, fireFang2Box, slash2Box, flamethrower2Box, fireSpin2Box};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
        charmeleonBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2 = 5;
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

                        //This sets pokemon2Nick to equal the input of the nickname entry.
                        pokemon2Nick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        for(int i = 0; i < charmeleonMoves.length; i++) {
                            if(i == 0) {
                                charmeleonMoves[i].setBounds(170, 70, 240, 40);
                            }
                            else if(i == 1) {
                                charmeleonMoves[i].setBounds(170, 150, 240, 40);
                            }
                            else if(i == 2) {
                                charmeleonMoves[i].setBounds(170, 230, 240, 40);
                            }
                            else if(i == 3) {
                                charmeleonMoves[i].setBounds(170, 310, 240, 40);
                            }
                            else if(i == 4) {
                                charmeleonMoves[i].setBounds(170, 390, 240, 40);
                            }
                            charmeleonMoves[i].setBackground(charmeleonColors[i]);
                            charmeleonMoves[i].setForeground(Color.white);
                            charmeleonMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                            pokemonPanel.add(charmeleonMoves[i]);
                            charmeleonMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            charmeleonMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(charmeleonMoves[finalI],5);
                                }
                            });
                        }

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(dragonBreath2Box);
                        disableMoves.add(fireFang2Box);
                        disableMoves.add(slash2Box);
                        disableMoves.add(flamethrower2Box);
                        disableMoves.add(fireSpin2Box);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
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
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charmeleonBTN);


        //Create charizardBTN select button.
        Button charizardBTN = createButton("Charizard", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charizardMoves = {airSlash2Box, dragonClaw2Box, flamethrower2Box, inferno2Box, flareBlitz2Box};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
        charizardBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2=6;
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

                        //This sets pokemon2Nick to equal the input of the nickname entry.
                        pokemon2Nick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add airslash attack to the attacks list in the battle class.
                        for(int i = 0; i < charizardMoves.length; i++) {
                            if(i == 0) {
                                charizardMoves[i].setBounds(170, 70, 240, 40);
                            }
                            else if(i == 1) {
                                charizardMoves[i].setBounds(170, 150, 240, 40);
                            }
                            else if(i == 2) {
                                charizardMoves[i].setBounds(170, 230, 240, 40);
                            }
                            else if(i == 3) {
                                charizardMoves[i].setBounds(170, 310, 240, 40);
                            }
                            else if(i == 4) {
                                charizardMoves[i].setBounds(170, 390, 240, 40);
                            }
                            charizardMoves[i].setBackground(charizardColors[i]);
                            charizardMoves[i].setForeground(Color.white);
                            charizardMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                            pokemonPanel.add(charizardMoves[i]);
                            charizardMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            charizardMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(charizardMoves[finalI], 5);
                                }
                            });
                        }

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(airSlash2Box);
                        disableMoves.add(dragonClaw2Box);
                        disableMoves.add(flamethrower2Box);
                        disableMoves.add(inferno2Box);
                        disableMoves.add(flareBlitz2Box);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
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
        //Add Pokemon Buttons to pokemonPanel here
        pokemonPanel.add(charizardBTN);

        //Create squirtleBTN select button.
        Button squirtleBTN = createButton("Squirtle", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] squirtleMoves = {tackle2Box, bubble2Box, waterGun2Box, bite2Box, bubbleBeam2Box};
        Color[] squirtleColors = {Color.lightGray, Color.blue, Color.blue, Color.black, Color.blue};
        squirtleBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2 = 7;
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

                        //This sets pokemon2Nick to equal the input of the nickname entry.
                        pokemon2Nick = pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        for(int i = 0; i < squirtleMoves.length; i++) {
                            if(i == 0) {
                                squirtleMoves[i].setBounds(170, 70, 240, 40);
                            }
                            else if(i == 1) {
                                squirtleMoves[i].setBounds(170, 150, 240, 40);
                            }
                            else if(i == 2) {
                                squirtleMoves[i].setBounds(170, 230, 240, 40);
                            }
                            else if(i == 3) {
                                squirtleMoves[i].setBounds(170, 310, 240, 40);
                            }
                            else if(i == 4) {
                                squirtleMoves[i].setBounds(170, 390, 240, 40);
                            }
                            squirtleMoves[i].setBackground(squirtleColors[i]);
                            squirtleMoves[i].setForeground(Color.white);
                            squirtleMoves[i].setFont(new Font("Arial", Font.BOLD, 30));
                            pokemonPanel.add(squirtleMoves[i]);
                            squirtleMoves[i].setSelected(false);
                            //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                            int finalI = i;
                            squirtleMoves[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    PlayerOne.MoveDisabler(squirtleMoves[finalI], 5);
                                }
                            });
                        }

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(tackle2Box);
                        disableMoves.add(bubble2Box);
                        disableMoves.add(waterGun2Box);
                        disableMoves.add(bite2Box);
                        disableMoves.add(bubbleBeam2Box);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
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

}
