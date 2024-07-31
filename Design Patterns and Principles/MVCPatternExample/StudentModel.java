import java.util.ArrayList;
import java.util.List;

public class StudentModel {
    private List<Student> students;

    public StudentModel() {
        students = new ArrayList<>();
        // Adding some default students
        students.add(new Student(1, "John Doe", 20));
        students.add(new Student(2, "Jane Smith", 22));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(Student student) {
        Student existing = getStudentById(student.getId());
        if (existing != null) {
            existing.setName(student.getName());
            existing.setAge(student.getAge());
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }
}