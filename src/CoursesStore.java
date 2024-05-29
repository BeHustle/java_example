import java.util.ArrayList;


public class CoursesStore implements IStore<Course, String> {
    private final ArrayList<Course> courses = new ArrayList<>();


    @Override
    public void add(Course course) {
        courses.add(course);
    }


    @Override
    public Course get(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }


    @Override
    public ArrayList<Course> getAll() {
        return courses;
    }
}
