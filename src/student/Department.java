package student;

public enum Department {
    CS("Computer Science"),
    DS("Data Science"),
    ES("Engineering Science"),
    EC("English & Communications"),
    BAB("Business");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
