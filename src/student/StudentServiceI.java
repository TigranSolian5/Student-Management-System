package student;

import java.util.List;

public interface StudentServiceI {
    Student createStudent(String name,
                          String surname,
                          String studentId,
                          int GPA,
                          int year,
                          int semester,
                          Department department);
    Student addStudent(String name, String surname, Department department);
    List<Student> getAllStudents();
    void deleteStudent(Student student);
}
