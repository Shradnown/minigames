package cardgames;

import cardgames.gamedata.*;
import java.util.Scanner;

/**
 *
 * @author Erik
 */

public class UI {
    //Initializes a scanner for input from user, and declares the scoreboard and the abstract class game
    private final Scanner sc = new Scanner(System.in);
    private final Scoreboard scoreboard;
    private CardGame game;

    public UI(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }
    
    public boolean mainMenu() {
        //Prints the menu options, and takes the input from the user
        System.out.println("Welcome to the Card Game game");
        System.out.println("You have " + scoreboard.getTokens() + " tokens");
        System.out.println("What do you want to do?");
        System.out.println("1. Play a game");
        System.out.println("2. Buy Tokens");
        System.out.println("3. View Scores");
        System.out.println("0. Quit");
        String input = sc.nextLine();

        //Calls different methods depending on user input
        if (input.equals("1") || input.equalsIgnoreCase("p") || input.toLowerCase().contains("play") || input.toLowerCase().contains("game")) {
            if (scoreboard.getTokens() == 0) {
                System.out.println("You don't have any tokens!");
            }
            else {
                gameSelection();
            }
        }
        
        else if ((input.equals("2") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("t") || input.toLowerCase().contains("buy") || input.toLowerCase().contains("token"))) {
            scoreboard.addTokens(buyTokens());
        }
        
        else if (input.equals("3") || input.equalsIgnoreCase("v") || input.equalsIgnoreCase("s") || input.toLowerCase().contains("view") || input.toLowerCase().contains("scores")) {
            System.out.println(scoreboard.showAllScores());
        }
        else if (input.equals("0") || input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
            System.out.println("You ended up with " + scoreboard.getTokens() + " tokens (" + (scoreboard.getTokenValue()) + "kr)");
            System.out.println("We hope to see you again!");
            return false;
        }
        else {
            System.out.println("Invalid input\n");
        }
        return true;
    }
    
    private boolean gameSelection() {
        while (true){
            System.out.println("What game do you want to play?");
            System.out.println("1. Blackjack");
            System.out.println("2. HiLo");
            System.out.println("0. Back to menu");
            String input = sc.nextLine();

            //creates the game depending on input, and calls the start method for the game
            if (input.equals("1") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("bj") || input.equalsIgnoreCase("blackjack")) {
                game = new Blackjack(scoreboard);
                return game.start();
            }
            else if (input.equals("2") || input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hl") || input.equalsIgnoreCase("hilo")) {
                game = new HiLo(scoreboard);
                return game.start();

            }
            else if (input.equals("0") || input.equalsIgnoreCase("b") || input.equalsIgnoreCase("back") || input.equalsIgnoreCase("menu")) {
                System.out.println("Returning to main menu\n");
                return false;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }
    
    private int buyTokens(){
        while (true) {
            //Currently just has tokens of an arbitrary value, but functionality exists for eventual future expansion
            System.out.println("Each token has a value of 50kr.");
            System.out.print("How many tokens do you want to purchase?: ");
            String input = sc.nextLine();
            try {
                int amount = Integer.parseInt(input);
                if (input.equals("0") || input.equalsIgnoreCase("back") || input.equalsIgnoreCase("exit")) {
                    System.out.println("Returning to main menu\n");
                    return 0;
                }
                else if ((amount) > 0) {
                    System.out.println("You have bought " + input + " tokens for " + amount*50 + "kr\n");
                    return amount;
                }
            } catch (java.lang.NumberFormatException e) {
            }
            System.out.println("Invalid input\n");
        }
    }
}
