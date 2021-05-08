package student;

import course.Course;
import course.CourseDao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class StudentDao {
    public static Student createStudent(String name,
                                        String surname,
                                        Department department) {
        String studentId = generateStudentId();

        Student s = new Student(name, surname, studentId, 0, 1, 1, department);
        writeStudent(s);

        return s;
    }

    public static Student createStudent(String name,
                                        String surname,
                                        String studentId,
                                        int GPA,
                                        int year,
                                        int semester,
                                        Department department) {
        Student s = new Student(name, surname, studentId, GPA, year, semester, department);
        writeStudent(s);

        return s;
    }

    public static List<Student> readAllStudents() {
        List<Student> students = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get("src", "students"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

                            students.add(parseString(lines.get(0)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static String readStudent(String studentId) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src", "students", studentId + ".txt"), StandardCharsets.UTF_8);

            return lines.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void removeStudent(Student student) {
        try {
            Files.delete(Paths.get("src", "students", student.getStudentID() + ".txt"));
        } catch (IOException e) {
            System.err.println("Error while deleting the user: " + e);
        }
    }

    public static void removeCourseFromStudent(Student student, Course course) {
        student.getCurrentCourses().remove(course);

        student.getPreviousCourses().add(course);
    }

    public static void addStudentToCourseArray(String[] studentIds, Course course) {
        List<Student> students = getStudentsFromIds(studentIds);
        StringJoiner sj = new StringJoiner(",");

        students.forEach(student -> {
            student.getCurrentCourses().add(course);

//            String record = readStudent(student.getStudentID());
//            String[] split = record.split("\\|");
//            sj.add(split[split.length - 1]).add(course.getCourseName());

            writeStudent(student);
        });
    }

    private static String generateStudentId() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 8;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
                .toUpperCase();
    }

    private static void writeStudent(Student student) {
        StringJoiner sj = new StringJoiner("|");
        StringJoiner coursesSj = new StringJoiner(",");
        Set<Course> currentCourses = student.getCurrentCourses();
        currentCourses.forEach(course -> coursesSj.add(course.getCourseName()));

        try {
            String record = sj.add(student.getName()).add(student.getSurname()).add(student.getStudentID())
                    .add(Integer.toString(student.getGPA())).add(Integer.toString(student.getYear())).add(Integer.toString(student.getSemester()))
                    .add(student.getDepartment().toString()).add(coursesSj.toString()).toString();

            Path file = Paths.get("src", "students", student.getStudentID() + ".txt");
            if (Files.exists(file)) {
                Files.delete(file);
            }

            Files.createFile(file);
            Files.write(file, record.getBytes(StandardCharsets.UTF_8), StandardOpenOption.WRITE);
        } catch (FileNotFoundException e) {
            System.err.println("Error with the output stream");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Student parseString(String studentString) {
        String[] split = studentString.split("\\|");
        String currentCoursesString = split[7];
        String[] courseNames = currentCoursesString.split(",");

        List<Course> coursesByNames = CourseDao.getCoursesByNames(courseNames);
        Set<Course> courses = new HashSet<>(coursesByNames);

        Student student = new Student(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]),
                Integer.parseInt(split[5]), Department.valueOf(split[6]));
        student.setCurrentCourses(courses);

        return student;
    }

    private static List<Student> getStudentsFromIds(String[] ids) {
        List<Student> students = new ArrayList<>();
        Set<String> idSet = new HashSet<>();
        Collections.addAll(idSet, ids);

        try (Stream<Path> paths = Files.walk(Paths.get("src", "students"))) {
            paths
                    .filter(Files::isRegularFile)
                    .forEach(path -> {
                        try {
                            System.out.println(path);
                            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
                            Student student = parseString(lines.get(0));

                            if (idSet.contains(student.getStudentID())) {
                                students.add(student);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

}
