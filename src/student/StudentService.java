package student;

import course.Course;

import javax.swing.*;
import java.util.List;

public class StudentService implements StudentServiceI {
    @Override
    public Student createStudent(String name, String surname, String studentId, int GPA, int year, int semester, Department department) {
        return StudentDao.createStudent(name, surname, studentId, GPA, year, semester, department);
    }

    @Override
    public Student addStudent(String name, String surname, Department department) {
        return StudentDao.createStudent(name, surname, department);
    }

    @Override
    public DefaultListModel<Student> getAllStudents() {
        List<Student> students = StudentDao.readAllStudents();
        DefaultListModel<Student> demoList = new DefaultListModel<>();

        students.forEach(demoList::addElement);
        return demoList;
    }

    @Override
    public void deleteStudent(Student student) {
        StudentDao.removeStudent(student);
    }

    @Override
    public void enrollInCourse(String studentId, Course course) {
       enrollInCourseArray(new String[]{studentId}, course);
    }

    @Override
    public void enrollInCourseArray(String[] studentIds, Course course) {
        StudentDao.addStudentToCourseArray(studentIds, course);
    }

    @Override
    public void finishCourse(Student student, Course course) {
        StudentDao.removeCourseFromStudent(student, course);
    }
}
