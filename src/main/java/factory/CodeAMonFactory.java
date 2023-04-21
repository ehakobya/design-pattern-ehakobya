package factory;

/**
 * Factory class for building Code A Mons
 *
 * @author Edgar Hakobyan
 * @version 1.0
 * created on 04/20/2023
 * updated on _
 */
public class CodeAMonFactory {

	/**
	 * Overloaded method for getting the type of the concrete class based on given information.
	 * Used for generating random code-a-mons.
	 * @param rnd random number from 0 to 10
	 * @return a random code-a-mon character
	 */
	public CodeAMon getType(int rnd) {
		// fire
		if (0 <= rnd && rnd < 2.5) {
			return new FireMon();
		}
		// earth
		else if (2.5 <= rnd && rnd < 5) {
			return new EarthMon();
		}
		// water
		else if (5 <= rnd && rnd < 7.5) {
			return new WaterMon();
		}
		// wind
		else if (7.5 <= rnd && rnd < 10) {
			return new WindMon();
		} else {
			return null;
		}
	}

	/**
	 * Overloaded Method for getting the type of the concrete class based on given information.
	 * @param charType type of the code-a-mon
	 * @return a random code-a-mon character
	 */
	public CodeAMon getType(String charType) {
		String type = charType.toUpperCase();
		// fire
		if (type.equals("FIRE")) {
			return new FireMon();
		}
		// earth
		else if (type.equals("EARTH")) {
			return new EarthMon();
		}
		// water
		else if (type.equals("WATER")) {
			return new WaterMon();
		}
		// wind
		else if (type.equals("WIND")) {
			return new WindMon();
		} else {
			return null;
		}
	}
}