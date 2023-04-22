package decorator;

import decorator.CodeAMon;

public class WaterMon extends CodeAMonDecorator {

	public WaterMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from WaterMon const\n");
	}

	public void setBonus(CodeAMon opponent) {
		if (opponent.getType().equals("FIRE")) {
			super.setBonus(20);
		} else {
			super.setBonus(0);
		}
	}
}
