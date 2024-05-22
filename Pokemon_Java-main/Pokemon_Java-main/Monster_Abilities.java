/**
 * The Monster_Abilities subclass
 * creates Monster with abilities.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */
import java.util.List;
public class Monster_Abilities extends Monster
{
    public String ability;

    public Monster_Abilities(final String species, final MonsterType type,final MonsterType type2, final int maxHP, final List<Attack> attacks,final String ability)
    {
        super(species, type,type2,maxHP,attacks);
        this.ability = ability;
    }
    //This method is used to get the ability name of a Monster.
    public String getAbility() {return ability;}
}
