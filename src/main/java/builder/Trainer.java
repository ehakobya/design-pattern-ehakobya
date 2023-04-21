package builder;

import factory.CodeAMon;

import java.util.ArrayList;

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

	}

	public static class TrainerBuilder {
		private String trainerName;
		private int gold;
		private int XP;
		private ArrayList<CodeAMon> team;

		public TrainerBuilder(String name) {
			this.trainerName = name;
			this.team = new ArrayList<>();
//			this.team.add() USE FACTORY TO RANDOMLY CREATE A CODEAMON
		}

		public Trainer build() {
			return new Trainer(this);
		}
	}












}
