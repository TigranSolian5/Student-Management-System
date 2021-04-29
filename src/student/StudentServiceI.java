package student;

public interface StudentServiceI {
    Student createStudent(String name,
                          String surname,
                          String studentId,
                          double GPA,
                          int year,
                          int semester,
                          Department department);
    Student addStudent(String name, String surname, Department department);
}
