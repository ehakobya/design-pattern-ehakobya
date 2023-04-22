package decorator;

/**
 * Interface for a basic code-a-mon
 *
 * @author Edgar Hakobyan
 * @version 1.0
 * created on 04/20/2023
 * updated on _
 */
public interface CodeAMon {

	double currentHP = 0;
	double maxHP = 0;
	double xp = 0;
	double levelUpThreshold = 0;
	int level = 01;
	double attack = 0;
	double bonus = 0;
	boolean isDead = false;
	String type = "NONE";
	enum weather { CLEAR, RAIN, WINDY, SUNNY; }

	public void attack(CodeAMon opponent);
	public void takeDamage(CodeAMon opponent);
	public void heal();
	public void levelUp();
	public double getCurrentHP();
	public double getMaxHP();
	public double getXp();
	public double getAttack();
	public int getLevel();
	public double getLevelUpThreshold();
	public double getBonus();
	public boolean isDead();
	public String getType();
	public void setIsDead(Boolean bool);
	public void setCurrentHP(double hp);
	public void addXP(double xp);
	public void setType(String type);
	public void setBonus(double bonus);
}
