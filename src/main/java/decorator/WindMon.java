package decorator;

public class WindMon extends CodeAMonDecorator {

	public WindMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from WindMon const\n");
	}

	public void setBonus(CodeAMon opponent, weather wh) {
		int twoBool = 2;
		if (opponent.getType().equals("EARTH")) {
			super.setBonus(10);
			twoBool--;
		}
		if (wh.equals(weather.WINDY)) {
			super.setBonus(20);
			twoBool--;
		}
		if (twoBool == 2) {
			// resets bonus to 0 if no bonus is applied
			// (to make sure each round has fresh bonus stat)
			super.setBonus(0);
		}
	}
}
