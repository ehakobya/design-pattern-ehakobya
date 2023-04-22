package decorator;

import decorator.CodeAMon;

public class FireMon extends CodeAMonDecorator {

	public FireMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from FireMon const\n");
	}

	public void setBonus(CodeAMon opponent, weather wh) {
		int twoBool = 2;
		if (opponent.getType().equals("NATURE")) {
			super.setBonus(10);
			twoBool--;
		}
		if (wh.equals(weather.SUNNY)) {
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
