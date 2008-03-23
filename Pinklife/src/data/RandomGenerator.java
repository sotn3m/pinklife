/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.Random;

/**
 *
 * @author sotn3m <sotn3m at gmail dot com>
 */
public class RandomGenerator {
    private static Random random;

    protected static Random getRandomGenerator() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    //</editor-fold>
    // returns random number between <begin, end)
    public static int getRandomNumber(int begin, int end) {
        return getRandomGenerator().nextInt(end - begin) + begin;
    }

}
