
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
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public static void PCharOne()
    {
        PokemonPanel.removeAll();
        PokemonPanel.repaint();
        JLabel PokemonChooser = new JLabel("Choose your Pokemon:");
        PokemonChooser.setBounds(20,10,300,25);
        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 25));
        PokemonPanel.add(PokemonChooser);

        //Create Bulbasaur select button.
        Bulbasaur = new Button("Bulbasaur");
        Bulbasaur.setBounds(20,55,160,85);
        Bulbasaur.setBackground(Color.green);
        Bulbasaur.setForeground(Color.white);
        Bulbasaur.setFont(new Font("Arial", Font.BOLD, 25));

        //If Bulbasaur button is clicked the game will continue to the nickname selection screen.
        Bulbasaur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //This sets what number of Pokemon in the pokedex player one will be.
                PokemonNumber=1;
                PokemonPanel.removeAll();
                PokemonPanel.repaint();
                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                PokemonPanel.add(PokemonChooser);

                //Input your Pokemon nickname here.
                PokeNickName = new JTextField();
                PokeNickName.setBounds(175,150,250,50);
                PokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
                //Make Pokemon nickname entry only accept 12 characters.
                PokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if(PokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {

                            evt.consume();
                        }
                    }
                });

                PokemonPanel.add(PokeNickName);

                NickEnter = new Button("Enter");
                NickEnter.setBounds(200,270,200,60);
                NickEnter.setBackground(Color.green);
                NickEnter.setForeground(Color.white);
                NickEnter.setFont(new Font("Arial", Font.BOLD, 30));

                //Make game continue to Pokemon move selection screen.
                NickEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        PokemonCount = 0;

                        //This sets PokemonNick to equal the input of the nickname entry.
                        PokemonNick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        Tackle = new JCheckBox("Tackle");
                        Tackle.setBounds(170,70,240,40);
                        Tackle.setBackground(Color.lightGray);
                        Tackle.setForeground(Color.white);
                        Tackle.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Tackle);
                        Tackle.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Tackle.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Tackle,5);
                            }
                        });

                        //Creates button to add vinewhip attack to the attacks list in the battle class.
                        VineWhip = new JCheckBox("Vine Whip");
                        VineWhip.setBounds(170,150,240,40);
                        VineWhip.setBackground(Color.GREEN);
                        VineWhip.setForeground(Color.white);
                        VineWhip.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(VineWhip);
                        VineWhip.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        VineWhip.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(VineWhip,5);
                            }
                        });

                        //Creates button to add sleeppowder attack to the attacks list in the battle class.
                        SleepPowder= new JCheckBox("Sleep Powder");
                        SleepPowder.setBounds(170,230,240,40);
                        SleepPowder.setBackground(Color.GREEN);
                        SleepPowder.setForeground(Color.white);
                        SleepPowder.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(SleepPowder);
                        SleepPowder.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        SleepPowder.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(SleepPowder,5);
                            }
                        });

                        //Creates button to add takedown attack to the attacks list in the battle class.
                        TakeDown= new JCheckBox("Take Down");
                        TakeDown.setBounds(170,310,240,40);
                        TakeDown.setBackground(Color.LIGHT_GRAY);
                        TakeDown.setForeground(Color.white);
                        TakeDown.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(TakeDown);
                        TakeDown.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        TakeDown.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(TakeDown,5);
                            }
                        });

                        //Creates button to add razorleaf attack to the attacks list in the battle class.
                        RazorLeaf= new JCheckBox("Razor Leaf");
                        RazorLeaf.setBounds(170,390,240,40);
                        RazorLeaf.setBackground(Color.GREEN);
                        RazorLeaf.setForeground(Color.white);
                        RazorLeaf.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(RazorLeaf);
                        RazorLeaf.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        RazorLeaf.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(RazorLeaf,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Tackle);
                        DisableMoves.add(VineWhip);
                        DisableMoves.add(SleepPowder);
                        DisableMoves.add(TakeDown);
                        DisableMoves.add(RazorLeaf);


                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to player two Pokemon selection screen.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        PokemonPanel.add(Bulbasaur);


        //Create Charmander select button.
        Charmander = new Button("Charmander");
        Charmander.setBounds(20,160,160,85);
        Charmander.setBackground(Color.red);
        Charmander.setForeground(Color.white);
        Charmander.setFont(new Font("Arial", Font.BOLD, 25));

        //If Charmander button is clicked the game will continue to the nickname selection screen.
        Charmander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                PokemonNumber=4;
                PokemonPanel.removeAll();
                PokemonPanel.repaint();

                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                PokemonPanel.add(PokemonChooser);

                //Input your Pokemon nickname here.
                PokeNickName = new JTextField();
                PokeNickName.setBounds(175,150,250,50);
                PokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
                //Make Pokemon nickname entry only accept 12 characters.
                PokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if(PokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {

                            evt.consume();
                        }
                    }
                });

                PokemonPanel.add(PokeNickName);

                NickEnter = new Button("Enter");
                NickEnter.setBounds(200,270,200,60);
                NickEnter.setBackground(Color.green);
                NickEnter.setForeground(Color.white);
                NickEnter.setFont(new Font("Arial", Font.BOLD, 30));

                //Make game continue to Pokemon move selection screen.
                NickEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        PokemonCount = 0;
                        //This sets PokemonNick to equal the input of the nickname entry.
                        PokemonNick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);

                        //Pokemon Move Button Selection
                        //Creates button to add scratch attack to the attacks list in the battle class.
                        Scratch = new JCheckBox("Scratch");
                        Scratch.setBounds(170,70,240,40);
                        Scratch.setBackground(Color.lightGray);
                        Scratch.setForeground(Color.white);
                        Scratch.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Scratch);
                        Scratch.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Scratch.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Scratch,5);
                            }
                        });

                        //Creates button to add ember attack to the attacks list in the battle class.
                        Ember = new JCheckBox("Ember");
                        Ember.setBounds(170,150,240,40);
                        Ember.setBackground(Color.red);
                        Ember.setForeground(Color.white);
                        Ember.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Ember);
                        Ember.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Ember.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Ember,5);
                            }
                        });

                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        DragonBreath = new JCheckBox("Dragon Breath");
                        DragonBreath.setBounds(170,230,240,40);
                        DragonBreath.setBackground(Blueviolet);
                        DragonBreath.setForeground(Color.white);
                        DragonBreath.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonBreath);
                        DragonBreath.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonBreath.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(DragonBreath,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        FireFang = new JCheckBox("Fire Fang");
                        FireFang.setBounds(170,310,240,40);
                        FireFang.setBackground(Color.red);
                        FireFang.setForeground(Color.white);
                        FireFang.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireFang);
                        FireFang.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireFang.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                               MoveDisabler(FireFang,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        Slash = new JCheckBox("Slash");
                        Slash.setBounds(170,390,240,40);
                        Slash.setBackground(Color.lightGray);
                        Slash.setForeground(Color.white);
                        Slash.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Slash);
                        Slash.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Slash.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Slash,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Scratch);
                        DisableMoves.add(Ember);
                        DisableMoves.add(DragonBreath);
                        DisableMoves.add(FireFang);
                        DisableMoves.add(Slash);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to player two Pokemon selection screen.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        //Add Pokemon Buttons to PokemonPanel here
        PokemonPanel.add(Charmander);

        //Create Charmeleon select button.
        Charmeleon = new Button("Charmeleon");
        Charmeleon.setBounds(200,160,160,85);
        Charmeleon.setBackground(Color.red);
        Charmeleon.setForeground(Color.white);
        Charmeleon.setFont(new Font("Arial", Font.BOLD, 25));

        //If Charmeleon button is clicked the game will continue to the nickname selection screen.
        Charmeleon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                PokemonNumber=5;
                PokemonPanel.removeAll();
                PokemonPanel.repaint();

                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                PokemonPanel.add(PokemonChooser);

                //Input your Pokemon nickname here.
                PokeNickName = new JTextField();
                PokeNickName.setBounds(175,150,250,50);
                PokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
                //Make Pokemon nickname entry only accept 12 characters.
                PokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if(PokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {

                            evt.consume();
                        }
                    }
                });
                PokemonPanel.add(PokeNickName);

                NickEnter = new Button("Enter");
                NickEnter.setBounds(200,270,200,60);
                NickEnter.setBackground(Color.green);
                NickEnter.setForeground(Color.white);
                NickEnter.setFont(new Font("Arial", Font.BOLD, 30));

                //Make game continue to Pokemon move selection screen.
                NickEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        PokemonCount = 0;
                        //This sets PokemonNick to equal the input of the nickname entry.
                        PokemonNick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        DragonBreath = new JCheckBox("Dragon Breath");
                        DragonBreath.setBounds(170,70,240,40);
                        DragonBreath.setBackground(Blueviolet);
                        DragonBreath.setForeground(Color.white);
                        DragonBreath.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonBreath);
                        DragonBreath.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonBreath.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(DragonBreath,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        FireFang = new JCheckBox("Fire Fang ");
                        FireFang.setBounds(170,150,240,40);
                        FireFang.setBackground(Color.red);
                        FireFang.setForeground(Color.white);
                        FireFang.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireFang);
                        FireFang.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireFang.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(FireFang ,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        Slash = new JCheckBox("Slash");
                        Slash.setBounds(170,230,240,40);
                        Slash.setBackground(Color.lightGray);
                        Slash.setForeground(Color.white);
                        Slash.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Slash);
                        Slash.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Slash.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Slash,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        Flamethrower = new JCheckBox("Flamethrower");
                        Flamethrower.setBounds(170,310,240,40);
                        Flamethrower.setBackground(Color.red);
                        Flamethrower.setForeground(Color.white);
                        Flamethrower.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Flamethrower);
                        Flamethrower.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Flamethrower.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Flamethrower,5);
                            }
                        });

                        //Creates button to add firespin attack to the attacks list in the battle class.
                        FireSpin = new JCheckBox("Fire Spin");
                        FireSpin.setBounds(170,390,240,40);
                        FireSpin.setBackground(Color.red);
                        FireSpin.setForeground(Color.white);
                        FireSpin.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireSpin);
                        FireSpin.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireSpin.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(FireSpin,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(DragonBreath);
                        DisableMoves.add(FireFang);
                        DisableMoves.add(Slash);
                        DisableMoves.add(Flamethrower);
                        DisableMoves.add(FireSpin);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        //Add Pokemon Buttons to PokemonPanel here
        PokemonPanel.add(Charmeleon);



        //Create Charizard select button.
        Charizard = new Button("Charizard");
        Charizard.setBounds(380,160,160,85);
        Charizard.setBackground(Color.red);
        Charizard.setForeground(Color.white);
        Charizard.setFont(new Font("Arial", Font.BOLD, 25));
        //If Charizard button is clicked the game will continue to the nickname selection screen.
        Charizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                PokemonNumber=6;
                PokemonPanel.removeAll();
                PokemonPanel.repaint();

                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                PokemonPanel.add(PokemonChooser);

                //Input your Pokemon nickname here.
                PokeNickName = new JTextField();
                PokeNickName.setBounds(175,150,250,50);
                PokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
                //Make Pokemon nickname entry only accept 12 characters.
                PokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if(PokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {

                            evt.consume();
                        }
                    }
                });
                PokemonPanel.add(PokeNickName);

                NickEnter = new Button("Enter");
                NickEnter.setBounds(200,270,200,60);
                NickEnter.setBackground(Color.green);
                NickEnter.setForeground(Color.white);
                NickEnter.setFont(new Font("Arial", Font.BOLD, 30));
                //Make game continue to Pokemon move selection screen.
                NickEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        PokemonCount = 0;
                        //This sets PokemonNick to equal the input of the nickname entry.
                        PokemonNick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add airslash attack to the attacks list in the battle class.
                        AirSlash = new JCheckBox("Air Slash");
                        AirSlash.setBounds(170,70,240,40);
                        AirSlash.setBackground(Color.cyan);
                        AirSlash.setForeground(Color.white);
                        AirSlash.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(AirSlash);
                        AirSlash.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        AirSlash.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(AirSlash,5);
                            }
                        });

                        //Creates button to add dragonclaw attack to the attacks list in the battle class.
                        DragonClaw = new JCheckBox("Dragon Claw");
                        DragonClaw.setBounds(170,150,240,40);
                        DragonClaw.setBackground(Blueviolet);
                        DragonClaw.setForeground(Color.white);
                        DragonClaw.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonClaw);
                        DragonClaw.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonClaw.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(DragonClaw ,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        Flamethrower = new JCheckBox("Flamethrower");
                        Flamethrower.setBounds(170,230,240,40);
                        Flamethrower.setBackground(Color.red);
                        Flamethrower.setForeground(Color.white);
                        Flamethrower.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Flamethrower);
                        Flamethrower.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Flamethrower.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Flamethrower,5);
                            }
                        });

                        //Creates button to add inferno attack to the attacks list in the battle class.
                        Inferno = new JCheckBox("Inferno");
                        Inferno.setBounds(170,310,240,40);
                        Inferno.setBackground(Color.red);
                        Inferno.setForeground(Color.white);
                        Inferno.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Inferno);
                        Inferno.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Inferno.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Inferno,5);
                            }
                        });

                        //Creates button to add flareblitz attack to the attacks list in the battle class.
                        FlareBlitz = new JCheckBox("Flare Blitz");
                        FlareBlitz.setBounds(170,390,240,40);
                        FlareBlitz.setBackground(Color.red);
                        FlareBlitz.setForeground(Color.white);
                        FlareBlitz.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FlareBlitz);
                        FlareBlitz.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FlareBlitz.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(FlareBlitz,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(AirSlash);
                        DisableMoves.add(DragonClaw);
                        DisableMoves.add(Flamethrower);
                        DisableMoves.add(Inferno);
                        DisableMoves.add(FlareBlitz);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        //Add Pokemon Buttons to PokemonPanel here
        PokemonPanel.add(Charizard);


        //Create Squirtle select button.
        Squirtle = new Button("Squirtle");
        Squirtle.setBounds(20,265,160,85);
        Squirtle.setBackground(Color.blue);
        Squirtle.setForeground(Color.white);
        Squirtle.setFont(new Font("Arial", Font.BOLD, 25));
        //If Squirtle button is clicked the game will continue to the nickname selection screen.
        Squirtle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                PokemonNumber=7;
                PokemonPanel.removeAll();
                PokemonPanel.repaint();

                JLabel PokemonChooser = new JLabel("<html>Choose your Pokemon nickname:<br/>Leave the entry blank if you do not want a Pokemon nickname.<html>");
                PokemonChooser.setBounds(5,5,600,50);
                PokemonChooser.setFont(new Font("Arial", Font.BOLD, 19));
                PokemonPanel.add(PokemonChooser);

                //Input your Pokemon nickname here.
                PokeNickName = new JTextField();
                PokeNickName.setBounds(175,150,250,50);
                PokeNickName.setFont(new Font("Arial", Font.BOLD, 30));
                //Make Pokemon nickname entry only accept 12 characters.
                PokeNickName.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        if(PokeNickName.getText().length()>=12&&!(evt.getKeyChar()== KeyEvent.VK_DELETE||evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)) {

                            evt.consume();
                        }
                    }
                });
                PokemonPanel.add(PokeNickName);

                NickEnter = new Button("Enter");
                NickEnter.setBounds(200,270,200,60);
                NickEnter.setBackground(Color.green);
                NickEnter.setForeground(Color.white);
                NickEnter.setFont(new Font("Arial", Font.BOLD, 30));
                //Make game continue to Pokemon move selection screen.
                NickEnter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //This counts how many Pokemon Moves are checked.
                        PokemonCount = 0;

                        //This sets PokemonNick to equal the input of the nickname entry.
                        PokemonNick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        Tackle = new JCheckBox("Tackle");
                        Tackle.setBounds(170,70,240,40);
                        Tackle.setBackground(Color.lightGray);
                        Tackle.setForeground(Color.white);
                        Tackle.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Tackle);
                        Tackle.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Tackle.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Tackle,5);
                            }
                        });

                        //Creates button to add bubble attack to the attacks list in the battle class.
                        Bubble = new JCheckBox("Bubble");
                        Bubble.setBounds(170,150,240,40);
                        Bubble.setBackground(Color.blue);
                        Bubble.setForeground(Color.white);
                        Bubble.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Bubble);
                        Bubble.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Bubble.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Bubble,5);
                            }
                        });

                        //Creates button to add watergun attack to the attacks list in the battle class.
                        WaterGun = new JCheckBox("Water Gun");
                        WaterGun.setBounds(170,230,240,40);
                        WaterGun.setBackground(Color.blue);
                        WaterGun.setForeground(Color.white);
                        WaterGun.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(WaterGun);
                        WaterGun.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        WaterGun.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(WaterGun,5);
                            }
                        });

                        //Creates button to add bite attack to the attacks list in the battle class.
                        Bite = new JCheckBox("Bite");
                        Bite.setBounds(170,310,240,40);
                        Bite.setBackground(Color.black);
                        Bite.setForeground(Color.white);
                        Bite.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Bite);
                        Bite.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Bite.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(Bite,5);
                            }
                        });

                        //Creates button to add bubblebeam attack to the attacks list in the battle class.
                        BubbleBeam = new JCheckBox("Bubble Beam");
                        BubbleBeam.setBounds(170,390,240,40);
                        BubbleBeam.setBackground(Color.blue);
                        BubbleBeam.setForeground(Color.white);
                        BubbleBeam.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(BubbleBeam);
                        BubbleBeam.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        BubbleBeam.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MoveDisabler(BubbleBeam,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Tackle);
                        DisableMoves.add(Bubble);
                        DisableMoves.add(WaterGun);
                        DisableMoves.add(Bite);
                        DisableMoves.add(BubbleBeam);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to player two Pokemon selection screen.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                //Starts Player Two Pokemon Selection
                                PlayerTwo.PCharTwo();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        //Add Pokemon Buttons to PokemonPanel here
        PokemonPanel.add(Squirtle);
    }



    //This method disables moves when four or more are selected and re-enables them when there are less than four selected.
    public static void MoveDisabler(JCheckBox Checker,int MoveNum)
    {
        try {
            //This for loop enables all attack buttons.
            for (int x = 0; x < MoveNum; x++) {
                DisableMoves.get(x).setEnabled(true);
            }
            //The PokemonCount will count how many moves are selected.
            if (Checker.isSelected()) {
                PokemonCount++;
            }
            if (!Checker.isSelected()) {
                PokemonCount--;
            }
            //If there are four Pokemon Moves selected all the attack buttons will get disabled.
            if (PokemonCount == 4) {
                for (int x = 0; x < MoveNum; x++) {
                    if (!DisableMoves.get(x).isSelected()) {
                        DisableMoves.get(x).setEnabled(false);
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



