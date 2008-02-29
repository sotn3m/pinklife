/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/** 
 * This thread is (will be;>) used to make creature do sth on its own.
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class MainThread extends Thread {

    private data.CreatureBean _creature;
    private gui.GameCanvas _canvas;
    // whether thread should run or be stopped
    private boolean _bContinue;

    public MainThread(data.CreatureBean creature, gui.GameCanvas canvas) {
        this._creature = creature;
        this._canvas = canvas;
    }

    public void stopThread() {
        _bContinue = false;
    }

    public void run() {
        while (_bContinue) {
            
            // make the time pass
            _creature.timePass();
            
            //redraw the scene
            _canvas.repaint();
            
            
            try {
                sleep(100); // wait 10ms every loop
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
