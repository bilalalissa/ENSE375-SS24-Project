package Proj_375_Classes;


import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class CourseManager {
    private Map<String, Course> courses = new HashMap<>();

    // Add course
    public boolean addCourse(String courseName, String semester, int year, String courseCode) {
        if (courses.containsKey(courseCode)) {
            return false; // Course already exists
        }
        courses.put(courseCode, new Course(courseName, semester, year, courseCode));
        return true;
    }

    // Update course
    public boolean updateCourse(String courseCode, String courseName, String semester, int year) {
        Course course = courses.get(courseCode);
        if (course != null) {
            course.setCourseName(courseName);
            course.setSemester(semester);
            course.setYear(year);
            return true;
        }
        return false;
    }

    // Delete course
    public boolean deleteCourse(String courseCode) {
        return courses.remove(courseCode) != null;
    }

    // Search course
    public Course searchCourse(String courseCode) {
        return courses.get(courseCode);
    }

    // Get all courses
    public Collection<Course> getAllCourses() {
        return courses.values();
    }
}
