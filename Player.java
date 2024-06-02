// Represents a player in the card game, holding a deck and maintaining game status.
public class Player {
    private  DeckOfCards playerDeck;// player's deck of cards
    private  String status;// current game status of the player
    // Constructor initializes the player with a deck and status.
    public Player(DeckOfCards deck, String gameStatus)
    {
        this.playerDeck = deck;
        this.status = gameStatus;
    }
    // Sets the player's game status.
    public void setStatus(String gameStatus)
    {
        status = gameStatus;
    }

    // Checks if the player has cards left in their deck.
    public boolean hasCards() {
        return !playerDeck.isEmpty();
    }
    // Gets the number of cards in the player's deck
    public int getDeckSize() {
        return playerDeck.deckSize();
    }
    // Deals a card from the player's deck.
    public Card dealCard() {
        return playerDeck.dealCard();
    }

    // Receives a card into the player's deck.
    public void receiveCard(Card card) {
        playerDeck.receiveCard(card);
    }
    // Receives multiple cards into the player's deck.
    public void receiveCards(DeckOfCards newCards) {
        while(!newCards.isEmpty()){
            Card card = newCards.dealCard();
            playerDeck.receiveCard(card);

        }
    }

}
