package course;

import professor.Professor;
import student.Student;

import javax.swing.*;
import java.util.Date;

public interface CourseServiceI {
    Course createCourse(String courseName,
                        String professor,
                        int courseId,
                        String startDate,
                        String endDate,
                        int courseCredits,
                        String room,
                        int capacity);
    DefaultListModel<Course> getAllCourses();
}
