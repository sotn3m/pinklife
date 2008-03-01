package data;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean extends CreatureBeanRMS implements CreatureBehaviourInterface {
        
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
    }

    public void drinkMilk() {
        waterLevel += 100;
        dirtyLevel += 30;
        messLevel += 10;
        size += 3;
    }

    public void drinkOrangeJuice() {
        waterLevel += 100;
        foodLevel += 10;
        dirtyLevel += 40;
        messLevel += 10;
    }

    public void drinkCocaCola() {
        waterLevel += 200;
        dirtyLevel += 20;
        messLevel += 10;
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Time passing...">
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
        waterLevel -= getRandomNumber(1, 3);

        playLevel--;

        dirtyLevel += 6;
        messLevel += 8;

        tireLevel -= 3;
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Accessors">
    public String getTextHappiness() {
        calculateHappiness();
        switch(happiness)
        {
            case -2: return "Very sad!";
            case -1: return "Sad!";
            case 0: return "Normal";
            case 1: return "Happy :)";
            case 2: return "Very happy :)";            
        }
        return null;
    }

    public String getTextFoodLevel() {
        if(getFoodLevel()<50)
            return "little hunger";
        else if(getFoodLevel()<0)
            return "hungry";
        return "full";
    }

    public String getTextWaterLevel() {
        if(getFoodLevel()<50)
            return "little thirsty";
        else if(getFoodLevel()<0)
            return "thirsty";
        return "ok";
    }
    
    public String getTextIllness() {
        if(getIllness()==1)
            return "ill";
        return "healthy";
    }

    public String getTextMessLevel() {
        if(getFoodLevel()>500)
            return "total mess";
        else if(getFoodLevel()>200)
            return "mess";
        return "order";
    }
    
    public String getTextDirtyLevel() {
        if(getDirtyLevel()>100)
            return "dirty";
        return "clean";
    }

    public String getTextPlayLevel() {
        if(getPlayLevel()<100)
            return "I want to play with you!:)";
        else if(getPlayLevel()<0)
            return "Total bored";
        else return "So happy while playing with you";
    }

    public String getTextSize() {
        switch(size)
        {
            case 1: return "small";
            case 2: return "medium";
            case 3: return "large";
        }
        return "large";
    }

    public String getTextTireLevel() {
        if(getDirtyLevel()>100)
            return "Well-rested";
        else if(getDirtyLevel()>0)
            return "rested";
        return "sleepy";
    }


    //</editor-fold>

    private void calculateHappiness() {
        //TODO
    }
}
