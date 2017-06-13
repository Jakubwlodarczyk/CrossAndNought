package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private Cell[][] cells;

    @BeforeEach
    void setup() {
        board = new Board();
        cells = new Cell[3][3];
        cells[0][0] = new Cell(1,1);
        cells[0][1] = new Cell(1,2);
        cells[0][2] = new Cell(1,3);
        cells[1][0] = new Cell(2,1);
        cells[1][1] = new Cell(2,2);
        cells[1][2] = new Cell(2,3);
        cells[2][0] = new Cell(3,1);
        cells[2][1] = new Cell(3,2);
        cells[2][2] = new Cell(3,3);
        board.setCells(cells);
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsInRowAreSame() {
        board.getCells()[0][0].setContent(Seed.CROSS);
        board.getCells()[0][1].setContent(Seed.CROSS);
        board.getCells()[0][2].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsInColAreSame() {
        board.getCells()[0][0].setContent(Seed.CROSS);
        board.getCells()[1][0].setContent(Seed.CROSS);
        board.getCells()[2][0].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsOnLeftBevelAreSame() {
        board.getCells()[0][0].setContent(Seed.CROSS);
        board.getCells()[1][1].setContent(Seed.CROSS);
        board.getCells()[2][2].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsOnRightBevelAreSame() {
        board.getCells()[2][2].setContent(Seed.CROSS);
        board.getCells()[1][1].setContent(Seed.CROSS);
        board.getCells()[0][0].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }
}