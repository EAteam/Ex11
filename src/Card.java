import java.util.HashMap;
import java.util.Map;

/**
 * Created by John Smith on 3/4/2018.
 */
public class Card implements Comparable<Card>{
    private final int rank;
    private final int suit;

    private static final String[] ranks = {"ACE", "DEUCE", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    private static final String[] suits = {"HEART", "DIAMOND", "CLUB", "SPADE"};

    public Card(int rank, int suit) {
        assert isValidRank(rank);
        assert isValidSuit(suit);
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public String getSuitString(){
        return suits[suit];
    }

    public int getRank() {
        if (rank == 0) { // Ace
            return 13;
        }
        return rank;
    }

    public String getRankString(){
        return ranks[rank];
    }

    public static boolean isValidRank(int rank) {
        return 0 <= rank && rank <=13;
    }

    public static boolean isValidSuit(int suit) {
        return 0 <= suit && suit <= 4;
    }

    public static void main(String [] args) {
        Card c = new Card(2,2);
        System.out.println(c.getRankString()+"  "+c.getSuitString());
    }

    public int compareTo(Card c) {
        if (this.getRank() == c.getRank()) {
            return 0;
        } else if (this.getRank() > c.getRank()) {
            return 1;
        } else {
            return -1;
        }
    }
}


