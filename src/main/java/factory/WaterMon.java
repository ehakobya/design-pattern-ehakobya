package factory;

import java.util.Random;

public class WaterMon extends CodeAMon {

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

    public WaterMon() {
        setType("WATER");
        setAttack(25); // generate random attack from 15 to 20
        setAbility("WATER WAVE", 25);
        setName(codeAMonNameBucket[rnd.nextInt(19)]); // select random name from 0 to 20
    }

    /**
     * Method calculates the damage dealt by a CodeAMon when it attacks an opponent.
     * The damage calculation includes the CodeAMon's attack value, the power of the
     * "WATER WAVE" ability, and any weather or type bonuses or penalties.
     * @param opponent The CodeAMon that is being attacked.
     * @param weather The current weather condition in the battle.
     * @return An integer representing the amount of damage dealt by the attacking CodeAMon.
     */
    public int attack(CodeAMon opponent, String weather) {

        int dealtDamage = this.getAttack() + this.getAbilities().get("WATER WAVE");

        // bonus when weather is rainy
        if (weather == "RAINY") {
            dealtDamage += 5;
        }

        // bonus when opponent is fire
        if (opponent.getType().equals("FIRE")) {
            dealtDamage += 5;
        }

        // penalty if opponent is nature
        if (opponent.getType().equals("NATURE")) {
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
