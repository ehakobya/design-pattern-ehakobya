package mediator;

import builder.Trainer;
import decorator.CodeAMon;

import java.util.ArrayList;

public interface Mediator {

	public ArrayList<Trainer> getTrainers();

	public void registerTrainer(Trainer t);

	public void unregisterTrainer(Trainer t);

	public void heal(ArrayList<Trainer> trainers);

	public void beginBattle(Trainer t1, Trainer t2);

	public void endBattle(Trainer t1, Trainer t2);

	public void changeWeather();

	public void attack(CodeAMon c1, CodeAMon c2);
}
