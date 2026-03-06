public interface UserDatabase {

    void addUser(User user);
    boolean userExists(User user);

}