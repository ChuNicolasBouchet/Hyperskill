package tictactoe;

import java.util.Scanner;

public class checkEmptyCell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String playerInput = "";
        while (!playerInput.matches("^[XO_]{9}$")) {
            playerInput = scanner.nextLine();
        }
        char[] charArray = playerInput.toCharArray();
        char[][] gameArray = new char[3][3];

        for (int i = 0; i < charArray.length; i++) {
            int row = i / 3;
            int column = i % 3;
            gameArray[row][column] = charArray[i];
        }

        showGameArray(gameArray);

        if (!checkThreeInARow(gameArray, 'X') && !checkThreeInARow(gameArray, 'O') && checkEmptyCell(charArray) && !checkPlayDifference(charArray)) {
            System.out.println("Game not finished");
        } else if (!checkThreeInARow(gameArray, 'X') && !checkThreeInARow(gameArray, 'O') && !checkEmptyCell(charArray)){
            System.out.println("Draw");
        } else if (checkThreeInARow(gameArray, 'X') && !checkThreeInARow(gameArray, 'O')) {
            System.out.println("X wins");
        } else if (checkThreeInARow(gameArray, 'O') && !checkThreeInARow(gameArray, 'X')) {
            System.out.println("O wins");
        } else if (checkThreeInARow(gameArray, 'X') && checkThreeInARow(gameArray, 'O') || checkPlayDifference(charArray)) {
            System.out.println("Impossible");
        }


    }
    public static boolean checkEmptyCell(char[] charArray) {
        boolean empty = false;
        for (char c : charArray) {
            if ('_' == c) {
                empty = true;
                break;
            }
        }
        return empty;
    }

    public static boolean checkThreeInARow(char[][] gameArray, char symbol) {

        boolean win = false;
        int i, j;
        // Check by _ row
        for (i = 0; i < gameArray.length && !win; i++) {
            for (j = 0; j < gameArray[0].length; j++) {
                if (gameArray[i][j] != symbol) {
                    break;
                }
            }
            if (j == gameArray.length) {
                win = true;
            }
        }
        // Check by | column
        if (!win) {
            for (j = 0; j < gameArray[0].length && !win; j++) {
                for (i = 0; i < gameArray.length; i++) {
                    if (gameArray[i][j] != symbol) {
                        break;
                    }
                }
                if (i == gameArray[0].length) {
                    win = true;
                }
            }
        }
        // Check by diagonal \
        if (!win) {
            for (i = 0; i < gameArray.length; i++) {
                if (gameArray[i][i] != symbol) {
                    break;
                }
                if (i == gameArray.length - 1) {
                    win = true;
                }
            }
        }
        // Check by diagonal /
        if (!win) {
            for (i = 0; i < gameArray.length; i++) {
                if (gameArray[i][gameArray.length - 1 - i] != symbol) {
                    break;
                }
            }
            if (i == gameArray.length) {
                win = true;
            }
        }
        return win;
    }

    public static void showGameArray(char[][] gameArray) {
        System.out.println("---------");
        for (char[] yChars : gameArray) {
            System.out.print("| ");
            for (char xChar : yChars) {
                System.out.print(xChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    public static boolean checkPlayDifference(char[] charArray) {
        boolean playerDifference = false;
        int x = 0, o = 0;
        for (char player : charArray) {
            if ('X' == player) {
                x++;
            } else if ('O' == player) {
                o++;
            }
        }
        if ((x - o) > 1 || o - x > 1) {
            playerDifference = true;
        }
        return playerDifference;
    }
}
