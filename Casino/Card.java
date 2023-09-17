import java.util.ArrayList;

public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public String getCard() {
        String s = "";
        if (this.number < 11) {
            s = number + " of " + suit;
        }
        if (this.number == 11) {
            s = "Jack of " + this.suit;
        }
        else if (this.number == 12) {
            s = "Queen of " + this.suit;
        }
        else if (this.number == 13) {
            s = "King of " + this.suit;
        }
        else if (this.number == 14) {
            s = "Ace of " + this.suit;
        }
        return s;

    }

    public String getSuit() {
        return this.suit;
    }


    public int getNumber() {
        return this.number;
    }

    public static ArrayList<Card> makeDeck() {
        //Card[] deck = new String[52];.
        String[] suitArray = {"Spades", "Hearts", "Clubs", "Diamonds"};
        int[] numArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; //jack = 11, queen = 12, king = 13, ace = 14
        ArrayList<Card> deck = new ArrayList<>();

        for (int i = 0; i < suitArray.length; i++) {
            for (int j = 0; j < numArray.length; j++) {
                deck.add(new Card(numArray[j], suitArray[i]));

            }//end of j loop
        }//end of i loop
        return deck;
    }



}