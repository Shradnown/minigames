package minigames.cardgames.carddata;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Erik
 */

public class Deck {
    /*Defines the actual deck of the deck, along with a discard pile connected to the deck,
    and a "missingDeck" that contains cards not currently in the deck nor in the discard pile, for future functionality*/
    private static ArrayList<Card> cardDeck = new ArrayList<>();
    private static ArrayList<Card> missingDeck = new ArrayList<>();
    private static ArrayList<Card> discardPile = new ArrayList<>();
    
    
    public Deck() {
        cardDeck = Card.createDeck();
    }
    
    //Defines a method to completely reset the deck
    public void reset() {
        cardDeck.clear();
        missingDeck.clear();
        discardPile.clear();
        cardDeck = Card.createDeck();
    }
    
    //Method to collect all the cards not currently in the deck nor in the discard pile and adds them to the bottom of the deck in the order they were taken out
    public void returnAllToDeck() {
        cardDeck.addAll(missingDeck);
        missingDeck.clear();
    }
    
    //Method that puts the cards in the discard pile at the bottom of the deck
    public void discardPileToDeck() {
        cardDeck.addAll(discardPile);
        discardPile.clear();
        missingDeck.removeAll(discardPile);
        
    }
    
    //Method to discard a card not currently in the deck to the discard pile
    public void discard(Card card) {
        discardPile.add(card);
        missingDeck.remove(card);
    }
    
    //Method to discard multiple cards not currently in the deck to the discard pile
    public void discard(ArrayList<Card> cards) {
        discardPile.addAll(cards);
        missingDeck.removeAll(cards);
    }
    
    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }
    
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }
    
    //Method to reset the deck and then shuffle it
    public void shuffleAll() {
        reset();
        shuffle();
    }
    
    //Method to draw the card at the "top" of the deck
    public Card draw() {
        Card drawnCard = cardDeck.get(0);
        missingDeck.add(cardDeck.get(0));
        cardDeck.remove(0);
        return drawnCard;
    }
    
    //Method to draw multiple cards from the "top" of the deck
    public ArrayList<Card> draw(int amount) {
        ArrayList<Card> drawList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            drawList.add(cardDeck.get(0));
            missingDeck.add(cardDeck.get(0));
            cardDeck.remove(0);
        }
        return drawList;
    }
    
    public int getDeckSize() {
        return cardDeck.size();
    }
    
    @Override
    public String toString() {
        return cardDeck.toString();
    }
    
}
