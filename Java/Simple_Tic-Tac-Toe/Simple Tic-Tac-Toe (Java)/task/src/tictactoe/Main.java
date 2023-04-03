package tictactoe;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String[][] gameArray = new String[3][3];
        for (int i = 0; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray[i].length; j++) {
                String symbol = String.valueOf(scanner.next().charAt(i));
                if ((Objects.equals("O", symbol)) || (Objects.equals("X", symbol)) || (Objects.equals("_", symbol))) {
                    gameArray[i][j] = symbol;
                } else {
                    System.out.println("Error, only 'X', 'O', or'_' accepted");
                    break;
                }
            }
        }
        // TODO create a regex to test the input

        for (int i = 0; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray[i].length; j++) {
                System.out.println(gameArray[i][j]);
            }
        }
    }
}
