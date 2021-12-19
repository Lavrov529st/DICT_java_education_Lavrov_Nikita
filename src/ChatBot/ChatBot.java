package ChatBot;

import java.time.LocalDate;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
    LocalDate localDate = LocalDate.now();

        System.out.println();
        System.out.println("Hello! My name is  Vasia");
        System.out.println("I was created in " + localDate);

        System.out.println();
        System.out.println("Hello! My name is  Vasia");
        System.out.println("I was created in " + localDate);
        Scanner s11 = new Scanner(System.in);
        System.out.println("What a great name you have, " + s11.nextLine());
    }
}

