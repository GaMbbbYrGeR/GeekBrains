package Level1.Task3;

import java.util.Random;
import java.util.Scanner;

public class Task3_1 {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int randomNumber;
        int ready = 1;
        do {
            randomNumber = random.nextInt(10);
            for (int i = 0; i < 3; i++) {
                int x = sc.nextInt();
                if (x == randomNumber) {
                    System.out.println("Ты угадал число !!!");
                    break;
                } else if (x > randomNumber) {
                    System.out.println("Не угадал, число меньше твоего");
                } else {
                    System.out.println("Не угадал, число больше твоего");
                }
                if (i == 2) {
                    System.out.println("Ты пытался )))");
                }
            }
            System.out.println("Сыграем еще раз?");
            ready = sc.nextInt();
        } while (ready == 1);
    }
}
