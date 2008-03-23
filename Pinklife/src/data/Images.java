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

    public static Image readImage(String str) {
        try {
            return Image.createImage(Image.class.getResourceAsStream("/resources/" + str + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
