package data;

import javax.microedition.lcdui.Image;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean extends CreatureBeanRMS implements CreatureBehaviourInterface {
        
    //<editor-fold defaultstate="collapsed" desc="Contructors and debug method">
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
    
    public void debug() {
        System.out.println("--------");
        System.out.println("Name: "+getName());
        System.out.println("");
        System.out.println("Food: "+getFoodLevel());
        System.out.println("Water: "+getWaterLevel());
        System.out.println("Dirty: "+getDirtyLevel());
        System.out.println("Mess: "+getMessLevel());
        System.out.println("Play: "+getPlayLevel());
        System.out.println("Tire: "+getTireLevel());
        System.out.println("");
        System.out.println("Happiness: "+getHappiness());
        System.out.println("Size: "+getSize());
        System.out.println("Illness: "+getIllness());
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
    }

    public void timePassWithoutLight() {
        foodLevel--;
        waterLevel -= getRandomNumber(1, 3);

        playLevel--;

        dirtyLevel += 6;
        messLevel += 8;

        tireLevel -= 3;
        changeIllnessAtRandom1toN(1000);
    }

    public void timePassWithSleep() {
        foodLevel -= 2;
        waterLevel -= 4;

        dirtyLevel += 1;

        tireLevel += 3;
        changeIllnessAtRandom1toN(500);
    }

    public void timePassWithSleepWithoutLight() {
        foodLevel -= 2;
        waterLevel -= 4;

        dirtyLevel += 1;

        tireLevel += 1;
        changeIllnessAtRandom1toN(1000);
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
        if(getFoodLevel()<50 && getFoodLevel()>=0)
            return "little hunger";
        else if(getFoodLevel()<0)
            return "hungry";
        return "full";
    }

    public String getTextWaterLevel() {
        if(getWaterLevel()<50 && getWaterLevel()>=0)
            return "little thirsty";
        else if(getWaterLevel()<0)
            return "thirsty";
        return "ok";
    }
    
    public String getTextIllness() {
        if(getIllness()==1)
            return "ill";
        return "healthy";
    }

    public String getTextMessLevel() {
        if(getMessLevel()>500)
            return "total mess";
        else if(getMessLevel()>200)
            return "mess";
        return "order";
    }
    
    public String getTextDirtyLevel() {
        if(getDirtyLevel()>100)
            return "dirty";
        return "clean";
    }

    public String getTextPlayLevel() {
        if(getPlayLevel()<100 && getPlayLevel()>=0)
            return "I want to play with you!:)";
        else if(getPlayLevel()<0)
            return "Total bored";
        else return "So happy while playing with you";
    }

    public String getTextSize() {
        if(getSize()<300)
            return "small";
        else if(getSize()<1000)
            return "medium";
        return "large";
    }

    public String getTextTireLevel() {
        if(getTireLevel()>100)
            return "Well-rested";
        else if(getTireLevel()>0)
            return "rested";
        return "sleepy";
    }

    public Image getCurrentImage() {
        if(getHappiness() > 0)
            return Images.getSmiledImage();
        else
            return Images.getSadImage();
    }

    //</editor-fold>

    private void calculateHappiness() {
        //TODO
    }
    
    private void changeIllnessAtRandom1toN(int N) {
        if(getIllness()==0) {
            if(getRandomNumber(0, N)==13) {
                setIllness(1);
            }
        }            
    }
}
