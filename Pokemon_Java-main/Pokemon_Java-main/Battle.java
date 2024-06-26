import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The Battle class starts the
 * Monster battle. Then the class
 * restarts the whole program to
 *continue onto the startHere.restart(startHere)
 * again.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */

public class Battle extends StartHere

{
    //This ImageIcon will contain the png of the Monster's back selected by player one.
    public  ImageIcon MonsterBack;

    //This ImageIcon will contain the png of the Monster's front selected for the cpu.
    public  ImageIcon MonsterFront;

    //This JLabel will hold MonsterBack to be able to move its position.
    public  JLabel ImageBox;

    //This JLabel will hold MonsterFront to be able to move its position.
    public  JLabel ImageBox2;

    //This JLabel will output the text that explains what is happening in the battle..
    public  JLabel BattleText;

    //These four buttons will be the moves that will show up to the user to select to attack the defending Monster.
    public  Button FirstMove = new Button();
    public  Button SecondMove = new Button();
    public  Button ThirdMove = new Button();
    public  Button FourthMove = new Button();

    //These Buttons make the battle sequence continue.
    public  Button NextBattle = new Button();
    public  Button P2Fight = new Button();
    public  Button P3Fight = new Button();
    public  Button P4Fight = new Button();
    public  Button P5Fight = new Button();
    public  Button P5Fightsub1 = new Button();
    public  Button P5Fightsub2 = new Button();
    public  Button P6Fight = new Button();
    public  Button P7Fight = new Button();
    public  Button P23Fightsub1 = new Button();
    public  Button P23Fightsub2 = new Button();

    //This will set the Monster chosen by player one to player1.
    public  Monster_Abilities player1;
    //This will set the Monster chosen for the cpu to player2.
    public  Monster_Abilities player2;

    //This counts how many turns player one's Monster has had the ASLEEP status.
    private  int ASleepTurn = 0;
    //This counts how many turns the cpu's Monster has had the ASLEEP status.
    private  int ASleepTurn2 = 0;

    //These Action Listeners make the battle sequence continue and eventually restart the game when the battle ends..
    public  ActionListener Fight = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
             //This Action Listener restarts the game.
            public  ActionListener HereWeGoAgain = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
    };
    public  ActionListener Move1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener Move2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener Move3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener Move4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
        //This Action Listener changes the move selected depending on what attack button is clicked.
        public  int Movenumber;
        public  ActionListener MoveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    public  ActionListener FighterP2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP5 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP6 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public  ActionListener FighterP5sub1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP5sub2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP23sub1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public  ActionListener FighterP23sub2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    //Monster Health Bar
    //This Panel will show itself more when player one Monster gets damaged.
    public  Panel HPHolder = new Panel();
    //This Panel will show itself more when the cpu Monster gets damaged.
    public  Panel HPHolder2 = new Panel();
    //This Panel will indicate how much HP player one's Monster has left.
    public  Panel CurrentHP = new Panel();
    //This Panel will indicate how much HP the cpu's Monster has left.
    public  Panel CurrentHP2 = new Panel();
    //This variable will hold the player one Monster's initial HP.
    public  int HPInitial;
    //This variable will hold the cpu's initial HP.
    public  int HPInitial2;


    public Battle() {
        this.Movenumber = Movenumber;
        this.BattleText = BattleText;


    }

    //This method will start the battle sequence.
    public  void StartBattle(StartHere startHere, PlayerOne playerOne, PlayerTwo playerTwo, Battle battle) {

        try {
            // define attacks
            final Attack tackle = new DamageAttack("Tackle", MonsterType.NORMAL, 40,1);
            final Attack scratch = new DamageAttack("Scratch",MonsterType.NORMAL,40,1);
            final Attack takedown = new DamageAttack("Take Down",MonsterType.NORMAL,90,0.85f);
            final Attack vinewhip = new DamageAttack("Vine Whip", MonsterType.GRASS, 45,1);
            final Attack razorleaf = new DamageAttack("Razor Leaf", MonsterType.GRASS, 55,0.95f);
            final Attack bubble = new DamageAttack("Bubble", MonsterType.WATER, 40,1);
            final Attack watergun = new DamageAttack("Water Gun", MonsterType.WATER, 40,1);
            final Attack bite = new DamageAttack("Bite", MonsterType.DARK, 60,1);
            final Attack bubblebeam = new DamageAttack("Bubble Beam", MonsterType.WATER, 65,1);
            final Attack sleeppowder = new StatusAttack("Sleep Powder", MonsterType.GRASS, Status.ASLEEP, 0.75f);
            final Attack ember = new DamageAttack("Ember", MonsterType.FIRE, 30,1);
            final Attack struggle = new DamageAttack("Struggle",MonsterType.NORMAL,10,1);
            final Attack dragonbreath = new DamageAttack("Dragon Breath", MonsterType.DRAGON,60,1);
            final Attack firefang = new DamageAttack("Fire Fang", MonsterType.FIRE,65,0.95f);
            final Attack slash = new DamageAttack("Slash", MonsterType.NORMAL,70,1);
            final Attack flamethrower = new DamageAttack("Flamethrower", MonsterType.FIRE,90,1);
            final Attack firespin = new DamageAttack("Fire Spin", MonsterType.FIRE,90,0.85f);//5 times
            final Attack inferno = new DamageAttack("Inferno", MonsterType.FIRE,100,0.5f);
            final Attack flareblitz = new DamageAttack("Flare Blitz", MonsterType.FIRE,120,1);
            final Attack airslash = new DamageAttack("Air Slash", MonsterType.FLYING,75,0.95f);
            final Attack dragonclaw = new DamageAttack("Dragon Claw", MonsterType.DRAGON,80,1);
            
            // Create Bulbasaur for player one
            JCheckBox[] bulbasaurMoves = playerOne.getBulbasaurMoves();
            Attack[] bulbasaurAttMoves = {tackle, vinewhip, sleeppowder, takedown, razorleaf};
            Monster_Abilities bulbasaur = createPokeChar(bulbasaurMoves, bulbasaurAttMoves, "Bulbasaur",
                    MonsterType.GRASS, MonsterType.POISON, 294, "Overgrow", startHere.monsterNick);


            // Create Bulbasaur for cpu
            JCheckBox[] bulbasaur2Moves = playerTwo.getBulbasaurMoves();
            Attack[] bulbasaur2AttMoves = {tackle, vinewhip, sleeppowder, takedown, razorleaf};
            Monster_Abilities bulbasaur2 = createPokeChar(bulbasaur2Moves, bulbasaur2AttMoves, "Bulbasaur",
                    MonsterType.GRASS, MonsterType.POISON, 294, "Overgrow", startHere.monsterNick2);


            // Create Player One dragonCub
            JCheckBox[] dragonCubMoves = playerOne.getdragonCubMoves();
            Attack[] dragonCubAttMoves = {scratch, ember, dragonbreath, firefang, slash};
            Monster_Abilities dragonCub = createPokeChar(dragonCubMoves, dragonCubAttMoves, "Dragon Cub",
                    MonsterType.FIRE, MonsterType.FIRE, 282, "Blaze", startHere.monsterNick);

            // Create CPU dragonCub
            JCheckBox[] dragonCub2Moves = playerTwo.getdragonCubMoves();
            Attack[] dragonCub2AttMoves = {scratch, ember, dragonbreath, firefang, slash};
            Monster_Abilities dragonCub2 = createPokeChar(dragonCub2Moves, dragonCub2AttMoves, "Dragon Cub",
                    MonsterType.FIRE, MonsterType.FIRE, 282, "Blaze", startHere.monsterNick2);

            // Create Player One Charmeleon
            JCheckBox[] charmeleonMoves = playerOne.getCharmeleonMoves();
            Attack[] charmeleonAttMoves = {dragonbreath, firefang, slash, flamethrower, firefang};
            Monster_Abilities charmeleon = createPokeChar(charmeleonMoves, charmeleonAttMoves, "Charmeleon",
                    MonsterType.FIRE, MonsterType.FIRE, 320, "Blaze", startHere.monsterNick);

            // Create CPU Charmeleon
            JCheckBox[] charmeleon2Moves = playerTwo.getCharmeleonMoves();
            Attack[] charmeleon2AttMoves = {dragonbreath, firefang, slash, flamethrower, firefang};
            Monster_Abilities charmeleon2 = createPokeChar(charmeleon2Moves, charmeleon2AttMoves, "Charmeleon",
                    MonsterType.FIRE, MonsterType.FIRE, 320, "Blaze", startHere.monsterNick2);

            // Create Player One Charizard
            JCheckBox[] charizardMoves = playerOne.getCharizardMoves();
            Attack[] charizardAttMoves = {airslash, dragonclaw, flamethrower, inferno, flareblitz};
            Monster_Abilities charizard = createPokeChar(charizardMoves, charizardAttMoves, "Charizard",
                    MonsterType.FIRE, MonsterType.FIRE, 360, "Blaze", startHere.monsterNick);

            // Create CPU Charizard
            JCheckBox[] charizard2Moves = playerTwo.getCharizardMoves();
            Attack[] charizard2AttMoves = {airslash, dragonclaw, flamethrower, inferno, flareblitz};
            Monster_Abilities charizard2 = createPokeChar(charizard2Moves, charizard2AttMoves, "Charizard",
                    MonsterType.FIRE, MonsterType.FIRE, 360, "Blaze", startHere.monsterNick2);

            // Create Player One Squirtle
            JCheckBox[] squirtleMoves = playerOne.getSquirtleMoves();
            Attack[] squirtleAttMoves = {tackle, bubble, watergun, bite, bubblebeam};
            Monster_Abilities squirtle = createPokeChar(squirtleMoves, squirtleAttMoves, "Squirtle",
                    MonsterType.WATER, MonsterType.WATER, 292, "Torrent", startHere.monsterNick);

            // Create CPU Squirtle
            JCheckBox[] squirtle2Moves = playerTwo.getSquirtleMoves();;
            Attack[] squirtle2AttMoves = {tackle, bubble, watergun, bite, bubblebeam};
            Monster_Abilities squirtle2 = createPokeChar(squirtle2Moves, squirtle2AttMoves, "Squirtle",
                    MonsterType.WATER, MonsterType.WATER, 292, "Torrent", startHere.monsterNick2);

            //Create player1 and player2 variables.
            player1 = bulbasaur;
            player2 = bulbasaur;

            //If player one selects Bulbasaur MonsterNumber from playerOne class will equal 1.
            if (startHere.monsterNumber == 1)
            {
                //Player one equals Bulbasaur.
                player1 = bulbasaur;

                //Get Bulbasaur image.
                MonsterBack = new ImageIcon(Battle.class.getResource("PokemonImages/BulbasaurBack.png"));

                Image PokeBack = MonsterBack.getImage();
                //Resize MonsterBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500,500, Image.SCALE_SMOOTH);
                MonsterBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(MonsterBack);

                ImageBox.setBounds(60,300,300,300);
                playerTwo.MonsterBox.add(ImageBox);
                playerTwo.MonsterBox.repaint();
            }

            //If player one selects dragonCub MonsterNumber from playerOne class will equal 4.
            if (startHere.monsterNumber == 4)
            {
                //Player one equals dragonCub.
                player1 = dragonCub;
                //Get dragonCub image.
                MonsterBack = new ImageIcon(Battle.class.getResource("PokemonImages/dragonCubBack.png"));

                Image PokeBack = MonsterBack.getImage();
                Image PokeBackReSize = PokeBack.getScaledInstance(250,250, Image.SCALE_SMOOTH);
                //Resize MonsterBack
                MonsterBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(MonsterBack);

                ImageBox.setBounds(60,300,300,300);
                playerTwo.MonsterBox.add(ImageBox);
                playerTwo.MonsterBox.repaint();
            }

            //If player one selects Charmeleon MonsterNumber from playerOne class will equal 5.
            if (startHere.monsterNumber == 5) {
                //Player one equals Charmeleon.
                player1 = charmeleon;
                //Get Charmeleon image.
                MonsterBack = new ImageIcon(Battle.class.getResource("PokemonImages/CharmeleonBack.png"));

                Image PokeBack = MonsterBack.getImage();
                //Resize MonsterBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                MonsterBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(MonsterBack);

                ImageBox.setBounds(60, 300, 300, 300);
                playerTwo.MonsterBox.add(ImageBox);
                playerTwo.MonsterBox.repaint();
            }

            //If player one selects Charizard MonsterNumber from playerOne class will equal 6.
            if (startHere.monsterNumber == 6) {
                //Player one equals Charizard.
                player1 = charizard;
                //Get Charizard image.
                MonsterBack = new ImageIcon(Battle.class.getResource("PokemonImages/CharizardBack.png"));

                Image PokeBack = MonsterBack.getImage();
                //Resize MonsterBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
                MonsterBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(MonsterBack);


                ImageBox.setBounds(20, 220, 400, 325);
                playerTwo.MonsterBox.add(ImageBox);
                playerTwo.MonsterBox.repaint();

            }

            //If player one selects Squirtle MonsterNumber from playerOne class will equal 1.
            if (startHere.monsterNumber == 7)
            {
                //Player one equals Squirtle.
                player1 = squirtle;
                //Get Squirtle image.
                MonsterBack = new ImageIcon(Battle.class.getResource("PokemonImages/SquirtleBack.png"));

                Image PokeBack = MonsterBack.getImage();
                //Resize MonsterBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500,500, Image.SCALE_SMOOTH);
                MonsterBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(MonsterBack);

                ImageBox.setBounds(60,300,300,300);
                playerTwo.MonsterBox.add(ImageBox);
                playerTwo.MonsterBox.repaint();
            }

            //If cpu selects Bulbasaur MonsterNumber2 from playerTwo class will equal 1.
            if(startHere.monsterNumber2 == 1)
            {
                //CPU equals Bulbasaur.
                player2 = bulbasaur2;
                //Get Bulbasaur image.
                MonsterFront = new ImageIcon(Battle.class.getResource("PokemonImages/wyrmlingFront.png"));

                Image PokeBack = MonsterFront.getImage();
                //Resize MonsterFront
                Image PokeBackReSize = PokeBack.getScaledInstance(220,220, Image.SCALE_SMOOTH);
                MonsterFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(MonsterFront);

                ImageBox2.setBounds(290,200,300,300);
                playerTwo.MonsterBox.add(ImageBox2);
                playerTwo.MonsterBox.repaint();
            }

            //If CPU selects dragonCub MonsterNumber2 from playerTwo class will equal 4.
            if(startHere.monsterNumber2 == 4)
            {
                //CPU equals dragonCub.
                player2 = dragonCub2;
                //Get dragonCub image.
                MonsterFront = new ImageIcon(Battle.class.getResource("PokemonImages/dragonCubFront.png"));

                Image PokeBack = MonsterFront.getImage();
                //Resize MonsterFront
                Image PokeBackReSize = PokeBack.getScaledInstance(150,150, Image.SCALE_SMOOTH);
                MonsterFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(MonsterFront);

                ImageBox2.setBounds(290,200,300,300);
                playerTwo.MonsterBox.add(ImageBox2);
                playerTwo.MonsterBox.repaint();
            }

            //If CPU selects Charmeleon MonsterNumber2 from playerTwo class will equal 5.
            if(startHere.monsterNumber2 == 5)
            {
                //CPU equals Charmeleon.
                player2 = charmeleon2;
                //Get Charmeleon image.
                MonsterFront = new ImageIcon(Battle.class.getResource("PokemonImages/youngDragonFront.png"));

                Image PokeBack = MonsterFront.getImage();
                //Resize MonsterFront
                Image PokeBackReSize = PokeBack.getScaledInstance(220,220, Image.SCALE_SMOOTH);
                MonsterFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(MonsterFront);

                ImageBox2.setBounds(290,200,300,300);
                playerTwo.MonsterBox.add(ImageBox2);
                playerTwo.MonsterBox.repaint();
            }

            //If CPU selects Charizard MonsterNumber2 from playerTwo class will equal 6.
            if(startHere.monsterNumber2 == 6)
            {
                //CPU equals Charizard.
                player2 = charizard2;
                //Get Charizard image.
                MonsterFront = new ImageIcon(Battle.class.getResource("PokemonImages/dragonFront.png"));

                Image PokeBack = MonsterFront.getImage();
                //Resize MonsterFront
                Image PokeBackReSize = PokeBack.getScaledInstance(230,230, Image.SCALE_SMOOTH);
                MonsterFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(MonsterFront);

                ImageBox2.setBounds(250,120,400,350);
                playerTwo.MonsterBox.add(ImageBox2);
                playerTwo.MonsterBox.repaint();
            }

            //If CPU selects Squirtle MonsterNumber2 from playerTwo class will equal 7.
            if(startHere.monsterNumber2 == 7)
            {
                //CPU equals Squirtle.
                player2 = squirtle2;
                //Get Bulbasaur image.
                MonsterFront = new ImageIcon(Battle.class.getResource("PokemonImages/seaSerpentlingFront.png"));

                Image PokeBack = MonsterFront.getImage();
                //Resize MonsterFront
                Image PokeBackReSize = PokeBack.getScaledInstance(220,220, Image.SCALE_SMOOTH);
                MonsterFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(MonsterFront);

                ImageBox2.setBounds(290,200,300,300);
                playerTwo.MonsterBox.add(ImageBox2);
                playerTwo.MonsterBox.repaint();
            }

            //Create a list to hold Player one's attacks.
            List<Attack> Moves = player1.getAttacks();

            //Depending on the number of attacks added to the Monster this for loop will add Buttons so the user could decide what attack to use.
            for(int movedraw = 0; movedraw < Moves.size(); movedraw++)
            {
                //Create an attack button if Monster has a move.
                if (movedraw == 0)
                {
                    Attack Movack = Moves.get(movedraw);

                    FirstMove.setLabel(Movack.getName());
                    //Get Button color depending on attack Monster typing.
                    Color ColorMove = MoreColor(Movack);
                    FirstMove.setBackground(ColorMove);
                    FirstMove.setBounds(0,0,142,46);
                    FirstMove.setFont(new Font("Arial", Font.BOLD, 15));
                    FirstMove.setForeground(Color.white);
                    playerTwo.MovesBox.add(FirstMove);

                }

                //Create two attack buttons if Monster has two moves.
                if (movedraw == 1)
                {
                    Attack Movack = Moves.get(movedraw);

                    SecondMove.setLabel(Movack.getName());
                    //Get Button color depending on attack monster typing.
                    Color ColorMove = MoreColor(Movack);
                    SecondMove.setBackground(ColorMove);
                    SecondMove.setBounds(142,0,142,46);
                    SecondMove.setFont(new Font("Arial", Font.BOLD, 15));
                    SecondMove.setForeground(Color.white);
                    playerTwo.MovesBox.add(SecondMove);

                }
                //Create three attack buttons if Monster has three moves.
                if (movedraw == 2)
                {
                    Attack Movack = Moves.get(movedraw);

                    ThirdMove.setLabel(Movack.getName());
                    //Get Button color depending on attack monster typing.
                    Color ColorMove = MoreColor(Movack);
                    ThirdMove.setBackground(ColorMove);
                    ThirdMove.setBounds(0,46,142,46);
                    ThirdMove.setFont(new Font("Arial", Font.BOLD, 15));
                    ThirdMove.setForeground(Color.white);
                    playerTwo.MovesBox.add(ThirdMove);

                }

                //Create four attack buttons if Monster has four moves.
                if (movedraw == 3)
                {
                    Attack Movack = Moves.get(movedraw);

                    FourthMove.setLabel(Movack.getName());
                    //Get Button color depending on attack monster typing.
                    Color ColorMove = MoreColor(Movack);
                    FourthMove.setBackground(ColorMove);
                    FourthMove.setBounds(142,46,142,46);
                    FourthMove.setFont(new Font("Arial", Font.BOLD, 15));
                    FourthMove.setForeground(Color.white);
                    playerTwo.MovesBox.add(FourthMove);
                }
            }

            //Create Button to start the Battle
            NextBattle.setLabel("Start");
            NextBattle.setForeground(Color.white);
            NextBattle.setBackground(Color.green);
            NextBattle.setFont(new Font("Arial", Font.BOLD, 17));
            NextBattle.setBounds(230,60,70,30);
            playerTwo.TextBox.add(NextBattle);

            //Create Text to go inside the information box.
            BattleText = new JLabel("<html>Click on the start button.<html>");
            BattleText.setFont(new Font("Arial", Font.BOLD, 18));
            BattleText.setBounds(10,-10,400,90);
            BattleText.setForeground(Color.white);
            playerTwo.TextBox.add(BattleText);

            //Get how much HP player one has at the start of the battle.
            HPInitial = player1.getCurrentHP();
            //Get how much HP player two has at the start of the battle.
            HPInitial2 = player2.getCurrentHP();

            //Create player one hp holder and set it to gray color so it can contrast with amount of HP the Monster has.
            HPHolder.setBackground(Color.gray);
            HPHolder.setBounds(420,500,150,25);
            playerTwo.MonsterBox.add(HPHolder);
            //Create  CPU hp holder and set it to gray color so it can contrast with amount of HP the Monster has.
            HPHolder2.setBackground(Color.gray);
            HPHolder2.setBounds(100,100,150,25);
            playerTwo.MonsterBox.add(HPHolder2);

            //Create a green bar to show player one's HP.
            CurrentHP.setBackground(Color.green);
            CurrentHP.setBounds(0,0,150,25);
            HPHolder.add(CurrentHP);
            //Create a green bar to show player two's HP.
            CurrentHP2.setBackground(Color.green);
            CurrentHP2.setBounds(0,0,150,25);
            HPHolder2.add(CurrentHP2);
            playerTwo.MonsterBox.repaint();

        //Start the Monster Battle attacking sequence.
        Fight = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Remove these three things so the game doesn't use these again.
                    playerTwo.TextBox.remove(P7Fight);
                    P7Fight.removeActionListener(Fight);
                    NextBattle.removeActionListener(Fight);

                    //CPU attacks player one.
                    takeTurn2(player2, player1, startHere, playerTwo, battle);


                    // if CPU has fainted, player one wins and battle ends.
                    if (player2.hasFainted()) {
                        //Remove these Button and action listeners to make the game not reuse them again.
                        P2Fight.removeActionListener(FighterP2);
                        playerTwo.TextBox.remove(P2Fight);
                        P5Fight.removeActionListener(FighterP5);
                        playerTwo.TextBox.remove(P5Fight);
                        P6Fight.removeActionListener(FighterP6);
                        playerTwo.TextBox.remove(P6Fight);
                        P3Fight.removeActionListener(FighterP3);
                        playerTwo.TextBox.remove(P3Fight);
                        P4Fight.removeActionListener(FighterP4);
                        playerTwo.TextBox.remove(P4Fight);
                        P5Fightsub1.removeActionListener(FighterP5sub1);
                        playerTwo.TextBox.remove(P5Fightsub1);
                        P5Fightsub2.removeActionListener(FighterP5sub2);
                        playerTwo.TextBox.remove(P5Fightsub2);
                        P7Fight.removeActionListener(Fight);
                        playerTwo.TextBox.remove(P7Fight);
                        P23Fightsub1.removeActionListener(FighterP23sub1);
                        playerTwo.TextBox.remove(P23Fightsub1);
                        P23Fightsub2.removeActionListener(FighterP23sub2);
                        playerTwo.TextBox.remove(P23Fightsub2);
                        playerTwo.MonsterBox.remove(ImageBox2);

                        //Remove BattleText to add new information about the battle.
                        playerTwo.TextBox.remove(BattleText);
                        playerTwo.TextBox.repaint();
                        //Set BattleText to show that the monster has fainted and who won.
                        BattleText.setText("<html>Opplayer1nt "+player2.getNickname() + " has<br/>fainted! " + player1.getNickname() + " wins!<html>");
                        playerTwo.TextBox.add(BattleText);
                        playerTwo.TextBox.remove(NextBattle);

                        //Disable Monster Moves buttons, so they don't interfere with the game.
                        disableplayer1Moves();

                        NextBattle.setLabel("Continue");
                        //Remove this action listener to make the game not reuse it again.
                        NextBattle.removeActionListener(Fight);
                        startHere.getMonsterPanel().repaint();

                        //Repeat the whole entire game.
                        HereWeGoAgain = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove this action listeners to make the game not reuse it again.
                                NextBattle.removeActionListener(HereWeGoAgain);

                                startHere.getMonsterPanel().removeAll();
                                startHere.getMonsterPanel().remove(rectanglePanel);
                                startHere.getMonsterPanel().repaint();

                                // Re-enable Monster attack buttons to select a move to attack with.
                                enableplayer1Moves();

                                // Restart the game.
                                startHere.restartGame(startHere);
                            }
                        };
                        NextBattle.addActionListener(HereWeGoAgain);
                        playerTwo.TextBox.add(NextBattle);
                        return;
                    }

            }
           //}
          };

        NextBattle.addActionListener(Fight);
        // Disable Monster Moves buttons, so they don't interfere with the game.
        disableplayer1Moves();
        // Enable button to continue with the battle.
        NextBattle.enable();

        // These action listeners are for when an attack is selected.

        Move1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                // Disable Monster Moves buttons so they don't interfere with the game.
                disableplayer1Moves();

                // The first move is selected.
                Movenumber = 1;

            }
        };
        FirstMove.addActionListener(Move1);
        Move2= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                // Disable Monster Moves buttons so they don't interfere with the game.
                disableplayer1Moves();
                // The second move is selected.
                Movenumber=2;

            }
        };
        SecondMove.addActionListener(Move2);

        ThirdMove.addActionListener(Move3);
        Move3= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                // Disable Monster Moves buttons, so they don't interfere with the game.
                disableplayer1Moves();
                // The third move is selected.
                Movenumber=3;

            }
        };
        ThirdMove.addActionListener(Move3);

        FourthMove.addActionListener(Move4);
        Move4= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                // Disable Monster Moves buttons so they don't interfere with the game.
                disableplayer1Moves();
                //The fourth move is selected.
                Movenumber=4;
            }
        };
        FourthMove.addActionListener(Move4);


       }

        catch(IllegalArgumentException exception)
        {
            throw new IllegalArgumentException
                    ("value must be non-negative");
        }
    }

    public  Monster_Abilities createPokeChar(JCheckBox[] monsterMoves, Attack[] monsterAttMoves, String species,
                                                    MonsterType type0, MonsterType type1, int maxHP, String ability,
                                                   String pokeNickName) {
        //Add attacks to player one's Bulbasaur if selected.
        final List<Attack> monsterAttacks = new ArrayList<>();
        for(int i = 0; i < monsterMoves.length; i++) {
            if(i == 0 && monsterMoves[i].isSelected()) {
                monsterMoves[i].setSelected(false);
                monsterAttacks.add(monsterAttMoves[i]);
            }
            else if(monsterMoves[i].isSelected()) {
                monsterMoves[i].setSelected(false);
                monsterAttacks.add(monsterAttMoves[i]);
            }

        }

        //If no attack has been chosen the monster will have the move struggle.
        if(monsterAttacks.isEmpty())
        {
            final Attack struggle = new DamageAttack("Struggle", MonsterType.NORMAL, 10, 1);
            monsterAttacks.add(struggle);
        }

        // Create monster for player
        Monster_Abilities monster = new Monster_Abilities(species, type0, type1, maxHP, monsterAttacks, ability);
        //If nickname entry for player one is blank the Monster will take its original name.
        if(pokeNickName != null && !pokeNickName.isEmpty())
        {
            monster.setNickname(pokeNickName);
        }
        return monster;
    }


    //This method will make player one attack the cpu.
    private  void takeTurn(Monster_Abilities attacker, Monster_Abilities defender, PlayerTwo playerTwo, Battle battle)
    {
        //Remove these action listeners to make the game not reuse them again.
        NextBattle.removeActionListener(Fight);
        NextBattle.removeActionListener(HereWeGoAgain);

        // if the attacker is asleep, it can't use a move
        if (attacker.getCurrentStatus() == Status.ASLEEP) {
            if(ASleepTurn<3)
            {
                //Remove BattleText to add new information about the battle.
                updateBattleText(attacker.getNickname() + " is " +
                        attacker.getCurrentStatus().toString().toLowerCase() + "!", playerTwo);

                //Add 1 to number turns Monster has slept.
                ASleepTurn++;

                //Add new button to continue the battle.
                P7Fight.setLabel("Next");
                P7Fight.setForeground(Color.white);
                P7Fight.setBackground(Color.green);
                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                P7Fight.setBounds(230, 60, 70, 30);
                playerTwo.TextBox.add(P7Fight);

                //Start the fight again.
                P7Fight.addActionListener(Fight);
                return;
            }
            //If ASleepTurn equals 3 Monster wakes up.
            if(ASleepTurn == 3)
            {
                //ASleepTurn counter restarts
                ASleepTurn=0;
                //Remove BattleText to add new information about the battle.
                updateBattleText(attacker.getNickname() + " has woken up!", playerTwo);

                //Revert Monster status back to normal.
                attacker.setCurrentStatus(Status.NORMAL);

                //Add new button to continue the battle.
                P5Fightsub1.setLabel("Next");
                P5Fightsub1.setForeground(Color.white);
                P5Fightsub1.setBackground(Color.green);
                P5Fightsub1.setFont(new Font("Arial", Font.BOLD, 17));
                P5Fightsub1.setBounds(230, 60, 70, 30);
                playerTwo.TextBox.add(P5Fightsub1);
                //Continue Battle
                FighterP5sub1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove these action listeners and buttons to make the game not reuse them again.
                        P5Fightsub1.removeActionListener(FighterP5sub1);
                        playerTwo.TextBox.remove(P5Fightsub1);
                        //Remove BattleText to add new information about the battle.
                        updateBattleText("<html>What will <br/>" + attacker.getNickname() +
                                        " do?<html>", playerTwo);

                        // Add new button to continue the battle.
                        P5Fight.setLabel("Next");
                        P5Fight.setForeground(Color.white);
                        P5Fight.setBackground(Color.green);
                        P5Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P5Fight.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P5Fight);

                        // Disable button to not interfere with Move Choice.
                        P5Fight.disable();

                        // Re-enable Monster attack buttons to select a move to attack with.
                        enableplayer1Moves();

                        // Continue Battle
                        FighterP5 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                P5Fight.removeActionListener(FighterP5);
                                playerTwo.TextBox.remove(P5Fight);
                                // Disable Monster Moves buttons, so they don't interfere with the game.
                                disableplayer1Moves();

                                // Define attack that will be used based on which attack button was clicked.
                                Attack attack = attacker.chooseAttack(battle);

                                // If Monster has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                                if (attacker.hasHealth1_3() && attacker.getAbility().equals("Blaze") &&
                                        attack.getType() == MonsterType.FIRE) {

                                            // Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>"+attacker.getNickname() + " ability " +
                                                    attacker.getAbility() +
                                                    ":<br/>Fire type moves damage<br/>are boosted!<html>", playerTwo);

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P5Fightsub2);

                                            //Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    //Remove BattleText to add new information about the battle.
                                                    updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                                            attack.getName() + "!<html>", playerTwo);

                                                    //Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    playerTwo.TextBox.add(P6Fight);

                                                    //Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            playerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                //Attack!
                                                                attack.useAttack(attacker, attacker, playerTwo, battle);

                                                                //Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                HPHolder.add(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);
                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker, playerTwo, battle);

                                                                //Update Amount of HP left.
                                                                HPHolder2.remove(CurrentHP2);
                                                                CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                                HPHolder2.add(CurrentHP2);
                                                            }

                                                            //Add new button to continue the battle.
                                                            P7Fight.setLabel("Next");
                                                            P7Fight.setForeground(Color.white);
                                                            P7Fight.setBackground(Color.green);
                                                            P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                            P7Fight.setBounds(230, 60, 70, 30);
                                                            playerTwo.TextBox.add(P7Fight);

                                                            //Start the fight again.
                                                            P7Fight.addActionListener(Fight);

                                                        }
                                                    };
                                                    P6Fight.addActionListener(FighterP6);

                                                }
                                            };
                                            P5Fightsub2.addActionListener(FighterP5sub2);
                                        }
                                //If Monster has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                                else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Overgrow")&&
                                        attack.getType() == MonsterType.GRASS) {

                                            //Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>"+attacker.getNickname() + " ability " +
                                                    attacker.getAbility() +
                                                    ":<br/>Grass type moves damage<br/>are boosted!<html>", playerTwo);

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P5Fightsub2);

                                            // Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    // Remove these action listeners and buttons to make the game
                                                    // not reuse them again.
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    // Remove BattleText to add new information about the battle.
                                                    updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                                            attack.getName() + "<html>!", playerTwo);

                                                    // Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    playerTwo.TextBox.add(P6Fight);

                                                    // Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            // Remove these action listeners and buttons to make the
                                                            // game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            playerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                // Attack!
                                                                attack.useAttack(attacker, attacker, playerTwo, battle);

                                                                // Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);

                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker, playerTwo, battle);

                                                                //Update Amount of HP left.
                                                                HPHolder2.remove(CurrentHP2);
                                                                CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                                HPHolder2.add(CurrentHP2);
                                                            }

                                                            //Add new button to continue the battle.
                                                            P7Fight.setLabel("Next");
                                                            P7Fight.setForeground(Color.white);
                                                            P7Fight.setBackground(Color.green);
                                                            P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                            P7Fight.setBounds(230, 60, 70, 30);
                                                            playerTwo.TextBox.add(P7Fight);

                                                            //Start the fight again.
                                                            P7Fight.addActionListener(Fight);

                                                        }
                                                    };
                                                    P6Fight.addActionListener(FighterP6);

                                                }
                                            };
                                            P5Fightsub2.addActionListener(FighterP5sub2);
                                        }

                                //If Monster has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                                else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Torrent")&&
                                        attack.getType() == MonsterType.WATER) {

                                            // Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>"+attacker.getNickname() + " ability " +
                                                    attacker.getAbility() +
                                                    ":<br/>Water type moves damage<br/>are boosted!<html>", playerTwo);

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P5Fightsub2);

                                            //Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    //Remove BattleText to add new information about the battle.
                                                    updateBattleText("<html>"+attacker.getNickname() + " used<br/>"
                                                            + attack.getName() + "<html>!", playerTwo);

                                                    //Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    playerTwo.TextBox.add(P6Fight);

                                                    //Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            playerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                //Attack!
                                                                attack.useAttack(attacker, attacker, playerTwo, battle);

                                                                //Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);
                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker, playerTwo, battle);

                                                                //Update Amount of HP left.
                                                                HPHolder2.remove(CurrentHP2);
                                                                CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                                HPHolder2.add(CurrentHP2);
                                                            }

                                                            //Add new button to continue the battle.
                                                            P7Fight.setLabel("Next");
                                                            P7Fight.setForeground(Color.white);
                                                            P7Fight.setBackground(Color.green);
                                                            P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                            P7Fight.setBounds(230, 60, 70, 30);
                                                            playerTwo.TextBox.add(P7Fight);

                                                            //Start the fight again.
                                                            P7Fight.addActionListener(Fight);

                                                        }
                                                    };
                                                    P6Fight.addActionListener(FighterP6);

                                                }
                                            };
                                            P5Fightsub2.addActionListener(FighterP5sub2);
                                        }


                                else {
                                    //Remove BattleText to add new information about the battle.
                                    updateBattleText("<html>"+attacker.getNickname() + " used<br/>"
                                            + attack.getName() + "<html>!", playerTwo);

                                    //Add new button to continue the battle.
                                    P6Fight.setLabel("Next");
                                    P6Fight.setForeground(Color.white);
                                    P6Fight.setBackground(Color.green);
                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                    P6Fight.setBounds(230, 60, 70, 30);
                                    playerTwo.TextBox.add(P6Fight);

                                    //Continue Battle
                                    FighterP6 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P6Fight.removeActionListener(FighterP6);
                                            playerTwo.TextBox.remove(P6Fight);
                                            if (attack.getName() == "Heal") {
                                                //Attack!
                                                attack.useAttack(attacker, attacker, playerTwo, battle);

                                                //Update Amount of HP left.
                                                HPHolder.remove(CurrentHP);
                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                HPHolder.add(CurrentHP);
                                            } else {
                                                //Attack!
                                                attack.useAttack(defender, attacker, playerTwo, battle);

                                                //Update Amount of HP left.
                                                HPHolder2.remove(CurrentHP2);
                                                CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                HPHolder2.add(CurrentHP2);
                                            }

                                            //Add new button to continue the battle.
                                            P7Fight.setLabel("Next");
                                            P7Fight.setForeground(Color.white);
                                            P7Fight.setBackground(Color.green);
                                            P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P7Fight.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P7Fight);

                                            //Start the fight again.
                                            P7Fight.addActionListener(Fight);

                                        }
                                    };
                                    P6Fight.addActionListener(FighterP6);

                                }//End else
                            }
                        };
                        P5Fight.addActionListener(FighterP5);


                    }
                };
                P5Fightsub1.addActionListener(FighterP5sub1);

            }
        }

        // otherwise, it uses a move on the target
        else {
            //Remove BattleText to add new information about the battle.
            updateBattleText("<html>What will <br/>" + attacker.getNickname() + " do?<html>", playerTwo);

            //Add new button to continue the battle.
            P5Fight.setLabel("Next");
            P5Fight.setForeground(Color.white);
            P5Fight.setBackground(Color.green);
            P5Fight.setFont(new Font("Arial", Font.BOLD, 17));
            P5Fight.setBounds(230, 60, 70, 30);
            playerTwo.TextBox.add(P5Fight);

            // Disable button to not interfere with Move Choice.
            P5Fight.disable();

            // Re-enable Monster attack buttons to select a move to attack with.
            enableplayer1Moves();

            // Continue Battle
            FighterP5 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Remove these action listeners and buttons to make the game not reuse them again.
                    P5Fight.removeActionListener(FighterP5);
                    playerTwo.TextBox.remove(P5Fight);
                    // Disable Monster Moves buttons, so they don't interfere with the game.
                    disableplayer1Moves();

                    // Define attack that will be used based on which attack button was clicked.
                    Attack attack = attacker.chooseAttack(battle);

                    // If Monster has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                     if (attacker.hasHealth1_3() &&attacker.getAbility().equals("Blaze") &&
                             attack.getType() == MonsterType.FIRE) {

                                // Remove BattleText to add new information about the battle.
                                updateBattleText("<html>"+attacker.getNickname() +
                                        " ability " + attacker.getAbility() +
                                        ":<br/>Fire type moves damage<br/>are boosted!<html>", playerTwo);

                                // Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        playerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                        //Remove BattleText to add new information about the battle.
                                        updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                                attack.getName() + "<html>!", playerTwo);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                playerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder2.remove(CurrentHP2);
                                                    CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                    HPHolder2.add(CurrentHP2);
                                                }

                                                //Add new button to continue the battle.
                                                P7Fight.setLabel("Next");
                                                P7Fight.setForeground(Color.white);
                                                P7Fight.setBackground(Color.green);
                                                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                P7Fight.setBounds(230, 60, 70, 30);
                                                playerTwo.TextBox.add(P7Fight);

                                                //Start the fight again.
                                                P7Fight.addActionListener(Fight);

                                            }
                                        };
                                        P6Fight.addActionListener(FighterP6);

                                    }
                                };
                                P5Fightsub2.addActionListener(FighterP5sub2);
                            }

                     //If Monster has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                    else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Overgrow") &&
                             attack.getType() == MonsterType.GRASS) {

                                //Remove BattleText to add new information about the battle.
                                updateBattleText("<html>"+attacker.getNickname() +
                                        " ability " + attacker.getAbility() +
                                        ":<br/>Grass type moves damage<br/>are boosted!<html>", playerTwo);

                                //Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        playerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);

                                        //Remove BattleText to add new information about the battle.
                                        updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                                attack.getName() + "!<html>", playerTwo);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                playerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder2.remove(CurrentHP2);
                                                    CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                    HPHolder2.add(CurrentHP2);
                                                }

                                                //Add new button to continue the battle.
                                                P7Fight.setLabel("Next");
                                                P7Fight.setForeground(Color.white);
                                                P7Fight.setBackground(Color.green);
                                                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                P7Fight.setBounds(230, 60, 70, 30);
                                                playerTwo.TextBox.add(P7Fight);

                                                //Start the fight again.
                                                P7Fight.addActionListener(Fight);

                                            }
                                        };
                                        P6Fight.addActionListener(FighterP6);

                                    }
                                };
                                P5Fightsub2.addActionListener(FighterP5sub2);
                            }

                     //If Monster has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                    else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Torrent")&&
                             attack.getType() == MonsterType.WATER) {

                                //Remove BattleText to add new information about the battle.
                                updateBattleText("<html>"+attacker.getNickname() +
                                        " ability " + attacker.getAbility() +
                                        ":<br/>Water type moves damage<br/>are boosted!<html>", playerTwo);

                                //Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        playerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);

                                        //Remove BattleText to add new information about the battle.
                                        updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                                attack.getName() + "!<html>", playerTwo);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                playerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker, playerTwo, battle);

                                                    //Update Amount of HP left.
                                                    HPHolder2.remove(CurrentHP2);
                                                    CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                                    HPHolder2.add(CurrentHP2);
                                                }

                                                //Add new button to continue the battle.
                                                P7Fight.setLabel("Next");
                                                P7Fight.setForeground(Color.white);
                                                P7Fight.setBackground(Color.green);
                                                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                P7Fight.setBounds(230, 60, 70, 30);
                                                playerTwo.TextBox.add(P7Fight);

                                                //Start the fight again.
                                                P7Fight.addActionListener(Fight);

                                            }
                                        };
                                        P6Fight.addActionListener(FighterP6);

                                    }
                                };
                                P5Fightsub2.addActionListener(FighterP5sub2);
                            }
                    else {
                        //Remove BattleText to add new information about the battle.
                        updateBattleText("<html>"+attacker.getNickname() + " used<br/>" +
                                attack.getName() + "!<html>", playerTwo);

                         //Add new button to continue the battle.
                        P6Fight.setLabel("Next");
                        P6Fight.setForeground(Color.white);
                        P6Fight.setBackground(Color.green);
                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P6Fight.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P6Fight);

                         //Continue Battle
                        FighterP6 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                P6Fight.removeActionListener(FighterP6);
                                playerTwo.TextBox.remove(P6Fight);
                                if (attack.getName() == "Heal") {
                                    //Attack!
                                    attack.useAttack(attacker, attacker, playerTwo, battle);

                                    //Update Amount of HP left.
                                    HPHolder.remove(CurrentHP);
                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                    HPHolder.add(CurrentHP);
                                } else {
                                    //Attack!
                                    attack.useAttack(defender, attacker, playerTwo, battle);

                                    //Update Amount of HP left.
                                    HPHolder2.remove(CurrentHP2);
                                    CurrentHP2.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial2,25);
                                    HPHolder2.add(CurrentHP2);
                                }

                                //Add new button to continue the battle.
                                P7Fight.setLabel("Next");
                                P7Fight.setForeground(Color.white);
                                P7Fight.setBackground(Color.green);
                                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P7Fight.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P7Fight);

                                //Start the fight again.
                                P7Fight.addActionListener(Fight);

                            }
                        };
                        P6Fight.addActionListener(FighterP6);
                    }//end else
                }
            };
            P5Fight.addActionListener(FighterP5);
        }//end else

    }

    //This method will make the CPU attack player one.
    private  void takeTurn2(Monster_Abilities attacker, Monster_Abilities defender, StartHere startHere,
                            PlayerTwo playerTwo, Battle battle)
    {
        //Remove BattleText to add new information about the battle.
        updateBattleText("<html>"+attacker.getNickname() + " will attack!<html>", playerTwo);

        // if the attacker is asleep, it can't use a move
        if (attacker.getCurrentStatus() == Status.ASLEEP) {
            if(ASleepTurn2<3)
            {
                //Remove BattleText to add new information about the battle.
                updateBattleText(attacker.getNickname() + " is " +
                        attacker.getCurrentStatus().toString().toLowerCase() + "!", playerTwo);

                //Add 1 to number turns Monster has slept.
                ASleepTurn2++;

                //Add new button to continue the battle.
                P4Fight.setLabel("Next");
                P4Fight.setForeground(Color.white);
                P4Fight.setBackground(Color.green);
                P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                P4Fight.setBounds(230, 60, 70, 30);
                playerTwo.TextBox.add(P4Fight);

                //Continue Battle
                FighterP4 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove these action listeners and buttons to make the game not reuse them again.
                        P4Fight.removeActionListener(FighterP4);
                        playerTwo.TextBox.remove(P4Fight);
                        takeTurn(player1, player2, playerTwo, battle);

                        // if player one has fainted, cpu wins and battle ends
                        if (player1.hasFainted()) {
                            //Remove these action listeners and buttons to make the game not reuse them again.
                            P2Fight.removeActionListener(FighterP2);
                            playerTwo.TextBox.remove(P2Fight);
                            P5Fight.removeActionListener(FighterP5);
                            playerTwo.TextBox.remove(P5Fight);
                            P6Fight.removeActionListener(FighterP6);
                            playerTwo.TextBox.remove(P6Fight);
                            P3Fight.removeActionListener(FighterP3);
                            playerTwo.TextBox.remove(P3Fight);
                            P4Fight.removeActionListener(FighterP4);
                            playerTwo.TextBox.remove(P4Fight);
                            P5Fightsub1.removeActionListener(FighterP5sub1);
                            playerTwo.TextBox.remove(P5Fightsub1);
                            P5Fightsub2.removeActionListener(FighterP5sub2);
                            playerTwo.TextBox.remove(P5Fightsub2);
                            P7Fight.removeActionListener(Fight);
                            playerTwo.TextBox.remove(P7Fight);
                            P23Fightsub1.removeActionListener(FighterP23sub1);
                            playerTwo.TextBox.remove(P23Fightsub1);
                            P23Fightsub2.removeActionListener(FighterP23sub2);
                            playerTwo.TextBox.remove(P23Fightsub2);
                            playerTwo.MonsterBox.remove(ImageBox);
                            // Remove BattleText to add new information about the battle.
                            playerTwo.TextBox.remove(BattleText);
                            playerTwo.TextBox.repaint();
                            // Set BattleText to show that the monster has fainted and who won.
                            BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                            playerTwo.TextBox.add(BattleText);
                            // Disable Monster Moves buttons so they don't interfere with the game.
                            disableplayer1Moves();

                            NextBattle.setLabel("Continue");
                            // Remove these action listeners and buttons to make the game not reuse them again.
                            NextBattle.removeActionListener(Fight);
                            startHere.getMonsterPanel().repaint();
                            // Repeat the whole entire game.
                            HereWeGoAgain = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                    NextBattle.removeActionListener(HereWeGoAgain);

                                    startHere.getMonsterPanel().removeAll();
                                    startHere.getMonsterPanel().remove(rectanglePanel);
                                    startHere.getMonsterPanel().repaint();

                                    // Re-enable Monster attack buttons to select a move to attack with.
                                    enableplayer1Moves();

                                    // Restart the game.
                                    startHere.restartGame(startHere);

                                }
                            };
                            NextBattle.addActionListener(HereWeGoAgain);
                            playerTwo.TextBox.add(NextBattle);
                            return;
                        }
                    }
                };
                P4Fight.addActionListener(FighterP4);


                return;
            }
            //If ASleepTurn2 equals 3 Monster wakes up.
            if(ASleepTurn2 == 3)
            {
                //ASleepTurn2 counter restarts
                ASleepTurn2 = 0;
                //Remove BattleText to add new information about the battle.
                updateBattleText(attacker.getNickname() + " has woken up!", playerTwo);

                //Revert Monster status back to normal.
                attacker.setCurrentStatus(Status.NORMAL);

                //Add new button to continue the battle.
                P23Fightsub1.setLabel("Next");
                P23Fightsub1.setForeground(Color.white);
                P23Fightsub1.setBackground(Color.green);
                P23Fightsub1.setFont(new Font("Arial", Font.BOLD, 17));
                P23Fightsub1.setBounds(230, 60, 70, 30);
                playerTwo.TextBox.add(P23Fightsub1);

                // Continue Battle
                FighterP23sub1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Remove these action listeners and buttons to make the game not reuse them again.
                        P23Fightsub1.removeActionListener(FighterP23sub1);
                        playerTwo.TextBox.remove(P23Fightsub1);
                        playerTwo.TextBox.remove(NextBattle);

                        // Remove BattleText to add new information about the battle.
                        updateBattleText("<html>"+attacker.getNickname() + " will attack!<html>", playerTwo);

                        // Add new button to continue the battle.
                        P2Fight.setLabel("Next");
                        P2Fight.setForeground(Color.white);
                        P2Fight.setBackground(Color.green);
                        P2Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P2Fight.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P2Fight);

                        // Continue Battle
                        FighterP2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Define attack that will be used randomly.
                                Attack attack = attacker.chooseAttack2();
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                P2Fight.removeActionListener(FighterP2);
                                playerTwo.TextBox.remove(P2Fight);

                                // If Monster has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                                if (attacker.hasHealth1_3() && attacker.getAbility().equals("Blaze") &&
                                        attack.getType() == MonsterType.FIRE) {

                                    // Remove BattleText to add new information about the battle.
                                    updateBattleText("<html>"+attacker.getNickname() +
                                            " ability " + attacker.getAbility() +
                                            ":<br/>Fire type moves damage<br/>are boosted!<html>", playerTwo);

                                    // Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    playerTwo.TextBox.add(P23Fightsub2);

                                    // Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                            playerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);

                                            // Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                                    attack.getName() + "!<html>", playerTwo);

                                            // Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P3Fight);

                                            // Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        // Attack!
                                                        attack.useAttack(attacker, attacker, playerTwo, battle);

                                                        // Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker, playerTwo, battle);

                                                        //Update Amount of HP left.
                                                        HPHolder.remove(CurrentHP);
                                                        CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                                        HPHolder.add(CurrentHP);
                                                    }

                                                    //Add new button to continue the battle.
                                                    P4Fight.setLabel("Next");
                                                    P4Fight.setForeground(Color.white);
                                                    P4Fight.setBackground(Color.green);
                                                    P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P4Fight.setBounds(230, 60, 70, 30);
                                                    playerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            playerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(player1, player2, playerTwo, battle);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (player1.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                playerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                playerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                playerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                playerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                playerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                playerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                playerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                playerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                playerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                playerTwo.TextBox.remove(P23Fightsub2);
                                                                playerTwo.MonsterBox.remove(ImageBox);

                                                                // Remove BattleText to add new information about the battle.
                                                                playerTwo.TextBox.remove(BattleText);
                                                                playerTwo.TextBox.repaint();
                                                                // Set BattleText to show that the monster has fainted and who won.
                                                                BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                                playerTwo.TextBox.add(BattleText);

                                                                // Disable Monster Moves buttons so they don't interfere with the game.
                                                                disableplayer1Moves();

                                                                NextBattle.setLabel("Continue");
                                                                // Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                startHere.getMonsterPanel().repaint();
                                                                // Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        startHere.getMonsterPanel().removeAll();
                                                                        startHere.getMonsterPanel().remove(rectanglePanel);
                                                                        startHere.getMonsterPanel().repaint();

                                                                        // Re-enable Monster attack buttons to select a move to attack with.
                                                                        enableplayer1Moves();

                                                                        // Restart the game.
                                                                        startHere.restartGame(startHere);
                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                playerTwo.TextBox.add(NextBattle);
                                                                return;
                                                            }
                                                        }
                                                    };
                                                    P4Fight.addActionListener(FighterP4);
                                                }
                                            };
                                            P3Fight.addActionListener(FighterP3);
                                        }
                                    };
                                    P23Fightsub2.addActionListener(FighterP23sub2);
                                }

                                // If Monster has 1/3 of health and ability is Overgrow and the attack type is grass
                                // the damage will get boosted.
                                else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Overgrow") &&
                                        attack.getType() == MonsterType.GRASS) {
                                    // Remove BattleText to add new information about the battle.
                                    updateBattleText("<html>"+attacker.getNickname() +
                                            " ability " + attacker.getAbility() +
                                            ":<br/>Grass type moves damage<br/>are boosted!<html>", playerTwo);

                                    // Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    playerTwo.TextBox.add(P23Fightsub2);

                                    // Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Remove these action listeners and buttons to make the game not
                                            // reuse them again.
                                            playerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);

                                            // Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                                    attack.getName() + "!<html>", playerTwo);

                                            // Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P3Fight);

                                            // Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        // Attack!
                                                        attack.useAttack(attacker, attacker, playerTwo, battle);

                                                        // Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker, playerTwo, battle);

                                                        //Update Amount of HP left.
                                                        HPHolder.remove(CurrentHP);
                                                        CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                                        HPHolder.add(CurrentHP);
                                                    }

                                                    //Add new button to continue the battle.
                                                    P4Fight.setLabel("Next");
                                                    P4Fight.setForeground(Color.white);
                                                    P4Fight.setBackground(Color.green);
                                                    P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P4Fight.setBounds(240, 60, 60, 30);
                                                    playerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            playerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(player1, player2, playerTwo, battle);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (player1.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                playerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                playerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                playerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                playerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                playerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                playerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                playerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                playerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                playerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                playerTwo.TextBox.remove(P23Fightsub2);
                                                                playerTwo.MonsterBox.remove(ImageBox);

                                                                // Remove BattleText to add new information about the battle.
                                                                playerTwo.TextBox.remove(BattleText);
                                                                playerTwo.TextBox.repaint();
                                                                // Set BattleText to show that the monster has fainted and who won.
                                                                BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                                playerTwo.TextBox.add(BattleText);

                                                                // Disable Monster Moves buttons, so they don't interfere with the game.
                                                                disableplayer1Moves();

                                                                NextBattle.setLabel("Continue");
                                                                // Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                startHere.getMonsterPanel().repaint();
                                                                // Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        startHere.getMonsterPanel().removeAll();
                                                                        startHere.getMonsterPanel().remove(rectanglePanel);
                                                                        startHere.getMonsterPanel().repaint();

                                                                        // Re-enable Monster attack buttons to select a move to attack with.
                                                                        enableplayer1Moves();

                                                                        // Restart the game.
                                                                        startHere.restartGame(startHere);
                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                playerTwo.TextBox.add(NextBattle);
                                                                return;
                                                            }
                                                        }
                                                    };
                                                    P4Fight.addActionListener(FighterP4);
                                                }
                                            };
                                            P3Fight.addActionListener(FighterP3);
                                        }
                                    };
                                    P23Fightsub2.addActionListener(FighterP23sub2);

                                    // If Monster has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                                } else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Torrent") && attack.getType() == MonsterType.WATER) {
                                    // Remove BattleText to add new information about the battle.
                                    updateBattleText("<html>"+attacker.getNickname() +
                                            " ability " + attacker.getAbility() +
                                            ":<br/>Water type moves damage<br/>are boosted!<html>", playerTwo);

                                    // Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    playerTwo.TextBox.add(P23Fightsub2);

                                    // Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                            playerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);

                                            // Remove BattleText to add new information about the battle.
                                            updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                                    attack.getName() + "!<html>", playerTwo);

                                            //Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P3Fight);

                                            //Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        //Attack!
                                                        attack.useAttack(attacker, attacker, playerTwo, battle);

                                                        //Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker, playerTwo, battle);

                                                        //Update Amount of HP left.
                                                        HPHolder.remove(CurrentHP);
                                                        CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                                        HPHolder.add(CurrentHP);
                                                    }

                                                    //Add new button to continue the battle.
                                                    P4Fight.setLabel("Next");
                                                    P4Fight.setForeground(Color.white);
                                                    P4Fight.setBackground(Color.green);
                                                    P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P4Fight.setBounds(240, 60, 60, 30);
                                                    playerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            playerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(player1, player2, playerTwo, battle);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (player1.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                playerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                playerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                playerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                playerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                playerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                playerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                playerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                playerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                playerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                playerTwo.TextBox.remove(P23Fightsub2);
                                                                playerTwo.MonsterBox.remove(ImageBox);

                                                                // Remove BattleText to add new information about the battle.
                                                                playerTwo.TextBox.remove(BattleText);
                                                                playerTwo.TextBox.repaint();
                                                                // Set BattleText to show that the monster has fainted and who won.
                                                                BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                                playerTwo.TextBox.add(BattleText);

                                                                // Disable Monster Moves buttons, so they don't interfere with the game.
                                                                disableplayer1Moves();

                                                                NextBattle.setLabel("Continue");
                                                                // Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                startHere.getMonsterPanel().repaint();
                                                                // Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        startHere.getMonsterPanel().removeAll();
                                                                        startHere.getMonsterPanel().remove(rectanglePanel);
                                                                        startHere.getMonsterPanel().repaint();
                                                                        // Re-enable Monster attack buttons to select a move to attack with.
                                                                        enableplayer1Moves();

                                                                        // Restart the game.
                                                                        startHere.restartGame(startHere);
                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                playerTwo.TextBox.add(NextBattle);
                                                                return;
                                                            }
                                                        }
                                                    };
                                                    P4Fight.addActionListener(FighterP4);
                                                }
                                            };
                                            P3Fight.addActionListener(FighterP3);
                                        }
                                    };
                                    P23Fightsub2.addActionListener(FighterP23sub2);
                                }

                                else {
                                    // Remove BattleText to add new information about the battle.
                                    updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                            attack.getName() + "!<html>", playerTwo);

                                    //Add new button to continue the battle.
                                    P3Fight.setLabel("Next");
                                    P3Fight.setForeground(Color.white);
                                    P3Fight.setBackground(Color.green);
                                    P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                    P3Fight.setBounds(230, 60, 70, 30);
                                    playerTwo.TextBox.add(P3Fight);

                                    //Continue Battle
                                    FighterP3 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P3Fight.removeActionListener(FighterP3);
                                            playerTwo.TextBox.remove(P3Fight);
                                            if (attack.getName() == "Heal") {
                                                //Attack!
                                                attack.useAttack(attacker, attacker, playerTwo, battle);

                                                //Update Amount of HP left.
                                                HPHolder2.remove(CurrentHP2);
                                                CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                HPHolder2.add(CurrentHP2);
                                            } else {
                                                //Attack!
                                                attack.useAttack(defender, attacker, playerTwo, battle);

                                                //Update Amount of HP left.
                                                HPHolder.remove(CurrentHP);
                                                CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                                HPHolder.add(CurrentHP);
                                            }

                                            //Add new button to continue the battle.
                                            P4Fight.setLabel("Next");
                                            P4Fight.setForeground(Color.white);
                                            P4Fight.setBackground(Color.green);
                                            P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P4Fight.setBounds(230, 60, 70, 30);
                                            playerTwo.TextBox.add(P4Fight);

                                            //Continue Battle
                                            FighterP4 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P4Fight.removeActionListener(FighterP4);
                                                    playerTwo.TextBox.remove(P4Fight);
                                                    takeTurn(player1, player2, playerTwo, battle);

                                                    // If player one has fainted, cpu wins and battle ends.
                                                    if (player1.hasFainted()) {
                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                        P2Fight.removeActionListener(FighterP2);
                                                        playerTwo.TextBox.remove(P2Fight);
                                                        P5Fight.removeActionListener(FighterP5);
                                                        playerTwo.TextBox.remove(P5Fight);
                                                        P6Fight.removeActionListener(FighterP6);
                                                        playerTwo.TextBox.remove(P6Fight);
                                                        P3Fight.removeActionListener(FighterP3);
                                                        playerTwo.TextBox.remove(P3Fight);
                                                        P4Fight.removeActionListener(FighterP4);
                                                        playerTwo.TextBox.remove(P4Fight);
                                                        P5Fightsub1.removeActionListener(FighterP5sub1);
                                                        playerTwo.TextBox.remove(P5Fightsub1);
                                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                                        playerTwo.TextBox.remove(P5Fightsub2);
                                                        P7Fight.removeActionListener(Fight);
                                                        playerTwo.TextBox.remove(P7Fight);
                                                        P23Fightsub1.removeActionListener(FighterP23sub1);
                                                        playerTwo.TextBox.remove(P23Fightsub1);
                                                        P23Fightsub2.removeActionListener(FighterP23sub2);
                                                        playerTwo.TextBox.remove(P23Fightsub2);
                                                        playerTwo.MonsterBox.remove(ImageBox);

                                                        // Remove BattleText to add new information about the battle.
                                                        playerTwo.TextBox.remove(BattleText);
                                                        playerTwo.TextBox.repaint();
                                                        // Set BattleText to show that the monster has fainted and who won.
                                                        BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                        playerTwo.TextBox.add(BattleText);

                                                        // Disable Monster Moves buttons, so they don't interfere with the game.
                                                        disableplayer1Moves();

                                                        NextBattle.setLabel("Continue");
                                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                                        NextBattle.removeActionListener(Fight);
                                                        startHere.getMonsterPanel().repaint();
                                                        // Repeat the whole entire game.
                                                        HereWeGoAgain = new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                // Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(HereWeGoAgain);

                                                                startHere.getMonsterPanel().removeAll();
                                                                startHere.getMonsterPanel().remove(rectanglePanel);
                                                                startHere.getMonsterPanel().repaint();
                                                                // Re-enable Monster attack buttons to select a move to attack with.
                                                                enableplayer1Moves();

                                                                // Restart the game.
                                                                startHere.restartGame(startHere);
                                                            }
                                                        };
                                                        NextBattle.addActionListener(HereWeGoAgain);
                                                        playerTwo.TextBox.add(NextBattle);
                                                        return;
                                                    }
                                                }
                                            };
                                            P4Fight.addActionListener(FighterP4);
                                        }
                                    };
                                    P3Fight.addActionListener(FighterP3);
                                }
                            }
                        };
                        P2Fight.addActionListener(FighterP2);

                    }
                };
                P23Fightsub1.addActionListener(FighterP23sub1);

            }
        }

        else {
            playerTwo.TextBox.remove(NextBattle);

            //Add new button to continue the battle.
            P2Fight.setLabel("Next");
            P2Fight.setForeground(Color.white);
            P2Fight.setBackground(Color.green);
            P2Fight.setFont(new Font("Arial", Font.BOLD, 17));
            P2Fight.setBounds(230, 60, 70, 30);
            playerTwo.TextBox.add(P2Fight);

            //Continue Battle
            FighterP2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Define attack that will be used randomly.
                    Attack attack = attacker.chooseAttack2();
                    // Remove these action listeners and buttons to make the game not reuse them again.
                    P2Fight.removeActionListener(FighterP2);
                    playerTwo.TextBox.remove(P2Fight);

                    // If Monster has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                    if (attacker.hasHealth1_3() && attacker.getAbility().equals("Blaze") &&
                            attack.getType() == MonsterType.FIRE) {

                        // Remove BattleText to add new information about the battle.
                        updateBattleText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() +
                                ":<br/>Fire type moves damage<br/>are boosted!<html>", playerTwo);

                        // Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P23Fightsub2);

                        // Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                playerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                // Remove BattleText to add new information about the battle.
                                updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                        attack.getName() + "!<html>", playerTwo);

                                // Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P3Fight);

                                // Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        playerTwo.TextBox.remove(P3Fight);
                                        if (attack.getName() == "Heal") {
                                            // Attack!
                                            attack.useAttack(attacker, attacker, playerTwo, battle);

                                            // Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker, playerTwo, battle);

                                            //Update Amount of HP left.
                                            HPHolder.remove(CurrentHP);
                                            CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                            HPHolder.add(CurrentHP);
                                        }

                                        //Add new button to continue the battle.
                                        P4Fight.setLabel("Next");
                                        P4Fight.setForeground(Color.white);
                                        P4Fight.setBackground(Color.green);
                                        P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P4Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                playerTwo.TextBox.remove(P4Fight);
                                                takeTurn(player1, player2, playerTwo, battle);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (player1.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    playerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    playerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    playerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    playerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    playerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    playerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    playerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    playerTwo.TextBox.remove(P23Fightsub2);
                                                    playerTwo.MonsterBox.remove(ImageBox);

                                                    // Remove BattleText to add new information about the battle.
                                                    playerTwo.TextBox.remove(BattleText);
                                                    playerTwo.TextBox.repaint();
                                                    // Set BattleText to show that the monster has fainted and who won.
                                                    BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                    playerTwo.TextBox.add(BattleText);

                                                    // Disable Monster Moves buttons, so they don't interfere with the game.
                                                    disableplayer1Moves();

                                                    NextBattle.setLabel("Continue");
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    startHere.getMonsterPanel().repaint();

                                                    // Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            startHere.getMonsterPanel().removeAll();
                                                            startHere.getMonsterPanel().remove(rectanglePanel);
                                                            startHere.getMonsterPanel().repaint();
                                                            //Re-enable Monster attack buttons to select a move to attack with.
                                                            enableplayer1Moves();

                                                            //Restart the game.
                                                            startHere.restartGame(startHere);
                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    playerTwo.TextBox.add(NextBattle);
                                                    return;
                                                }
                                            }
                                        };
                                        P4Fight.addActionListener(FighterP4);
                                    }
                                };
                                P3Fight.addActionListener(FighterP3);
                            }
                        };
                        P23Fightsub2.addActionListener(FighterP23sub2);
                    }
                    // If Monster has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                    else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Overgrow") && attack.getType() == MonsterType.GRASS) {

                        // Remove BattleText to add new information about the battle.
                        updateBattleText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() +
                                ":<br/>Grass type moves damage<br/>are boosted!<html>", playerTwo);

                        // Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P23Fightsub2);

                        // Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                playerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);

                                // Remove BattleText to add new information about the battle.
                                updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                        attack.getName() + "!<html>", playerTwo);

                                //Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P3Fight);

                                // Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        playerTwo.TextBox.remove(P3Fight);
                                        if (attack.getName() == "Heal") {
                                            // Attack!
                                            attack.useAttack(attacker, attacker, playerTwo, battle);

                                            // Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker, playerTwo, battle);

                                            //Update Amount of HP left.
                                            HPHolder.remove(CurrentHP);
                                            CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                            HPHolder.add(CurrentHP);
                                        }

                                        //Add new button to continue the battle.
                                        P4Fight.setLabel("Next");
                                        P4Fight.setForeground(Color.white);
                                        P4Fight.setBackground(Color.green);
                                        P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P4Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                playerTwo.TextBox.remove(P4Fight);
                                                takeTurn(player1, player2, playerTwo, battle);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (player1.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    playerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    playerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    playerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    playerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    playerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    playerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    playerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    playerTwo.TextBox.remove(P23Fightsub2);
                                                    playerTwo.MonsterBox.remove(ImageBox);

                                                    // Remove BattleText to add new information about the battle.
                                                    playerTwo.TextBox.remove(BattleText);
                                                    playerTwo.TextBox.repaint();
                                                    // Set BattleText to show that the monster has fainted and who won.
                                                    BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                    playerTwo.TextBox.add(BattleText);

                                                    // Disable Monster Moves buttons, so they don't interfere with the game.
                                                    disableplayer1Moves();

                                                    NextBattle.setLabel("Continue");
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    startHere.getMonsterPanel().repaint();

                                                    // Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            startHere.getMonsterPanel().removeAll();
                                                            startHere.getMonsterPanel().remove(rectanglePanel);
                                                            startHere.getMonsterPanel().repaint();
                                                            // Re-enable Monster attack buttons to select a move to attack with.
                                                            enableplayer1Moves();

                                                            // Restart the game.
                                                            startHere.restartGame(startHere);
                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    playerTwo.TextBox.add(NextBattle);
                                                    return;
                                                }
                                            }
                                        };
                                        P4Fight.addActionListener(FighterP4);
                                    }
                                };
                                P3Fight.addActionListener(FighterP3);
                            }
                        };
                        P23Fightsub2.addActionListener(FighterP23sub2);

                        // If Monster has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                    } else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Torrent") && attack.getType() == MonsterType.WATER) {

                        // Remove BattleText to add new information about the battle.
                        updateBattleText("<html>" + attacker.getNickname() + " ability " + attacker.getAbility() +
                                ":<br/>Water type moves damage<br/>are boosted!<html>", playerTwo);

                        // Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P23Fightsub2);

                        // Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                playerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);

                                // Remove BattleText to add new information about the battle.
                                updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                        attack.getName() + "!<html>", playerTwo);

                                //Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P3Fight);

                                // Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        playerTwo.TextBox.remove(P3Fight);


                                        if (attack.getName() == "Heal") {
                                            // Attack!
                                            attack.useAttack(attacker, attacker, playerTwo, battle);
                                            // Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker, playerTwo, battle);
                                            //Update Amount of HP left.
                                            HPHolder.remove(CurrentHP);
                                            CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                            HPHolder.add(CurrentHP);
                                        }

                                        //Add new button to continue the battle.
                                        P4Fight.setLabel("Next");
                                        P4Fight.setForeground(Color.white);
                                        P4Fight.setBackground(Color.green);
                                        P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P4Fight.setBounds(230, 60, 70, 30);
                                        playerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                playerTwo.TextBox.remove(P4Fight);
                                                takeTurn(player1, player2, playerTwo, battle);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (player1.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    playerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    playerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    playerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    playerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    playerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    playerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    playerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    playerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    playerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    playerTwo.TextBox.remove(P23Fightsub2);
                                                    playerTwo.MonsterBox.remove(ImageBox);

                                                    // Remove BattleText to add new information about the battle.
                                                    playerTwo.TextBox.remove(BattleText);
                                                    playerTwo.TextBox.repaint();
                                                    // Set BattleText to show that the monster has fainted and who won.
                                                    BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                                    playerTwo.TextBox.add(BattleText);

                                                    //Disable Monster Moves buttons, so they don't interfere with the game.
                                                    disableplayer1Moves();

                                                    NextBattle.setLabel("Continue");
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    startHere.getMonsterPanel().repaint();

                                                    // Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            startHere.getMonsterPanel().removeAll();
                                                            startHere.getMonsterPanel().remove(rectanglePanel);
                                                            startHere.getMonsterPanel().repaint();
                                                            //Re-enable Monster attack buttons to select a move to attack with.
                                                            enableplayer1Moves();

                                                            //Restart the game.
                                                            startHere.restartGame(startHere);
                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    playerTwo.TextBox.add(NextBattle);
                                                    return;
                                                }
                                            }
                                        };
                                        P4Fight.addActionListener(FighterP4);
                                    }
                                };
                                P3Fight.addActionListener(FighterP3);
                            }
                        };
                        P23Fightsub2.addActionListener(FighterP23sub2);
                    }

                    else {

                        // Remove BattleText to add new information about the battle.
                        updateBattleText("<html>" + attacker.getNickname() + " used<br/>" +
                                attack.getName() + "!<html>", playerTwo);

                        // Add new button to continue the battle.
                        P3Fight.setLabel("Next");
                        P3Fight.setForeground(Color.white);
                        P3Fight.setBackground(Color.green);
                        P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P3Fight.setBounds(230, 60, 70, 30);
                        playerTwo.TextBox.add(P3Fight);

                        // Continue Battle
                        FighterP3 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Remove these action listeners and buttons to make the game not reuse them again.
                                P3Fight.removeActionListener(FighterP3);
                                playerTwo.TextBox.remove(P3Fight);
                                if (attack.getName() == "Heal") {
                                    // Attack!
                                    attack.useAttack(attacker, attacker, playerTwo, battle);

                                    // Update Amount of HP left.
                                    HPHolder2.remove(CurrentHP2);
                                    CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                    HPHolder2.add(CurrentHP2);
                                } else {
                                    //Attack!
                                    attack.useAttack(defender, attacker, playerTwo, battle);

                                    //Update Amount of HP left.
                                    HPHolder.remove(CurrentHP);
                                    CurrentHP.setBounds(0,0,(defender.getCurrentHP()*150)/HPInitial,25);
                                    HPHolder.add(CurrentHP);
                                }

                                //Add new button to continue the battle.
                                P4Fight.setLabel("Next");
                                P4Fight.setForeground(Color.white);
                                P4Fight.setBackground(Color.green);
                                P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P4Fight.setBounds(230, 60, 70, 30);
                                playerTwo.TextBox.add(P4Fight);

                                //Continue Battle
                                FighterP4 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        P4Fight.removeActionListener(FighterP4);
                                        playerTwo.TextBox.remove(P4Fight);
                                        takeTurn(player1, player2, playerTwo, battle);

                                        // If player one has fainted, cpu wins and battle ends.
                                        if (player1.hasFainted()) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P2Fight.removeActionListener(FighterP2);
                                            playerTwo.TextBox.remove(P2Fight);
                                            P5Fight.removeActionListener(FighterP5);
                                            playerTwo.TextBox.remove(P5Fight);
                                            P6Fight.removeActionListener(FighterP6);
                                            playerTwo.TextBox.remove(P6Fight);
                                            P3Fight.removeActionListener(FighterP3);
                                            playerTwo.TextBox.remove(P3Fight);
                                            P4Fight.removeActionListener(FighterP4);
                                            playerTwo.TextBox.remove(P4Fight);
                                            P5Fightsub1.removeActionListener(FighterP5sub1);
                                            playerTwo.TextBox.remove(P5Fightsub1);
                                            P5Fightsub2.removeActionListener(FighterP5sub2);
                                            playerTwo.TextBox.remove(P5Fightsub2);
                                            P7Fight.removeActionListener(Fight);
                                            playerTwo.TextBox.remove(P7Fight);
                                            P23Fightsub1.removeActionListener(FighterP23sub1);
                                            playerTwo.TextBox.remove(P23Fightsub1);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);
                                            playerTwo.TextBox.remove(P23Fightsub2);
                                            playerTwo.MonsterBox.remove(ImageBox);

                                            // Remove BattleText to add new information about the battle.
                                            playerTwo.TextBox.remove(BattleText);
                                            playerTwo.TextBox.repaint();
                                            // Set BattleText to show that the monster has fainted and who won.
                                            BattleText.setText("<html>" + player1.getNickname() + " has fainted!<br/>Opplayer1nt " + player2.getNickname() + " wins!<html>");
                                            playerTwo.TextBox.add(BattleText);

                                            // Disable Monster Moves buttons, so they don't interfere with the game.
                                            disableplayer1Moves();

                                            NextBattle.setLabel("Continue");
                                            // Remove these action listeners and buttons to make the game not reuse them again.
                                            NextBattle.removeActionListener(Fight);
                                            startHere.getMonsterPanel().repaint();

                                            // Repeat the whole entire game.
                                            HereWeGoAgain = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    // Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(HereWeGoAgain);

                                                    startHere.getMonsterPanel().removeAll();
                                                    startHere.getMonsterPanel().remove(rectanglePanel);
                                                    startHere.getMonsterPanel().repaint();
                                                    //Re-enable Monster attack buttons to select a move to attack with.
                                                    enableplayer1Moves();

                                                    //Restart the game.
                                                    startHere.restartGame(startHere);
                                                }
                                            };
                                            NextBattle.addActionListener(HereWeGoAgain);
                                            playerTwo.TextBox.add(NextBattle);
                                            return;
                                        }
                                    }
                                };
                                P4Fight.addActionListener(FighterP4);
                            }
                        };
                        P3Fight.addActionListener(FighterP3);
                    }
                }
            };
            P2Fight.addActionListener(FighterP2);
        }

    }

    public  void updateBattleText (String text, PlayerTwo playerTwo) {
        //Remove BattleText to add new information about the battle.
        playerTwo.TextBox.remove(BattleText);
        playerTwo.TextBox.repaint();
        BattleText.setText(text);
        playerTwo.TextBox.add(BattleText);
        playerTwo.TextBox.repaint();
    }

    //Determine what the Monster attack button's color will be based on the attack typing.
    public  Color MoveColor;
    public  Color MoreColor(Attack MoveChosen)
    {
        if(MoveChosen.getType() == MonsterType.FIRE)
        {
            MoveColor = Color.red;
        }
        if(MoveChosen.getType() == MonsterType.WATER)
        {
            MoveColor = Color.blue;
        }
        if(MoveChosen.getType() == MonsterType.GRASS)
        {
            MoveColor = Color.green;
        }
        if(MoveChosen.getType() == MonsterType.NORMAL)
        {
            MoveColor = Color.LIGHT_GRAY;
        }
        if(MoveChosen.getType() == MonsterType.DARK)
        {
            MoveColor = Color.black;
        }
        if(MoveChosen.getType() == MonsterType.DRAGON)
        {
            MoveColor = getBlueviolet();
        }
        if(MoveChosen.getType() == MonsterType.FLYING)
        {
            MoveColor = Color.cyan;
        }
        return (MoveColor);

    }

    private  void disableplayer1Moves() {
        FirstMove.disable();
        SecondMove.disable();
        ThirdMove.disable();
        FourthMove.disable();
    }

    private  void enableplayer1Moves() {
        FirstMove.enable();
        SecondMove.enable();
        ThirdMove.enable();
        FourthMove.enable();
    }

}
