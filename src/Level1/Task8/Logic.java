package Level1.Task8;

import java.time.Year;
import java.util.Random;

public class Logic {
    static int SIZE;
    static int DOTS_TO_WIN;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Random random = new Random();

    static boolean gameFinished;

    static private int winFlag = -2;

    public static void goHA(int x, int y) {
        gameFinished = true;

        winFlag = -2;
        printMap();
        int[] coord = new int[2];

        if (checkWin(x, y, DOT_X)) {
            System.out.println("Вы выиграли!!!");
            winFlag = 1;
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            winFlag = 0;
            return;
        }

        coord = aiTurn();
        printMap();
        if (checkWin(coord[0], coord[1], DOT_O)) {
            System.out.println("Комьютер победил");
            winFlag = -1;
            return;
        }
        if (isFull()) {
            System.out.println("Ничья");
            winFlag = 0;
            return;
        }

        gameFinished = false;
    }

    public static void goHH(int x, int y, int userNumber) {
        gameFinished = true;

        winFlag = -2;
        printMap();

        if (userNumber == 1) {
            if (checkWin(x, y, DOT_X)) {
                System.out.println("Выиграли Х !!!");
                winFlag = 2;
                return;
            }
        } else {
            if (checkWin(x, y, DOT_O)) {
                System.out.println("Выиграли 0 !!!");
                winFlag = 3;
                return;
            }
        }
        if (isFull()) {
            System.out.println("Ничья");
            winFlag = 0;
            return;
        }

        gameFinished = false;
    }

    public int getWinFlag() {
        return winFlag;
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

    static void humanTurn(int x, int y, int mode, int userNumber) {
        if (isCellValid(y, x) && mode == 0) {
            map[y][x] = DOT_X;
            goHA(x, y);
        }
        if (isCellValid(y, x) && mode == 1) {
            if (userNumber == 1) {
                map[y][x] = DOT_X;
            } else {
                map[y][x] = DOT_O;
            }
            goHH(x, y, userNumber);
        }
    }

    static int[] aiTurn() {
        int x;
        int y;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '.') {
                    int[] coord = new int[]{i, j};
                    map[i][j] = DOT_X;
                    if (checkWin(i, j, DOT_X)) {
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
        int[] coord = new int[2];
        coord[0] = x;
        coord[1] = y;
        return coord;
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

    static boolean checkWin(int x, int y, char c) {

        int lowRangeX = x;
        int highRangeX = x;
        int lowRangeY = y;
        int highRangeY = y;

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

        for (int i = lowRangeX; i <= highRangeX; i++) {
            if (map[y][i] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;

        for (int i = lowRangeY; i <= highRangeY; i++) {
            if (map[i][x] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;
        int lowX = x;
        int lowY = y;
        int highX = x;
        int highY = y;

        while (lowX > lowRangeX) {
            lowX--;
        }
        while (lowY > lowRangeY) {
            lowY--;
        }

        while (highX < highRangeX) {
            highX++;
        }
        while (highY < highRangeY) {
            highY++;
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

        while (lowX > lowRangeX) {
            lowX--;
        }
        while (lowY > lowRangeY) {
            lowY--;
        }

        count = 0;

        while (highX >= lowX && lowY <= highY) {
            if (map[highX][lowY] == c) {
                count++;
                if (count == DOTS_TO_WIN) {
                    return true;
                }
            }
            highX--;
            lowY++;
        }

        return false;
    }
}
