package student;

import java.util.Random;

public class StudentDao {
    public static Student createStudent(String name,
                                        String surname,
                                        Department department) {
        String studentId = generateStudentId();

        return new Student(name, surname, studentId, 0, 1, 1, department);
    }

    public static Student createStudent(String name,
                                        String surname,
                                        String studentId,
                                        double GPA,
                                        int year,
                                        int semester,
                                        Department department) {
        return new Student(name, surname, studentId, GPA, year, semester, department);
    }

    private static String generateStudentId() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 2;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
