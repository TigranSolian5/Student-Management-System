package course;
import java.util.List;


public class CourseService {


    public class CourseService implements CourseServiceI {
        @Override
        public Course createCourse(String courseName, int courseId, int startDate, int endDate,String schedualType , String college,int courseCredits, String courseLength,String room,int capacity) {
            return CourseDao.createCourse(courseName, courseId, startDate, endDate, schedualType, college, courseCredits, courseLength, room,capacity);
        }

        @Override
        public Course addCourse(String courseName, int courseId, int startDate, int endDate, String schedualType,String college, int courseCredits, String courseLength, String room, int capacity) {
            return CourseDao.createCourse(courseName, courseId, startDate, endDate, schedualType, college, courseCredits, courseLength, room, capacity);
        }

        @Override
        public List<Course> getAllCourses() {
            return CourseDao.readAllCourses();
        }

        @Override
        public void deleteCourse(Course course) {
            CourseDao.removeCourse(course);
        }
    }
}
