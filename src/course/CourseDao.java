package course;

public class CourseDao {
    import java.util.Random;
    public class CourseDao {
        public static Course createCourse(String courseName,
                                          int startDate,
                                          int endDate) {
            java.lang.String courseId = generateCourseId();
            return new Course(courseName, startDate, 0,1,1,endDate);

        }
        public  static  Course createCourse(String courseName,
                                            int startDate,
                                            int endDate,
                                            String schedualType,
                                            String college,
                                            int courseCredits,
                                            String courseLength,
                                            String room,
                                            int capacity){
            return new Course(courseName,startDate,schedualType,college,courseCredits,courseLength,room)
        }


    }
