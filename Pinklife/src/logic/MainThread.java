/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import gui.*;
import data.CreatureBehaviourInterface;

/** 
 * This thread is (will be;>) used to make creature do sth on its own.
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class MainThread extends Thread implements Actions {

    private data.CreatureBehaviourInterface _creature;
    private gui.GameCanvas _canvas;
    // whether thread should run or be stopped
    private boolean _bContinue;
    private int actionToPerform;
    private int actionTimeCounter;

    public MainThread(CreatureBehaviourInterface creature, GameCanvas canvas) {
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
        _creature.switchLight();
    }

    public void switchSleeping() {
        _creature.switchSleeping();
    }

    public boolean isSleeping() {
        return _creature.isSleeping();
    }

    public void performAction(int action) {
        actionToPerform = action;
        actionTimeCounter = 0;
        setCurrentAnimationType();
    }

    public int getCurrentAction() {
        return actionToPerform;
    }

    public void run() {
        int iCounter = 0;

        while (_bContinue) {
            if (iCounter >= 80) {
                timePassing();
                _creature.debug();

                iCounter = 0;
            }
            iCounter++;

            // optionally modify current action
            finalizeAction();

            //redraw the scene
            _canvas.repaint();

            try {
                sleep(100); // wait 10ms every loop
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void finalizeAction() {
        if (actionTimeCounter == 100 && actionToPerform!=NOTHING) {
            switch (actionToPerform) {
                case GIVE_MEDICINE: {
                    _creature.cure();
                }
                case GIVE_ORANGE: {
                    _creature.eatOrange();
                }
                case GIVE_PEACH: {
                    _creature.eatPeach();
                }
                case GIVE_PINEAPPLE: {
                    _creature.eatPineapple();
                }
                case GIVE_ICECREAM: {
                    _creature.eatIceCream();
                }
                case GIVE_MILK: {
                    _creature.drinkMilk();
                }
                case GIVE_COCACOLA: {
                    _creature.drinkCocaCola();
                }
                case GIVE_ORANGEJUICE: {
                    _creature.drinkOrangeJuice();
                }
                case PLAY: {
                    _creature.play();
                }
                case SHOWER: {
                    _creature.washCreature();
                }
                case TIDY: {
                    _creature.tidy();
                }
            }
            performAction(NOTHING);
        }
        if(actionToPerform!=NOTHING)
            actionTimeCounter++;
    }

    private void setCurrentAnimationType() {
        
    }

    private void timePassing() {
        _creature.timePassing();
    }
}
