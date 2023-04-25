package mediator;

import builder.Trainer;
import factory.CodeAMon;

import java.util.ArrayList;
import java.util.Random;

public class MediatorManager implements Mediator {

    private ArrayList<Trainer> trainers;
    private ArrayList<String> weather;
    String currentWeather;
    int weatherSelect;
    int cycles = 3;


    /**
     * Constructor for the MediatorManager class.
     * It initializes the list of trainers and the list of possible weather conditions,
     * and sets the current weather to the first element in the list.
     */
    public MediatorManager() {
        this.trainers = new ArrayList<>();
        this.weather = new ArrayList<>();
        weather.add("Warm");
        weather.add("Clear");
        weather.add("Rainy");
        currentWeather = weather.get(0);
        weatherSelect = 0;
    }


    // Getter Methods
    public String getWeather() {
        return currentWeather;
    }

    public int getCycles() {
        return cycles;
    }

    @Override
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }


    // Setter Methods
    public void setWeather(String currentWeather) {
        this.currentWeather = currentWeather;
    }

    public void registerTrainer(Trainer trainer) {
        trainers.add(trainer);
    }

    public void unregisterTrainer(Trainer trainer) {
        trainers.remove(trainer);
    }

    @Override
    public void changeWeather() {
        Random rnd = new Random();
        int choice = rnd.nextInt(4);
        switch (choice) {
            case 0: setWeather("CLEAR");
            case 1: setWeather("RAINY");
            case 2: setWeather("SUNNY");
            default: setWeather("CLEAR");
        }
    }


    // Gameplay methods

    /**
     * The MediatorManager class is responsible for managing and mediating
     * battles between two trainers. It contains methods to initialize a battle
     * between two trainers, execute rounds of attacks, and determine the winner of the battle.
     * @param t1 Trainer 1
     * @param t2 Trainer 2
     */
    public void battleInit(Trainer t1, Trainer t2) {

        int i;
        int j = 0;
        int currRound = 1;

        // while (t1.getTeam().get(i) != null &&
        // t2.getTeam().get(j) != null
        // && t1.getTeam().get(i).getIsAlive()
        // && t2.getTeam().get(j).getIsAlive()) {
        for (i = 0; i < t1.getTeam().size(); i++) {
            for (j = 0; j < t2.getTeam().size(); j++) {

                // both characters are alive
                if (t1.getTeam().get(i).getHp() > 0 && t2.getTeam().get(j).getHp() > 0) {
                    System.out.printf("%n> ==== Round %d begins! ====%n", currRound);
                    System.out.printf(">> Trainer %s summons %s AND ",
                            t1.getTrainerName(), t1.getTeam().get(i).getName());
                    System.out.printf("Trainer %s summons %s%n",
                            t2.getTrainerName(), t2.getTeam().get(j).getName());
                    System.out.println("> ==== FIGHT!!!! ====");

                    attack(t1.getTeam().get(i), t2.getTeam().get(j));
                    currRound++;
                }

                if (t1.getTeam().get(i).getHp() <= 0) {
                    System.out.printf(">>> Trainer %s lost a code-a-mon %n", t1.getTrainerName());
                    i++;
                } else if (t2.getTeam().get(j).getHp() <= 0) {
                    System.out.printf(">>> Trainer %s lost a code-a-mon %n", t2.getTrainerName());
                    j++;
                }
            }
        }

        if (i == t1.getTeam().size()) {
            System.out.printf("> Trainer %s lost the battle%n", t1.getTrainerName());
            battleFinish(t1, t2);
        } else if (j == t2.getTeam().size()) {
            System.out.printf("> Trainer %s lost the battle%n", t2.getTrainerName());
            battleFinish(t2, t1);
        }
    }


    /**
     * This method initiates the attack sequence between two CodeAMon objects.
     * It takes two CodeAMon objects and makes them battle until one of them loses all its HP.
     * The attack sequence alternates between both CodeAMon objects, starting with the first one.
     * If one CodeAMon dies, the other one wins and gains 10 experience points.
     * @param c1 The first CodeAMon object.
     * @param c2 The second CodeAMon object.
     */
    public void attack(CodeAMon c1, CodeAMon c2) {

        Random rand = new Random();
        int c1TakenDamage;
        int c2TakenDamage;

        while (c1.getHp() > 0 && c2.getHp() > 0) {

            int c1AttackDamage = c1.attack(c2, getWeather());
            c2TakenDamage = c2.takeDamage(c1AttackDamage);
            System.out.printf("> %s attacks %s and deals %d damage%n",
                    c1.getName(), c2.getName(), c2TakenDamage);

            // if code-a-mon 2 is still alive
            if (c2.getHp() > 0) {
                int c2AttackDamage = c2.attack(c1, getWeather());
                c1TakenDamage = c1.takeDamage(c2AttackDamage);
                System.out.printf("> %s attacks %s and deals %d damage%n",
                        c2.getName(), c2.getName(), c1TakenDamage);
            }
        }
        if (c1.getHp() <= 0) {
            System.out.printf("> %s died, %s wins the fight%n", c1.getName(), c2.getName());
            c2.setXp(c2.getXp() + 10);
            System.out.printf("> %s gained 10 experience%n", c2.getName());
        } else if (c2.getHp() <= 0) {
            System.out.printf("> %s died, %s wins the fight%n", c2.getName(), c1.getName());
            c1.setXp(c1.getXp() + 10);
            System.out.printf("> %s gained 10 experience%n", c1.getName());
        }
    }


    /**
     * Finish a battle by printing out the winner and awarding them with 100 gold coins.
     * @param winner the Trainer who won the battle
     * @param loser the Trainer who lost the battle
     */
    public void battleFinish(Trainer winner, Trainer loser) {
        System.out.printf("> %s Wins!!! %n", winner.getTrainerName());
        winner.setGold(winner.getGold() + 100);
    }

    /**
     * Method heals all the code-a-mons of all the trainers in the list by
     * calling the heal() method of each code-a-mon instance.
     * @param trainers List of trainers
     */
    public void heal(ArrayList<Trainer> trainers) {
        for (Trainer t : trainers) {
            for (CodeAMon c : t.getTeam()) {
                c.heal();
            }
            System.out.printf("> %s's code-a-mons are healing", t.getTrainerName());
        }
    }
}
