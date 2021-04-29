package student;

import course.Course;

import java.util.Set;

public class Student {
    private final String name;
    private final String surname;
    private String studentID;
    private double GPA;
    private int year;
    private int semester;
    private Department department;
    private Set<Course> currentCourses;
    private Set<Course> previousCourses;

    public Student(String name, String surname, String studentID, double GPA, int year, int semester, Department department) {
        this.name = name;
        this.surname = surname;
        this.studentID = studentID;
        this.GPA = GPA;
        this.year = year;
        this.semester = semester;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
