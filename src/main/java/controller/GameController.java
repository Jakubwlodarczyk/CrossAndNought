package controller;

import model.Game;
import model.GameState;
import model.Seed;
import ui.UserInput;
import view.DisplayGame;


public class GameController {

    private Game game = new Game();

    public void initGame() {
        game.initGame();
        DisplayGame.clearScreen();
        DisplayGame.printWelcomeInfo(game.getCurrentPlayer());
    }

    public void startGame() {
        boolean playGame = true;
        while (playGame) {
            while (game.getCurrentState().equals(GameState.PLAYING)) {
                DisplayGame.displayBoard(game.getBoard());
                Integer row = UserInput.getPositiveIntInput(game.getCurrentPlayer(), "enter your move (row[1-3]): ");
                Integer col = UserInput.getPositiveIntInput(game.getCurrentPlayer(), "enter your move (col[1-3]): ");
                if (isSeedEmpty(row, col)) {
                    setCellContent(row, col, game.getCurrentPlayer());
                } else {
                    DisplayGame.displayMessage("Chose another place sir!");
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
                game.switchPlayer();
                DisplayGame.clearScreen();
            }
            DisplayGame.displayGameResult(game.getCurrentPlayer());
            DisplayGame.displayMessage("\n");
            if (UserInput.getUserPlayAgainAnswer().equals("n")) {
                playGame = false;
                DisplayGame.displayMessage("Hope you enjoyed! C U later!");
            } else {
                game.initGame();
                DisplayGame.clearScreen();
                DisplayGame.printWelcomeInfo(game.getCurrentPlayer());
            }
        }
    }

    boolean isSeedEmpty(int row, int col) {
        return game.getBoard().getCells()[row-1][col-1].getContent().equals(Seed.EMPTY);
    }

    private void setCellContent(int row, int col, Seed content) {
        game.getBoard().getCells()[row - 1][col - 1].setContent(content);
    }
}
