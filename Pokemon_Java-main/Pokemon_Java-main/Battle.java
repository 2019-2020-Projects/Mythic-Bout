
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * The Battle class starts the
 * Pokemon battle. Then the class
 * restarts the whole program to
 *continue onto the StartHere.main(null)
 * again.
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */

public class Battle extends StartHere


{
    //This ImageIcon will contain the png of the Pokemon's back selected by player one.
    public static ImageIcon PokemonBack;

    //This ImageIcon will contain the png of the Pokemon's front selected for the cpu.
    public static ImageIcon PokemonFront;

    //This JLabel will hold PokemonBack to be able to move its position.
    public static JLabel ImageBox;

    //This JLabel will hold PokemonFront to be able to move its position.
    public static JLabel ImageBox2;

    //This JLabel will output the text that explains what is happening in the battle..
    public static JLabel BattleText;

    //These four buttons will be the moves that will show up to the user to select to attack the defending Pokemon.
    public static Button FirstMove=new Button();
    public static Button SecondMove=new Button();
    public static Button ThirdMove=new Button();
    public static Button FourthMove=new Button();

    //These Buttons make the battle sequence continue.
    public static Button NextBattle = new Button();
    public static Button P2Fight = new Button();
    public static Button P3Fight = new Button();
    public static Button P4Fight = new Button();
    public static Button P5Fight = new Button();
    public static Button P5Fightsub1 = new Button();
    public static Button P5Fightsub2 = new Button();
    public static Button P6Fight = new Button();
    public static Button P7Fight = new Button();
    public static Button P23Fightsub1 = new Button();
    public static Button P23Fightsub2 = new Button();

    //This will set the Pokemon chosen by player one to Pone.
    public static Pokemon_Abilities Pone;
    //This will set the Pokemon chosen for the cpu to Ptwo.
    public static Pokemon_Abilities Ptwo;

    //This counts how many turns player one's Pokemon has had the ASLEEP status.
    private static int ASleepTurn=0;
    //This counts how many turns the cpu's Pokemon has had the ASLEEP status.
    private static int ASleepTurn2=0;

    //These Action Listeners make the battle sequence continue and eventually restart the game when the battle ends..
    public static ActionListener Fight = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
             //This Action Listener restarts the game.
            public static ActionListener HereWeGoAgain = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
    };
    public static ActionListener Move1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener Move2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener Move3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener Move4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
        //This Action Listener changes the move selected depending on what attack button is clicked.
        public static int Movenumber;
        public static ActionListener MoveListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
    public static ActionListener FighterP2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP3 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP4 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP5 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP6 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public static ActionListener FighterP5sub1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP5sub2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP23sub1 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };
    public static ActionListener FighterP23sub2 = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    //Pokemon Health Bar
    //This Panel will show itself more when player one Pokemon gets damaged.
    public static Panel HPHolder = new Panel();
    //This Panel will show itself more when the cpu Pokemon gets damaged.
    public static Panel HPHolder2 = new Panel();
    //This Panel will indicate how much HP player one's Pokemon has left.
    public static Panel CurrentHP = new Panel();
    //This Panel will indicate how much HP the cpu's Pokemon has left.
    public static Panel CurrentHP2 = new Panel();
    //This variable will hold the player one Pokemon's initial HP.
    public static int HPInitial;
    //This variable will hold the cpu's initial HP.
    public static int HPInitial2;


    //This method will start the battle sequence.
    public static void StartBattle() {

        try {
            // define attacks
            final Attack tackle = new DamageAttack("Tackle", PokemonType.NORMAL, 40,1);
            final Attack scratch = new DamageAttack("Scratch",PokemonType.NORMAL,40,1);
            final Attack takedown = new DamageAttack("Take Down",PokemonType.NORMAL,90,0.85f);
            final Attack vinewhip = new DamageAttack("Vine Whip", PokemonType.GRASS, 45,1);
            final Attack razorleaf = new DamageAttack("Razor Leaf", PokemonType.GRASS, 55,0.95f);
            final Attack bubble = new DamageAttack("Bubble", PokemonType.WATER, 40,1);
            final Attack watergun = new DamageAttack("Water Gun", PokemonType.WATER, 40,1);
            final Attack bite = new DamageAttack("Bite", PokemonType.DARK, 60,1);
            final Attack bubblebeam = new DamageAttack("Bubble Beam", PokemonType.WATER, 65,1);
            final Attack sleeppowder = new StatusAttack("Sleep Powder", PokemonType.GRASS, Status.ASLEEP, 0.75f);
            final Attack ember = new DamageAttack("Ember", PokemonType.FIRE, 30,1);
            //final Attack knockout = new Stat_Dam("Knockout", PokemonType.NORMAL, Status.ASLEEP, 0.5f, 30);
            //final Attack heal = new DamageAttack("Heal", PokemonType.NORMAL, -10,1);
            final Attack struggle = new DamageAttack("Struggle",PokemonType.NORMAL,10,1);
            final Attack dragonbreath = new DamageAttack("Dragon Breath", PokemonType.DRAGON,60,1);
            final Attack firefang = new DamageAttack("Fire Fang", PokemonType.FIRE,65,0.95f);
            final Attack slash = new DamageAttack("Slash", PokemonType.NORMAL,70,1);
            final Attack flamethrower = new DamageAttack("Flamethrower", PokemonType.FIRE,90,1);
            final Attack firespin = new DamageAttack("Fire Spin", PokemonType.FIRE,90,0.85f);//5 times
            final Attack inferno = new DamageAttack("Inferno", PokemonType.FIRE,100,0.5f);
            final Attack flareblitz = new DamageAttack("Flare Blitz", PokemonType.FIRE,120,1);
            final Attack airslash = new DamageAttack("Air Slash", PokemonType.FLYING,75,0.95f);
            final Attack dragonclaw = new DamageAttack("Dragon Claw", PokemonType.DRAGON,80,1);


            //Add attacks to player one's Bulbasaur if selected.
            final List<Attack> bulbasaurAttacks = new ArrayList<>();
            if(tackleBox.isSelected())
            {
                bulbasaurAttacks.add(tackle);
            }
            if(vineWhipBox.isSelected())
            {
                vineWhipBox.setSelected(false);
                bulbasaurAttacks.add(vinewhip);
            }
            if(sleepPowderBox.isSelected())
            {
                sleepPowderBox.setSelected(false);
                bulbasaurAttacks.add(sleeppowder);
            }
            if(takeDownBox.isSelected())
            {
                takeDownBox.setSelected(false);
                bulbasaurAttacks.add(takedown);
            }
            if(razorLeafBox.isSelected())
            {
                razorLeafBox.setSelected(false);
                bulbasaurAttacks.add(razorleaf);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(bulbasaurAttacks.isEmpty())
            {
                bulbasaurAttacks.add(struggle);
            }

            //Create Bulbasaur for player one.
            Pokemon_Abilities bulbasaur = new Pokemon_Abilities("Bulbasaur", PokemonType.GRASS,PokemonType.POISON, 294, bulbasaurAttacks,"Overgrow");
            //If nickname entry for player one is blank the Pokemon will take its original name.
            if(pokemonNick != null && !pokemonNick.isEmpty())
            {
                bulbasaur.setNickname(pokemonNick);
            }

            //Add attacks to cpu's Bulbasaur if selected.
            final List<Attack> bulbasaur2Attacks = new ArrayList<>();
            if(tackle2Box.isSelected())
            {
                bulbasaur2Attacks.add(tackle);
            }
            if(vineWhip2Box.isSelected())
            {
                vineWhip2Box.setSelected(false);
                bulbasaur2Attacks.add(vinewhip);
            }
            if(sleepPowder2Box.isSelected())
            {
                sleepPowder2Box.setSelected(false);
                bulbasaur2Attacks.add(sleeppowder);
            }
            if(takeDown2Box.isSelected())
            {
                takeDown2Box.setSelected(false);
                bulbasaur2Attacks.add(takedown);
            }
            if(razorLeaf2Box.isSelected())
            {
                razorLeaf2Box.setSelected(false);
                bulbasaur2Attacks.add(razorleaf);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(bulbasaur2Attacks.isEmpty())
            {
                bulbasaur2Attacks.add(struggle);
            };
            //Create Bulbasaur for cpu.
            Pokemon_Abilities bulbasaur2 = new Pokemon_Abilities("Bulbasaur", PokemonType.GRASS,PokemonType.POISON, 294, bulbasaur2Attacks,"Overgrow");
            //If nickname entry for cpu is blank the Pokemon will take its original name.
            if(pokemon2Nick != null && !pokemon2Nick.isEmpty())
            {
                bulbasaur2.setNickname(pokemon2Nick);
            }

            //Add attacks to player one's Charmander if selected.
            final List<Attack> charmanderAttacks = new ArrayList<>();
            if(scratchBox.isSelected())
            {
                scratchBox.setSelected(false);
                charmanderAttacks.add(scratch);
            }
            if(emberBox.isSelected())
            {
                emberBox.setSelected(false);
                charmanderAttacks.add(ember);
            }
            if(dragonBreathBox.isSelected())
            {
                charmanderAttacks.add(dragonbreath);
            }
            if(fireFangBox.isSelected())
            {
                charmanderAttacks.add(firefang);
            }
            if(slashBox.isSelected())
            {
                charmanderAttacks.add(slash);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charmanderAttacks.isEmpty())
            {
                charmanderAttacks.add(struggle);
            }
            //Create Player One Charmander
            Pokemon_Abilities charmander = new Pokemon_Abilities("Charmander", PokemonType.FIRE,PokemonType.FIRE, 282, charmanderAttacks,"Blaze");
            //If player one nickname entry is blank the Pokemon will take its original name.
            if(pokemonNick != null && !pokemonNick.isEmpty())
            {
                charmander.setNickname(pokemonNick);
            }

            //Add attacks to cpu's Charmander if selected.
            final List<Attack> charmander2Attacks = new ArrayList<>();
            if(scratch2Box.isSelected())
            {
                scratch2Box.setSelected(false);
                charmander2Attacks.add(scratch);
            }
            if(ember2Box.isSelected())
            {
                ember2Box.setSelected(false);
                charmander2Attacks.add(ember);
            }
            if(dragonBreath2Box.isSelected())
            {
                charmander2Attacks.add(dragonbreath);
            }
            if(fireFang2Box.isSelected())
            {
                charmander2Attacks.add(firefang);
            }
            if(slash2Box.isSelected())
            {
                charmander2Attacks.add(slash);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charmander2Attacks.isEmpty())
            {
                charmander2Attacks.add(struggle);
            }
            //Create CPU Charmander
            Pokemon_Abilities charmander2 = new Pokemon_Abilities("Charmander", PokemonType.FIRE,PokemonType.FIRE, 282, charmander2Attacks,"Blaze");
            //If cpu nickname entry is blank the Pokemon will take its original name.
            if(pokemon2Nick != null && !pokemon2Nick.isEmpty())
            {
                charmander2.setNickname(pokemon2Nick);
            }

            //Add attacks to player one's Charmeleon if selected.
            final List<Attack> charmeleonAttacks = new ArrayList<>();
            if(dragonBreathBox.isSelected())
            {
                dragonBreathBox.setSelected(false);
                charmeleonAttacks.add(dragonbreath);
            }
            if(fireFangBox.isSelected())
            {
                fireFangBox.setSelected(false);
                charmeleonAttacks.add(firefang);
            }
            if(slashBox.isSelected())
            {
                slashBox.setSelected(false);
                charmeleonAttacks.add(slash);
            }
            if(flamethrowerBox.isSelected())
            {
                charmeleonAttacks.add(flamethrower);
            }
            if(fireSpinBox.isSelected())
            {
                fireSpinBox.setSelected(false);
                charmeleonAttacks.add(firespin);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charmeleonAttacks.isEmpty())
            {
                charmeleonAttacks.add(struggle);
            }
            //Create Player One Charmeleon
            Pokemon_Abilities charmeleon = new Pokemon_Abilities("Charmeleon", PokemonType.FIRE,PokemonType.FIRE, 320, charmeleonAttacks,"Blaze");
            //If player one nickname entry is blank the Pokemon will take its original name.
            if(pokemonNick != null && !pokemonNick.isEmpty())
            {
                charmeleon.setNickname(pokemonNick);
            }

            //Add attacks to cpu's Charmeleon if selected.
            final List<Attack> charmeleon2Attacks = new ArrayList<>();
            if(dragonBreath2Box.isSelected())
            {
                dragonBreath2Box.setSelected(false);
                charmeleon2Attacks.add(dragonbreath);
            }
            if(fireFang2Box.isSelected())
            {
                fireFang2Box.setSelected(false);
                charmeleon2Attacks.add(firefang);
            }
            if(slash2Box.isSelected())
            {
                slash2Box.setSelected(false);
                charmeleon2Attacks.add(slash);
            }
            if(flamethrower2Box.isSelected())
            {
                charmeleon2Attacks.add(flamethrower);
            }
            if(fireSpin2Box.isSelected())
            {
                fireSpin2Box.setSelected(false);
                charmeleon2Attacks.add(firespin);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charmeleon2Attacks.isEmpty())
            {
                charmeleon2Attacks.add(struggle);
            }
            //Create CPU Charmeleon
            Pokemon_Abilities charmeleon2 = new Pokemon_Abilities("Charmeleon", PokemonType.FIRE,PokemonType.FIRE, 320, charmeleon2Attacks,"Blaze");
            //If cpu nickname entry is blank the Pokemon will take its original name.
            if(pokemon2Nick != null && !pokemon2Nick.isEmpty())
            {
                charmeleon2.setNickname(pokemon2Nick);
            }

            //Add attacks to player one's Charizard if selected.
            final List<Attack> charizardAttacks = new ArrayList<>();
            if(airSlashBox.isSelected())
            {
                airSlashBox.setSelected(false);
                charizardAttacks.add(airslash);
            }
            if(dragonClawBox.isSelected())
            {
                dragonClawBox.setSelected(false);
                charizardAttacks.add(dragonclaw);
            }
            if(flamethrowerBox.isSelected())
            {
                flamethrowerBox.setSelected(false);
                charizardAttacks.add(flamethrower);
            }
            if(infernoBox.isSelected())
            {
                infernoBox.setSelected(false);
                charizardAttacks.add(inferno);
            }
            if(flareBlitzBox.isSelected())
            {
                flareBlitzBox.setSelected(false);
                charizardAttacks.add(flareblitz);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charizardAttacks.isEmpty())
            {
                charizardAttacks.add(struggle);
            }
            //Create Player One Charizard
            Pokemon_Abilities charizard = new Pokemon_Abilities("Charizard", PokemonType.FIRE,PokemonType.FLYING, 360, charizardAttacks,"Blaze");
            //If player one nickname entry is blank the Pokemon will take its original name.
            if(pokemonNick != null && !pokemonNick.isEmpty())
            {
                charizard.setNickname(pokemonNick);
            }

            //Add attacks to cpu's Charizard if selected.
            final List<Attack> charizard2Attacks = new ArrayList<>();
            if(airSlash2Box.isSelected())
            {
                airSlash2Box.setSelected(false);
                charizard2Attacks.add(airslash);
            }
            if(dragonClaw2Box.isSelected())
            {
                dragonClaw2Box.setSelected(false);
                charizard2Attacks.add(dragonclaw);
            }
            if(flamethrower2Box.isSelected())
            {
                flamethrower2Box.setSelected(false);
                charizard2Attacks.add(flamethrower);
            }
            if(inferno2Box.isSelected())
            {
                inferno2Box.setSelected(false);
                charizard2Attacks.add(inferno);
            }
            if(flareBlitz2Box.isSelected())
            {
                flareBlitz2Box.setSelected(false);
                charizard2Attacks.add(flareblitz);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(charizard2Attacks.isEmpty())
            {
                charizard2Attacks.add(struggle);
            }
            //Create CPU Charizard
            Pokemon_Abilities charizard2 = new Pokemon_Abilities("Charizard", PokemonType.FIRE,PokemonType.FLYING, 360, charizard2Attacks,"Blaze");
            //If cpu nickname entry is blank the Pokemon will take its original name.
            if(pokemon2Nick != null && !pokemon2Nick.isEmpty())
            {
                charizard2.setNickname(pokemon2Nick);
            }

            //Add attacks to player one's Squirtle if selected.
            final List<Attack> squirtleAttacks = new ArrayList<>();
            if(tackleBox.isSelected())
            {
                tackleBox.setSelected(false);
                squirtleAttacks.add(tackle);
            }
            if(bubbleBox.isSelected())
            {
                bubbleBox.setSelected(false);
                squirtleAttacks.add(bubble);
            }
            if(waterGunBox.isSelected())
            {
                waterGunBox.setSelected(false);
                squirtleAttacks.add(watergun);
            }
            if(biteBox.isSelected())
            {
                biteBox.setSelected(false);
                squirtleAttacks.add(bite);
            }
            if(bubbleBeamBox.isSelected())
            {
                bubbleBeamBox.setSelected(false);
                squirtleAttacks.add(bubblebeam);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(squirtleAttacks.isEmpty())
            {
                squirtleAttacks.add(struggle);
            }
            //Create Player One Squirtle
            Pokemon_Abilities squirtle = new Pokemon_Abilities("Squirtle", PokemonType.WATER,PokemonType.WATER, 292, squirtleAttacks,"Torrent");
            //If player one nickname entry is blank the Pokemon will take its original name.
            if(pokemonNick != null && !pokemonNick.isEmpty())
            {
                squirtle.setNickname(pokemonNick);
            }

            //Add attacks to cpu's Squirtle if selected.
            final List<Attack> squirtle2Attacks = new ArrayList<>();
            if(tackle2Box.isSelected())
            {
                tackle2Box.setSelected(false);
                squirtle2Attacks.add(tackle);
            }
            if(bubble2Box.isSelected())
            {
                bubble2Box.setSelected(false);
                squirtle2Attacks.add(bubble);
            }
            if(waterGun2Box.isSelected())
            {
                waterGun2Box.setSelected(false);
                squirtle2Attacks.add(watergun);
            }
            if(bite2Box.isSelected())
            {
                bite2Box.setSelected(false);
                squirtle2Attacks.add(bite);
            }
            if(bubbleBeam2Box.isSelected())
            {
                bubbleBeam2Box.setSelected(false);
                squirtle2Attacks.add(bubblebeam);
            }
            //If no attack has been chosen the pokemon will have the move struggle.
            if(squirtle2Attacks.isEmpty())
            {
                squirtle2Attacks.add(struggle);
            }
            //Create CPU Squirtle
            Pokemon_Abilities squirtle2 = new Pokemon_Abilities("Squirtle", PokemonType.WATER,PokemonType.WATER, 292, squirtle2Attacks,"Torrent");
            //If cpu nickname entry is blank the Pokemon will take its original name.
            if(pokemon2Nick != null && !pokemon2Nick.isEmpty())
            {
                squirtle2.setNickname(pokemon2Nick);
            }

            //Create Pone and Ptwo variables.
            Pone = bulbasaur;
            Ptwo = bulbasaur;

            //If player one selects Bulbasaur PokemonNumber from PlayerOne class will equal 1.
            if (pokemonNumber == 1)
            {
                //Player one equals Bulbasaur.
                Pone = bulbasaur;

                //Get Bulbasaur image.
                PokemonBack = new ImageIcon(Battle.class.getResource("PokemonImages/BulbasaurBack.png"));

                Image PokeBack = PokemonBack.getImage();
                //Resize PokemonBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500,500, Image.SCALE_SMOOTH);
                PokemonBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(PokemonBack);

                ImageBox.setBounds(60,300,300,300);
                PlayerTwo.PokemonBox.add(ImageBox);
                PlayerTwo.PokemonBox.repaint();
            }

            //If player one selects Charmander PokemonNumber from PlayerOne class will equal 4.
            if (pokemonNumber == 4)
            {
                //Player one equals Charmander.
                Pone = charmander;
                //Get Charmander image.
                PokemonBack = new ImageIcon(Battle.class.getResource("PokemonImages/CharmanderBack.png"));

                Image PokeBack = PokemonBack.getImage();
                Image PokeBackReSize = PokeBack.getScaledInstance(500,500, Image.SCALE_SMOOTH);
                //Resize PokemonBack
                PokemonBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(PokemonBack);

                ImageBox.setBounds(60,300,300,300);
                PlayerTwo.PokemonBox.add(ImageBox);
                PlayerTwo.PokemonBox.repaint();
            }

            //If player one selects Charmeleon PokemonNumber from PlayerOne class will equal 5.
            if (pokemonNumber == 5) {
                //Player one equals Charmeleon.
                Pone = charmeleon;
                //Get Charmeleon image.
                PokemonBack = new ImageIcon(Battle.class.getResource("PokemonImages/CharmeleonBack.png"));

                Image PokeBack = PokemonBack.getImage();
                //Resize PokemonBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
                PokemonBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(PokemonBack);

                ImageBox.setBounds(60, 300, 300, 300);
                PlayerTwo.PokemonBox.add(ImageBox);
                PlayerTwo.PokemonBox.repaint();
            }

            //If player one selects Charizard PokemonNumber from PlayerOne class will equal 6.
            if (pokemonNumber == 6) {
                //Player one equals Charizard.
                Pone = charizard;
                //Get Charizard image.
                PokemonBack = new ImageIcon(Battle.class.getResource("PokemonImages/CharizardBack.png"));

                Image PokeBack = PokemonBack.getImage();
                //Resize PokemonBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
                PokemonBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(PokemonBack);


                ImageBox.setBounds(20, 220, 400, 325);
                PlayerTwo.PokemonBox.add(ImageBox);
                PlayerTwo.PokemonBox.repaint();

            }

            //If player one selects Squirtle PokemonNumber from PlayerOne class will equal 1.
            if (pokemonNumber == 7)
            {
                //Player one equals Squirtle.
                Pone=squirtle;
                //Get Squirtle image.
                PokemonBack = new ImageIcon(Battle.class.getResource("PokemonImages/SquirtleBack.png"));

                Image PokeBack = PokemonBack.getImage();
                //Resize PokemonBack
                Image PokeBackReSize = PokeBack.getScaledInstance(500,500, Image.SCALE_SMOOTH);
                PokemonBack = new ImageIcon(PokeBackReSize);
                ImageBox = new JLabel(PokemonBack);

                ImageBox.setBounds(60,300,300,300);
                PlayerTwo.PokemonBox.add(ImageBox);
                PlayerTwo.PokemonBox.repaint();
            }

            //If cpu selects Bulbasaur PokemonNumber2 from PlayerTwo class will equal 1.
            if(pokemonNumber2 == 1)
            {
                //CPU equals Bulbasaur.
                Ptwo = bulbasaur2;
                //Get Bulbasaur image.
                PokemonFront = new ImageIcon(Battle.class.getResource("PokemonImages/BulbasaurFront.png"));

                Image PokeBack = PokemonFront.getImage();
                //Resize PokemonFront
                Image PokeBackReSize = PokeBack.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                PokemonFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(PokemonFront);

                ImageBox2.setBounds(290,200,300,300);
                PlayerTwo.PokemonBox.add(ImageBox2);
                PlayerTwo.PokemonBox.repaint();
            }

            //If CPU selects Charmander PokemonNumber2 from PlayerTwo class will equal 4.
            if(pokemonNumber2 == 4)
            {
                //CPU equals Charmander.
                Ptwo = charmander2;
                //Get Charmander image.
                PokemonFront = new ImageIcon(Battle.class.getResource("PokemonImages/CharmanderFront.png"));

                Image PokeBack = PokemonFront.getImage();
                //Resize PokemonFront
                Image PokeBackReSize = PokeBack.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                PokemonFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(PokemonFront);

                ImageBox2.setBounds(290,200,300,300);
                PlayerTwo.PokemonBox.add(ImageBox2);
                PlayerTwo.PokemonBox.repaint();
            }

            //If CPU selects Charmeleon PokemonNumber2 from PlayerTwo class will equal 5.
            if(pokemonNumber2 == 5)
            {
                //CPU equals Charmeleon.
                Ptwo=charmeleon2;
                //Get Charmeleon image.
                PokemonFront = new ImageIcon(Battle.class.getResource("PokemonImages/CharmeleonFront.png"));

                Image PokeBack = PokemonFront.getImage();
                //Resize PokemonFront
                Image PokeBackReSize = PokeBack.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                PokemonFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(PokemonFront);

                ImageBox2.setBounds(290,200,300,300);
                PlayerTwo.PokemonBox.add(ImageBox2);
                PlayerTwo.PokemonBox.repaint();
            }

            //If CPU selects Charizard PokemonNumber2 from PlayerTwo class will equal 6.
            if(pokemonNumber2 == 6)
            {
                //CPU equals Charizard.
                Ptwo = charizard2;
                //Get Charizard image.
                PokemonFront = new ImageIcon(Battle.class.getResource("PokemonImages/CharizardFront.png"));

                Image PokeBack = PokemonFront.getImage();
                //Resize PokemonFront
                Image PokeBackReSize = PokeBack.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                PokemonFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(PokemonFront);

                ImageBox2.setBounds(250,120,400,350);
                PlayerTwo.PokemonBox.add(ImageBox2);
                PlayerTwo.PokemonBox.repaint();
            }

            //If CPU selects Squirtle PokemonNumber2 from PlayerTwo class will equal 7.
            if(pokemonNumber2 == 7)
            {
                //CPU equals Squirtle.
                Ptwo = squirtle2;
                //Get Bulbasaur image.
                PokemonFront = new ImageIcon(Battle.class.getResource("PokemonImages/SquirtleFront.png"));

                Image PokeBack = PokemonFront.getImage();
                //Resize PokemonFront
                Image PokeBackReSize = PokeBack.getScaledInstance(420,420, Image.SCALE_SMOOTH);
                PokemonFront = new ImageIcon(PokeBackReSize);
                ImageBox2 = new JLabel(PokemonFront);

                ImageBox2.setBounds(290,200,300,300);
                PlayerTwo.PokemonBox.add(ImageBox2);
                PlayerTwo.PokemonBox.repaint();
            }

            //Create a list to hold Player one's attacks.
            List<Attack> Moves=Pone.getAttacks();

            //Depending on the number of attacks added to the Pokemon this for loop will add Buttons so the user could decide what attack to use.
            for(int movedraw=0;movedraw<Moves.size();movedraw++)
            {
                //Create an attack button if Pokemon has a move.
                if (movedraw==0)
                {
                    Attack Movack = Moves.get(movedraw);

                    FirstMove.setLabel(Movack.getName());
                    //Get Button color depending on attack pokemon typing.
                    Color ColorMove = MoreColor(Movack);
                    FirstMove.setBackground(ColorMove);
                    FirstMove.setBounds(0,0,142,46);
                    FirstMove.setFont(new Font("Arial", Font.BOLD, 15));
                    FirstMove.setForeground(Color.white);
                    PlayerTwo.MovesBox.add(FirstMove);

                }

                //Create two attack buttons if Pokemon has two moves.
                if (movedraw==1)
                {
                    Attack Movack = Moves.get(movedraw);

                    SecondMove.setLabel(Movack.getName());
                    //Get Button color depending on attack pokemon typing.
                    Color ColorMove = MoreColor(Movack);
                    SecondMove.setBackground(ColorMove);
                    SecondMove.setBounds(142,0,142,46);
                    SecondMove.setFont(new Font("Arial", Font.BOLD, 15));
                    SecondMove.setForeground(Color.white);
                    PlayerTwo.MovesBox.add(SecondMove);

                }
                //Create three attack buttons if Pokemon has three moves.
                if (movedraw==2)
                {
                    Attack Movack = Moves.get(movedraw);

                    ThirdMove.setLabel(Movack.getName());
                    //Get Button color depending on attack pokemon typing.
                    Color ColorMove = MoreColor(Movack);
                    ThirdMove.setBackground(ColorMove);
                    ThirdMove.setBounds(0,46,142,46);
                    ThirdMove.setFont(new Font("Arial", Font.BOLD, 15));
                    ThirdMove.setForeground(Color.white);
                    PlayerTwo.MovesBox.add(ThirdMove);

                }

                //Create four attack buttons if Pokemon has four moves.
                if (movedraw==3)
                {
                    Attack Movack = Moves.get(movedraw);

                    FourthMove.setLabel(Movack.getName());
                    //Get Button color depending on attack pokemon typing.
                    Color ColorMove = MoreColor(Movack);
                    FourthMove.setBackground(ColorMove);
                    FourthMove.setBounds(142,46,142,46);
                    FourthMove.setFont(new Font("Arial", Font.BOLD, 15));
                    FourthMove.setForeground(Color.white);
                    PlayerTwo.MovesBox.add(FourthMove);

                }
            }

            //Create Button to start the Battle
            NextBattle.setLabel("Start");
            NextBattle.setForeground(Color.white);
            NextBattle.setBackground(Color.green);
            NextBattle.setFont(new Font("Arial", Font.BOLD, 17));
            NextBattle.setBounds(230,60,70,30);
            PlayerTwo.TextBox.add(NextBattle);

            //Create Text to go inside the information box.
            BattleText = new JLabel("<html>Click on the start button.<html>");
            BattleText.setFont(new Font("Arial", Font.BOLD, 18));
            BattleText.setBounds(10,-10,400,90);
            BattleText.setForeground(Color.white);
            PlayerTwo.TextBox.add(BattleText);

            //Get how much HP player one has at the start of the battle.
            HPInitial = Pone.getCurrentHP();
            //Get how much HP player two has at the start of the battle.
            HPInitial2 = Ptwo.getCurrentHP();

            //Create player one hp holder and set it to gray color so it can contrast with amount of HP the Pokemon has.
            HPHolder.setBackground(Color.gray);
            HPHolder.setBounds(420,500,150,25);
            PlayerTwo.PokemonBox.add(HPHolder);
            //Create  CPU hp holder and set it to gray color so it can contrast with amount of HP the Pokemon has.
            HPHolder2.setBackground(Color.gray);
            HPHolder2.setBounds(100,100,150,25);
            PlayerTwo.PokemonBox.add(HPHolder2);

            //Create a green bar to show player one's HP.
            CurrentHP.setBackground(Color.green);
            CurrentHP.setBounds(0,0,150,25);
            HPHolder.add(CurrentHP);
            //Create a green bar to show player two's HP.
            CurrentHP2.setBackground(Color.green);
            CurrentHP2.setBounds(0,0,150,25);
            HPHolder2.add(CurrentHP2);


            PlayerTwo.PokemonBox.repaint();

        //Start the Pokemon Battle attacking sequence.
        Fight = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //Remove these three things so the game doesn't use these again.
                    PlayerTwo.TextBox.remove(P7Fight);
                    P7Fight.removeActionListener(Fight);
                NextBattle.removeActionListener(Fight);

                //CPU attacks player one.
                takeTurn2(Ptwo, Pone);


                // if CPU has fainted, player one wins and battle ends.
                    if (Ptwo.hasFainted()) {
                        //Remove these Button and action listeners to make the game not reuse them again.
                        P2Fight.removeActionListener(FighterP2);
                        PlayerTwo.TextBox.remove(P2Fight);
                        P5Fight.removeActionListener(FighterP5);
                        PlayerTwo.TextBox.remove(P5Fight);
                        P6Fight.removeActionListener(FighterP6);
                        PlayerTwo.TextBox.remove(P6Fight);
                        P3Fight.removeActionListener(FighterP3);
                        PlayerTwo.TextBox.remove(P3Fight);
                        P4Fight.removeActionListener(FighterP4);
                        PlayerTwo.TextBox.remove(P4Fight);
                        P5Fightsub1.removeActionListener(FighterP5sub1);
                        PlayerTwo.TextBox.remove(P5Fightsub1);
                        P5Fightsub2.removeActionListener(FighterP5sub2);
                        PlayerTwo.TextBox.remove(P5Fightsub2);
                        P7Fight.removeActionListener(Fight);
                        PlayerTwo.TextBox.remove(P7Fight);
                        P23Fightsub1.removeActionListener(FighterP23sub1);
                        PlayerTwo.TextBox.remove(P23Fightsub1);
                        P23Fightsub2.removeActionListener(FighterP23sub2);
                        PlayerTwo.TextBox.remove(P23Fightsub2);
                        PlayerTwo.PokemonBox.remove(ImageBox2);

                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        //Set BattleText to show that the pokemon has fainted and who won.
                        BattleText.setText("<html>Opponent "+Ptwo.getNickname() + " has<br/>fainted! " + Pone.getNickname() + " wins!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.remove(NextBattle);

                        //Disable Pokemon Moves buttons so they don't interfere with the game.
                        FirstMove.disable();
                        SecondMove.disable();
                        ThirdMove.disable();
                        FourthMove.disable();


                        NextBattle.setLabel("Continue");
                        //Remove this action listener to make the game not reuse it again.
                        NextBattle.removeActionListener(Fight);
                        pokemonPanel.repaint();

                        //Repeat the whole entire game.
                        HereWeGoAgain = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove this action listeners to make the game not reuse it again.
                                NextBattle.removeActionListener(HereWeGoAgain);

                                pokemonPanel.removeAll();
                                pokemonPanel.remove(rectanglePanel);
                                pokemonPanel.repaint();

                                //Re-enable Pokemon attack buttons to select a move to attack with.
                                FirstMove.enable();
                                SecondMove.enable();
                                ThirdMove.enable();
                                FourthMove.enable();

                                //Indicates that this is not the games first run.
                                gameState = false;

                                //Restart the game.
                                StartHere.main(null);
                            }
                        };
                        NextBattle.addActionListener(HereWeGoAgain);
                        PlayerTwo.TextBox.add(NextBattle);


                        return;
                    }




            }
           //}
          };

        NextBattle.addActionListener(Fight);
        //Disable Pokemon Moves buttons so they don't interfere with the game.
        FirstMove.disable();
        SecondMove.disable();
        ThirdMove.disable();
        FourthMove.disable();
        //Enable button to continue with the battle.
        NextBattle.enable();

        //These action listeners are for when an attack is selected.

        Move1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                //Disable Pokemon Moves buttons so they don't interfere with the game.
                FirstMove.disable();
                SecondMove.disable();
                ThirdMove.disable();
                FourthMove.disable();

                //The first move is selected.
                Movenumber=1;


            }
        };
        FirstMove.addActionListener(Move1);
        Move2= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                //Disable Pokemon Moves buttons so they don't interfere with the game.
                FirstMove.disable();
                SecondMove.disable();
                ThirdMove.disable();
                FourthMove.disable();
                //The second move is selected.
                Movenumber=2;


            }
        };
        SecondMove.addActionListener(Move2);

        ThirdMove.addActionListener(Move3);
        Move3= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Enable button or buttons to continue with the battle.
                P5Fight.enable();
                NextBattle.enable();
                //Disable Pokemon Moves buttons so they don't interfere with the game.
                FirstMove.disable();
                SecondMove.disable();
                ThirdMove.disable();
                FourthMove.disable();
                //The third move is selected.
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
                // Disable Pokemon Moves buttons so they don't interfere with the game.
                FirstMove.disable();
                SecondMove.disable();
                ThirdMove.disable();
                FourthMove.disable();
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

    //This method will make player one attack the cpu.
    private static void takeTurn(Pokemon_Abilities attacker, Pokemon_Abilities defender)
    {


        //Remove these action listeners to make the game not reuse them again.
        NextBattle.removeActionListener(Fight);
        NextBattle.removeActionListener(HereWeGoAgain);

        // if the attacker is asleep, it can't use a move
        if (attacker.getCurrentStatus() == Status.ASLEEP) {
            if(ASleepTurn<3)
            {
                //Remove BattleText to add new information about the battle.
                PlayerTwo.TextBox.remove(BattleText);
                PlayerTwo.TextBox.repaint();
                BattleText.setText(attacker.getNickname() + " is " + attacker.getCurrentStatus().toString().toLowerCase() + "!");
                PlayerTwo.TextBox.add(BattleText);
                PlayerTwo.TextBox.repaint();

                //Add 1 to number turns Pokemon has slept.
                ASleepTurn++;

                //Add new button to continue the battle.
                P7Fight.setLabel("Next");
                P7Fight.setForeground(Color.white);
                P7Fight.setBackground(Color.green);
                P7Fight.setFont(new Font("Arial", Font.BOLD, 17));
                P7Fight.setBounds(230, 60, 70, 30);
                PlayerTwo.TextBox.add(P7Fight);

                //Start the fight again.
                P7Fight.addActionListener(Fight);


                return;
            }
            //If ASleepTurn equals 3 Pokemon wakes up.
            if(ASleepTurn==3)
            {
                //ASleepTurn counter restarts
                ASleepTurn=0;
                //Remove BattleText to add new information about the battle.
                PlayerTwo.TextBox.remove(BattleText);
                PlayerTwo.TextBox.repaint();
                BattleText.setText(attacker.getNickname() + " has woken up!");
                PlayerTwo.TextBox.add(BattleText);
                PlayerTwo.TextBox.repaint();

                //Revert Pokemon status back to normal.
                attacker.setCurrentStatus(Status.NORMAL);

                //Add new button to continue the battle.
                P5Fightsub1.setLabel("Next");
                P5Fightsub1.setForeground(Color.white);
                P5Fightsub1.setBackground(Color.green);
                P5Fightsub1.setFont(new Font("Arial", Font.BOLD, 17));
                P5Fightsub1.setBounds(230, 60, 70, 30);
                PlayerTwo.TextBox.add(P5Fightsub1);
                //Continue Battle
                FighterP5sub1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove these action listeners and buttons to make the game not reuse them again.
                        P5Fightsub1.removeActionListener(FighterP5sub1);
                        PlayerTwo.TextBox.remove(P5Fightsub1);
                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>What will <br/>" + attacker.getNickname() + " do?<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P5Fight.setLabel("Next");
                        P5Fight.setForeground(Color.white);
                        P5Fight.setBackground(Color.green);
                        P5Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P5Fight.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P5Fight);

                        //Disable button to not interfere with Move Choice.
                        P5Fight.disable();

                        //Re-enable Pokemon attack buttons to select a move to attack with.
                        FirstMove.enable();
                        SecondMove.enable();
                        ThirdMove.enable();
                        FourthMove.enable();

                        //Continue Battle
                        FighterP5 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                P5Fight.removeActionListener(FighterP5);
                                PlayerTwo.TextBox.remove(P5Fight);
                                //Disable Pokemon Moves buttons so they don't interfere with the game.
                                FirstMove.disable();
                                SecondMove.disable();
                                ThirdMove.disable();
                                FourthMove.disable();

                                //Define attack that will be used based on which attack button was clicked.
                                Attack attack = attacker.chooseAttack();

                                //If Pokemon has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                                if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Blaze")&&attack.getType() == PokemonType.FIRE) {

                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Fire type moves damage<br/>are boosted!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P5Fightsub2);

                                            //Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                                    PlayerTwo.TextBox.repaint();


                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    PlayerTwo.TextBox.add(P6Fight);

                                                    //Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            PlayerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                //Attack!
                                                                attack.useAttack(attacker, attacker);

                                                                //Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                HPHolder.add(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);
                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker);

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
                                                            PlayerTwo.TextBox.add(P7Fight);

                                                            //Start the fight again.
                                                            P7Fight.addActionListener(Fight);

                                                        }
                                                    };
                                                    P6Fight.addActionListener(FighterP6);

                                                }
                                            };
                                            P5Fightsub2.addActionListener(FighterP5sub2);
                                        }
                                //If Pokemon has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                                else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Overgrow")&&attack.getType() == PokemonType.GRASS) {
                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Grass type moves damage<br/>are boosted!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P5Fightsub2);

                                            //Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "<html>!");
                                                    PlayerTwo.TextBox.repaint();
                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    PlayerTwo.TextBox.add(P6Fight);

                                                    //Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            PlayerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                //Attack!
                                                                attack.useAttack(attacker, attacker);

                                                                //Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);

                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker);

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
                                                            PlayerTwo.TextBox.add(P7Fight);

                                                            //Start the fight again.
                                                            P7Fight.addActionListener(Fight);

                                                        }
                                                    };
                                                    P6Fight.addActionListener(FighterP6);

                                                }
                                            };
                                            P5Fightsub2.addActionListener(FighterP5sub2);
                                        }

                                //If Pokemon has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                                else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Torrent")&&attack.getType() == PokemonType.WATER) {
                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Water type moves damage<br/>are boosted!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P5Fightsub2.setLabel("Next");
                                            P5Fightsub2.setForeground(Color.white);
                                            P5Fightsub2.setBackground(Color.green);
                                            P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                            P5Fightsub2.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P5Fightsub2);

                                            //Continue Battle
                                            FighterP5sub2 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "<html>!");
                                                    PlayerTwo.TextBox.repaint();


                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Add new button to continue the battle.
                                                    P6Fight.setLabel("Next");
                                                    P6Fight.setForeground(Color.white);
                                                    P6Fight.setBackground(Color.green);
                                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                                    P6Fight.setBounds(230, 60, 70, 30);
                                                    PlayerTwo.TextBox.add(P6Fight);

                                                    //Continue Battle
                                                    FighterP6 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P6Fight.removeActionListener(FighterP6);
                                                            PlayerTwo.TextBox.remove(P6Fight);
                                                            if (attack.getName() == "Heal") {
                                                                //Attack!
                                                                attack.useAttack(attacker, attacker);

                                                                //Update Amount of HP left.
                                                                HPHolder.remove(CurrentHP);
                                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                                HPHolder.add(CurrentHP);
                                                            } else {
                                                                //Attack!
                                                                attack.useAttack(defender, attacker);

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
                                                            PlayerTwo.TextBox.add(P7Fight);

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
                                    PlayerTwo.TextBox.remove(BattleText);
                                    PlayerTwo.TextBox.repaint();
                                    BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "<html>!");
                                    PlayerTwo.TextBox.repaint();


                                    PlayerTwo.TextBox.add(BattleText);

                                    //Add new button to continue the battle.
                                    P6Fight.setLabel("Next");
                                    P6Fight.setForeground(Color.white);
                                    P6Fight.setBackground(Color.green);
                                    P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                    P6Fight.setBounds(230, 60, 70, 30);
                                    PlayerTwo.TextBox.add(P6Fight);

                                    //Continue Battle
                                    FighterP6 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P6Fight.removeActionListener(FighterP6);
                                            PlayerTwo.TextBox.remove(P6Fight);
                                            if (attack.getName() == "Heal") {
                                                //Attack!
                                                attack.useAttack(attacker, attacker);

                                                //Update Amount of HP left.
                                                HPHolder.remove(CurrentHP);
                                                CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                HPHolder.add(CurrentHP);
                                            } else {
                                                //Attack!
                                                attack.useAttack(defender, attacker);

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
                                            PlayerTwo.TextBox.add(P7Fight);

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
            PlayerTwo.TextBox.remove(BattleText);
            PlayerTwo.TextBox.repaint();
            BattleText.setText("<html>What will <br/>" + attacker.getNickname() + " do?<html>");
            PlayerTwo.TextBox.add(BattleText);
            PlayerTwo.TextBox.repaint();

            //Add new button to continue the battle.
            P5Fight.setLabel("Next");
            P5Fight.setForeground(Color.white);
            P5Fight.setBackground(Color.green);
            P5Fight.setFont(new Font("Arial", Font.BOLD, 17));
            P5Fight.setBounds(230, 60, 70, 30);
            PlayerTwo.TextBox.add(P5Fight);

            //Disable button to not interfere with Move Choice.
            P5Fight.disable();

            //Re-enable Pokemon attack buttons to select a move to attack with.
            FirstMove.enable();
            SecondMove.enable();
            ThirdMove.enable();
            FourthMove.enable();

            //Continue Battle
            FighterP5 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Remove these action listeners and buttons to make the game not reuse them again.
                    P5Fight.removeActionListener(FighterP5);
                    PlayerTwo.TextBox.remove(P5Fight);
                    //Disable Pokemon Moves buttons so they don't interfere with the game.
                    FirstMove.disable();
                    SecondMove.disable();
                    ThirdMove.disable();
                    FourthMove.disable();

                    //Define attack that will be used based on which attack button was clicked.
                    Attack attack = attacker.chooseAttack();

                    //If Pokemon has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                     if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Blaze")&&attack.getType() == PokemonType.FIRE) {
                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Fire type moves damage<br/>are boosted!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        PlayerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                        //Remove BattleText to add new information about the battle.
                                        PlayerTwo.TextBox.remove(BattleText);
                                        PlayerTwo.TextBox.repaint();
                                        BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "<html>!");
                                        PlayerTwo.TextBox.repaint();
                                        PlayerTwo.TextBox.add(BattleText);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        PlayerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                PlayerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker);

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
                                                PlayerTwo.TextBox.add(P7Fight);

                                                //Start the fight again.
                                                P7Fight.addActionListener(Fight);

                                            }
                                        };
                                        P6Fight.addActionListener(FighterP6);

                                    }
                                };
                                P5Fightsub2.addActionListener(FighterP5sub2);
                            }

                     //If Pokemon has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                    else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Overgrow")&&attack.getType() == PokemonType.GRASS) {
                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Grass type moves damage<br/>are boosted!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        PlayerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                        //Remove BattleText to add new information about the battle.
                                        PlayerTwo.TextBox.remove(BattleText);
                                        PlayerTwo.TextBox.repaint();
                                        BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                        PlayerTwo.TextBox.repaint();
                                        PlayerTwo.TextBox.add(BattleText);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        PlayerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                PlayerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker);

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
                                                PlayerTwo.TextBox.add(P7Fight);

                                                //Start the fight again.
                                                P7Fight.addActionListener(Fight);

                                            }
                                        };
                                        P6Fight.addActionListener(FighterP6);

                                    }
                                };
                                P5Fightsub2.addActionListener(FighterP5sub2);
                            }

                     //If Pokemon has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                    else if (attacker.hasHealth1_3()&&attacker.getAbility().equals("Torrent")&&attack.getType() == PokemonType.WATER) {
                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Water type moves damage<br/>are boosted!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P5Fightsub2.setLabel("Next");
                                P5Fightsub2.setForeground(Color.white);
                                P5Fightsub2.setBackground(Color.green);
                                P5Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                P5Fightsub2.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P5Fightsub2);

                                //Continue Battle
                                FighterP5sub2 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        PlayerTwo.TextBox.remove(P5Fightsub2);
                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                        //Remove BattleText to add new information about the battle.
                                        PlayerTwo.TextBox.remove(BattleText);
                                        PlayerTwo.TextBox.repaint();
                                        BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                        PlayerTwo.TextBox.repaint();


                                        PlayerTwo.TextBox.add(BattleText);

                                        //Add new button to continue the battle.
                                        P6Fight.setLabel("Next");
                                        P6Fight.setForeground(Color.white);
                                        P6Fight.setBackground(Color.green);
                                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                        P6Fight.setBounds(230, 60, 70, 30);
                                        PlayerTwo.TextBox.add(P6Fight);

                                        //Continue Battle
                                        FighterP6 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P6Fight.removeActionListener(FighterP6);
                                                PlayerTwo.TextBox.remove(P6Fight);
                                                if (attack.getName() == "Heal") {
                                                    //Attack!
                                                    attack.useAttack(attacker, attacker);

                                                    //Update Amount of HP left.
                                                    HPHolder.remove(CurrentHP);
                                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                                    HPHolder.add(CurrentHP);
                                                } else {
                                                    //Attack!
                                                    attack.useAttack(defender, attacker);

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
                                                PlayerTwo.TextBox.add(P7Fight);

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
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>"+attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                        PlayerTwo.TextBox.repaint();
                        PlayerTwo.TextBox.add(BattleText);

                         //Add new button to continue the battle.
                        P6Fight.setLabel("Next");
                        P6Fight.setForeground(Color.white);
                        P6Fight.setBackground(Color.green);
                        P6Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P6Fight.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P6Fight);

                         //Continue Battle
                        FighterP6 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                P6Fight.removeActionListener(FighterP6);
                                PlayerTwo.TextBox.remove(P6Fight);
                                if (attack.getName() == "Heal") {
                                    //Attack!
                                    attack.useAttack(attacker, attacker);

                                    //Update Amount of HP left.
                                    HPHolder.remove(CurrentHP);
                                    CurrentHP.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial,25);
                                    HPHolder.add(CurrentHP);
                                } else {
                                    //Attack!
                                    attack.useAttack(defender, attacker);

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
                                PlayerTwo.TextBox.add(P7Fight);

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
    private static void takeTurn2(Pokemon_Abilities attacker, Pokemon_Abilities defender)
    {
        //Remove BattleText to add new information about the battle.
        PlayerTwo.TextBox.remove(BattleText);
        PlayerTwo.TextBox.repaint();
        BattleText.setText("<html>"+attacker.getNickname() + " will attack!<html>");
        PlayerTwo.TextBox.add(BattleText);
        PlayerTwo.TextBox.repaint();

        // if the attacker is asleep, it can't use a move
        if (attacker.getCurrentStatus() == Status.ASLEEP) {
            if(ASleepTurn2<3)
            {
                //Remove BattleText to add new information about the battle.
                PlayerTwo.TextBox.remove(BattleText);
                PlayerTwo.TextBox.repaint();
                BattleText.setText(attacker.getNickname() + " is " + attacker.getCurrentStatus().toString().toLowerCase() + "!");
                PlayerTwo.TextBox.add(BattleText);
                    PlayerTwo.TextBox.repaint();

                //Add 1 to number turns Pokemon has slept.
                ASleepTurn2++;

                //Add new button to continue the battle.
                P4Fight.setLabel("Next");
                P4Fight.setForeground(Color.white);
                P4Fight.setBackground(Color.green);
                P4Fight.setFont(new Font("Arial", Font.BOLD, 17));
                P4Fight.setBounds(230, 60, 70, 30);
                PlayerTwo.TextBox.add(P4Fight);

                //Continue Battle
                FighterP4 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove these action listeners and buttons to make the game not reuse them again.
                        P4Fight.removeActionListener(FighterP4);
                        PlayerTwo.TextBox.remove(P4Fight);
                        takeTurn(Pone, Ptwo);

                        // if player one has fainted, cpu wins and battle ends
                        if (Pone.hasFainted()) {
                            //Remove these action listeners and buttons to make the game not reuse them again.
                            P2Fight.removeActionListener(FighterP2);
                            PlayerTwo.TextBox.remove(P2Fight);
                            P5Fight.removeActionListener(FighterP5);
                            PlayerTwo.TextBox.remove(P5Fight);
                            P6Fight.removeActionListener(FighterP6);
                            PlayerTwo.TextBox.remove(P6Fight);
                            P3Fight.removeActionListener(FighterP3);
                            PlayerTwo.TextBox.remove(P3Fight);
                            P4Fight.removeActionListener(FighterP4);
                            PlayerTwo.TextBox.remove(P4Fight);
                            P5Fightsub1.removeActionListener(FighterP5sub1);
                            PlayerTwo.TextBox.remove(P5Fightsub1);
                            P5Fightsub2.removeActionListener(FighterP5sub2);
                            PlayerTwo.TextBox.remove(P5Fightsub2);
                            P7Fight.removeActionListener(Fight);
                            PlayerTwo.TextBox.remove(P7Fight);
                            P23Fightsub1.removeActionListener(FighterP23sub1);
                            PlayerTwo.TextBox.remove(P23Fightsub1);
                            P23Fightsub2.removeActionListener(FighterP23sub2);
                            PlayerTwo.TextBox.remove(P23Fightsub2);
                            PlayerTwo.PokemonBox.remove(ImageBox);
                            //Remove BattleText to add new information about the battle.
                            PlayerTwo.TextBox.remove(BattleText);
                            PlayerTwo.TextBox.repaint();
                            //Set BattleText to show that the pokemon has fainted and who won.
                            BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                            PlayerTwo.TextBox.add(BattleText);
                            //Disable Pokemon Moves buttons so they don't interfere with the game.
                            FirstMove.disable();
                            SecondMove.disable();
                            ThirdMove.disable();
                            FourthMove.disable();

                            NextBattle.setLabel("Continue");
                            //Remove these action listeners and buttons to make the game not reuse them again.
                            NextBattle.removeActionListener(Fight);
                            pokemonPanel.repaint();
                            //Repeat the whole entire game.
                            HereWeGoAgain = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                    NextBattle.removeActionListener(HereWeGoAgain);

                                    pokemonPanel.removeAll();
                                    pokemonPanel.remove(rectanglePanel);
                                    pokemonPanel.repaint();

                                    //Re-enable Pokemon attack buttons to select a move to attack with.
                                    FirstMove.enable();
                                    SecondMove.enable();
                                    ThirdMove.enable();
                                    FourthMove.enable();
                                    //Indicates that this is not the games first run.
                                    gameState = false;
                                    //Restart the game.
                                    StartHere.main(null);

                                }
                            };
                            NextBattle.addActionListener(HereWeGoAgain);
                            PlayerTwo.TextBox.add(NextBattle);


                            return;
                        }
                    }
                };
                P4Fight.addActionListener(FighterP4);


                return;
            }
            //If ASleepTurn2 equals 3 Pokemon wakes up.
            if(ASleepTurn2==3)
            {
                //ASleepTurn2 counter restarts
                ASleepTurn2=0;
                //Remove BattleText to add new information about the battle.
                PlayerTwo.TextBox.remove(BattleText);
                PlayerTwo.TextBox.repaint();
                BattleText.setText(attacker.getNickname() + " has woken up!");
                PlayerTwo.TextBox.add(BattleText);
                    PlayerTwo.TextBox.repaint();

                //Revert Pokemon status back to normal.
                attacker.setCurrentStatus(Status.NORMAL);

                //Add new button to continue the battle.
                P23Fightsub1.setLabel("Next");
                P23Fightsub1.setForeground(Color.white);
                P23Fightsub1.setBackground(Color.green);
                P23Fightsub1.setFont(new Font("Arial", Font.BOLD, 17));
                P23Fightsub1.setBounds(230, 60, 70, 30);
                PlayerTwo.TextBox.add(P23Fightsub1);

                //Continue Battle
                FighterP23sub1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Remove these action listeners and buttons to make the game not reuse them again.
                        P23Fightsub1.removeActionListener(FighterP23sub1);
                        PlayerTwo.TextBox.remove(P23Fightsub1);
                        PlayerTwo.TextBox.remove(NextBattle);
                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>"+attacker.getNickname() + " will attack!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P2Fight.setLabel("Next");
                        P2Fight.setForeground(Color.white);
                        P2Fight.setBackground(Color.green);
                        P2Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P2Fight.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P2Fight);

                        //Continue Battle
                        FighterP2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Define attack that will be used randomly.
                                Attack attack = attacker.chooseAttack2();
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                P2Fight.removeActionListener(FighterP2);
                                PlayerTwo.TextBox.remove(P2Fight);

                                //If Pokemon has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                                if (attacker.hasHealth1_3() && attacker.getAbility().equals("Blaze") && attack.getType() == PokemonType.FIRE) {
                                    //Remove BattleText to add new information about the battle.
                                    PlayerTwo.TextBox.remove(BattleText);
                                    PlayerTwo.TextBox.repaint();
                                    BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Fire type moves damage<br/>are boosted!<html>");
                                    PlayerTwo.TextBox.add(BattleText);
                                    PlayerTwo.TextBox.repaint();

                                    //Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    PlayerTwo.TextBox.add(P23Fightsub2);

                                    //Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            PlayerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);

                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P3Fight);

                                            //Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        //Attack!
                                                        attack.useAttack(attacker, attacker);

                                                        //Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker);

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
                                                    PlayerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            PlayerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(Pone, Ptwo);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (Pone.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                PlayerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                PlayerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                PlayerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                PlayerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                PlayerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                PlayerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                PlayerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                PlayerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                PlayerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                                                PlayerTwo.PokemonBox.remove(ImageBox);

                                                                //Remove BattleText to add new information about the battle.
                                                                PlayerTwo.TextBox.remove(BattleText);
                                                                PlayerTwo.TextBox.repaint();
                                                                //Set BattleText to show that the pokemon has fainted and who won.
                                                                BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                                PlayerTwo.TextBox.add(BattleText);

                                                                //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                                FirstMove.disable();
                                                                SecondMove.disable();
                                                                ThirdMove.disable();
                                                                FourthMove.disable();

                                                                NextBattle.setLabel("Continue");
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                pokemonPanel.repaint();
                                                                //Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        pokemonPanel.removeAll();
                                                                        pokemonPanel.remove(rectanglePanel);
                                                                        pokemonPanel.repaint();

                                                                        //Re-enable Pokemon attack buttons to select a move to attack with.
                                                                        FirstMove.enable();
                                                                        SecondMove.enable();
                                                                        ThirdMove.enable();
                                                                        FourthMove.enable();
                                                                        //Indicates that this is not the games first run.
                                                                        gameState = false;
                                                                        //Restart the game.
                                                                        StartHere.main(null);

                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                PlayerTwo.TextBox.add(NextBattle);


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

                                //If Pokemon has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                                else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Overgrow") && attack.getType() == PokemonType.GRASS) {
                                    //Remove BattleText to add new information about the battle.
                                    PlayerTwo.TextBox.remove(BattleText);
                                    PlayerTwo.TextBox.repaint();
                                    BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Grass type moves damage<br/>are boosted!<html>");
                                    PlayerTwo.TextBox.add(BattleText);
                                    PlayerTwo.TextBox.repaint();

                                    //Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    PlayerTwo.TextBox.add(P23Fightsub2);

                                    //Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            PlayerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);
                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P3Fight);

                                            //Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        //Attack!
                                                        attack.useAttack(attacker, attacker);

                                                        //Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker);

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
                                                    PlayerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            PlayerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(Pone, Ptwo);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (Pone.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                PlayerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                PlayerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                PlayerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                PlayerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                PlayerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                PlayerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                PlayerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                PlayerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                PlayerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                                                PlayerTwo.PokemonBox.remove(ImageBox);

                                                                //Remove BattleText to add new information about the battle.
                                                                PlayerTwo.TextBox.remove(BattleText);
                                                                PlayerTwo.TextBox.repaint();
                                                                //Set BattleText to show that the pokemon has fainted and who won.
                                                                BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                                PlayerTwo.TextBox.add(BattleText);

                                                                //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                                FirstMove.disable();
                                                                SecondMove.disable();
                                                                ThirdMove.disable();
                                                                FourthMove.disable();

                                                                NextBattle.setLabel("Continue");
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                pokemonPanel.repaint();
                                                                //Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        pokemonPanel.removeAll();
                                                                        pokemonPanel.remove(rectanglePanel);
                                                                        pokemonPanel.repaint();

                                                                        //Re-enable Pokemon attack buttons to select a move to attack with.
                                                                        FirstMove.enable();
                                                                        SecondMove.enable();
                                                                        ThirdMove.enable();
                                                                        FourthMove.enable();
                                                                        //Indicates that this is not the games first run.
                                                                        gameState = false;
                                                                        //Restart the game.
                                                                        StartHere.main(null);

                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                PlayerTwo.TextBox.add(NextBattle);


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

                                    //If Pokemon has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                                } else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Torrent") && attack.getType() == PokemonType.WATER) {
                                    //Remove BattleText to add new information about the battle.
                                    PlayerTwo.TextBox.remove(BattleText);
                                    PlayerTwo.TextBox.repaint();
                                    BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Water type moves damage<br/>are boosted!<html>");
                                    PlayerTwo.TextBox.add(BattleText);
                                    PlayerTwo.TextBox.repaint();

                                    //Add new button to continue the battle.
                                    P23Fightsub2.setLabel("Next");
                                    P23Fightsub2.setForeground(Color.white);
                                    P23Fightsub2.setBackground(Color.green);
                                    P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                                    P23Fightsub2.setBounds(230, 60, 70, 30);
                                    PlayerTwo.TextBox.add(P23Fightsub2);

                                    //Continue Battle
                                    FighterP23sub2 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            PlayerTwo.TextBox.remove(P23Fightsub2);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);
                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                            PlayerTwo.TextBox.add(BattleText);
                                            PlayerTwo.TextBox.repaint();

                                            //Add new button to continue the battle.
                                            P3Fight.setLabel("Next");
                                            P3Fight.setForeground(Color.white);
                                            P3Fight.setBackground(Color.green);
                                            P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                            P3Fight.setBounds(230, 60, 70, 30);
                                            PlayerTwo.TextBox.add(P3Fight);

                                            //Continue Battle
                                            FighterP3 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    if (attack.getName() == "Heal") {
                                                        //Attack!
                                                        attack.useAttack(attacker, attacker);

                                                        //Update Amount of HP left.
                                                        HPHolder2.remove(CurrentHP2);
                                                        CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                        HPHolder2.add(CurrentHP2);
                                                    } else {
                                                        //Attack!
                                                        attack.useAttack(defender, attacker);

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
                                                    PlayerTwo.TextBox.add(P4Fight);

                                                    //Continue Battle
                                                    FighterP4 = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            P4Fight.removeActionListener(FighterP4);
                                                            PlayerTwo.TextBox.remove(P4Fight);
                                                            takeTurn(Pone, Ptwo);

                                                            // if player one has fainted, cpu wins and battle ends
                                                            if (Pone.hasFainted()) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                P2Fight.removeActionListener(FighterP2);
                                                                PlayerTwo.TextBox.remove(P2Fight);
                                                                P5Fight.removeActionListener(FighterP5);
                                                                PlayerTwo.TextBox.remove(P5Fight);
                                                                P6Fight.removeActionListener(FighterP6);
                                                                PlayerTwo.TextBox.remove(P6Fight);
                                                                P3Fight.removeActionListener(FighterP3);
                                                                PlayerTwo.TextBox.remove(P3Fight);
                                                                P4Fight.removeActionListener(FighterP4);
                                                                PlayerTwo.TextBox.remove(P4Fight);
                                                                P5Fightsub1.removeActionListener(FighterP5sub1);
                                                                PlayerTwo.TextBox.remove(P5Fightsub1);
                                                                P5Fightsub2.removeActionListener(FighterP5sub2);
                                                                PlayerTwo.TextBox.remove(P5Fightsub2);
                                                                P7Fight.removeActionListener(Fight);
                                                                PlayerTwo.TextBox.remove(P7Fight);
                                                                P23Fightsub1.removeActionListener(FighterP23sub1);
                                                                PlayerTwo.TextBox.remove(P23Fightsub1);
                                                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                                                PlayerTwo.PokemonBox.remove(ImageBox);

                                                                //Remove BattleText to add new information about the battle.
                                                                PlayerTwo.TextBox.remove(BattleText);
                                                                PlayerTwo.TextBox.repaint();
                                                                //Set BattleText to show that the pokemon has fainted and who won.
                                                                BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                                PlayerTwo.TextBox.add(BattleText);

                                                                //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                                FirstMove.disable();
                                                                SecondMove.disable();
                                                                ThirdMove.disable();
                                                                FourthMove.disable();

                                                                NextBattle.setLabel("Continue");
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(Fight);
                                                                pokemonPanel.repaint();
                                                                //Repeat the whole entire game.
                                                                HereWeGoAgain = new ActionListener() {
                                                                    @Override
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                                        NextBattle.removeActionListener(HereWeGoAgain);

                                                                        pokemonPanel.removeAll();
                                                                        pokemonPanel.remove(rectanglePanel);
                                                                        pokemonPanel.repaint();
                                                                        //Re-enable Pokemon attack buttons to select a move to attack with.
                                                                        FirstMove.enable();
                                                                        SecondMove.enable();
                                                                        ThirdMove.enable();
                                                                        FourthMove.enable();
                                                                        //Indicates that this is not the games first run.
                                                                        gameState = false;
                                                                        //Restart the game.
                                                                        StartHere.main(null);

                                                                    }
                                                                };
                                                                NextBattle.addActionListener(HereWeGoAgain);
                                                                PlayerTwo.TextBox.add(NextBattle);


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
                                    //Remove BattleText to add new information about the battle.
                                    PlayerTwo.TextBox.remove(BattleText);
                                    PlayerTwo.TextBox.repaint();
                                    BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                    PlayerTwo.TextBox.add(BattleText);
                                    PlayerTwo.TextBox.repaint();

                                    //Add new button to continue the battle.
                                    P3Fight.setLabel("Next");
                                    P3Fight.setForeground(Color.white);
                                    P3Fight.setBackground(Color.green);
                                    P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                    P3Fight.setBounds(230, 60, 70, 30);
                                    PlayerTwo.TextBox.add(P3Fight);

                                    //Continue Battle
                                    FighterP3 = new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P3Fight.removeActionListener(FighterP3);
                                            PlayerTwo.TextBox.remove(P3Fight);
                                            if (attack.getName() == "Heal") {
                                                //Attack!
                                                attack.useAttack(attacker, attacker);

                                                //Update Amount of HP left.
                                                HPHolder2.remove(CurrentHP2);
                                                CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                                HPHolder2.add(CurrentHP2);
                                            } else {
                                                //Attack!
                                                attack.useAttack(defender, attacker);

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
                                            PlayerTwo.TextBox.add(P4Fight);

                                            //Continue Battle
                                            FighterP4 = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P4Fight.removeActionListener(FighterP4);
                                                    PlayerTwo.TextBox.remove(P4Fight);
                                                    takeTurn(Pone, Ptwo);

                                                    // If player one has fainted, cpu wins and battle ends.
                                                    if (Pone.hasFainted()) {
                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                        P2Fight.removeActionListener(FighterP2);
                                                        PlayerTwo.TextBox.remove(P2Fight);
                                                        P5Fight.removeActionListener(FighterP5);
                                                        PlayerTwo.TextBox.remove(P5Fight);
                                                        P6Fight.removeActionListener(FighterP6);
                                                        PlayerTwo.TextBox.remove(P6Fight);
                                                        P3Fight.removeActionListener(FighterP3);
                                                        PlayerTwo.TextBox.remove(P3Fight);
                                                        P4Fight.removeActionListener(FighterP4);
                                                        PlayerTwo.TextBox.remove(P4Fight);
                                                        P5Fightsub1.removeActionListener(FighterP5sub1);
                                                        PlayerTwo.TextBox.remove(P5Fightsub1);
                                                        P5Fightsub2.removeActionListener(FighterP5sub2);
                                                        PlayerTwo.TextBox.remove(P5Fightsub2);
                                                        P7Fight.removeActionListener(Fight);
                                                        PlayerTwo.TextBox.remove(P7Fight);
                                                        P23Fightsub1.removeActionListener(FighterP23sub1);
                                                        PlayerTwo.TextBox.remove(P23Fightsub1);
                                                        P23Fightsub2.removeActionListener(FighterP23sub2);
                                                        PlayerTwo.TextBox.remove(P23Fightsub2);
                                                        PlayerTwo.PokemonBox.remove(ImageBox);

                                                        //Remove BattleText to add new information about the battle.
                                                        PlayerTwo.TextBox.remove(BattleText);
                                                        PlayerTwo.TextBox.repaint();
                                                        //Set BattleText to show that the pokemon has fainted and who won.
                                                        BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                        PlayerTwo.TextBox.add(BattleText);

                                                        //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                        FirstMove.disable();
                                                        SecondMove.disable();
                                                        ThirdMove.disable();
                                                        FourthMove.disable();

                                                        NextBattle.setLabel("Continue");
                                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                                        NextBattle.removeActionListener(Fight);
                                                        pokemonPanel.repaint();
                                                        //Repeat the whole entire game.
                                                        HereWeGoAgain = new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                                NextBattle.removeActionListener(HereWeGoAgain);

                                                                pokemonPanel.removeAll();
                                                                pokemonPanel.remove(rectanglePanel);
                                                                pokemonPanel.repaint();
                                                                //Re-enable Pokemon attack buttons to select a move to attack with.
                                                                FirstMove.enable();
                                                                SecondMove.enable();
                                                                ThirdMove.enable();
                                                                FourthMove.enable();
                                                                //Indicates that this is not the games first run.
                                                                gameState = false;

                                                                //Restart the game.
                                                                StartHere.main(null);

                                                            }
                                                        };
                                                        NextBattle.addActionListener(HereWeGoAgain);
                                                        PlayerTwo.TextBox.add(NextBattle);


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
            PlayerTwo.TextBox.remove(NextBattle);

            //Add new button to continue the battle.
            P2Fight.setLabel("Next");
            P2Fight.setForeground(Color.white);
            P2Fight.setBackground(Color.green);
            P2Fight.setFont(new Font("Arial", Font.BOLD, 17));
            P2Fight.setBounds(230, 60, 70, 30);
            PlayerTwo.TextBox.add(P2Fight);

            //Continue Battle
            FighterP2 = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Define attack that will be used randomly.
                    Attack attack = attacker.chooseAttack2();
                    //Remove these action listeners and buttons to make the game not reuse them again.
                    P2Fight.removeActionListener(FighterP2);
                    PlayerTwo.TextBox.remove(P2Fight);

                    //If Pokemon has 1/3 of health and ability is Blaze and the attack type is fire the damage will get boosted.
                    if (attacker.hasHealth1_3() && attacker.getAbility().equals("Blaze") && attack.getType() == PokemonType.FIRE) {

                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Fire type moves damage<br/>are boosted!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P23Fightsub2);

                        //Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);
                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P3Fight);

                                //Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        PlayerTwo.TextBox.remove(P3Fight);
                                        if (attack.getName() == "Heal") {
                                            //Attack!
                                            attack.useAttack(attacker, attacker);

                                            //Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker);

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
                                        PlayerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                PlayerTwo.TextBox.remove(P4Fight);
                                                takeTurn(Pone, Ptwo);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (Pone.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    PlayerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    PlayerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    PlayerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    PlayerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    PlayerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    PlayerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    PlayerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    PlayerTwo.TextBox.remove(P23Fightsub2);
                                                    PlayerTwo.PokemonBox.remove(ImageBox);

                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    //Set BattleText to show that the pokemon has fainted and who won.
                                                    BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                    FirstMove.disable();
                                                    SecondMove.disable();
                                                    ThirdMove.disable();
                                                    FourthMove.disable();

                                                    NextBattle.setLabel("Continue");
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    pokemonPanel.repaint();

                                                    //Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            pokemonPanel.removeAll();
                                                            pokemonPanel.remove(rectanglePanel);
                                                            pokemonPanel.repaint();
                                                            //Re-enable Pokemon attack buttons to select a move to attack with.
                                                            FirstMove.enable();
                                                            SecondMove.enable();
                                                            ThirdMove.enable();
                                                            FourthMove.enable();
                                                            //Indicates that this is not the games first run.
                                                            gameState = false;
                                                            //Restart the game.
                                                            StartHere.main(null);

                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    PlayerTwo.TextBox.add(NextBattle);


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
                    //If Pokemon has 1/3 of health and ability is Overgrow and the attack type is grass the damage will get boosted.
                    else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Overgrow") && attack.getType() == PokemonType.GRASS) {

                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Grass type moves damage<br/>are boosted!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P23Fightsub2);

                        //Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);

                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P3Fight);

                                //Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        PlayerTwo.TextBox.remove(P3Fight);
                                        if (attack.getName() == "Heal") {
                                            //Attack!
                                            attack.useAttack(attacker, attacker);

                                            //Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker);

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
                                        PlayerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                PlayerTwo.TextBox.remove(P4Fight);
                                                takeTurn(Pone, Ptwo);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (Pone.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    PlayerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    PlayerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    PlayerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    PlayerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    PlayerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    PlayerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    PlayerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    PlayerTwo.TextBox.remove(P23Fightsub2);
                                                    PlayerTwo.PokemonBox.remove(ImageBox);

                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    //Set BattleText to show that the pokemon has fainted and who won.
                                                    BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                    FirstMove.disable();
                                                    SecondMove.disable();
                                                    ThirdMove.disable();
                                                    FourthMove.disable();

                                                    NextBattle.setLabel("Continue");
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    pokemonPanel.repaint();

                                                    //Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            pokemonPanel.removeAll();
                                                            pokemonPanel.remove(rectanglePanel);
                                                            pokemonPanel.repaint();
                                                            //Re-enable Pokemon attack buttons to select a move to attack with.
                                                            FirstMove.enable();
                                                            SecondMove.enable();
                                                            ThirdMove.enable();
                                                            FourthMove.enable();
                                                            //Indicates that this is not the games first run.
                                                            gameState = false;
                                                            //Restart the game.
                                                            StartHere.main(null);

                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    PlayerTwo.TextBox.add(NextBattle);


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

                        //If Pokemon has 1/3 of health and ability is Torrent and the attack type is water the damage will get boosted.
                    } else if (attacker.hasHealth1_3() && attacker.getAbility().equals("Torrent") && attack.getType() == PokemonType.WATER) {

                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>"+attacker.getNickname() + " ability " + attacker.getAbility() + ":<br/>Water type moves damage<br/>are boosted!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P23Fightsub2.setLabel("Next");
                        P23Fightsub2.setForeground(Color.white);
                        P23Fightsub2.setBackground(Color.green);
                        P23Fightsub2.setFont(new Font("Arial", Font.BOLD, 17));
                        P23Fightsub2.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P23Fightsub2);

                        //Continue Battle
                        FighterP23sub2 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                PlayerTwo.TextBox.remove(P23Fightsub2);
                                P23Fightsub2.removeActionListener(FighterP23sub2);

                                //Remove BattleText to add new information about the battle.
                                PlayerTwo.TextBox.remove(BattleText);
                                PlayerTwo.TextBox.repaint();
                                BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                                PlayerTwo.TextBox.add(BattleText);
                                PlayerTwo.TextBox.repaint();

                                //Add new button to continue the battle.
                                P3Fight.setLabel("Next");
                                P3Fight.setForeground(Color.white);
                                P3Fight.setBackground(Color.green);
                                P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                                P3Fight.setBounds(230, 60, 70, 30);
                                PlayerTwo.TextBox.add(P3Fight);

                                //Continue Battle
                                FighterP3 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        P3Fight.removeActionListener(FighterP3);
                                        PlayerTwo.TextBox.remove(P3Fight);


                                        if (attack.getName() == "Heal") {
                                            //Attack!
                                            attack.useAttack(attacker, attacker);
                                            //Update Amount of HP left.
                                            HPHolder2.remove(CurrentHP2);
                                            CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                            HPHolder2.add(CurrentHP2);
                                        } else {
                                            //Attack!
                                            attack.useAttack(defender, attacker);
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
                                        PlayerTwo.TextBox.add(P4Fight);

                                        //Continue Battle
                                        FighterP4 = new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                //Remove these action listeners and buttons to make the game not reuse them again.
                                                P4Fight.removeActionListener(FighterP4);
                                                PlayerTwo.TextBox.remove(P4Fight);
                                                takeTurn(Pone, Ptwo);

                                                // If player one has fainted, cpu wins and battle ends.
                                                if (Pone.hasFainted()) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    P2Fight.removeActionListener(FighterP2);
                                                    PlayerTwo.TextBox.remove(P2Fight);
                                                    P5Fight.removeActionListener(FighterP5);
                                                    PlayerTwo.TextBox.remove(P5Fight);
                                                    P6Fight.removeActionListener(FighterP6);
                                                    PlayerTwo.TextBox.remove(P6Fight);
                                                    P3Fight.removeActionListener(FighterP3);
                                                    PlayerTwo.TextBox.remove(P3Fight);
                                                    P4Fight.removeActionListener(FighterP4);
                                                    PlayerTwo.TextBox.remove(P4Fight);
                                                    P5Fightsub1.removeActionListener(FighterP5sub1);
                                                    PlayerTwo.TextBox.remove(P5Fightsub1);
                                                    P5Fightsub2.removeActionListener(FighterP5sub2);
                                                    PlayerTwo.TextBox.remove(P5Fightsub2);
                                                    P7Fight.removeActionListener(Fight);
                                                    PlayerTwo.TextBox.remove(P7Fight);
                                                    P23Fightsub1.removeActionListener(FighterP23sub1);
                                                    PlayerTwo.TextBox.remove(P23Fightsub1);
                                                    P23Fightsub2.removeActionListener(FighterP23sub2);
                                                    PlayerTwo.TextBox.remove(P23Fightsub2);
                                                    PlayerTwo.PokemonBox.remove(ImageBox);

                                                    //Remove BattleText to add new information about the battle.
                                                    PlayerTwo.TextBox.remove(BattleText);
                                                    PlayerTwo.TextBox.repaint();
                                                    //Set BattleText to show that the pokemon has fainted and who won.
                                                    BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                                    PlayerTwo.TextBox.add(BattleText);

                                                    //Disable Pokemon Moves buttons so they don't interfere with the game.
                                                    FirstMove.disable();
                                                    SecondMove.disable();
                                                    ThirdMove.disable();
                                                    FourthMove.disable();

                                                    NextBattle.setLabel("Continue");
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(Fight);
                                                    pokemonPanel.repaint();

                                                    //Repeat the whole entire game.
                                                    HereWeGoAgain = new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                                            NextBattle.removeActionListener(HereWeGoAgain);

                                                            pokemonPanel.removeAll();
                                                            pokemonPanel.remove(rectanglePanel);
                                                            pokemonPanel.repaint();
                                                            //Re-enable Pokemon attack buttons to select a move to attack with.
                                                            FirstMove.enable();
                                                            SecondMove.enable();
                                                            ThirdMove.enable();
                                                            FourthMove.enable();
                                                            //Indicates that this is not the games first run.
                                                            gameState = false;
                                                            //Restart the game.
                                                            StartHere.main(null);

                                                        }
                                                    };
                                                    NextBattle.addActionListener(HereWeGoAgain);
                                                    PlayerTwo.TextBox.add(NextBattle);


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

                        //Remove BattleText to add new information about the battle.
                        PlayerTwo.TextBox.remove(BattleText);
                        PlayerTwo.TextBox.repaint();
                        BattleText.setText("<html>" + attacker.getNickname() + " used<br/>" + attack.getName() + "!<html>");
                        PlayerTwo.TextBox.add(BattleText);
                        PlayerTwo.TextBox.repaint();

                        //Add new button to continue the battle.
                        P3Fight.setLabel("Next");
                        P3Fight.setForeground(Color.white);
                        P3Fight.setBackground(Color.green);
                        P3Fight.setFont(new Font("Arial", Font.BOLD, 17));
                        P3Fight.setBounds(230, 60, 70, 30);
                        PlayerTwo.TextBox.add(P3Fight);

                        //Continue Battle
                        FighterP3 = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                //Remove these action listeners and buttons to make the game not reuse them again.
                                P3Fight.removeActionListener(FighterP3);
                                PlayerTwo.TextBox.remove(P3Fight);
                                if (attack.getName() == "Heal") {
                                    //Attack!
                                    attack.useAttack(attacker, attacker);

                                    //Update Amount of HP left.
                                    HPHolder2.remove(CurrentHP2);
                                    CurrentHP2.setBounds(0,0,(attacker.getCurrentHP()*150)/HPInitial2,25);
                                    HPHolder2.add(CurrentHP2);
                                } else {
                                    //Attack!
                                    attack.useAttack(defender, attacker);

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
                                PlayerTwo.TextBox.add(P4Fight);

                                //Continue Battle
                                FighterP4 = new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        //Remove these action listeners and buttons to make the game not reuse them again.
                                        P4Fight.removeActionListener(FighterP4);
                                        PlayerTwo.TextBox.remove(P4Fight);
                                        takeTurn(Pone, Ptwo);

                                        // If player one has fainted, cpu wins and battle ends.
                                        if (Pone.hasFainted()) {
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            P2Fight.removeActionListener(FighterP2);
                                            PlayerTwo.TextBox.remove(P2Fight);
                                            P5Fight.removeActionListener(FighterP5);
                                            PlayerTwo.TextBox.remove(P5Fight);
                                            P6Fight.removeActionListener(FighterP6);
                                            PlayerTwo.TextBox.remove(P6Fight);
                                            P3Fight.removeActionListener(FighterP3);
                                            PlayerTwo.TextBox.remove(P3Fight);
                                            P4Fight.removeActionListener(FighterP4);
                                            PlayerTwo.TextBox.remove(P4Fight);
                                            P5Fightsub1.removeActionListener(FighterP5sub1);
                                            PlayerTwo.TextBox.remove(P5Fightsub1);
                                            P5Fightsub2.removeActionListener(FighterP5sub2);
                                            PlayerTwo.TextBox.remove(P5Fightsub2);
                                            P7Fight.removeActionListener(Fight);
                                            PlayerTwo.TextBox.remove(P7Fight);
                                            P23Fightsub1.removeActionListener(FighterP23sub1);
                                            PlayerTwo.TextBox.remove(P23Fightsub1);
                                            P23Fightsub2.removeActionListener(FighterP23sub2);
                                            PlayerTwo.TextBox.remove(P23Fightsub2);
                                            PlayerTwo.PokemonBox.remove(ImageBox);

                                            //Remove BattleText to add new information about the battle.
                                            PlayerTwo.TextBox.remove(BattleText);
                                            PlayerTwo.TextBox.repaint();
                                            //Set BattleText to show that the pokemon has fainted and who won.
                                            BattleText.setText("<html>" + Pone.getNickname() + " has fainted!<br/>Opponent " + Ptwo.getNickname() + " wins!<html>");
                                            PlayerTwo.TextBox.add(BattleText);

                                            //Disable Pokemon Moves buttons so they don't interfere with the game.
                                            FirstMove.disable();
                                            SecondMove.disable();
                                            ThirdMove.disable();
                                            FourthMove.disable();

                                            NextBattle.setLabel("Continue");
                                            //Remove these action listeners and buttons to make the game not reuse them again.
                                            NextBattle.removeActionListener(Fight);
                                            pokemonPanel.repaint();

                                            //Repeat the whole entire game.
                                            HereWeGoAgain = new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    //Remove these action listeners and buttons to make the game not reuse them again.
                                                    NextBattle.removeActionListener(HereWeGoAgain);

                                                    pokemonPanel.removeAll();
                                                    pokemonPanel.remove(rectanglePanel);
                                                    pokemonPanel.repaint();
                                                    //Re-enable Pokemon attack buttons to select a move to attack with.
                                                    FirstMove.enable();
                                                    SecondMove.enable();
                                                    ThirdMove.enable();
                                                    FourthMove.enable();
                                                    //Indicates that this is not the games first run.
                                                    gameState = false;
                                                    //Restart the game.
                                                    StartHere.main(null);

                                                }
                                            };
                                            NextBattle.addActionListener(HereWeGoAgain);
                                            PlayerTwo.TextBox.add(NextBattle);


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

    //Determine what the Pokemon attack button's color will be based on the attack typing.
    public static Color MoveColor;
    public static Color MoreColor(Attack MoveChosen)
    {
        if(MoveChosen.getType()== PokemonType.FIRE)
        {
            MoveColor = Color.red;
        }
        if(MoveChosen.getType()== PokemonType.WATER)
        {
            MoveColor = Color.blue;
        }
        if(MoveChosen.getType()== PokemonType.GRASS)
        {
            MoveColor = Color.green;
        }
        if(MoveChosen.getType()== PokemonType.NORMAL)
        {
            MoveColor = Color.LIGHT_GRAY;
        }
        if(MoveChosen.getType()== PokemonType.DARK)
        {
            MoveColor = Color.black;
        }
        if(MoveChosen.getType()== PokemonType.DRAGON)
        {
            MoveColor = getBlueviolet();
        }
        if(MoveChosen.getType()== PokemonType.FLYING)
        {
            MoveColor = Color.cyan;
        }
        return (MoveColor);

    }

}
