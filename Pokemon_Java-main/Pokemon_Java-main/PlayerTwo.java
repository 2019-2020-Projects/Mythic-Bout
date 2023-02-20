
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

        PokemonPanel.removeAll();
        PokemonPanel.repaint();

        JLabel PokemonChooser = new JLabel("Choose Pokemon CPU:");
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
                PokemonNumber2=1;
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

                        //This sets Pokemon2Nick to equal the input of the nickname entry.
                        Pokemon2Nick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();
                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        Tackle2 = new JCheckBox("Tackle");
                        Tackle2.setBounds(170,70,240,40);
                        Tackle2.setBackground(Color.lightGray);
                        Tackle2.setForeground(Color.white);
                        Tackle2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Tackle2);
                        Tackle2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Tackle2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Tackle2,5);
                            }
                        });

                        //Creates button to add vinewhip attack to the attacks list in the battle class.
                        VineWhip2 = new JCheckBox("Vine Whip");
                        VineWhip2.setBounds(170,150,240,40);
                        VineWhip2.setBackground(Color.GREEN);
                        VineWhip2.setForeground(Color.white);
                        VineWhip2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(VineWhip2);
                        VineWhip2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        VineWhip2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(VineWhip2,5);
                            }
                        });

                        //Creates button to add sleeppowder attack to the attacks list in the battle class.
                        SleepPowder2= new JCheckBox("Sleep Powder");
                        SleepPowder2.setBounds(170,230,240,40);
                        SleepPowder2.setBackground(Color.GREEN);
                        SleepPowder2.setForeground(Color.white);
                        SleepPowder2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(SleepPowder2);
                        SleepPowder2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        SleepPowder2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(SleepPowder2,5);
                            }
                        });

                        //Creates button to add takedown attack to the attacks list in the battle class.
                        TakeDown2= new JCheckBox("Take Down");
                        TakeDown2.setBounds(170,310,240,40);
                        TakeDown2.setBackground(Color.LIGHT_GRAY);
                        TakeDown2.setForeground(Color.white);
                        TakeDown2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(TakeDown2);
                        TakeDown2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        TakeDown2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(TakeDown2,5);
                            }
                        });

                        //Creates button to add razorleaf attack to the attacks list in the battle class.
                        RazorLeaf2= new JCheckBox("Razor Leaf");
                        RazorLeaf2.setBounds(170,390,240,40);
                        RazorLeaf2.setBackground(Color.GREEN);
                        RazorLeaf2.setForeground(Color.white);
                        RazorLeaf2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(RazorLeaf2);
                        RazorLeaf2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        RazorLeaf2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(RazorLeaf2,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Tackle2);
                        DisableMoves.add(VineWhip2);
                        DisableMoves.add(SleepPowder2);
                        DisableMoves.add(TakeDown2);
                        DisableMoves.add(RazorLeaf2);


                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to the Pokemon battle sequence.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                PokemonPanel.removeAll();
                                PokemonPanel.repaint();

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
                                PokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(Darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                PokemonPanel.repaint();
                            }
                        });
                        PokemonPanel.add(DoneMoves);

                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });
        //Add Pokemon Buttons to PokemonPanel here
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
                PokemonNumber2=4;
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
                        PokemonCount= 0;

                        //This sets Pokemon2Nick to equal the input of the nickname entry.
                        Pokemon2Nick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();
                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);

                        //Pokemon Move Button Selection
                        //Creates button to add scratch attack to the attacks list in the battle class.
                        Scratch2 = new JCheckBox("Scratch");
                        Scratch2.setBounds(170,70,240,40);
                        Scratch2.setBackground(Color.lightGray);
                        Scratch2.setForeground(Color.white);
                        Scratch2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Scratch2);
                        Scratch2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Scratch2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Scratch2,5);
                            }
                        });

                        //Creates button to add ember attack to the attacks list in the battle class.
                        Ember2 = new JCheckBox("Ember");
                        Ember2.setBounds(170,150,240,40);
                        Ember2.setBackground(Color.red);
                        Ember2.setForeground(Color.white);
                        Ember2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Ember2);
                        Ember2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Ember2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Ember2,5);
                            }
                        });

                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        DragonBreath2 = new JCheckBox("Dragon Breath");
                        DragonBreath2.setBounds(170,230,240,40);
                        DragonBreath2.setBackground(Blueviolet);
                        DragonBreath2.setForeground(Color.white);
                        DragonBreath2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonBreath2);
                        DragonBreath2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonBreath2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                              PlayerOne.MoveDisabler(DragonBreath2,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        FireFang2 = new JCheckBox("Fire Fang");
                        FireFang2.setBounds(170,310,240,40);
                        FireFang2.setBackground(Color.red);
                        FireFang2.setForeground(Color.white);
                        FireFang2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireFang2);
                        FireFang2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireFang2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(FireFang2,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        Slash2 = new JCheckBox("Slash");
                        Slash2.setBounds(170,390,240,40);
                        Slash2.setBackground(Color.lightGray);
                        Slash2.setForeground(Color.white);
                        Slash2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Slash2);
                        Slash2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Slash2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Slash2,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Scratch2);
                        DisableMoves.add(Ember2);
                        DisableMoves.add(DragonBreath2);
                        DisableMoves.add(FireFang2);
                        DisableMoves.add(Slash2);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));

                        //Continue game to the Pokemon battle sequence.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PokemonPanel.removeAll();
                                PokemonPanel.repaint();

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
                                PokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(Darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                PokemonPanel.repaint();
                            }
                        });

                        PokemonPanel.add(DoneMoves);
                    }
                });

                PokemonPanel.add(NickEnter);
            }
        });

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
                PokemonNumber2=5;
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

                        //This sets Pokemon2Nick to equal the input of the nickname entry.
                        Pokemon2Nick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add dragonbreath attack to the attacks list in the battle class.
                        DragonBreath2 = new JCheckBox("Dragon Breath");
                        DragonBreath2.setBounds(170,70,240,40);
                        DragonBreath2.setBackground(Blueviolet);
                        DragonBreath2.setForeground(Color.white);
                        DragonBreath2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonBreath2);
                        DragonBreath2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonBreath2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(DragonBreath2,5);
                            }
                        });

                        //Creates button to add firefang attack to the attacks list in the battle class.
                        FireFang2 = new JCheckBox("Fire Fang ");
                        FireFang2.setBounds(170,150,240,40);
                        FireFang2.setBackground(Color.red);
                        FireFang2.setForeground(Color.white);
                        FireFang2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireFang2 );
                        FireFang2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireFang2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(FireFang2 ,5);
                            }
                        });

                        //Creates button to add slash attack to the attacks list in the battle class.
                        Slash2 = new JCheckBox("Slash");
                        Slash2.setBounds(170,230,240,40);
                        Slash2.setBackground(Color.lightGray);
                        Slash2.setForeground(Color.white);
                        Slash2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Slash2);
                        Slash2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Slash2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Slash2,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        Flamethrower2 = new JCheckBox("Flamethrower");
                        Flamethrower2.setBounds(170,310,240,40);
                        Flamethrower2.setBackground(Color.red);
                        Flamethrower2.setForeground(Color.white);
                        Flamethrower2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Flamethrower2);
                        Flamethrower2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Flamethrower2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Flamethrower2,5);
                            }
                        });

                        //Creates button to add firespin attack to the attacks list in the battle class.
                        FireSpin2 = new JCheckBox("Fire Spin");
                        FireSpin2.setBounds(170,390,240,40);
                        FireSpin2.setBackground(Color.red);
                        FireSpin2.setForeground(Color.white);
                        FireSpin2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FireSpin2);
                        FireSpin2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FireSpin2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(FireSpin2,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(DragonBreath2);
                        DisableMoves.add(FireFang2);
                        DisableMoves.add(Slash2);
                        DisableMoves.add(Flamethrower2);
                        DisableMoves.add(FireSpin2);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                PokemonPanel.removeAll();
                                PokemonPanel.repaint();

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
                                PokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(Darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                PokemonPanel.repaint();
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
                PokemonNumber2=6;
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

                        //This sets Pokemon2Nick to equal the input of the nickname entry.
                        Pokemon2Nick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add airslash attack to the attacks list in the battle class.
                        AirSlash2 = new JCheckBox("Air Slash");
                        AirSlash2.setBounds(170,70,240,40);
                        AirSlash2.setBackground(Color.cyan);
                        AirSlash2.setForeground(Color.white);
                        AirSlash2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(AirSlash2);
                        AirSlash2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        AirSlash2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(AirSlash2,5);
                            }
                        });

                        //Creates button to add dragonclaw attack to the attacks list in the battle class.
                        DragonClaw2 = new JCheckBox("Dragon Claw");
                        DragonClaw2.setBounds(170,150,240,40);
                        DragonClaw2.setBackground(Blueviolet);
                        DragonClaw2.setForeground(Color.white);
                        DragonClaw2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(DragonClaw2);
                        DragonClaw2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        DragonClaw2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(DragonClaw2,5);
                            }
                        });

                        //Creates button to add flamethrower attack to the attacks list in the battle class.
                        Flamethrower2 = new JCheckBox("Flamethrower");
                        Flamethrower2.setBounds(170,230,240,40);
                        Flamethrower2.setBackground(Color.red);
                        Flamethrower2.setForeground(Color.white);
                        Flamethrower2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Flamethrower2);
                        Flamethrower2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Flamethrower2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Flamethrower2,5);
                            }
                        });

                        //Creates button to add inferno attack to the attacks list in the battle class.
                        Inferno2 = new JCheckBox("Inferno");
                        Inferno2.setBounds(170,310,240,40);
                        Inferno2.setBackground(Color.red);
                        Inferno2.setForeground(Color.white);
                        Inferno2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Inferno2);
                        Inferno2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Inferno2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Inferno2,5);
                            }
                        });

                        //Creates button to add flareblitz attack to the attacks list in the battle class.
                        FlareBlitz2 = new JCheckBox("Flare Blitz");
                        FlareBlitz2.setBounds(170,390,240,40);
                        FlareBlitz2.setBackground(Color.red);
                        FlareBlitz2.setForeground(Color.white);
                        FlareBlitz2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(FlareBlitz2);
                        FlareBlitz2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        FlareBlitz2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(FlareBlitz2,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(AirSlash2);
                        DisableMoves.add(DragonClaw2);
                        DisableMoves.add(Flamethrower2);
                        DisableMoves.add(Inferno2);
                        DisableMoves.add(FlareBlitz2);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                PokemonPanel.removeAll();
                                PokemonPanel.repaint();

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
                                PokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(Darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                PokemonPanel.repaint();
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
                PokemonNumber2=7;
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

                        //This sets Pokemon2Nick to equal the input of the nickname entry.
                        Pokemon2Nick=PokeNickName.getText();

                        PokemonPanel.removeAll();
                        PokemonPanel.repaint();

                        JLabel PokemonChooser = new JLabel("<html>Choose four Pokemon moves:<html>");
                        PokemonChooser.setBounds(5,5,600,50);
                        PokemonChooser.setFont(new Font("Arial", Font.BOLD, 20));
                        PokemonPanel.add(PokemonChooser);
                        //Pokemon Move Button Selection
                        //Creates button to add tackle attack to the attacks list in the battle class.
                        Tackle2 = new JCheckBox("Tackle");
                        Tackle2.setBounds(170,70,240,40);
                        Tackle2.setBackground(Color.lightGray);
                        Tackle2.setForeground(Color.white);
                        Tackle2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Tackle2);
                        Tackle2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Tackle2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Tackle2,5);
                            }
                        });

                        //Creates button to add bubble attack to the attacks list in the battle class.
                        Bubble2 = new JCheckBox("Bubble");
                        Bubble2.setBounds(170,150,240,40);
                        Bubble2.setBackground(Color.blue);
                        Bubble2.setForeground(Color.white);
                        Bubble2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Bubble2);
                        Bubble2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Bubble2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Bubble2,5);
                            }
                        });

                        //Creates button to add watergun attack to the attacks list in the battle class.
                        WaterGun2 = new JCheckBox("Water Gun");
                        WaterGun2.setBounds(170,230,240,40);
                        WaterGun2.setBackground(Color.blue);
                        WaterGun2.setForeground(Color.white);
                        WaterGun2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(WaterGun2);
                        WaterGun2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        WaterGun2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(WaterGun2,5);
                            }
                        });

                        //Creates button to add bite attack to the attacks list in the battle class.
                        Bite2 = new JCheckBox("Bite");
                        Bite2.setBounds(170,310,240,40);
                        Bite2.setBackground(Color.black);
                        Bite2.setForeground(Color.white);
                        Bite2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(Bite2);
                        Bite2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        Bite2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(Bite2,5);
                            }
                        });

                        //Creates button to add bubblebeam attack to the attacks list in the battle class.
                        BubbleBeam2 = new JCheckBox("Bubble Beam");
                        BubbleBeam2.setBounds(170,390,240,40);
                        BubbleBeam2.setBackground(Color.blue);
                        BubbleBeam2.setForeground(Color.white);
                        BubbleBeam2.setFont(new Font("Arial", Font.BOLD, 30));
                        PokemonPanel.add(BubbleBeam2);
                        BubbleBeam2.setSelected(false);
                        //If clicked and the moves selected are more than four, all moves will be disabled until other moves are unchecked.
                        BubbleBeam2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                PlayerOne.MoveDisabler(BubbleBeam2,5);
                            }
                        });

                        //Add all moves to a list to later be disabled when the amount of selected exceeds four.
                        DisableMoves = new LinkedList<JCheckBox>();
                        DisableMoves.add(Tackle2);
                        DisableMoves.add(Bubble2);
                        DisableMoves.add(WaterGun2);
                        DisableMoves.add(Bite2);
                        DisableMoves.add(BubbleBeam2);

                        DoneMoves = new Button("Continue");
                        DoneMoves.setBounds(200,500,200,60);
                        DoneMoves.setBackground(Color.green);
                        DoneMoves.setForeground(Color.white);
                        DoneMoves.setFont(new Font("Arial", Font.BOLD, 30));
                        //Continue game to the Pokemon battle sequence.
                        DoneMoves.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                PokemonPanel.removeAll();
                                PokemonPanel.repaint();

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
                                PokemonPanel.add(PokemonBox);
                                TextBox = new Panel();
                                TextBox.setBounds(0,550,300,100);
                                TextBox.setBackground(Darkblue);
                                PokemonBox.add(TextBox);
                                MovesBox = new Panel();
                                MovesBox.setBounds(300,550,300,100);
                                MovesBox.setBackground(Color.white);
                                PokemonBox.add(MovesBox);

                                //Starts Pokemon Battle
                                Battle.StartBattle();
                                PokemonPanel.repaint();
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

}
