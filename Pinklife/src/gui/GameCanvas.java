package gui;

import data.CreatureBehaviourInterface;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class GameCanvas extends Canvas implements CommandListener {

    private static final int BLACK = 0x00000000;
    private static final int WHITE = 0x00FFFFFF;
    private static final int RED = 0x00FF0000;
    private static final int BLUE = 0x000000FF;
    private CreatureBehaviourInterface creature;
    private Animation animation;

    /**
     * constructor
     */
    public GameCanvas() {
        animation = new Animation(getWidth(), getHeight());
        try {
            // Set up this canvas to listen to command events
            setCommandListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assignCreature(CreatureBehaviourInterface creature) {
        this.creature = creature;
        this.animation.setCreature(creature);
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

        if (creature.isLightTurnedOn()) {
            g.setColor(WHITE);
        } else {
            g.setColor(BLACK);
        }
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawCreature(Graphics g) {
        this.animation.drawFrame(g);
    }

    public void setAnimation(int action) {
        this.animation.setAction(action);
    }
}
