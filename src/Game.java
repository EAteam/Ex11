import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by sahar.shukrun on 2/13/2018.
 */
public class Game extends JPanel{

    DeckOfCards gameDeck = null;
    DeckOfCards player1 = null;
    DeckOfCards player1Deck = null;
    DeckOfCards player2 = null;
    DeckOfCards player2Deck = null;

    public Game() {
        DeckOfCards d = new DeckOfCards();
        player1Deck.setDeck(d.splitDeck());
        player2Deck.setDeck(d.getDeck());
    }


    public static void main(String [] args) throws IOException {
        DeckOfCards d = new DeckOfCards();
    }


}

