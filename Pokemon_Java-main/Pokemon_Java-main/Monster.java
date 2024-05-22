import java.util.List;
import java.util.Random;
/**
 * The Monster class creates methods that
 * lets us create Monster and get information
 * related to these Monster.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */

public class Monster
{
    private final String species;
    private final MonsterType type;
    private final MonsterType type2;
    public int maxHP;
    private final List<Attack> attacks;


    private String nickname;
    private int currentHP;
    private Status currentStatus;

    //This Monster method lets the user create a Monster.
    public Monster(final String species, final MonsterType type,final MonsterType type2, final int maxHP, final List<Attack> attacks)
    {
        this.species = species;
        this.maxHP = maxHP;
        this.type = type;
        this.type2 = type2;
        //This code is used to prevent the Monster from having no attacks or more than four attacks.
        if (attacks.size() < 1 || attacks.size() > 4)
        {
            throw new IllegalArgumentException("Monster must know between one and four attacks.");
        }
        this.attacks = attacks;

        this.nickname = species;
        this.currentHP = maxHP;
        this.currentStatus = Status.NORMAL;
    }


    //This method is used to get the first type of a Monster.
    public MonsterType getType()
    {
        return type;
    }

    //This method is used to get the second type of a Monster.
    public MonsterType getType2(){return type2;}

    //This method sets the name for a Monster.
    public void setNickname(final String nickname)
    {

        this.nickname = nickname;
    }
    //This method chooses an attack for the user based on the move button they clicked on.
    public Attack chooseAttack(Battle battle)
    {
        //In the battle class buttons get created based on how many attacks are chosen.
        //If one of those buttons are clicked BattleNumber will equal a certain number based on the attacks order.
        if(battle.Movenumber == 1)
        {
            return attacks.get(0);
        }
        if(battle.Movenumber == 2)
        {
            return attacks.get(1);
        }
        if(battle.Movenumber == 3)
        {
            return attacks.get(2);
        }
        if(battle.Movenumber == 4)
        {
            return attacks.get(3);
        }
      return(null);
    }
    //This method chooses a random attack from the attacks list of the cpu monster for the cpu to use.
    public Attack chooseAttack2()
    {
        // choose at random - monster are not very smart
        return attacks.get(new Random().nextInt(attacks.size()));
    }

    //This method gets all the attacks that a Monster has.
    public List<Attack> getAttacks()
    {
        return attacks;
    }

    //This method gets the Monster current name.
    public String getNickname()
    {
        return nickname;
    }

    //This method does damage to the Monster HP.
    public void doDamage(final int damage)
    {
        currentHP -= damage;
    }

    //This method gets the monster current HP.
    public int getCurrentHP()
    {
        return currentHP;
    }

    //This method check if the Monster has fainted.
    public boolean hasFainted()
    {
        return (currentHP <= 0);
    }

    //This method check if the Monster has less than 1/3 of its HP.
    public boolean hasHealth1_3(){return(currentHP<=maxHP/3);}

    //This method sets the status on a Monster depending on what status was inflicted to it.
    public void setCurrentStatus(Status status)
    {
        currentStatus = status;
    }

    //This methods gets the Monster current status.
    public Status getCurrentStatus()
    {
        return currentStatus;
    }

    //This methods compares the types of two monster to see if they are different or equal in typing.
    public void compareTypes(Monster target)
    {
        if (this.type == target.type)
        {
            System.out.println("These are the same type");
        }
        else
        {
            System.out.println("These are different types");
        }
    }
}
