import java.util.Random;
/**
 * The Stat_Dam class creates
 * Status Attacks that produce damage.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */
public class Stat_Dam {

    //This variable will hold the attack name.
    private final String name;

    //This variable wll gold the attack Pokemon type.
    private final PokemonType type;

    //This variable will hold the amount of damage that the attacker will inflict to the defending Pokemon.
    private final int damage;

    //This variable will hold the status that this attack will inflict.
    private final Status status;

    //This variable will hold the probability that this attack will have on hitting the defending Pokemon.
    private final float probability;

    //This method will create new status and damage attacks.
    public Stat_Dam(String aName, PokemonType aType, Status aStatus ,float aProbability,int aDamage)
    {
        this.name = aName;
        this.type = aType;
        this.damage = aDamage;
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
    public void useAttack(Pokemon_Abilities target,Pokemon_Abilities shooter)
    {
        //This integer will calculate the damage of an attack.
        final int damage = calculateDamage(target.getType());
        //This will deal the damage to the defending Pokemon.
        target.doDamage(damage);
        System.out.println(target.getNickname() + " took " + damage + " damage!");

        //The boolean succeeds will calculate the success of the attack hitting.
        final boolean succeeds = calculateSuccess();
        //If it succeeds the Pokemon is now affected by the attacks status.
        if (succeeds)
        {
            target.setCurrentStatus(status);
            System.out.println(target.getNickname() + " is now " + status.toString().toLowerCase() + "!");
        }
        //If the attack fails the game will output that the attack failed.
        else
        {
            System.out.println("The attack failed!");
        }
    }

    //This method calculates the success of an attack.
    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }

    //This method will calculate the damage of an attack depending on its typing.
    private int calculateDamage(final PokemonType defenderType)
    {
        // defender is vulnerable - double damage
        if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.GRASS && defenderType == PokemonType.WATER))
        {
            return damage * 2;
        }

        // defender is resistant - half damage
        if ((type == PokemonType.GRASS && defenderType == PokemonType.FIRE) ||
                (type == PokemonType.FIRE && defenderType == PokemonType.WATER) ||
                (type == PokemonType.WATER && defenderType == PokemonType.GRASS))
        {
            return damage / 2;
        }

        // no weaknesses - normal damage
        return damage;
    }
}
