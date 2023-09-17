import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


/**
 Simulates a poker game

 @author Nathan McKinley
 @version 9/16/2023
 */

public class Poker {
    private String[] suitArray = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private int[] numArray = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; //jack = 11, queen = 12, king = 13, ace = 14
    private int currentMoney, handStrength;
    //handstrength is from 1-10, where 1 is high card and 10 is royal flush
    //straightChance and flushChance are going to be numbers that increase
        //if two of the numbers are next to each other or two suits are the same, the number will increment by 1
        //if the number of either of these =5 then they have a straight
    private boolean stillIn = true, isWinning;
    private ArrayList<Card> deck;
    private Card[] myHand = new Card[2], onTable = new Card[5];
    //computer's stuff
    private Card[] cHand1 = new Card[2], cHand2 = new Card[2], cHand3 = new Card[2], cHand4 = new Card[2];
    private int cMon1 = 1000, cMon2 = 1000, cMon3 = 1000, cMon4 = 1000;
    private int comp1Strength = 0, comp2Strength = 0,comp3Strength = 0,comp4Strength = 0;

    private Card tempCard;
    public Poker() {
        currentMoney = 1000;
        deck = Card.makeDeck();

    }

    public void PlayPokerVsComputer() {
        //MAKE SURE TO RESET THE PAIRS, STRAIGHT, FLUSH, ETC VARIABLES BUT KEEP MONEY THE SAME
        //LOOP ALL OF THIS



        //buy in is 1000 dollars DONE
        //deal out cards DONE
        System.out.println("Current money: " + currentMoney);
        deck = dealCardsForComputer(deck);
        //printDeck(deck);

        //initial bets
        currentMoney = betMoney(currentMoney);
        System.out.println("Current money: " + currentMoney);

        //***print out computers bets***


        //flop (first 3 cards are shown)
        deck = theFlop(deck);


        //post flop bets, must make sure you are still in and not folded
        if (stillIn) {
            betMoney(currentMoney);
            System.out.println("Current money: " + currentMoney);
        }

        //the turn (4th card)
        deck = theTurn(deck);


        if (stillIn) {
            currentMoney = betMoney(currentMoney);
            System.out.println("Current money: " + currentMoney);
        }

        //the river (5th card)

        deck = theRiver(deck);


        //show the full river again so the player can see
        System.out.println("\n------------------------------------------------\n");
        /*
        System.out.println("Full river: ");
        for (int i = 0; i < onTable.length; i++) {
            System.out.println(onTable[i].getCard());
        }
        */




        if (stillIn) {
            currentMoney = betMoney(currentMoney);
            System.out.println("Current money: " + currentMoney);
        }




        //5 players
        //ADD:
        //blinds
        //probability for "computer" to fold
        //add every poker hand




        int firstNum = myHand[0].getNumber(), secondNum = myHand[1].getNumber();
        int higherNum, lowerNum;
        String firstSuit = myHand[0].getSuit(), secondSuit = myHand[0].getSuit();
        if (firstNum > secondNum) {
            higherNum = firstNum;
            lowerNum = secondNum;
        } else {
            higherNum = secondNum;
            lowerNum = firstNum;
        }
        //for tie purposes

        for (int i = 0; i < onTable.length; i++) {
            System.out.println(onTable[i].getCard());
        }
        //uncomment the loops if you want to see what the computers had
        Card[] allCards;
        System.out.println("-------------");
        allCards = createAllCards(myHand, 0);
        handStrength = checkPokerHands(myHand, allCards);
        for (int i = 0; i < 7; i++)
            System.out.println(allCards[i].getCard());
        

        System.out.println("-------------");
        allCards = createAllCards(cHand1, 1);
        comp1Strength = checkPokerHands(cHand1, allCards);
        for (int i = 0; i < 7; i++)
            System.out.println(allCards[i].getCard());
        

        System.out.println("-------------");
        allCards = createAllCards(cHand2, 2);
        comp2Strength = checkPokerHands(cHand2, allCards);
        for (int i = 0; i < 7; i++)
            System.out.println(allCards[i].getCard());

        

        System.out.println("-------------");
        allCards = createAllCards(cHand3, 3);
        comp3Strength = checkPokerHands(cHand3, allCards);
        for (int i = 0; i < 7; i++)
            System.out.println(allCards[i].getCard());
        

        System.out.println("-------------");
        allCards = createAllCards(cHand4, 4);
        comp4Strength = checkPokerHands(cHand4, allCards);
        for (int i = 0; i < 7; i++)
            System.out.println(allCards[i].getCard());
        

        System.out.println("-------------");


        /**
         * RIGHT NOW, ALL OF allCards ARE THE SAME, IF YOU FIND A WAY TO MAKE THEM UNIQUE FOR EVERY COMPUTER,
         * THEN ALL YOU NEED TO DO IS DEAL WITH TIEBREAKS
         */


        int[] strengths = {handStrength, comp1Strength, comp2Strength, comp3Strength, comp4Strength};
        Card[][] playerStrengths = {myHand, cHand1, cHand2, cHand3, cHand4};
        //System.out.println(playerStrengths.length + "--" + playerStrengths[0].length);
        Card[][] sortedPlayerStrengths = new Card[5][2];

        //System.out.println(playerStrengths[0][1].getNumber());

        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (strengths[i] > max) {
                max = strengths[i];
            }

        }

        int[] tieNums = new int[5];
        for (int i = 0, j = 0; i < strengths.length; i++) {
            if (strengths[i] == max) {
                tieNums[j] = strengths[i];
                sortedPlayerStrengths[j] = playerStrengths[i];//sorted the hands the same way as the strengths
                j++;
            }
        }
        for (int i = 0; i < tieNums.length; i++) {

        }

        int endTies = 0;
        for (int i = 0; i < tieNums.length; i++) {
            //System.out.println(tieNums[i] + "l");
            if (tieNums[i] == 0) {
                endTies = i;
            }
        }

        sortedPlayerStrengths = tieBreaker(sortedPlayerStrengths, tieNums, endTies);

        /*
        for (int i = 0; i < tieNums.length; i++)
            System.out.println(tieNums[i]);
        */

        //tieNums[0] is the winner
        //so, by logic, if my code works, sortedPlayerStrengths[0] should be the highest

        //public int tieBreaker(Card[] hand, Card[] tiedPlayers)
        /*
        System.out.println("-----------");
        System.out.println(handStrength);
        System.out.println(comp1Strength);
        System.out.println(comp2Strength);
        System.out.println(comp3Strength);
        System.out.println(comp4Strength);
        */





        if (myHand == sortedPlayerStrengths[0])
            System.out.println("You win!");
        else if (cHand1 == sortedPlayerStrengths[0])
            System.out.println("Computer 1 wins!");
        else if (cHand2 == sortedPlayerStrengths[0])
            System.out.println("Computer 2 wins!");
        else if (cHand3 == sortedPlayerStrengths[0])
            System.out.println("Computer 3 wins!");
        else if (cHand4 == sortedPlayerStrengths[0])
            System.out.println("Computer 4 wins!");



        //there are 10 poker hands, royal flush = 10 and high card = 1
        //need to resolve ties (if there are two straights) as well

    }


    public int checkPokerHands(Card[] playerHand, Card[] allCards) {
        boolean straight = false, flush = false, onePair = false, twoPair = false, threeOfAKind = false, fourOfAKind = false, fullHouse = false;
        int straightChance = 0, flushChance = 0, pairs = 0;


        Card[] allCards1 = new Card[7];
        //will check for flushes
        //sort for straights
        for (int i = 0; i < allCards.length; i++) {
            allCards1[i] = allCards[i];
        }

        sortCardNum(allCards);
        sortCardSuit( allCards1);
        //both sort correctly


        //testing sorts
        /*
        for (int i = 0; i < allCards.length; i++) {
            System.out.println(allCards[i].getCard());
        }

        System.out.println("-----------------------");
        for (int i = 0; i < allCards1.length; i++) {
            System.out.println(allCards1[i].getCard());
        }

        */


        //number sorted array, checking for straights
        for (int i = allCards.length - 1; i > 0; i--) {
            if (allCards[i].getNumber() - allCards[i - 1].getNumber() == 1) {
                straightChance++;
                if (straightChance == 4)
                    straight = true;
            }
            else if (allCards[i].getNumber() - allCards[i - 1].getNumber() == 0) {
                straightChance += 0;
            }
            else if (straightChance < 4)
                straightChance = 0;

            //8,9,10,jack,jack,queen did not work

        }
        //System.out.println("-------------");
        //suit sorted array, checking for flushes
        for (int i = allCards1.length - 1; i > 0; i--) {
            if (allCards1[i].getSuit().equals(allCards1[i - 1].getSuit())) {
                flushChance++;
                if (flushChance == 4)
                    flush = true;
            }
            else if (flushChance < 4)
                flushChance = 0;

            //System.out.println(flushChance);


        }

        //number sorted array, checking for pairs
        for (int i = 0; i < allCards.length - 1; i++) {
            int num1 = allCards[i].getNumber(), num2 = allCards[i + 1].getNumber();
            if (num1 == num2) {
                pairs++;

                if (i < allCards.length - 3 && num1 == allCards[i + 3].getNumber()) {
                    fourOfAKind = true;
                    break;
                } else if (i < allCards.length - 2 && num1 == allCards[i + 2].getNumber()) {
                    threeOfAKind = true;
                    //i++;
                }
                i++;
            }


        }
        // && !threeOfAKind
        if (!fourOfAKind) {
            if (pairs == 1)
                onePair = true;
            else if (pairs == 2)
                twoPair = true;
        }



        if ((threeOfAKind && twoPair))
            fullHouse = true;

        if (allCards[6].getNumber() == 14 && allCards[2].getNumber() == 10 && straight && flush)
            return 9;
        else if (straight && flush)
            return 8;
        else if (fourOfAKind)
            return 7;
        else if (fullHouse)
            return 6;
        else if (flush)
            return 5;
        else if (straight)
            return 4;
        else if (threeOfAKind)
            return 3;
        else if (twoPair)
            return 2;
        else if (onePair)
            return 1;
        else
            return 0;

        //create priorities
        //testing straight, flush, onePair, twoPair, threeOfAKind, fourOfAKind, fullHouse;
        /*
        System.out.println("One pair: " + onePair);
        System.out.println("Two pair: " + twoPair);
        System.out.println("3 of a kind: " + threeOfAKind);
        System.out.println("4 of a kind: " + fourOfAKind);
        System.out.println("Full house: " + fullHouse);
        System.out.println("Flush: " + flush);
        System.out.println("Straight: " + straight);
        */

    }



    public Card[][] tieBreaker(Card[][] sortedPlayers, int[] sortedHands, int endTies) {
        //both arrays are the players' hands and their strength of hand, both in sorted lists
        Card[] winner, temp;
        int temp2;
        for (int i = 1; i < endTies; i++) {
            if (sortedPlayers[i][0] != null && sortedPlayers[i][0].getNumber() > sortedPlayers[i-1][0].getNumber()) {
                //need to sort both arrays
                temp = sortedPlayers[i];
                sortedPlayers[i] = sortedPlayers[i-1];
                sortedPlayers[i-1] = temp;

                temp2 = sortedHands[i];
                sortedHands[i] = sortedHands[i-1];
                sortedHands[i-1] = temp2;


            }
            else if (sortedPlayers[i][0] != null && sortedPlayers[i][0].getNumber() == sortedPlayers[i-1][0].getNumber()) {
                if (sortedPlayers[i][1] != null && sortedPlayers[i][1].getNumber() > sortedPlayers[i-1][1].getNumber()) {
                    //must sort both arrays
                    temp = sortedPlayers[i];
                    sortedPlayers[i] = sortedPlayers[i-1];
                    sortedPlayers[i-1] = temp;


                    temp2 = sortedHands[i];
                    sortedHands[i] = sortedHands[i-1];
                    sortedHands[i-1] = temp2;

                }
            }
        }


        return sortedPlayers;
    }

    public Card[] createAllCards(Card[] hand, int personPlaying) {
        Card[] allCards = new Card[7];
        for (int i = 0; i < allCards.length; i++) {
            if (i < 5)
                allCards[i] = onTable[i];
            else
                if (personPlaying == 0)
                    allCards[i] = myHand[i-5];
                else if (personPlaying == 1)
                    allCards[i] = cHand1[i-5];
                else if (personPlaying == 2)
                    allCards[i] = cHand2[i-5];
                else if (personPlaying == 3)
                    allCards[i] = cHand3[i-5];
                else if (personPlaying == 4)
                    allCards[i] = cHand4[i-5];
        }

        return allCards;

        //allCards = new Card[7], allCards1 = new Card[7];
    }

    public void sortCardNum(Card[] allCards) {
        for (int i = 0; i < allCards.length; i++) {
            for (int j = 0; j < allCards.length - 1; j++) {
                if (allCards[j].getNumber() > allCards[j+1].getNumber()) {
                    Card temp = allCards[j];
                    allCards[j] = allCards[j+1];
                    allCards[j+1] = temp;
                }
            }
        }
    }
    public void sortCardSuit(Card[] allCards1) {
        for (int i = 0; i < allCards1.length; i++) {
            for (int j = 0; j < allCards1.length - 1; j++) {
                if (allCards1[j].getSuit().compareTo(allCards1[j+1].getSuit()) > 0) {
                    Card temp = allCards1[j];
                    allCards1[j] = allCards1[j+1];
                    allCards1[j+1] = temp;
                }
            }
        }
    }

    public ArrayList<Card> theRiver(ArrayList<Card> deck) {
        Random gen = new Random();
        int cardPick = gen.nextInt(deck.size());
        System.out.println("The river: ");
        System.out.println(deck.get(cardPick).getCard());
        onTable[4] = deck.get(cardPick);
        deck.remove(cardPick);

        return deck;
    }

    public ArrayList<Card> theTurn(ArrayList<Card> deck) {
        Random gen = new Random();
        int cardPick = gen.nextInt(deck.size());
        System.out.println("The turn: ");
        System.out.println(deck.get(cardPick).getCard());
        onTable[3] = deck.get(cardPick);
        deck.remove(cardPick);

        return deck;
    }

    public ArrayList<Card> theFlop(ArrayList<Card> deck) {
        Random gen = new Random();
        int cardPick = gen.nextInt(deck.size());
        System.out.println("The flop: ");
        int endNum = deck.size() - 3;
        for (int i = deck.size() - 1, j = 0; i >= endNum; i--, j++) {
            System.out.println(deck.get(cardPick).getCard());
            onTable[j] = deck.get(cardPick);
            deck.remove(cardPick);
            cardPick = gen.nextInt(deck.size());
        }

        return deck;
    }


    public int betMoney(int money) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Based on your cards, how much would you like to bet (0 to fold)? ");
        int betAmt;
        betAmt = scan.nextInt();
        scan.nextLine();
        while (betAmt > money) {
            System.out.println("You do not have enough money to bet that amount. Choose a number that is below or equal to: " + money);
            betAmt = scan.nextInt();
            scan.nextLine();
        }
        if (betAmt == 0) {
            stillIn = false;
        }
        else {
            money -= betAmt;
        }
        return money;

    }

    public ArrayList<Card> dealCardsForComputer(ArrayList<Card> deck) {
        Random gen = new Random();
        int cardPick = gen.nextInt(52);
        for (int i = deck.size() - 1, j = 0; i >= 42; i--, j++) {
            //System.out.println(i);
            if (i > 49) {
                System.out.println("Your card is " + deck.get(cardPick).getCard());
                myHand[j] = deck.get(cardPick);
            }
            else if (i > 47) {
                cHand1[j-2] = deck.get(cardPick);
            }
            else if (i > 45) {
                cHand2[j-4] = deck.get(cardPick);
            }
            else if (i > 43) {
                cHand3[j-6] = deck.get(cardPick);
            }
            else if (i > 41) {
                cHand4[j-8] = deck.get(cardPick);
            }
            deck.remove(cardPick);
            //System.out.println(cardPick);
            cardPick = gen.nextInt(deck.size());
        }
        return deck;
    }

    public static void printDeck(ArrayList<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println(i);
            System.out.println(deck.get(i).getCard());
        }

    }


}