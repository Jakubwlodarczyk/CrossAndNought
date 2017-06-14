package controller;

import model.Game;
import model.GameState;
import model.Seed;
import view.DisplayGame;

public class GameController {
    private Game game = new Game();

    public void startGame() {
        game.initGame();
        DisplayGame.clearScreen();
        DisplayGame.printWelcomeInfo(game.getCurrentPlayer());

        while (game.getCurrentState().equals(GameState.PLAYING)) {
            DisplayGame.displayBoard(game.getBoard());
            Integer row = DisplayGame.userInput(game.getCurrentPlayer(), "enter your move (row[1-3]): ");
            Integer col = DisplayGame.userInput(game.getCurrentPlayer(), "enter your move (col[1-3]): ");
            if (checkIfSeedIsEmpty(row, col)) {
                setCellContent(row,col,game.getCurrentPlayer());
            }
            game.getBoard().hasWon();
            game.getBoard().isDraw();
            game.togglePlayer();
            DisplayGame.clearScreen();
            }
        }

    private boolean checkIfSeedIsEmpty(int row, int col) {
        return game.getBoard().getCells()[row-1][col-1].getContent().equals(Seed.EMPTY);
    }

    private void setCellContent(int row, int col, Seed content) {
        game.getBoard().getCells()[row - 1][col - 1].setContent(content);
    }
}
