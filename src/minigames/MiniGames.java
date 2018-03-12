package minigames;

/**
 *
 * @author Erik
 */

import minigames.boardgames.gamedata.Board;
import minigames.boardgames.gamedata.CoordinateNotFoundException;
import minigames.boardgames.gamedata.InvalidCoordinateException;
import minigames.cardgames.UI;
import minigames.cardgames.gamedata.Scoreboard;

//A fun little project of minigames that I'll update every now and then when I learn things/think of games to add
public class MiniGames {
    public static void main(String[] args) {
        //Creates scoreboard and ui objects and loops the main menu function of the ui, until the user decides to exit.
        Scoreboard scoreboard = new Scoreboard();
        UI ui = new UI(scoreboard);
        
        Board board = new Board();
        System.out.println(board);
        
        try {
        board.markCoordinate("E5");
        }
        catch (InvalidCoordinateException e) {
            System.out.println("Something went wrong");
        }
        System.out.println(board);
        try {
            System.out.print(board.getBoard().get(board.findCoordinateIndex("E5")).getColumn());
            System.out.println(board.getBoard().get(board.findCoordinateIndex("E5")).getRow());
            System.out.print(board.getBoard().get(board.getAboveIndex("E5")).getColumn());
            System.out.println(board.getBoard().get(board.getAboveIndex("E5")).getRow());
            System.out.println(board.getBoard().indexOf(board.getBoard().get(board.findCoordinateIndex("E5"))));
            System.out.println(board.getBoard().indexOf(board.getBoard().get(board.findCoordinateIndex("E4"))));
        }
        catch (CoordinateNotFoundException e) {
            System.out.println("Something went wrong");
        }
        
        
        boolean loop = true;
        while (loop) {
            loop = ui.mainMenu();
        }
    }
    
}
