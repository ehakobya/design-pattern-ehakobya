package decorator;

public class BasicCodeAMon implements CodeAMon {

	double currentHP = 100;
	String name;
	double maxHP = 100;
	double xp = 0;
	double levelUpThreshold = 20;
	int level = 1;
	double attack = 40;
	double bonus = 0;
	boolean isDead = false;
	String type = "Basic";

	@Override
	public void attack(CodeAMon opponent) {
		if (!this.isDead() && !opponent.isDead()) {
			if (this.getAttack() > opponent.getCurrentHP()) {
				opponent.setIsDead(true);
			} else {
				opponent.setCurrentHP(this.getAttack());
				opponent.addXP(this.getAttack());
			}
		}
	}

	@Override
	public void takeDamage(CodeAMon opponent) {
		if (!this.isDead() && !opponent.isDead()) {
			if (opponent.getAttack() > this.getCurrentHP()) {
				this.setIsDead(true);
			} else {
				this.setCurrentHP(opponent.getAttack());
				this.addXP(opponent.getAttack() / 2);
			}
		}
	}

	@Override
	public double heal() {
		double healAmount = 0;
		if (!this.isDead() && currentHP <= maxHP / 2) {
			double previousHP = currentHP;
			// if health below 50% then heal by 20%
			currentHP += currentHP * 0.2;
			healAmount = currentHP - previousHP;
		}
		return healAmount;
	}

	@Override
	public void levelUp() {
		if (!this.isDead() && this.xp >= levelUpThreshold) {
			levelUpThreshold += levelUpThreshold * 0.2; // increase threshold by 20%
			xp = 0; // reset xp
			level++; // increase level
		}
	}

	@Override
	public double getCurrentHP() {
		return this.currentHP;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getMaxHP() {
		return this.maxHP;
	}

	@Override
	public double getXp() {
		return this.xp;
	}

	@Override
	public double getAttack() {
		return this.attack + (this.attack * bonus / 100);
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public double getLevelUpThreshold() {
		return this.levelUpThreshold;
	}

	@Override
	public double getBonus() {
		return this.bonus;
	}

	@Override
	public boolean isDead() {
		return !(currentHP > 0);
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setIsDead(Boolean bool) {
		this.isDead = true;
	}

	@Override
	public void setCurrentHP(double hp) {
		this.currentHP = hp;
	}

	@Override
	public void addXP(double xp) {
		this.xp += xp;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
