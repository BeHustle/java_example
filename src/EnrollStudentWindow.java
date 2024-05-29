import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EnrollStudentWindow extends JFrame {
    private JComboBox<String> courseComboBox;
    private JComboBox<String> studentComboBox;

    public EnrollStudentWindow() {
        setTitle("Enroll Student");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel courseLabel = new JLabel("Select Course:");
        courseComboBox = new JComboBox<>();
        populateCourseComboBox();

        JLabel studentLabel = new JLabel("Select Student:");
        studentComboBox = new JComboBox<>();
        populateStudentComboBox();

        JButton enrollButton = new JButton("Enroll");
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enrollStudent();
            }
        });

        mainPanel.add(courseLabel);
        mainPanel.add(courseComboBox);
        mainPanel.add(studentLabel);
        mainPanel.add(studentComboBox);
        mainPanel.add(enrollButton);

        add(mainPanel);
        setVisible(true);
    }

    private void populateCourseComboBox() {
        ArrayList<Course> courses = CourseManagement.getAllCourses();
        for (Course course : courses) {
            courseComboBox.addItem(course.getName());
        }
    }

    private void populateStudentComboBox() {
        ArrayList<Student> students = StudentsManagement.getAllStudents();
        for (Student student : students) {
            studentComboBox.addItem(student.getFirstName() + " " + student.getLastName());
        }
    }

    private void enrollStudent() {
        String selectedCourseName = (String) courseComboBox.getSelectedItem();
        String selectedStudentFullName = (String) studentComboBox.getSelectedItem();

        // Extracting first and last names from the full name
        String[] studentNames = selectedStudentFullName.split(" ");
        String firstName = studentNames[0];
        String lastName = studentNames[1];

        // Find the selected course and student objects
        Course selectedCourse = null;
        Student selectedStudent = null;
        for (Course course : CourseManagement.getAllCourses()) {
            if (course.getName().equals(selectedCourseName)) {
                selectedCourse = course;
                break;
            }
        }
        for (Student student : StudentsManagement.getAllStudents()) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                selectedStudent = student;
                break;
            }
        }

        // Enroll the student in the selected course
        if (selectedCourse != null && selectedStudent != null) {
            try {
                CourseManagement.enrollStudent(selectedCourse, selectedStudent);
                JOptionPane.showMessageDialog(this, "Student enrolled successfully!");
                dispose(); // Close the window after enrolling student
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Course or student not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
