import java.util.ArrayList;

/**
 * Created by sahar.shukrun on 3/4/2018.
 */
public class War {
    DeckOfCards gameDeck = null;
    DeckOfCards player1 = null;
    DeckOfCards player1Deck = null;
    DeckOfCards player2 = null;
    DeckOfCards player2Deck = null;


    // Crate new shuffle deck and split
    public War() {
        gameDeck = new DeckOfCards(true);
        DeckOfCards d = new DeckOfCards();
        player1 = new DeckOfCards(true);
        player1Deck = new DeckOfCards(true);
        player2 = new DeckOfCards(true);
        player2Deck = new DeckOfCards(true);

        player1Deck.setDeck(d.splitDeck());
        player2Deck.setDeck(d.getDeck());
    }

    public static boolean checkAndUpdateDecks (DeckOfCards d1, DeckOfCards d2) {
        if (d1.getDeck().size() == 0) {
            if (d2.getDeck().size() == 0) {
                return false;
            }
            d2.shuffleDeck();
            d1.addDeckToDeck(d2); //
        }
        return true;
    }

    public static void main(String [] args) {
        War game = new War();
        int state = 0;
        int counter = 0;
        while (true) {

            // Validity check
            if (false == checkAndUpdateDecks(game.player1Deck, game.player1)) {
                System.out.println("Player 1 lose | Player 2 win");
                break;
            }
            if ( false == checkAndUpdateDecks(game.player2Deck, game.player2)) {
                System.out.println("Player 1 win | Player 2 lose");
                break;
            }

            // Here the assumption is that we have one card at least.
            Card p1  = game.player1Deck.getCard();
            Card p2 = game.player2Deck.getCard();

            if (state == 1 && counter > 0) {
                counter --;
                game.gameDeck.addCard(p1);
                game.gameDeck.addCard(p2);
                continue;
            }
            //System.out.println(p1.getRank()+" vs "+ p2.getRank());
            int res = p1.compareTo(p2);
            switch (res) {
                case 0:
                    state = 1; // war state
                    System.out.println("Draw");
                    game.gameDeck.addCard(p1);
                    game.gameDeck.addCard(p2);
                    counter = 3;
                    break;
                case 1:
                    state = 0;
                    System.out.println("P1 get cards");
                    game.player1.addCard(p1);
                    game.player1.addCard(p2);
                    if (state == 1) {
                        game.player1.addDeckToDeck(game.gameDeck);
                    }
                    break;
                case -1:
                    state = 0;
                    System.out.println("P2 get cards");
                    game.player2.addCard(p1);
                    game.player2.addCard(p2);
                    if (state == 1) {
                        game.player2.addDeckToDeck(game.gameDeck);
                    }
                    break;
                default:
                    break;
            }

        }
    }
}
