package course;

import java.util.Date;

public class Course {
    private String courseName;
    private String professor;
    private int courseId;
    private Date startDate;
    private Date endDate;
    private int courseCredits;
    private String room;
    private int capacity;

    public Course(String courseName, String professor, int courseId, Date startDate, Date endDate, int courseCredits, String room, int capacity) {
        this.courseName = courseName;
        this.professor = professor;
        this.courseId = courseId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseCredits = courseCredits;
        this.room = room;
        this.capacity = capacity;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return courseId + ": \"" + courseName + "\" by " + professor + ", Credits - " + courseCredits;
    }
}
