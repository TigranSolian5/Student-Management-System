package course;
import java.util.Set;


public class Course {


        private String courseName;
        private int courseId;
        private int startDate;
        private int endDate;
        private String schedualType;
        private String college;
        private int courseCredits;
        private String courseLength;
        private String room;
        private int capacity;

        public Course(String courseName, int courseId, int startDate, int endDate, int courseCredits, int capacity){
            this.coursename = coursename;
            this.capacity = capacity;
            this.courseId = courseId;
            this.startDate = startDate;
            this.endDate = endDate;
            this.schedualType = schedualType;
            this.college= college;
            this.courseCredits = courseCredits;
            this.courseLength = courseLength;
            this.room = room;

        }
        public String getCourseName(){
            return courseName;
        }


        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public java.lang.String getRoom() {
            return room;
        }

        public void setRoom(java.lang.String room) {
            this.room = room;
        }

        public java.lang.String getCourseLength() {
            return courseLength;
        }

        public void setCourseLength(java.lang.String courseLength) {
            this.courseLength = courseLength;
        }

        public int getCourseCredits() {
            return courseCredits;
        }

        public void setCourseCredits(int courseCredits) {
            this.courseCredits = courseCredits;
        }

        public java.lang.String getCollege() {
            return college;
        }

        public void setCollege(java.lang.String college) {
            this.college = college;
        }

        public java.lang.String getSchedualType() {
            return schedualType;
        }

        public void setSchedualType(java.lang.String schedualType) {
            this.schedualType = schedualType;
        }

        public int getEndDate() {
            return endDate;
        }

        public void setEndDate(int endDate) {
            this.endDate = endDate;
        }

        public int getStartDate() {
            return startDate;
        }

        public void setStartDate(int startDate) {
            this.startDate = startDate;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public void setCourseName(java.lang.String courseName) {
            this.courseName = courseName;
        }
    }

}
