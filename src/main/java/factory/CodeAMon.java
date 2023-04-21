package factory;

/**
 * Interface for a basic code-a-mon
 *
 * @author Edgar Hakobyan
 * @version 1.0
 * created on 04/20/2023
 * updated on _
 */
public interface CodeAMon {

	public int attack(CodeAMon opponent);

	public int takeDamage(CodeAMon opponent);

	public void heal();

	public void levelUp();
}
