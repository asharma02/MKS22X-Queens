public class QueenBoard {
  private int[][]board;


  public QueenBoard(int size){
    board = new int[size][size] ;
    for (int r = 0 ; r < size ; r++) {
      for (int c = 0 ; c < size ; c++) {
        board[r][c] = 0 ;
      }
    }
  }

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

  private boolean issafe(int row, int column){
      for (int x = 0; x < rows; x++) {
        if (board[x][column] == -1) {
          return false;
        }
      }
      for (int x = 0; x < columns; x++) {
        if (board[row][x] == -1) {
          return false;
        }
      }

      return true

  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    int rows = board.length;
    int columns = board[0].length;
    return helper (0,0,rows);

  }

  public void helper(int r, int c, int target) {
    int count = 0;
    if (count == target) {
      return true;
    }
    if {board[r][c] == 0 && board[r][c](r,c).issafe()) {
          board[r][c] = -1;
          count += 1;
        }
    }
    return helper(r + 1, c, target, count);
    return helper(r, c + 1, target, count);
  }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){

  }

}
