public class StudentController {
    private StudentModel model;
    private StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void listStudents() {
        view.printAllStudents(model.getAllStudents());
    }

    public void showStudent(int id) {
        Student student = model.getStudentById(id);
        view.printStudentDetails(student);
    }

    public void addStudent(int id, String name, int age) {
        Student student = new Student(id, name, age);
        model.addStudent(student);
    }

    public void updateStudent(int id, String name, int age) {
        Student student = new Student(id, name, age);
        model.updateStudent(student);
    }

    public void deleteStudent(int id) {
        model.deleteStudent(id);
    }
}