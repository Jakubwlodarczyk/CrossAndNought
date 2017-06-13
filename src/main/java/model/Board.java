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
        return true;
    }

    public Cell[][] getCells() {
        return this.cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

}
