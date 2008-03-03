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
    private static Image smiledImage = null;
    private static Image sadImage = null;
    
    public static Image getSmiledImage() {
        if(smiledImage==null) 
            smiledImage = readImage("/resources/icon.png");        
        return smiledImage;
    }
    public static Image getSadImage() {
        if(sadImage==null) 
            sadImage = readImage("/resources/icon.png");
        return sadImage;
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
