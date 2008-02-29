package data;

import javax.microedition.rms.RecordStore;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean {

    private final String storeName = "creatureData";
    private String sName;
    private int happiness;
    private int foodLevel;
    private int waterLevel;
    private int dirtyLevel;
    private int playLevel;

    public CreatureBean() {
        sName = new String();
    }

    public CreatureBean(String sName, int happiness, int foodLevel, int waterLevel, int dirtyLevel, int playLevel) {
        this.sName = sName;
        this.happiness = happiness;
        this.foodLevel = foodLevel;
        this.waterLevel = waterLevel;
        this.dirtyLevel = dirtyLevel;
        this.playLevel = playLevel;
    }

    public void debug() {
        System.out.println(getName());
        System.out.println("Happiness: " + getHappiness());
        System.out.println("Food: " + getFoodLevel());
        System.out.println("Water: " + getWaterLevel());
        System.out.println("Dirty: " + getDirtyLevel());
        System.out.println("Play: " + getPlayLevel());
    }

    public static byte[] intToByte(int value) {
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte) ((value >> 24) & 0xFF);
        byteArray[1] = (byte) ((value >> 16) & 0xFF);
        byteArray[2] = (byte) ((value >> 8) & 0xFF);
        byteArray[3] = (byte) (value & 0xFF);
        return byteArray;
    }

    public static int byteToInt(byte[] value) {
        int temp;
        temp = (int) value[3];
        temp = (int) (value[2] << 8);
        temp = (int) (value[1] << 16);
        temp = (int) (value[0] << 24);
        return temp;
    }

    /*
     * This method will store all records in RMS.
     * 
     * @return true if successful, false otherwise.
     */
    public boolean save() {
        try {
            //firstly delete all previous record stores:
            try {
                RecordStore.deleteRecordStore(storeName);
            }
            catch(Exception ex){} //ignore

            //create record store:
            RecordStore store = RecordStore.openRecordStore(storeName, true);

            //store all of the values:
            store.addRecord(getName().getBytes(), 0, getName().getBytes().length);
            store.addRecord(intToByte(getHappiness()), 0, 4);
            store.addRecord(intToByte(getFoodLevel()), 0, 4);
            store.addRecord(intToByte(getWaterLevel()), 0, 4);
            store.addRecord(intToByte(getDirtyLevel()), 0, 4);
            store.addRecord(intToByte(getPlayLevel()), 0, 4);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /*
     * This method will load all records from RMS
     * 
     * @return true if successful, false otherwise.
     */
    public boolean load() {
        try {
            //get the record store              
            RecordStore store = RecordStore.openRecordStore(storeName, false);

            //get the values; should be numbered just as saved.            
            //order is crucial!
            setName(new String(store.getRecord(1)));
            setHappiness(byteToInt(store.getRecord(2)));
            setFoodLevel(byteToInt(store.getRecord(3)));
            setWaterLevel(byteToInt(store.getRecord(4)));
            setDirtyLevel(byteToInt(store.getRecord(5)));
            setPlayLevel(byteToInt(store.getRecord(6)));

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public void eat() {
        foodLevel+=1;
    }
    
    public void drink() {
        waterLevel+=1;
    }
    
    public void tidy() {
        dirtyLevel-=2;
    }
    
    public void play() {
        playLevel+=3;
    }
    
    public void timePass() {
        foodLevel--;
        waterLevel--;
        playLevel--;
        dirtyLevel++;
    }

    //<editor-fold defaultstate="collapsed" desc="Accessor methods">
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
    //</editor-fold>
}
