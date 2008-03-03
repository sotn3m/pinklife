/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import javax.microedition.lcdui.Image;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public interface CreatureBehaviourInterface {        
    
    // user actions:
    void drinkCocaCola();

    void drinkMilk();

    void drinkOrangeJuice();

    void eatIceCream();

    void eatOrange();

    void eatPeach();

    void eatPineapple();

    void play();

    void tidy();

    void timePass();

    void timePassWithSleep();

    void timePassWithSleepWithoutLight();

    void timePassWithoutLight();

    void washCreature();
    
    // accessors:
    String getTextDirtyLevel();

    String getTextFoodLevel();

    String getTextHappiness();

    String getTextIllness();

    String getTextMessLevel();    
    
    String getTextPlayLevel();

    String getTextSize();

    String getTextTireLevel();

    String getTextWaterLevel();
    
    //image
    public Image getCurrentImage();
    
    // RMS part:    
    String getName();

    boolean load();

    boolean save();
    
    // other:
    void debug();    
}
