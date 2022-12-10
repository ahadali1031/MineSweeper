import java.util.Scanner;

public class MineSweeper {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Ask the user for the size of the game board
    System.out.print("Enter the size of the game board: ");
    int size = scan.nextInt();

    char[][] board = new char[size][size];

    // Make the board
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = ' ';
      }
    }

    
    int mines = 0;
    while (mines < size) {
      int row = (int) (Math.random() * size);
      int col = (int) (Math.random() * size);
      if (board[row][col] != 'm') {
        board[row][col] = 'm';
        mines++;
      }
    }

    
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }

    // Start the game
    while (true) {
      
      System.out.print("Enter the row and column of the cell to reveal: ");
      int row = scan.nextInt();
      int col = scan.nextInt();

      // Check if the selected cell is a mine
      if (board[row][col] == 'm') {
        System.out.println("You hit a mine! Game over.");
        break;
      }

      
      board[row][col] = '-';

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          System.out.print(board[i][j] + " ");
        }
        System.out.println();
      }
    }
  }
}