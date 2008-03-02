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
        lights = ! lights;
    }
    
    public void switchSleeping() {
        sleeping = ! sleeping;
    }
    
    public boolean isSleeping() {
        return sleeping;
    }

    public void run() {
        while (_bContinue) {

            // make the time pass
            if (sleeping) {
                if(lights)
                    _creature.timePassWithSleep();
                else
                    _creature.timePassWithSleepWithoutLight();
            } else
                if(lights)
                    _creature.timePass();
                else
                    _creature.timePassWithoutLight();

            _creature.debug();

            _canvas.setLight(lights);
            _canvas.setSleeping(sleeping);

            //redraw the scene
            _canvas.repaint();


            try {
                sleep(2000); // wait 10ms every loop
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
