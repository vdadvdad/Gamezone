import java.util.Arrays;
import java.util.Collections;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Roulette in console
 *
 * <p>Made during Hello World 2023 — hackathon for freshmen at Purdue</p>
 *
 * @author Vladislav Pavlovskii
 * @version September 16, 2023
 */


public class Roulette {
    public boolean notUnique(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).equals(list.get(i))) return true;
        }
        return false;
    }

    public void runGame(ArrayList<Integer> bet) {
        SecureRandom gen = new SecureRandom();
        int winningNumber = gen.nextInt(-1, 37); // -1 represents 00
        if (bet.contains(winningNumber)) {
            System.out.println("You won");
        } else {
            System.out.println("You lose");
        }
        if (winningNumber != -1) System.out.printf("Winning number: %d\n", winningNumber);
        else System.out.println("Winning number: 00"); // special case for 00
        System.out.print("Your bet: ");
        System.out.print(Arrays.toString(bet.toArray())); // outputs array, any number in which would have won
        System.out.println();
    }

    public Roulette() {
        System.out.println("Choose what to bet on:\n1. Color\n2. Even/Odd\n3. Low/High\n4. Dozens\n5. Columns\n6. Inside");
        Scanner s = new Scanner(System.in);
        String mode = "";
        while (mode.isEmpty()) {
            String number = s.nextLine();
            switch (number) {
                case "1" -> mode = "Color";
                case "2" -> mode = "Even/Odd";
                case "3" -> mode = "Low/High";
                case "4" -> mode = "Dozens";
                case "5" -> mode = "Columns";
                case "6" -> mode = "Inside";
                default -> System.out.println("Invalid input, please try again");
            }
        }
        if (mode.equals("Color")) {
            while (true) {
                System.out.println("Choose a color: red or black.");
                String color = s.nextLine();
                if (color.equalsIgnoreCase("red")) {
                    ArrayList<Integer> bet = new ArrayList();
                    // bet generation
                    for (int i = 3; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 9; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 5; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 7; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    bet.add(1);
                    bet.add(19);
                    // end of bet generation
                    runGame(bet);
                    break; // here and after 'break' stops infinite loop from running
                } else if (color.equalsIgnoreCase("black")) {
                    ArrayList<Integer> bet = new ArrayList();
                    // bet generation
                    for (int i = 2; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 8; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 6; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    for (int i = 4; i <= 36; i += 9) {
                        bet.add(i);
                    }
                    bet.add(10);
                    bet.add(28);
                    // end of bet generation
                    runGame(bet);
                    break;
                } else {
                    System.out.println("Invalid input");

                }
            }

        } else if (mode.equals("Even/Odd")) {
            while (true) {
                System.out.println("Choose Even or Odd");
                String color = s.nextLine();
                if (color.equalsIgnoreCase("odd")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 1; i <= 36; i += 2) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (color.equalsIgnoreCase("even")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 2; i <= 36; i += 2) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }
        } else if (mode.equals("Low/High")) {
            while (true) {
                System.out.println("Choose Low (1-18) or High (19-36)");
                String input = s.nextLine();
                if (input.equalsIgnoreCase("low")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 1; i <= 18; i++) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (input.equalsIgnoreCase("high")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 19; i <= 36; i++) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else {
                    System.out.println("Invalid input");
                    continue;
                }
            }
        } else if (mode.equals("Dozens")) {
            while (true) {
                System.out.println("Choose first (1-12), second (13-24), or third (25-36) dozen");
                String input = s.nextLine();
                if (input.equalsIgnoreCase("first")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 1; i <= 12; i++) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (input.equalsIgnoreCase("second")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 13; i <= 24; i++) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (input.equalsIgnoreCase("third")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 25; i <= 36; i++) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else {
                    System.out.println("Invalid input");
                    continue;
                }
            }
        } else if (mode.equals("Columns")) {
            while (true) {
                System.out.println("Choose first (1-4-7-...), second (2-5-8-...) or third (3-6-9-...) lines");
                String input = s.nextLine();
                if (input.equalsIgnoreCase("first")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 1; i <= 36; i += 3) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (input.equalsIgnoreCase("second")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 2; i <= 36; i += 3) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else if (input.equalsIgnoreCase("third")) {
                    ArrayList<Integer> bet = new ArrayList<>();
                    // bet generation
                    for (int i = 3; i <= 36; i += 3) {
                        bet.add(i);
                    }
                    // end of bet generation
                    runGame(bet);
                    break;
                } else {
                    System.out.println("Invalid input");
                    continue;
                }
            }
        } else if (mode.equals("Inside")) {
            while (true) {
                System.out.println("Please choose an inner bet. Type \"rules\" for rules. Multiple numbers should be entered on the same line");
                System.out.println("00 3 6 9 12 15 18 21 24 27 30 33 36"); // <-- roulette board
                System.out.println("   2 5 8 11 14 17 20 23 26 29 32 35");
                System.out.println(" 0 1 4 7 10 13 16 19 22 25 28 31 34");
//                int[][] table = {
//                        {-1, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36},
//                        {-2, 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35},
//                        { 0, 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34}
//                };
                String input = s.nextLine() + " "; // input is taken in string as it is unclear whether input is/are integer(s) or some other characters, such as "rules" or other notation (e.g. 12-15)
                if (input.equalsIgnoreCase("rules ")) { // inside-betting rules (slightly changed from wikipedia.org)
                    System.out.println("There are 7 types of inside bet:");
                    System.out.println("Single — bet on every single number");
                    System.out.println("Split — bet on two vertically or horizontally adjacent numbers (15-18, 8-9)");
                    System.out.println("Street — bet on three consecutive numbers in a vertical line (4-5-6)");
                    System.out.println("Square — bet on four numbers that meet at one corner (and form a square — 10-11-13-14)");
                    System.out.println("Double street — bet on 6 consecutive numbers that form two columns (31-32-33-34-35-36)");
                    System.out.println("Trio — 0-1-2, 0-00-2, 00-2-3");
                    System.out.println("Top line — 0-00-1-2-3");
                    continue;
                }
                ArrayList<Integer> inputList = new ArrayList<>();
                int currentNumber = 0;
                int numberLength = 0;
                for (int i = 0; i < input.length(); i++) {
                    switch (input.charAt(i)) {
                        case '1' -> {
                            currentNumber = currentNumber * 10 + 1;
                            numberLength++; // every numberLength++ is supposed to help in case of finding 0 and 00 (which will have currentNumber at 0)
                        }
                        case '2' -> {
                            currentNumber = currentNumber * 10 + 2;
                            numberLength++;
                        }
                        case '3' -> {
                            currentNumber = currentNumber * 10 + 3;
                            numberLength++;
                        }
                        case '4' -> {
                            currentNumber = currentNumber * 10 + 4;
                            numberLength++;
                        }
                        case '5' -> {
                            currentNumber = currentNumber * 10 + 5;
                            numberLength++;
                        }
                        case '6' -> {
                            currentNumber = currentNumber * 10 + 6;
                            numberLength++;
                        }
                        case '7' -> {
                            currentNumber = currentNumber * 10 + 7;
                            numberLength++;
                        }
                        case '8' -> {
                            currentNumber = currentNumber * 10 + 8;
                            numberLength++;
                        }
                        case '9' -> {
                            currentNumber = currentNumber * 10 + 9;
                            numberLength++;
                        }
                        case '0' -> {
                            currentNumber = currentNumber * 10;
                            numberLength++;
                        }
                        default -> {
                            if (numberLength != 0) {
                                if (numberLength == 2 && currentNumber == 0) {
                                    inputList.add(-1); // -1 represents 00
                                } else {
                                    inputList.add(currentNumber);
                                    currentNumber = 0;
                                    numberLength = 0;
                                }
                            }

                        }
                    }
                }
                Collections.sort(inputList); // <-- list of winning numbers is sorted
                if (notUnique(inputList) || inputList.get(inputList.size() - 1) > 36) { // if list does not consist of only unique elements or some number is larger than 36
                    System.out.println("Invalid input");
                    continue;
                } // after this if it is guaranteed that list is within boundaries of the board
                if (inputList.size() == 1) { // every other one-number input is valid
                    runGame(inputList);
                    break;
                } else if (inputList.size() == 2) {
                    // vertical line will have difference in 1, horizontal — in 3. Special cases for 0 and 00 are checked (00-2, 00-3, 0-1)
                    if ((inputList.get(1) - inputList.get(0) != 2 && inputList.get(1) - inputList.get(0) <= 3) || (inputList.get(0) == 0 && inputList.get(1) <= 2) || (inputList.get(0) == -1 && (inputList.get(1) == 2 || inputList.get(1) == 3))) {
                        runGame(inputList);
                        break;
                    } else {
                        System.out.println("Invalid input");
                        continue;
                    }
                } else if (inputList.size() == 3) {
                    // checks if numbers are consecutive with difference of 1:
                    // list would consist of numbers n, n + 1 and n + 2, with difference between first and last being exactly two
                    // second check verifies that numbers are actually in one column — as list is sorted, first number should be on the lowest row (numbers on the lowest row are calculated by n = 3 * a + 1, where 'a' is any positive number and 0)
                    if (inputList.get(2) - inputList.get(0) == 2 && (inputList.get(0) % 3) == 0) {
                        runGame(inputList);
                        break;
                    }
                    // special cases of size 3, as described in rules
                    else if ((inputList.get(0) == -1 && inputList.get(1) == 2 && inputList.get(2) == 3) || // 00-2-3
                            (inputList.get(0) == -1 && inputList.get(1) == 0 && inputList.get(2) == 2) || // 00-0-2
                            (inputList.get(0) == 0 && inputList.get(2) == 2)) { // 0-1-2, check for 1 can be skipped as it is known that list is sorted and consists of unique integers — between 0 and 2 only 1 can be placed
                        runGame(inputList);
                        break;
                    } else {
                        System.out.println("Invalid input");
                        continue;
                    }
                } else if (inputList.size() == 4) {
                    // numbers in square are adjacent vertically and horizontally, so can be calculated by formula if n_1 = n: n_2 = n + 1, n_3 = n + 3, n_4 = n + 4
                    // if-statement checks that n_2 - n_1 == 1 and n_4 - n_3 == 1(two pairs of vertically aligned numbers) and n_3 - n_2 == 2, which is correct according to the formula above
                    if (inputList.get(1) - inputList.get(0) == 1 && inputList.get(3) - inputList.get(2) == 1 && inputList.get(2) - inputList.get(1) == 2) {
                        runGame(inputList);
                        break;
                    } else {
                        System.out.println("Invalid input");
                        continue;
                    }
                } else if (inputList.size() == 5) {
                    // the only possible way of containing 5 elements with the largest being 3 is 0-00-1-2-3
                    if (inputList.get(4) == 3) {
                        runGame(inputList);
                        break;
                    } else {
                        System.out.println("Invalid input");
                        continue;
                    }
                } else if (inputList.size() == 6) {
                    // first check confirms that numbers are within two columns
                    // with 6 sorted unique numbers, first and last will have difference of 5 only if they are consecutive
                    if ((inputList.get(0) - 1) % 3 == 0 && inputList.get(5) - inputList.get(0) == 5) {
                        runGame(inputList);
                        break;
                    }
                }
                break;
            }
        }
    }
}