import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateCourseInfoWindow extends JFrame {
    private JComboBox<String> courseComboBox;
    private JTextField newNameField;
    private JTextField newMaxCapacityField;

    public UpdateCourseInfoWindow() {
        setTitle("Update Course");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel courseLabel = new JLabel("Select Course:");
        courseComboBox = new JComboBox<>();
        populateCourseComboBox();

        JLabel newNameLabel = new JLabel("New Name:");
        newNameField = new JTextField(20);

        JLabel newMaxCapacityLabel = new JLabel("New Max Capacity:");
        newMaxCapacityField = new JTextField(20);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updateCourse());

        mainPanel.add(courseLabel);
        mainPanel.add(courseComboBox);
        mainPanel.add(newNameLabel);
        mainPanel.add(newNameField);
        mainPanel.add(newMaxCapacityLabel);
        mainPanel.add(newMaxCapacityField);
        mainPanel.add(updateButton);

        add(mainPanel);
        setVisible(true);
    }

    private void populateCourseComboBox() {
        ArrayList<Course> courses = CourseManagement.getAllCourses();
        for (Course course : courses) {
            courseComboBox.addItem(course.getName() + " (" + course.getCode() + ")");
        }
    }

    private void updateCourse() {
        try {
            int selectedCourseIndex = courseComboBox.getSelectedIndex();
            String newName = newNameField.getText();
            int newMaxCapacity = Integer.parseInt(newMaxCapacityField.getText());

            // Find the selected course object
            Course selectedCourse = null;
            if (selectedCourseIndex >= 0) {
                selectedCourse = CourseManagement.getAllCourses().get(selectedCourseIndex);
            }
            if (selectedCourse == null) {
                throw new IllegalArgumentException("Please select a course to update!");
            }
            selectedCourse.setName(newName);
            selectedCourse.setMaxCapacity(newMaxCapacity);
            JOptionPane.showMessageDialog(this, "Course information updated successfully!");
            dispose(); // Close the window after updating course info
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
