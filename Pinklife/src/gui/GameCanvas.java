package gui;

import data.CreatureBehaviourInterface;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class GameCanvas extends Canvas implements CommandListener {

    private CreatureBehaviourInterface creature;
    private boolean lights; //true -> on, false -> off
    private boolean sleeping; //true -> sleeping, false -> not sleeping

    /**
     * constructor
     */
    public GameCanvas() {
        try {
            // Set up this canvas to listen to command events
            setCommandListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assignCreature(CreatureBehaviourInterface creature) {
        this.creature = creature;
    }

    public void setLight(boolean light) {
        lights = light;
    }

    public void setSleeping(boolean sleep) {
        sleeping = sleep;
    }

    /**
     * paint
     */
    public void paint(Graphics g) {

        if (lights) {
            g.setColor(255, 255, 255);
        } else {
            g.setColor(0, 0, 0);
        }
        g.fillRect(0, 0, getWidth(), getHeight());


        g.setColor(255, 0, 255);
        g.drawString(creature.getTextFoodLevel(), 0, 0, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextWaterLevel(), 0, 10, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextDirtyLevel(), 0, 20, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextMessLevel(), 0, 30, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextTireLevel(), 0, 40, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextPlayLevel(), 0, 50, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextHappiness(), 0, 60, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextSize(), 0, 70, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextIllness(), 0, 80, Graphics.TOP | Graphics.LEFT);
        
        if(sleeping)
            g.drawString("Sleeping", 0, 100, Graphics.TOP | Graphics.LEFT);
        else
            g.drawString("No sleeping", 0, 100, Graphics.TOP | Graphics.LEFT);
    }

    /**
     * Called when a key is pressed.
     */
    protected void keyPressed(int keyCode) {
    }

    /**
     * Called when a key is released.
     */
    protected void keyReleased(int keyCode) {
    }

    /**
     * Called when a key is repeated (held down).
     */
    protected void keyRepeated(int keyCode) {
    }

    /**
     * Called when the pointer is dragged.
     */
    protected void pointerDragged(int x, int y) {
    }

    /**
     * Called when the pointer is pressed.
     */
    protected void pointerPressed(int x, int y) {
    }

    /**
     * Called when the pointer is released.
     */
    protected void pointerReleased(int x, int y) {
    }

    /**
     * Called when action should be handled
     */
    public void commandAction(Command command, Displayable displayable) {
    }
}
