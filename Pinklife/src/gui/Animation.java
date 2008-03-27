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
    private CreatureBehaviourInterface creature;
    private int iCurrentStep = 0;
    private String[][] animationfileNames;
    private int width;
    private int height;
    private int eyesTimeCounter = 0;
    private int legTimeCounter = 0;
    private int action = NOTHING;
    private int frameDuration = 0;

    public Animation(int width, int height) {
        this.width = width;
        this.height = height;

        animationfileNames = new String[ACTIONS_COUNT + 1][];
        animationfileNames[SHOWER] = new String[]{"shower_1", "shower_2"};
        animationfileNames[PLAY] = new String[]{"ball_1", "ball_2", "ball_3", "ball_4", "ball_5", "ball_4", "ball_3", "ball_2"};
        animationfileNames[GIVE_MILK] = new String[]{"drink_1", "drink_2", "drink_3", "drink_4"};
        animationfileNames[GIVE_COCACOLA] = new String[]{"cola_1", "cola_2", "cola_3", "drink_4"};
        animationfileNames[GIVE_ORANGEJUICE] = new String[]{"orangejuice_1", "orangejuice_2", "orangejuice_3", "drink_4"};
        animationfileNames[GIVE_ORANGE] = new String[]{"orange_1", "orange_2", "orange_3", "orange_4", "blank"};
        animationfileNames[GIVE_PEACH] = new String[]{"nectarine","nectarine_2","nectarine_3","blank"};
        animationfileNames[GIVE_PINEAPPLE] = new String[]{"ananas", "ananas_2", "blank"};
        animationfileNames[GIVE_ICECREAM] = new String[]{"icecream"};
        animationfileNames[GIVE_MEDICINE] = new String[]{"syringe_1", "syringe_2", "syringe_3"};
        animationfileNames[TIDY] = new String[]{"broom_1", "broom_2", "broom_3", "broom_4", "broom_3", "broom_2"};
    }

    void setAction(int action) {
        frameDuration = 0;
        this.action = action;        
    }

    void setCreature(CreatureBehaviourInterface creature) {
        this.creature = creature;
    }

    private void drawAnimation(Graphics g) {
        if (iCurrentStep >= animationfileNames[action].length) {
            iCurrentStep = 0;
        }

        drawImage(g, Images.readImage(animationfileNames[action][iCurrentStep]));

        if (frameDuration == 2) {
            iCurrentStep++;
            frameDuration = 0;
        } else {            
            frameDuration++;
        }

    }

    public void drawFrame(Graphics g) {
        if (action == TIDY || action == PLAY || action == NOTHING) {
            drawCreature(g);
        }
        if (action != NOTHING) {
            drawAnimation(g);
        }
    }

    //draw only the creature
    private void drawCreature(Graphics g) {
        int happ = creature.getHappiness();

        // mess
        if (creature.isMess()) {
            drawUpperRight(g, Images.readImage("mess"));
        }
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
        if (creature.isSleeping()) {
            drawImage(g, Images.readImage("leg_" + creature.getTextSize()));
        } else if (legTimeCounter > 0) {
            drawImage(g, Images.readImage("leg_impatience_" + creature.getTextSize()));
            legTimeCounter--;
        } else if (data.RandomGenerator.getRandomNumber(1, 60) == 7 && !creature.isIll() && !creature.isDirty()) {
            drawImage(g, Images.readImage("leg_impatience_" + creature.getTextSize()));
            legTimeCounter = 7;
        } else {
            drawImage(g, Images.readImage("leg_" + creature.getTextSize()));
        }
        // eyes
        if (creature.isSleeping()) {
            drawImage(g, Images.readImage("eyes_sleeping_" + creature.getTextSize()));
        } else if (eyesTimeCounter > 0) {
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

    private void drawUpperRight(Graphics g, Image image) {
        int beginningPixelWidth = getWidth() - image.getWidth();
        int beginningPixelHeight = getHeight() - image.getHeight();
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
