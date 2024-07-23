package PathTesting;

import Proj_375_Classes.UserManager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StateTransitionTest {

    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testSignup_TransitionToLoggedIn() {
        System.out.println("Running test case: Sign Up Transition to Logged In...");
        assertTrue(userManager.signup("user1", "Password1!", "Password1!", "user1@example.com", "User One"));
        assertFalse(userManager.isLoggedIn("user1")); // Initially, user is not logged in
    }

    @Test
    public void testLogin_TransitionToLoggedIn() {
        userManager.signup("user2", "Password1!", "Password1!", "user2@example.com", "User Two");
        System.out.println("Running test case: Log In Transition to Logged In...");
        userManager.signin("user2", "Password1!");
        assertTrue(userManager.isLoggedIn("user2"));
    }

    @Test
    public void testLogout_TransitionToLoggedOut() {
        userManager.signup("user3", "Password1!", "Password1!", "user3@example.com", "User Three");
        userManager.signin("user3", "Password1!");
        System.out.println("Running test case: Log Out Transition to Logged Out...");
        userManager.logout("user3");
        assertFalse(userManager.isLoggedIn("user3"));
    }

    @Test
    public void testUpdateProfile_StayLoggedIn() {
        userManager.signup("user4", "Password1!", "Password1!", "user4@example.com", "User Four");
        userManager.signin("user4", "Password1!");
        System.out.println("Running test case: Update Profile, Stay Logged In...");
        assertTrue(userManager.updateProfile("user4", "newemail@example.com", "New Name"));
        assertTrue(userManager.isLoggedIn("user4"));
    }

    @Test
    public void testDeleteAccount_TransitionToLoggedOut() {
        userManager.signup("user5", "Password1!", "Password1!", "user5@example.com", "User Five");
        userManager.signin("user5", "Password1!");
        System.out.println("Running test case: Delete Account, Transition to Logged Out...");
        assertTrue(userManager.deleteAccount("user5"));
        assertFalse(userManager.isLoggedIn("user5"));
    }
}
