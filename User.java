public class User implements Person {
    // role will be User
    PersonRole role;

    // person name
    String personName;

    // person id
    int personId;

    // parametrized constructor
    public User(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
        this.role = PersonRole.User;
    }

    // overriding the getName() method
    @Override
    public String getName() {
        return this.personName;
    }

    // overriding the getPersonId() method
    @Override
    public int getPersonId() {
        return this.personId;
    }

    // overriding the getPersonRole() method
    @Override
    public PersonRole getPersonRole() {
        return this.role;
    }

    // overriding the getPersonRole() method
    public PersonRole personRole() {
        return this.role;
    }
}
