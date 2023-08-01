import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    Grid.startGame();
    boolean isRunning = true;

    while (isRunning) {
      Grid.printBoard();
      System.out.print(
        "Please enter a coordinate between 0 and 9 (in the format row,column): "
      );

      // Ensure user provides valid coordinate input (and prevent error from crashing console)
      Pattern inputPattern = Pattern.compile("^\\d,\\d$");
      String input;

      while (true) {
        input = scanner.nextLine();
        if (inputPattern.matcher(input).matches()) {
          break;
        } else {
          System.out.print(
            "Invalid input - Please enter coordinates as row,column: "
          );
        }
      }

      int row = Integer.parseInt(input.split(",")[0]); // row
      int col = Integer.parseInt(input.split(",")[1]); // column

      // end game immediately if row,cols match bomb set
      if (Grid.mines.contains(row + "," + col)) {
        System.out.println("**Boom!** That was a mine. Game Over.");
        // to do: show mines if game over
        Grid.showMines();
        Grid.printBoard();
        break;
      } else {
        int mineCount = MineCounter.countNearbyMines(row, col);
        Grid.grid[row][col] = Integer.toString(mineCount);
        Grid.cellsRevealed[row][col] = true;
        if (Grid.isGameWon()) {
          Grid.printBoard();
          System.out.println("You have won, congratulations");
          break;
        }
      }
    }
    scanner.close();
  }
}
