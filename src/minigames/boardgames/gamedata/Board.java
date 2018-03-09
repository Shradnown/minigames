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
            sb.append(String.format("%-3s", String.valueOf(i+1)));
            sb.append("|");
            for (int n = 0; n < boardSize; n++) {
                sb.append("|");
                sb.append(board.get(i));
            }
            sb.append("|\n---");
            for (int n = 0; n <= boardSize; n++) {
                sb.append("----");
            }
            
        }
        return sb.toString();
    }
    
}
