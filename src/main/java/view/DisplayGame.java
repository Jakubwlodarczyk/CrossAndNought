package view;

import model.Board;
import model.Cell;


public class DisplayGame {
    public static void displayBoard(Board board) {
        int line = 0;
        for (Cell[] cells: board.getCells()) {
            System.out.println(cells[0].toString()+" | "+cells[1].toString()+" | "+
                    cells[2].toString());
            if (line < 2) {
                System.out.println("---------");
            }
            line++;
        }
    }
}

