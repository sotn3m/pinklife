/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import data.CreatureBehaviourInterface;

/** 
 * This thread is (will be;>) used to make creature do sth on its own.
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class MainThread extends Thread {

    private data.CreatureBehaviourInterface _creature;
    private gui.GameCanvas _canvas;
    // whether thread should run or be stopped
    private boolean _bContinue;
    private boolean sleeping = false;
    private boolean lights = true;
    private boolean medicineToBeGiven = false;

    MainThread(CreatureBehaviourInterface creature, GameCanvas canvas) {
        this._creature = creature;
        this._canvas = canvas;
        _bContinue = true;
    }

    public void stopThread() {
        _bContinue = false;
    }

    public void setCreature(CreatureBehaviourInterface creature) {
        _creature = creature;
    }

    public void setCanvas(GameCanvas canvas) {
        _canvas = canvas;
    }

    public void switchLights() {
        lights = !lights;
    }

    public void switchSleeping() {
        sleeping = !sleeping;
        _creature.setSleeping(sleeping);
    }

    public boolean isSleeping() {
        return sleeping;
    }

    public void giveMedicine() {
        medicineToBeGiven = true;
    }
    
    public void run() {
        int iCounter = 0;

        while (_bContinue) {
            if (iCounter >= 80) {
                timePassing();
                _creature.debug();
                
                iCounter = 0;
                
                //we want the medicine working to be delayed...
                if(medicineToBeGiven)
                {
                    _creature.cure();
                    medicineToBeGiven=false;
                }
            }
            iCounter++;

            _canvas.setLight(lights);
            _canvas.setSleeping(sleeping);

            //redraw the scene
            _canvas.repaint();


            try {
                sleep(100); // wait 10ms every loop
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void timePassing() {
        // make the time pass
        if (sleeping) {
            if (lights) {
                _creature.timePassWithSleep();
            } else {
                _creature.timePassWithSleepWithoutLight();
            }
        } else {
            if (lights) {
                _creature.timePass();
            } else {
                _creature.timePassWithoutLight();
            }
        }
    }
}
