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

    private void clearBoard() { //helper clears board
          for(int r = 0; r < board.length; r++) {
              for(int c = 0; c < board.length; c++) {
                  board[r][c] = 0;
              }
          }
      }

    private boolean isEmpty() { //helper chekcs if empty
        for(int r = 0; r < board.length; r++) {
          for(int c = 0; c < board.length; c++) {
            if(board[r][c] != 0) return false;
          }
        }
        return true;
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
      return true;
  }


    private boolean removeQueen(int r, int c) { //opposite of addqueen
      if (board[r][c] != -1) {
        return false;
      } //no queen here
      for(int i = 0; i < board.length; i++) {
        board[r][i] -= 1;
      }
      for(int i = 0; i < board.length; i++) {
        board[i][c] -= 1;
      }
        //add safe to the row and column
      for(int i = 0; r + i < board.length && c + i < board.length; i++) {
        board[r + i][c + i] -= 1;
      }
      for(int i = 0; r - i >= 0 && c - i >= 0; i++) {
        board[r - i][c - i] -= 1;
      }
      for(int i = 0; r + i < board.length && c - i >= 0; i++) {
          board[r + i][c - i] -= 1;
      }
      for(int i = 0; r - i >= 0 && c + i < board.length; i++) {
          board[r - i][c + i] -= 1;
      }
      //adding safe diagonally all 4 ways
      board[r][c] = 0; //changing the tile back to UNSAFE
      return true;
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
    if(!isEmpty()) throw new IllegalStateException(); //check if empty
    if(!helper(0, 0)) { //call the helper function; if doesnt work
      clearBoard(); //clear
      return false;//return false
    }
    return true; //return true otherwise
  }

  public boolean helper(int r, int c) {
    int l = board.length ;
    if(r == 0) {
      addQueen(0, c);
      if(!helper(1, 0)) { // if the this queen could not be added
        removeQueen(r, c);
        if(c == board.length - 1) {
          return false;
        } //once you reach the end of the board, no more solutions
        return helper(0, c + 1); // try the next row
      }
      else {
        return true;
      }
    }
    if(addQueen(r, c)) { //if adding queen here
      if(r == board.length - 1) {   //last row?
        return true;
      }
      else {
        if(!helper(r + 1, 0)) { //check rows, if no more solutions
          removeQueen(r, c);
          if(c == board.length - 1) {
            return false;
          }// if the last column, return false
          return helper(r, c + 1); //try next column
        }
        return true; //return true because all bad solutions have been taken care of
      }
    }
    if(c == board.length - 1) {
      return false;
    } //last column of row, return false
    return helper(r, c + 1); // if queen could be placed, try next column
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    if(!isEmpty()) throw new IllegalStateException(); //check if empty
    clearBoard(); //clear
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
