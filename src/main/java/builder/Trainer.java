package builder;

import factory.CodeAMon;
import factory.CodeAMonFactory;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class representing a Trainer in the CodeAMon game.
 */
public class Trainer {

    private String trainerName;
    private int gold;
    private ArrayList<CodeAMon> team;

    /**
     * Gets the name of the trainer.
     *
     * @return the name of the trainer
     */
    public String getTrainerName() {
        return trainerName;
    }

    /**
     * Gets the amount of gold the trainer has.
     *
     * @return the amount of gold the trainer has
     */
    public int getGold() {
        return gold;
    }

    /**
     * Gets the trainer's team of CodeAMons.
     *
     * @return the trainer's team of CodeAMons
     */
    public ArrayList<CodeAMon> getTeam() {
        return team;
    }

    /**
     * Sets the amount of gold the trainer has.
     *
     * @param gold the amount of gold to set
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Constructs a new Trainer with the specified name and team.
     *
     * @param name the name of the trainer
     * @param team the trainer's team of CodeAMons
     */
    public Trainer(String name, ArrayList<CodeAMon> team) {
        this.team = team;
        this.trainerName = name;
    }


    /**
     * A Builder class for constructing new Trainer objects.
     */
    public static class TrainerBuilder {

        private CodeAMonFactory codeAMonFactory;

        /**
         * Constructs a new TrainerBuilder with the specified CodeAMonFactory.
         *
         * @param codeAMonFactory the CodeAMonFactory to use for creating CodeAMons
         */
        public TrainerBuilder(CodeAMonFactory codeAMonFactory) {
            this.codeAMonFactory = codeAMonFactory;
        }

        /**
         * Builds a new Trainer object with a randomly generated team and name.
         *
         * @return a new Trainer object
         */
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

            for (int i = 0; i < codeAMonCount; i++) {
                // CodeAMon codeAMon = CodeAMonFactory.getType(rand);
                team.add(codeAMonFactory.getType(rand));
            }

            int randomNameIndex = rnd.nextInt(14);
            return new Trainer(randomNamesArray[randomNameIndex], team);
        }
    }
}
