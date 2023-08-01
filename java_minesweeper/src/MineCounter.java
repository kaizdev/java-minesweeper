public class MineCounter {

  static int countNearbyMines(int row, int col) {
    // check each of the 8 cells surrounding the user selected co-ordinate for a mine. Positions are relative to the user selected position
    // eg.
    /*
     * [ ] [ ] [ ] above row
     * [ ] [x] [ ] left/right
     * [ ] [ ] [ ] below row
     */

    int count = 0;

    if (checkGridLocationForMine(row - 1, col - 1)) count++; // above left
    if (checkGridLocationForMine(row - 1, col)) count++; // above
    if (checkGridLocationForMine(row - 1, col + 1)) count++; // above right

    if (checkGridLocationForMine(row, col - 1)) count++; // left
    if (checkGridLocationForMine(row, col + 1)) count++; // right

    if (checkGridLocationForMine(row + 1, col - 1)) count++; // below left
    if (checkGridLocationForMine(row + 1, col)) count++; // below
    if (checkGridLocationForMine(row + 1, col + 1)) count++; // below right

    return count;
  }

  static boolean checkGridLocationForMine(int row, int col) {
    return Grid.mines.contains(row + "," + col);
  }
}
