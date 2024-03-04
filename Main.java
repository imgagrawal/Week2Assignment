public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person person = PersonFactory.getPerson(PersonRole.User,5,"ABC");
        Person user1 = new User(1, "Garvit");
        Person user2 = new User(2, "Rajat");
        Person admin1 = new Administrator(1, "Admin1");
        Person agent1 = new HotelAgent(1, "Agent1");
        HotelSystem hotelSystem = HotelSystem.getHotelSystem();
        hotelSystem.registerIntoSite(user1);
        hotelSystem.registerIntoSite(admin1);
        hotelSystem.registerIntoSite(agent1);
        hotelSystem.registerIntoSite(person);
        System.out.println("-------------");
        hotelSystem.getUsers(1);
        System.out.println("---------------");
        Room room101 = new Room(101, 2);
        Room room102 = new Room(102, 2);
        Hotel hotel101 = new Hotel(101, "Taj Mumbai");
        hotel101.addRoom(room101.getRoomId(), room101);
//        hotel101.addRoom(room102.getRoomId(), room102);
        hotelSystem.addHotelDetails(1, hotel101);
        hotelSystem.addFeature(1,101,"Gym");
        hotelSystem.getAllHotels();
        hotelSystem.getAllApprovedHotels();
        hotelSystem.searchHotelByFeature("Wifi");
        hotelSystem.getAllUnApprovedHotels();
        hotelSystem.bookRoomInhotel(1, 101);
//        hotelSystem.bookRoomInhotel(1, 101);
//        hotelSystem.addHotelDetails(1, hotel101);
//        hotelSystem.deleteUser(2, 2);
//        hotelSystem.getUsers(1);

    }
}