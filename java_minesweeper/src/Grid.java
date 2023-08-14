import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Grid {

  static int gridSizeColsRows = 10;
  static int numOfMines = 10;
  static String[][] grid = new String[gridSizeColsRows][gridSizeColsRows];
  static boolean[][] cellsRevealed = new boolean[gridSizeColsRows][gridSizeColsRows];
  static Set<String> mines = new HashSet<>(); // HashSet ensures no duplicate mine position
  static Random random = new Random();

  public static void main(String[] args) {}

  // generate initial grid
  static void startGame() {
    for (int i = 0; i < gridSizeColsRows; i++) {
      for (int j = 0; j < gridSizeColsRows; j++) {
        grid[i][j] = "[ ]";
      }
    }
    // Generate 10 mines using random.nextInt
    while (mines.size() < numOfMines) {
      int row = random.nextInt(gridSizeColsRows); // generate from 0 - 9 inclusive
      int col = random.nextInt(gridSizeColsRows);
      mines.add(row + "," + col);
    }
  }

  // printing to console
  static void printBoard() {
    System.out.print("   "); // Padding for x-axis
    for (int i = 0; i < gridSizeColsRows; i++) {
      System.out.printf("%2d  ", i); // Print the x-axis numbers
    }
    System.out.println();

    for (int i = 0; i < gridSizeColsRows; i++) {
      System.out.printf("%2d ", i); // Print the y-axis numbers
      for (int j = 0; j < gridSizeColsRows; j++) {
        // if the reveal = true, show the number on the grid, else continue to show empty grid
        if (cellsRevealed[i][j]) {
          System.out.printf("[%s] ", grid[i][j]);
        } else {
          System.out.print("[ ] ");
        }
      }
      System.out.println();
    }
  }

  // end game if all non-bomb squares revealed
  static boolean isGameWon() {
    for (int i = 0; i < gridSizeColsRows; i++) {
      for (int j = 0; j < gridSizeColsRows; j++) {
        // game still continues if there are cells yet to be revealed and the cell is not a bomb
        if (!cellsRevealed[i][j] && !mines.contains(i + "," + j)) {
          return false;
        }
      }
    }
    return true;
  }

  static void showMines() {
    for (String mine : mines) {
      int row = Integer.parseInt(mine.split(",")[0]);
      int col = Integer.parseInt(mine.split(",")[1]);
      grid[row][col] = "X";
      cellsRevealed[row][col] = true;
    }
  }
}
