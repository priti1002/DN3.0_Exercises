class Employee {
    String id;
    String name;
    String department;
    double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id='" + id + "', name='" + name + "', department='" + department + "', salary=" + salary + '}';
    }
}
