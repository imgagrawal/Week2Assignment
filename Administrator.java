// Administrator class which is implementing person
public class Administrator implements Person {
    // role will be administrator
    PersonRole role;

    // person name
    String personName;

    // person id
    int personId;

    // parametrized constructor
    public Administrator(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
        this.role = PersonRole.Administrator;
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

    // overriding the getPersonId() method
    @Override
    public PersonRole getPersonRole() {
        return this.role;
    }

}
