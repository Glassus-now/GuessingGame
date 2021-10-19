import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = getRandomNumberByDifficulty(scanner);
        loopTillRight(scanner, randomNumber);
    }

    private static int getRandomNumberByDifficulty(Scanner scanner) {
        Random random = new Random();
        int number = 0;
        System.out.println("Please select your difficulty by typing in the number 1-3:");
        System.out.println("1: easy (0-10), 2: medium (0-50), 3: hard (0-100)");
        int difficulty = Integer.parseInt(scanner.nextLine());
        if (difficulty == 1) {
            number = random.nextInt(11);
            System.out.println("Easy: ");
            System.out.println("Please enter your guess:");
        } else if (difficulty == 2) {
            number = random.nextInt(51);
            System.out.println("Medium: ");
            System.out.println("Please enter your guess:");
        } else {
            number = random.nextInt(101);
            System.out.println("Hard: ");
            System.out.println("Please enter your guess:");
        }
        return number;
    }

    private static boolean checkGuess (Scanner scanner,int randomNumber) {
        int guess = getGuess(scanner);
        if (guess == randomNumber) {
            System.out.println("Congratulations! CORRECT!");
            return true;
        } else if (guess < randomNumber) {
            System.out.println("Wrong! Too low! Try again!");
            return false;
        } else {
            System.out.println("Wrong! Too high! Try again!");
            return false;
        }
    }

    private static int getGuess (Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void loopTillRight(Scanner scanner,int randomNumber) {
        int count = 0;
        Boolean solved = false; // Ausgangswert
        while (!solved && count != 3) { // Abfrage IF Ausgangswert = true
            solved = checkGuess(scanner, randomNumber);
            System.out.println("You have " + (2 - count) + " trys left!");
            count ++;
        }
    }
}
