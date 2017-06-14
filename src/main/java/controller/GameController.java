package controller;

import model.Game;
import model.GameState;
import model.Seed;
import view.DisplayGame;

public class GameController {
    private Game game = new Game();

    public void initGame() {
        game.initGame();
        DisplayGame.clearScreen();
        DisplayGame.printWelcomeInfo(game.getCurrentPlayer());
    }

    public void startGame() {
        while (game.getCurrentState().equals(GameState.PLAYING)) {
            DisplayGame.displayBoard(game.getBoard());
            Integer row = DisplayGame.getPositiveIntInput(game.getCurrentPlayer(), "enter your move (row[1-3]): ");
            Integer col = DisplayGame.getPositiveIntInput(game.getCurrentPlayer(), "enter your move (col[1-3]): ");
            if (checkIfSeedIsEmpty(row, col)) {
                setCellContent(row, col, game.getCurrentPlayer());
            } else {
                DisplayGame.displayMessage();
                continue;
            }
            if (game.getBoard().hasWon()) {
                if (game.getCurrentPlayer().equals(Seed.CROSS)) {
                    game.setCurrentState(GameState.CROSS_WON);
                } else {
                    game.setCurrentState(GameState.NOUGHT_WON);
                }
                break;
            }
            if (game.getBoard().isDraw()) {
                game.setCurrentPlayer(Seed.EMPTY);
                game.setCurrentState(GameState.DRAW);
                break;
            }
            game.togglePlayer();
            DisplayGame.clearScreen();
            }
        DisplayGame.displayGameResultOfGame(game.getCurrentPlayer());
        }

    private boolean checkIfSeedIsEmpty(int row, int col) {
        return game.getBoard().getCells()[row-1][col-1].getContent().equals(Seed.EMPTY);
    }

    private void setCellContent(int row, int col, Seed content) {
        game.getBoard().getCells()[row - 1][col - 1].setContent(content);
    }
}
