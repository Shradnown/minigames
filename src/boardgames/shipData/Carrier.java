package boardgames.shipData;

import boardgames.gamedata.Coordinate;

/**
 *
 * @author User
 */
public class Carrier extends Ship {

    public Carrier(Coordinate start, Coordinate end) {
        placement.add(start);
        if (start.getColumn()==end.getColumn()) {
            
        }
        else if (start.getRow() == end.getRow()) {
        
        }
        
    }
    
}
