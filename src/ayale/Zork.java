package ayale;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * ___________________________________
 *|          |           |     8      |
 *|     5    |    6      |_Secret Rm)_|
 *|(dinning) |  (Vault)  |     7      |
 *|_____ ____|___________|__(Parlor)__|
 *|          |           |            |
 *|    3     |    2      |     4      |
 *|(Library) | (Front Rm)| (Kitchen)  |
 *|__________|_____ _____|____________|
 *           |           |
 *           |     1     |
 *           | (Foyer)   |
 *           |_____ _____|
 */
public class Zork {
    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, String> items = new HashMap<>();
    static Map<Integer, Integer> money = new HashMap<>();
    static  Scanner keyboard = new Scanner(System.in);

    public static int totalMoney = 0;
    public static int roomCharacter = 0;
    static boolean characterFound = false;
    static boolean found = false;

    public static void main(String[] args) {
        welcome();
        roomCharacter = getRandom(1,8);
        foyer();
    }

    public static void welcome(){
        System.out.println("|----------------------------|");
        System.out.println("|****************************|");
        System.out.println("|***WELCOME TO THE PROGRAM***|");
        System.out.println("|************ZORK************|");
        System.out.println("|----------------------------|");
    }

    public static void foyer() {
        items.put(1, "Dead Scorpion");
        visited.put(1, true);
        String answer = "";
        System.out.println("\n'ROOM:'\t\t\tFOYER\n'CONTAIN:'\t\tDEAD SCORPION\n'DIRECTION TO:'\t(NORTH)\n");
        money(1);

        while (true) {
            System.out.print("which room you want to travel type (NORTH|N).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if ((answer.equalsIgnoreCase("NORTH")) || (answer.equalsIgnoreCase("N"))) {
                frontRoom();
            } else if ((answer.equalsIgnoreCase("q"))) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void frontRoom() {
        System.out.println("\n'ROOM:'\t\t\tFRONT_ROOM \n'CONTAIN:'\t\tPIANO \n'DIRECTION TO:'\t(SOUTH|WEST|EAST)\n");
        items.put(2, "Piano");
        visited.put(2, true);
        String answer = "";
        money(2);

        while (true) {
            System.out.print("which room you want to travel type (SOUTH|S),(WEST|W),(EAST|E).. OR press 'q' to exit");
            answer = keyboard.nextLine().toLowerCase();
            if (!(answer.equalsIgnoreCase("q"))) {
                switch (answer) {
                    case "south":
                    case "s":
                        foyer();
                        break;
                    case "west":
                    case "w":
                        library();
                        break;
                    case "e":
                    case "east":
                        kitchen();
                        break;
                    default:
                        System.out.println("please enter the correct direction");
                }
            } else if ((answer.equalsIgnoreCase("q"))) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void library() {
        System.out.println("\n'ROOM:'\t\t\tLIBRARY \n'CONTAIN:'\t\tSPIDERS \n'DIRECTION TO:'\t(NORTH|EAST)\n");
        items.put(3, "Spider");
        visited.put(3, true);
        String answer = "";
        money(3);

        while (true) {
            System.out.print("which room you want to travel type (NORTH|N),(EAST|E).. OR press 'q' to exit");
            answer = keyboard.nextLine().toLowerCase();
            if (!(answer.equalsIgnoreCase("q"))) {
                switch (answer) {
                    case "east":
                    case "e":
                        frontRoom();
                        break;
                    case "north":
                    case "n":
                        diningRoom();
                        break;
                    default:
                        System.out.println("please enter the correct direction");
                }
            } else if ((answer.equalsIgnoreCase("q"))) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void kitchen() {
        System.out.println("\n'ROOM:'\t\t\tKITCHEN\n'CONTAIN:'\t\tBATS \n'DIRECTION TO:'\t(WEST|NORTH)\n");
        items.put(4, "Bats");
        visited.put(4, true);
        String answer = "";
        money(4);

        while (true) {
            System.out.print("which room you want to travel type (WEST|W),(NORTH|N).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if (!(answer.equalsIgnoreCase("q"))) {
                switch (answer) {
                    case "w":
                    case "west":
                        frontRoom();
                        break;
                    case "n":
                    case "north":
                        parlor();
                        break;
                    default:
                        System.out.println("please enter the correct room direction");
                }
            } else if ((answer.equalsIgnoreCase("q"))) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void diningRoom() {
        System.out.println("\n'ROOM:'\t\t\tDINING_ROOM\n'CONTAIN:'\t\tDUST EMPTY BOX\n'DIRECTION TO:'\t(SOUTH)\n");
        items.put(5, "Dust Empty Box");
        visited.put(5, true);
        String answer = "";
        money(5);

        while (true) {
            System.out.print("which room you want to travel type (SOUTH|S).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if ((answer.equalsIgnoreCase("south")) || (answer.equalsIgnoreCase("s"))) {
                library();
            } else if (answer.equalsIgnoreCase("q")) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void valut() {
        System.out.println("\n'ROOM:'\t\t\tVALUT\n'CONTAIN:'\t\t3 WALKING SKELETONS\n'DIRECTION TO:'\t(EAST|E)\n");
        items.put(6, "3 Walking Skeletons");
        visited.put(6, true);
        String answer = "";
        money(6);
        while (true) {
            System.out.print("which room you want to travel type (EAST|E).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if (((answer.equalsIgnoreCase("EAST")) || (answer.equalsIgnoreCase("E")))) {
                if(isFound()){
                    System.out.print("Enter the room to go (7/8): ");
                    int roomSel = keyboard.nextInt();
                    switch (roomSel) {
                        case 7:
                            parlor();
                            break;
                        case 8:
                            secretRoom();
                            break;
                    }
                } else {
                    int random = getRandom(1,100);
                    if (random > 25) {
                        parlor();
                    } else {
                        secretRoom();
                        found = true;
                    }
                }
            } else if (answer.equalsIgnoreCase("q")) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void parlor() {
        System.out.println("'ROOM:'\t\t\tPARLOR\n'CONTAIN:'\t\tTREASURE CHEST \n'DIRECTION TO:'\t(EAST|E),(SOUTH|S)\n");
        items.put(7, "Treasure Chest");
        visited.put(7, true);
        String answer = "";
        money(7);
        while (true) {
            System.out.print("which room you want to travel type (W/S).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if (answer.equalsIgnoreCase("w")) {
                valut();
            } else if (answer.equalsIgnoreCase("s")) {
                kitchen();
            } else if (answer.equalsIgnoreCase("q")) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void secretRoom() {
        System.out.println("YOU ARE IN SECRET ROOM RIGHT NOW\n");
        System.out.println("'ROOM:'\t\t\tSECRET_ROOM \n'CONTAIN:'\t\tPILES OF GOLD \n'DIRECTION TO:'\t(WEST)\n");
        items.put(8, "Piles of Gold");
        visited.put(8, true);
        String answer = "";
        money(8);

        while (true) {
            System.out.print("which room you want to travel type (WEST|W).. OR press 'q' to exit");
            answer = keyboard.nextLine();
            if ((answer.equalsIgnoreCase("w")) || (answer.equalsIgnoreCase("west"))) {
                valut();
            } else if (answer.equalsIgnoreCase("q")) {
                exit();
            } else {
                System.out.println("please enter the correct choice");
            }
        }
    }

    public static void money(int room) {
        if(!money.containsKey(room)){
            String moneyChoice;
            int random = getRandom(1,100);
            System.out.print("There are $" + random + ".Do you want to take it?...(y|n): " );
            moneyChoice = keyboard.nextLine();
            if ((moneyChoice.equalsIgnoreCase("y"))) {
                money.put(room, random);
                totalMoney += random;
            } else {
                System.out.println("You did not take the money.");
            }
        }
        if (roomCharacter == room) {
            System.out.println("YOU LOST ALL OF YOUR MONEY. YOU LOSS");
//            for(int key : money.keySet()){
//                money.put(key,0);
//            }
            totalMoney = 0;//money.clear();
            roomCharacter = 9;
        }
    }

    public static int getRandom(int min, int max) {
        return min + ((int) (Math.random() * max));
    }

    public static boolean isCharacterFound() {
        return characterFound;
    }

    public static boolean isFound() {
        return found;
    }

    public static void exit() {
        int random = getRandom(1,100);
        if (random <= 25) {
            System.out.println("You are followed by ghost");
        }
        System.out.println("YOU VISIT " +  visited.size() + " ROOM");
        System.out.println("YOU HAVE $" + totalMoney + " AMOUNT OF MONEY");
        System.out.println("The items you have seen:" + items);
        System.out.println("THANKS");
        System.exit(0);
    }
}