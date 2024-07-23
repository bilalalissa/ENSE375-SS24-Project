package Proj_375_Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportManager {

    public void exportUserInformation(List<User> users, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (User user : users) {
                writer.write("Username: " + user.getUsername());
                writer.write("\nEmail: " + user.getEmail());
                writer.write("\nFull Name: " + user.getFullName());
                writer.write("\n\n");
            }
            System.out.println("User information exported successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting user information: " + e.getMessage());
        }
    }

    public void exportCourseInformation(List<Course> courses, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Course course : courses) {
                writer.write("Course Name: " + course.getCourseName());
                writer.write("\nCourse Code: " + course.getCourseCode());
                writer.write("\nSemester: " + course.getSemester());
                writer.write("\nYear: " + course.getYear());
                writer.write("\n\n");
            }
            System.out.println("Course information exported successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting course information: " + e.getMessage());
        }
    }

    public void exportSchedule(List<Task> tasks, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                writer.write("Task Name: " + task.getTaskName());
                writer.write("\nDue Date: " + task.getDueDate());
                writer.write("\nStatus: " + task.getStatus());
                writer.write("\nCourse Code: " + task.getCourseCode());
                writer.write("\n\n");
            }
            System.out.println("Schedule exported successfully.");
        } catch (IOException e) {
            System.err.println("Error exporting schedule: " + e.getMessage());
        }
    }
}
