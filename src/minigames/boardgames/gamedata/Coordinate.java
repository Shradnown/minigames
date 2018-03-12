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
        if (obj instanceof Coordinate) {
            Coordinate testedCoordinate = (Coordinate) obj;
            return this.row == testedCoordinate.row && this.column == testedCoordinate.column;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.row;
        hash = 43 * hash + this.column;
        return hash;
    }

    public boolean equals(int row, char column) {
        return row == this.row && column == this.column;
    }
    
    
    protected static ArrayList<Coordinate> createGridBoard() {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= 10; row++) {
            char column = 'A';
            for (int c = 1; c <= 10; c++) {
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
            char column = 'A';
            if (row == 27){
                System.out.println("Maximum size of grid is 26");
                return board;
            }
            for (int c = 1; c <= size; c++) {
                board.add(new Coordinate(row, column));
                column++;
            }
        }
        return board;
    }
    
    protected static ArrayList<Coordinate> createGridBoard(boolean visible) {
        ArrayList<Coordinate> board = new ArrayList<>();
        for (int row = 1; row <= 10; row++) {
            char column = 'A';
            for (int c = 1; c <= 10; c++) {
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
            char column = 'A';
            if (row == 27){
                System.out.println("Maximum size of grid is 26");
                return board;
            }
            for (int c = 1; c <= size; c++) {
                board.add(new Coordinate(row, column, visible));
                column++;
            }
        }
        return board;
    }
    
}
