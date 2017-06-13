package model;

public class Board {

    private Cell[][] cells;

    public Board() {
        this.cells = new Cell[3][3];
    }

    public void init() {
        cells[0][0] = new Cell(1,1);
        cells[0][1] = new Cell(1,2);
        cells[0][2] = new Cell(1,3);
        cells[1][0] = new Cell(2,1);
        cells[1][1] = new Cell(2,2);
        cells[1][2] = new Cell(2,3);
        cells[2][0] = new Cell(3,1);
        cells[2][1] = new Cell(3,2);
        cells[2][2] = new Cell(3,3);
    }

    public boolean isDraw() {
        return true;
    }

    boolean hasWon() {
        return seedsInRowAreSame() ||
                seedsInColAreSame() ||
                seedsOnLeftBevelAreSame() ||
                seedsOnRightBevelAreSame();
    }

    private boolean seedsInColAreSame() {
        int rowIndex = 0;
        int firstColumn = 0;
        int secondColumn = 1;
        int thirdColumn = 2;
        for (Cell[] cell : cells) {
            if (cells[firstColumn][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[secondColumn][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[thirdColumn][rowIndex].getContent().equals(Seed.CROSS) ||
                    cells[firstColumn][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[secondColumn][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[thirdColumn][rowIndex].getContent().equals(Seed.NOUGHT)) {
                return true;
            }
            rowIndex++;
        }
        return false;
    }

    private boolean seedsInRowAreSame() {
        for (Cell[] row: this.cells) {
            if (row[0].getContent().equals(Seed.CROSS) &&
                    row[1].getContent().equals(Seed.CROSS) &&
                    row[2].getContent().equals(Seed.CROSS) ||
                    row[0].getContent().equals(Seed.NOUGHT) &&
                            row[1].getContent().equals(Seed.NOUGHT) &&
                            row[2].getContent().equals(Seed.NOUGHT)){
                return true;
            }
        }
        return false;
    }

    private boolean seedsOnLeftBevelAreSame() {
        return this.cells[0][0].getContent().equals(Seed.CROSS) &&
                this.cells[1][1].getContent().equals(Seed.CROSS) &&
                this.cells[2][2].getContent().equals(Seed.CROSS);
    }

    private boolean seedsOnRightBevelAreSame() {
        return this.cells[2][2].getContent().equals(Seed.CROSS) &&
                this.cells[1][1].getContent().equals(Seed.CROSS) &&
                this.cells[0][0].getContent().equals(Seed.CROSS);
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    void setCells(Cell[][] cells) {
        this.cells = cells;
    }

}
