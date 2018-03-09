package cardgames.gamedata;

import cardgames.carddata.*;
import java.util.ArrayList;

/**
 *
 * @author Erik
 */

public class Blackjack extends CardGame{
    
    public Blackjack(Scoreboard scoreboard) {
        super(scoreboard);
    }
    
    //method defining the game of Blackjack
    @Override
    protected boolean play(int bet) {
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> player = new ArrayList<>();
        ArrayList<Card> dealer = new ArrayList<>();
        dealer.add(deck.draw());
        player.addAll(deck.draw(2));
        boolean loop = true;
        while (loop) {
            System.out.println("Dealers card: " + dealer);
            System.out.println("Your hand: " + player);
            System.out.println("Your total value: " + printValues(player));
            if (values(player)> 21) {
                System.out.println("You bust, you lose!");
                scoreboard.addNewBlackjackScore(bet, values(dealer), values(player), -1);
                return repeatCheck(scoreboard.getTokens());
            }
            else {
                System.out.println("What do you want to do?");
                System.out.println("1. Hit\n2. Stand");
                String input = sc.nextLine();

                if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("h") || input.equalsIgnoreCase("hit")) {
                    player.add(deck.draw());
                }
                else if (input.equalsIgnoreCase("2") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("stand")) {
                    loop = false;
                }
                else {
                    System.out.println("Invalid input");
                }
            }
        }
        dealer.add(deck.draw());
        boolean dealerLoop = true;
        while (dealerLoop) {
            if (values(dealer)< 17) {
                dealer.add(deck.draw());
            }
            else {
                dealerLoop = false;
            }
        }
        System.out.println("Dealers hand: " + dealer);
        System.out.println("Your hand: " + player);
        
        int playerScore = values(player);
        int dealerScore = values(dealer);
        int result = 1;
        
        if (playerScore == dealerScore) {
            System.out.println("It's a draw, both you and the dealer had " + playerScore);
            result = 1;
        }
        else if (playerScore == 21 && dealerScore != 21) {
            System.out.println("Blackjack, You win!");
            result = 3;
        }
        else if (dealerScore > 21) {
            System.out.println("Dealer bust with " + dealerScore + ", you win!");
            result = 2;
        }
        else if (playerScore > dealerScore) {
            System.out.println("You win! Your total value was: " + playerScore + ", and the dealer had " + dealerScore);
            result = 2;
        }
        else if (playerScore < dealerScore) {
            System.out.println("You lost! Your total value was: " + playerScore + ", and the dealer had " + dealerScore);
            result = 0;
        }
        scoreboard.addNewBlackjackScore(bet, dealerScore, playerScore, result);
        return repeatCheck(scoreboard.getTokens());
    }
    
    //Method calculating the numerical value of the cards in a "hand"
    private int values(ArrayList<Card> cards) {
        int values = 0;
        boolean soft = false;
        for (Card nextCard : cards) {
            values += nextCard.getBJValue();
            if (nextCard.getRank().equals(Rank.ACE) && values <= 11) {
                soft = true;
            }
        }
        if (soft && values <=11) {
            values += 10;
        }
        return values;
    }
    
    //Returns a string with the numerical value of the cards of a hand, including the "soft" tag from an Ace 
    private String printValues(ArrayList<Card> cards) {
        int values = 0;
        boolean soft = false;
        StringBuilder sb = new StringBuilder();
        for (Card nextCard : cards) {
            values += nextCard.getBJValue();
            if (nextCard.getRank().equals(Rank.ACE) && values <= 11) {
                soft = true;
            }
        }
        
        if (soft && values <= 11) {
            values += 10;
            sb.append(values);
            sb.append(" (soft)");
        }
        else {
            sb.append(values);
        }
        return sb.toString();
    }
    
    @Override
    public void rules() {
        System.out.println("The goal of Blackjack is to have a better hand than the dealer.");
        System.out.println("The best hand is a hand with a total value as close to, but not over 21.");
        System.out.println("The Jack, Queen, and King, all have a value of 10, and an Ace has a value of either 1 or 11");
        System.out.println("(it will always be 1 if 11 would make the total value of the hand over 21).");
        System.out.println("You first get dealt 2 cards, and the dealer will be dealt 1 card that you can see,");
        System.out.println("you can then choose to \"hit\", and draw another card, or \"stand\" to let the dealer draw cards to try to beat you.");
        System.out.println("Winning gives you 2 times your bet in winnings, unless you get a \"Blackjack\", which gives you a 3 times payout!");
    }
    
    @Override
    public void localScoreboard() {
        if (scoreboard.getBlackjackList().isEmpty()) {
            System.out.println("You have not played yet!");
        }
        else {
            System.out.println(scoreboard.getBlackJackScores());
        }
    }
    
    @Override
    public String toString() {
        return "Blackjack";
    }
}
