package com.company;

import java.util.*;

/**
     ___________________________________
    |          |           |     8      |
    |     5    |    6      |_Secret Rm)_|
    |(dinning) |  (Vault)  |     7      |
    |_____ ____|___________|__(Parlor)__|
    |          |           |            |
    |    3     |    2      |     4      |
    |(Library) | (Front Rm)| (Kitchen)  |
    |__________|_____ _____|____________|
 *             |           |
 *             |     1     |
 *             | (Foyer)   |
 *             |_____ _____|
 */
public class Zork1 {

    static Map<Integer,Boolean> visited = new HashMap<>();
    static boolean found = false;
    static Map<Integer,Double> money = new HashMap<>();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        //System.out.println("Enter house - Choice is (n)");
        String answer;
        char direction = '1', directionInput;
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
                    System.out.println("Room = 0");
                    System.exit(1);
                    break;
            }

            System.out.print("Do you want to go another room (y/n): ");
            answer = keyboard.next();

        } while(answer.equals("y"));

        int random = 1 + (int) (Math.random() * 100);
        if (random <= 25) {
            System.out.println("You are followed by ghost");
        }

        //iterating over keys
        int roomVisited =0;
        for (int i : visited.keySet()) {
            roomVisited++;
        }
        System.out.println("You have visited: " + roomVisited + " room(s)");
    }

    public static int foyer(char direction) {
        System.out.println("You are in Room# 1 foyer \tcontains : dead scorpion\tYou can only go (n/q)");
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 1;
        switch (direction) {
            case 'n':
                room = 2;
                break;
            case 'q':
                System.exit(0);
            default:
                room = 1;
                System.out.println(room + " Invalid direction " + direction + " in 1" );
        }
        visited.put(1,true);
        return room;
    }

    public static int frontRoom(char direction) {
        System.out.println("You are in Room# 2 front Room \tContains : piano \tYou can only go (s/w/e)");
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
                System.out.println(room +" Invalid direction " + direction + " in 2");
        }
        visited.put(2,true);
        return room;
    }

    public static int library(char direction) {
        System.out.println("You are in Room# 3 library \tIt contains : spider \tYou can only go (e/n)");
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
                System.out.println(room +"Invalid direction " + direction + " in 3");
        }
        visited.put(3,true);
        return room;
    }

    public static int kitchen(char direction) {
        System.out.println("You are in Room# 4 Kitchen \tIt contains : bats \tYou can only go (w/n)");
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
                room =4;
                System.out.println(room +" Invalid direction " + direction + " in 4");
        }
        visited.put(4,true);
        return room;
    }

    public static int diningRoom(char direction) {
        System.out.println("You are in Room# 5 Dining Room \tIt contains : dust empty box \tYou can only go (s)");
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 5;
        switch (direction) {
            case 's':
                room = 3;
                break;
            default:
                room =5;
                System.out.println(room +" Invalid direction " + direction + " in 5");
        }
        visited.put(5,true);
        return room;
    }

    public static int vault(char direction) {
        System.out.println("You are in Room# 6 vault\tIt contains : 3 walking skeletons \tYou can only go (e)");
        System.out.print("Enter Direction: ");
        direction = keyboard.next().charAt(0);
        int room = 6;
        switch (direction) {
            case 'e':
                if(isFound()) {
                    System.out.println("HOORAH!!! You have found SECRET Room !!!");
                    System.out.print("Enter the room to go (7/8)");
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
                room =6;
                System.out.println(room + "Invalid direction " + direction + " in 6");
        }
        visited.put(6,true);
        return room;
    }

    public static int parlor(char direction) {
        System.out.println("You are in Room# 7 parlor\tContains : treasure chest\tYou can only go (w/s)");
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
        visited.put(7,true);
        return room;
    }

    public static int secretRoom(char direction) {
        System.out.println("You are in Room# 8 Secret \tContains : piles of gold\tYou can only go (w)");
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
        visited.put(8,true);
        return room;
    }

    public static boolean isFound(){
        return found;
    }
}
