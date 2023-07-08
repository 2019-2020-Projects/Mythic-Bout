
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
    //private static Button charmanderBTN, charmeleonBTN, charizardBTN, bulbasaurBTN, squirtleBTN, nickEnterBTN;
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
        Button charmanderBTN, charmeleonBTN, charizardBTN, bulbasaurBTN, squirtleBTN;
        scratch2Box = new JCheckBox();
        ember2Box = new JCheckBox();
        dragonBreath2Box = new JCheckBox();
        fireFang2Box = new JCheckBox();
        slash2Box = new JCheckBox();
        flamethrower2Box = new JCheckBox();
        fireSpin2Box = new JCheckBox();
        airSlash2Box = new JCheckBox();
        dragonClaw2Box = new JCheckBox();
        inferno2Box = new JCheckBox();
        flareBlitz2Box = new JCheckBox();
        tackle2Box = new JCheckBox();
        vineWhip2Box = new JCheckBox();
        sleepPowder2Box = new JCheckBox();
        takeDown2Box = new JCheckBox();
        razorLeaf2Box = new JCheckBox();
        bubble2Box = new JCheckBox();
        waterGun2Box = new JCheckBox();
        bite2Box = new JCheckBox();
        bubbleBeam2Box = new JCheckBox();

        pokemonPanel.removeAll();
        pokemonPanel.repaint();

        JLabel PokemonChooser = new JLabel("Choose Pokemon CPU:");
        PokemonChooser.setBounds(20,10,300,25);
        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 25));
        pokemonPanel.add(PokemonChooser);

        //Create bulbasaurBTN select button.
        bulbasaurBTN = new Button("Bulbasaur");
        bulbasaurBTN.setBounds(20,55,160,85);
        bulbasaurBTN.setBackground(Color.green);
        bulbasaurBTN.setForeground(Color.white);
        bulbasaurBTN.setFont(new Font("Arial", Font.BOLD, 25));
        //If bulbasaurBTN button is clicked the game will continue to the nickname selection screen.
        bulbasaurBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2=1;
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

                nickEnterBTN = new Button("Enter");
                nickEnterBTN.setBounds(200,270,200,60);
                nickEnterBTN.setBackground(Color.green);
                nickEnterBTN.setForeground(Color.white);
                nickEnterBTN.setFont(new Font("Arial", Font.BOLD, 30));

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
                        tackle2Box = new JCheckBox("Tackle");
                        tackle2Box.setBounds(170,70,240,40);
                        tackle2Box.setBackground(Color.lightGray);
                        tackle2Box.setForeground(Color.white);
                        tackle2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(tackle2Box);
                        tackle2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        tackle2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(tackle2Box,5);
                            }
                        });

                        //Creates button to add vinewhip attack to the attacks list in the battle class.
                        vineWhip2Box = new JCheckBox("Vine Whip");
                        vineWhip2Box.setBounds(170,150,240,40);
                        vineWhip2Box.setBackground(Color.GREEN);
                        vineWhip2Box.setForeground(Color.white);
                        vineWhip2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(vineWhip2Box);
                        vineWhip2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        vineWhip2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(vineWhip2Box,5);
                            }
                        });

                        //Creates button to add sleeppowder attack to the attacks list in the battle class.
                        sleepPowder2Box = new JCheckBox("Sleep Powder");
                        sleepPowder2Box.setBounds(170,230,240,40);
                        sleepPowder2Box.setBackground(Color.GREEN);
                        sleepPowder2Box.setForeground(Color.white);
                        sleepPowder2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(sleepPowder2Box);
                        sleepPowder2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        sleepPowder2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(sleepPowder2Box,5);
                            }
                        });

                        //Creates button to add takedown attack to the attacks list in the battle class.
                        takeDown2Box = new JCheckBox("Take Down");
                        takeDown2Box.setBounds(170,310,240,40);
                        takeDown2Box.setBackground(Color.LIGHT_GRAY);
                        takeDown2Box.setForeground(Color.white);
                        takeDown2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(takeDown2Box);
                        takeDown2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        takeDown2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(takeDown2Box,5);
                            }
                        });

                        //Creates button to add razorleaf attack to the attacks list in the battle class.
                        razorLeaf2Box = new JCheckBox("Razor Leaf");
                        razorLeaf2Box.setBounds(170,390,240,40);
                        razorLeaf2Box.setBackground(Color.GREEN);
                        razorLeaf2Box.setForeground(Color.white);
                        razorLeaf2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(razorLeaf2Box);
                        razorLeaf2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        razorLeaf2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(razorLeaf2Box,5);
                            }
                        });

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
        charmanderBTN = new Button("Charmander");
        charmanderBTN.setBounds(20,160,160,85);
        charmanderBTN.setBackground(Color.red);
        charmanderBTN.setForeground(Color.white);
        charmanderBTN.setFont(new Font("Arial", Font.BOLD, 25));
        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        charmanderBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2=4;
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

                nickEnterBTN = new Button("Enter");
                nickEnterBTN.setBounds(200,270,200,60);
                nickEnterBTN.setBackground(Color.green);
                nickEnterBTN.setForeground(Color.white);
                nickEnterBTN.setFont(new Font("Arial", Font.BOLD, 30));

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
                        scratch2Box = new JCheckBox("Scratch");
                        scratch2Box.setBounds(170,70,240,40);
                        scratch2Box.setBackground(Color.lightGray);
                        scratch2Box.setForeground(Color.white);
                        scratch2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(scratch2Box);
                        scratch2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        scratch2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(scratch2Box,5);
                            }
                        });

                        //Creates button to add ember attack to the attacks list in the battle class.
                        ember2Box = new JCheckBox("Ember");
                        ember2Box.setBounds(170,150,240,40);
                        ember2Box.setBackground(Color.red);
                        ember2Box.setForeground(Color.white);
                        ember2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(ember2Box);
                        ember2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        ember2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(ember2Box,5);
                            }
                        });

                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        dragonBreath2Box = new JCheckBox("Dragon Breath");
                        dragonBreath2Box.setBounds(170,230,240,40);
                        dragonBreath2Box.setBackground(blueviolet);
                        dragonBreath2Box.setForeground(Color.white);
                        dragonBreath2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonBreath2Box);
                        dragonBreath2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonBreath2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                              PlayerOne.MoveDisabler(dragonBreath2Box,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        fireFang2Box = new JCheckBox("Fire Fang");
                        fireFang2Box.setBounds(170,310,240,40);
                        fireFang2Box.setBackground(Color.red);
                        fireFang2Box.setForeground(Color.white);
                        fireFang2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireFang2Box);
                        fireFang2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireFang2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(fireFang2Box,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        slash2Box = new JCheckBox("Slash");
                        slash2Box.setBounds(170,390,240,40);
                        slash2Box.setBackground(Color.lightGray);
                        slash2Box.setForeground(Color.white);
                        slash2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(slash2Box);
                        slash2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        slash2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(slash2Box,5);
                            }
                        });

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
        charmeleonBTN = new Button("Charmeleon");
        charmeleonBTN.setBounds(200,160,160,85);
        charmeleonBTN.setBackground(Color.red);
        charmeleonBTN.setForeground(Color.white);
        charmeleonBTN.setFont(new Font("Arial", Font.BOLD, 25));
        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        charmeleonBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2=5;
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

                nickEnterBTN = new Button("Enter");
                nickEnterBTN.setBounds(200,270,200,60);
                nickEnterBTN.setBackground(Color.green);
                nickEnterBTN.setForeground(Color.white);
                nickEnterBTN.setFont(new Font("Arial", Font.BOLD, 30));

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
                        dragonBreath2Box = new JCheckBox("Dragon Breath");
                        dragonBreath2Box.setBounds(170,70,240,40);
                        dragonBreath2Box.setBackground(blueviolet);
                        dragonBreath2Box.setForeground(Color.white);
                        dragonBreath2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonBreath2Box);
                        dragonBreath2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonBreath2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(dragonBreath2Box,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        fireFang2Box = new JCheckBox("Fire Fang ");
                        fireFang2Box.setBounds(170,150,240,40);
                        fireFang2Box.setBackground(Color.red);
                        fireFang2Box.setForeground(Color.white);
                        fireFang2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireFang2Box );
                        fireFang2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireFang2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(fireFang2Box ,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        slash2Box = new JCheckBox("Slash");
                        slash2Box.setBounds(170,230,240,40);
                        slash2Box.setBackground(Color.lightGray);
                        slash2Box.setForeground(Color.white);
                        slash2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(slash2Box);
                        slash2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        slash2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(slash2Box,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        flamethrower2Box = new JCheckBox("Flamethrower");
                        flamethrower2Box.setBounds(170,310,240,40);
                        flamethrower2Box.setBackground(Color.red);
                        flamethrower2Box.setForeground(Color.white);
                        flamethrower2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flamethrower2Box);
                        flamethrower2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flamethrower2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(flamethrower2Box,5);
                            }
                        });

                        //Creates button to add firespin attack to the attacks list in the battle class.
                        fireSpin2Box = new JCheckBox("Fire Spin");
                        fireSpin2Box.setBounds(170,390,240,40);
                        fireSpin2Box.setBackground(Color.red);
                        fireSpin2Box.setForeground(Color.white);
                        fireSpin2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireSpin2Box);
                        fireSpin2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireSpin2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(fireSpin2Box,5);
                            }
                        });

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
        charizardBTN = new Button("Charizard");
        charizardBTN.setBounds(380,160,160,85);
        charizardBTN.setBackground(Color.red);
        charizardBTN.setForeground(Color.white);
        charizardBTN.setFont(new Font("Arial", Font.BOLD, 25));
        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
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

                nickEnterBTN = new Button("Enter");
                nickEnterBTN.setBounds(200,270,200,60);
                nickEnterBTN.setBackground(Color.green);
                nickEnterBTN.setForeground(Color.white);
                nickEnterBTN.setFont(new Font("Arial", Font.BOLD, 30));

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
                        airSlash2Box = new JCheckBox("Air Slash");
                        airSlash2Box.setBounds(170,70,240,40);
                        airSlash2Box.setBackground(Color.cyan);
                        airSlash2Box.setForeground(Color.white);
                        airSlash2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(airSlash2Box);
                        airSlash2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        airSlash2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(airSlash2Box,5);
                            }
                        });

                        //Creates button to add dragonclaw attack to the attacks list in the battle class.
                        dragonClaw2Box = new JCheckBox("Dragon Claw");
                        dragonClaw2Box.setBounds(170,150,240,40);
                        dragonClaw2Box.setBackground(blueviolet);
                        dragonClaw2Box.setForeground(Color.white);
                        dragonClaw2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonClaw2Box);
                        dragonClaw2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonClaw2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(dragonClaw2Box,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        flamethrower2Box = new JCheckBox("Flamethrower");
                        flamethrower2Box.setBounds(170,230,240,40);
                        flamethrower2Box.setBackground(Color.red);
                        flamethrower2Box.setForeground(Color.white);
                        flamethrower2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flamethrower2Box);
                        flamethrower2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flamethrower2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(flamethrower2Box,5);
                            }
                        });

                        //Creates button to add inferno attack to the attacks list in the battle class.
                        inferno2Box = new JCheckBox("Inferno");
                        inferno2Box.setBounds(170,310,240,40);
                        inferno2Box.setBackground(Color.red);
                        inferno2Box.setForeground(Color.white);
                        inferno2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(inferno2Box);
                        inferno2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        inferno2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(inferno2Box,5);
                            }
                        });

                        //Creates button to add flareblitz attack to the attacks list in the battle class.
                        flareBlitz2Box = new JCheckBox("Flare Blitz");
                        flareBlitz2Box.setBounds(170,390,240,40);
                        flareBlitz2Box.setBackground(Color.red);
                        flareBlitz2Box.setForeground(Color.white);
                        flareBlitz2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flareBlitz2Box);
                        flareBlitz2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flareBlitz2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(flareBlitz2Box,5);
                            }
                        });

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
        squirtleBTN = new Button("Squirtle");
        squirtleBTN.setBounds(20,265,160,85);
        squirtleBTN.setBackground(Color.blue);
        squirtleBTN.setForeground(Color.white);
        squirtleBTN.setFont(new Font("Arial", Font.BOLD, 25));
        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        squirtleBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber2=7;
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

                nickEnterBTN = new Button("Enter");
                nickEnterBTN.setBounds(200,270,200,60);
                nickEnterBTN.setBackground(Color.green);
                nickEnterBTN.setForeground(Color.white);
                nickEnterBTN.setFont(new Font("Arial", Font.BOLD, 30));
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
                        tackle2Box = new JCheckBox("Tackle");
                        tackle2Box.setBounds(170,70,240,40);
                        tackle2Box.setBackground(Color.lightGray);
                        tackle2Box.setForeground(Color.white);
                        tackle2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(tackle2Box);
                        tackle2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        tackle2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(tackle2Box,5);
                            }
                        });

                        //Creates button to add bubble attack to the attacks list in the battle class.
                        bubble2Box = new JCheckBox("Bubble");
                        bubble2Box.setBounds(170,150,240,40);
                        bubble2Box.setBackground(Color.blue);
                        bubble2Box.setForeground(Color.white);
                        bubble2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(bubble2Box);
                        bubble2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        bubble2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(bubble2Box,5);
                            }
                        });

                        //Creates button to add watergun attack to the attacks list in the battle class.
                        waterGun2Box = new JCheckBox("Water Gun");
                        waterGun2Box.setBounds(170,230,240,40);
                        waterGun2Box.setBackground(Color.blue);
                        waterGun2Box.setForeground(Color.white);
                        waterGun2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(waterGun2Box);
                        waterGun2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        waterGun2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(waterGun2Box,5);
                            }
                        });

                        //Creates button to add bite attack to the attacks list in the battle class.
                        bite2Box = new JCheckBox("Bite");
                        bite2Box.setBounds(170,310,240,40);
                        bite2Box.setBackground(Color.black);
                        bite2Box.setForeground(Color.white);
                        bite2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(bite2Box);
                        bite2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        bite2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(bite2Box,5);
                            }
                        });

                        //Creates button to add bubblebeam attack to the attacks list in the battle class.
                        bubbleBeam2Box = new JCheckBox("Bubble Beam");
                        bubbleBeam2Box.setBounds(170,390,240,40);
                        bubbleBeam2Box.setBackground(Color.blue);
                        bubbleBeam2Box.setForeground(Color.white);
                        bubbleBeam2Box.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(bubbleBeam2Box);
                        bubbleBeam2Box.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        bubbleBeam2Box.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(bubbleBeam2Box,5);
                            }
                        });

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

}
