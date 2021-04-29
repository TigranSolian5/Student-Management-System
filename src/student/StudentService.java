package student;

public class StudentService implements StudentServiceI {
    @Override
    public Student createStudent(String name, String surname, String studentId, double GPA, int year, int semester, Department department) {
        return StudentDao.createStudent(name, surname, studentId, GPA, year, semester, department);
    }

    @Override
    public Student addStudent(String name, String surname, Department department) {
        return StudentDao.createStudent(name, surname, department);
    }
}
