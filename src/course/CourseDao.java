package course;

import student.Student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class CourseDao {
    public static Course createCourse(String courseName,
                                      String professor,
                                      int courseId,
                                      String startDateString,
                                      String endDateString,
                                      int courseCredits,
                                      String room,
                                      int capacity) {
        Date startDate = null, endDate = null;
        try {
            startDate = getDate(startDateString);
            endDate = getDate(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Course course = new Course(courseName, professor, courseId, startDate, endDate, courseCredits, room, capacity);
        writeCourse(course);

        return course;
    }

    private static void writeCourse(Course course) {
        StringJoiner sj = new StringJoiner("|");

        try {
            String record = sj.add(course.getCourseName()).add(course.getProfessor()).add(Integer.toString(course.getCourseId()))
                    .add(course.getStartDate().toString()).add(course.getEndDate().toString()).add(Integer.toString(course.getCourseCredits()))
                    .add(course.getRoom()).add(Integer.toString(course.getCapacity())).toString();

            Path file = Paths.get("src", "courses", course.getCourseId() + ".txt");
            Files.createFile(file);
            Files.write(file, record.getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);
        } catch (FileNotFoundException e) {
            System.err.println("Error with the output stream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Course> readAllCourses() {
        List<Course> courses = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get("src", "courses"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

                            courses.add(parseString(lines.get(0)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public static List<Course> getCoursesByNames(String[] names) {
        List<Course> courses = new ArrayList<>();
        Set<String> nameSet = new HashSet<>();
        Collections.addAll(nameSet, names);

        try (Stream<Path> paths = Files.walk(Paths.get("src", "courses"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            System.out.println(path);
                            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                            Course course = parseString(lines.get(0));

                            if (nameSet.contains(course.getCourseName())) {
                                courses.add(course);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    private static Course parseString(String courseString) {
        String[] split = courseString.split("\\|");
        Date startDate = null, endDate = null;
        try {
            startDate = getDate(split[3]);
            endDate = getDate(split[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new Course(split[0], split[1], Integer.parseInt(split[2]), startDate, endDate, Integer.parseInt(split[5]),
                split[6], Integer.parseInt(split[7]));
    }

    private static Date getDate(String d) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        return sdf.parse(d);
    }
}