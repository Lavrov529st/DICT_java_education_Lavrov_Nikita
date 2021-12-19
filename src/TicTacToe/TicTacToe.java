package TicTacToe;

import java.util.Scanner;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cells : ");

        String input = sc.nextLine();

        printGrid(input);

        while (true) {

            try {

                System.out.print("Enter the coordinates: ");

                int x = sc.nextInt();
                int y = sc.nextInt();
                int target = -1;

                if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (x == 1) {
                        target = y - x;
                    } else if (x == 2) {
                        target = x + y;
                    } else if (x == 3 && y == 1) {
                        target = 6;
                    } else if (x == 3 && y == 2) {
                        target = 7;
                    } else if (x == 3 && y == 3) {
                        target = 8;
                    }
                }

                if (target != -1 && input.charAt(target) == '_') {

                    char[] arr = input.toCharArray();
                    arr[target] = 'X';
                    input = String.valueOf(arr);
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }

            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                sc.next();
            }
        }

        printGrid(input);
    }

    public static void printGrid(String str) {

        System.out.println("---------");

        System.out.println("| " + str.charAt(0) + " " + str.charAt(1) + " " + str.charAt(2) + " |");
        System.out.println("| " + str.charAt(3) + " " + str.charAt(4) + " " + str.charAt(5) + " |");
        System.out.println("| " + str.charAt(6) + " " + str.charAt(7) + " " + str.charAt(8) + " |");

        System.out.println("---------");
    }
}
