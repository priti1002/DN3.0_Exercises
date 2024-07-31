public class EmployeeManagementSystem {
    private Employee[] employees;
    private int count;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    // Method to add an employee
    public boolean addEmployee(Employee employee) {
        if (count >= employees.length) {
            return false; // array is full
        }
        employees[count++] = employee;
        return true;
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id.equals(id)) {
                return employees[i];
            }
        }
        return null; // employee not found
    }

    // Method to delete an employee by ID
    public boolean deleteEmployee(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].id.equals(id)) {
                // Shift elements to the left to fill the gap
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; // decrease count and nullify the last element
                return true;
            }
        }
        return false; // employee not found
    }

    // Method to traverse and print all employee records
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee("1", "Alice", "Engineering", 90000));
        ems.addEmployee(new Employee("2", "Bob", "Marketing", 75000));
        ems.addEmployee(new Employee("3", "Charlie", "HR", 80000));

        // Traversing employees
        System.out.println("All Employees:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.println("Search Employee with ID '2':");
        Employee emp = ems.searchEmployee("2");
        System.out.println(emp != null ? emp : "Employee not found");

        // Deleting an employee
        System.out.println("Deleting Employee with ID '2':");
        boolean isDeleted = ems.deleteEmployee("2");
        System.out.println(isDeleted ? "Employee deleted successfully" : "Employee not found");

        // Traversing employees after deletion
        System.out.println("All Employees after deletion:");
        ems.traverseEmployees();
    }
}
