package data;

import javax.microedition.lcdui.Image;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean extends CreatureBeanRMS implements CreatureBehaviourInterface {

    private boolean sleeping;
    private String lastImageName = null;
    private String lastImageSize = null;
    private Image lastImage = null;

    //<editor-fold defaultstate="collapsed" desc="Contructors and debug method">
    public CreatureBean() throws Exception {
        setSleeping(false);
        if (!load()) {
            throw new Exception("Loading failed");
        }
    }

    public CreatureBean(String sName, int happiness, int illness, int size, int foodLevel, int waterLevel, int dirtyLevel, int messLevel, int playLevel, int tireLevel) {
        setSleeping(false);
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

    public void debug() {
        System.out.println("--------");
        System.out.println("Name: " + getName());
        System.out.println("");
        System.out.println("Food: " + getFoodLevel());
        System.out.println("Water: " + getWaterLevel());
        System.out.println("Dirty: " + getDirtyLevel());
        System.out.println("Mess: " + getMessLevel());
        System.out.println("Play: " + getPlayLevel());
        System.out.println("Tire: " + getTireLevel());
        System.out.println("");
        System.out.println("Happiness: " + getHappiness());
        System.out.println("Size: " + getSize());
        System.out.println("Illness: " + getIllness());
        System.out.println("--------");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="User actions...">
    public void eatOrange() {
        foodLevel += 100;
        dirtyLevel += 10;
        messLevel += 10;
        size += 1;
    }

    public void eatPineapple() {
        foodLevel += 200;
        dirtyLevel += 30;
        messLevel += 30;
        size += 2;
    }

    public void eatPeach() {
        foodLevel += 200;
        dirtyLevel += 30;
        messLevel += 30;
        size += 2;
    }

    public void eatIceCream() {
        foodLevel += 200;
        dirtyLevel += 50;
        messLevel += 50;
        size += 1;
        changeIllnessAtRandom1toN(300);
    }

    public void drinkMilk() {
        waterLevel += 200;
        dirtyLevel += 30;
        messLevel += 10;
        size += 3;
    }

    public void drinkOrangeJuice() {
        waterLevel += 180;
        foodLevel += 10;
        dirtyLevel += 40;
        messLevel += 10;
    }

    public void drinkCocaCola() {
        waterLevel += 200;
        dirtyLevel += 20;
        messLevel += 10;
        changeIllnessAtRandom1toN(300);
    }

    public void tidy() {
        messLevel = 0;
    }

    public void washCreature() {
        dirtyLevel = 0;
    }

    public void play() {
        messLevel += getRandomNumber(5, 30);
        playLevel += getRandomNumber(220, 320);
    }

    public void cure() {
        setIllness(0);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Time passing...">
    public void timePass() {
        foodLevel--;
        waterLevel -= 2;

        playLevel--;

        dirtyLevel += 4;
        messLevel += 6;

        tireLevel -= 2;
        changeIllnessAtRandom1toN(1000);
        limitValues();
    }

    public void timePassWithoutLight() {
        foodLevel--;
        waterLevel -= getRandomNumber(1, 3);

        playLevel--;

        dirtyLevel += 6;
        messLevel += 8;

        tireLevel -= 3;
        changeIllnessAtRandom1toN(1000);
        limitValues();
    }

    public void timePassWithSleep() {
        foodLevel -= 1;
        waterLevel -= 3;

        dirtyLevel += 1;

        tireLevel += 1;
        changeIllnessAtRandom1toN(500);
        limitValues();
    }

    public void timePassWithSleepWithoutLight() {
        foodLevel -= 1;
        waterLevel -= 3;

        dirtyLevel += 1;

        tireLevel += 2;
        changeIllnessAtRandom1toN(1000);
        limitValues();
    }

    public int getHappiness() {
        calculateHappiness();
        return super.getHappiness();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Accessors">        
    public String getTextHappiness() {
        calculateHappiness();
        switch (happiness) {
            case -2:
                return "Very sad! ;-(";
            case -1:
                return "Sad :(";
            case 0:
                return "Not happy, nod sad...";
            case 1:
                return "Happy :)";
            case 2:
                return "Very happy :)";
        }
        return null;
    }

    public String getTextFoodLevel() {
        if (getFoodLevel() < 50 && getFoodLevel() >= 0) {
            return "little hunger";
        } else if (getFoodLevel() < 0) {
            return "hungry";
        }
        return "full";
    }

    public String getTextWaterLevel() {
        if (getWaterLevel() < 50 && getWaterLevel() >= 0) {
            return "little thirsty";
        } else if (getWaterLevel() < 0) {
            return "thirsty";
        }
        return "ok";
    }

    public String getTextIllness() {
        if (getIllness() == 1) {
            return "ill";
        }
        return "healthy";
    }

    public String getTextMessLevel() {
        if (getMessLevel() > 500) {
            return "total mess";
        } else if (getMessLevel() > 200) {
            return "mess";
        }
        return "order";
    }

    public String getTextDirtyLevel() {
        if (getDirtyLevel() > 100) {
            return "dirty";
        }
        return "clean";
    }

    public String getTextPlayLevel() {
        if (getPlayLevel() < 100 && getPlayLevel() >= 0) {
            return "I want to play with you!:)";
        } else if (getPlayLevel() < 0) {
            return "Totally bored";
        } else {
            return "So happy while playing with you";
        }
    }

    public String getTextSize() {
        if (getSize() < 300) {
            return "small";
        } else if (getSize() < 1000) {
            return "medium";
        }
        return "big";
    }

    public String getTextTireLevel() {
        if (isSleeping()) {
            return "Sleeping (" + (getTireLevel() > 150 ? "enough" : "want to sleep!") + ")";
        }
        if (getTireLevel() > 100) {
            return "Well-rested";
        } else if (getTireLevel() > 0) {
            return "rested";
        }
        return "sleepy";
    }

    public Image getCurrentImage() {
        String currentImageName;
        if (getIllness() == 1) {
            currentImageName = "illness";
        } else if (isSleeping()) {
            currentImageName = "sleeping";
        } else if (getHappiness() == -2) {
            currentImageName = "verysad";
        } else if (getHappiness() == -1) {
            currentImageName = "sad";
        } else if (getHappiness() == 0) {
            currentImageName = "normal";
        } else if (getHappiness() == 1) {
            currentImageName = "happy";
        } else {
            currentImageName = "veryhappy";
        }
        if (lastImage != null) {
            if (currentImageName.equals(lastImageName) && getTextSize().equals(lastImageSize)) {
                return lastImage;
            }
        }
        lastImage = Images.readImage(currentImageName, getTextSize());
        lastImageName = currentImageName;
        lastImageSize = getTextSize();
        return lastImage;
    }

    //</editor-fold>
    private void limitValues() {
        if (getFoodLevel() > 600) {
            setFoodLevel(600);
        }
        if (getWaterLevel() > 600) {
            setWaterLevel(600);
        }
    }

    private void calculateHappiness() {
        happiness = 2;
        happiness -= illness;
        happiness -= getFoodLevel() < 0 ? 1 : 0;
        happiness -= getWaterLevel() < 0 ? 1 : 0;
        happiness -= getMessLevel() > 500 ? 1 : 0;
        happiness -= getDirtyLevel() > 100 ? 1 : 0;
        happiness -= getPlayLevel() < 0 ? 1 : 0;
        happiness -= getTireLevel() < 0 ? 1 : 0;
        if (happiness < -2) {
            happiness = -2;
        }

    }

    private void changeIllnessAtRandom1toN(int N) {
        if (getIllness() == 0) {
            if (getRandomNumber(0, N) == 13) {
                setIllness(1);
            }
        }
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void setSleeping(boolean sleeping) {
        this.sleeping = sleeping;
    }
}
