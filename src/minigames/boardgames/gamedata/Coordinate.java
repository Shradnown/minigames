package minigames.boardgames.gamedata;

import java.util.ArrayList;

/**
 *
 * @author User
 */

public class Coordinate {
    
    private final int row;
    private final char column;
    private final boolean visible;
    private boolean mark;
    private boolean occupied;
    

    public Coordinate(int row, char column) {
        this.row = row;
        this.column = Character.toUpperCase(column);
        mark = false;
        occupied = false;
        visible = true;
    }
    
    public Coordinate(int row, char column, boolean visible) {
        this.row = row;
        this.column = Character.toUpperCase(column);
        mark = false;
        occupied = false;
        this.visible = visible;
    }

    public int getRow() {
        return row;
    }

    public char getColumn() {
        return column;
    }

    public boolean isMark() {
        return mark;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void mark() {
        mark = true;
    }

    public void setOccupied() {
        occupied = true;
    }
    
    public void reset() {
        mark = false;
        occupied = false;
    }

    @Override
    public String toString() {
        String visual;
        if (occupied && mark) {
            return "[O]";
        }
        else if (visible && occupied && !mark) {
            return "[ ]";
        }
        else if (!occupied && mark) {
            return " X ";
        }
        else {
            return "   ";
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() == obj.getClass()){
            Coordinate otherClass = (Coordinate)obj;
            if (row == otherClass.row && column == otherClass.column) {
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
    protected static ArrayList<Coordinate> createGridBoard() {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= 10; row++) {
            for (int c = 1; c <= 10; c++) {
                char column = 'A';
                board.add(new Coordinate(row, column));
                column++;
            }
        }
        return board;
    }
    
    protected static ArrayList<Coordinate> createGridBoard(int size) throws InvalidBoardSizeException {
        if (size < 1) {
            throw new InvalidBoardSizeException();
        }
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= size; row++) {
            if (row == 27){
                System.out.println("Maximum size of grid is 26");
                return board;
            }
            for (int c = 1; c <= size; c++) {
                char column = 'A';
                board.add(new Coordinate(row, column));
                column++;
            }
        }
        return board;
    }
    
    protected static ArrayList<Coordinate> createGridBoard(boolean visible) {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= 10; row++) {
            for (int c = 1; c <= 10; c++) {
                char column = 'A';
                board.add(new Coordinate(row, column, visible));
                column++;
            }
        }
        return board;
    }
    
    protected static ArrayList<Coordinate> createGridBoard(int size, boolean visible) throws InvalidBoardSizeException {
        if (size < 1) {
            throw new InvalidBoardSizeException();
        }
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= size; row++) {
            if (row == 27){
                System.out.println("Maximum size of grid is 26");
                return board;
            }
            for (int c = 1; c <= size; c++) {
                char column = 'A';
                board.add(new Coordinate(row, column, visible));
                column++;
            }
        }
        return board;
    }
    
}
