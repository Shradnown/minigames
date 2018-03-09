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
        for (int i = 0; i < boardSize; i++) {
            sb.append("----");
        }
        sb.append("\n");
        for (int i = 0; i < boardSize; i++) {
            sb.append("|");
            sb.append(board.get(i).getColumn());
        }
        sb.append("|\n");
        
        for (int i = 0; i < boardSize; i++) {
            sb.append("|");
            sb.append(board.get(i).getRow());
            for (int n = 0; n < boardSize; n++) {
                sb.append("----");
            }
            sb.append("\n");
            for (int n = 0; n < boardSize; n++) {
                sb.append("|");
                sb.append(board.get(i));
            }
            sb.append("|\n");
        }
        
        return sb.toString();
    }
    
}
