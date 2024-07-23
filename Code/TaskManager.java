package Proj_375_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private Map<String, List<Task>> tasksByCourse = new HashMap<>();
    private CourseManager courseManager;

    public TaskManager(CourseManager courseManager) {
        this.courseManager = courseManager;
    }

    // Add task
    public boolean addTask(String taskName, Date dueDate, String status, String courseCode) {
        Task newTask = new Task(taskName, dueDate, status, courseCode);
        tasksByCourse.computeIfAbsent(courseCode, k -> new ArrayList<>()).add(newTask);
        return true;
    }

    // Update task
    public boolean updateTask(String courseCode, String taskName, Date newDueDate, String newStatus) {
        List<Task> tasks = tasksByCourse.get(courseCode);
        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTaskName().equals(taskName)) {
                    task.setDueDate(newDueDate);
                    task.setStatus(newStatus);
                    return true;
                }
            }
        }
        return false;
    }

    // Delete task
    public boolean deleteTask(String courseCode, String taskName) {
        List<Task> tasks = tasksByCourse.get(courseCode);
        if (tasks != null) {
            return tasks.removeIf(task -> task.getTaskName().equals(taskName));
        }
        return false;
    }

    // Search task
    public Task searchTask(String courseCode, String taskName) {
        List<Task> tasks = tasksByCourse.get(courseCode);
        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTaskName().equals(taskName)) {
                    return task;
                }
            }
        }
        return null;
    }

    // List tasks by course
    public List<Task> listTasksByCourse(String courseCode) {
        return tasksByCourse.getOrDefault(courseCode, new ArrayList<>());
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        return tasksByCourse.values().stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }

    // Get course for a specific task
    public Course getCourseForTask(Task task) {
        return courseManager.searchCourse(task.getCourseCode());
    }
}
