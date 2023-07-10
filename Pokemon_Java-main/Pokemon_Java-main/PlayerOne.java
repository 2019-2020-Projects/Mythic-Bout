
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
    public static int pokemonCount;
    //This method creates the Pokemon on the gui based on what buttons are clicked.
    public static void PCharOne()
    {
        scratchBox = new JCheckBox("Scratch");
        emberBox = new JCheckBox("Ember");
        dragonBreathBox = new JCheckBox("Dragon Breath");
        fireFangBox = new JCheckBox("Fire Fang");
        slashBox = new JCheckBox("Slash");
        flamethrowerBox = new JCheckBox("Flamethrower");
        fireSpinBox = new JCheckBox("Fire Spin");
        airSlashBox = new JCheckBox("Air Slash");
        dragonClawBox = new JCheckBox("Dragon Claw");
        infernoBox = new JCheckBox("Inferno");
        flareBlitzBox = new JCheckBox("Flare Blitz");
        tackleBox = new JCheckBox("Tackle");
        vineWhipBox = new JCheckBox("Vine Whip");
        sleepPowderBox = new JCheckBox("Sleep Powder");
        takeDownBox = new JCheckBox("Take Down");
        razorLeafBox = new JCheckBox("Razor Leaf");
        bubbleBox = new JCheckBox("Bubble");
        waterGunBox = new JCheckBox("Water Gun");
        biteBox = new JCheckBox("Bite");
        bubbleBeamBox = new JCheckBox("Bubble Beam");

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
        JCheckBox[] bulbasaurMoves = {tackleBox, vineWhipBox, sleepPowderBox, takeDownBox, razorLeafBox};
        Color[] bulbasaurColors = {Color.lightGray, Color.green, Color.green, Color.lightGray, Color.green};
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

                nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                        Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

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
                                    MoveDisabler(bulbasaurMoves[finalI],5);
                                }
                            });
                        }

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
        Button charmanderBTN = createButton("Charmander", 20, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmanderBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmanderMoves = {scratchBox, emberBox, dragonBreathBox, fireFangBox, slashBox};
        Color[] charmanderColors = {Color.lightGray, Color.red, getBlueviolet(), Color.red, Color.lightGray};
        charmanderBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber = 4;
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
                        pokemonNick=pokeNickName.getText();

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
                                    MoveDisabler(charmanderMoves[finalI],5);
                                }
                            });
                        }

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
        Button charmeleonBTN = createButton("Charmeleon", 200, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charmeleonBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charmeleonMoves = {dragonBreathBox, fireFangBox, slashBox, flamethrowerBox, fireSpinBox};
        Color[] charmeleonColors = {getBlueviolet(), Color.red, Color.lightGray, Color.red, Color.red};
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

                nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                        Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

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
                                    MoveDisabler(charmeleonMoves[finalI],5);
                                }
                            });
                        }

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
        Button charizardBTN = createButton("Charizard", 380, 160, 160, 85,
                Color.red, Color.white, new Font("Arial", Font.BOLD, 25));

        //If charizardBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] charizardMoves = {airSlashBox, dragonClawBox, flamethrowerBox, infernoBox, flareBlitzBox};
        Color[] charizardColors = {Color.cyan, getBlueviolet(), Color.red, Color.red, Color.red};
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

                nickEnterBTN = createButton("Enter", 200, 270, 200, 60,
                        Color.green, Color.white, new Font("Arial", Font.BOLD, 30));

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
                        //Creates button to add Air Slash attack to the attacks list in the battle class.
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
                                    MoveDisabler(charizardMoves[finalI],5);
                                }
                            });
                        }

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
        Button squirtleBTN = createButton("Squirtle", 20, 265, 160, 85,
                Color.blue, Color.white, new Font("Arial", Font.BOLD, 25));

        //If squirtleBTN button is clicked the game will continue to the nickname selection screen.
        JCheckBox[] squirtleMoves = {tackleBox, bubbleBox, waterGunBox, biteBox, bubbleBeamBox};
        Color[] squirtleColors = {Color.lightGray, Color.blue, Color.blue, Color.black, Color.blue};
        squirtleBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This sets what number of Pokemon in the pokedex player one will be.
                pokemonNumber = 7;
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
                        pokemonNick = pokeNickName.getText();

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
                                    MoveDisabler(squirtleMoves[finalI],5);
                                }
                            });
                        }

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

    private static Button createButton(String label, int x, int y, int width,
                                      int height, Color bColor, Color fColor, Font font) {
        Button btn = new Button(label);
        btn.setBounds(x, y, width, height);
        btn.setBackground(bColor);
        btn.setForeground(fColor);
        btn.setFont(font);
        return btn;
    }

   /* private static Button addPokeButtonListener(Button btn, int pokeNum) {
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
        return btn;
    }*/


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



