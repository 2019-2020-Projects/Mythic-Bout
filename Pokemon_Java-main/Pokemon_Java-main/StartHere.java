import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * The StartHere class creates a title screen and
 * initializes the Pokemon game. Then the class calls
 * PlayerOne.PCharOne().
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */
public class StartHere {

    // Variables declaration
    public static JButton singlePlayer;
    public static JFrame pokemonWindow;
    public static JPanel pokemonPanel;
    public static JTextField pokeNickName;
    public static int pokemonNumber, pokemonNumber2;
    public static JCheckBox scratchBox, emberBox, dragonBreathBox, fireFangBox, slashBox;
    public static JCheckBox scratch2Box, ember2Box, dragonBreath2Box, fireFang2Box, slash2Box;
    public static JCheckBox flamethrowerBox, fireSpinBox;
    public static JCheckBox flamethrower2Box, fireSpin2Box;
    public static JCheckBox airSlashBox, dragonClawBox, infernoBox, flareBlitzBox;
    public static JCheckBox airSlash2Box, dragonClaw2Box, inferno2Box, flareBlitz2Box;
    public static JCheckBox tackleBox, vineWhipBox, sleepPowderBox, takeDownBox, razorLeafBox;
    public static JCheckBox tackle2Box, vineWhip2Box, sleepPowder2Box, takeDown2Box, razorLeaf2Box;
    public static JCheckBox bubbleBox, waterGunBox, biteBox, bubbleBeamBox;
    public static JCheckBox bubble2Box, waterGun2Box, bite2Box, bubbleBeam2Box;
    public static String pokemonNick, pokemon2Nick;
    public static Button doneMoves;
    public static LinkedList<JCheckBox> disableMoves;
    public static JLabel pokemonJava = new JLabel();
    public static ImageIcon pokemonJ;
    public static JPanel rectanglePanel = new JPanel();
    public static Color brown = new Color(165, 42, 42);
    private static Color blueviolet = new Color(138, 43, 226);
    public static Color darkblue = new Color(0, 0, 139);
    public static boolean gameState = true;

    public static void main(String[] args) {
        //Check and see if this is the first run, if its not the part of the code inside the if statement won't run.
        if (gameState) {
            createWindow();
        }

        // Set up the Pokemon Java label
        setupPokemonJavaLabel();

        // Set up the Single Player button
        setupSinglePlayerButton();
    }

    // Creates a window
    private static void createWindow() {
        pokemonWindow = new JFrame("Pokemon Java");
        pokemonWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pokemonWindow.setVisible(true);
        pokemonWindow.setSize(600, 600);
        pokemonWindow.setLocation(500, 100);
        pokemonWindow.setResizable(false);

        pokemonPanel = new JPanel();
        pokemonPanel.setBackground(Color.white);
        pokemonPanel.setLayout(null);
        pokemonWindow.add(pokemonPanel);
    }

    // Sets up the Pokemon Java label
    private static void setupPokemonJavaLabel() {
        pokemonJava.setBounds(30, 50, 500, 180);
        pokemonJava.setForeground(Color.orange);
        pokemonJava.setFont(new Font("Arial", Font.BOLD, 65));
        pokemonJava.setText("Pokemon Java");

        pokemonJ = new ImageIcon(StartHere.class.getResource("PokemonImages/PokemonJava.png"));
        Image pokeBack = pokemonJ.getImage();
        Image pokeBackReSize = pokeBack.getScaledInstance(500,180, Image.SCALE_SMOOTH);
        pokemonJ = new ImageIcon(pokeBackReSize);

        pokemonJava.setIcon(pokemonJ);
        pokemonPanel.setBackground(Color.BLUE);
        pokemonPanel.add(pokemonJava);
        pokemonPanel.repaint();
        rectanglePanel.repaint();
    }

    // Sets up the Single Player button
    private static void setupSinglePlayerButton() {
        singlePlayer = new JButton("Play");
        singlePlayer.setBounds(200, 240, 200, 200);
        singlePlayer.setBackground(brown);
        singlePlayer.setForeground(Color.white);
        singlePlayer.setFont(new Font("Arial", Font.BOLD, 40));

        ImageIcon startButton = new ImageIcon(StartHere.class.getResource("PokemonImages/StartButton.png"));
        Image startBack = startButton.getImage();
        Image startBackReSize = startBack.getScaledInstance(200,200, Image.SCALE_SMOOTH);
        startButton = new ImageIcon(startBackReSize);

        JLabel startBox = new JLabel(startButton);
        startBox.setBounds(0,0,200,200);

        singlePlayer.add(startBox);
        singlePlayer.setBorder(BorderFactory.createEmptyBorder());
        singlePlayer.setContentAreaFilled(false);
        singlePlayer.setFocusPainted(false);
        singlePlayer.setRolloverEnabled(false);
        singlePlayer.validate();

        // Add SinglePlayer ActionListener To continue game after player Clicks the SinglePlayer button.
        singlePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Starts Player One Pokemon Selection
                pokemonPanel.setBackground(Color.WHITE);
                PlayerOne.PCharOne();
            }
        });

        pokemonPanel.add(singlePlayer);
        pokemonPanel.repaint();
    }

    public static Color getBlueviolet() {
        return blueviolet;
    }
}
