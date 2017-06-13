package model;

public class Game {
    private Board board = new Board();
    private GameState currentState;
    private Seed currentPlayer;

    public Game() {
    }

    public void initGame() {
        board.init();
    }

    public void updateGameState(Seed seed, int row, int col) {
    }

    public Board getBoard() {
        return board;
    }
}
