package student;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
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

    public static void removeStudent(Student student) {
//        File file = new File(STUDENT_DB_FILENAME);
//        try {
//            RandomAccessFile raFile = new RandomAccessFile(file, "rw");
//
//            while (raFile.getFilePointer() < raFile.length()) {
////                buffer.append(raFile.readLine()).append(System.lineSeparator());
//                String studentString = raFile.readLine();
//                System.out.println(studentString);
//
//                if (student.equals(parseString(studentString))) {
//
//                    raFile.write("".getBytes(StandardCharsets.UTF_8));
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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

        try {
            String record = sj.add(student.getName()).add(student.getSurname()).add(student.getStudentID())
                    .add(Integer.toString(student.getGPA())).add(Integer.toString(student.getYear())).add(Integer.toString(student.getSemester()))
                    .add(student.getDepartment().toString()).toString();

            Path file = Paths.get("src", "students", student.getStudentID() + ".txt");
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

        return new Student(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]),
                Integer.parseInt(split[5]), Department.valueOf(split[6]));
    }
}
