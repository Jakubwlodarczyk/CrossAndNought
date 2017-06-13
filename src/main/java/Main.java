import model.Board;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        board.init();
        System.out.println(board);
        System.out.println(board.getCells());
        System.out.println(board.getCells()[0][0]);
    }
}
