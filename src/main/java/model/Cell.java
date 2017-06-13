package model;

public class Cell {
    private Seed content;
    private int row;
    private int col;

    public void setContent(Seed content) {
        this.content = content;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.content = Seed.EMPTY;
    }

    public void clear() {
        this.content = Seed.EMPTY;
    }

    public String toString() {
        switch (this.content){
            case CROSS:
                return "X";
            case NOUGHT:
                return "O";
            case EMPTY:
                return " ";
        }
        return null;
    }
}
