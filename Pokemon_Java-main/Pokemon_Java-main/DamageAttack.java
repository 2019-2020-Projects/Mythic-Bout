import java.util.Random;
/**
 * The DamageAttack class creates
 * Attacks.
 * @author Wilson Neira
 * @version 1.8
 * @since 11/29/2023
 */

public class DamageAttack implements Attack {

    //This variable will hold the attack name.
    private final String name;

    //This variable wll gold the attack Pokemon type.
    private final PokemonType type;

    //This variable will hold the amount of damage that the attacker will inflict to the defending Pokemon.
    public int damage;

    //This variable will hold the probability that this attack will have on hitting the defending Pokemon.
    private final float probability;

    //This method will create new damage attacks.
    public DamageAttack(String aName, PokemonType aType, int aDamage, float aProbability)
    {
        this.name = aName;
        this.type = aType;
        this.damage = aDamage;
        if (aProbability < 0 || aProbability > 1)
        {
            throw new IllegalArgumentException("Probability must be between 0 (0%) and 1 (100%).");
        }
        this.probability = aProbability;
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
    public void useAttack(Pokemon_Abilities target,Pokemon_Abilities shooter, PlayerTwo playerTwo, Battle battle)
    {
        //This integer will calculate the damage of an attack.
        final int damage = calculateDamage(target.getType(),target.getType2(),shooter);

        //This boolean will calculate te success of attack hitting.
        final boolean succeeds = calculateSuccess();
        //If it succeeds the attack will deal damage to the defending Pokemon.
        if (succeeds) {
            //This will deal the damage to the defending Pokemon.
            target.doDamage(damage);
            playerTwo.TextBox.remove(battle.BattleText);
            playerTwo.TextBox.repaint();
            battle.BattleText.setText("<html>"+target.getNickname() + " took " + damage + " damage!<html>");
            playerTwo.TextBox.add(battle.BattleText);
        }

        //Else if it fails the game will output that the attack has failed.
        else
        {
            playerTwo.TextBox.remove(battle.BattleText);
            playerTwo.TextBox.repaint();
            battle.BattleText.setText("<html>The attack failed!<html>");
            playerTwo.TextBox.add(battle.BattleText);
        }
    }
    //This method will calculate the success of an attack.
    private boolean calculateSuccess()
    {
        float random = new Random().nextFloat();
        return (random < probability);
    }

    //This method will calculate the amount of damage dealt to the defending pokemon.
    private int calculateDamage(final PokemonType defenderType,final PokemonType defenderType2,final Pokemon_Abilities attacker)
    {


        if(defenderType==defenderType2) {
            if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                    (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.FLYING && defenderType == PokemonType.GRASS)) {
                // defender is vulnerable and attacker has ability Blaze - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==PokemonType.FIRE){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable and attacker has ability Overgrow - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==PokemonType.GRASS){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable and attacker has ability Torrent - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==PokemonType.WATER){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable - double damage
                return damage * 2;
            }


            if ((type == PokemonType.GRASS && defenderType == PokemonType.FIRE) ||
                    (type == PokemonType.FIRE && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.WATER && defenderType == PokemonType.GRASS) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.FLYING) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.GRASS)||
                    (type == PokemonType.GRASS && defenderType == PokemonType.POISON)||
                    (type == PokemonType.WATER && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.FIRE && defenderType == PokemonType.FIRE)) {

                // defender is resistant and attacker has ability Blaze - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==PokemonType.FIRE){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant and attacker has ability Overgrow - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==PokemonType.GRASS){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant and attacker has ability Torrent - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==PokemonType.WATER){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant - half damage
                return damage / 2;
            }
        }
        if(defenderType!=defenderType2)
        {
            if ((type == PokemonType.FIRE && defenderType == PokemonType.GRASS) ||
                    (type == PokemonType.WATER && defenderType == PokemonType.FIRE) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.FLYING && defenderType == PokemonType.GRASS)) {

                if ((type == PokemonType.FIRE && defenderType2 == PokemonType.GRASS) ||
                        (type == PokemonType.WATER && defenderType2 == PokemonType.FIRE) ||
                        (type == PokemonType.GRASS && defenderType2 == PokemonType.WATER) ||
                        (type == PokemonType.FLYING && defenderType == PokemonType.GRASS)) {

                    // defender is vulnerable on two types and attacker has ability Blaze - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==PokemonType.FIRE){
                                return damage*6;
                            }
                        }
                    }

                    // defender is vulnerable on two types and attacker has ability Overgrow - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==PokemonType.GRASS){
                                return damage*6;
                            }
                        }
                    }

                    // defender is vulnerable on two types and attacker has ability Torrent - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==PokemonType.WATER){
                                return damage*6;
                            }
                        }
                    }
                    // defender is vulnerable on two types - times four damage
                    return damage * 4;
                }
                if ((type == PokemonType.GRASS && defenderType2 == PokemonType.FIRE) ||
                        (type == PokemonType.FIRE && defenderType2 == PokemonType.WATER) ||
                        (type == PokemonType.WATER && defenderType2 == PokemonType.GRASS) ||
                        (type == PokemonType.GRASS && defenderType == PokemonType.FLYING) ||
                        (type == PokemonType.GRASS && defenderType == PokemonType.GRASS)||
                        (type == PokemonType.GRASS && defenderType == PokemonType.POISON)||
                        (type == PokemonType.WATER && defenderType == PokemonType.WATER) ||
                        (type == PokemonType.FIRE && defenderType == PokemonType.FIRE)) {

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Blaze - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==PokemonType.FIRE){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Overgrow - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==PokemonType.GRASS){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Torrent - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==PokemonType.WATER){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is vulnerable on one type and resistant on the other - times damage
                    return damage;
                }

                // defender is vulnerable on one type attacker has ability Blaze - times 3 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==PokemonType.FIRE){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable on one type and attacker has ability Overgrow - times 3 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==PokemonType.GRASS){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable on one type and attacker has ability Torrent - times 3 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==PokemonType.WATER){
                            return damage*3;
                        }
                    }
                }
                // defender is vulnerable on one type - times 2 damage
                return damage*2;

            }

            if ((type == PokemonType.GRASS && defenderType == PokemonType.FIRE) ||
                    (type == PokemonType.FIRE && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.WATER && defenderType == PokemonType.GRASS) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.FLYING) ||
                    (type == PokemonType.GRASS && defenderType == PokemonType.GRASS)||
                    (type == PokemonType.GRASS && defenderType == PokemonType.POISON)||
                    (type == PokemonType.WATER && defenderType == PokemonType.WATER) ||
                    (type == PokemonType.FIRE && defenderType == PokemonType.FIRE) ){

                // defender is resistant on one type and vulnerable on the other and attacker has ability Blaze - times 3/2 damage
                if ((type == PokemonType.FIRE && defenderType2 == PokemonType.GRASS) ||
                        (type == PokemonType.WATER && defenderType2 == PokemonType.FIRE) ||
                        (type == PokemonType.GRASS && defenderType2 == PokemonType.WATER) ||
                        (type == PokemonType.FLYING && defenderType2 == PokemonType.GRASS)) {
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==PokemonType.FIRE){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other and attacker has ability Overgrow - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==PokemonType.GRASS){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other and attacker has ability Torrent - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==PokemonType.WATER){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other - times damage
                    return damage;
                }
                if ((type == PokemonType.GRASS && defenderType2 == PokemonType.FIRE) ||
                        (type == PokemonType.FIRE && defenderType2 == PokemonType.WATER) ||
                        (type == PokemonType.WATER && defenderType2 == PokemonType.GRASS) ||
                        (type == PokemonType.GRASS && defenderType == PokemonType.FLYING) ||
                        (type == PokemonType.GRASS && defenderType == PokemonType.GRASS)||
                        (type == PokemonType.GRASS && defenderType == PokemonType.POISON)||
                        (type == PokemonType.WATER && defenderType == PokemonType.WATER) ||
                        (type == PokemonType.FIRE && defenderType == PokemonType.FIRE)) {

                    // defender is resistant on two types and attacker has ability Blaze - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==PokemonType.FIRE){
                                return damage*3/8;
                            }
                        }
                    }

                    // defender is resistant on two types and attacker has ability Overgrow - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==PokemonType.GRASS){
                                return damage*3/8;
                            }
                        }
                    }

                    // defender is resistant on two types and attacker has ability Torrent - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==PokemonType.WATER){
                                return damage*3/8;
                            }
                        }
                    }

                    // defender is resistant on two types - times 1/4 damage
                    return damage / 4;
                }

                // defender is resistant on one type and attacker has ability Blaze - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==PokemonType.FIRE){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant on one type and attacker has ability Overgrow - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==PokemonType.GRASS){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant on one type and attacker has ability Torrent - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==PokemonType.WATER){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant on one type - times 1/2 damage
                return damage/2;
            }
        }

        // attacker has ability Blaze - times 3/2 damage
        if(attacker.hasHealth1_3()) {
            if (attacker.getAbility().equals("Blaze")) {
                if(type==PokemonType.FIRE){
                    return damage*3/2;
                }
            }
        }

        // attacker has ability Overgrow - times 3/2 damage
        if(attacker.hasHealth1_3()) {
            if (attacker.getAbility().equals("Overgrow")) {
                if(type==PokemonType.GRASS){
                    return damage*3/2;
                }
            }
        }

        // attacker has ability Torrent - times 3/2 damage
        if(attacker.hasHealth1_3()) {
            if (attacker.getAbility().equals("Torrent")) {
                if(type==PokemonType.WATER){
                    return damage*3/2;
                }
            }
        }

        // no weaknesses - normal damage
        return damage;
    }
}
