package builder;

import factory.CodeAMon;
import factory.CodeAMonFactory;

import java.util.ArrayList;
import java.util.Random;

public class Trainer {

	private String trainerName;
	private int gold;
	private ArrayList<CodeAMon> team;

	public String getTrainerName() {
		return trainerName;
	}

	public int getGold() {
		return gold;
	}

	public ArrayList<CodeAMon> getTeam() {
		return team;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public Trainer(String name, ArrayList<CodeAMon> team) {
		this.team = team;
		this.trainerName = name;
	}

	public static class TrainerBuilder {

		private CodeAMonFactory codeAMonFactory;

		public TrainerBuilder(CodeAMonFactory codeAMonFactory) {
			this.codeAMonFactory = codeAMonFactory;
		}

		public Trainer build() {

			String[] randomNamesArray = {
					"Elora Zhang",
					"Isaias White",
					"Layla Christensen",
					"Gregory Woods",
					"Reese Flowers",
					"Saul Livingston",
					"Milena Grant",
					"Leon Stein",
					"Leilany Bass",
					"Landen Alvarado",
					"Blake Torres",
					"Jayden Andrews",
					"Payton Davila",
					"Grey Cabrera",
					"Daleyza Fernandez"
			};

			ArrayList<CodeAMon> team = new ArrayList<>();
			Random rnd = new Random();
			int rand = rnd.nextInt(3);
			int codeAMonCount = rnd.nextInt(5) + 1;

			for (int i = 0; i < codeAMonCount; i ++) {
//				CodeAMon codeAMon = CodeAMonFactory.getType(rand);
				team.add(codeAMonFactory.getType(rand));
			}

			int randomNameIndex = rnd.nextInt(15);
			return new Trainer(randomNamesArray[randomNameIndex], team);
		}
	}
}
