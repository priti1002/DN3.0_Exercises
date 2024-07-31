import java.util.List;

public class StudentView {
    public void printStudentDetails(Student student) {
        if (student != null) {
            System.out.println("Student Details: ");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
        } else {
            System.out.println("Student not found.");
        }
    }

    public void printAllStudents(List<Student> students) {
        System.out.println("Student List:");
        for (Student student : students) {
            printStudentDetails(student);
        }
    }
}