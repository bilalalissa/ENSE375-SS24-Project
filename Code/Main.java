package Proj_375_Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	private static User signedInUser = null;

	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		CourseManager courseManager = new CourseManager();
		TaskManager taskManager = new TaskManager(courseManager);
		ScheduleManager scheduleManager = new ScheduleManager(taskManager);
		ExportManager exportManager = new ExportManager();
		Scanner scanner = new Scanner(System.in);

		System.out.println(
				"\n\t\tWelcome to EduTrak..\n\n\tWelcome you, where the user can achieve \n\tsuccessful academic performance \n\tthrough wize time and academic management..");

		while (true) {
			if (signedInUser == null) {
				handleUserManagement(userManager, scanner);
			} else {
				showMainMenu();
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				clearScreen();
				printHeader();

				switch (choice) {
				case 1:
					handleCourseManagement(courseManager, scanner);
					break;
				case 2:
					handleTaskManagement(taskManager, scanner);
					break;
				case 3:
					handleScheduleManagement(scheduleManager, scanner);
					break;
				case 4:
					handleExportData(userManager, courseManager, scheduleManager, exportManager, scanner);
					break;
				case 5:
					System.out.println("..See you arround, "+ signedInUser.getFullName() +"\nSigning out...\n\n");
					signedInUser = null;
					break;
				case 6:
					System.out.println("..Bye for now, " + signedInUser.getFullName() + ".. App is exiting...\n\n");
					scanner.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please try again.\n");
				}
			}
		}
	}

	private static void showMainMenu() {
		System.out.println("\nMain Menu:");
		System.out.println("1. Course Management");
		System.out.println("2. Task Management");
		System.out.println("3. Schedule Management");
		System.out.println("4. Export Data");
		System.out.println("5. Sign out");
		System.out.println("6. Exit");
	}

	private static void handleUserManagement(UserManager userManager, Scanner scanner) {

		while (signedInUser == null) {

			System.out.println("\nUser Management:");
			System.out.println("1. Signup");
			System.out.println("2. Signin");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			clearScreen();
			printHeader();

			switch (choice) {
			case 1:
				System.out.print("\nSign-up menue..\n");
				System.out.print("\nEnter username: ");
				String username = scanner.nextLine();
				System.out.print("Enter password (>= 8 chars: upper/lower, digits, symbols): ");
				String password = scanner.nextLine();
				System.out.print("Confirm password: ");
				String confirmPassword = scanner.nextLine();
				System.out.print("Enter email (e.g. user@www.com): ");
				String email = scanner.nextLine();
				System.out.print("Enter full name: ");
				String fullName = scanner.nextLine();
				if (userManager.signup(username, password, confirmPassword, email, fullName)) {

					clearScreen();
					printHeader();
					
					System.out.println("Signup successful!");
				} else {
					// Error messages are already printed by UserManager
				}
				break;
			case 2:
				System.out.print("\nSignin menue..\n");
				System.out.print("\nEnter username: ");
				username = scanner.nextLine();
				System.out.print("Enter password: ");
				password = scanner.nextLine();
				signedInUser = userManager.signin(username, password);
				if (signedInUser != null) {

					clearScreen();
					printHeader();
					
					System.out.println("Signin successful! Welcome, " + signedInUser.getFullName());
				} else {

					clearScreen();
					printHeader();
					
					System.out.println("Invalid username or password.\n");
				}
				break;
			case 3:

				clearScreen();
				printHeader();
				
				System.out.println("..Bye for now.. App is exiting...\n\n");
				scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
	}

	private static void handleCourseManagement(CourseManager courseManager, Scanner scanner) {
		while (true) {
			System.out.println("\nCourse Management:");
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Delete Course");
			System.out.println("4. Search Course");
			System.out.println("5. Back");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			clearScreen();
			printHeader();

			switch (choice) {
			case 1:
				System.out.print("\nEnter course name (e.g. Software Testing): ");
				String courseName = scanner.nextLine();
				System.out.print("Enter course code (e.g. ENSE 375): ");
				String courseCode = scanner.nextLine();
				System.out.print("Enter semester (e.g. W, SS, F): ");
				String semester = scanner.nextLine();
				System.out.print("Enter year: ");
				int year = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				if (courseManager.addCourse(courseName, semester, year, courseCode)) {
					System.out.println("Course added successfully!\n");
				} else {
					System.out.println("Course code already exists.\n");
				}
				break;
			case 2:
				System.out.print("\nEnter course code to update (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				System.out.print("Enter new course name (e.g. Software Testing): ");
				courseName = scanner.nextLine();
				System.out.print("Enter new semester (e.g. W, SS, F): ");
				semester = scanner.nextLine();
				System.out.print("Enter new year: ");
				year = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				if (courseManager.updateCourse(courseCode, courseName, semester, year)) {
					System.out.println("Course updated successfully.\n");
				} else {
					System.out.println("Course not found.");
				}
				break;
			case 3:
				System.out.print("\nEnter course code to delete (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				if (courseManager.deleteCourse(courseCode)) {
					System.out.println("Course deleted successfully.\n");
				} else {
					System.out.println("Course not found.\n");
				}
				break;
			case 4:
				System.out.print("\nEnter course code to search (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				Course course = courseManager.searchCourse(courseCode);
				if (course != null) {
					System.out.println("Course found: " + course.getCourseName() + ", " + course.getSemester() + " "
							+ course.getYear());
				} else {
					System.out.println("Course not found.\n");
				}
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
	}

	private static void handleTaskManagement(TaskManager taskManager, Scanner scanner) {

		while (true) {

			System.out.println("\nTask Management:");
			System.out.println("1. Add Task");
			System.out.println("2. Update Task");
			System.out.println("3. Delete Task");
			System.out.println("4. Search Task");
			System.out.println("5. List Tasks by Course");
			System.out.println("6. Back");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			clearScreen();
			printHeader();

			switch (choice) {
			case 1:
				System.out.print("\nEnter course code (e.g. ENSE 375): ");
				String courseCode = scanner.nextLine();
				System.out.print("Enter task name: ");
				String taskName = scanner.nextLine();
				System.out.print("Enter due date (yyyy-MM-dd): ");
				String dueDateStr = scanner.nextLine();
				System.out.print("Enter status (complete / progress / incomplete): ");
				String status = scanner.nextLine();
				try {
					Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr);
					if (taskManager.addTask(taskName, dueDate, status, courseCode)) {
						System.out.println("Task added successfully!");
					} else {
						System.out.println("Failed to add task.\n");
					}
				} catch (ParseException e) {
					System.out.println("Invalid date format.\n");
				}
				break;
			case 2:
				System.out.print("\nEnter course code (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				System.out.print("Enter task name: ");
				taskName = scanner.nextLine();
				System.out.print("Enter new due date (yyyy-MM-dd): ");
				String dueDateStr2 = scanner.nextLine();
				System.out.print("Enter new status (complete / progress / incomplete): ");
				status = scanner.nextLine();
				try {
					Date newDueDate = new SimpleDateFormat("yyyy-MM-dd").parse(dueDateStr2);
					if (taskManager.updateTask(courseCode, taskName, newDueDate, status)) {
						System.out.println("Task updated successfully.\n");
					} else {
						System.out.println("Task not found.\n");
					}
				} catch (ParseException e) {
					System.out.println("Invalid date format.\n");
				}
				break;
			case 3:
				System.out.print("\nEnter course code (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				System.out.print("Enter task name: ");
				taskName = scanner.nextLine();
				if (taskManager.deleteTask(courseCode, taskName)) {
					System.out.println("Task deleted successfully.\n");
				} else {
					System.out.println("Task not found.\n");
				}
				break;
			case 4:
				System.out.print("\nEnter course code (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				System.out.print("Enter task name: ");
				taskName = scanner.nextLine();
				Task task = taskManager.searchTask(courseCode, taskName);
				if (task != null) {
					System.out.println("Task found: " + task.getTaskName() + ", Due: " + task.getDueDate()
							+ ", Status: " + task.getStatus());
				} else {
					System.out.println("Task not found.\n");
				}
				break;
			case 5:
				System.out.print("Enter course code (e.g. ENSE 375): ");
				courseCode = scanner.nextLine();
				List<Task> tasks = taskManager.listTasksByCourse(courseCode);
				if (!tasks.isEmpty()) {
					for (Task t : tasks) {
						System.out.println("- Task: " + t.getTaskName() + ", Due: " + t.getDueDate() + ", Status: "
								+ t.getStatus());
					}
				} else {
					System.out.println("No tasks found for this course.\n");
				}
				break;
			case 6:
				return;
			default:
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
	}

	private static void handleScheduleManagement(ScheduleManager scheduleManager, Scanner scanner) {

		while (true) {

			System.out.println("\nSchedule Management:");
			System.out.println("1. View Daily Schedule");
			System.out.println("2. View Weekly Schedule");
			System.out.println("3. View Monthly Schedule");
			System.out.println("4. View Semester Schedule");
			System.out.println("5. Back");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			clearScreen();
			printHeader();

			switch (choice) {
			case 1:
				System.out.print("\nEnter date (yyyy-MM-dd): ");
				String dateStr = scanner.nextLine();
				try {
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					List<Task> dailyTasks = scheduleManager.viewDailySchedule(date);
					if (!dailyTasks.isEmpty()) {
						for (Task task : dailyTasks) {
							System.out.println("- Task: " + task.getTaskName() + ", Due: " + task.getDueDate()
									+ ", Status: " + task.getStatus());
						}
					} else {
						System.out.println("No tasks found for this day.\n");
					}
				} catch (ParseException e) {
					System.out.println("Invalid date format.\n");
				}
				break;
			case 2:
				System.out.print("\nEnter start date (yyyy-MM-dd): ");
				dateStr = scanner.nextLine();
				try {
					Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
					List<Task> weeklyTasks = scheduleManager.viewWeeklySchedule(startDate);
					if (!weeklyTasks.isEmpty()) {
						for (Task task : weeklyTasks) {
							System.out.println("- Task: " + task.getTaskName() + ", Due: " + task.getDueDate()
									+ ", Status: " + task.getStatus());
						}
					} else {
						System.out.println("No tasks found for this week.\n");
					}
				} catch (ParseException e) {
					System.out.println("Invalid date format.\n");
				}
				break;
			case 3:
				System.out.print("\nEnter month (1-12): ");
				int month = scanner.nextInt() - 1;
				System.out.print("Enter year: ");
				int year = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				List<Task> monthlyTasks = scheduleManager.viewMonthlySchedule(month, year);
				if (!monthlyTasks.isEmpty()) {
					for (Task task : monthlyTasks) {
						System.out.println("- Task: " + task.getTaskName() + ", Due: " + task.getDueDate()
								+ ", Status: " + task.getStatus());
					}
				} else {
					System.out.println("No tasks found for this month.\n");
				}
				break;
			case 4:
				System.out.print("\nEnter semester: ");
				String semester = scanner.nextLine();
				System.out.print("Enter year: ");
				year = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				List<Task> semesterTasks = scheduleManager.viewSemesterSchedule(semester, year);
				if (!semesterTasks.isEmpty()) {
					for (Task task : semesterTasks) {
						System.out.println("- Task: " + task.getTaskName() + ", Due: " + task.getDueDate()
								+ ", Status: " + task.getStatus());
					}
				} else {
					System.out.println("No tasks found for this semester.\n");
				}
				break;
			case 5:
				return;
			default:
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
	}

	private static void handleExportData(UserManager userManager, CourseManager courseManager,
			ScheduleManager scheduleManager, ExportManager exportManager, Scanner scanner) {

		while (true) {

			System.out.println("\nExport Data:");
			System.out.println("1. Export User Information");
			System.out.println("2. Export Course Information");
			System.out.println("3. Export Schedule");
			System.out.println("4. Back");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			clearScreen();
			printHeader();

			switch (choice) {
			case 1:
				System.out.print("\nEnter file path for user information export: ");
				String userFilePath = scanner.nextLine();
				List<User> users = new ArrayList<>(userManager.getAllUsers());
				exportManager.exportUserInformation(users, userFilePath);
				break;
			case 2:
				System.out.print("\nEnter file path for course information export: ");
				String courseFilePath = scanner.nextLine();
				List<Course> courses = new ArrayList<>(courseManager.getAllCourses());
				exportManager.exportCourseInformation(courses, courseFilePath);
				break;
			case 3:
				System.out.print("\nEnter file path for schedule export: ");
				String scheduleFilePath = scanner.nextLine();
				List<Task> tasks = scheduleManager.viewSemesterSchedule("Spring", 2024); // Example schedule
				exportManager.exportSchedule(tasks, scheduleFilePath);
				break;
			case 4:
				return;
			default:
				System.out.println("Invalid choice. Please try again.\n");
			}
		}
	}

	private static void clearScreen() {
		// Simulate clearing the screen by printing multiple new lines
		for (int i = 0; i < 15; i++) {
            System.out.println();
		}
	}

	private static void printHeader() {
		System.out.println("\n\t\t<<< EduTrack Application >>>\n");
	}

}
