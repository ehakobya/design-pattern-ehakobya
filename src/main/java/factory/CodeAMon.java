package factory;

import java.util.HashMap;

/**
 * Abstract class for a basic code-a-mon.
 * <p> This class represents a basic CodeAMon that has a name, type, maximum HP, current HP, XP,
 * level, attack power, and a set of abilities. It provides getter and setter methods for
 * these properties, as well as methods for gameplay, such as attacking, taking damage,
 * healing, and leveling up.
 * </p>
 *
 * @author Edgar Hakobyan
 * @version 1.0
 */
public abstract class CodeAMon {

    protected String name = "";
    private String type = "";
    private int maxHp = 100;
    private int hp = 100;
    private int xp = 0;
    private int level = 1;
    // private int levelUpThreshold = 0;
    private int attack = 0;
    // double bonus = 0;
    // boolean isDead = false;
    // enum weather { CLEAR, RAIN, WINDY, SUNNY; }
    private HashMap<String, Integer> abilities = new HashMap<>();


    /**
     * Returns the set of abilities of this CodeAMon.
     *
     * @return the abilities of this CodeAMon as a HashMap
     */
    public HashMap<String, Integer> getAbilities() {
        return abilities;
    }

    /**
     * Returns the name of this CodeAMon.
     *
     * @return the name of this CodeAMon
     */
    // Getter methods
    public String getName() {
        return this.name;
    }

    /**
     * Returns the type of this CodeAMon.
     *
     * @return the type of this CodeAMon
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the maximum HP of this CodeAMon.
     *
     * @return the maximum HP of this CodeAMon
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * Returns the current HP of this CodeAMon.
     *
     * @return the current HP of this CodeAMon
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Returns the attack power of this CodeAMon.
     *
     * @return the attack power of this CodeAMon
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Returns the XP of this CodeAMon.
     *
     * @return the XP of this CodeAMon
     */
    public int getXp() {
        return this.xp;
    }

    // public int getBonus() {
    // return this.bonus;
    // }

    /**
     * Returns the level of this CodeAMon.
     *
     * @return the level of this CodeAMon
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * Returns whether this CodeAMon is alive or not.
     *
     * @return true if this CodeAMon is alive, false otherwise
     */
    public boolean getIsAlive() {
        return (this.hp > 0);
    }


    // Setter methods

    /**
     * Sets the type of this CodeAMon.
     *
     * @param type the new type of this CodeAMon
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the level of this CodeAMon.
     *
     * @param newLevel the new level of this CodeAMon
     */
    public void setLevel(int newLevel) {
        this.level = newLevel;
    }

    /**
     * Sets the XP of this CodeAMon.
     *
     * @param xp the new XP of this CodeAMon
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * Sets the name of this CodeAMon.
     *
     * @param name the new name of this CodeAMon
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the HP of this CodeAMon.
     *
     * @param hp the new HP of this CodeAMon
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Sets the attack of this CodeAMon.
     *
     * @param attack the new attack of this CodeAMon
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Add new ability to this CodeAMon.
     *
     * @param abilityName the new ability of this CodeAMon
     */
    public void setAbility(String abilityName, int abilityDamage) {
        this.abilities.put(abilityName, abilityDamage);
    }


    // Gameplay methods
    // public void attack(CodeAMon attacker, CodeAMon opponent, int weather);
    public abstract int attack(CodeAMon opponent, String weather);

    public abstract int takeDamage(int damage);

    /**
     * This method heals a CodeAMon if its current health is less
     * than half of its maximum health. The CodeAMon's health is increased
     * by 50% of its current health.
     */
    public void heal() {
        if (hp < (maxHp / 2)) {
            this.setHp(hp + (hp / 2)); // heal by 50%
        }
    }

    /**
     * This method levels up a CodeAMon if its experience points reach 20 or more.
     * The CodeAMon's level is incremented by 1, its experience points are reset to 0,
     * and its health points are set to their maximum value (100).
     */
    public void levelUp() {
        if (this.getXp() >= 20) {
            // level up codeAMon
            this.setLevel(this.getLevel() + 1); // increment level
            this.setXp(0); // reset xp
            this.setHp(100); // reset HP to full
        }
    }
}
