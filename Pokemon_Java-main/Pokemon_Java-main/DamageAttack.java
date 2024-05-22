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

    //This variable wll gold the attack Monster type.
    private final MonsterType type;

    //This variable will hold the amount of damage that the attacker will inflict to the defending Monster.
    public int damage;

    //This variable will hold the probability that this attack will have on hitting the defending Monster.
    private final float probability;

    //This method will create new damage attacks.
    public DamageAttack(String aName, MonsterType aType, int aDamage, float aProbability)
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

    //This method will get the Monster type.
    public MonsterType getType()
    {
        return type;
    }

    //This method will be used to attack the defending Monster. it has two parameters monster target which is the defender and monster shooter which is the attacker.
    public void useAttack(Monster_Abilities target,Monster_Abilities shooter, PlayerTwo playerTwo, Battle battle)
    {
        //This integer will calculate the damage of an attack.
        final int damage = calculateDamage(target.getType(),target.getType2(),shooter);

        //This boolean will calculate te success of attack hitting.
        final boolean succeeds = calculateSuccess();
        //If it succeeds the attack will deal damage to the defending Monster.
        if (succeeds) {
            //This will deal the damage to the defending Monster.
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

    //This method will calculate the amount of damage dealt to the defending monster.
    private int calculateDamage(final MonsterType defenderType,final MonsterType defenderType2,final Monster_Abilities attacker)
    {


        if(defenderType==defenderType2) {
            if ((type == MonsterType.FIRE && defenderType == MonsterType.GRASS) ||
                    (type == MonsterType.WATER && defenderType == MonsterType.FIRE) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.FLYING && defenderType == MonsterType.GRASS)) {
                // defender is vulnerable and attacker has ability Blaze - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==MonsterType.FIRE){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable and attacker has ability Overgrow - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==MonsterType.GRASS){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable and attacker has ability Torrent - triple damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==MonsterType.WATER){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable - double damage
                return damage * 2;
            }


            if ((type == MonsterType.GRASS && defenderType == MonsterType.FIRE) ||
                    (type == MonsterType.FIRE && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.WATER && defenderType == MonsterType.GRASS) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.FLYING) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.GRASS)||
                    (type == MonsterType.GRASS && defenderType == MonsterType.POISON)||
                    (type == MonsterType.WATER && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.FIRE && defenderType == MonsterType.FIRE)) {

                // defender is resistant and attacker has ability Blaze - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Blaze")) {
                        if(type==MonsterType.FIRE){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant and attacker has ability Overgrow - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==MonsterType.GRASS){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant and attacker has ability Torrent - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==MonsterType.WATER){
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
            if ((type == MonsterType.FIRE && defenderType == MonsterType.GRASS) ||
                    (type == MonsterType.WATER && defenderType == MonsterType.FIRE) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.FLYING && defenderType == MonsterType.GRASS)) {

                if ((type == MonsterType.FIRE && defenderType2 == MonsterType.GRASS) ||
                        (type == MonsterType.WATER && defenderType2 == MonsterType.FIRE) ||
                        (type == MonsterType.GRASS && defenderType2 == MonsterType.WATER) ||
                        (type == MonsterType.FLYING && defenderType == MonsterType.GRASS)) {

                    // defender is vulnerable on two types and attacker has ability Blaze - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==MonsterType.FIRE){
                                return damage*6;
                            }
                        }
                    }

                    // defender is vulnerable on two types and attacker has ability Overgrow - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==MonsterType.GRASS){
                                return damage*6;
                            }
                        }
                    }

                    // defender is vulnerable on two types and attacker has ability Torrent - times six damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==MonsterType.WATER){
                                return damage*6;
                            }
                        }
                    }
                    // defender is vulnerable on two types - times four damage
                    return damage * 4;
                }
                if ((type == MonsterType.GRASS && defenderType2 == MonsterType.FIRE) ||
                        (type == MonsterType.FIRE && defenderType2 == MonsterType.WATER) ||
                        (type == MonsterType.WATER && defenderType2 == MonsterType.GRASS) ||
                        (type == MonsterType.GRASS && defenderType == MonsterType.FLYING) ||
                        (type == MonsterType.GRASS && defenderType == MonsterType.GRASS)||
                        (type == MonsterType.GRASS && defenderType == MonsterType.POISON)||
                        (type == MonsterType.WATER && defenderType == MonsterType.WATER) ||
                        (type == MonsterType.FIRE && defenderType == MonsterType.FIRE)) {

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Blaze - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==MonsterType.FIRE){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Overgrow - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==MonsterType.GRASS){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is vulnerable on one type and resistant on the other and attacker has ability Torrent - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==MonsterType.WATER){
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
                        if(type==MonsterType.FIRE){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable on one type and attacker has ability Overgrow - times 3 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==MonsterType.GRASS){
                            return damage*3;
                        }
                    }
                }

                // defender is vulnerable on one type and attacker has ability Torrent - times 3 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==MonsterType.WATER){
                            return damage*3;
                        }
                    }
                }
                // defender is vulnerable on one type - times 2 damage
                return damage*2;

            }

            if ((type == MonsterType.GRASS && defenderType == MonsterType.FIRE) ||
                    (type == MonsterType.FIRE && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.WATER && defenderType == MonsterType.GRASS) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.FLYING) ||
                    (type == MonsterType.GRASS && defenderType == MonsterType.GRASS)||
                    (type == MonsterType.GRASS && defenderType == MonsterType.POISON)||
                    (type == MonsterType.WATER && defenderType == MonsterType.WATER) ||
                    (type == MonsterType.FIRE && defenderType == MonsterType.FIRE) ){

                // defender is resistant on one type and vulnerable on the other and attacker has ability Blaze - times 3/2 damage
                if ((type == MonsterType.FIRE && defenderType2 == MonsterType.GRASS) ||
                        (type == MonsterType.WATER && defenderType2 == MonsterType.FIRE) ||
                        (type == MonsterType.GRASS && defenderType2 == MonsterType.WATER) ||
                        (type == MonsterType.FLYING && defenderType2 == MonsterType.GRASS)) {
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==MonsterType.FIRE){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other and attacker has ability Overgrow - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==MonsterType.GRASS){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other and attacker has ability Torrent - times 3/2 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==MonsterType.WATER){
                                return damage*3/2;
                            }
                        }
                    }

                    // defender is resistant on one type and vulnerable on the other - times damage
                    return damage;
                }
                if ((type == MonsterType.GRASS && defenderType2 == MonsterType.FIRE) ||
                        (type == MonsterType.FIRE && defenderType2 == MonsterType.WATER) ||
                        (type == MonsterType.WATER && defenderType2 == MonsterType.GRASS) ||
                        (type == MonsterType.GRASS && defenderType == MonsterType.FLYING) ||
                        (type == MonsterType.GRASS && defenderType == MonsterType.GRASS)||
                        (type == MonsterType.GRASS && defenderType == MonsterType.POISON)||
                        (type == MonsterType.WATER && defenderType == MonsterType.WATER) ||
                        (type == MonsterType.FIRE && defenderType == MonsterType.FIRE)) {

                    // defender is resistant on two types and attacker has ability Blaze - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Blaze")) {
                            if(type==MonsterType.FIRE){
                                return damage*3/8;
                            }
                        }
                    }

                    // defender is resistant on two types and attacker has ability Overgrow - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Overgrow")) {
                            if(type==MonsterType.GRASS){
                                return damage*3/8;
                            }
                        }
                    }

                    // defender is resistant on two types and attacker has ability Torrent - times 3/8 damage
                    if(attacker.hasHealth1_3()) {
                        if (attacker.getAbility().equals("Torrent")) {
                            if(type==MonsterType.WATER){
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
                        if(type==MonsterType.FIRE){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant on one type and attacker has ability Overgrow - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Overgrow")) {
                        if(type==MonsterType.GRASS){
                            return damage*3/4;
                        }
                    }
                }

                // defender is resistant on one type and attacker has ability Torrent - times 3/4 damage
                if(attacker.hasHealth1_3()) {
                    if (attacker.getAbility().equals("Torrent")) {
                        if(type==MonsterType.WATER){
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
                if(type==MonsterType.FIRE){
                    return damage*3/2;
                }
            }
        }

        // attacker has ability Overgrow - times 3/2 damage
        if(attacker.hasHealth1_3()) {
            if (attacker.getAbility().equals("Overgrow")) {
                if(type==MonsterType.GRASS){
                    return damage*3/2;
                }
            }
        }

        // attacker has ability Torrent - times 3/2 damage
        if(attacker.hasHealth1_3()) {
            if (attacker.getAbility().equals("Torrent")) {
                if(type==MonsterType.WATER){
                    return damage*3/2;
                }
            }
        }

        // no weaknesses - normal damage
        return damage;
    }
}
