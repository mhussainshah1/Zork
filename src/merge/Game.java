package merge;

import java.util.List;
import java.util.Scanner;

public class Game {
    private int total;

    public static void main(String[] args) {
        Castle castle = new Castle();
        Scanner keyboard = new Scanner(System.in);

        List<Room> rooms = castle.getRooms();
        for(Room room:rooms){
            System.out.println(room);
        }
    }

    public int getTotal() {
        return total;
    }
}
