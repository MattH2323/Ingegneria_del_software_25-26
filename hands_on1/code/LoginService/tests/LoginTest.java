import org.junit.Test;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

import db.DatabaseInitializer; 

public class LoginTest {

    private static Login auth;

    @BeforeClass
    public static void setup() throws Exception {
        DatabaseInitializer.initialize();
        auth = new Login();
    }

    @Test
    public void testLogin() {
        assertTrue(auth.login("mario_rossi", "password123"));
    }
}
