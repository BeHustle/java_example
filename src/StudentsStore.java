import java.util.ArrayList;


public class StudentsStore implements IStore<Student, Integer> {
    private final ArrayList<Student> students = new ArrayList<>();


    @Override
    public Student get(Integer id) {
        for (Student student : students) {
            if (student.getID() == id) {
                return student;
            }
        }
        return null;
    }


    @Override
    public void add(Student student) {
        students.add(student);
    }


    @Override
    public ArrayList<Student> getAll() {
        return students;
    }
}
