package PathTesting;

import org.junit.jupiter.api.Test;

import Proj_375_Classes.UserManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class UserManager_DataFlowTesting {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testSignup_UsernameExists() {
        userManager.signup("existingUser", "Password123!", "Password123!", "existing@user.com", "Existing User");
        boolean result = userManager.signup("existingUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertFalse(result);
    }

    @Test
    void testSignup_PasswordsDoNotMatch() {
        boolean result = userManager.signup("newUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result);
    }

    @Test
    void testSignup_InvalidEmail() {
        boolean result = userManager.signup("newUser", "Password123!", "Password123!", "invalid-email", "New User");
        assertFalse(result);
    }

    @Test
    void testSignup_InvalidPassword() {
        boolean result = userManager.signup("newUser", "password", "password", "new@user.com", "New User");
        assertFalse(result);
    }

    @Test
    void testSignup_Success() {
        boolean result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result);
    }

    @Test
    void testSignup_AllDUPaths() {
        // Test 1: Definition and use of username (Path: 1 -> 2 -> 7)
        userManager.signup("existingUser", "Password123!", "Password123!", "existing@user.com", "Existing User");
        boolean result1 = userManager.signup("existingUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertFalse(result1);

        // Test 2: Definition and use of password and confirmPassword (Path: 1 -> 3 -> 7)
        boolean result2 = userManager.signup("newUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result2);

        // Test 3: Definition and use of email (Path: 1 -> 4 -> 7)
        boolean result3 = userManager.signup("newUser", "Password123!", "Password123!", "invalid-email", "New User");
        assertFalse(result3);

        // Test 4: Definition and use of password (Path: 1 -> 5 -> 7)
        boolean result4 = userManager.signup("newUser", "password", "password", "new@user.com", "New User");
        assertFalse(result4);

        // Test 5: Definition and use of all parameters for success (Path: 1 -> 6 -> 8)
        boolean result5 = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result5);
    }
}