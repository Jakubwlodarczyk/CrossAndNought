package model;

public class Board {

    private Cell[][] cells;
    private int row1 = 0;
    private int row2 = 1;
    private int row3 = 2;
    private int col1 = 0;
    private int col2 = 1;
    private int col3 = 2;

    Board() {
        this.cells = new Cell[3][3];
    }

    void init() {
        cells[row1][col1] = new Cell(1,1);
        cells[row1][col2] = new Cell(1,2);
        cells[row1][col3] = new Cell(1,3);
        cells[row2][col1] = new Cell(2,1);
        cells[row2][col2] = new Cell(2,2);
        cells[row2][col3] = new Cell(2,3);
        cells[row3][col1] = new Cell(3,1);
        cells[row3][col2] = new Cell(3,2);
        cells[row3][col3] = new Cell(3,3);
    }

    public boolean isDraw() {
        if (!hasWon()) {
            for (Cell[] cellList : cells) {
                for (Cell cell : cellList) {
                    if (cell.getContent().equals(Seed.EMPTY)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean hasWon() {
        return seedsInRowAreSame() ||
                seedsInColAreSame() ||
                seedsOnLeftBevelAreSame() ||
                seedsOnRightBevelAreSame();
    }

    private boolean seedsInColAreSame() {
        int rowIndex = 0;
        for (Cell[] cell : cells) {
            if (cells[col1][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[col2][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[col3][rowIndex].getContent().equals(Seed.CROSS) ||
                    cells[col1][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[col2][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[col3][rowIndex].getContent().equals(Seed.NOUGHT)) {
                return true;
            }
            rowIndex++;
        }
        return false;
    }

    private boolean seedsInRowAreSame() {
        for (Cell[] row: this.cells) {
            if (row[col1].getContent().equals(Seed.CROSS) &&
                    row[col2].getContent().equals(Seed.CROSS) &&
                    row[col3].getContent().equals(Seed.CROSS) ||
                    row[col1].getContent().equals(Seed.NOUGHT) &&
                            row[col2].getContent().equals(Seed.NOUGHT) &&
                            row[col3].getContent().equals(Seed.NOUGHT)){
                return true;
            }
        }
        return false;
    }

    private boolean seedsOnLeftBevelAreSame() {
        return this.cells[row1][col1].getContent().equals(Seed.CROSS) &&
                this.cells[row2][col2].getContent().equals(Seed.CROSS) &&
                this.cells[row3][col3].getContent().equals(Seed.CROSS);
    }

    private boolean seedsOnRightBevelAreSame() {
        return this.cells[row3][col3].getContent().equals(Seed.CROSS) &&
                this.cells[row2][col2].getContent().equals(Seed.CROSS) &&
                this.cells[row1][col1].getContent().equals(Seed.CROSS);
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    void setCells(Cell[][] cells) {
        this.cells = cells;
    }

}
