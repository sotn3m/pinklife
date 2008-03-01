/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.Random;
import javax.microedition.rms.RecordStore;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBeanRMS {

    protected final String storeName = "creatureData";
    protected String sName;
    
    protected int happiness; // -2 (very sad), -1 (sad), 0 (neutral), 1 (happy), 2 (very happy)
    
    protected int illness; // 0 if none, 1 if ill.
    protected int size; // 1, 2 or 3.            
            
    protected int foodLevel;
    protected int waterLevel;
    protected int dirtyLevel; //creature's dirtyness
    protected int messLevel; //around
    protected int playLevel;
    protected int tireLevel;
    private Random random;

    //<editor-fold defaultstate="collapsed" desc="int to byte[] and vice versa">
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
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Saving and loading">
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
            } catch (Exception ex) {
            } //ignore

            //create record store:
            RecordStore store = RecordStore.openRecordStore(storeName, true);

            //store all of the values:
            store.addRecord(getName().getBytes(), 0, getName().getBytes().length);
            store.addRecord(intToByte(getHappiness()), 0, 4);
            store.addRecord(intToByte(getFoodLevel()), 0, 4);
            store.addRecord(intToByte(getWaterLevel()), 0, 4);
            store.addRecord(intToByte(getDirtyLevel()), 0, 4);
            store.addRecord(intToByte(getMessLevel()), 0, 4);
            store.addRecord(intToByte(getPlayLevel()), 0, 4);
            store.addRecord(intToByte(getTireLevel()), 0, 4);
            store.addRecord(intToByte(getSize()), 0, 4);
            store.addRecord(intToByte(getIllness()), 0, 4);

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
            setMessLevel(byteToInt(store.getRecord(6)));
            setPlayLevel(byteToInt(store.getRecord(7)));
            setTireLevel(byteToInt(store.getRecord(8)));
            setSize(byteToInt(store.getRecord(9)));
            setIllness(byteToInt(store.getRecord(10)));

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    //</editor-fold>
    
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

    public int getMessLevel() {
        return messLevel;
    }

    public void setMessLevel(int messLevel) {
        this.messLevel = messLevel;
    }

    public int getTireLevel() {
        return tireLevel;
    }

    public void setTireLevel(int tireLevel) {
        this.tireLevel = tireLevel;
    }

    public int getIllness() {
        return illness;
    }

    public void setIllness(int illness) {
        this.illness = illness;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    //</editor-fold>
    
    // returns random number between <begin, end)
    protected int getRandomNumber(int begin, int end) {
        return getRandomGenerator().nextInt(end - begin) + begin;
    }

    protected Random getRandomGenerator() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }
}
