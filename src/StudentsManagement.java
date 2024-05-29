import java.util.ArrayList;


public class StudentsManagement {
    private static final StudentsStore studentsStore = new StudentsStore();

    public static Student addStudent(String name, String lastName, int id) {
        if (studentsStore.get(id) != null) {
            throw new IllegalArgumentException("Student with ID " + id + " already exists");
        }
        Student newStudent = new Student(name, lastName, id);
        studentsStore.add(newStudent);
        return newStudent;
    }


    public static ArrayList<Student> getAllStudents() {
        return studentsStore.getAll();
    }


    public static Student getStudent(int id) {
        return studentsStore.get(id);
    }
}
