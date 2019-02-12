public class driver {

  public static void main(String[] args) {
    QueenBoard queenboard = new QueenBoard(8);
    QueenBoard queenboard1 = new QueenBoard(8);
    System.out.println(queenboard.solve());
    System.out.println(queenboard);
    System.out.println(queenboard1.countSolutions());
  }



}
