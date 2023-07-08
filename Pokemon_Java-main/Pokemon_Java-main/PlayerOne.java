
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
    public static Button nickEnterBTN;
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public static void PCharOne()
    {
        Button charmanderBTN, charmeleonBTN, charizardBTN, bulbasaurBTN, squirtleBTN;
        scratchBox = new JCheckBox();
        emberBox = new JCheckBox();
        dragonBreathBox = new JCheckBox();
        fireFangBox = new JCheckBox();
        slashBox = new JCheckBox();
        flamethrowerBox = new JCheckBox();
        fireSpinBox = new JCheckBox();
        airSlashBox = new JCheckBox();
        dragonClawBox = new JCheckBox();
        infernoBox = new JCheckBox();
        flareBlitzBox = new JCheckBox();
        tackleBox = new JCheckBox();
        vineWhipBox = new JCheckBox();
        sleepPowderBox = new JCheckBox();
        takeDownBox = new JCheckBox();
        razorLeafBox = new JCheckBox();
        bubbleBox = new JCheckBox();
        waterGunBox = new JCheckBox();
        biteBox = new JCheckBox();
        bubbleBeamBox = new JCheckBox();

        pokemonPanel.removeAll();
        pokemonPanel.repaint();
        JLabel PokemonChooser = new JLabel("Choose your Pokemon:");
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
                pokemonNumber=1;
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

                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemonNick = pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        tackleBox = new JCheckBox("Tackle");
                        tackleBox.setBounds(170,70,240,40);
                        tackleBox.setBackground(Color.lightGray);
                        tackleBox.setForeground(Color.white);
                        tackleBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(tackleBox);
                        tackleBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        tackleBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(tackleBox,5);
                            }
                        });

                        //Creates button to add vinewhip attack to the attacks list in the battle class.
                        vineWhipBox = new JCheckBox("Vine Whip");
                        vineWhipBox.setBounds(170,150,240,40);
                        vineWhipBox.setBackground(Color.GREEN);
                        vineWhipBox.setForeground(Color.white);
                        vineWhipBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(vineWhipBox);
                        vineWhipBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        vineWhipBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(vineWhipBox,5);
                            }
                        });

                        //Creates button to add sleeppowder attack to the attacks list in the battle class.
                        sleepPowderBox = new JCheckBox("Sleep Powder");
                        sleepPowderBox.setBounds(170,230,240,40);
                        sleepPowderBox.setBackground(Color.GREEN);
                        sleepPowderBox.setForeground(Color.white);
                        sleepPowderBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(sleepPowderBox);
                        sleepPowderBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        sleepPowderBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(sleepPowderBox,5);
                            }
                        });

                        //Creates button to add takedown attack to the attacks list in the battle class.
                        takeDownBox = new JCheckBox("Take Down");
                        takeDownBox.setBounds(170,310,240,40);
                        takeDownBox.setBackground(Color.LIGHT_GRAY);
                        takeDownBox.setForeground(Color.white);
                        takeDownBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(takeDownBox);
                        takeDownBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        takeDownBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(takeDownBox,5);
                            }
                        });

                        //Creates button to add razorleaf attack to the attacks list in the battle class.
                        razorLeafBox = new JCheckBox("Razor Leaf");
                        razorLeafBox.setBounds(170,390,240,40);
                        razorLeafBox.setBackground(Color.GREEN);
                        razorLeafBox.setForeground(Color.white);
                        razorLeafBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(razorLeafBox);
                        razorLeafBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        razorLeafBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(razorLeafBox,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(tackleBox);
                        disableMoves.add(vineWhipBox);
                        disableMoves.add(sleepPowderBox);
                        disableMoves.add(takeDownBox);
                        disableMoves.add(razorLeafBox);


                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        pokemonPanel.add(doneMoves);

                    }
                });

                pokemonPanel.add(nickEnterBTN);
            }
        });
        pokemonPanel.add(bulbasaurBTN);


        //Create Charmander select button.
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
                pokemonNumber=4;
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
                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemonNick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);

                        //Pokemon Move Button Selection
                        //Creates button to add scratch attack to the attacks list in the battle class.
                        scratchBox = new JCheckBox("Scratch");
                        scratchBox.setBounds(170,70,240,40);
                        scratchBox.setBackground(Color.lightGray);
                        scratchBox.setForeground(Color.white);
                        scratchBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(scratchBox);
                        scratchBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        scratchBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(scratchBox,5);
                            }
                        });

                        //Creates button to add ember attack to the attacks list in the battle class.
                        emberBox = new JCheckBox("Ember");
                        emberBox.setBounds(170,150,240,40);
                        emberBox.setBackground(Color.red);
                        emberBox.setForeground(Color.white);
                        emberBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(emberBox);
                        emberBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        emberBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(emberBox,5);
                            }
                        });

                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        dragonBreathBox = new JCheckBox("Dragon Breath");
                        dragonBreathBox.setBounds(170,230,240,40);
                        dragonBreathBox.setBackground(blueviolet);
                        dragonBreathBox.setForeground(Color.white);
                        dragonBreathBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonBreathBox);
                        dragonBreathBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonBreathBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(dragonBreathBox,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        fireFangBox = new JCheckBox("Fire Fang");
                        fireFangBox.setBounds(170,310,240,40);
                        fireFangBox.setBackground(Color.red);
                        fireFangBox.setForeground(Color.white);
                        fireFangBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireFangBox);
                        fireFangBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireFangBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               MoveDisabler(fireFangBox,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        slashBox = new JCheckBox("Slash");
                        slashBox.setBounds(170,390,240,40);
                        slashBox.setBackground(Color.lightGray);
                        slashBox.setForeground(Color.white);
                        slashBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(slashBox);
                        slashBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        slashBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(slashBox,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(scratchBox);
                        disableMoves.add(emberBox);
                        disableMoves.add(dragonBreathBox);
                        disableMoves.add(fireFangBox);
                        disableMoves.add(slashBox);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        pokemonPanel.add(doneMoves);

                    }
                });

                pokemonPanel.add(nickEnterBTN);
            }
        });
        //Add Pokemon Buttons to pokemonPanel here
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
                pokemonNumber = 5;
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
                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemonNick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        dragonBreathBox = new JCheckBox("Dragon Breath");
                        dragonBreathBox.setBounds(170,70,240,40);
                        dragonBreathBox.setBackground(blueviolet);
                        dragonBreathBox.setForeground(Color.white);
                        dragonBreathBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonBreathBox);
                        dragonBreathBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonBreathBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(dragonBreathBox,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        fireFangBox = new JCheckBox("Fire Fang ");
                        fireFangBox.setBounds(170,150,240,40);
                        fireFangBox.setBackground(Color.red);
                        fireFangBox.setForeground(Color.white);
                        fireFangBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireFangBox);
                        fireFangBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireFangBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(fireFangBox ,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        slashBox = new JCheckBox("Slash");
                        slashBox.setBounds(170,230,240,40);
                        slashBox.setBackground(Color.lightGray);
                        slashBox.setForeground(Color.white);
                        slashBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(slashBox);
                        slashBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        slashBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(slashBox,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        flamethrowerBox = new JCheckBox("Flamethrower");
                        flamethrowerBox.setBounds(170,310,240,40);
                        flamethrowerBox.setBackground(Color.red);
                        flamethrowerBox.setForeground(Color.white);
                        flamethrowerBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flamethrowerBox);
                        flamethrowerBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flamethrowerBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(flamethrowerBox,5);
                            }
                        });

                        //Creates button to add firespin attack to the attacks list in the battle class.
                        fireSpinBox = new JCheckBox("Fire Spin");
                        fireSpinBox.setBounds(170,390,240,40);
                        fireSpinBox.setBackground(Color.red);
                        fireSpinBox.setForeground(Color.white);
                        fireSpinBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(fireSpinBox);
                        fireSpinBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        fireSpinBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(fireSpinBox,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(dragonBreathBox);
                        disableMoves.add(fireFangBox);
                        disableMoves.add(slashBox);
                        disableMoves.add(flamethrowerBox);
                        disableMoves.add(fireSpinBox);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
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
                pokemonNumber=6;
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
                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemonNick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add airslash attack to the attacks list in the battle class.
                        airSlashBox = new JCheckBox("Air Slash");
                        airSlashBox.setBounds(170,70,240,40);
                        airSlashBox.setBackground(Color.cyan);
                        airSlashBox.setForeground(Color.white);
                        airSlashBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(airSlashBox);
                        airSlashBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        airSlashBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(airSlashBox,5);
                            }
                        });

                        //Creates button to add dragonclaw attack to the attacks list in the battle class.
                        dragonClawBox = new JCheckBox("Dragon Claw");
                        dragonClawBox.setBounds(170,150,240,40);
                        dragonClawBox.setBackground(blueviolet);
                        dragonClawBox.setForeground(Color.white);
                        dragonClawBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(dragonClawBox);
                        dragonClawBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        dragonClawBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(dragonClawBox ,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        flamethrowerBox = new JCheckBox("Flamethrower");
                        flamethrowerBox.setBounds(170,230,240,40);
                        flamethrowerBox.setBackground(Color.red);
                        flamethrowerBox.setForeground(Color.white);
                        flamethrowerBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flamethrowerBox);
                        flamethrowerBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flamethrowerBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(flamethrowerBox,5);
                            }
                        });

                        //Creates button to add inferno attack to the attacks list in the battle class.
                        infernoBox = new JCheckBox("Inferno");
                        infernoBox.setBounds(170,310,240,40);
                        infernoBox.setBackground(Color.red);
                        infernoBox.setForeground(Color.white);
                        infernoBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(infernoBox);
                        infernoBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        infernoBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(infernoBox,5);
                            }
                        });

                        //Creates button to add flareblitz attack to the attacks list in the battle class.
                        flareBlitzBox = new JCheckBox("Flare Blitz");
                        flareBlitzBox.setBounds(170,390,240,40);
                        flareBlitzBox.setBackground(Color.red);
                        flareBlitzBox.setForeground(Color.white);
                        flareBlitzBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(flareBlitzBox);
                        flareBlitzBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        flareBlitzBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(flareBlitzBox,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(airSlashBox);
                        disableMoves.add(dragonClawBox);
                        disableMoves.add(flamethrowerBox);
                        disableMoves.add(infernoBox);
                        disableMoves.add(flareBlitzBox);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
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
                pokemonNumber=7;
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

                        //This sets pokemonNick to equal the input of the nickname entry.
                        pokemonNick=pokeNickName.getText();

                        pokemonPanel.removeAll();
                        pokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        pokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        tackleBox = new JCheckBox("Tackle");
                        tackleBox.setBounds(170,70,240,40);
                        tackleBox.setBackground(Color.lightGray);
                        tackleBox.setForeground(Color.white);
                        tackleBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(tackleBox);
                        tackleBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        tackleBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(tackleBox,5);
                            }
                        });

                        //Creates button to add bubble attack to the attacks list in the battle class.
                        bubbleBox = new JCheckBox("Bubble");
                        bubbleBox.setBounds(170,150,240,40);
                        bubbleBox.setBackground(Color.blue);
                        bubbleBox.setForeground(Color.white);
                        bubbleBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(bubbleBox);
                        bubbleBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        bubbleBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(bubbleBox,5);
                            }
                        });

                        //Creates button to add watergun attack to the attacks list in the battle class.
                        waterGunBox = new JCheckBox("Water Gun");
                        waterGunBox.setBounds(170,230,240,40);
                        waterGunBox.setBackground(Color.blue);
                        waterGunBox.setForeground(Color.white);
                        waterGunBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(waterGunBox);
                        waterGunBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        waterGunBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(waterGunBox,5);
                            }
                        });

                        //Creates button to add bite attack to the attacks list in the battle class.
                        biteBox = new JCheckBox("Bite");
                        biteBox.setBounds(170,310,240,40);
                        biteBox.setBackground(Color.black);
                        biteBox.setForeground(Color.white);
                        biteBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(biteBox);
                        biteBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        biteBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(biteBox,5);
                            }
                        });

                        //Creates button to add bubblebeam attack to the attacks list in the battle class.
                        bubbleBeamBox = new JCheckBox("Bubble Beam");
                        bubbleBeamBox.setBounds(170,390,240,40);
                        bubbleBeamBox.setBackground(Color.blue);
                        bubbleBeamBox.setForeground(Color.white);
                        bubbleBeamBox.setFont(new Font("Arial", Font.BOLD, 30));
                        pokemonPanel.add(bubbleBeamBox);
                        bubbleBeamBox.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        bubbleBeamBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(bubbleBeamBox,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        disableMoves = new LinkedList<JCheckBox>();
                        disableMoves.add(tackleBox);
                        disableMoves.add(bubbleBox);
                        disableMoves.add(waterGunBox);
                        disableMoves.add(biteBox);
                        disableMoves.add(bubbleBeamBox);

                        doneMoves = new Button("Continue");
                        doneMoves.setBounds(200,500,200,60);
                        doneMoves.setBackground(Color.green);
                        doneMoves.setForeground(Color.white);
                        doneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        doneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
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

}



