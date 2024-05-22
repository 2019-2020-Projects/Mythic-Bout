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

    //This variable wll gold the attack Monster type.
    private final MonsterType type;

    //This variable will hold the amount of damage that the attacker will inflict to the defending Monster.
    private final int damage;

    //This variable will hold the status that this attack will inflict.
    private final Status status;

    //This variable will hold the probability that this attack will have on hitting the defending Monster.
    private final float probability;

    //This method will create new status and damage attacks.
    public Stat_Dam(String aName, MonsterType aType, Status aStatus ,float aProbability,int aDamage)
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

    //This method will get the Monster type.
    public MonsterType getType()
    {
        return type;
    }

    //This method will be used to attack the defending Monster. it has two parameters monster target which is the defender and monster shooter which is the attacker.
    public void useAttack(Monster_Abilities target,Monster_Abilities shooter)
    {
        //This integer will calculate the damage of an attack.
        final int damage = calculateDamage(target.getType());
        //This will deal the damage to the defending Monster.
        target.doDamage(damage);
        System.out.println(target.getNickname() + " took " + damage + " damage!");

        //The boolean succeeds will calculate the success of the attack hitting.
        final boolean succeeds = calculateSuccess();
        //If it succeeds the Monster is now affected by the attacks status.
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
    private int calculateDamage(final MonsterType defenderType)
    {
        // defender is vulnerable - double damage
        if ((type == MonsterType.FIRE && defenderType == MonsterType.GRASS) ||
                (type == MonsterType.WATER && defenderType == MonsterType.FIRE) ||
                (type == MonsterType.GRASS && defenderType == MonsterType.WATER))
        {
            return damage * 2;
        }

        // defender is resistant - half damage
        if ((type == MonsterType.GRASS && defenderType == MonsterType.FIRE) ||
                (type == MonsterType.FIRE && defenderType == MonsterType.WATER) ||
                (type == MonsterType.WATER && defenderType == MonsterType.GRASS))
        {
            return damage / 2;
        }

        // no weaknesses - normal damage
        return damage;
    }
}
