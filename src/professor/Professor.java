package professor;

public class Professor implements ProfessorInterface {
        private String title;
        private String department;
        private Vector teaches;

        public Professor(String name, String ssn, String title, String dept) {

            super(name, ssn);

            setTitle(title);
            setDepartment(dept);

            teaches = new Vector();
        }
        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setDepartment(String dept) {
            department = dept;
        }

        public String getDepartment() {
            return department;
        }

    }


