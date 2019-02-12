public class QueenBoard {
  private int[][]board;


  public QueenBoard(int size){
    board = new int[size][size] ;
    for (int r = 0 ; r < size ; r++) {
      for (int c = 0 ; c < size ; c++) {
        board[r][c] = 0 ;
      } //makes a square board filled with zeroes
    }
  }

//add queen
private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) {
      return false;
    } //TILE IS UNSAFE, CANT PUT QUEEN
    else {
      board[r][c] = -1; //ADD THE QUEEN

      for (int row = 0 ; row < board.length ; row++) {
        for (int col = 0 ; col < board.length; col++) {
          if (row == r && col != c) {
            board[row][col] += 1;
          }
          if (col == c && row != r) {
            board[row][col] += 1;
          }
        }
      } //add unsafe to the row and column
      if (c < board.length-1 && r > 0) { //make sure r, c are in bounds
        int row = r - 1;
        int col = c + 1;
        while (row >= 0 && col < board.length) {
          board[row][col] += 1 ;
          col += 1 ; //increment
          row -= 1 ;
        }
        //adding unsdafe diag right up
      }
      if (r < board.length-1 && c < board.length-1) { // make sure r, c in bounds
        int row = r + 1 ;
        int col = c + 1 ;
        while (row < board.length && col < board.length) {
          board[row][col] += 1 ;
          row++ ;//increment
          col++ ;
        }
        //adding unsafe diag right down
      }
      return true ; //queen and unsafes added
    }
  }

  private boolean removeQueen(int r, int c) { //opposite of addqueen
      if (board[r][c] != -1) { //tile is not a queen
        return false;
      }
      else {
        for (int row = 0 ; row < board.length; row++) {
          for (int col = 0 ; col < board.length; col++) {
            if (row == r && col != c) {
              board[row][col] -= 1;
            }
            if (col == c && row != r) {
              board[row][col] -= 1;
            }
          }
        } //add safe to the row and column
        if (c < board.length-1 && r > 0) { //make sure r, c are in bounds
          int row = r - 1;
          int col = c + 1;
          while (row >= 0 && col < l) {
            board[row][col] -= 1 ;
            col += 1 ; //increment
            row -= 1 ;
          }
          //adding safe diag right up
        }
        if (r < board.length -1 && c < board.length -1) { // make sure r, c in bounds
          int row = r + 1 ;
          int col = c + 1 ;
          while (row < l && col < l) {
            board[row][col] -= 1 ;
            row++ ;//increment
            col++ ;
          }
          //adding safe diag right down
        }
        return true ;
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


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){

  }

  public void helper(int r, int c, int target) {

  }
  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){

  }

}
