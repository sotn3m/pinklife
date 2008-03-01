package data;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean extends CreatureBeanRMS {
        
    public CreatureBean() throws Exception {
        if (!load()) {
            throw new Exception("Loading failed");
        }
    }

    public CreatureBean(String sName, int happiness, int illness, int size, int foodLevel, int waterLevel, int dirtyLevel, int messLevel, int playLevel, int tireLevel) {
        this.sName = sName;
        this.happiness = happiness;
        this.illness = illness;
        this.size = size;
        this.foodLevel = foodLevel;
        this.waterLevel = waterLevel;
        this.dirtyLevel = dirtyLevel;
        this.messLevel = messLevel;
        this.playLevel = playLevel;
        this.tireLevel = tireLevel;
    }


    public void eatOrange() {
        foodLevel += 10;
        dirtyLevel -= 1;
        messLevel -= 1;
        size += 1;
    }

    public void eatPineapple() {
        foodLevel += 20;
        dirtyLevel -= 3;
        messLevel -= 3;
        size += 2;
    }

    public void eatPeach() {
        foodLevel += 20;
        dirtyLevel -= 3;
        messLevel -= 3;
        size += 2;
    }

    public void eatIceCream() {
        foodLevel += 20;
        dirtyLevel -= 5;
        messLevel -= 5;
        size += 1;
    }

    public void drinkMilk() {
        waterLevel += 10;
        dirtyLevel -= 3;
        messLevel -= 1;
    }

    public void drinkOrangeJuice() {
        waterLevel += 20;
        dirtyLevel -= 4;
        messLevel -= 1;
    }

    public void drinkCocaCola() {
        waterLevel += 5;
        dirtyLevel -= 2;
        messLevel -= 1;
    }

    public void tidy() {
        messLevel -= 20;
        if (messLevel < 0) {
            messLevel = 0;
        }
    }

    public void washCreature() {
        dirtyLevel -= 20;
        if (dirtyLevel < 0) {
            dirtyLevel = 0;
        }
    }

    public void play() {
        playLevel += getRandomNumber(220, 320);
    }

    public void timePass() {
        foodLevel--;
        waterLevel -= 2;

        playLevel--;

        dirtyLevel += 4;
        messLevel += 6;

        tireLevel -= 2;
    }

    public void timePassWithoutLight() {
        foodLevel--;
        waterLevel -= 2;

        playLevel--;

        dirtyLevel += 6;
        messLevel += 8;

        tireLevel -= 2;
    }

    public void timePassWithSleep() {
        foodLevel -= 2;
        waterLevel -= 4;

        dirtyLevel += 1;

        tireLevel += 3;
    }

    public void timePassWithSleepWithoutLight() {
        foodLevel -= 2;
        waterLevel -= 4;

        dirtyLevel += 1;

        tireLevel += 1;
    }

    private void calculateHappiness() {

    }
}
