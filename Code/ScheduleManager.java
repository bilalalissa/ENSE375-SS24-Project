package Proj_375_Classes;


import java.util.*;
import java.util.stream.Collectors;

public class ScheduleManager {
    private TaskManager taskManager;

    public ScheduleManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    // View schedule by day
    public List<Task> viewDailySchedule(Date date) {
        return taskManager.getAllTasks().stream()
            .filter(task -> isSameDay(task.getDueDate(), date))
            .collect(Collectors.toList());
    }

    // View schedule by week
    public List<Task> viewWeeklySchedule(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date endDate = calendar.getTime();

        return taskManager.getAllTasks().stream()
            .filter(task -> task.getDueDate().after(startDate) && task.getDueDate().before(endDate))
            .collect(Collectors.toList());
    }

    // View schedule by month
    public List<Task> viewMonthlySchedule(int month, int year) {
        return taskManager.getAllTasks().stream()
            .filter(task -> {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(task.getDueDate());
                return calendar.get(Calendar.MONTH) == month && calendar.get(Calendar.YEAR) == year;
            })
            .collect(Collectors.toList());
    }

    // View schedule by semester
    public List<Task> viewSemesterSchedule(String semester, int year) {
        return taskManager.getAllTasks().stream()
            .filter(task -> {
                Course course = taskManager.getCourseForTask(task);
                return course != null && course.getSemester().equalsIgnoreCase(semester) && course.getYear() == year;
            })
            .collect(Collectors.toList());
    }

    // Utility method to check if two dates are on the same day
    private boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
               cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}

