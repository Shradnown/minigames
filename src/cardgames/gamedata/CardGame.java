package cardgames.gamedata;

import java.util.Scanner;

/**
 *
 * @author Erik
 */
public abstract class CardGame {
    protected final Scoreboard scoreboard;
    protected final Scanner sc;
    
    public CardGame(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
        sc = new Scanner(System.in);
    }
    
    //Creates a common start method (menu) for all card games
    public boolean start() {
        System.out.println("\nWelcome to " + this.toString() + "!");
        boolean loop = true;
        while (loop) {
            int tokens = scoreboard.getTokens();
            
            if (tokens == 0) {
                System.out.println("You have no tokens, so you can't play this game\nReturning to Card Game menu\n");
                return false;
            }
            
            System.out.println("You have " + tokens + " tokens");
            System.out.println("What would you like to do?");
            System.out.println("1. Play");
            System.out.println("2. Read the rules");
            System.out.println("3. View current scores");
            System.out.println("0. Quit");
            String input = sc.nextLine();
            
            if (input.equals("1") || input.equalsIgnoreCase("p") || input.equalsIgnoreCase("play")) {
                boolean betLoop = true;
                while (betLoop) {
                    System.out.println("How many tokens do you want to bet?");
                    input = sc.nextLine();
                    try {
                        int bet = Integer.parseInt(input);
                        if (bet <= tokens && bet > 0) {
                            scoreboard.betTokens(bet);
                            betLoop = play(bet);
                        } else if (bet > tokens) {
                            System.out.println("You don't have enough tokens for that bet");
                        } else if (bet == 0) {
                            System.out.println("Returning to menu");
                            betLoop = false;
                        } else {
                            System.out.println("Invalid input");
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Invalid input");
                    }
                }
            }
            else if (input.equals("2") || input.equalsIgnoreCase("r") || input.equalsIgnoreCase("read") || input.equalsIgnoreCase("rules") || input.equalsIgnoreCase("read rules") || input.equalsIgnoreCase("read the rules")) {
                rules();
            }
            else if (input.equals("3") || input.equalsIgnoreCase("v") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("view") || input.equalsIgnoreCase("view scores") || input.equalsIgnoreCase("view current scores") || input.equalsIgnoreCase("current scores") || input.equalsIgnoreCase("scores")) {
                localScoreboard();
            }
            else if (input.equals("0") || input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                System.out.println("Returning to the Card Game menu\n");
                loop = false;
            }
            else {
                System.out.println("invalid input");
            }
        }
        return true;
    
    }
    
    protected abstract boolean play(int bet);
    
    protected boolean repeatCheck(int tokens) {
        if (tokens == 0) {
            System.out.println();
            return false;
        }
        else {
            while (true) {
                System.out.print("Do you want to play again? (y/n): ");
                String input = sc.nextLine();
                if (input.equals("1") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                    System.out.println("\nYou have " + tokens + " tokens");
                    return true;
                }
                else if (input.equals("2") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                    System.out.println("");
                    return false;
                }
                else {
                    System.out.println("Invalid input");
                }
            }
        }
    }
    
    public abstract void rules();
    
    public abstract void localScoreboard();
    
    @Override
    public abstract String toString();
}
