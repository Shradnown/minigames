package minigames.cardgames.carddata;

import java.util.ArrayList;

/**
 *
 * @author Erik
 */

public class Card {
    //Defines cards as having a rank and a suit
    private final Rank rank;
    private final Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    //Defines methods to get the numerical value of a card
    public int getValue() {
        return rank.value();
    }
    
    public int getBJValue() {
        if (getValue() > 10) {
            return 10;
        }
        else {
            return getValue();
        }
    }
    
    //Overrides the toString method to make cards print nicely
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
    
    //creates a method that makes an arraylist with one copy of each type of card (a standard 52 card deck)
    protected static ArrayList<Card> createDeck() {
        ArrayList<Card> cardDeck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(rank, suit));
            }
        }
        return cardDeck;
    }
    
    
    
    /*
    private static ArrayList<Card> cardDeck = new ArrayList<Card>();
    
    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cardDeck.add(new Card(rank, suit));
            }
        }      
    }

    public static ArrayList<Card> newDeck() {
        return new ArrayList<Card>(cardDeck); // Return copy of prototype deck
    }
    */
}
