import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AddUserServiceTest {
    private AddUserService addUserService;
    private MockUserDatabase mockUserDatabase;

    @Before
    public void setUp() {
        mockUserDatabase = new MockUserDatabase();
        addUserService = new AddUserService(mockUserDatabase);
    }

    @Test
    public void addUser() throws ExistingUserException {
        User testUser = new User("name", "password", "email");

        addUserService.addUser(testUser);

        assertTrue(mockUserDatabase.getUsers().contains(testUser));
    }

    @Test
    public void addUserThrowsExistingUserException() throws ExistingUserException {
        User testUser = new User("name", "password", "email");
        addUserService.addUser(testUser);

        assertThrows(ExistingUserException.class, () -> {
            addUserService.addUser(testUser);
        });
    }
}
