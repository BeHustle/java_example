import java.util.HashMap;
import java.util.Map;


public class Student {
    private String firstName;


    private String lastName;


    private final int ID;


    private final Map<Course, Integer> grades = new HashMap<>();


    public Student(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
    }


    public void addCourse(Course course) {
        if (grades.containsKey(course)) {
            throw new IllegalArgumentException("Student is already enrolled in course");
        }
        grades.put(course, 0);
    }


    public Map<Course, Integer> getGrades() {
        return grades;
    }


    public void assignGrade(Course course, int grade) {
        if (!grades.containsKey(course)) {
            throw new IllegalArgumentException("Student is not enrolled in course");
        }
        grades.put(course, grade);
    }


    public int getID() {
        return ID;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String gradeToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Course, Integer> entry : grades.entrySet()) {
            sb.append(entry.getKey().getName()).append(": ").append(entry.getValue()).append(", ");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "Student ID: " + ID + ", Name: " + firstName + " " + lastName + ", Grades: " + gradeToString() + "\n";
    }
}
