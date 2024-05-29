import java.util.ArrayList;

public class CourseManagement {
    private static final CoursesStore coursesStore = new CoursesStore();

    public static Course addCourse(String code, String name, int maxCapacity) {
        try {
            coursesStore.get(code);
            throw new IllegalArgumentException("Course with code " + code + " already exists");
        } catch (IllegalArgumentException e) {
            // Do nothing
        }
        Course newCourse = new Course(code, name, maxCapacity);
        coursesStore.add(newCourse);
        return newCourse;
    }


    public static ArrayList<Course> getAllCourses() {
        return coursesStore.getAll();
    }


    public static Course getCourse(String code) {
        return coursesStore.get(code);
    }


    public static void enrollStudent(Course course, Student student) {
        course.incrementCurrentCapacity();
        student.addCourse(course);
    }


    public static void assignGrade(Student student, Course course, int grade) {
        student.assignGrade(course, grade);
    }


    public static float calculateOverallGrade(Student student) {
        if (student.getGrades().isEmpty()) {
            return 0;
        }
        int total = 0;
        for (int grade : student.getGrades().values()) {
            total += grade;
        }
        return (float) total / student.getGrades().size();
    }
}
