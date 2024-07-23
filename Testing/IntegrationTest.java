package PathTesting;

import Proj_375_Classes.UserManager;
import Proj_375_Classes.CourseManager;
import Proj_375_Classes.TaskManager;
import Proj_375_Classes.ScheduleManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    private UserManager userManager;
    private CourseManager courseManager;
    private TaskManager taskManager;
    private ScheduleManager scheduleManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
        courseManager = new CourseManager();
        taskManager = new TaskManager(courseManager); // Using the default constructor
        scheduleManager = new ScheduleManager(taskManager); // Using the default constructor
    }

    @Test
    void testUserManagerAndCourseManagerIntegration() {
        userManager.signup("user1", "Password123!", "Password123!", "user1@example.com", "User One");
        boolean courseAdded = courseManager.addCourse("CSE101", "Intro to Computer Science", 2024, "Fall");
        assertTrue(courseAdded, "Course should be added successfully.");
    }

    @Test
    void testCourseManagerAndTaskManagerIntegration() {
        courseManager.addCourse("CSE101", "Intro to Computer Science", 2024, "Fall");
        Date dueDate = new Date();
        boolean taskAdded = taskManager.addTask("Assignment 1", dueDate, "CSE101", "Fall");
        assertTrue(taskAdded, "Task should be added to the course successfully.");
    }

    @Test
    void testTaskManagerAndScheduleManagerIntegration() {
        Date dueDate = new Date();
        boolean scheduleAdded = taskManager.addTask("Assignment 1", dueDate, "CSE101", "Fall");
        assertTrue(scheduleAdded, "Task should be scheduled successfully.");
    }
}