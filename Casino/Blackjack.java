import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Homework 1 Walkthrough
 * <p>
 * brief description of the program
 *
 * @author Rohini Pillai, L11
 * @version MM/DD/YYYY (date of completion)
 * <p>
 * Sources: {TA Names}
 */
public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!\n");
        Scanner scanner = new Scanner(System.in);
        int dealerValue = 0;  //value of the dealer's card
        int playerValue = 0;  //value of the player's card
        ArrayList<Card> dealerCards = new ArrayList<Card>(); //all the cards the dealer has
        ArrayList<Card> playerCards = new ArrayList<Card>(); //all the cards the player has
        ArrayList<Card> deck = new ArrayList<Card>(); //the deck
        deck = Card.makeDeck();
        Collections.shuffle(deck); //the shuffled deck

        /*\for (int i=0; i<=deck.size()-1; i++){
            System.out.println(deck.get(i).getCard());
        } //checks to see if all cards are printed in deck */

        dealerCards.add(deck.remove(0));
        if (dealerCards.get(0).getNumber() == 14) {
            dealerValue += 11;
        } else if (dealerCards.get(0).getNumber() == 13 || dealerCards.get(0).getNumber() == 12 || dealerCards.get(0).getNumber() == 11) {
            dealerValue += 10;
        } else {
            dealerValue += dealerCards.get(0).getNumber();
        }

        boolean cont = true;
        while (cont) {
            playerCards.add(deck.remove(0));
            if (playerCards.get(playerCards.size() - 1).getNumber() == 14) {
                playerValue += 11;
            } else if (playerCards.get(playerCards.size() - 1).getNumber() == 13 || playerCards.get(playerCards.size() - 1).getNumber() == 12 || playerCards.get(playerCards.size() - 1).getNumber() == 11) {
                playerValue += 10;
            } else {
                playerValue += playerCards.get(playerCards.size() - 1).getNumber();
            }

            System.out.println("Dealer's hand: " + dealerCards.get(0).getCard());
            System.out.println("Value of dealer's hand: " + dealerValue + "\n");

            System.out.println("Player's hand: " + playerCards.get(playerCards.size() - 1).getCard());
            System.out.println("Value of player's hand: " + playerValue + "\n");

            if (playerValue == 21) {
                System.out.println("You reached 21 points. You win!");
                System.exit(0);
            } else if (playerValue > 21) {
                //add functionality for aces
                int c=0;
                for(int i=c; c>=playerCards.size()-1; c++){
                    if (playerCards.get(c).getNumber()==14){
                        playerValue-=10;
                        break;
                    }
                }
                System.out.println("Sorry, you got more that 21 points. You lose.");
                System.exit(0);
            }

            System.out.println("Do you want to hit or stay? (hit/stay) ");
            String choice = scanner.nextLine();

            if (choice.equals("stay")) {
                //System.out.println("stay"); used to test if program is working
                cont = false;
                dealerCards.add(deck.remove(0));
                if (dealerCards.get(1).getNumber() == 14) {
                    dealerValue += 11;
                } else if (dealerCards.get(1).getNumber() == 13 || dealerCards.get(1).getNumber() == 12 || dealerCards.get(1).getNumber() == 11) {
                    dealerValue += 10;
                } else {
                    dealerValue += dealerCards.get(1).getNumber();
                }

                System.out.println("Dealer's hand: " + dealerCards.get(1).getCard());
                System.out.println("Value of dealer's hand: " + dealerValue + "\n");

                System.out.println("Player's hand: " + playerCards.get(playerCards.size() - 1).getCard());
                System.out.println("Value of player's hand: " + playerValue + "\n");

                if (dealerValue>21 || dealerValue<playerValue){
                    System.out.println("You win!");
                } else if (dealerValue==playerValue){
                    System.out.println("It's a tie.");
                } else{
                    System.out.println("You lose.");
                }
            }
        }

    }
}
