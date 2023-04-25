import builder.Trainer;
import factory.CodeAMon;
import factory.CodeAMonFactory;
import mediator.MediatorManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UnitTest {

    @Test
    public void testFireAttacksNature() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType("FIRE");
        CodeAMon natureCodeAMon = CodeAMonFactory.getType("NATURE");

        assertEquals(60, fireCodeAMon.attack(natureCodeAMon, "SUNNY"));
    }

    @Test
    public void testWaterAttacksFire() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType("WATER");

        assertEquals(60, waterCodeAMon.attack(fireCodeAMon, "RAINY"));
    }

    @Test
    public void testNatureAttacksWater() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(60, natureCodeAMon.attack(waterCodeAMon, "CLEAR"));
    }

    @Test
    public void testFireAttacksWater() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(45, fireCodeAMon.attack(waterCodeAMon, "RAINY"));
    }

    @Test
    public void testWaterAttacksNature() {
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);

        assertEquals(45, waterCodeAMon.attack(natureCodeAMon, "CLEAR"));
    }


    @Test
    public void testNatureAttacksFire() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);

        assertEquals(45, natureCodeAMon.attack(fireCodeAMon, "SUNNY"));
    }

    @Test
    public void testFireDamageSunny() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(50, fireCodeAMon.attack(waterCodeAMon, "SUNNY"));
    }

    @Test
    public void testFireDamageSunnyAndAgainstNature() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);

        assertEquals(60, fireCodeAMon.attack(natureCodeAMon, "SUNNY"));
    }

    @Test
    public void testWaterDamageRainy() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(50, waterCodeAMon.attack(natureCodeAMon, "RAINY"));
    }

    @Test
    public void testWaterDamageRainyAndAgainstFire() {
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(60, waterCodeAMon.attack(fireCodeAMon, "RAINY"));
    }

    @Test
    public void testNatureDamageClear() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        CodeAMon fireCodeAMon = CodeAMonFactory.getType(0);

        assertEquals(50, natureCodeAMon.attack(fireCodeAMon, "CLEAR"));
    }

    @Test
    public void testNatureDamageClearAndAgainstWater() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        CodeAMon waterCodeAMon = CodeAMonFactory.getType(2);

        assertEquals(60, natureCodeAMon.attack(waterCodeAMon, "CLEAR"));
    }


    @Test
    public void testLevelUp() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(1);
        natureCodeAMon.setXp(20);
        assertEquals(1, natureCodeAMon.getLevel());
        natureCodeAMon.levelUp();
        assertEquals(2, natureCodeAMon.getLevel());
    }

    @Test
    public void testHeal() {
        CodeAMon natureCodeAMon = CodeAMonFactory.getType(2);
        natureCodeAMon.setHp(40);
        assertEquals(40, natureCodeAMon.getHp());
        natureCodeAMon.heal();
        assertEquals(60, natureCodeAMon.getHp());
    }


    @Test
    public void testFireTakeNormalDamage() {
        CodeAMon fire = CodeAMonFactory.getType(0);
        int dmg = fire.takeDamage(25);

        assertEquals(75, dmg);
        assertEquals(75, fire.getHp());
    }

    @Test
    public void testWaterTakeNormalDamage() {
        CodeAMon water = CodeAMonFactory.getType(2);
        int dmg = water.takeDamage(25);

        assertEquals(75, dmg);
        assertEquals(75, water.getHp());
    }

    @Test
    public void testNatureTakeNormalDamage() {
        CodeAMon nature = CodeAMonFactory.getType(1);
        int dmg = nature.takeDamage(25);

        assertEquals(75, dmg);
        assertEquals(75, nature.getHp());
    }


    @Test
    public void testBattleFinish() {
        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        MediatorManager mediatorManager = new MediatorManager();
        Trainer t1 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        Trainer t2 = new Trainer.TrainerBuilder(codeAMonFactory).build();

        mediatorManager.registerTrainer(t1);
        mediatorManager.registerTrainer(t2);
        mediatorManager.battleFinish(t1, t2);
        assertEquals(100, t1.getGold());
    }


    @Test
    public void testMediatorHeal() {
        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        MediatorManager mediatorManager = new MediatorManager();
        Trainer t1 = new Trainer.TrainerBuilder(codeAMonFactory).build();

        mediatorManager.registerTrainer(t1);

        t1.getTeam().get(0).setHp(40);

        assertEquals(40, t1.getTeam().get(0).getHp());
        mediatorManager.heal(mediatorManager.getTrainers());
        assertEquals(60, t1.getTeam().get(0).getHp());
    }


    @Test
    public void testT1Win() {
        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        MediatorManager mediatorManager = new MediatorManager();
        Trainer t1 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        Trainer t2 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        t1.getTeam().clear();
        t2.getTeam().clear();

        t1.getTeam().add(CodeAMonFactory.getType(0));
        t2.getTeam().add(CodeAMonFactory.getType(1));
//	    CodeAMon c3 = codeAMonFactory.createCodeAMon(1);

        mediatorManager.registerTrainer(t1);
        mediatorManager.registerTrainer(t2);

        mediatorManager.battleInit(t1, t2);

        assertEquals(100, t1.getGold());
        assertTrue(t1.getTeam().get(0).getXp() > 0);
    }

    @Test
    public void testT2Win() {
        CodeAMonFactory codeAMonFactory = new CodeAMonFactory();
        MediatorManager mediatorManager = new MediatorManager();
        Trainer t1 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        Trainer t2 = new Trainer.TrainerBuilder(codeAMonFactory).build();
        t1.getTeam().clear();
        t2.getTeam().clear();

        t1.getTeam().add(CodeAMonFactory.getType("WATER"));
        t2.getTeam().add(CodeAMonFactory.getType("FIRE"));
//	    CodeAMon c3 = codeAMonFactory.createCodeAMon(1);

        mediatorManager.registerTrainer(t1);
        mediatorManager.registerTrainer(t2);

        mediatorManager.battleInit(t1, t2);

        assertEquals(100, t1.getGold());
        assertTrue(t1.getTeam().get(0).getXp() > 0);
    }
}
