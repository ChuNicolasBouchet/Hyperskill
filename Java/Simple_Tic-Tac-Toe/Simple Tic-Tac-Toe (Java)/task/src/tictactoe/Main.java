package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        char[][] gameArray = new char[3][3];
        for (char[] chars : gameArray) {
            Arrays.fill(chars, ' ');
        }

        boolean toogle = false;
        boolean winner = false;

        do {
            toogle = !toogle;
            showGameArray(gameArray);
            char currentPlayer = toogle ? 'X' : 'O';
            int[] playerCoord;
            do {
                playerCoord = checkPlayerInput();
                if (checkOccupied(gameArray, playerCoord)) {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } while (checkOccupied(gameArray, playerCoord));

            makeAMove(gameArray, playerCoord, currentPlayer);
            if (checkThreeInARow(gameArray, currentPlayer)) {
                winner = true;
            } else if (checkFull(gameArray)) {
                break;
            }
        } while (!winner) ;
        showGameArray(gameArray);
        if (winner) {
        char winnerIs = toogle ? 'X' : 'O';
        System.out.println(winnerIs + " wins");
        } else {
            System.out.println("Draw");
        }
    }


    public static int[] checkPlayerInput() {
        Scanner scanner = new Scanner(System.in);

        String playerInput = "";
        int[] playerChoice = new int[2];

        while (!playerInput.matches("^[0-9] [0-9]$") || !playerInput.matches("^[1-3] [1-3]$")) {
            playerInput = scanner.nextLine();
            if (!playerInput.matches("^[0-9] [0-9]$")) {
                System.out.println("You should enter numbers!");
            } else if (!playerInput.matches("^[1-3] [1-3]$")) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
            String[] playerInputSplit = playerInput.split(" ");
            for (int i = 0; i < 2; i++) {
                playerChoice[i] = Integer.parseInt(playerInputSplit[i]);
            }
            playerChoice[0]--;
            playerChoice[1]--;
        }
    }
        return playerChoice;
    }

    public static void makeAMove(char[][] gameArray, int[] playerChoice, char player) {
        gameArray[playerChoice[0]][playerChoice[1]] = player;
    }

    public static boolean checkOccupied(char[][] gameArray, int[] playerMove) {
        return gameArray[playerMove[0]][playerMove[1]] == 'X' || gameArray[playerMove[0]][playerMove[1]] == 'O';
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

    public static boolean checkFull(char[][] gameArray) {
        boolean full = false;
        int x = 0, o = 0;

        for (int i = 0; i < gameArray.length; i++) {
            for (int j = 0; j < gameArray[0].length; j++) {
                if (gameArray[i][j] == 'X') {
                    x++;
                } else if (gameArray[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (x + o == 9) {
            full = true;
        }
        return full;
    }
}
