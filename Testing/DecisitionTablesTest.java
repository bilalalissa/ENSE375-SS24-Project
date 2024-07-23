package PathTesting;

import Proj_375_Classes.UserManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DecisitionTablesTest {
    @Test
    void testSignup() {
        UserManager userManager = new UserManager();

        // Rule 1
        assertFalse(userManager.signup("", "Password1!", "Password1!", "test@example.com", "John Doe"));

        // Rule 2
        assertFalse(userManager.signup("ab", "Password1!", "Password1!", "test@example.com", "John Doe"));

        // Rule 3
        userManager.signup("user1", "Password1!", "Password1!", "test@example.com", "John Doe");
        assertFalse(userManager.signup("user1", "Password1!", "Password1!", "test2@example.com", "Jane Doe"));

        // Rule 4
        assertFalse(userManager.signup("user2", "Password1!", "Password2!", "test@example.com", "John Doe"));

        // Rule 5
        assertFalse(userManager.signup("user3", "pass", "pass", "test@example.com", "John Doe"));

        // Rule 6
        assertFalse(userManager.signup("user4", "Password1!", "Password1!", "testexample.com", "John Doe"));

        // Rule 7
        assertTrue(userManager.signup("user5", "Password1!", "Password1!", "test@example.com", "John Doe"));
    }
}
