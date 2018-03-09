package boardgames.gamedata;

import java.util.ArrayList;

/**
 *
 * @author User
 */

public class Coordinate {
    
    private final Row row;
    private final int column;
    private boolean mark;

    public Coordinate(Row row, int column) {
        this.row = row;
        this.column = column;
        mark = false;
    }

    public Row getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean getMark() {
        return mark;
    }

    public void mark(boolean mark) {
        this.mark = mark;
    }
    
    public boolean equals(String row, String column) {
        if (this.row.toString().equalsIgnoreCase(row) || String.valueOf(this.column).equals(column)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()){
            Coordinate otherClass = (Coordinate)obj;
            if (row.equals(otherClass.row) && column == otherClass.column) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    
    @Override
    public String toString() {
        return row + String.valueOf(column);
    }
    
    protected static ArrayList<Coordinate> createGridBoard() {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (Row row : Row.values()) {
            for (int column = 1; column <= 10; column++) {
                board.add(new Coordinate(row, column));
            }
        }
        
        return board;
    }
    /*
    protected static ArrayList<Card> createDeck() {
        ArrayList<Card> cardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(rank, suit));
            }
        }
        return cardDeck;
    }
*/
}
