package Level1.Task4;

import java.util.Random;
import java.util.Scanner;

public class Task4_1 {
    static final int SIZE = 8;
    static final int DOTS_TO_WIN = 4;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();


    public static void main(String[] args) {
        initMap();
        printMap();
        int[] coord = new int[2];

        while (true) {
            coord = humanTurn();
            printMap();
            if (checkWin(coord, DOT_X)) {
                System.out.println("Вы выиграли!!!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            coord = aiTurn();
            printMap();
            if (checkWin(coord, DOT_O)) {
                System.out.println("Комьютер победил");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", map[i][j]);
            }
            System.out.println();
        }
    }

    static int[] humanTurn() {
        int x;
        int y;
        do {
            System.out.println("input coord X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = DOT_X;
        int mas[] = new int[]{y, x};
        return mas;
    }

    static int[] aiTurn() {
        int x;
        int y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '.') {
                    int[] coord = new int[] {i,j};
                    map[i][j] = DOT_X;
                    if (checkWin(coord, DOT_X)) {
                        map[i][j] = DOT_O;
                        return coord;
                    } else {
                        map[i][j] = '.';
                    }
                }
            }
        }
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
        int mas[] = new int[]{y, x};
        return mas;
    }


    static boolean isCellValid(int y, int x) {
        if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(int[] coord, char c) {

        int lowRangeX = coord[0];
        int highRangeX = coord[0];
        int lowRangeY = coord[1];
        int highRangeY = coord[1];

        for (int i = 0; i < DOTS_TO_WIN - 1; i++) {
            if (lowRangeX > 0) {
                lowRangeX--;
            }
            if (highRangeX < SIZE - 1) {
                highRangeX++;
            }
            if (lowRangeY > 0) {
                lowRangeY--;
            }
            if (highRangeY < SIZE - 1) {
                highRangeY++;
            }
        }

        int count = 0;

        for (int i = lowRangeX; i < highRangeX; i++) {
            if (map[i][coord[1]] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;

        for (int i = lowRangeY; i < highRangeY; i++) {
            if (map[coord[0]][i] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;
        int i = coord[0];
        int j = coord[1];
        int lowX = coord[0];
        int lowY = coord[1];
        int highX = coord[0];
        int highY = coord[1];

        while (i >= lowRangeX && j >= lowRangeY) {
            lowX = i--;
            lowY = j--;
        }

        while (i <= highRangeX && j <= highRangeY) {
            highX = i++;
            highY = j++;
        }

        while (lowX <= highX && lowY <= highY) {
            if (map[lowX][lowY] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
            lowX++;
            lowY++;
        }

        return false;
    }
}
