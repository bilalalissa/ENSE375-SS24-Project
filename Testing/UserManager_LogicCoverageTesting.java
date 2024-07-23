package PathTesting;


import Proj_375_Classes.UserManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserManager_LogicCoverageTesting {

    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    // Predicate Coverage
    @Test
    void testPredicateCoverage_UsernameExists() {
        userManager.signup("existingUser", "Password123!", "Password123!", "existing@user.com", "Existing User");
        boolean result = userManager.signup("existingUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertFalse(result); // Predicate evaluates to true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Predicate evaluates to false
    }

    @Test
    void testPredicateCoverage_PasswordsDoNotMatch() {
        boolean result = userManager.signup("newUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result); // Predicate evaluates to true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Predicate evaluates to false
    }

    @Test
    void testPredicateCoverage_InvalidEmail() {
        boolean result = userManager.signup("newUser", "Password123!", "Password123!", "invalid-email", "New User");
        assertFalse(result); // Predicate evaluates to true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Predicate evaluates to false
    }

    @Test
    void testPredicateCoverage_InvalidPassword() {
        boolean result = userManager.signup("newUser", "password", "password", "new@user.com", "New User");
        assertFalse(result); // Predicate evaluates to true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Predicate evaluates to false
    }

    // Clause Coverage
    @Test
    void testClauseCoverage_UsernameExists() {
        userManager.signup("existingUser", "Password123!", "Password123!", "existing@user.com", "Existing User");
        boolean result = userManager.signup("existingUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertFalse(result); // Clause users.containsKey(username) is true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Clause users.containsKey(username) is false
    }

    @Test
    void testClauseCoverage_PasswordsDoNotMatch() {
        boolean result = userManager.signup("newUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result); // Clause !password.equals(confirmPassword) is true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Clause !password.equals(confirmPassword) is false
    }

    @Test
    void testClauseCoverage_InvalidEmail() {
        boolean result = userManager.signup("newUser", "Password123!", "Password123!", "invalid-email", "New User");
        assertFalse(result); // Clause !isValidEmail(email) is true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Clause !isValidEmail(email) is false
    }

    @Test
    void testClauseCoverage_InvalidPassword() {
        boolean result = userManager.signup("newUser", "password", "password", "new@user.com", "New User");
        assertFalse(result); // Clause !isValidPassword(password) is true

        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result); // Clause !isValidPassword(password) is false
    }

    // Combinatorial Coverage
    @Test
    void testCombinatorialCoverage() {
        // Combination: users.containsKey(username) = true, !password.equals(confirmPassword) = true
        userManager.signup("existingUser", "Password123!", "Password123!", "existing@user.com", "Existing User");
        boolean result = userManager.signup("existingUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result);

        // Combination: users.containsKey(username) = false, !password.equals(confirmPassword) = true
        result = userManager.signup("newUser", "Password123!", "Password1234!", "new@user.com", "New User");
        assertFalse(result);

        // Combination: users.containsKey(username) = true, !password.equals(confirmPassword) = false
        result = userManager.signup("existingUser", "Password123!", "Password123!", "existing2@user.com", "Existing User 2");
        assertFalse(result);

        // Combination: users.containsKey(username) = false, !password.equals(confirmPassword) = false
        result = userManager.signup("newUser", "Password123!", "Password123!", "new@user.com", "New User");
        assertTrue(result);

        // Further combinations for all predicates
        result = userManager.signup("user1", "Password123!", "Password123!", "invalid-email", "User One");
        assertFalse(result);

        result = userManager.signup("user2", "password", "password", "user2@domain.com", "User Two");
        assertFalse(result);

        result = userManager.signup("user3", "Password123!", "Password1234!", "user3@domain.com", "User Three");
        assertFalse(result);

        result = userManager.signup("user4", "Password123!", "Password123!", "user4@domain.com", "User Four");
        assertTrue(result);
    }
}
