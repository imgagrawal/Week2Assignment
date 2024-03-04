// implementing the factory design pattern for person class.
public class PersonFactory {

    // getPerson name to get the object of person based on the input
    public static Person getPerson(PersonRole personRole, int personId, String personName) {
        if (personRole == PersonRole.User) {
            return new User(personId, personName);
        } else if (personRole == PersonRole.HotelAgent) {
            return new HotelAgent(personId, personName);
        } else if (personRole == PersonRole.Administrator) {
            return new Administrator(personId, personName);
        } else
            return null;
    }
}
