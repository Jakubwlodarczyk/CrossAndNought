package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    @BeforeEach
    void setup(){
        game = new Game();
    }

    @Test
    void testInitMethodFillsAllCellsInTheBoardWithObjects() {
        game.initGame();
        int fstIndex = 0;
        int scndIndex = 1;
        int thirdIndex = 2;
        for (Cell[] cells: game.getBoard().getCells()){
            assertNotNull(cells[fstIndex]);
            assertNotNull(cells[scndIndex]);
            assertNotNull(cells[thirdIndex]);
        }
    }

    @Test
    void testInitMethodSetsCurrentPlayerAttrAsCrossOrNought() {
        game.initGame();
        assertTrue(game.getCurrentPlayer().equals(Seed.CROSS)||
                            game.getCurrentPlayer().equals(Seed.NOUGHT));
    }

    @Test
    void testInitMethodSetsCurrentStateAttributeAsPlaying() {
        game.initGame();
        assertEquals(game.getCurrentState(), GameState.PLAYING);
    }
}