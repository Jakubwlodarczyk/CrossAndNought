package ui;

import model.Seed;

import java.util.Scanner;

public class UserInput {

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

    public static String getUserPlayAgainAnswer() {
        String answer;
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to play again? [y/n]");
        while (true) {
            while (!sc.hasNext()) {
                System.out.println("Wrong input!");
                sc.next();
            }
            answer = sc.next();
            sc.nextLine();
            if (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("n")) {
                return answer;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }
}
