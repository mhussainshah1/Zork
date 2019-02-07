package merge;

import java.util.ArrayList;
import java.util.List;

public class Castle {

    List<Room> rooms;

    public Castle() {
        rooms= new ArrayList<>();
        rooms.add(new Room(1,"foyer","dead scropion" ,"n2"));
        rooms.add(new Room(2,"frontRoom","piano","s1,w3,e4"));
        rooms.add(new Room(3,"library","spider","e2 and n5"));
        rooms.add(new Room(4,"kitchen","bats","w2 and n7"));
        rooms.add(new Room(5,"dining room", "dust empty box", "s3"));
        rooms.add(new Room(6,"vault","3 walking skeltons", "e7 and e8"));
        rooms.add(new Room(7,"parlor","treasure chest", "w6 and s4"));
        rooms.add(new Room(8, "secret room", "piles of gold", "w6"));
   }

   public Room getRoom(int roomNumber){
        for(Room room : rooms){
            if(roomNumber == room.getRoomNumber()){
                return room;
            }
        }
        return null;
   }

    public List<Room> getRooms() {
        return rooms;
    }
}
