package model;

import java.util.Random;

import static model.GameState.*;

public class Game {
    private Board board = new Board();
    private GameState currentState;
    private Seed currentPlayer;

    public Game() {
    }

    public void initGame() {
        board.init();
        setCurrentPlayer(chooseFirstPlayer());
        setCurrentState(PLAYING);
    }

    private static Seed chooseFirstPlayer() {
        Random random = new Random();
        return (random.nextInt()%2 == 0)?Seed.CROSS:Seed.NOUGHT;
    }

    public void updateGameState(Seed seed, int row, int col) {
    }

    GameState getCurrentState() {
        return currentState;
    }

    Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    private void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    private void setCurrentPlayer(Seed currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
