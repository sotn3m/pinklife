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
        drawBackground(g);        
        drawCreature(g);
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

    private void drawBackground(Graphics g) {

        if (!creature.isLightTurnedOn()) {
            g.setColor(255, 255, 255);
        } else {
            g.setColor(0, 0, 0);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawCreature(Graphics g) {
        Image image = creature.getCurrentImage();
        int beginningPixelWidth = getWidth() - image.getWidth();
        int beginningPixelHeight = getHeight() - image.getHeight();
        beginningPixelWidth >>= 1;
        beginningPixelHeight >>= 1;
        g.drawImage(image, beginningPixelWidth, beginningPixelHeight, Graphics.TOP | Graphics.LEFT);
    }
}
