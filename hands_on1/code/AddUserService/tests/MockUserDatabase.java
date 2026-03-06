import java.util.ArrayList;

public class MockUserDatabase implements UserDatabase {
    private final ArrayList<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean userExists(User user) {
        return users.contains(user);
    }

    // Package-private for testing purposes
    ArrayList<User> getUsers(){
        return users;
    }
}