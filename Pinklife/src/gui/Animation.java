/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.CreatureBehaviourInterface;
import data.Images;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import logic.Actions;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class Animation implements Actions {

    // general animation for drinks
    private final int DRINK = ACTIONS_COUNT + 1;
    private int frameCount;
    private CreatureBehaviourInterface creature;
    private int iCurrentStep = 1;
    private Object[][] animationfileNames;
    private int width;
    private int height;

    public Animation(int width, int height) {
        this.width = width;
        this.height = height;

        animationfileNames = new Object[ACTIONS_COUNT + 2][];
        animationfileNames[SHOWER] = new String[]{"shower_1", "shower_2"};
        animationfileNames[PLAY] = new String[]{"ball_1", "ball_2", "ball_3", "ball_4", "ball_5"};
        animationfileNames[DRINK] = new String[]{"drink_1", "drink_2", "drink_3", "drink_4"};
        animationfileNames[GIVE_ORANGE] = new String[]{"orange"};
        animationfileNames[GIVE_PEACH] = new String[]{"nectarine"};
        animationfileNames[GIVE_PINEAPPLE] = new String[]{"ananas"};
        animationfileNames[GIVE_ICECREAM] = new String[]{"icecream"};
        animationfileNames[GIVE_MEDICINE] = new String[]{"syringe_1", "syringe_2", "syringe_3"};
        animationfileNames[TIDY] = new String[]{"broom_1", "broom_2", "broom_3", "broom_4"};
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
        drawCreature(g);

    }

    //draw only the creature
    private void drawCreature(Graphics g) {
        drawImage(g, Images.readImage("body_" + creature.getTextSize()));

    }

    //draw single image on the center
    private void drawImage(Graphics g, Image image) {
        int beginningPixelWidth = getWidth() - image.getWidth();
        int beginningPixelHeight = getHeight() - image.getHeight();
        beginningPixelWidth >>= 1;
        beginningPixelHeight >>= 1;
        g.drawImage(image, beginningPixelWidth, beginningPixelHeight, Graphics.TOP | Graphics.LEFT);
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
