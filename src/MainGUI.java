import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    private JButton createMainButton(String text, ActionListener onClick) {
        JButton button = new JButton(text);
        button.addActionListener(onClick);
        return button;
    }

    public MainGUI() {
        setTitle("Student Management System");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        mainPanel.add(createMainButton("Add Student", e -> new AddStudentWindow()));
        mainPanel.add(createMainButton("Update Student", e -> new UpdateStudentInfoWindow()));
        mainPanel.add(createMainButton("Students list", e -> new ViewStudentsWindow()));

        mainPanel.add(createMainButton("Add Course", e -> new AddCourseWindow()));
        mainPanel.add(createMainButton("Update Course", e -> new UpdateCourseInfoWindow()));
        mainPanel.add(createMainButton("Courses list", e -> new ViewCoursesWindow()));

        mainPanel.add(createMainButton("Enroll Student", e -> new EnrollStudentWindow()));

        add(mainPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
