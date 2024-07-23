package PathTesting;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Proj_375_Classes.UserManager;

class BoundaryValueTest {

    private UserManager userManager = new UserManager();

    @Test
    void testBoundaryValues() {
        // Case 1: Username is empty
        System.out.println("Running test case 1, Username is empty...");
        assertFalse(userManager.signup("", "Password1!", "Password1!", "test@example.com", "John Doe"));
        
        // Case 2: Username is at minimum length just above empty
        System.out.println("Running test Case 2: Username is at minimum length just above empty...");
        assertTrue(userManager.signup("abc", "Password1!", "Password1!", "test@example.com", "John Doe"));
        
        // Case 3: Username is at maximum length
        System.out.println("Running test Case 3: Username is at maximum length...");
        assertTrue(userManager.signup("aaaaaaaaaaaaaaaaaaaa", "Password1!", "Password1!", "test@example.com", "John Doe"));
        
        // Case 4: Username is just below maximum length
        System.out.println("Running test Case 4: Username is just below maximum length...");
        assertTrue(userManager.signup("aaaaaaaaaaaaaaaaaaa", "Password1!", "Password1!", "test@example.com", "John Doe"));

        // Case 5: Password is at minimum length with criteria met
        System.out.println("Running test Case 5: Password is at minimum length with criteria met...");
        assertTrue(userManager.signup("user5", "A1@abcde", "A1@abcde", "test@example.com", "John Doe"));

        // Case 5a: Password does not match confirmation
        System.out.println("Running test Case 5a: Password does not match confirmation...");
        assertFalse(userManager.signup("user123", "A1@abcde", "A1@abcd", "test@example.com", "John Doe"));
        
        // Case 6: Password is slightly above minimum length
        System.out.println("Running test Case 6: Password is slightly above minimum length...");
        assertTrue(userManager.signup("user1", "A1@abcdef", "A1@abcdef", "test@example.com", "John Doe"));
        
        // Case 7: Password is just below maximum length
        System.out.println("Running test Case 7: Password is just below maximum length...");
        assertTrue(userManager.signup("user2", "A1@bcdefghijklmno", "A1@bcdefghijklmno", "test@example.com", "John Doe"));
        
        // Case 8: Password is at maximum length
        System.out.println("Running test Case 8: Password is at maximum length...");
        assertTrue(userManager.signup("user3", "A1@bcdefghijklmnop", "A1@bcdefghijklmnop", "test@example.com", "John Doe"));
        
        // Case 9: Invalid email format
        System.out.println("Running test Case 9: Invalid email format...");
        assertFalse(userManager.signup("user4", "Password1!", "Password1!", "a@b.c", "John Doe"));
        
        // Case 10: Valid email
        System.out.println("Running test Case 10: Valid email...");
        assertTrue(userManager.signup("user6", "Password1!", "Password1!", "user@example.com", "John Doe"));
        
        // Case 11: Valid long email
        System.out.println("Running test Case 11: Valid long email...");
        assertTrue(userManager.signup("user7", "Password1!", "Password1!", "test123@example.com", "John Doe"));
        
        // Case 12: Valid extra long email
        System.out.println("Running test Case 12: Valid extra long email...");
        assertTrue(userManager.signup("user8", "Password1!", "Password1!", "longemailaddress@example.com", "John Doe"));
        
        // Case 13: Full name is empty
        System.out.println("Running test Case 13: Full name is empty...");
        assertFalse(userManager.signup("user9", "Password1!", "Password1!", "test@example.com", ""));
        
        // Case 14: Full name is at minimum valid length
        System.out.println("Running test Case 14: Full name is at minimum valid length...");
        assertTrue(userManager.signup("user10", "Password1!", "Password1!", "test@example.com", "A"));
        
        // Case 15: Full name is just below maximum length
        System.out.println("Running test Case 15: Full name is just below maximum length...");
        assertTrue(userManager.signup("user11", "Password1!", "Password1!", "test@example.com", "A".repeat(49)));
        
        // Case 16: Full name is at maximum length
        System.out.println("Running test Case 16: Full name is at maximum length...");
        assertTrue(userManager.signup("user12", "Password1!", "Password1!", "test@example.com", "A".repeat(50)));
        
        // Case 17: Nominal case
        System.out.println("Running test Case 17: Nominal case...");
        assertTrue(userManager.signup("user13", "Password1!", "Password1!", "test@example.com", "John Doe"));
    }
}