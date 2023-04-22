package decorator;

import decorator.CodeAMon;

public class WaterMon extends CodeAMonDecorator {

	public WaterMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from WaterMon const\n");
	}

	public void setBonus(CodeAMon opponent, weather wh) {
		int twoBool = 2;
		if (opponent.getType().equals("FIRE")) {
			super.setBonus(10);
			twoBool--;
		}
		if (wh.equals(weather.RAIN)) {
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
