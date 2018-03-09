package cardgames;

/**
 *
 * @author Erik
 */

import cardgames.gamedata.Scoreboard;

//A fun little project of minigames that I'll update every now and then when I learn things/think of games to add
public class CardGames {
    public static void main(String[] args) {
        //Creates scoreboard and ui objects and loops the main menu function of the ui, until the user decides to exit.
        Scoreboard scoreboard = new Scoreboard();
        UI ui = new UI(scoreboard);
        boolean loop = true;
        while (loop) {
            loop = ui.mainMenu();
        }
    }
    
}
