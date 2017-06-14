package controller;

import model.Game;
import model.GameState;
import view.DisplayGame;

public class GameController {
    private Game game = new Game();

    public void startGame() {
        game.initGame();
        DisplayGame.printWelcomeInfo(game.getCurrentPlayer());

        while (game.getCurrentState().equals(GameState.PLAYING)) {
            DisplayGame.displayBoard(game.getBoard());
            DisplayGame.userInput(game.getCurrentPlayer());
        }
    }
}
