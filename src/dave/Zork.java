package dave;

import java.util.Scanner;

public class Zork {
    public final static int WINDOW = 0;
    public final static int FOYER = 1;
    public final static int FRONT = 2;
    public final static int LIBRARY = 3;
    public final static int KITCHEN = 4;
    public final static int DINING = 5;
    public final static int VAULT = 6;
    public final static int PARLOR = 7;

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int input, room = FOYER;
        String quit = "anything";


        do {

            // foyer
            if (room == FOYER) {
                System.out.println("You are standing in the foyer of an old house.");
                System.out.println("You see a dead scorpion.");
                System.out.print("You can (1) exit to the north, (2) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = FRONT;
                else if (input == 2)
                    quit = "run";

                // front room
            } else if (room == FRONT) {
                System.out.println("You are standing in the front room.");
                System.out.println("You see a piano.");
                System.out.println("You can (1) exit to the south, (2) exit to the east, (3) exit to the west, (4) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = FOYER;
                else if (input == 2)
                    room = LIBRARY;
                else if (input == 3)
                    room = KITCHEN;
                else if (input == 4)
                    quit = "run";

                // library
            } else if (room == LIBRARY) {
                System.out.println("You are standing in the library.");
                System.out.println("You see a spiders.");
                System.out.println("You can (1) exit to the west, (2) exit to the north, (3) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = 2;
                else if (input == 2)
                    room = 5;
                else if (input == 3)
                    quit = "run";

                // kitchen
            } else if (room == KITCHEN) {
                System.out.println("You are standing in the kitchen.");
                System.out.println("You see a bats.");
                System.out
                        .println("You can (1) exit to the east, (2) exit to the north, (3) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = 2;
                else if (input == 2)
                    room = 7;
                else if (input == 3)
                    quit = "run";

                // dining room
            } else if (room == DINING) {
                System.out.println("You are standing in the dining room.");
                System.out.println("You see a dust and empty box.");
                System.out.println("You can (1) exit to the south, (2) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = 3;
                else if (input == 2)
                    quit = "run";

                // vault
            } else if (room == VAULT) {
                System.out.println("You are standing in the vault.");
                System.out.println("You see a three walking skeletons.");
                System.out.println("You can (1) exit to the east, (2) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = 7;
                else if (input == 2)
                    quit = "run";

                // parlor
            } else if (room == PARLOR) {
                System.out.println("You are standing in the parlor.");
                System.out.println("You see a treasure chest.");
                System.out
                        .println("You can (1) exit to the west, (2) exit to the south, (3) run. ");

                input = keyboard.nextInt();
                if (input == 1)
                    room = 6;
                else if (input == 2)
                    room = 4;
                else if (input == 3)
                    quit = "run";

            }

        } while (!quit.equals("run"));

        System.out.println("You have exited!");

        keyboard.close();

    }


}
