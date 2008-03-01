package gui;

import data.CreatureBehaviourInterface;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class GameCanvas extends Canvas implements CommandListener {

    private CreatureBehaviourInterface creature;

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

    /**
     * paint
     */
    public void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(255, 0, 255);
        g.drawString(creature.getTextFoodLevel(), 0, 0, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextWaterLevel(), 0, 20, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextDirtyLevel(), 0, 40, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextMessLevel(), 0, 60, Graphics.TOP | Graphics.LEFT);
        g.drawString(creature.getTextTireLevel(), 0, 80, Graphics.TOP | Graphics.LEFT);
        
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
