package merge;

public class Room {
    private int roomNumber;
    private String roomName;
    private String item;
    private String directions;
    private boolean found;
    private int money;

    public Room(int roomNumber, String roomName, String item, String directions) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.item = item;
        this.directions = directions;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public int getMoney() {
        int random = 1+(int)(Math.random() *1000);
        setMoney(random);
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "You are in roomNumber=" + roomNumber +
                ", roomName='" + roomName + '\'' +
                ", item contains='" + item + '\'' +
                ", direction & room number ='" + directions + '\'' +
                '}';
    }
}
