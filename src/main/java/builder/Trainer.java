package builder;

import decorator.CodeAMon;
import factory.CodeAMonFactory;

import java.util.ArrayList;
import java.util.Random;

public class Trainer {

	private String trainerName;
	private int gold = 20; // starting amount for all trainers
	private int XP = 0;
	private ArrayList<CodeAMon> team;

	public String getTrainerName() {
		return trainerName;
	}

	public int getGold() {
		return gold;
	}

	public int getXP() {
		return XP;
	}

	public ArrayList<CodeAMon> getTeam() {
		return team;
	}


	public Trainer(TrainerBuilder builder) {
		this.trainerName = builder.trainerName;
	}

	public static class TrainerBuilder {
		private String trainerName;
		private int gold;
		private int XP;
		private ArrayList<CodeAMon> team;

		public TrainerBuilder(String name) {
			this.trainerName = name;
			this.team = new ArrayList<>();
			Random rnd = new Random();
			double rand = rnd.nextDouble() * 10;
			CodeAMon codeAMon = CodeAMonFactory.getType(rand);
			this.team.add(codeAMon);
		}

		public Trainer build() {
			return new Trainer(this);
		}
	}


}
