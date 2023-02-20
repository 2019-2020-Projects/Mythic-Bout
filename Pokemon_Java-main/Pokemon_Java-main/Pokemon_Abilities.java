/**
 * The Pokemon_Abilities subclass
 * creates Pokemon with abilities.
 * @author Wilson Neira
 * @version 1.0
 * @since 11/29/2019
 */
import java.util.List;
public class Pokemon_Abilities extends Pokemon
{
    public String ability;

    public Pokemon_Abilities(final String species, final PokemonType type,final PokemonType type2, final int maxHP, final List<Attack> attacks,final String ability)
    {
        super(species, type,type2,maxHP,attacks);
        this.ability = ability;
    }
    //This method is used to get the ability name of a Pokemon.
    public String getAbility() {return ability;}
}
