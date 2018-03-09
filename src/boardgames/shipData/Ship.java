package boardgames.shipData;

import boardgames.gamedata.Coordinate;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public abstract class Ship {
    ArrayList<Coordinate> placement;
    private boolean sunk;

    public boolean isSunk() {
        if (sunk) {
            return sunk;
        }
        
        boolean test = true;
        for (Coordinate coordinate : placement) {
            if (!coordinate.getMark()) {
                test = false;
            }
        }
        sunk = test;
        return sunk;
    }
    
}
