package Proj_375_Classes;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;
import java.util.Collection;
import java.util.regex.Pattern;

public class UserManager {
    private Map<String, User> users = new HashMap<>();
    private Set<String> loggedInUsers = new HashSet<>();

 // Signup user
    public boolean signup(String username, String password, String confirmPassword, String email, String fullName) {
        if (username == null || username.isEmpty()) {

			clearScreen();
			printHeader();

            System.out.println("Signup failed! Username ("+ username +") is empty.");
            return false; // Username is empty
        }
        if (username.length() < 3) {

			clearScreen();
			printHeader();

            System.out.println("Signup failed! Username length ("+ username.length() +") is less than minimum, 3 chars.");
            return false; // Username length is less than minimum
        }
        if (username.length() > 20) {

			clearScreen();
			printHeader();

            System.out.println("Signup failed! Username length ("+ username.length() +") is more than maximum, 20 chars.");
            return false; // Username length is more than maximum
        }
        if (users.containsKey(username)) {

			clearScreen();
			printHeader();

            System.out.println("Signup failed! Username already exists.");
            return false; // User already exists
        }
        if (!isValidPassword(password)) {

			clearScreen();
			printHeader();

            System.out.println("\nSignup failed!\n- Password must be at least 8 characters long. \n- Includes: \n   - upper and lower case letters. \n   - symbols.\n   - and numbers.");
            return false; // Invalid password
        }
        if (!password.equals(confirmPassword)) {

			clearScreen();
			printHeader();

            System.out.println("\nSignup failed! Passwords do not match.");
            return false; // Passwords do not match
        }
        if (!isValidEmail(email)) {

			clearScreen();
			printHeader();

            System.out.println("\nSignup failed! Invalid email format.");
            return false; // Invalid email
        }
        if (fullName.isEmpty()) {

			clearScreen();
			printHeader();

            System.out.println("\nSignup failed! Fullname is empty.");
            return false; // Fullname is empty
        }
        if (fullName.length() > 50) {

			clearScreen();
			printHeader();

            System.out.println("\nSignup failed! Fullname length is more than maximum, 50 chars.");
            return false; // Fullname length is more than maximum, 50 chars
        }
        users.put(username, new User(username, password, email, fullName));
        return true;
    }

    // Validate password
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.matches(regex, password);
    }

    // Validate email
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$";
        return Pattern.matches(regex, email);
    }

    // Signin user
    public User signin(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUsers.add(username);
            return user; // Successful signin
        }
        return null; // Signin failed
    }
    
    // Logout method
    public void logout(String username) {
        loggedInUsers.remove(username);
    }

    // Search user
    public User searchUser(String username) {
        return users.get(username);
    }

    // Update user information
    public boolean updateUser(String username, String password, String email, String fullName) {
        User user = users.get(username);
        if (user != null) {
            user.setPassword(password);
            user.setEmail(email);
            user.setFullName(fullName);
            return true;
        }
        return false;
    }

    // Delete user
    public boolean deleteUser(String username) {
        return users.remove(username) != null;
    }

    // Get all users
    public Collection<User> getAllUsers() {
        return users.values();
    }
    

	private static void clearScreen() {
		// Simulate clearing the screen by printing multiple new lines
		// For debugging and testing loop max replaced with 2, original value is 15
		for (int i = 0; i < 2; i++) {
            System.out.println();
		}
	}

	private static void printHeader() {
		System.out.println("\n\t\t<<< EduTrack Application >>>\n");
	}

	// Check if user is logged in
    public boolean isLoggedIn(String username) {
		System.out.println("User logged in: " + username);
		return loggedInUsers.contains(username);
	}
    

    // Update profile method
    public boolean updateProfile(String username, String newEmail, String newFullName) {
        User user = users.get(username);
        if (user != null) {
            user.setEmail(newEmail);
            user.setFullName(newFullName);
            return true;
        }
        return false;
    }

    // Delete account method
    public boolean deleteAccount(String username) {
        if (users.remove(username) != null) {
            loggedInUsers.remove(username);
            return true;
        }
        return false;
    }
}
