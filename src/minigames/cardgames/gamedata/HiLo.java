package minigames.cardgames.gamedata;

import minigames.cardgames.carddata.Card;
import minigames.cardgames.carddata.Deck;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */

public class HiLo extends CardGame{
    
    public HiLo(Scoreboard scoreboard) {
        super(scoreboard);
    }
    
    //Method defining the game of HiLo
    @Override
    protected boolean play(int bet) {
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> cards = new ArrayList<>();
        int streak = 0;
        int cardNumber = 0;
        int tokens = bet;
        boolean loop = true;
        while (loop) {
            cards.add(deck.draw());
            System.out.println("\nThe card is the " + cards.get(cardNumber));
            System.out.println("Do you think will be Higher(1) or Lower(2)");
            boolean higherGuess = validHiLoInput();
            cards.add(deck.draw());
            cardNumber++;
            if (cards.get(cardNumber-1).getValue() == cards.get(cardNumber).getValue()) {
                
                System.out.println(cards.get(cardNumber) + "The card has the same value, drawing new card:");
            }
            else if ((cards.get(cardNumber-1).getValue() < cards.get(cardNumber).getValue() && higherGuess) || (cards.get(cardNumber-1).getValue() > cards.get(cardNumber).getValue() && !higherGuess)) {
                tokens = tokens*2;
                streak++;
                //Shuffles the deck if all the cards have been on the table
                if (deck.getDeckSize()==0) {
                    System.out.println("You correctly guessed every single card, preparing new deck");
                    deck.shuffleAll();
                }
                System.out.println(cards.get(cardNumber) + "\nYou are correct!");
                boolean repeatLoop = true;
                while (repeatLoop) {
                    System.out.println("Current win streak: " + streak + "\nDo you want to double up your current winnings of " + tokens + " tokens?");
                    System.out.print("(y/n): ");
                    String input = sc.nextLine();
                    if (input.equals("1") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
                        repeatLoop = false;
                    }
                    else if (input.equals("2") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
                        scoreboard.addNewHiLoScore(bet, streak, true);
                        return repeatCheck(scoreboard.getTokens());
                    }
                    else {
                        System.out.println("invalid input");
                    }
                }
            }
            else if ((cards.get(cardNumber-1).getValue() < cards.get(cardNumber).getValue() && !higherGuess) || (cards.get(cardNumber-1).getValue() > cards.get(cardNumber).getValue() && higherGuess)) {
                System.out.println(cards.get(cardNumber) + "\nThe card was lower, you lost");
                scoreboard.addNewHiLoScore(bet, streak, false);
                return repeatCheck(scoreboard.getTokens());
            }
            else {
                System.out.println("Unexpected Error");
            } 
        }
        return true;
    }
    
    //Defines a separate method to check for valid input during the game, for simplicity
    private boolean validHiLoInput() {
        while (true) {
            String input = sc.nextLine();
            if (input.equals("1") || input.equalsIgnoreCase("h") || input.equalsIgnoreCase("high") || input.equalsIgnoreCase("higher")) {
                return true;
            }
            else if (input.equals("2") || input.equalsIgnoreCase("l") || input.equalsIgnoreCase("low") || input.equalsIgnoreCase("lower")) {
                return false;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }
    
    @Override
    public void rules() {
        System.out.println("HiLo is a simple game where you have to guess if the next card drawn will be higher or lower than the previous one.");
        System.out.println("If you guess correctly, you get double your bet in winnings, but you can also choose to bet it all on the next card.");
        System.out.println("The deck is shuffled between games, or after guessing every card in the deck correctly");
    }
    
    @Override
    public void localScoreboard() {
        if (scoreboard.getHiLoList().isEmpty()) {
            System.out.println("You have not played yet!");
        }
        else {
            System.out.println(scoreboard.getHiLoScores());
        }
    }
    
    @Override
    public String toString() {
        return "HiLo";
    }
}
