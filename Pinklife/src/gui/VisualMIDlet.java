/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.CreatureBean;
import data.CreatureBehaviourInterface;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class VisualMIDlet extends MIDlet implements CommandListener {

    private boolean midletPaused = false;
    private CreatureBehaviourInterface creature;
    private MainThread thread;

    //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
    private java.util.Hashtable __previousDisplayables = new java.util.Hashtable();
    private GameCanvas gameCanvas;
    private List list;
    private Form form;
    private StringItem stringItem;
    private Alert alert;
    private TextBox CreatureNameTextBox;
    private List listOfFoods;
    private List listOfDrinks;
    private List actionList;
    private Form creatureStatsWindow;
    private StringItem stringItem1;
    private StringItem stringItem2;
    private StringItem stringItem3;
    private StringItem stringItem7;
    private StringItem stringItem6;
    private StringItem stringItem5;
    private StringItem stringItem4;
    private StringItem stringItem10;
    private StringItem stringItem9;
    private StringItem stringItem8;
    private Alert saveGame;
    private List listActionSleeping;
    private Command exitCommand;
    private Command backCommand;
    private Command okCommand;
    private Command statsCommand;
    private Command actionCommand;
    private Command noCommand;
    //</editor-fold>//GEN-END:|fields|0|
    /**
     * The VisualMIDlet constructor.
     */
    public VisualMIDlet() {
    }

    private void create() {
        creature = new CreatureBean(getCreatureNameTextBox().getString(), 0, 0, 0, 0, 0, 0, 0, 0, 0);
        if (creature.save()) {
            load();
        } else {
            loadingFailed();
        }
    }

    private void load() {
        try {
            creature = new CreatureBean();

            getGameCanvas().assignCreature(creature);

            if (thread == null) {
                thread = new MainThread(creature, getGameCanvas());
                thread.start();
            } else {
                thread.setCanvas(getGameCanvas());
                thread.setCreature(creature);
            }

            returnToGameScreen();
        } catch (Exception ex) {
            loadingFailed();
        }
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
            gameCanvas.addCommand(getActionCommand());
            gameCanvas.addCommand(getStatsCommand());
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
        if (displayable == CreatureNameTextBox) {//GEN-BEGIN:|7-commandAction|1|84-preAction
            if (command == backCommand) {//GEN-END:|7-commandAction|1|84-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|2|84-postAction
            // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|3|87-preAction
                // write pre-action user code here
                create();//GEN-LINE:|7-commandAction|4|87-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|5|142-preAction
        } else if (displayable == actionList) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|5|142-preAction
                // write pre-action user code here
                actionListAction();//GEN-LINE:|7-commandAction|6|142-postAction
            // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|7|212-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|8|212-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|9|80-preAction
        } else if (displayable == alert) {
            if (command == backCommand) {//GEN-END:|7-commandAction|9|80-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|10|80-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|11|154-preAction
        } else if (displayable == creatureStatsWindow) {
            if (command == backCommand) {//GEN-END:|7-commandAction|11|154-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|12|154-postAction
                stringItem1 = null;
                stringItem2 = null;
                stringItem3 = null;
                stringItem4 = null;
                stringItem5 = null;
                stringItem6 = null;
                stringItem7 = null;
                stringItem8 = null;
                stringItem9 = null;
                stringItem10 = null;                              
            }//GEN-BEGIN:|7-commandAction|13|62-preAction
        } else if (displayable == form) {
            if (command == backCommand) {//GEN-END:|7-commandAction|13|62-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|14|62-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|15|140-preAction
        } else if (displayable == gameCanvas) {
            if (command == actionCommand) {//GEN-END:|7-commandAction|15|140-preAction
                // write pre-action user code here
                isSleeping();//GEN-LINE:|7-commandAction|16|140-postAction
            // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|17|22-preAction
                // write pre-action user code here
                switchDisplayable(null, getSaveGame());//GEN-LINE:|7-commandAction|18|22-postAction
            // write post-action user code here
            } else if (command == statsCommand) {//GEN-LINE:|7-commandAction|19|138-preAction
                // write pre-action user code here
                switchDisplayable(null, getCreatureStatsWindow());//GEN-LINE:|7-commandAction|20|138-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|21|35-preAction
        } else if (displayable == list) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|21|35-preAction
                // write pre-action user code here
                listAction();//GEN-LINE:|7-commandAction|22|35-postAction
            // write post-action user code here
            } else if (command == exitCommand) {//GEN-LINE:|7-commandAction|23|60-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|24|60-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|25|200-preAction
        } else if (displayable == listActionSleeping) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|25|200-preAction
                // write pre-action user code here
                listActionSleepingAction();//GEN-LINE:|7-commandAction|26|200-postAction
                // write post-action user code here
            } else if (command == backCommand) {//GEN-LINE:|7-commandAction|27|214-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|28|214-postAction
                // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|29|117-preAction
        } else if (displayable == listOfDrinks) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|29|117-preAction
                // write pre-action user code here
                listOfDrinksAction();//GEN-LINE:|7-commandAction|30|117-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|31|105-preAction
        } else if (displayable == listOfFoods) {
            if (command == List.SELECT_COMMAND) {//GEN-END:|7-commandAction|31|105-preAction
                // write pre-action user code here
                listOfFoodsAction();//GEN-LINE:|7-commandAction|32|105-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|33|171-preAction
        } else if (displayable == saveGame) {
            if (command == backCommand) {//GEN-END:|7-commandAction|33|171-preAction
                // write pre-action user code here
                switchToPreviousDisplayable();//GEN-LINE:|7-commandAction|34|171-postAction
            // write post-action user code here
            } else if (command == noCommand) {//GEN-LINE:|7-commandAction|35|185-preAction
                // write pre-action user code here
                exitMIDlet();//GEN-LINE:|7-commandAction|36|185-postAction
            // write post-action user code here
            } else if (command == okCommand) {//GEN-LINE:|7-commandAction|37|170-preAction
                creature.save();
                exitMIDlet();//GEN-LINE:|7-commandAction|38|170-postAction
            // write post-action user code here
            }//GEN-BEGIN:|7-commandAction|39|7-postCommandAction
        }//GEN-END:|7-commandAction|39|7-postCommandAction

        getGameCanvas().repaint();
        
    }//GEN-BEGIN:|7-commandAction|40|
    //</editor-fold>//GEN-END:|7-commandAction|40|

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
    //<editor-fold defaultstate="collapsed" desc=" Generated Method: returnToGameScreen ">//GEN-BEGIN:|30-entry|0|31-preAction
    /**
     * Performs an action assigned to the returnToGameScreen entry-point.
     */
    public void returnToGameScreen() {//GEN-END:|30-entry|0|31-preAction
        // write pre-action user code here
        switchDisplayable(null, getGameCanvas());//GEN-LINE:|30-entry|1|31-postAction
        getGameCanvas().repaint();
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
                switchDisplayable(null, getCreatureNameTextBox());//GEN-LINE:|33-action|2|41-postAction
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

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: CreatureNameTextBox ">//GEN-BEGIN:|82-getter|0|82-preInit
    /**
     * Returns an initiliazed instance of CreatureNameTextBox component.
     * @return the initialized component instance
     */
    public TextBox getCreatureNameTextBox() {
        if (CreatureNameTextBox == null) {//GEN-END:|82-getter|0|82-preInit
            // write pre-init user code here
            CreatureNameTextBox = new TextBox("Choose your creature name:", "", 100, TextField.ANY | TextField.INITIAL_CAPS_WORD);//GEN-BEGIN:|82-getter|1|82-postInit
            CreatureNameTextBox.addCommand(getBackCommand());
            CreatureNameTextBox.addCommand(getOkCommand());
            CreatureNameTextBox.setCommandListener(this);//GEN-END:|82-getter|1|82-postInit
        // write post-init user code here
        }//GEN-BEGIN:|82-getter|2|
        return CreatureNameTextBox;
    }
    //</editor-fold>//GEN-END:|82-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: okCommand ">//GEN-BEGIN:|86-getter|0|86-preInit
    /**
     * Returns an initiliazed instance of okCommand component.
     * @return the initialized component instance
     */
    public Command getOkCommand() {
        if (okCommand == null) {//GEN-END:|86-getter|0|86-preInit
            // write pre-init user code here
            okCommand = new Command("Ok", Command.OK, 0);//GEN-LINE:|86-getter|1|86-postInit
        // write post-init user code here
        }//GEN-BEGIN:|86-getter|2|
        return okCommand;
    }
    //</editor-fold>//GEN-END:|86-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: listOfFoods ">//GEN-BEGIN:|104-getter|0|104-preInit
    /**
     * Returns an initiliazed instance of listOfFoods component.
     * @return the initialized component instance
     */
    public List getListOfFoods() {
        if (listOfFoods == null) {//GEN-END:|104-getter|0|104-preInit
            // write pre-init user code here
            listOfFoods = new List("List of foods", Choice.IMPLICIT);//GEN-BEGIN:|104-getter|1|104-postInit
            listOfFoods.append("Orange", null);
            listOfFoods.append("Pineapple", null);
            listOfFoods.append("Peach", null);
            listOfFoods.append("Ice cream", null);
            listOfFoods.setCommandListener(this);
            listOfFoods.setSelectedFlags(new boolean[] { false, false, false, false });//GEN-END:|104-getter|1|104-postInit
        // write post-init user code here
        }//GEN-BEGIN:|104-getter|2|
        return listOfFoods;
    }
    //</editor-fold>//GEN-END:|104-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listOfFoodsAction ">//GEN-BEGIN:|104-action|0|104-preAction
    /**
     * Performs an action assigned to the selected list element in the listOfFoods component.
     */
    public void listOfFoodsAction() {//GEN-END:|104-action|0|104-preAction
        // pre-action
        String __selectedString = getListOfFoods().getString(getListOfFoods().getSelectedIndex());//GEN-BEGIN:|104-action|1|108-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Orange")) {//GEN-END:|104-action|1|108-preAction
                creature.eatOrange();
//GEN-LINE:|104-action|2|108-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Pineapple")) {//GEN-LINE:|104-action|3|109-preAction
                creature.eatPineapple();
//GEN-LINE:|104-action|4|109-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Peach")) {//GEN-LINE:|104-action|5|110-preAction
                creature.eatPeach();
//GEN-LINE:|104-action|6|110-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Ice cream")) {//GEN-LINE:|104-action|7|111-preAction
                creature.eatIceCream();
//GEN-LINE:|104-action|8|111-postAction
            // write post-action user code here
            }//GEN-BEGIN:|104-action|9|104-postAction
        }//GEN-END:|104-action|9|104-postAction
        returnToGameScreen();
    }//GEN-BEGIN:|104-action|10|
    //</editor-fold>//GEN-END:|104-action|10|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: listOfDrinks ">//GEN-BEGIN:|116-getter|0|116-preInit
    /**
     * Returns an initiliazed instance of listOfDrinks component.
     * @return the initialized component instance
     */
    public List getListOfDrinks() {
        if (listOfDrinks == null) {//GEN-END:|116-getter|0|116-preInit
            // write pre-init user code here
            listOfDrinks = new List("List of drinks", Choice.IMPLICIT);//GEN-BEGIN:|116-getter|1|116-postInit
            listOfDrinks.append("Milk", null);
            listOfDrinks.append("Orange juice", null);
            listOfDrinks.append("Coca cola", null);
            listOfDrinks.setCommandListener(this);
            listOfDrinks.setSelectedFlags(new boolean[] { false, false, false });//GEN-END:|116-getter|1|116-postInit
        // write post-init user code here
        }//GEN-BEGIN:|116-getter|2|
        return listOfDrinks;
    }
    //</editor-fold>//GEN-END:|116-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listOfDrinksAction ">//GEN-BEGIN:|116-action|0|116-preAction
    /**
     * Performs an action assigned to the selected list element in the listOfDrinks component.
     */
    public void listOfDrinksAction() {//GEN-END:|116-action|0|116-preAction
        // enter pre-action user code here
        String __selectedString = getListOfDrinks().getString(getListOfDrinks().getSelectedIndex());//GEN-BEGIN:|116-action|1|119-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("Milk")) {//GEN-END:|116-action|1|119-preAction
                creature.drinkMilk();
//GEN-LINE:|116-action|2|119-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Orange juice")) {//GEN-LINE:|116-action|3|120-preAction
                creature.drinkOrangeJuice();
//GEN-LINE:|116-action|4|120-postAction
            // write post-action user code here
            } else if (__selectedString.equals("Coca cola")) {//GEN-LINE:|116-action|5|121-preAction
                creature.drinkCocaCola();
//GEN-LINE:|116-action|6|121-postAction
            // write post-action user code here
            }//GEN-BEGIN:|116-action|7|116-postAction
        }//GEN-END:|116-action|7|116-postAction
        returnToGameScreen();
    }//GEN-BEGIN:|116-action|8|
    //</editor-fold>//GEN-END:|116-action|8|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: statsCommand ">//GEN-BEGIN:|137-getter|0|137-preInit
    /**
     * Returns an initiliazed instance of statsCommand component.
     * @return the initialized component instance
     */
    public Command getStatsCommand() {
        if (statsCommand == null) {//GEN-END:|137-getter|0|137-preInit
            // write pre-init user code here
            statsCommand = new Command("Creature statistics", Command.SCREEN, 0);//GEN-LINE:|137-getter|1|137-postInit
        // write post-init user code here
        }//GEN-BEGIN:|137-getter|2|
        return statsCommand;
    }
    //</editor-fold>//GEN-END:|137-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: actionList ">//GEN-BEGIN:|141-getter|0|141-preInit
    /**
     * Returns an initiliazed instance of actionList component.
     * @return the initialized component instance
     */
    public List getActionList() {
        if (actionList == null) {//GEN-END:|141-getter|0|141-preInit
            // write pre-init user code here
            actionList = new List("Action List", Choice.IMPLICIT);//GEN-BEGIN:|141-getter|1|141-postInit
            actionList.append("feed", null);
            actionList.append("drink", null);
            actionList.append("tidy room", null);
            actionList.append("wash creature", null);
            actionList.append("play", null);
            actionList.append("go to sleep/wake up", null);
            actionList.append("turn the lights on/off", null);
            actionList.addCommand(getBackCommand());
            actionList.setCommandListener(this);
            actionList.setSelectedFlags(new boolean[] { false, false, false, false, false, false, false });//GEN-END:|141-getter|1|141-postInit
        // write post-init user code here
        }//GEN-BEGIN:|141-getter|2|
        return actionList;
    }
    //</editor-fold>//GEN-END:|141-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: actionListAction ">//GEN-BEGIN:|141-action|0|141-preAction
    /**
     * Performs an action assigned to the selected list element in the actionList component.
     */
    public void actionListAction() {//GEN-END:|141-action|0|141-preAction
        // enter pre-action user code here
        String __selectedString = getActionList().getString(getActionList().getSelectedIndex());//GEN-BEGIN:|141-action|1|145-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("feed")) {//GEN-END:|141-action|1|145-preAction
                // write pre-action user code here
                switchDisplayable(null, getListOfFoods());//GEN-LINE:|141-action|2|145-postAction
            // write post-action user code here
            } else if (__selectedString.equals("drink")) {//GEN-LINE:|141-action|3|147-preAction
                // write pre-action user code here
                switchDisplayable(null, getListOfDrinks());//GEN-LINE:|141-action|4|147-postAction
            // write post-action user code here
            } else if (__selectedString.equals("tidy room")) {//GEN-LINE:|141-action|5|149-preAction
                // write pre-action user code here
                creature.tidy();//GEN-LINE:|141-action|6|149-postAction
                returnToGameScreen();
            } else if (__selectedString.equals("wash creature")) {//GEN-LINE:|141-action|7|187-preAction
                // write pre-action user code here
                creature.washCreature();//GEN-LINE:|141-action|8|187-postAction
                returnToGameScreen();
            } else if (__selectedString.equals("play")) {//GEN-LINE:|141-action|9|151-preAction
                // write pre-action user code here
                creature.play();//GEN-LINE:|141-action|10|151-postAction
                returnToGameScreen();
            } else if (__selectedString.equals("go to sleep/wake up")) {//GEN-LINE:|141-action|11|181-preAction
                // write pre-action user code here
                thread.switchSleeping();//GEN-LINE:|141-action|12|181-postAction
                returnToGameScreen();
            } else if (__selectedString.equals("turn the lights on/off")) {//GEN-LINE:|141-action|13|182-preAction
                // write pre-action user code here
                thread.switchLights();//GEN-LINE:|141-action|14|182-postAction
                returnToGameScreen();
            }//GEN-BEGIN:|141-action|15|141-postAction
        }//GEN-END:|141-action|15|141-postAction
    // post-action
    }//GEN-BEGIN:|141-action|16|
    //</editor-fold>//GEN-END:|141-action|16|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: actionCommand ">//GEN-BEGIN:|139-getter|0|139-preInit
    /**
     * Returns an initiliazed instance of actionCommand component.
     * @return the initialized component instance
     */
    public Command getActionCommand() {
        if (actionCommand == null) {//GEN-END:|139-getter|0|139-preInit
            // write pre-init user code here
            actionCommand = new Command("Do sth!", Command.SCREEN, 0);//GEN-LINE:|139-getter|1|139-postInit
        // write post-init user code here
        }//GEN-BEGIN:|139-getter|2|
        return actionCommand;
    }
    //</editor-fold>//GEN-END:|139-getter|2|
    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: creatureStatsWindow ">//GEN-BEGIN:|153-getter|0|153-preInit
    /**
     * Returns an initiliazed instance of creatureStatsWindow component.
     * @return the initialized component instance
     */
    public Form getCreatureStatsWindow() {
        if (creatureStatsWindow == null) {//GEN-END:|153-getter|0|153-preInit
            // write pre-init user code here
            creatureStatsWindow = new Form("Creature state", new Item[] { getStringItem9(), getStringItem10(), getStringItem7(), getStringItem1(), getStringItem2(), getStringItem3(), getStringItem4(), getStringItem5(), getStringItem6(), getStringItem8() });//GEN-BEGIN:|153-getter|1|153-postInit
            creatureStatsWindow.addCommand(getBackCommand());
            creatureStatsWindow.setCommandListener(this);//GEN-END:|153-getter|1|153-postInit
        // write post-init user code here
        }//GEN-BEGIN:|153-getter|2|
        return creatureStatsWindow;
    }
    //</editor-fold>//GEN-END:|153-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|157-getter|0|157-preInit
    /**
     * Returns an initiliazed instance of stringItem1 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem1() {
        if (stringItem1 == null) {//GEN-END:|157-getter|0|157-preInit
            // write pre-init user code here
            stringItem1 = new StringItem("Food:", creature.getTextFoodLevel());//GEN-LINE:|157-getter|1|157-postInit
        // write post-init user code here
        }//GEN-BEGIN:|157-getter|2|
        return stringItem1;
    }
    //</editor-fold>//GEN-END:|157-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|158-getter|0|158-preInit
    /**
     * Returns an initiliazed instance of stringItem2 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem2() {
        if (stringItem2 == null) {//GEN-END:|158-getter|0|158-preInit
            // write pre-init user code here
            stringItem2 = new StringItem("Drink:", creature.getTextWaterLevel());//GEN-LINE:|158-getter|1|158-postInit
        // write post-init user code here
        }//GEN-BEGIN:|158-getter|2|
        return stringItem2;
    }
    //</editor-fold>//GEN-END:|158-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|159-getter|0|159-preInit
    /**
     * Returns an initiliazed instance of stringItem3 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem3() {
        if (stringItem3 == null) {//GEN-END:|159-getter|0|159-preInit
            // write pre-init user code here
            stringItem3 = new StringItem("Entertainment:", creature.getTextPlayLevel());//GEN-LINE:|159-getter|1|159-postInit
        // write post-init user code here
        }//GEN-BEGIN:|159-getter|2|
        return stringItem3;
    }
    //</editor-fold>//GEN-END:|159-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|160-getter|0|160-preInit
    /**
     * Returns an initiliazed instance of stringItem4 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem4() {
        if (stringItem4 == null) {//GEN-END:|160-getter|0|160-preInit
            // write pre-init user code here
            stringItem4 = new StringItem("Creature dirtiness:", creature.getTextDirtyLevel());//GEN-LINE:|160-getter|1|160-postInit
        // write post-init user code here
        }//GEN-BEGIN:|160-getter|2|
        return stringItem4;
    }
    //</editor-fold>//GEN-END:|160-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|161-getter|0|161-preInit
    /**
     * Returns an initiliazed instance of stringItem5 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem5() {
        if (stringItem5 == null) {//GEN-END:|161-getter|0|161-preInit
            // write pre-init user code here
            stringItem5 = new StringItem("Room order:", creature.getTextMessLevel());//GEN-LINE:|161-getter|1|161-postInit
        // write post-init user code here
        }//GEN-BEGIN:|161-getter|2|
        return stringItem5;
    }
    //</editor-fold>//GEN-END:|161-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem6 ">//GEN-BEGIN:|162-getter|0|162-preInit
    /**
     * Returns an initiliazed instance of stringItem6 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem6() {
        if (stringItem6 == null) {//GEN-END:|162-getter|0|162-preInit
            // write pre-init user code here
            stringItem6 = new StringItem("Sleepiness:", creature.getTextTireLevel());//GEN-LINE:|162-getter|1|162-postInit
        // write post-init user code here
        }//GEN-BEGIN:|162-getter|2|
        return stringItem6;
    }
    //</editor-fold>//GEN-END:|162-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem7 ">//GEN-BEGIN:|163-getter|0|163-preInit
    /**
     * Returns an initiliazed instance of stringItem7 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem7() {
        if (stringItem7 == null) {//GEN-END:|163-getter|0|163-preInit
            // write pre-init user code here
            stringItem7 = new StringItem("Happiness:", creature.getTextHappiness());//GEN-LINE:|163-getter|1|163-postInit
        // write post-init user code here
        }//GEN-BEGIN:|163-getter|2|
        return stringItem7;
    }
    //</editor-fold>//GEN-END:|163-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem8 ">//GEN-BEGIN:|164-getter|0|164-preInit
    /**
     * Returns an initiliazed instance of stringItem8 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem8() {
        if (stringItem8 == null) {//GEN-END:|164-getter|0|164-preInit
            // write pre-init user code here
            stringItem8 = new StringItem("Ill/healthy:", creature.getTextIllness());//GEN-LINE:|164-getter|1|164-postInit
        // write post-init user code here
        }//GEN-BEGIN:|164-getter|2|
        return stringItem8;
    }
    //</editor-fold>//GEN-END:|164-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem9 ">//GEN-BEGIN:|165-getter|0|165-preInit
    /**
     * Returns an initiliazed instance of stringItem9 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem9() {
        if (stringItem9 == null) {//GEN-END:|165-getter|0|165-preInit
            // write pre-init user code here
            stringItem9 = new StringItem("Name:", creature.getName());//GEN-LINE:|165-getter|1|165-postInit
        // write post-init user code here
        }//GEN-BEGIN:|165-getter|2|
        return stringItem9;
    }
    //</editor-fold>//GEN-END:|165-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem10 ">//GEN-BEGIN:|166-getter|0|166-preInit
    /**
     * Returns an initiliazed instance of stringItem10 component.
     * @return the initialized component instance
     */
    public StringItem getStringItem10() {
        if (stringItem10 == null) {//GEN-END:|166-getter|0|166-preInit
            // write pre-init user code here
            stringItem10 = new StringItem("Size", creature.getTextSize());//GEN-LINE:|166-getter|1|166-postInit
        // write post-init user code here
        }//GEN-BEGIN:|166-getter|2|
        return stringItem10;
    }
    //</editor-fold>//GEN-END:|166-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: saveGame ">//GEN-BEGIN:|167-getter|0|167-preInit
    /**
     * Returns an initiliazed instance of saveGame component.
     * @return the initialized component instance
     */
    public Alert getSaveGame() {
        if (saveGame == null) {//GEN-END:|167-getter|0|167-preInit
            // write pre-init user code here
            saveGame = new Alert("Save game?");//GEN-BEGIN:|167-getter|1|167-postInit
            saveGame.addCommand(getOkCommand());
            saveGame.addCommand(getNoCommand());
            saveGame.addCommand(getBackCommand());
            saveGame.setCommandListener(this);
            saveGame.setTimeout(Alert.FOREVER);//GEN-END:|167-getter|1|167-postInit
        // write post-init user code here
        }//GEN-BEGIN:|167-getter|2|
        return saveGame;
    }
    //</editor-fold>//GEN-END:|167-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: noCommand ">//GEN-BEGIN:|184-getter|0|184-preInit
    /**
     * Returns an initiliazed instance of noCommand component.
     * @return the initialized component instance
     */
    public Command getNoCommand() {
        if (noCommand == null) {//GEN-END:|184-getter|0|184-preInit
            // write pre-init user code here
            noCommand = new Command("No", Command.CANCEL, 0);//GEN-LINE:|184-getter|1|184-postInit
        // write post-init user code here
        }//GEN-BEGIN:|184-getter|2|
        return noCommand;
    }
    //</editor-fold>//GEN-END:|184-getter|2|



    //<editor-fold defaultstate="collapsed" desc=" Generated Getter: listActionSleeping ">//GEN-BEGIN:|199-getter|0|199-preInit
    /**
     * Returns an initiliazed instance of listActionSleeping component.
     * @return the initialized component instance
     */
    public List getListActionSleeping() {
        if (listActionSleeping == null) {//GEN-END:|199-getter|0|199-preInit
            // write pre-init user code here
            listActionSleeping = new List("Action list (sleeping)", Choice.IMPLICIT);//GEN-BEGIN:|199-getter|1|199-postInit
            listActionSleeping.append("go to sleep/wake up", null);
            listActionSleeping.append("turn the lights on/off", null);
            listActionSleeping.addCommand(getBackCommand());
            listActionSleeping.setCommandListener(this);
            listActionSleeping.setSelectedFlags(new boolean[] { false, false });//GEN-END:|199-getter|1|199-postInit
            // write post-init user code here
        }//GEN-BEGIN:|199-getter|2|
        return listActionSleeping;
    }
    //</editor-fold>//GEN-END:|199-getter|2|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: listActionSleepingAction ">//GEN-BEGIN:|199-action|0|199-preAction
    /**
     * Performs an action assigned to the selected list element in the listActionSleeping component.
     */
    public void listActionSleepingAction() {//GEN-END:|199-action|0|199-preAction
        // enter pre-action user code here
        String __selectedString = getListActionSleeping().getString(getListActionSleeping().getSelectedIndex());//GEN-BEGIN:|199-action|1|203-preAction
        if (__selectedString != null) {
            if (__selectedString.equals("go to sleep/wake up")) {//GEN-END:|199-action|1|203-preAction
                // write pre-action user code here
                thread.switchSleeping();//GEN-LINE:|199-action|2|203-postAction
                returnToGameScreen();
            } else if (__selectedString.equals("turn the lights on/off")) {//GEN-LINE:|199-action|3|204-preAction
                // write pre-action user code here
                thread.switchLights();//GEN-LINE:|199-action|4|204-postAction
                returnToGameScreen();
            }//GEN-BEGIN:|199-action|5|199-postAction
        }//GEN-END:|199-action|5|199-postAction
        // enter post-action user code here
    }//GEN-BEGIN:|199-action|6|
    //</editor-fold>//GEN-END:|199-action|6|

    //<editor-fold defaultstate="collapsed" desc=" Generated Method: isSleeping ">//GEN-BEGIN:|207-if|0|207-preIf
    /**
     * Performs an action assigned to the isSleeping if-point.
     */
    public void isSleeping() {//GEN-END:|207-if|0|207-preIf
        // enter pre-if user code here
        if (thread.isSleeping()) {//GEN-LINE:|207-if|1|208-preAction
            // write pre-action user code here
            switchDisplayable(null, getListActionSleeping());//GEN-LINE:|207-if|2|208-postAction
            // write post-action user code here
        } else {//GEN-LINE:|207-if|3|209-preAction
            // write pre-action user code here
            switchDisplayable(null, getActionList());//GEN-LINE:|207-if|4|209-postAction
            // write post-action user code here
        }//GEN-LINE:|207-if|5|207-postIf
        // enter post-if user code here
    }//GEN-BEGIN:|207-if|6|
    //</editor-fold>//GEN-END:|207-if|6|
    /**
     * Returns a display instance.
     * @return the display instance.
     */
    public Display getDisplay() {
        return Display.getDisplay(this);
    }

    /**
     * Exits MIDlet.
     */
    public void exitMIDlet() {
        try {
            thread.stopThread();
            thread.join();
            switchDisplayable(null, null);
            destroyApp(true);
            notifyDestroyed();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Called when MIDlet is started.
     * Checks whether the MIDlet have been already started and initialize/starts or resumes the MIDlet.
     */
    public void startApp() {
        if (midletPaused) {
            resumeMIDlet();
        } else {
            initialize();
            startMIDlet();
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
