import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by sahar.shukrun on 3/4/2018.
 */
public class DeckOfCards {
    final static int DECK_SIZE = 52;
    private ArrayList<Card> deck = new ArrayList<>();

    public DeckOfCards() {
        // Initialize cards
        for (int i = 0; i < DECK_SIZE; i++) {
            // This is logic of card representation
            // ex: 13%13+1 = 1 1 is Ace 13/13+1 = 2 this is CLUBS
            deck.add(new Card(i%13+1,(i/13)+1));
        }

        shuffleDeck();

    }

    public DeckOfCards(boolean isEmpty) {
        // create empty deck
        if(!isEmpty) {
            for (int i = 0; i < DECK_SIZE; i++) {
                deck.add(new Card(i%13+1,(i/13)+1));
            }

            shuffleDeck();
        }
    }

    public void shuffleDeck() {
        for (int i = 0 ; i < deck.size(); i++) {
            // Generate an index randomly
            int index = (int)(Math.random() * deck.size());
            Card temp = deck.get(i);
            deck.set(i,deck.get(index));
            deck.set(index, temp);
        }
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> splitDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (int i = 0; i < DECK_SIZE/2; i++) {
            deck.add(this.deck.remove(0));
        }
        return deck;
    }

    public void addCard(Card c) {
        this.deck.add(c);
    }

    public Card getCard() {
        Card c = null;
        if (deck.size() != 0) {
            c = deck.remove(0);
        }
        return c;
    }

    public void addDeckToDeck(DeckOfCards d) {
        int size = d.getDeck().size();
        for (int i = 0; i < size; i++) {
            this.addCard(d.getDeck().remove(0));
        }
    }
}
