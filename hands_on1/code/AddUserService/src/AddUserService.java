public class AddUserService {
    private final UserDatabase userDatabase;

    public AddUserService(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public void addUser(User user) {
        if (userDatabase.userExists(user)) {
            throw new ExistingUserException(
                    "User with username:" + user.getUsername() +
                            "and email:" + user.getEmail() + "already exists");
        }
        userDatabase.addUser(user);
    }
}