// singleton class
public class HotelSystem {

    // reservation id
    static int reservationId = 0;

    // instance of hotelSystem
    private static HotelSystem hotelSystem;

    private HotelManagement hotelManagement;
    private UserManagement userManagement;
    private ReservationManagement reservationManagement;


    // private constructor
    private HotelSystem() {
        this.hotelManagement = HotelManagement.getHotelManagement();
        this.userManagement = UserManagement.getUserManagement();
        this.reservationManagement = ReservationManagement.getReservationManagement();
    }


    // method to get the instance of hotelsystem
    public static HotelSystem getHotelSystem() {
        if (hotelSystem == null)
            hotelSystem = new HotelSystem();
        return hotelSystem;
    }


    // method to increment the reservation id
    public static void incrementReservationId() {
        reservationId++;
    }


    // method to register into the site
    void registerIntoSite(Person person) {
        userManagement.registerIntoSite(person);
    }


    // method to delete the hotel (only admin can delete)
    void deleteHotel(int adminId, int hotelId) {
        if (userManagement.isPersonAdmin(adminId)) {
            hotelManagement.deleteHotel(hotelId);
        } else {
            System.out.println("Only admin can delete the hotel details.");
        }
    }


    // method to delete the user (only admin can delete)
    void deleteUser(int adminId, int userId) {
        if (userManagement.isPersonAdmin(adminId)) {
            userManagement.deleteUser(userId);
        } else {
            System.out.println("Only admin can delete the user.");
        }
    }


    // method to approve the hotel details (only admin can approve)
    void approveHotelDetails(int adminId, int hotelId) {
        if (userManagement.isPersonAdmin(adminId)) {
            hotelManagement.approveHotelDetails(hotelId);
        } else {
            System.out.println("Only admin can approve the hotel details.");
        }
    }


    // method to get all the list of all the hotels
    void getAllHotels() {
        hotelManagement.getAllHotels();
    }


    // method to get all the approved hotels
    void getAllApprovedHotels() {
        hotelManagement.getAllApprovedHotels();
    }


    // method to get all the unapproved hotels.
    void getAllUnApprovedHotels() {
        hotelManagement.getAllUnApprovedHotels();
    }


    // method to add the hotel details (only hotel agent can add the details)
    void addHotelDetails(int agentId, Hotel hotel) {
        if (userManagement.isPersonAgent(agentId)) {
            hotelManagement.addHotelDetails(hotel);
        } else
            System.out.println("Only hotel agent can add the hotel details.");
    }


    // method to get the hotel by id
    Hotel getHotelById(int agentId, int hotelId) {
        Hotel hotel = null;
        if (userManagement.isPersonAgent(agentId)) {
            hotel = hotelManagement.getHotelById(hotelId);
        } else
            System.out.println("Only hotel agent can add the hotel details.");
        return hotel;
    }


    // method to update the hotel only agent can update the details of the hotel.
    void updateHotel(int agentId, int hotelId, Hotel hotel) {
        if (userManagement.isPersonAgent(agentId)) {
            if (hotelId == hotel.getHotelId()) {
                hotelManagement.updateHotelDetails(hotel);
            } else {
                System.out.println("Hotel id and updated Hotel id are note same.");
            }
        } else
            System.out.println("Only hotel agent can add the hotel details.");
    }


    // method to get the users (only admin can see all the users)
    void getUsers(int adminId) {
        if (userManagement.isPersonAdmin(adminId)) {
            userManagement.getUsers();
        } else
            System.out.println("Only admin can see the user details.");
    }


    // method to book the room in the hotel
    void bookRoomInhotel(int personId, int hotelId) {
        int roomId;
        if (hotelManagement.checkAvailability(hotelId)) {
            roomId = hotelManagement.getAvailableRoomId(hotelId);
            HotelSystem.incrementReservationId();
            Reservation reservation = new Reservation(HotelSystem.reservationId, personId, roomId, hotelId);
            reservationManagement.addIntoReservation(personId, HotelSystem.reservationId);
            reservationManagement.addReservation(reservation);
            System.out.println("Booking successful.");
            System.out.println("Booking details are : " + reservation.toString());
        } else {
            System.out.println("No rooms are available in this hotel.");
        }
    }


    // method to search the hotel by feature
    void searchHotelByFeature(String feature){
        hotelManagement.searchHotelByFeature(feature);
    }

    // method to add the feature (only agent can add the feature)
    void addFeature(int agentId,int hotelId, String feature){
        if(userManagement.isPersonAgent(agentId)){
           hotelManagement.addFeature(hotelId,feature);
        }else{
            System.out.println("Only agents can add feature.");
        }
    }


    // method to add the feedback
    void addFeedback(int userid, int reservationId, String feedback){

    }
}
