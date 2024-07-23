package Proj_375_Classes;

import java.util.Date;

public class Task {
    private String taskName;
    private Date dueDate;
    private String status; // e.g., "complete" or "incomplete"
    private String courseCode;

    // Constructor
    public Task(String taskName, Date dueDate, String status, String courseCode) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.status = status;
        this.courseCode = courseCode;
    }

    // Getters and Setters
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
