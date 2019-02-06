package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ___________________________________
 * |          |           |     8      |
 * |          |           | Secret Rm) |
 * |     5    |    6      |_____  _____|
 * |(dinning) |  (Vault)  |     7      |
 * |          |           | (Parlor)   |
 * |_____ ____|___________|_____  _____|
 * |          |           |            |
 * |    3     |    2      |     4      |
 * |(Library) | (Front Rm)| (Kitchen)  |
 * |__________|_____ _____|____________|
 * |           |
 * |     1     |
 * | (Foyer)   |
 * |_____ _____|
 */
public class Zork1 {

    static int totalMoney = 0;
    static Map<Integer, Boolean> visited = new HashMap<>();
    static Map<Integer, String> items = new HashMap<>();

    static Map<Integer, Double> money = new HashMap<>();
    static Scanner keyboard = new Scanner(System.in);
    static int count = 0;
    static boolean found = false;
    static int roomCharacter = getRandom(1, 6);

    //public static int roomCharacter = 0;

    public static int getRandom(int min, int max) {
        return min + ((int) (Math.random() * max));
    }

    public static void mula() {
        int money = getRandom(1, 1000);
        System.out.println("You found " + "$" + money + " in the room!");
        System.out.print("Would you like to take it? (y/n): ");
        String answer = keyboard.next();
        if (answer.equals("y")) {
            count += money;
            System.out.println("You now have $" + count);
        } else {
            System.out.println("You did not take the money.");
        }
    }

    public static void newTroll(int room) {
        if (room == roomCharacter) {
            System.out.println("A troll has appeared in the room!");
            System.out.println("He has taken all of your money!");
            totalMoney = 0;//money.clear();
            System.out.println("You now have $" + totalMoney);
            roomCharacter = 9;
         }
    }

    public static void main(String[] args) {

        //System.out.println("Enter Castle - Choice is (n)");
        String answer;
        char direction = 'q', directionInput;
        int room = 1;
        do {
//            System.out.println("You are in room = " + room);
            //roomInput = Integer.parseInt(choice.substring(1,2));
            /*
            if(roomInput!= room){
                System.out.println("Invalid Room");
                continue;
            }
            */
            switch (room) { //Room
                case 1:
                    room = foyer(direction);
                    break;
                case 2:
                    room = frontRoom(direction);
                    break;
                case 3:
                    room = library(direction);
                    break;
                case 4:
                    room = kitchen(direction);
                    break;
                case 5:
                    room = diningRoom(direction);
                    break;
                case 6:
                    room = vault(direction);
                    break;
                case 7:
                    room = parlor(direction);
                    break;
                case 8:
                    room = secretRoom(direction);
                    break;
                default:
                    System.out.println("Invalid Room");
                    break;
            }
//            System.out.print("Do you want to go another room (y/n): ");
//            answer = keyboard.next();
        } while (true);//while(answer.equals("y"));
        //exit();
    }

    public static void exit() {
        int random = 1 + (int) (Math.random() * 100);
        if (random <= 25) {
            System.out.println("You are followed by ghost");
        }
        System.out.println("You have visited: " + (1 + visited.size()) + " room(s)");
        System.out.println("You have seen the following items: " + items);
    }

    //1
    public static int foyer(char direction) {
        System.out.println("You are in Room# 1 foyer \tcontains : dead scorpion\tYou can only go (n/q)");
        items.put(1, "Dead Scorpion");
        visited.put(1, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 1;
        switch (direction) {
            case 'n':
                room = 2;
                break;
            case 'q':
                exit();
                System.exit(0);
                break;
            default:
                room = 1;
                System.out.println(room + " Invalid direction " + direction + " in 1");
        }

        return room;
    }

    //2
    public static int frontRoom(char direction) {
        System.out.println("You are in Room# 2 front Room \tContains : piano \tYou can only go (s/w/e)");
        mula();
        newTroll(2);
        items.put(2, "Piano");
        visited.put(2, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 2;
        switch (direction) {
            case 's':
                room = 1;
                break;
            case 'w':
                room = 3;
                break;
            case 'e':
                room = 4;
                break;
            default:
                room = 2;
                System.out.println(room + " Invalid direction " + direction + " in 2");
        }

        return room;
    }

    //3
    public static int library(char direction) {
        System.out.println("You are in Room# 3 library \tIt contains : spider \tYou can only go (e/n)");
        mula();
        newTroll(3);
        items.put(3, "Spider");
        visited.put(3, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 3;
        switch (direction) {
            case 'e':
                room = 2;
                break;
            case 'n':
                room = 5;
                break;
            default:
                room = 3;
                System.out.println(room + "Invalid direction " + direction + " in 3");
        }

        return room;
    }

    //4
    public static int kitchen(char direction) {
        System.out.println("You are in Room# 4 Kitchen \tIt contains : bats \tYou can only go (w/n)");
        mula();
        newTroll(4);
        items.put(4, "Bats");
        visited.put(4, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 4;
        switch (direction) {
            case 'w':
                room = 2;
                break;
            case 'n':
                room = 7;
                break;
            default:
                room = 4;
                System.out.println(room + " Invalid direction " + direction + " in 4");
        }
        return room;
    }

    //5
    public static int diningRoom(char direction) {
        System.out.println("You are in Room# 5 Dining Room \tIt contains : dust empty box \tYou can only go (s)");
        mula();
        newTroll(5);
        items.put(5, "Dust Empty Box");
        visited.put(5, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 5;
        switch (direction) {
            case 's':
                room = 3;
                break;
            default:
                room = 5;
                System.out.println(room + " Invalid direction " + direction + " in 5");
        }

        return room;
    }

    //6
    public static int vault(char direction) {
        System.out.println("You are in Room# 6 vault\tIt contains : 3 walking skeletons \tYou can only go (e)");
        mula();
        newTroll(6);
        items.put(6, "3 Walking Skeletons");
        visited.put(6, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 6;
        switch (direction) {
            case 'e':
                if (isFound()) {
                    System.out.print("Enter the room to go (7/8): ");
                    int roomSel = keyboard.nextInt();
                    switch (roomSel) {
                        case 7:
                            room = 7;
                            break;
                        case 8:
                            room = 8;
                            break;
                        default:
                            room = 6;
                            System.out.println(room + "Invalid direction " + direction + " in 6");
                            break;
                    }
                } else {
                    int random = 1 + (int) (Math.random() * 100);
                    if (random > 25) {
                        room = 7;
                    } else {
                        room = 8;
                        found = true;
                    }
                }
                break;
            default:
                room = 6;
                System.out.println(room + "Invalid direction " + direction + " in 6");
        }

        return room;
    }

    //7
    public static int parlor(char direction) {
        System.out.println("You are in Room# 7 parlor\tContains : treasure chest)");
        mula();
        newTroll(7);
        items.put(7, "Treasure Chest");
        visited.put(7, true);
        System.out.println("You can only go (w/s");
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 7;
        switch (direction) {
            case 'w':
                room = 6;
                break;
            case 's':
                room = 4;
                break;
            default:
                room = 7;
                System.out.println(room + " Invalid direction " + direction + " in 7");
        }

        return room;
    }

    //8
    public static int secretRoom(char direction) {
        System.out.println("HOORAH!!! You have found SECRET Room !!!");
        System.out.println("You are in Room# 8 Secret \tContains : piles of gold\tYou can only go (w)");
        mula();
        newTroll(8);
        items.put(8, "Piles of Gold");
        visited.put(8, true);
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 8;
        switch (direction) {
            case 'w':
                room = 6;
                break;
            default:
                room = 8;
                System.out.println(room + " Invalid direction " + direction + " in 8");
        }

        return room;
    }

    public static boolean isFound() {
        return found;
    }
}
