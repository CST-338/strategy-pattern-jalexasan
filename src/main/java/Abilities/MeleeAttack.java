package Abilities;

public class MeleeAttack implements Attack {
    Monster attacker;

    public MeleeAttack(Monster attacker) {
        this.attacker = attacker;
    }

    @Override
    public Integer attack(Monster target) { //current user attacks target passed in parameter
        String message = attacker + " uses a melee attack on " + target;
        System.out.println(message);

        return null;
    }

}
