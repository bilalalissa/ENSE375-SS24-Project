package PathTesting;

import Proj_375_Classes.UserManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EquivalenceClassTest {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testWeakNormalECT() {
        // Valid Case for Weak Normal ECT
        assertTrue(userManager.signup("validUser", "ValidPass1!", "ValidPass1!", "test@example.com", "John Doe"));
    }

    @Test
    void testStrongNormalECT() {
        // Valid Cases for Strong Normal ECT
        assertTrue(userManager.signup("validUser", "ValidPass1!", "ValidPass1!", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "ValidPass1!", "WrongPass1!", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "ValidPass1!", "ValidPass1!", "invalidEmail", "John Doe"));
    }

    @Test
    void testWeakRobustECT() {
        // Invalid Cases for Weak Robust ECT
        assertFalse(userManager.signup("u", "ValidPass1!", "ValidPass1!", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "pass", "pass", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "ValidPass1!", "ValidPass1!", "invalidEmail", "John Doe"));
    }

    @Test
    void testStrongRobustECT() {
        // Invalid Cases for Strong Robust ECT
        assertFalse(userManager.signup("u", "ValidPass1!", "ValidPass1!", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "pass", "pass", "test@example.com", "John Doe"));
        assertFalse(userManager.signup("validUser", "ValidPass1!", "ValidPass1!", "invalidEmail", "John Doe"));
    }
}
