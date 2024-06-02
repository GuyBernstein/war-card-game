// Created by Guy Bernstein
// i.d 206558439
// question1 in the maman 11
// Represents the game logic for a simple war card game.
import javax.swing.*;

public class WarGame {
    private static final int NUMBER_OF_DRAW_CARDS = 3; // Number of cards drawn in a tie situation
    private static final int NUMBER_OF_CARDS = 52; // Total number of cards to play with

    // Conducts a single round of the game between two players.
    public static void playRound(Player playerOne, Player playerTwo) {
        // Each player deals one card
        Card cardOne = playerOne.dealCard();
        Card cardTwo = playerTwo.dealCard();
        // Temporary deck to hold cards during the round
        DeckOfCards roundCards = new DeckOfCards(false);
        roundCards.receiveCard(cardOne);
        roundCards.receiveCard(cardTwo);
        // Determines the winner of the round or handles a tie
        compareAndAward(playerOne, playerTwo, cardOne, cardTwo, roundCards);
    }
    // Compares the cards of two players to determine the winner of the round.
    public static void compareAndAward(Player playerOne, Player playerTwo, Card cardOne, Card cardTwo, DeckOfCards roundCards) {
        // Compare cards; player with higher card wins the round
        if (cardOne.compareTo(cardTwo) > 0) {
            JOptionPane.showMessageDialog(null, "Player One wins the round with " + cardOne + " against " + cardTwo);
            // Winner takes all cards
            playerOne.receiveCards(roundCards);
        } else if (cardOne.compareTo(cardTwo) < 0) {
            JOptionPane.showMessageDialog(null, "Player Two wins the round with " + cardTwo + " against " + cardOne);
            // Winner takes all cards
            playerTwo.receiveCards(roundCards);
        } else {
            // If the cards are of equal value, proceed to draw additional cards
            handleDraw(playerOne, playerTwo, roundCards);
        }
        // Clear the temporary deck after the round
        roundCards.clearDeck();
    }
    // Handles the situation when players draw cards of equal value.
    public static void handleDraw(Player playerOne, Player playerTwo, DeckOfCards roundCards)
    {
        int i;//index for dealing cards NUMBER_OF_DRAW_CARDS times from the players
        JOptionPane.showMessageDialog(null, "Draw! Drawing 3 more cards each...");

        if (!playerOne.hasCards() && !playerTwo.hasCards())//no more cards for each player
            return;//the game is over, we return to main function to declare draw

        // Draw additional cards to break the tie
        for (i = 0; i < NUMBER_OF_DRAW_CARDS && playerOne.hasCards() && playerTwo.hasCards(); i++) {//deal NUMBER_OF_DRAW_CARDS cards
            roundCards.receiveCard(playerOne.dealCard());
            roundCards.receiveCard(playerTwo.dealCard());
        }
        Card lastCardOne = roundCards.getCardIndexOf(roundCards.deckSize() - 2); // Second last card is the last drawn card for player one
        Card lastCardTwo = roundCards.getCardIndexOf(roundCards.deckSize() - 1); // Last card is the last drawn card for player two

        //we check if i != NUMBER_OF_DRAW_CARDS to see if there has been problem dealing cards from each player NUMBER_OF_DRAW_CARDS times
        if(i != NUMBER_OF_DRAW_CARDS) {
            if (!playerOne.hasCards() && playerTwo.hasCards()) {//player one ran out of cards
                roundCards.receiveCard(playerTwo.dealCard());//deal card form player two
                lastCardTwo = roundCards.getCardIndexOf(roundCards.deckSize() - 1); // Last card is the last drawn card for player two
            } else if (!playerTwo.hasCards() && playerOne.hasCards()) {//player two ran out of cards
                roundCards.receiveCard(playerOne.dealCard());//deal card form player one
                lastCardOne = roundCards.getCardIndexOf(roundCards.deckSize() - 1); // Last card is the last drawn card for player One

            }
        }

        compareAndAward(playerOne, playerTwo, lastCardOne, lastCardTwo, roundCards);//compare for the next cards
    }
    // Main method to execute the game.
    public static void main(String[] args)
    {
        //save each player deck size to determine winner if the game settles
        int deckSizePlayerOne;
        int deckSizePlayerTwo;

        // Initialize a new deck and shuffle it
        DeckOfCards deck = new DeckOfCards(true);
        deck.shuffle();

        // Split the deck between two players
        Player playerOne = new Player(new DeckOfCards(false), "Playing");
        Player playerTwo = new Player(new DeckOfCards(false), "Playing");
        for (int i = 0; i < NUMBER_OF_CARDS / 2; i++) {
            playerOne.receiveCard(deck.dealCard());
            playerTwo.receiveCard(deck.dealCard());
        }
        // Start the game and announce the start
        JOptionPane.showMessageDialog(null,"Welcome to War Game");



        // Continue rounds until one player wins, or it's a draw
        while (playerOne.hasCards() && playerTwo.hasCards()) {
            int choice = JOptionPane.showConfirmDialog(null, "Next card");
            if (choice == JOptionPane.OK_OPTION) {
                playRound(playerOne, playerTwo);
            } else {
                break; // Exit the game if user chooses not to continue, or the game has settled
            }
        }
        //gets the deck sized from each player
        deckSizePlayerOne = playerOne.getDeckSize();
        deckSizePlayerTwo = playerTwo.getDeckSize();
        // Determine and display the final winner or a draw
        if (deckSizePlayerOne > deckSizePlayerTwo) {//player one wins
            playerOne.setStatus("Won");
            playerTwo.setStatus("Lose");
            JOptionPane.showMessageDialog(null, "Player One wins the game! with " + deckSizePlayerOne +" against " + deckSizePlayerTwo);
        } else if (deckSizePlayerOne < deckSizePlayerTwo) {//player two wins
            playerOne.setStatus("Lose");
            playerTwo.setStatus("Won");
            JOptionPane.showMessageDialog(null, "Player Two wins the game! with " + deckSizePlayerTwo +" against " + deckSizePlayerOne);
        } else {// a draw
            playerOne.setStatus("Draw");
            playerTwo.setStatus("Draw");
            JOptionPane.showMessageDialog(null, "The game is a draw!");
        }
    }

}
