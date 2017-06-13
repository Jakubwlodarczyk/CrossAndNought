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

    public boolean hasWon() {
        return seedsInColAreSame();
    }

    private boolean seedsInColAreSame() {
        int rowIndex = 0;
        for (int index=0; index<cells.length; index++) {
            if (cells[0][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[1][rowIndex].getContent().equals(Seed.CROSS) &&
                    cells[2][rowIndex].getContent().equals(Seed.CROSS) ||
                    cells[0][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[1][rowIndex].getContent().equals(Seed.NOUGHT) &&
                            cells[2][rowIndex].getContent().equals(Seed.NOUGHT)) {
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

//    private boolean seedsOnLeftBevelAreSame() {
//
//    }
//
//    private boolean seedsOnRightBevelAreSame() {
//
//    }



//    SeedsInCol
//             SeedsinRow
//            SeedsOnLeftBevel
//    SeedsOnRightBevel
    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

}
