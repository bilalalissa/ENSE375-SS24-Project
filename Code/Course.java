package Proj_375_Classes;



public class Course {
    private String courseName;
    private String semester;
    private int year;
    private String courseCode;

    // Constructor
    public Course(String courseName, String semester, int year, String courseCode) {
        this.courseName = courseName;
        this.semester = semester;
        this.year = year;
        this.courseCode = courseCode;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
