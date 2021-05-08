package student;

import course.Course;

import javax.swing.*;

public interface StudentServiceI {
    Student createStudent(String name,
                          String surname,
                          String studentId,
                          int GPA,
                          int year,
                          int semester,
                          Department department);
    Student addStudent(String name, String surname, Department department);
    DefaultListModel<Student> getAllStudents();
    void deleteStudent(Student student);
    void enrollInCourse(String studentId, Course course);
    void enrollInCourseArray(String[] studentIds, Course course);
    void finishCourse(Student student, Course course);
}
