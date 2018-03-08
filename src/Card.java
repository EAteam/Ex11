import java.util.HashMap;
import java.util.Map;

/**
 * Created by sahar.shukrun on 3/4/2018.
 */
public class Card implements Comparable<Card>{
    private final int rank;
    private final int suit;

    public enum META_RANK {
        ACE(1), DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);

        private final int value;

        private static final Map lookup = new HashMap();

        static {
            //Create reverse lookup hash map
            for(META_RANK d : META_RANK.values()) {
                lookup.put(d.getValue(), d);
            }
        }

        META_RANK(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static META_RANK get(int value) {
            //the reverse lookup by simply getting
            //the value from the lookup HsahMap.
            return (Card.META_RANK)lookup.get(value);
        }
    }

    public enum META_SUIT {
        DIAMONDS(1), CLUBS(2), HEARTS(3),SPADES(4);

        private final int value;

        private static final Map lookup = new HashMap();

        static {
            //Create reverse lookup hash map
            for(META_SUIT d : META_SUIT.values()) {
                lookup.put(d.getValue(), d);
            }
        }

        META_SUIT(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static META_SUIT get(int value) {
            //the reverse lookup by simply getting
            //the value from the lookup HsahMap.
            return (Card.META_SUIT)lookup.get(value);
        }
    }

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
        return (META_SUIT.get(suit)).name();
    }

    public int getRank() {
        if (rank == 1) {
            return 14;
        }
        return rank;
    }

    public String getRankString(){
        return (META_RANK.get(rank)).name();
    }

    public static boolean isValidRank(int rank) {
        return META_RANK.ACE.getValue() <= rank && rank <= META_RANK.KING.getValue();
    }

    public static boolean isValidSuit(int suit) {
        return META_SUIT.DIAMONDS.getValue() <= suit && suit <= META_SUIT.SPADES.getValue();
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


