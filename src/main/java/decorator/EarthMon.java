package decorator;

import decorator.CodeAMon;

public class EarthMon extends CodeAMonDecorator {

	public EarthMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from EarthMon const\n");
	}

	public void setBonus(CodeAMon opponent, weather e) {
		int twoBool = 2;
		if (opponent.getType().equals("WATER")) {
			super.setBonus(10);
			twoBool--;
		}
		if (e.equals(weather.CLEAR)) {
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
