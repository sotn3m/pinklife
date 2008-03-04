/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.IOException;
import javax.microedition.lcdui.Image;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class Images {
    private static Image happyImage = null;
    private static Image sadImage = null;
    private static Image veryHappyImage = null;
    private static Image verySadImage = null;
    private static Image illImage = null;
    private static Image sleepingImage = null;
    private static Image normalImage = null;
    
    public static Image getIllImage(String size) {
        if(illImage==null) 
            illImage = readImage("/resources/icon.png");
        return illImage;
    }
    
    public static Image getSleepingImage(String size) {
        if(sleepingImage==null) 
            sleepingImage = readImage("/resources/icon.png");
        return sleepingImage;
    }
    
    public static Image getVeryHappyImage(String size) {
        if(veryHappyImage==null) 
            veryHappyImage = readImage("/resources/icon.png");        
        return veryHappyImage;
    }
    
    public static Image getHappyImage(String size) {
        if(happyImage==null) 
            happyImage = readImage("/resources/icon.png");        
        return happyImage;
    }
    
    public static Image getNormalImage(String size) {
        if(normalImage==null) 
            normalImage = readImage("/resources/icon.png");
        return normalImage;
    }
    
    public static Image getSadImage(String size) {
        if(sadImage==null) 
            sadImage = readImage("/resources/icon.png");
        return sadImage;
    }

    public static Image getVerySadImage(String size) {
        if(verySadImage==null) 
            verySadImage = readImage("/resources/icon.png");
        return verySadImage;
    }    
    
    private static Image readImage(String str) {
        try {
            return Image.createImage(Image.class.getResourceAsStream(str));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
