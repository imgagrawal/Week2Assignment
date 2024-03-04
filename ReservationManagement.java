import java.util.ArrayList;
import java.util.HashMap;

public class ReservationManagement {
    private static ReservationManagement reservationManagement;

    HashMap<Integer, Reservation> allReservations;
    // userid followed by list of reservationid
    HashMap<Integer, ArrayList<Integer>> reservations;

    private ReservationManagement() {
        reservations = new HashMap<>();
        allReservations = new HashMap<>();
    }

    public static ReservationManagement getReservationManagement() {
        if (reservationManagement == null)
            reservationManagement = new ReservationManagement();
        return reservationManagement;
    }

    void addIntoReservation(int userId, int reservationId) {
        ArrayList<Integer> reservationIds;
        if (reservations.containsKey(userId)) {
            reservationIds = reservations.get(userId);
            reservationIds.add(reservationId);
            reservations.replace(userId, reservationIds);
        } else {
            reservationIds = new ArrayList<>();
            reservationIds.add(reservationId);
            reservations.put(userId, reservationIds);
        }
    }

    public void addReservation(Reservation reservation) {
        allReservations.put(reservation.getReservationId(), reservation);
    }
}
