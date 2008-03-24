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
    private int eyesTimeCounter = 0;
    private int legTimeCounter = 0;

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

    private void drawFrame(Graphics g, int iStep) {
        drawCreature(g);

    }

    //draw only the creature
    private void drawCreature(Graphics g) {
        int happ = creature.getHappiness();

        // body
        drawImage(g, Images.readImage("body_" + creature.getTextSize()));
        // brows              
        if (happ == 2 || happ == 0) {
            drawImage(g, Images.readImage("brows_normal_" + creature.getTextSize()));
        }
        if (happ > 0) {
            drawImage(g, Images.readImage("brows_happy_" + creature.getTextSize()));
        }
        if (happ < 0) {
            drawImage(g, Images.readImage("brows_sad_" + creature.getTextSize()));
        }
        // lips
        if (happ == 0 || happ == 2) {
            drawImage(g, Images.readImage("smile_normal_" + creature.getTextSize()));
        }
        if (happ > 0) {
            drawImage(g, Images.readImage("smile_happy_" + creature.getTextSize()));
        }
        if (happ < 0) {
            drawImage(g, Images.readImage("smile_sad_" + creature.getTextSize()));
        }
        // legs        
        if (legTimeCounter > 0) {
            drawImage(g, Images.readImage("leg_impatience_" + creature.getTextSize()));
            legTimeCounter--;
        } else if (data.RandomGenerator.getRandomNumber(1, 60) == 7) {
            drawImage(g, Images.readImage("leg_impatience_" + creature.getTextSize()));
            legTimeCounter = 7;
        } else {
            drawImage(g, Images.readImage("leg_" + creature.getTextSize()));
        }
        // eyes
        if (eyesTimeCounter > 0) {
            drawImage(g, Images.readImage("eyes_wink_" + creature.getTextSize()));
            eyesTimeCounter--;
        } else if (data.RandomGenerator.getRandomNumber(1, 80) == 7) {
            drawImage(g, Images.readImage("eyes_wink_" + creature.getTextSize()));
            eyesTimeCounter = 7;
        } else {
            drawImage(g, Images.readImage("eyes_" + creature.getTextSize()));
        }
        // health
        if (creature.isIll()) {
            drawImage(g, Images.readImage("illness_" + creature.getTextSize()));
        }
        // dirty
        if (creature.isDirty()) {
            drawImage(g, Images.readImage("dirt_" + creature.getTextSize()));
        }
        // tear
        if (happ == -2) {
            drawImage(g, Images.readImage("tear_" + creature.getTextSize()));
        }

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
