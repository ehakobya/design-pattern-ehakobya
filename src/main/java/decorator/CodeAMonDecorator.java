//package decorator;
//
//import factory.CodeAMon;
//
//public class CodeAMonDecorator implements CodeAMon {
//
//	protected CodeAMon codeAMon;
//
//	public CodeAMonDecorator(CodeAMon c) {
//		this.codeAMon = c;
//	}
//
//	@Override
//	public void attack(CodeAMon opponent) { this.codeAMon.attack(opponent);}
//
//	@Override
//	public void takeDamage(CodeAMon opponent) { this.codeAMon.takeDamage(opponent); }
//
//	@Override
//	public double heal() { return this.codeAMon.heal(); }
//
//	@Override
//	public void levelUp() { this.codeAMon.levelUp(); }
//
//	@Override
//	public double getHP() { return this.codeAMon.getHP(); }
//
//	@Override
//	public String getName() {
//		return this.codeAMon.getName();
//	}
//
//	@Override
//	public void setName(String name) {
//		this.codeAMon.setName(name);
//	}
//
//	@Override
//	public double getMaxHP() { return this.codeAMon.getMaxHP(); }
//
//	@Override
//	public double getXp() { return this.codeAMon.getXp(); }
//
//	@Override
//	public double getAttack() { return this.codeAMon.getAttack(); }
//
//	@Override
//	public int getLevel() { return this.codeAMon.getLevel(); }
//
//	@Override
//	public double getLevelUpThreshold() { return this.codeAMon.getLevelUpThreshold(); }
//
//	@Override
//	public double getBonus() { return this.codeAMon.getBonus(); }
//
//	@Override
//	public boolean getIsAlive() { return this.codeAMon.getIsAlive(); }
//
//	@Override
//	public String getType() { return this.codeAMon.getType(); }
//
//	@Override
//	public void setIsAlive(Boolean bool) { this.codeAMon.setIsAlive(bool); }
//
//	@Override
//	public void setHP(double hp) { this.codeAMon.setHP(hp); }
//
//	@Override
//	public void setXP(double xp) { this.codeAMon.setXP(xp); }
//
//	@Override
//	public void setType(String type) { this.codeAMon.setType(type); }
//
//	@Override
//	public void setBonus(double bonus) { this.codeAMon.setBonus(bonus);
//	}
//}
