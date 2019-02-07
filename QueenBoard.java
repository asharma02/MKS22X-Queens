public class QueenBoard {
  private int[][]board;

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *"""_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _"""
  *(pythonic string notation for clarity,
  *excludes the character up to the *)
  -1 = queen, 0 non threatened, 1 threatened
  */

  public String toString(){

  }

  private boolean issafe(){

  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    int numrows = board.length;
    int rowlength = board[0].length;
    for (int i = 0; i < numrows; i++) {
      for (int x = 0; i < rowlength; x++) {
        if board[i][x].issafe() {
          //add queen
        }
      }
    }
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){

  }

}
