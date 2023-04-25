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
		setAttack(rnd.nextInt(6) + 15); // generate random attack from 15 to 20
		setAbility("WATER WAVE", 25);
		setName(codeAMonNameBucket[rnd.nextInt(21)]); // select random name from 0 to 20
//		System.out.println("\n>>> DEBUG: Created basic code-a-mon from FireMon\n");
	}

	public int attack(CodeAMon opponent, String weather) {

		int abilityChance = rnd.nextInt(2);
		int dealtDamage;

		if (abilityChance == 0) {
			// chance that attacker attacked with basic attack and used an ability
			dealtDamage = this.getAttack() + this.getAbilities().get("WATER WAVE");
		} else {
			// chance that attacker used only basic attack
			dealtDamage = this.getAttack();
		}

		// bonus when weather is sunny
		if (weather == "RAINY") {
			dealtDamage += 5;
		}

		// bonus when opponent is nature
		if (opponent.getType().equals("FIRE")) {
			dealtDamage += 5;
		}

		// penalty if opponent is water
		if (opponent.getType().equals("NATURE")) {
			dealtDamage -= 5;
		}

		return dealtDamage;
	}

	public int takeDamage(int damage) {
		int newHP = this.getHP() - damage;
		this.setHP(newHP);
		return newHP;
	}
}
