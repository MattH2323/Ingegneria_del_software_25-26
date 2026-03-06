import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testEqualsAndHashCodeSuccess() {
        User user1 = new User("name1", "password", "email1@test.com");
        User user2 = new User("name1", "passwordNotEqual", "email1@test.com");

        assertEquals(user1, user2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void testEqualsFailure() {
        User user1 = new User("name1", "password1", "email1@test.com");
        User user2 = new User("name2", "password1", "email2@test.com");

        assertNotEquals(user1, user2);
    }

    @Test
    public void testNotEqualsWithNull() {
        User user = new User("name", "password", "email@test.com");

        assertNotNull(user);
        assertNotEquals(null, user);
    }
}