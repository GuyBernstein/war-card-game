// DeckOfCards class represents a deck of playing cards.

import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Collections;

public class DeckOfCards {
    // random number generator
    private static final SecureRandom randomNumbers = new SecureRandom();
    private static final int NUMBER_OF_CARDS = 52; // constant # of Cards
    private ArrayList<Card> deck;// stores the cards



    // Constructor to fill the deck with cards if populate is true.
    public DeckOfCards(boolean populate) {
        deck = new ArrayList<>();// Card references
        if (populate == true) {
            String[] faces = {"Ace", "Deuce", "Three", "fore", "five", "six",
                    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
            String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

            // populate deck with Card objects
            for (int count = 0; count < NUMBER_OF_CARDS; count++)
                deck.add(new Card(faces[count % 13], suits[count / 13]));
        }

    }


    // Shuffles the deck using Collections.shuffle.
    public void shuffle() {
        Collections.shuffle(deck,new SecureRandom());
    }
    // Deals and returns the top card of the deck, or null if empty
    public Card dealCard()
    {
        return deck.isEmpty() ? null : deck.remove(0);
    }
    // Adds a card to the deck.
    public void receiveCard(Card card)
    {
        deck.add(card);
    }
    // Checks if the deck is empty.
    public boolean isEmpty()
    {
        return deck.isEmpty()? true: false;
    }
    // Returns the number of cards in the deck.
    public int deckSize(){
        return deck.size();
    }

    // Retrieves a card at a specific index in the deck.
    public Card getCardIndexOf(int index) {
        return deck.get(index);
    }
    // Clears all cards from the deck.
    public void clearDeck(){
        deck.clear();
    }
}
