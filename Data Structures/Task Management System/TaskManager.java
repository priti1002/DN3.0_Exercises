public class TaskManager {
    private Node head;

    // Node class for singly linked list
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Method to add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a task by ID
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId.equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // task not found
    }

    // Method to delete a task by ID
    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false; // list is empty
        }

        if (head.task.taskId.equals(taskId)) {
            head = head.next; // delete head node
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.task.taskId.equals(taskId)) {
            current = current.next;
        }

        if (current.next == null) {
            return false; // task not found
        }

        current.next = current.next.next; // delete node
        return true;
    }

    // Method to traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask(new Task("1", "Task One", "Pending"));
        taskManager.addTask(new Task("2", "Task Two", "In Progress"));
        taskManager.addTask(new Task("3", "Task Three", "Completed"));

        // Traversing tasks
        System.out.println("All Tasks:");
        taskManager.traverseTasks();

        // Searching for a task
        System.out.println("Search Task with ID '2':");
        Task task = taskManager.searchTask("2");
        System.out.println(task != null ? task : "Task not found");

        // Deleting a task
        System.out.println("Deleting Task with ID '2':");
        boolean isDeleted = taskManager.deleteTask("2");
        System.out.println(isDeleted ? "Task deleted successfully" : "Task not found");

        // Traversing tasks after deletion
        System.out.println("All Tasks after deletion:");
        taskManager.traverseTasks();
    }
}
