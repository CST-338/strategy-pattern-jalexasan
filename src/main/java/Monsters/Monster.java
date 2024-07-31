package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Monster {
    private int hp;
    private int xp = 10;
    private int maxHP;
    private HashMap<String, Integer> items;

    int agility;
    int defense;
    int strength;
    Attack attack;




    //constructor
    public Monster (Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }

        return rand.nextInt(max-min) + min; //returns a random number between min and max inclusive
    }

    public int attackTarget(Monster monster) {
        int result = attack.attack(monster);
        takeDamage(result);

        return result;
    }

    public boolean takeDamage(int damage) {
        boolean notFainted = true;

        if (damage > 0) {
            hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage.");
        }

        if (hp <= 0) {
            notFainted = false;
            System.out.println("Oh no! The creature has perished! :(");
            System.out.println(this.toString());
        }

        return notFainted;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public int getAgility() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public Attack getAttack() {
        return attack;
    }

    public String toString() {
        return "hp = " + hp + "/" + maxHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && xp == monster.xp && maxHP == monster.maxHP && Objects.equals(items, monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, xp, maxHP, items);
    }
}