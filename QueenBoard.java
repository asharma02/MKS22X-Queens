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

  private void clearBoard() {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board.length; c++) {
                board[r][c] = 0;
            }
        }
    }

//add queen
private boolean addQueen(int r, int c) {
    if (board[r][c] != 0) {
      return false;
    } //TILE IS UNSAFE, CANT PUT QUEEN
    for(int i = 0; i < board.length; i++) {
      board[r][i] += 1;
    }
    for(int i = 0; i < board.length; i++) {
      board[i][c] += 1;
    }
      //add unsafe to the row and column
    for(int i = 0; r + i < board.length && c + i < board.length; i++) {
      board[r + i][c + i] += 1;
    }
    for(int i = 0; r - i >= 0 && c - i >= 0; i++) {
      board[r - i][c - i] += 1;
    }
    for(int i = 0; r + i < board.length && c - i >= 0; i++) {
        board[r + i][c - i] += 1;
    }
    for(int i = 0; r - i >= 0 && c + i < board.length; i++) {
        board[r - i][c + i] += 1;
    }
    //adding unsdafe diagonally all 4 ways
    board[r][c] = -1; //changing the tile back to a queen
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
          while (row >= 0 && col < board.length) {
            board[row][col] -= 1 ;
            col += 1 ; //increment
            row -= 1 ;
          }
          //adding safe diag right up
        }
        if (r < board.length -1 && c < board.length -1) { // make sure r, c in bounds
          int row = r + 1 ;
          int col = c + 1 ;
          while (row < board.length && col < board.length) {
            board[row][col] -= 1 ;
            row++ ;//increment
            col++ ;
          }
          //adding safe diag right down
        }
        return true; //queen removed and safes added
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
    String output = "" ;
    for (int r = 0 ; r < board.length ; r++) {
      for (int c = 0 ; c < board.length ; c++) {
        if (board[r][c] == -1) { //queen
          output += "Q " ;
        }
        else {
          output += "_ " ;  //add board plus blank
        }
      }
      output += "\n" ;
    }
    return output;
  }


  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for (int r = 0 ; r < board.length ; r++) {
      for (int c = 0 ; c < board.length ; c++) {
        if (board[r][c] != 0) throw new IllegalStateException() ;
      }
    } //check if board is good
    return helper(0); //start at column 0
  }

  public boolean helper(int c) {
    int l = board.length ;
    if (c >= l) {
      int total = 0 ;
      for (int rrow = 0 ; rrow < board.length ; rrow++) {
        for (int ccol = 0 ; ccol < board.length ; ccol++) {
          if (board[rrow][ccol] == -1) total++ ;
        }
      }
      return total == l; //if at end of board
    }
    else {
      for (int r = 0 ; r < l ; r++) {
        if (addQueen(r,c)) { //add queen and current index
          if (helper(c+1) ) { //can continue
            return true;
          }
          else {
            removeQueen(r,c); //its wrong, remove try again
          }
        }
     }
     for (int row = 0 ; row < l ; row++) {
        for (int col = 0 ; col < l ; col++) {
          board[row][col] = 0 ;
        }
      }
    return false; //cannot be solved
  }
}

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    for (int r = 0 ; r < board.length ; r++) {
        for (int c = 0 ; c < board.length ; c++) {
            if (board[r][c] != 0) throw new IllegalStateException() ;
        }
    } //check if board is all 0s
    return counthelper(0);
  }

  public int counthelper(int col) {
    if (col == board.length) {
      return 1;
    }// checks if the row last checked was the final row
    int all = 0;
    for (int r = 0 ; r < board.length ; r++) {//for every row in the column
      if (addQueen(r,col)) {
        all += counthelper(col + 1); //counter leads to the ocunter of the next column
      }
      removeQueen(r,col); //remove to TRY WITH THE NEXT QUEEN
    }
    return all;
}
}
