import java.util.Random;

/**
 * The StatusAttack class creates
 * Status Attacks that do not produce damage.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */

public class StatusAttack implements Attack
{
    //This variable will hold the attack name.
    private final String name;

    //This variable wll gold the attack Pokemon type.
    private final PokemonType type;

    //This variable will hold the status that this attack will inflict.
    private final Status status;

    //This variable will hold the probability that this attack will have on hitting the defending Pokemon.
    private final float probability;

    //This method creates new status attacks.
    public StatusAttack(String aName, PokemonType aType, Status aStatus, float aProbability) {
        name = aName;
        type = aType;
        status = aStatus;
        if (aProbability < 0 || aProbability > 1)
        {
            throw new IllegalArgumentException("Probability must be between 0 (0%) and 1 (100%).");
        }
        probability = aProbability;
    }

    //This method will get the name.
    public String getName()
    {
        return name;
    }

    //This method will get the Pokemon type.
    public PokemonType getType()
    {
        return type;
    }

    //This method will be used to attack the defending Pokemon. it has two parameters pokemon target which is the defender and pokemon shooter which is the attacker.
    public void useAttack(Pokemon_Abilities target, Pokemon_Abilities shooter, PlayerTwo playerTwo, Battle battle)
    {
        //The boolean succeeds will calculate the success of the attack hitting.
        final boolean succeeds = calculateSuccess();
        //If it succeeds and the Pokemon status is ASLEEP it will output that the pokemon is already asleep.
        if (succeeds) {
            if (target.getCurrentStatus() == Status.ASLEEP)
            {
                playerTwo.TextBox.remove(battle.BattleText);
                playerTwo.TextBox.repaint();
                battle.BattleText.setText(target.getNickname() + " is already " + status.toString().toLowerCase() + "!");
                playerTwo.TextBox.add(battle.BattleText);
            }
            //If it succeeds and the Pokemon status is something else the output will be that the defending pokemon is now asleep.
            else
            {
                target.setCurrentStatus(status);
                playerTwo.TextBox.remove(battle.BattleText);
                playerTwo.TextBox.repaint();
                battle.BattleText.setText(target.getNickname() + " is now " + status.toString().toLowerCase() + "!");
                playerTwo.TextBox.add(battle.BattleText);
            }
        }
        //If the attack fails the game will output that the attack failed.
        else
        {
            playerTwo.TextBox.remove(battle.BattleText);
            playerTwo.TextBox.repaint();
            battle.BattleText.setText("<html>The attack failed!<html>");
            playerTwo.TextBox.add(battle.BattleText);
        }
    }
    //This method calculates the success of an attack.
    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }
}
