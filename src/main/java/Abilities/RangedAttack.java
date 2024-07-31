package Abilities;

public class RangedAttack implements Attack {
    Monster attacker;

    public RangedAttack(Monster attacker) {
        this.attacker = attacker;
    }

    @Override
    public Integer attack(Monster target) { //current user attacks target passed in parameter
        String message = attacker + " uses a ranged attack on " + target;
        System.out.println(message);

        return null;
    }

}
