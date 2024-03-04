import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// singleton class
public class UserManagement {
    private static UserManagement userManagement;
    Map<PersonRole, ArrayList<Person>> members;

    // private constructor
    private UserManagement() {
        this.members = new HashMap<>();
    }

    // method to get the instance of the userManagement
    public static UserManagement getUserManagement() {
        if (userManagement == null)
            userManagement = new UserManagement();
        return userManagement;
    }

    public void registerIntoSite(Person person) {
        if (checkWhetherMemberWithSameIdexists(person.getPersonId(), person.getPersonRole())) {
            System.out.println("Please try again as member with same id and role already exists.");
        } else {
            if (members.containsKey(person.getPersonRole())) {
                ArrayList<Person> member = members.get(person.getPersonRole());
                member.add(person);
                members.replace(person.getPersonRole(), member);
            } else {
                ArrayList<Person> member = new ArrayList<>();
                member.add(person);
                members.put(person.getPersonRole(), member);
            }
            System.out.println("Person Added Successfully.");
        }
    }

    boolean checkWhetherMemberWithSameIdexists(int personId, PersonRole role) {
        boolean doExists = false;
        if (members.containsKey(role)) {
            for (Person person : members.get(role)) {
                if (person.getPersonId() == personId) {
                    doExists = true;
                    break;
                }
            }
        }
        return doExists;
    }

    boolean isPersonAdmin(int personId) {
        boolean isAdmin = false;
        if (members.containsKey(PersonRole.Administrator)) {
            ArrayList<Person> person = members.get(PersonRole.Administrator);
            for (Person p : person) {
                if (p.getPersonId() == personId) {
                    isAdmin = true;
                    break;
                }
            }
        }
        return isAdmin;
    }

    public void deleteUser(int userId) {
        if (doUserExists(userId)) {
            Person user = getUserByUserId(userId);
            members.get(PersonRole.User).remove(user);
            System.out.println("User with user-id: " + userId + " successfully deleted.");
        } else {
            System.out.println("No User exists with user-id: " + userId);
        }
    }

    public Person getUserByUserId(int userId) {
        ArrayList<Person> users;
        Person user = null;
        users = members.get(PersonRole.User);
        for (Person p : users) {
            if (p.getPersonId() == userId) {
                user = p;
                break;
            }
        }
        return user;
    }

    public boolean doUserExists(int userId) {
        boolean doExists = false;
        ArrayList<Person> users;
        if (members.containsKey(PersonRole.User)) {
            users = members.get(PersonRole.User);
            for (Person p : users) {
                if (p.getPersonId() == userId) {
                    doExists = true;
                    break;
                }
            }
        }
        return doExists;
    }

    public boolean isPersonAgent(int agentId) {
        boolean isAgent = false;
        if (members.containsKey(PersonRole.HotelAgent)) {
            ArrayList<Person> agents = members.get(PersonRole.HotelAgent);
            for (Person p : agents) {
                if (p.getPersonId() == agentId) {
                    isAgent = true;
                    break;
                }
            }
        }
        return isAgent;
    }

    public void getUsers() {
        ArrayList<Person> users = members.get(PersonRole.User);
        for (Person p : users) {
            System.out.println("User id: " + p.getPersonId() + " Name: " + p.getName());
        }
    }
}
