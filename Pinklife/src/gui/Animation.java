/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.CreatureBean;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class Animation {

    private int frameCount;
    private CreatureBean creature;
    private int iCurrentStep = 1;

    public Animation(int frameCount, CreatureBean creature) {
        this.frameCount = frameCount;
        this.creature = creature;
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

    private void drawFrame(Graphics g,
            int iStep) {

    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public CreatureBean getCreature() {
        return creature;
    }

    public void setCreature(CreatureBean creature) {
        this.creature = creature;
    }
}
