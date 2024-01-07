//import javax.swing.*;
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
 * @version 1.8
 * @since 11/29/2023
 */
public class StartHere {

    // Variables declaration
    private JButton singlePlayer;
    private JFrame pokemonWindow;
    private JPanel pokemonPanel;
    public int pokemonCount;
    public JTextField pokeNickName;
    public int pokemonNumber, pokemonNumber2;
    public String pokemonNick, pokemonNick2;
    public  Button doneMoves;
    public  LinkedList<JCheckBox> disableMoves;
    public  JLabel pokemonJava = new JLabel();
    public  ImageIcon pokemonJ;
    public  JPanel rectanglePanel = new JPanel();
    public  Color brown = new Color(165, 42, 42);
    final private  Color blueviolet = new Color(138, 43, 226);
    public  Color darkblue = new Color(0, 0, 102);

    public StartHere () {
        this.pokemonPanel = pokemonPanel;
        this.disableMoves = disableMoves;
    }

    public static void main(String[] args) {
        StartHere startHere = new StartHere();
        // Check and see if this is the first run, if its not the part of the code inside the if statement won't run.
        startHere.createWindow(startHere);

        startHere.restartGame(startHere);
    }

    public void restartGame(StartHere startHere) {
        // Set up the Pokemon Java label
        startHere.setupPokemonJavaLabel();

        // Set up the Single Player button
        startHere.setupSinglePlayerButton(startHere);
    }

    // Creates a window
    void createWindow(StartHere startHere) {
        pokemonWindow = new JFrame("Mythic Bout");
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
    void setupPokemonJavaLabel() {
        pokemonJava.setBounds(30, 50, 500, 180);
        pokemonJava.setForeground(Color.orange);
        pokemonJava.setFont(new Font("Arial", Font.BOLD, 65));
        pokemonJava.setText("Pokemon Java");

        pokemonJ = new ImageIcon(StartHere.class.getResource("PokemonImages/MythicBout.png"));
        Image pokeBack = pokemonJ.getImage();
        Image pokeBackReSize = pokeBack.getScaledInstance(500,180, Image.SCALE_SMOOTH);
        pokemonJ = new ImageIcon(pokeBackReSize);

        pokemonJava.setIcon(pokemonJ);
        pokemonPanel.setBackground(darkblue);
        pokemonPanel.add(pokemonJava);
        pokemonPanel.repaint();
        rectanglePanel.repaint();
    }

    // Sets up the Single Player button
    void setupSinglePlayerButton(StartHere startHere) {
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
                PlayerOne playerOne = new PlayerOne();
                playerOne.PCharOne(startHere, playerOne);
            }
        });

        pokemonPanel.add(singlePlayer);
        pokemonPanel.repaint();
    }

    public JButton getSinglePlayer() {
        return singlePlayer;
    }
    public JFrame getPokemonWindow() {
        return pokemonWindow;
    }
    public JPanel getPokemonPanel() {
        return pokemonPanel;
    }
    public void setPokemonPanel(JPanel panel) {
        pokemonPanel = panel;
    }
    public Color getBlueviolet() {
        return blueviolet;
    }
}
