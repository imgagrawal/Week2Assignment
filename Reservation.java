public class Reservation {

    int reservationId;
    int personId;
    int roomId;
    int hotelId;

    public Reservation(int reservationId, int personId, int roomId, int hotelId) {
        this.reservationId = reservationId;
        this.personId = personId;
        this.roomId = roomId;
        this.hotelId = hotelId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getHotelId() {
        return this.hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", personId=" + personId +
                ", roomId=" + roomId +
                ", hotelId=" + hotelId +
                '}';
    }
}
