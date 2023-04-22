package decorator;

import decorator.CodeAMon;

public class EarthMon extends CodeAMonDecorator {

	public EarthMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from EarthMon const\n");
	}

	public void setBonus(CodeAMon opponent) {
		if (opponent.getType().equals("WATER")) {
			super.setBonus(20);
		} else {
			super.setBonus(0);
		}
	}
}
