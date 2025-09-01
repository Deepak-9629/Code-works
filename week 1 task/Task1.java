package firstweektask;

import java.util.*;

class Task {
    private final String id;
    private final String description;
    private final int priority;

    public Task(String id, String description, int priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

   
    public String toString() {
        return "Task[ID=" + id + ", Description=" + description + ", Priority=" + priority + "]";
    }
}

class TaskManager {
    private final PriorityQueue<Task> taskQueue;
    private final Map<String, Task> taskMap;

    public TaskManager() {
        taskQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getPriority).reversed());
        taskMap = new HashMap<>();
    }

    public void addTask(String id, String description, int priority) {
        if (taskMap.containsKey(id)) {
            System.out.println("Task with ID " + id + " already exists.");
            return;
        }
        Task task = new Task(id, description, priority);
        taskQueue.offer(task);
        taskMap.put(id, task);
    }

    public void removeTask(String id) {
        Task task = taskMap.remove(id);
        if (task != null) {
            taskQueue.remove(task);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    public Task getHighestPriorityTask() {
        return taskQueue.peek();
    }
}

public class Task1 {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.addTask("1", "Complete project report", 3);
        manager.addTask("2", "Prepare for meeting", 5);
        manager.addTask("3", "Reply to emails", 2);
        
        System.out.println("Highest Priority Task: " + manager.getHighestPriorityTask());
        
        manager.removeTask("2");
        System.out.println("After removing task 2:");
        System.out.println("Highest Priority Task: " + manager.getHighestPriorityTask());
    }
}
