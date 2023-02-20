
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

    //Single player button select.
    public static JButton SinglePlayer;

    //Creates a window.
    public static JFrame PokemonWindow;

    //creates a panel.
    public static Panel PokemonPanel;

    //Pokemon Buttons
    public static Button Charmander;
    public static Button Charmeleon;
    public static Button Charizard;
    public static Button Bulbasaur;
    public static Button Squirtle;

    //Variable hold pokemon method.
    public static JTextField PokeNickName;

    // Variable holds Pokemon Number of player one on Pokedex.
    public static int PokemonNumber;

    // Variable holds Pokemon Number of player two on Pokedex.
    public static int PokemonNumber2;

    //Continue after entering nickname.
    public static Button NickEnter;

    //JCheckBox Button Moves For Player One.
    public static JCheckBox Scratch = new JCheckBox();
    public static JCheckBox Ember = new JCheckBox();
    public static JCheckBox DragonBreath = new JCheckBox();
    public static JCheckBox FireFang = new JCheckBox();
    public static JCheckBox Slash = new JCheckBox();


    //JCheckBox Button Moves For Player Two.
    public static JCheckBox Scratch2 = new JCheckBox();
    public static JCheckBox Ember2 = new JCheckBox();
    public static JCheckBox DragonBreath2 = new JCheckBox();
    public static JCheckBox FireFang2 = new JCheckBox();
    public static JCheckBox Slash2 = new JCheckBox();

    //JCheckBox Button Moves For Player One.
    public static JCheckBox Flamethrower = new JCheckBox();
    public static JCheckBox FireSpin = new JCheckBox();

    //JCheckBox Button Moves For Player Two.
    public static JCheckBox Flamethrower2 = new JCheckBox();
    public static JCheckBox FireSpin2 = new JCheckBox();

    //JCheckBox Button Moves For Player One.
    public static JCheckBox AirSlash = new JCheckBox();
    public static JCheckBox DragonClaw = new JCheckBox();
    public static JCheckBox Inferno = new JCheckBox();
    public static JCheckBox FlareBlitz = new JCheckBox();

    //JCheckBox Button Moves For Player Two.
    public static JCheckBox AirSlash2 = new JCheckBox();
    public static JCheckBox DragonClaw2 = new JCheckBox();
    public static JCheckBox Inferno2 = new JCheckBox();
    public static JCheckBox FlareBlitz2 = new JCheckBox();

    //JCheckBox Button Moves For Player One.
    public static JCheckBox Tackle = new JCheckBox();
    public static JCheckBox VineWhip = new JCheckBox();
    public static JCheckBox SleepPowder = new JCheckBox();
    public static JCheckBox TakeDown = new JCheckBox();
    public static JCheckBox RazorLeaf = new JCheckBox();

    //JCheckBox Button Moves For Player Two.
    public static JCheckBox Tackle2 = new JCheckBox();
    public static JCheckBox VineWhip2 = new JCheckBox();
    public static JCheckBox SleepPowder2 = new JCheckBox();
    public static JCheckBox TakeDown2 = new JCheckBox();
    public static JCheckBox RazorLeaf2 = new JCheckBox();

    //JCheckBox Button Moves For Player One.
    public static JCheckBox Bubble = new JCheckBox();
    public static JCheckBox WaterGun = new JCheckBox();
    public static JCheckBox Bite = new JCheckBox();
    public static JCheckBox BubbleBeam = new JCheckBox();

    //JCheckBox Button Moves For Player Two.
    public static JCheckBox Bubble2 = new JCheckBox();
    public static JCheckBox WaterGun2 = new JCheckBox();
    public static JCheckBox Bite2 = new JCheckBox();
    public static JCheckBox BubbleBeam2 = new JCheckBox();


    //Holds player one Pokemon Nickname.
    public static String PokemonNick;

    //Holds player two Pokemon Nickname.
    public static String Pokemon2Nick;

    //Continues game after selecting the Pokemon moves.
    public static Button DoneMoves;

    //Counts how many moves are selected.
    public static int PokemonCount;

    //ges a list to disable moves.
    public static LinkedList<JCheckBox> DisableMoves;

    //Holds Title ImageIcon.
    public static JLabel PokemonJava = new JLabel();

    //Holds png.
    public static ImageIcon PokemonJ;
    public static Panel RectanglePanel = new Panel();

    //Extra Colors
    public static Color Brown = new Color(165, 42, 42);
    public static Color Purple = new Color(128, 0, 128);
    public static Color Blueviolet = new Color(138, 43, 226);
    public static Color Pink = new Color(255, 192, 203);
    public static Color Darkblue = new Color(0, 0, 139);
    public static boolean gamestate = true;

    //This method starts the game.
    public static void main(String[] args) {

        //Check and see if this is the first run, if its not the part of the code inside the if statement won't run.
        if (gamestate) {

            //Create window with pokemon java title.
            PokemonWindow = new JFrame("Pokemon Java");

            PokemonWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            PokemonWindow.setVisible(true);
            PokemonWindow.setSize(600, 600);
            PokemonWindow.setLocation(500, 100);
            PokemonWindow.setResizable(false);



            PokemonPanel = new Panel();
            PokemonPanel.setBackground(Color.white);
            PokemonPanel.setLayout(null);
            PokemonWindow.add(PokemonPanel);
        }


            PokemonJava.setBounds(30, 50, 500, 180);
            PokemonJava.setForeground(Color.orange);
            PokemonJava.setFont(new Font("Arial", Font.BOLD, 65));
            PokemonJava.setText("Pokemon Java");

            //Get Pokemon png.
            PokemonJ = new ImageIcon(StartHere.class.getResource("PokemonImages/PokemonJava.png"));
            Image PokeBack = PokemonJ.getImage();
            //Resize PokemonJ.
            Image PokeBackReSize = PokeBack.getScaledInstance(500,180, Image.SCALE_SMOOTH);
            PokemonJ = new ImageIcon(PokeBackReSize);

            //PokemonJava Label will hold Pokemon J ImageIcon.
            PokemonJava.setIcon(PokemonJ);

            PokemonPanel.setBackground(Color.BLUE);
            //PokemonPanel will add PokemonJava Label with PokemonJ ImageIcon.
            PokemonPanel.add(PokemonJava);

            PokemonPanel.repaint();
            RectanglePanel.repaint();


            SinglePlayer = new JButton("Play");
            SinglePlayer.setBounds(200, 240, 200, 200);
            SinglePlayer.setBackground(Brown);
            SinglePlayer.setForeground(Color.white);
            SinglePlayer.setFont(new Font("Arial", Font.BOLD, 40));

            //ImageIcon start_button gets png.
            ImageIcon start_button = new ImageIcon(StartHere.class.getResource("PokemonImages/StartButton.png"));
            Image Start_Back = start_button.getImage();
            //Resize start_button.
            Image re_start_button = Start_Back.getScaledInstance(200,200, Image.SCALE_SMOOTH);
            start_button= new ImageIcon(re_start_button);

            //JLabel contains ImageIcon start_button.
            JLabel start_box= new JLabel(start_button);
            start_box.setBounds(0,0,200,200);

        //SinglePlayer button adds JLabel start_box.
            SinglePlayer.add(start_box);
            //Button doesn't have a border.
        SinglePlayer.setBorder(BorderFactory.createEmptyBorder());

        //Sets button invisible except for png.
        SinglePlayer.setContentAreaFilled(false);

        //Sets button to not get the highlighted when clicked.
        SinglePlayer.setFocusPainted(false);

        //Sets button to not get highlighted when mouse is on top of button.
        SinglePlayer.setRolloverEnabled(false);
        SinglePlayer.validate();

        //Add SinglePlayer ActionListener To continue game after player Clicks the SinglePlayer button.
            SinglePlayer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Starts Player One Pokemon Selection
                    PokemonPanel.setBackground(Color.WHITE);
                    PlayerOne.PCharOne();

                }
            });
            PokemonPanel.add(SinglePlayer);
            PokemonPanel.repaint();


        }


    }


