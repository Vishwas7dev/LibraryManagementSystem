package src.model;

public class Student {
    private int id;
    private String name;
    private String course;
    private String year;

    public Student() {}

    // ✅ This is the missing constructor
    public Student(String name, String course, String year) {
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
