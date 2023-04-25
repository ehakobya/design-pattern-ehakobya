package factory;

import java.util.HashMap;

/**
 * Abstract class for a basic code-a-mon
 *
 * @author Edgar Hakobyan
 * @version 1.0
 * created on 04/20/2023
 * updated on _
 */
public abstract class CodeAMon {

	protected String name = "";
	private String type = "";
	private int maxHP = 100;
	private int HP = 100;
	private int xp = 0;
	private int level = 1;
//	private int levelUpThreshold = 0;
	private int attack = 0;
//	double bonus = 0;
//	boolean isDead = false;
//	enum weather { CLEAR, RAIN, WINDY, SUNNY; }
	private HashMap<String, Integer> abilities = new HashMap<>();


	public HashMap<String, Integer> getAbilities() {
		return abilities;
	}

	// Getter methods
	public String getName() { return this.name; }

	public String getType() { return this.type; }

	public int getMaxHP() { return this.maxHP; }

	public int getHP() { return this.HP; }

	public int getAttack() { return this.attack; }

	public int getXp() { return this.xp; }

//	public int getBonus() {
//		return this.bonus;
//	}

	public int getLevel() { return this.level; }

	public boolean getIsAlive() { return (this.HP > 0); }

	// Setter methods
	public void setType(String type) { this.type = type; }

	public void setLevel(int newLevel) { this.level = newLevel; }

	public void setXP(int xp) { this.xp = xp; }

	public void setName(String name) { this.name = name; }

	public void setHP(int hp) { this.HP = hp; }

	public void setAttack(int attack) { this.attack = attack; }

	public void setAbility(String abilityName, int abilityDamage) {
		this.abilities.put(abilityName, abilityDamage);
	}


	// Gameplay methods
//	public void attack(CodeAMon attacker, CodeAMon opponent, int weather);
	public abstract int attack(CodeAMon opponent, String weather);
	public abstract int takeDamage(int damage);
	public void heal() {
		if (HP < (maxHP / 2)) {
			this.setHP(HP + (HP / 2)); // heal by 50%
		}
	}

	public void levelUp() {
		if (this.getXp() >= 20) {
			// level up codeAMon
			this.setLevel(this.getLevel() + 1); // increment level
			this.setXP(0); // reset xp
			this.setHP(100); // reset HP to full
		}
	}
}
