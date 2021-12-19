package ChatBot;

import java.time.LocalDate;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        System.out.println();
        System.out.println("Hello! My name is  Vasia");
        System.out.println("I was created in " + localDate);
        Scanner s11 = new Scanner(System.in);
        System.out.println("What a great name you have, " + s11.nextLine());


        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        ChatBot chatBot = new ChatBot();
        chatBot.calcAge(s11);
        chatBot.numberQuestion(s11);
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");

        while (true) {
            if (s11.next().contains("2")) {
                System.out.println("Great, you right!\nGoodbye, have a nice day!");
                break;
            } else System.out.println("Please, try again.");

        }


    }

    void calcAge(Scanner s11) {
        int remainder7 = s11.nextInt();
        int remainder5 = s11.nextInt();
        int remainder3 = s11.nextInt();
        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;
        System.out.println("Your age is " + age + " that's a good time to start programming!");

    }

    void numberQuestion(Scanner s11) {
        int i3 = s11.nextInt();
        for (int i = 0; i < i3 + 1; i++) {

            System.out.println(i + " !");
        }

        System.out.println("Let's test your programming knowledge.");
    }
}


