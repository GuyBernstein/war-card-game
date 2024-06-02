
import java.util.Arrays;
import java.util.List;
// Represents a single playing card with a face and suit.
public class Card implements Comparable<Card> {
    //list of the possible card values
    private static final List<String> FACES = Arrays.asList(
            "Deuce", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
    );
    private final String face; // face of card ("Ace", "Deuce",...)
    private final String suit; // suit of card ("Hearts", "Diamonds",...)

    // two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    // return String representation of Card
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public int compareTo(Card other) {
        return Integer.compare(FACES.indexOf(this.face), FACES.indexOf(other.face));
    }


}
