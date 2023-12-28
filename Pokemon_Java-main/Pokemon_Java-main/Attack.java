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

    public PokemonType getType();


    public void useAttack(Pokemon_Abilities target,Pokemon_Abilities shooter, PlayerTwo playerTwo, Battle battle);

}
