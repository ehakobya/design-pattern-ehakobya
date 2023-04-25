package factory;

import java.util.Random;

public class NatureMon extends CodeAMon {

    Random rnd = new Random();
    private String[] codeAMonNameBucket = {
            "Pikachu",
            "Charmander",
            "Squirtle",
            "Bulbasaur",
            "Eevee",
            "Jigglypuff",
            "Snorlax",
            "Mewtwo",
            "Dragonite",
            "Gyarados",
            "Lapras",
            "Magikarp",
            "Vaporeon",
            "Flareon",
            "Jolteon",
            "Articuno",
            "Zapdos",
            "Moltres",
            "Mew",
            "Ditto"
    };

    /**
     * Constructor for the NatureMon class, which initializes
     * a new FireMon object with a predetermined attack, ability, type,
     * and randomly selected name.
     */
    public NatureMon() {
        setType("NATURE");
        setAttack(25); // generate random attack from 15 to 20
        setAbility("EARTH SPIKES", 25);
        setName(codeAMonNameBucket[rnd.nextInt(19)]); // select random name from 0 to 20
    }

    /**
     * Method calculates the damage dealt by a CodeAMon when it attacks an opponent.
     * The damage calculation includes the CodeAMon's attack value, the power of the
     * "EARTH SPIKES" ability, and any weather or type bonuses or penalties.
     * @param opponent The CodeAMon that is being attacked.
     * @param weather The current weather condition in the battle.
     * @return An integer representing the amount of damage dealt by the attacking CodeAMon.
     */
    public int attack(CodeAMon opponent, String weather) {

        int dealtDamage = this.getAttack() + this.getAbilities().get("EARTH SPIKES");

        // bonus when weather is clear
        if (weather == "CLEAR") {
            dealtDamage += 5;
        }

        // bonus when opponent is water
        if (opponent.getType().equals("WATER")) {
            dealtDamage += 5;
        }

        // penalty if opponent is fire
        if (opponent.getType().equals("FIRE")) {
            dealtDamage -= 5;
        }

        return dealtDamage;
    }

    /**
     * Method calculates the amount of damage a CodeAMon
     * receives from an attack and updates the CodeAMon's HP accordingly.
     * @param damage An integer representing the amount of damage received by the CodeAMon.
     * @return An integer representing the CodeAMon's remaining HP after the attack.
     */
    public int takeDamage(int damage) {
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
        return newHp;
    }
}
