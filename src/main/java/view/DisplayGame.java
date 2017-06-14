package view;

import model.Board;
import model.Cell;
import model.Seed;

import java.util.Scanner;


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

    public static void printWelcomeInfo(Seed firstPlayer) {
        System.out.println("...:: CROSS and NOUGHT ::...");
        System.out.println("Player " + firstPlayer.toString() + " will be the first player this round!");
    }

    public static void userInput(Seed currentPlayer) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Player " + currentPlayer.toString() + " enter your move (row[1-3], column[1-3]): " );
        int userInput = reader.nextInt();
        System.out.println(userInput);
    }
}

