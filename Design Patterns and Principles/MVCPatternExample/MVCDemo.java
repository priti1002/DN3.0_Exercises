public class MVCDemo {
    public static void main(String[] args) {
        // Create model and view
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(model, view);

        // List all students
        controller.listStudents();

        // Show details of a specific student
        controller.showStudent(1);

        // Add a new student
        controller.addStudent(3, "Emily Davis", 21);

        // List all students again to see the added student
        controller.listStudents();

        // Update a student's details
        controller.updateStudent(2, "Jane Smith", 23);

        // List all students again to see the updated details
        controller.listStudents();

        // Delete a student
        controller.deleteStudent(1);

        // List all students again to see the deletion
        controller.listStudents();
    }
}