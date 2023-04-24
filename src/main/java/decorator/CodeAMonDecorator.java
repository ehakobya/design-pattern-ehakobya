package decorator;

public class CodeAMonDecorator implements CodeAMon {

	protected CodeAMon codeAMon;

	public CodeAMonDecorator(CodeAMon c) {
		this.codeAMon = c;
	}

	@Override
	public void attack(CodeAMon opponent) { this.codeAMon.attack(opponent);}

	@Override
	public void takeDamage(CodeAMon opponent) { this.codeAMon.takeDamage(opponent); }

	@Override
	public double heal() { return this.codeAMon.heal(); }

	@Override
	public void levelUp() { this.codeAMon.levelUp(); }

	@Override
	public double getCurrentHP() { return this.codeAMon.getCurrentHP(); }

	@Override
	public String getName() {
		return this.codeAMon.getName();
	}

	@Override
	public void setName(String name) {
		this.codeAMon.setName(name);
	}

	@Override
	public double getMaxHP() { return this.codeAMon.getMaxHP(); }

	@Override
	public double getXp() { return this.codeAMon.getXp(); }

	@Override
	public double getAttack() { return this.codeAMon.getAttack(); }

	@Override
	public int getLevel() { return this.codeAMon.getLevel(); }

	@Override
	public double getLevelUpThreshold() { return this.codeAMon.getLevelUpThreshold(); }

	@Override
	public double getBonus() { return this.codeAMon.getBonus(); }

	@Override
	public boolean isDead() { return this.codeAMon.isDead(); }

	@Override
	public String getType() { return this.codeAMon.getType(); }

	@Override
	public void setIsDead(Boolean bool) { this.codeAMon.setIsDead(bool); }

	@Override
	public void setCurrentHP(double hp) { this.codeAMon.setCurrentHP(hp); }

	@Override
	public void addXP(double xp) { this.codeAMon.addXP(xp); }

	@Override
	public void setType(String type) { this.codeAMon.setType(type); }

	@Override
	public void setBonus(double bonus) { this.codeAMon.setBonus(bonus);
	}
}
