package data;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean {
    private String sName;    
    private int happiness;
    private int foodLevel;
    private int waterLevel;
    private int dirtyLevel;
    private int playLevel;
    
    public void debug() {
        System.out.println(getName());
        System.out.println("Happiness: " + getHappiness());
        System.out.println("Food: " + getFoodLevel());
        System.out.println("Water: " + getWaterLevel());
        System.out.println("Dirty: " + getDirtyLevel());
        System.out.println("Play: " + getPlayLevel());
    }
    /*
     * This method will store all records in RMS
     */
    public void save() {
        
    }
    
    /*
     * This method will load all records from RMS
     */
    public void load() {
        
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getFoodLevel() {
        return foodLevel;
    }

    public void setFoodLevel(int foodLevel) {
        this.foodLevel = foodLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public int getDirtyLevel() {
        return dirtyLevel;
    }

    public void setDirtyLevel(int dirtyLevel) {
        this.dirtyLevel = dirtyLevel;
    }

    public int getPlayLevel() {
        return playLevel;
    }

    public void setPlayLevel(int playLevel) {
        this.playLevel = playLevel;
    }

    public String getName() {
        return sName;
    }

    public void setName(String Name) {
        this.sName = Name;
    }
    
}
