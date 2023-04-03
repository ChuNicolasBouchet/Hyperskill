package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        String playerInput = "";
        while (!playerInput.matches("^[XO_]{9}$")) {
            playerInput = scanner.nextLine();
        }
        char[] symbol = playerInput.toCharArray();
        char[][] gameArray = new char[3][3];

        for (int i = 0; i < symbol.length; i++) {
            int row = i / 3;
            int column = i % 3;
            gameArray[row][column] = symbol[i];
        }

        System.out.println("---------");
        for (int i = 0; i < gameArray.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < gameArray[i].length; j++) {
                System.out.print(gameArray[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
