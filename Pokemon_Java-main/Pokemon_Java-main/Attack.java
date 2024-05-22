/**
 * The Attack interface specifies
 *what the DamageAttack, Stat_Dam and
 * StatusAttack classes must do.
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */
public interface Attack
{

    public String getName();

    public MonsterType getType();


    public void useAttack(Monster_Abilities target,Monster_Abilities shooter, PlayerTwo playerTwo, Battle battle);

}
