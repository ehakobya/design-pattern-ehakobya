package factory;

/**
 * Factory class for building Code A Mons.
 *
 * @author Edgar Hakobyan
 * @version 1.0
 */
public class CodeAMonFactory {

    /**
     * Overloaded method for getting the type of the concrete class based on given information.
     * Used for generating random code-a-mons.
     *
     * @param rnd random number from 0 to 10
     * @return a random code-a-mon character
     */
    public static CodeAMon getType(int rnd) {
        // fire
        if (rnd == 0) {
            return new FireMon();
        }
        // earth
        else if (rnd == 1) {
            return new NatureMon();
        }
        // water
        else if (rnd == 2) {
            return new WaterMon();
        } else {
            throw new IllegalArgumentException("> Error: Cannot generate code-a-mon\n");
        }
    }

    /**
     * Overloaded Method for getting the type of the concrete class based on given information.
     *
     * @param charType type of the code-a-mon
     * @return a random code-a-mon character
     */
    public static CodeAMon getType(String charType) {
        String type = charType.toUpperCase();
        // fire
        if (type.equals("FIRE")) {
            return new FireMon();
        }
        // earth
        else if (type.equals("NATURE")) {
            return new NatureMon();
        }
        // water
        else if (type.equals("WATER")) {
            return new WaterMon();
        } else {
            throw new IllegalArgumentException("> Error: Cannot generate code-a-mon\n");
        }
    }
}
