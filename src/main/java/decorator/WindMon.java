package decorator;

import decorator.CodeAMon;

public class WindMon extends CodeAMonDecorator {

	public WindMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from WindMon const\n");
	}

	public void setBonus(CodeAMon opponent) {
		if (opponent.getType().equals("EARTH")) {
			super.setBonus(20);
		} else {
			super.setBonus(0);
		}
	}
}
