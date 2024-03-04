import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


// HotelManagement class (A singleton class)
public class HotelManagement {


    // A private hotelmanagement reference variable
    private static HotelManagement hotelManagement;

    // Map of hotels where key is unique hotel id and value is Hotel object itself.
    HashMap<Integer, Hotel> hotels;


    // private constructor to stop the creation of object
    private HotelManagement() {
        this.hotels = new HashMap<>();
    }


    // static method to get the instance of the hotel management class
    public static HotelManagement getHotelManagement() {
        if (hotelManagement == null)
            hotelManagement = new HotelManagement();
        return hotelManagement;
    }


    // method to delete the hotel by unique hotel id.
    void deleteHotel(int hotelId) {
        if (doHotelExists(hotelId)) {
            this.hotels.remove(hotelId);
            System.out.println("Hotel with hotel-id: " + hotelId + " successfully deleted.");
        } else {
            System.out.println("No hotel exists with hotel-id: " + hotelId);
        }
    }


    // method to check whether the hotel exists by id
    public boolean doHotelExists(int hotelId) {
        return hotels.containsKey(hotelId) ? true : false;
    }


    // method to approve the hotel details by unique hotel id.
    public void approveHotelDetails(int hotelId) {
        if (doHotelExists(hotelId)) {
            hotels.get(hotelId).approveHotelDetails();
            System.out.println("Hotel with hotel-id: " + hotelId + " are successfully approved.");
        } else
            System.out.println("No hotel exists with hotel-id: " + hotelId);
    }


    // method to get the list of all hotels both approved and un-approved.
    void getAllHotels() {
        System.out.println("All hotels");
        for (Map.Entry<Integer, Hotel> e : hotels.entrySet()) {
            System.out.println("----------------");
            System.out.println("Hotel id: "+e.getKey());
            System.out.println("Hotel name: " + e.getValue().getHotelName());
            System.out.println("Available Rooms: " + e.getValue().getAvailableRoomCount());
            System.out.println("----------------");
        }
    }


    // method to get the list of all approved hotels.
    void getAllApprovedHotels() {
        int count = 0;
        System.out.println("All approved hotels");
        for (Map.Entry<Integer, Hotel> e : hotels.entrySet()) {
            if (e.getValue().isApproved)
            {
                count++;
                System.out.println("----------------");
                System.out.println("Hotel id: "+e.getKey());
                System.out.println("Hotel name: " + e.getValue().getHotelName());
                System.out.println("Available Rooms: " + e.getValue().getAvailableRoomCount());
                System.out.println("----------------");
            }
        }
        System.out.println(count+" hotels are approved.");
    }


    // method to get the list of all the unapproved hotels.
    void getAllUnApprovedHotels() {
        int count=0;
        System.out.println("All un-approved hotels.");
        for (Map.Entry<Integer, Hotel> e : hotels.entrySet()) {
            if (!e.getValue().isApproved) {
                count++;
                System.out.println("----------------");
                System.out.println("Hotel id: "+e.getKey());
                System.out.println("Hotel name: " + e.getValue().getHotelName());
                System.out.println("Available Rooms: " + e.getValue().getAvailableRoomCount());
                System.out.println("----------------");
            }
        }
        System.out.println(count+" hotels are un-approved.");
    }


    // method to add the hotel details.
    public void addHotelDetails(Hotel hotel) {
        int hotelId = hotel.getHotelId();
        if (hotels.containsKey(hotelId)) {
            System.out.println("Cannot add hotel details as hotel with same id is already registered.");
        } else {
            hotels.put(hotelId, hotel);
        }
    }


    // method to update the details of the hotel.
    public void updateHotelDetails(Hotel hotel) {
        if (doHotelExists(hotel.getHotelId())) {
            this.hotels.replace(hotel.getHotelId(), hotel);
            System.out.println("Hotel with hotel-id: " + hotel.getHotelId() + " successfully updated.");
        } else
            System.out.println("No hotel exists with hotel-id: " + hotel.getHotelId());
    }


    // method to get the hotel by unique hotel id.
    public Hotel getHotelById(int hotelId) {
        Hotel hotel = null;
        if (doHotelExists(hotelId))
            hotel = hotels.get(hotelId);
        else
            System.out.println("No hotel exists with hotel-id: " + hotelId);
        return hotel;
    }


    // method to check the availability of the hotel by unique hotel id.
    public boolean checkAvailability(int hotelId) {
        boolean isAvailable = false;
        HashMap<Integer, Room> rooms = hotels.get(hotelId).getRooms();
        for (Map.Entry<Integer, Room> room : rooms.entrySet()) {
            if (room.getValue().isRoomAvailable()) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }


    // method to get the available room id by unique hotel id.
    public int getAvailableRoomId(int hotelId) {
        int roomId = 0;
        HashMap<Integer, Room> rooms = hotels.get(hotelId).getRooms();
        for (Map.Entry<Integer, Room> room : rooms.entrySet()) {
            if (room.getValue().isRoomAvailable()) {
                roomId = room.getKey();
                room.getValue().changeRoomStatusToOccupied();
                break;
            }
        }
        return roomId;
    }

    public void searchHotelByFeature(String feature) {
        int count = 0;
        HashSet<String> currentFeatures = null;
        for(Map.Entry<Integer,Hotel> e: hotels.entrySet()){
            currentFeatures=e.getValue().getFeatures();
            if(currentFeatures.contains(feature)){
                System.out.println(e.getValue().toString());
                count++;
            }
        }
        if(count==0)
            System.out.println("No hotel exists with demanded feature");
    }


    void addFeature(int hotelId,String feature){
        if(hotels.containsKey(hotelId)){
            Hotel hotel = hotels.get(hotelId);
            hotel.addFeature(feature);
        }else{
            System.out.println("No such hotel Exists.");
        }
    }

}
