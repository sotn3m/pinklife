/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class CreatureBean {
    private String sName;    
    private int iHappiness;
    private int iFoodLevel;
    private int iWaterLevel;
    private int iDirtyLevel;
    private int iPlayLevel;

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        this.sName = name;
    }

    public int getIHappiness() {
        return iHappiness;
    }

    public void setIHappiness(int iHappiness) {
        this.iHappiness = iHappiness;
    }

    public int getIFoodLevel() {
        return iFoodLevel;
    }

    public void setIFoodLevel(int iFoodLevel) {
        this.iFoodLevel = iFoodLevel;
    }

    public int getIWaterLevel() {
        return iWaterLevel;
    }

    public void setIWaterLevel(int iWaterLevel) {
        this.iWaterLevel = iWaterLevel;
    }

    public int getIDirtyLevel() {
        return iDirtyLevel;
    }

    public void setIDirtyLevel(int iDirtyLevel) {
        this.iDirtyLevel = iDirtyLevel;
    }

    public int getIPlayLevel() {
        return iPlayLevel;
    }

    public void setIPlayLevel(int iPlayLevel) {
        this.iPlayLevel = iPlayLevel;
    }
    
}
