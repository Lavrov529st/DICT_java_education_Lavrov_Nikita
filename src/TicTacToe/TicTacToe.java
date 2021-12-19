package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cells : ");

        String input = sc.nextLine();

        System.out.println("---------");

        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");

        System.out.println("---------");

        if (input.contains("_")) {

            if ((countX(input) - countO(input) > 1) || (countO(input) - countX(input) > 1)) {
                System.out.println("Impossible");
            } else if (bothWon(input)) {
                System.out.println("Impossible");
            } else if (xWon(input)) {
                System.out.println("X wins");
            } else if (oWon(input)) {
                System.out.println("O wins");
            } else {
                System.out.println("Game not finished");
            }
        } else {

            if (bothWon(input)) {
                System.out.println("Impossible");
            } else if (xWon(input)) {
                System.out.println("X wins");
            } else if (oWon(input)) {
                System.out.println("O wins");
            } else {
                System.out.println("Draw");
            }
        }
    }

    public static int countX(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'X') {
                count++;
            }
        }
        return count;
    }

    public static int countO(String str) {

        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == 'O') {
                count++;
            }
        }
        return count;
    }

    public static boolean bothWon(String str) {

        if (((str.charAt(0) + str.charAt(1) + str.charAt(2) == 88 * 3) || (str.charAt(0) + str.charAt(1) + str.charAt(2) == 79 * 3)) &&
                ((str.charAt(3) + str.charAt(4) + str.charAt(5) == 88 * 3) || (str.charAt(3) + str.charAt(4) + str.charAt(5) == 79 * 3))) {
            return true;
        }

        else if (((str.charAt(0) + str.charAt(1) + str.charAt(2) == 88 * 3) || (str.charAt(0) + str.charAt(1) + str.charAt(2) == 79 * 3)) &&
                ((str.charAt(6) + str.charAt(7) + str.charAt(8) == 88 * 3) || (str.charAt(6) + str.charAt(7) + str.charAt(8) == 79 * 3))) {
            return true;
        }

        else if (((str.charAt(3) + str.charAt(4) + str.charAt(5) == 88 * 3) || (str.charAt(3) + str.charAt(4) + str.charAt(5) == 79 * 3)) &&
                ((str.charAt(6) + str.charAt(7) + str.charAt(8) == 88 * 3) || (str.charAt(6) + str.charAt(7) + str.charAt(8) == 79 * 3))) {
            return true;
        }

        else if (((str.charAt(0) + str.charAt(3) + str.charAt(6) == 88 * 3) || (str.charAt(0) + str.charAt(3) + str.charAt(6) == 79 * 3)) &&
                ((str.charAt(1) + str.charAt(4) + str.charAt(7) == 88 * 3) || (str.charAt(1) + str.charAt(4) + str.charAt(7) == 79 * 3))) {
            return true;
        }

        else if (((str.charAt(0) + str.charAt(3) + str.charAt(6) == 88 * 3) || (str.charAt(0) + str.charAt(3) + str.charAt(6) == 79 * 3)) &&
                ((str.charAt(2) + str.charAt(5) + str.charAt(8) == 88 * 3) || (str.charAt(2) + str.charAt(5) + str.charAt(8) == 79 * 3))) {
            return true;
        }

        else if (((str.charAt(1) + str.charAt(4) + str.charAt(7) == 88 * 3) || (str.charAt(1) + str.charAt(4) + str.charAt(7) == 79 * 3)) &&
                ((str.charAt(2) + str.charAt(5) + str.charAt(8) == 88 * 3) || (str.charAt(2) + str.charAt(5) + str.charAt(8) == 79 * 3))) {
            return true;
        }

        return false;
    }

    public static boolean xWon(String str) {

        if ((str.charAt(0) == 'X' && str.charAt(1) == 'X' && str.charAt(2) == 'X') ||
                (str.charAt(3) == 'X' && str.charAt(4) == 'X' && str.charAt(5) == 'X') ||
                (str.charAt(6) == 'X' && str.charAt(7) == 'X' && str.charAt(8) == 'X') ||
                (str.charAt(0) == 'X' && str.charAt(3) == 'X' && str.charAt(6) == 'X') ||
                (str.charAt(1) == 'X' && str.charAt(4) == 'X' && str.charAt(7) == 'X') ||
                (str.charAt(2) == 'X' && str.charAt(5) == 'X' && str.charAt(8) == 'X') ||
                (str.charAt(0) == 'X' && str.charAt(4) == 'X' && str.charAt(8) == 'X') ||
                (str.charAt(2) == 'X' && str.charAt(4) == 'X' && str.charAt(6) == 'X')) {
            return true;
        }

        return false;
    }

    public static boolean oWon(String str) {

        if ((str.charAt(0) == 'O' && str.charAt(1) == 'O' && str.charAt(2) == 'O') ||
                (str.charAt(3) == 'O' && str.charAt(4) == 'O' && str.charAt(5) == 'O') ||
                (str.charAt(6) == 'O' && str.charAt(7) == 'O' && str.charAt(8) == 'O') ||
                (str.charAt(0) == 'O' && str.charAt(3) == 'O' && str.charAt(6) == 'O') ||
                (str.charAt(1) == 'O' && str.charAt(4) == 'O' && str.charAt(7) == 'O') ||
                (str.charAt(2) == 'O' && str.charAt(5) == 'O' && str.charAt(8) == 'O') ||
                (str.charAt(0) == 'O' && str.charAt(4) == 'O' && str.charAt(8) == 'O') ||
                (str.charAt(2) == 'O' && str.charAt(4) == 'O' && str.charAt(6) == 'O')) {
            return true;
        }

        return false;
    }
}
