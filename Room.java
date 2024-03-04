
// Room class
public class Room {

    // unique room id.
    int roomId;

    // room status for availability of the room
    boolean isAvailable;

    // occupancy of the room
    int occupancy;


    // parametrized constructor
    public Room(int roomId, int occupancy) {
        this.roomId = roomId;
        this.occupancy = occupancy;
        this.isAvailable = true;
    }

    // method to change the room status to occupied
    public void changeRoomStatusToOccupied() {
        this.isAvailable = false;
    }

    // method to change the room status to available
    public void changeRoomStatusToAvailable() {
        this.isAvailable = true;
    }


    // method to get the occupancy of the room
    public int getOccupancy() {
        return this.occupancy;
    }


    // method to set the occupancy of the room
    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }


    // method to get the room id
    public int getRoomId() {
        return this.roomId;
    }


    // method to check whether the room is available or not.
    public boolean isRoomAvailable() {
        return this.isAvailable ? true : false;
    }
}
