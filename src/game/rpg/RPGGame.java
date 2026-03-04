package game.rpg;

import java.util.Random;

// -------------------- ABSTRACT CLASS --------------------
abstract class Character {
    protected String name;
    protected int health;
    protected int strength;
    protected Random random = new Random();

    public Character(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
        System.out.println(name + " takes " + damage + " damage! Remaining HP: " + health);
    }

    public abstract void attack(Character opponent);

    public String getName() {
        return name;
    }
}

// -------------------- WARRIOR --------------------
class Warrior extends Character {

    public Warrior(String name) {
        super(name, 150, 20); // High health
    }

    @Override
    public void attack(Character opponent) {
        int damage = strength + random.nextInt(10);
        System.out.println(name + " swings a sword!");
        opponent.takeDamage(damage);
    }
}

// -------------------- MAGE --------------------
class Mage extends Character {

    public Mage(String name) {
        super(name, 80, 35); // Low health, high damage
    }

    @Override
    public void attack(Character opponent) {
        int damage = strength + random.nextInt(20);
        System.out.println(name + " casts a fireball!");
        opponent.takeDamage(damage);
    }
}

// -------------------- ROGUE --------------------
class Rogue extends Character {

    public Rogue(String name) {
        super(name, 100, 25);
    }

    @Override
    public void attack(Character opponent) {
        int damage = strength + random.nextInt(15);
        System.out.println(name + " strikes from the shadows!");
        opponent.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        // 30% dodge chance
        if (random.nextInt(100) < 30) {
            System.out.println(name + " dodged the attack!");
        } else {
            super.takeDamage(damage);
        }
    }
}

// -------------------- ARENA --------------------
class Arena {

    public static void battle(Character p1, Character p2) {
        System.out.println("\n Battle Start: " + p1.getName() + " vs " + p2.getName());

        int round = 1;

        while (p1.isAlive() && p2.isAlive()) {
            System.out.println("\n--- Round " + round + " ---");

            p1.attack(p2);
            if (!p2.isAlive()) break;

            p2.attack(p1);

            round++;
        }

        System.out.println("\n🏆 Winner: " +
                (p1.isAlive() ? p1.getName() : p2.getName()));
    }
}

// -------------------- MAIN --------------------
public class RPGGame {
    public static void main(String[] args) {

        Character player1 = new Warrior("Thor");
        Character player2 = new Mage("Merlin");

        // POLYMORPHISM HERE
        Arena.battle(player1, player2);
    }
}
