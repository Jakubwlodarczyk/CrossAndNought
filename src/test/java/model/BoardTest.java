package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;
    private Cell[][] cells;
    private int row1 = 0;
    private int row2 = 1;
    private int row3 = 2;
    private int col1 = 0;
    private int col2 = 1;
    private int col3 = 2;

    @BeforeEach
    void setup() {
        board = new Board();
        int numberOfRows = 3;
        int numberOfCols = 3;
        cells = new Cell[numberOfRows][numberOfCols];
        cells[row1][col1] = new Cell(1,1);
        cells[row1][col2] = new Cell(1,2);
        cells[row1][col3] = new Cell(1,3);
        cells[row2][col1] = new Cell(2,1);
        cells[row2][col2] = new Cell(2,2);
        cells[row2][col3] = new Cell(2,3);
        cells[row3][col1] = new Cell(3,1);
        cells[row3][col2] = new Cell(3,2);
        cells[row3][col3] = new Cell(3,3);
        board.setCells(cells);
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsInRowAreSame() {
        board.getCells()[row1][col1].setContent(Seed.CROSS);
        board.getCells()[row2][col2].setContent(Seed.CROSS);
        board.getCells()[row3][col3].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsInColAreSame() {
        board.getCells()[row1][col1].setContent(Seed.CROSS);
        board.getCells()[row2][col1].setContent(Seed.CROSS);
        board.getCells()[row3][col1].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsOnLeftBevelAreSame() {
        board.getCells()[row1][col1].setContent(Seed.CROSS);
        board.getCells()[row2][col2].setContent(Seed.CROSS);
        board.getCells()[row3][col3].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testHasWonMethodReturnTrueWhenSeedsOnRightBevelAreSame() {
        board.getCells()[row3][col3].setContent(Seed.CROSS);
        board.getCells()[row2][col2].setContent(Seed.CROSS);
        board.getCells()[row1][col1].setContent(Seed.CROSS);
        assertEquals(true, board.hasWon());
    }

    @Test
    void testIsDrawMethodReturnTrueWhenAllSeedInCellArrayAreDifferentFromEmptyAndNotSameInLine() {
        board.getCells()[row1][col1].setContent(Seed.CROSS);
        board.getCells()[row1][col2].setContent(Seed.NOUGHT);
        board.getCells()[row1][col3].setContent(Seed.CROSS);
        board.getCells()[row2][col1].setContent(Seed.NOUGHT);
        board.getCells()[row2][col2].setContent(Seed.CROSS);
        board.getCells()[row2][col3].setContent(Seed.NOUGHT);
        board.getCells()[row3][col1].setContent(Seed.NOUGHT);
        board.getCells()[row3][col2].setContent(Seed.CROSS);
        board.getCells()[row3][col3].setContent(Seed.NOUGHT);
        assertEquals(true, board.isDraw());
    }

    @Test
    void testGetCellsMethodReturnValidCellsValue() {
        for (Cell[] cells: board.getCells()){
            assertEquals(Seed.EMPTY, cells[row1].getContent());
            assertEquals(Seed.EMPTY, cells[row2].getContent());
            assertEquals(Seed.EMPTY, cells[row3].getContent());
        }
    }
}
