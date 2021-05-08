package course;

import javax.swing.*;
import java.util.List;

public class CourseService implements CourseServiceI {
    @Override
    public Course createCourse(String courseName,
                               String professor,
                               int courseId,
                               String startDate,
                               String endDate,
                               int courseCredits,
                               String room,
                               int capacity) {
        return CourseDao.createCourse(courseName, professor, courseId, startDate, endDate, courseCredits, room, capacity);
    }

    @Override
    public DefaultListModel<Course> getAllCourses() {
        List<Course> courses = CourseDao.readAllCourses();
        DefaultListModel<Course> demoList = new DefaultListModel<>();

        courses.forEach((c) -> demoList.addElement(c));
        return demoList;
    }

}
