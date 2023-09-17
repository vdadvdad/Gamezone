import java.util.Scanner;
public class Main 
{
    public static void main(String[] args) 
  {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to the casino!");
        System.out.println("Options: ");
        System.out.println("1. Roulette");
        System.out.println("2. Poker");
        System.out.println("3. Blackjack");
        System.out.println("4. Kids' Zone");
        System.out.println("Where would you like to go? ");
        int game = in.nextInt();
        System.out.println();
        while ((game < 0 || game > 4)) {
          System.out.println(game+" is not a valid input. Please try again.");
          System.out.print("Which game would you like to play? ");
          game = in.nextInt();
          System.out.println();
        }
         
        if(game==1)
        {
        System.out.println("Thank you for choosing Roulette!");
          Roulette r = new Roulette();
        }
        else if(game==2)
        {
          System.out.println("Thank you for choosing Poker!");
          Poker p = new Poker();
          p.PlayPokerVsComputer();
        }
        else if(game==3)
        {
          System.out.println("Thank you for choosing Blackjack!");
          Blackjack b = new Blackjack();
        }
        else if(game==4)
        {
          System.out.println("Welcome to the Kids' Zone! Currently, our only game is Tic Tac Toe. Enter 1 to play.");
          int start = in.nextInt();
          System.out.println();
          while(start!=1)
            {
              System.out.println(start + " is not a valid input. Please try again.");
              System.out.println("Welcome to the Kids' Zone! Currently, our only game is Tic Tac Toe. Enter 1 to play.");
              System.out.println();
            }
            TicTacToe t = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Player " + t.currentPlayer + ", enter your move (row [0-2] and column [0-2]): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (t.placeMark(row, col)) 
            {
                t.printBoard();
                if (t.checkWin()) 
                {
                    System.out.println("Player " + t.currentPlayer + " wins!");
                    break;
                } 
                else if (t.isBoardFull()) 
                {
                    System.out.println("It's a draw!");
                    break;
                } 
                else 
                {
                    t.switchPlayer();
                }
            }
        }
        }
  }
}

    
        
    

