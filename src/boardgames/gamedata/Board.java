package boardgames.gamedata;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Board {
    private ArrayList<Coordinate> board;

    public Board() {
        board = Coordinate.createGridBoard();
    }
    
    private Coordinate findCoordinate(Coordinate coordinate) {
        for (Coordinate c : board) {
            if (c.equals(coordinate)) {
                return c;
            }
        }
        return null;
    }
    
    private Coordinate findCoordinate(String coordinate) {
        coordinate = coordinate.trim();
        String row =  String.valueOf(coordinate.charAt(0));
        String column =  String.valueOf(coordinate.charAt(1));
        
        for (Coordinate c : board) {
            if (c.equals(row, column)) {
                return c;
            }
        }
        return null;
    }
    
    private Coordinate findCoordinate(String row, String column) {
        for (Coordinate c : board) {
            if (c.equals(row, column)) {
                return c;
            }
        }
        return null;
    }
    
    public boolean markCoordinate(Coordinate coordinate) {
        
        return true;
    }
    
}
