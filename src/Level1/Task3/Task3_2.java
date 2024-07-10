package Level1.Task3;

import java.util.Random;
import java.util.Scanner;

public class Task3_2 {
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};
        int randomIndex = random.nextInt(words.length);
        String gameWord = words[randomIndex];
        boolean winLose = true;
        String playerWord;
        int iLenthg;
        while (winLose) {
            playerWord = sc.next();
            if (gameWord.equals(playerWord)) {
                System.out.println("Ты угадал слово !!!");
                winLose = false;
                break;
            } else {
                if (gameWord.length() > playerWord.length()) {
                    iLenthg = playerWord.length();
                } else {
                    iLenthg = gameWord.length();
                }
                for (int i = 0; i < iLenthg; i++) {
                    if (gameWord.charAt(i) == playerWord.charAt(i)) {
                        System.out.print(gameWord.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                for (int i = 0; i < 15 - iLenthg; i++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
    }

}
