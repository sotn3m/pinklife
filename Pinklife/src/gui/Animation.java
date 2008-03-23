/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.CreatureBehaviourInterface;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class Animation {

    private int frameCount;
    private CreatureBehaviourInterface creature;
    private int iCurrentStep = 1;
    
    private int width;
    private int height;

    public Animation(int width, int height) {
    }

    /**
     * Draw current frame
     * 
     * @param g - Graphics to draw into
     * @return true if loop was just restarted, false otherwise.
     */
    public boolean drawFrame(Graphics g) {
        drawFrame(g, iCurrentStep);
        iCurrentStep++;
        if (iCurrentStep > frameCount) {
            iCurrentStep = 1;
            return true;
        }
        return false;
    }

    void setAction(int action) {
    }

    void setCreature(CreatureBehaviourInterface creature) {
        this.creature = creature;
    }

    private void drawFrame(Graphics g,
            int iStep) {
        
//        Image image = creature.getCurrentImage();
//        int beginningPixelWidth = getWidth() - image.getWidth();
//        int beginningPixelHeight = getHeight() - image.getHeight();
//        beginningPixelWidth >>= 1;
//        beginningPixelHeight >>= 1;
//        g.drawImage(image, beginningPixelWidth, beginningPixelHeight, Graphics.TOP | Graphics.LEFT);
    }
    
    public CreatureBehaviourInterface getCreature() {
        return creature;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
