package decorator;

import decorator.CodeAMon;

public class FireMon extends CodeAMonDecorator {

	public FireMon(CodeAMon c) {
		super(c);
		System.out.println("\n>>> DEBUG: Created basic code-a-mon from FireMon const\n");
	}

	public void setBonus(CodeAMon opponent) {
		if (opponent.getType().equals("NATURE")) {
			super.setBonus(20);
		} else {
			super.setBonus(0);
		}
	}
}
