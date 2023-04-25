import builder.Trainer;
import factory.CodeAMonFactory;
import mediator.MediatorManager;

public class Main {

    public static void main(String[] args) {

        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        MediatorManager mediatorManager = new MediatorManager();
        Trainer t1 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        Trainer t2 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        mediatorManager.registerTrainer(t1);
        mediatorManager.registerTrainer(t2);

        System.out.println("==== A new world has Begun! ====\n");

        for (int i = 0; i < mediatorManager.getCycles(); i++) {
            mediatorManager.changeWeather();
            System.out.printf("%nDay %d : Daytime : %s weather%n",
                    i + 1, mediatorManager.getWeather());
            mediatorManager.battleInit(t1, t2);
            mediatorManager.changeWeather();
            System.out.printf("%nDay %d : Nighttime : %s weather%n",
                    i + 1, mediatorManager.getWeather());
            mediatorManager.heal(mediatorManager.getTrainers());
        }
    }
}