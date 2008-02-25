package gui;

import data.CreatureBean;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class GameCanvas extends Canvas implements CommandListener {
    private CreatureBean creature;
    
    /**
     * constructor
     */
    public GameCanvas() {
        try {
	    // Set up this canvas to listen to command events
	    setCommandListener(this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    } 
 
    public void assignCreature(CreatureBean creature) {
        this.creature = creature;
    }
    
    /**
     * paint
     */
    public void paint(Graphics g) {
        g.setColor(255,255,255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(255,0,255);
        g.drawString(getDescription(),0,0,Graphics.TOP|Graphics.LEFT);
    }
    
    private String getDescription() {
        StringBuffer strbuf = new StringBuffer();
        strbuf.append(creature.getName());
        strbuf.append(" ");
        strbuf.append(creature.getHappiness());
        strbuf.append(" ");
        strbuf.append(creature.getDirtyLevel());
        strbuf.append(" ");
        strbuf.append(creature.getWaterLevel());
        strbuf.append(" ");
        strbuf.append(creature.getFoodLevel());
        strbuf.append(" ");
        strbuf.append(creature.getPlayLevel());        
        return strbuf.toString();        
    }
    
    /**
     * Called when a key is pressed.
     */
    protected  void keyPressed(int keyCode) {
    }
    
    /**
     * Called when a key is released.
     */
    protected  void keyReleased(int keyCode) {
    }

    /**
     * Called when a key is repeated (held down).
     */
    protected  void keyRepeated(int keyCode) {
    }
    
    /**
     * Called when the pointer is dragged.
     */
    protected  void pointerDragged(int x, int y) {
    }

    /**
     * Called when the pointer is pressed.
     */
    protected  void pointerPressed(int x, int y) {
    }

    /**
     * Called when the pointer is released.
     */
    protected  void pointerReleased(int x, int y) {
    }
    
    /**
     * Called when action should be handled
     */
    public void commandAction(Command command, Displayable displayable) {
    }

}