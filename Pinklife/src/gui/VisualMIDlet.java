/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import data.CreatureBean;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class VisualMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    
    private CreatureBean creature;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private GameCanvas gameCanvas;
    private List list;
    private Form form;
    private StringItem stringItem;
    private Alert alert;
    private Command exitCommand;
    private Command feedCommand;
    private Command tidyCommand;
    private Command backCommand;
    //</editor-fold>//GEN-END:|fields|0|

    /**
     * The VisualMIDlet constructor.
     */
    public VisualMIDlet() {
    }

    private void create() {
        creature = new CreatureBean("name", 0, 0, 0, 0, 0);
        if(creature.save())
            load();
        else
            loadingFailed();
    }

    private void load() {
        creature = new CreatureBean();
        if(creature.load())
            returnToGameScreen();
        else
            loadingFailed();
    }

    //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
    /**
     * Switches a display to previous displayable of the current displayable.
     * The <code>display</code> instance is obtain from the <code>getDisplay</code> method.
     */
    private void switchToPreviousDisplayable() {
        Displayable __currentDisplayable = getDisplay().getCurrent();
        if (__currentDisplayable != null) {
            Displayable __nextDisplayable = (Displayable) __previousDisplayables.get(__currentDisplayable);
            if (__nextDisplayable != null) {
                switchDisplayable(null, __nextDisplayable);
            }
        }
    }
    //</editor-fold>//GEN-END:|methods|0|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
    /**
     * Initilizes the application.
     * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
     */
    private void initialize() {//GEN-END:|0-initialize|0|0-preInitialize
        // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
        // write post-initialize user code here
    }//GEN-BEGIN:|0-initialize|2|
    //</editor-fold>//GEN-END:|0-initialize|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Started point.
     */
    public void startMIDlet() {//GEN-END:|3-startMIDlet|0|3-preAction
        // write pre-action user code here
        switchDisplayable(null, getList());//GEN-LINE:|3-startMIDlet|1|3-postAction
        // write post-action user code here
    }//GEN-BEGIN:|3-startMIDlet|2|
    //</editor-fold>//GEN-END:|3-startMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
    /**
     * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
     */
    public void resumeMIDlet() {//GEN-END:|4-resumeMIDlet|0|4-preAction
        // write pre-action user code here
        load();//GEN-LINE:|4-resumeMIDlet|1|4-postAction
        // write post-action user code here
    }//GEN-BEGIN:|4-resumeMIDlet|2|
    //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
    /**
     * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
     * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
     * @param nextDisplayable the Displayable to be set
     */
    public void switchDisplayable(Alert alert, Displayable nextDisplayable) {//GEN-END:|5-switchDisplayable|0|5-preSwitch
        // write pre-switch user code here
        Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
        Displayable __currentDisplayable = display.getCurrent();
        if (__currentDisplayable != null  &&  nextDisplayable != null) {
            __previousDisplayables.put(nextDisplayable, __currentDisplayable);
        }
        if (alert == null) {
            display.setCurrent(nextDisplayable);
        } else {
            display.setCurrent(alert, nextDisplayable);
        }//GEN-END:|5-switchDisplayable|1|5-postSwitch
        // write post-switch user code here
    }//GEN-BEGIN:|5-switchDisplayable|2|
    //</editor-fold>//GEN-END:|5-switchDisplayable|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: gameCanvas ">//GEN-BEGIN:|13-getter|0|13-preInit
    /**
     * Returns an initiliazed instance of gameCanvas component.
     * @return the initialized component instance
     */
    public GameCanvas getGameCanvas() {
        if (gameCanvas == null) {//GEN-END:|13-getter|0|13-preInit
            // write pre-init user code here
            gameCanvas = new GameCanvas();//GEN-BEGIN:|13-getter|1|13-postInit
            gameCanvas.setTitle("gameCanvas");
            gameCanvas.addCommand(getExitCommand());
            gameCanvas.addCommand(getFeedCommand());
            gameCanvas.addCommand(getTidyCommand());
            gameCanvas.setCommandListener(this);//GEN-END:|13-getter|1|13-postInit
            // write post-init user code here
        }//GEN-BEGIN:|13-getter|2|
        return gameCanvas;
    }
    //</editor-fold>//GEN-END:|13-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
    /**
     * Called by a system to indicated that a command has been invoked on a particular displayable.
     * @param command the Command that was invoked
     * @param displayable the Displayable where the command was invoked
     */
    public void commandAction(Command command, Displayable displayable) {//GEN-END:|7-commandAction|0|7-preCommandAction
        // write pre-action user code here
        if (displayable == alert) {//GEN-BEGIN:|7-commandAction|1|80-preAction
            if (command == backCommand) {//GEN-END:|7-commandAction|1|80-preAction
                // write pre-action user code here
                switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|80-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|3|62-preAction
        } else if (displayable == form) {
            if (command == backCommand) {//GEN-END:|7-commandAction|3|62-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|4|62-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|22-preAction
        } else if (displayable == gameCanvas) {
            if (command == exitCommand) {//GEN-END:|7-commandAction|5|22-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|6|22-postAction
                // write post-action user code here
            } else if (command == feedCommand) {//GEN-LINE:|7-commandAction|7|25-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|8|25-postAction
                // write post-action user code here
            } else if (command == tidyCommand) {//GEN-LINE:|7-commandAction|9|27-preAction
                // write pre-action user code here
//GEN-LINE:|7-commandAction|10|27-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|35-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|11|35-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|12|35-postAction
                // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|13|60-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|14|60-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|7-postCommandAction
        }//GEN-END:|7-commandAction|15|7-postCommandAction
        // write post-action user code here
    }//GEN-BEGIN:|7-commandAction|16|
    //</editor-fold>//GEN-END:|7-commandAction|16|


    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|21-getter|0|21-preInit
    /**
     * Returns an initiliazed instance of exitCommand component.
     * @return the initialized component instance
     */
    public Command getExitCommand() {
        if (exitCommand == null) {//GEN-END:|21-getter|0|21-preInit
            // write pre-init user code here
            exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|21-getter|1|21-postInit
            // write post-init user code here
        }//GEN-BEGIN:|21-getter|2|
        return exitCommand;
    }
    //</editor-fold>//GEN-END:|21-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: feedCommand ">//GEN-BEGIN:|24-getter|0|24-preInit
    /**
     * Returns an initiliazed instance of feedCommand component.
     * @return the initialized component instance
     */
    public Command getFeedCommand() {
        if (feedCommand == null) {//GEN-END:|24-getter|0|24-preInit
            // write pre-init user code here
            feedCommand = new Command("Feed it!", "Feed it!", Command.SCREEN, 0);//GEN-LINE:|24-getter|1|24-postInit
            // write post-init user code here
        }//GEN-BEGIN:|24-getter|2|
        return feedCommand;
    }
    //</editor-fold>//GEN-END:|24-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: tidyCommand ">//GEN-BEGIN:|26-getter|0|26-preInit
    /**
     * Returns an initiliazed instance of tidyCommand component.
     * @return the initialized component instance
     */
    public Command getTidyCommand() {
        if (tidyCommand == null) {//GEN-END:|26-getter|0|26-preInit
            // write pre-init user code here
            tidyCommand = new Command("Tidy his room!", Command.SCREEN, 0);//GEN-LINE:|26-getter|1|26-postInit
            // write post-init user code here
        }//GEN-BEGIN:|26-getter|2|
        return tidyCommand;
    }
    //</editor-fold>//GEN-END:|26-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: returnToGameScreen ">//GEN-BEGIN:|30-entry|0|31-preAction
    /**
     * Performs an action assigned to the returnToGameScreen entry-point.
     */
    public void returnToGameScreen() {//GEN-END:|30-entry|0|31-preAction
        // write pre-action user code here
        switchDisplayable(null, getGameCanvas());//GEN-LINE:|30-entry|1|31-postAction
        // write post-action user code here
    }//GEN-BEGIN:|30-entry|2|
    //</editor-fold>//GEN-END:|30-entry|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|33-getter|0|33-preInit
    /**
     * Returns an initiliazed instance of list component.
     * @return the initialized component instance
     */
    public List getList() {
        if (list == null) {//GEN-END:|33-getter|0|33-preInit
            // write pre-init user code here
            list = new List("Menu", Choice.IMPLICIT);//GEN-BEGIN:|33-getter|1|33-postInit
            list.append("New creature", null);
            list.append("Load creature", null);
            list.append("Help", null);
            list.addCommand(getExitCommand());
            list.setCommandListener(this);
            list.setSelectedFlags(new boolean[] { false, false, false });//GEN-END:|33-getter|1|33-postInit
            // write post-init user code here
        }//GEN-BEGIN:|33-getter|2|
        return list;
    }
    //</editor-fold>//GEN-END:|33-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|33-action|0|33-preAction
    /**
     * Performs an action assigned to the selected list element in the list component.
     */
    public void listAction() {//GEN-END:|33-action|0|33-preAction
        // enter pre-action user code here
        String __selectedString = getList().getString(getList().getSelectedIndex());//GEN-BEGIN:|33-action|1|41-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("New creature")) {//GEN-END:|33-action|1|41-preAction
                // write pre-action user code here
                create();//GEN-LINE:|33-action|2|41-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Load creature")) {//GEN-LINE:|33-action|3|42-preAction
                // write pre-action user code here
                load();//GEN-LINE:|33-action|4|42-postAction
                // write post-action user code here
            } else if (__selectedString.equals("Help")) {//GEN-LINE:|33-action|5|44-preAction
                // write pre-action user code here
                switchDisplayable(null, getForm());//GEN-LINE:|33-action|6|44-postAction
                // write post-action user code here
            }//GEN-BEGIN:|33-action|7|33-postAction
        }//GEN-END:|33-action|7|33-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|33-action|8|
    //</editor-fold>//GEN-END:|33-action|8|



    
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|49-getter|0|49-preInit
    /**
     * Returns an initiliazed instance of backCommand component.
     * @return the initialized component instance
     */
    public Command getBackCommand() {
        if (backCommand == null) {//GEN-END:|49-getter|0|49-preInit
            // write pre-init user code here
            backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|49-getter|1|49-postInit
            // write post-init user code here
        }//GEN-BEGIN:|49-getter|2|
        return backCommand;
    }
    //</editor-fold>//GEN-END:|49-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|56-getter|0|56-preInit
    /**
     * Returns an initiliazed instance of form component.
     * @return the initialized component instance
     */
    public Form getForm() {
        if (form == null) {//GEN-END:|56-getter|0|56-preInit
            // write pre-init user code here
            form = new Form("form", new Item[] { getStringItem() });//GEN-BEGIN:|56-getter|1|56-postInit
            form.addCommand(getBackCommand());
            form.setCommandListener(this);//GEN-END:|56-getter|1|56-postInit
            // write post-init user code here
        }//GEN-BEGIN:|56-getter|2|
        return form;
    }
    //</editor-fold>//GEN-END:|56-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|65-getter|0|65-preInit
    /**
     * Returns an initiliazed instance of stringItem component.
     * @return the initialized component instance
     */
    public StringItem getStringItem() {
        if (stringItem == null) {//GEN-END:|65-getter|0|65-preInit
            // write pre-init user code here
            stringItem = new StringItem("Help", "\n\nThis is a game o life. Pink life. Your task is to take care of little creature. Whether the creature will be happy is up to you! ;-)\n\nHow you can do it?\nFeed it, play with him, tidy after him ;-)\nAt any time you can see how happy your little creature is!\nGood luck!:)");//GEN-LINE:|65-getter|1|65-postInit
            // write post-init user code here
        }//GEN-BEGIN:|65-getter|2|
        return stringItem;
    }
    //</editor-fold>//GEN-END:|65-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: loadingFailed ">//GEN-BEGIN:|69-entry|0|70-preAction
    /**
     * Performs an action assigned to the loadingFailed entry-point.
     */
    public void loadingFailed() {//GEN-END:|69-entry|0|70-preAction
        // write pre-action user code here
        switchDisplayable(null, getAlert());//GEN-LINE:|69-entry|1|70-postAction
        // write post-action user code here
    }//GEN-BEGIN:|69-entry|2|
    //</editor-fold>//GEN-END:|69-entry|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: alert ">//GEN-BEGIN:|75-getter|0|75-preInit
    /**
     * Returns an initiliazed instance of alert component.
     * @return the initialized component instance
     */
    public Alert getAlert() {
        if (alert == null) {//GEN-END:|75-getter|0|75-preInit
            // write pre-init user code here
            alert = new Alert("Error", "Could not load the creature.\n\nIf your phone supports RMS, you might try freeing some space on your device.", null, AlertType.ERROR);//GEN-BEGIN:|75-getter|1|75-postInit
            alert.addCommand(getBackCommand());
            alert.setCommandListener(this);
            alert.setTimeout(Alert.FOREVER);//GEN-END:|75-getter|1|75-postInit
            // write post-init user code here
        }//GEN-BEGIN:|75-getter|2|
        return alert;
    }
    //</editor-fold>//GEN-END:|75-getter|2|







    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay () {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        switchDisplayable (null, null);
        destroyApp(true);
        notifyDestroyed();
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet ();
        } else {
            initialize ();
            startMIDlet ();
        }
        midletPaused = false;
    }

    /**
     * Called when MIDlet is paused.
     */
    public void pauseApp() {
        midletPaused = true;
    }

    /**
     * Called to signal the MIDlet to terminate.
     * @param unconditional if true, then the MIDlet has to be unconditionally terminated and all resources has to be released.
     */
    public void destroyApp(boolean unconditional) {
    }

}
