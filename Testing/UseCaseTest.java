package PathTesting;

import Proj_375_Classes.UserManager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UseCaseTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testSignupAndLogin() {
        System.out.println("Running test case: Signup and Login...");
        assertTrue(userManager.signup("user1", "Password1!", "Password1!", "user1@example.com", "User One"));
        assertFalse(userManager.isLoggedIn("user1")); // Initially, user is not logged in
        userManager.signin("user1", "Password1!");
        assertTrue(userManager.isLoggedIn("user1"));
    }

    @Test
    public void testProfileUpdate() {
        userManager.signup("user2", "Password1!", "Password1!", "user2@example.com", "User Two");
        userManager.signin("user2", "Password1!");
        System.out.println("Running test case: Profile Update...");
        assertTrue(userManager.updateProfile("user2", "newemail@example.com", "New Name"));
        assertTrue(userManager.isLoggedIn("user2"));
    }

    @Test
    public void testLogout() {
        userManager.signup("user3", "Password1!", "Password1!", "user3@example.com", "User Three");
        userManager.signin("user3", "Password1!");
        System.out.println("Running test case: Logout...");
        userManager.logout("user3");
        assertFalse(userManager.isLoggedIn("user3"));
    }

    @Test
    public void testDeleteAccount() {
        userManager.signup("user4", "Password1!", "Password1!", "user4@example.com", "User Four");
        userManager.signin("user4", "Password1!");
        System.out.println("Running test case: Delete Account...");
        assertTrue(userManager.deleteAccount("user4"));
        assertFalse(userManager.isLoggedIn("user4"));
    }
}
