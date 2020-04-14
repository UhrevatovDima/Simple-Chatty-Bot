package tictactoe;

import java.util.Scanner;

public class Main {
    static boolean flagEnd = true;
    static Scanner scanner = new Scanner(System.in);
    static int steps = 0;

    public static void main(String[] args) {
        gaming();
    }

    public static void gameState(char[][] feeld) {
        int b = 5;
        int a = 9;
        int winsX = 0;
        int winsO = 0;
        int gNf = 0;
        int countX = 0;
        int countO = 0;
        for (int i = 1; i < b - 1; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (feeld[i][j] == 'X') {
                    countX++;
                }
                if (feeld[i][j] == 'O') {
                    countO++;
                }
                j++;
            }
        }

        for (int i = 1; i < b - 1; i++) {
            {
                if (feeld[i][2] == feeld[i][2 + 2]) {
                    if (feeld[i][2] == feeld[i][2 + 4]) {
                        if (feeld[i][2] == 'X') {
                            winsX++;
                        }
                        if (feeld[i][2] == 'O') {
                            winsO++;
                        }
                    }
                }
            }
        }

        for (int j = 2; j < a - 2; j++) {
            if (feeld[1][j] == feeld[1 + 1][j]) {
                if (feeld[1][j] == feeld[1 + 2][j]) {
                    if (feeld[1][j] == 'X') {
                        winsX++;
                    } else if (feeld[1][j] == 'O') {
                        winsO++;
                    }
                }
            }

        }

        for (int i = 1; i < 4; i++) {
            if (feeld[i][2] == feeld[i + 1][2 + 2]) {
                if (feeld[i][2] == feeld[i + 2][2 + 4]) {
                    if (feeld[i][2] == 'X') {
                        winsX++;
                    }
                    if (feeld[i][2] == 'O') {
                        winsO++;
                    }
                }
            }
        }

        for (int i = 1; i < 4; i++) {
            if (feeld[i][6] == feeld[i + 1][6 - 2]) {
                if (feeld[i][6] == feeld[i + 2][6 - 4]) {
                    if (feeld[i][6] == 'X') {
                        winsX++;
                    }
                    if (feeld[i][6] == 'O') {
                        winsO++;
                    }
                }
            }
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 2; j < a - 2; j++) {
                if (feeld[i][j] == ' ')
                    gNf++;
            }
        }
        while (true) {
            if ((winsX > 0 && winsO > 0) || (((countX - countO) >= 2) || (countO - countX) >= 2)) {
                System.out.println("Impossible");
                break;
            }
            if (winsX > 0) {
                System.out.println("X wins");
                flagEnd = false;
                break;
            }
            if (winsO > 0) {
                System.out.println("O wins");
                flagEnd = false;
                break;
            }
            if (gNf > 0 && steps < 8) {
                System.out.println("Game not finished");
                steps++;
                break;
            }
            if (winsX == 0 && winsO == 0) {
                System.out.println("Draw");
                flagEnd = false;
                break;
            }
        }
    }

    public static void gameConX(char[][] feeld) {
        boolean flag = true;

        while (flag) {
            System.out.print("Enter the coordinates X: ");
            String coord = scanner.nextLine();
            String[] coords = coord.split(" ");
            int[] cords = new int[2];
            try {
                if (Integer.parseInt(coords[1]) == 3) {
                    cords[0] = 1;
                }
                if (Integer.parseInt(coords[1]) == 1) {
                    cords[0] = 3;
                }
                if (Integer.parseInt(coords[1]) == 2) {
                    cords[0] = 2;
                }
                cords[1] = (Integer.parseInt(coords[0])) * 2;
                if (Integer.parseInt(coords[1]) > 3 || Integer.parseInt(coords[0]) > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (feeld[cords[0]][cords[1]] == ' ') {
                feeld[cords[0]][cords[1]] = 'X';
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(feeld[i][j]);
                    }
                    System.out.println();
                }
                flag = false;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static void gameConO(char[][] feeld) {
        boolean flag = true;

        while (flag) {
            System.out.print("Enter the coordinates O: ");
            String coord = scanner.nextLine();
            String[] coords = coord.split(" ");
            int[] cords = new int[2];
            try {
                if (Integer.parseInt(coords[1]) == 3) {
                    cords[0] = 1;
                }
                if (Integer.parseInt(coords[1]) == 1) {
                    cords[0] = 3;
                }
                if (Integer.parseInt(coords[1]) == 2) {
                    cords[0] = 2;
                }
                cords[1] = (Integer.parseInt(coords[0])) * 2;
                if (Integer.parseInt(coords[1]) > 3 || Integer.parseInt(coords[0]) > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (feeld[cords[0]][cords[1]] == ' ') {
                feeld[cords[0]][cords[1]] = 'O';
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.print(feeld[i][j]);
                    }
                    System.out.println();
                }
                flag = false;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
            }
        }
    }

    public static void gaming() {
        int b = 5;
        int a = 9;
        char[][] field = new char[b][a];

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = ' ';
            }
        }

        for (int i = 0; i < b; ) {
            for (int j = 0; j < a; j++) {
                field[i][j] = '-';
            }
            i += b - 1;
        }

        field[1][0] = '|';
        field[1][a - 1] = '|';
        field[2][0] = '|';
        field[2][a - 1] = '|';
        field[3][0] = '|';
        field[3][a - 1] = '|';

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        while (flagEnd) {
            gameConX(field);
            gameState(field);
            if (!flagEnd)
                break;
            gameConO(field);
            gameState(field);
            if (!flagEnd)
                break;
        }
    }
}