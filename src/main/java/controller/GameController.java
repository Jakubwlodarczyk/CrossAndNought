package controller;

import model.Game;
import view.DisplayGame;

public class GameController {
    private Game game = new Game();

    public void startGame() {
        game.initGame();
        DisplayGame.displayBoard(game.getBoard());
    }
}
