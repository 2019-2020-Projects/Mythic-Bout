//import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

/**
 * The StartHere class creates a title screen and
 * initializes the Monster game. Then the class calls
 * PlayerOne.PCharOne().
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */
public class StartHere {

    // Variables declaration
    private JButton singlePlayer;
    private JFrame monsterWindow;
    private JPanel monsterPanel;
    public int monsterCount;
    public JTextField pokeNickName;
    public int monsterNumber, monsterNumber2;
    public String monsterNick, monsterNick2;
    public  Button doneMoves;
    public  LinkedList<JCheckBox> disableMoves;
    public  JLabel monsterJava = new JLabel();
    public  ImageIcon monsterJ;
    public  JPanel rectanglePanel = new JPanel();
    public  Color brown = new Color(165, 42, 42);
    final private  Color blueviolet = new Color(138, 43, 226);
    public  Color darkblue = new Color(0, 0, 102);

    public StartHere () {
        this.monsterPanel = monsterPanel;
        this.disableMoves = disableMoves;
    }

    public static void main(String[] args) {
        StartHere startHere = new StartHere();
        // Check and see if this is the first run, if its not the part of the code inside the if statement won't run.
        startHere.createWindow(startHere);

        startHere.restartGame(startHere);
    }

    public void restartGame(StartHere startHere) {
        // Set up the Monster Java label
        startHere.setupMonsterJavaLabel();

        // Set up the Single Player button
        startHere.setupSinglePlayerButton(startHere);
    }

    // Creates a window
    void createWindow(StartHere startHere) {
        monsterWindow = new JFrame("Mythic Bout");
        monsterWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monsterWindow.setVisible(true);
        monsterWindow.setSize(600, 600);
        monsterWindow.setLocation(500, 100);
        monsterWindow.setResizable(false);

        monsterPanel = new JPanel();
        monsterPanel.setBackground(Color.white);
        monsterPanel.setLayout(null);
        monsterWindow.add(monsterPanel);
    }

    // Sets up the Monster Java label
    void setupMonsterJavaLabel() {
        monsterJava.setBounds(30, 50, 500, 180);
        monsterJava.setForeground(Color.orange);
        monsterJava.setFont(new Font("Arial", Font.BOLD, 65));
        monsterJava.setText("Monster Java");

        monsterJ = new ImageIcon(StartHere.class.getResource("PokemonImages/MythicBout.png"));
        Image pokeBack = monsterJ.getImage();
        Image pokeBackReSize = pokeBack.getScaledInstance(500,180, Image.SCALE_SMOOTH);
        monsterJ = new ImageIcon(pokeBackReSize);

        monsterJava.setIcon(monsterJ);
        monsterPanel.setBackground(darkblue);
        monsterPanel.add(monsterJava);
        monsterPanel.repaint();
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
                //Starts Player One Monster Selection
                monsterPanel.setBackground(Color.WHITE);
                PlayerOne playerOne = new PlayerOne();
                playerOne.PCharOne(startHere, playerOne);
            }
        });

        monsterPanel.add(singlePlayer);
        monsterPanel.repaint();
    }

    public JButton getSinglePlayer() {
        return singlePlayer;
    }
    public JFrame getMonsterWindow() {
        return monsterWindow;
    }
    public JPanel getMonsterPanel() {
        return monsterPanel;
    }
    public void setMonsterPanel(JPanel panel) {
        monsterPanel = panel;
    }
    public Color getBlueviolet() {
        return blueviolet;
    }
}
