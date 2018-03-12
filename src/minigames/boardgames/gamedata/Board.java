package minigames.boardgames.gamedata;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Board {
    int boardSize;
    private ArrayList<Coordinate> board;

    public Board() {
        board = Coordinate.createGridBoard();
        boardSize = 10;
    }
    
    public Board(int boardSize) throws InvalidBoardSizeException {
        if (boardSize < 1) {
            throw new InvalidBoardSizeException();
        }
        else if (this.boardSize > 26) {
            this.boardSize = boardSize;
        }
        else {
            this.boardSize = boardSize;
        }
        board = Coordinate.createGridBoard(boardSize);
    }
    /*
    public int findCoordinateIndex(String coordinate) throws CoordinateNotFoundException {
        coordinate = coordinate.trim();
        char column = coordinate.charAt(0);
        int row = Integer.parseInt(coordinate.substring(1, 2));
        for (int index = 0; index < board.size(); index++) {
            if (board.get(index).equals(row, column)) {
                return index;
            }
        }
        throw new CoordinateNotFoundException();
    }
    */
    public int findCoordinateIndex(String coordinate) throws CoordinateNotFoundException {
        coordinate = coordinate.trim();
        char column = coordinate.charAt(0);
        int row = Integer.parseInt(coordinate.substring(1, 2));
        Coordinate test = new Coordinate(row, column);
        if (board.contains(test)) {
            return board.indexOf(test);
        }
        
        throw new CoordinateNotFoundException();
    }
    

    public void markCoordinate(String coordinate) throws InvalidCoordinateException {
        try {
            int index = findCoordinateIndex(coordinate);
            if (board.get(index).isMark()) {
                throw new InvalidCoordinateException();
            }
            else {
                board.get(index).mark();
                System.out.println("Coordinate marked");
                System.out.println(board.get(index));
            }
            board.get(index).mark();
        }
        catch (CoordinateNotFoundException e) {
            System.out.println("Invalid Coordinate");
            throw new InvalidCoordinateException();
        }
    }
    
    
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= boardSize; i++) {
            sb.append("====");
        }
        sb.append("===\n|    |");
        char column = 'A';
        for (int i = 0; i < boardSize; i++) {
            sb.append("| ");
            sb.append(column);
            column++;
            sb.append(" ");
        }
        sb.append("|\n===");
        for (int i = 0; i <= boardSize; i++) {
            sb.append("====");
        }
        
        for (int i = 0; i < boardSize; i++) {
            sb.append("\n| ");
            sb.append(String.format("%-3s", String.valueOf(i + 1)));
            sb.append("|");

            for (int n = 0; n < boardSize; n++) {
                sb.append("|");
                sb.append(board.get((i * boardSize) + n));
            }
            sb.append("|\n---");
            for (int n = 0; n <= boardSize; n++) {
                sb.append("----");
            }
        }
        return sb.toString();
    }
    
}
