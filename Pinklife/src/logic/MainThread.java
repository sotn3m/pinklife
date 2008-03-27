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
        _canvas.setAnimation(actionToPerform);
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
        if (actionToPerform != NOTHING) {
            boolean bDifferentFromFood = actionToPerform != GIVE_ORANGE && actionToPerform != GIVE_PINEAPPLE && actionToPerform != GIVE_ICECREAM && actionToPerform != GIVE_PEACH;
            if (bDifferentFromFood) {
                if (actionTimeCounter == 50) {
                    performAction();
                }
            } else if (actionTimeCounter == 30) {
                performAction();
            }
            actionTimeCounter++;
        }
    }

    // do the action after the period end and switch action
    private void performAction() {
        switch (actionToPerform) {
            case GIVE_MEDICINE: {
                _creature.cure();
                break;
            }
            case GIVE_ORANGE: {
                _creature.eatOrange();
                break;
            }
            case GIVE_PEACH: {
                _creature.eatPeach();
                break;
            }
            case GIVE_PINEAPPLE: {
                _creature.eatPineapple();
                break;
            }
            case GIVE_ICECREAM: {
                _creature.eatIceCream();
                break;
            }
            case GIVE_MILK: {
                _creature.drinkMilk();
                break;
            }
            case GIVE_COCACOLA: {
                _creature.drinkCocaCola();
                break;
            }
            case GIVE_ORANGEJUICE: {
                _creature.drinkOrangeJuice();
                break;
            }
            case PLAY: {
                _creature.play();
                break;
            }
            case SHOWER: {
                _creature.washCreature();
                break;
            }
            case TIDY: {
                _creature.tidy();
                break;
            }
        }
        performAction(NOTHING);
    }

    private void timePassing() {
        _creature.timePassing();
    }
}
