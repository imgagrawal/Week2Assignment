import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


// Hotel class
public class Hotel {

    // unique hotelId
    int hotelId;

    // Hotel name
    String hotelName;

    // Hotel has rooms (aggregation), Rooms is a map where key is room id and value is the room object
    HashMap<Integer, Room> rooms;

    // status of the hotel which can be modified only by admin
    boolean isApproved;

    HashMap<Integer,ArrayList<String>> feedbacks;

    // hotel Features
    HashSet<String> features;


    // parametrized constructor
    Hotel(int hotelId, String hotelName) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = new HashMap<Integer, Room>();
        this.isApproved = false;
        this.features = new HashSet<>();
        this.feedbacks = new HashMap<>();
    }


    // method to approve the hotel details
    void approveHotelDetails() {
        this.isApproved = true;
    }


    // method to get the name of the hotel
    public String getHotelName() {
        return this.hotelName;
    }


    // method to get the id of the hotel
    public int getHotelId() {
        return this.hotelId;
    }

    // method to get the rooms of the hotels
    public HashMap<Integer, Room> getRooms() {
        return this.rooms;
    }


    // method to add the room in the hotel
    public void addRoom(int roomId, Room room) {
        if (rooms.containsKey(roomId)) {
            System.out.println("Room with same room id exists in the hotel.");
        } else {
            rooms.put(roomId, room);
        }
    }

    void addFeature(String feature){
        this.features.add(feature);
    }

    // method to add the list of rooms.
    public void setRooms(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            if (this.rooms.containsKey(room.getRoomId())) {
                System.out.println("Room cant be added as room with same room id exists in the hotel.");
            } else {
                this.rooms.put(room.getRoomId(), room);
            }
        }
    }

    public HashSet<String> getFeatures(){
        return this.features;
    }


    int getAvailableRoomCount(){
        int count = 0;
        for(Map.Entry<Integer,Room> room: rooms.entrySet()){
            if(room.getValue().isRoomAvailable())
                count++;
        }
        return count;
    }

    void addFeedBack(int userId,String feedback){
        if(feedbacks.containsKey(userId)){
            ArrayList<String> previousFeedback = feedbacks.get(userId);
            previousFeedback.add(feedback);
            feedbacks.replace(userId,previousFeedback);
        }else{
            ArrayList<String> currentFeedback = new ArrayList<>();
            currentFeedback.add(feedback);
            feedbacks.put(userId,currentFeedback);
        }
        System.out.println("FeedBack added successfully.");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", hotelName='" + hotelName + '\'' +
                ", rooms=" + rooms +
                ", isApproved=" + isApproved +
                ", features=" + features +
                '}';
    }
}
