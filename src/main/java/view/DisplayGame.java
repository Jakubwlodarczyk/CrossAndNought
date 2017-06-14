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

    public static int getPositiveIntInput(Seed currentPlayer, String info) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.print("Player "+currentPlayer.toString()+" "+info);
        while (true) {
            while (!sc.hasNextInt()) {
                System.out.print("Input must be an number!" +
                        "\n" + "Player "+currentPlayer.toString()+" "+info);
                sc.next();
            }
            number = sc.nextInt();
            sc.nextLine();
            if (number >= 1 && number <= 3) {
                return number;
            } else {
                System.out.print("Number must be between 1 and 3" +
                        "\n" + "Player "+currentPlayer.toString()+" "+info);
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayMessage() {
        System.out.println("Chose another place sir!");
    }

    public static void displayGameResultOfGame(Seed player){
        if (player.equals(Seed.CROSS)){
            System.out.println("Game finished.'X' Won!");
        } else if(player.equals(Seed.NOUGHT)){
            System.out.println("Game finished.'O' Won!");
        }else {
            System.out.println("Game finished. It's a draw!");
        }
    }
}

