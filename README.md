# War Card Game

This is a simple implementation of the classic card game "War" using Java. The game is played between two players, each dealing cards from their own deck. The player with the higher card value wins the round and takes all the cards played in that round. In case of a tie, additional cards are drawn until a winner is determined.

## How to Play

1. Clone the repository to your local machine.
2. Compile the Java files using a Java compiler.
3. Run the `WarGame` class to start the game.
4. Follow the on-screen prompts to play the game.

## Game Rules

- The game is played with a standard deck of 52 cards.
- The deck is shuffled and divided evenly between the two players.
- In each round, both players deal one card from their deck.
- The player with the higher card value wins the round and takes all the cards played in that round.
- If the dealt cards have the same value, each player draws three additional cards, and the value of the last drawn card determines the winner of the round.
- The game continues until one player runs out of cards or chooses to quit.
- The player with the most cards at the end of the game is declared the winner.

## Classes

- `Card`: Represents a single playing card with a face and suit.
- `DeckOfCards`: Represents a deck of playing cards.
- `Player`: Represents a player in the card game, holding a deck and maintaining game status.
- `WarGame`: Contains the main game logic and controls the flow of the game.

## Possible Future Enhancements

- Implement a graphical user interface (GUI) for a more interactive gaming experience.
- Add sound effects and visual animations to enhance the gameplay.
- Introduce a scoring system to keep track of multiple rounds.
- Allow customization of game rules and options.

Feel free to contribute to the project by submitting pull requests or reporting issues on the GitHub repository.
