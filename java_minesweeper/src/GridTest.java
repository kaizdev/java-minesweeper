import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class GridTest {

  // Check that 10 mines are actually generated randomly
  @Test
  public void startGame_newGame_Returns10Mines() {
    int expectedResult = 10;
    Grid.startGame();
    int actualResult = Grid.mines.size();
    assertEquals(expectedResult, actualResult);
  }
}
