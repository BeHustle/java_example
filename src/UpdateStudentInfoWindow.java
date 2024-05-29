import javax.swing.*;
import java.util.ArrayList;

public class UpdateStudentInfoWindow extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;

    private JComboBox<String> studentsComboBox;

    public UpdateStudentInfoWindow() {
        setTitle("Update Student Information");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel studentLabel = new JLabel("Select Student:");
        studentsComboBox = new JComboBox<>();
        populateStudentsComboBox();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> updateStudentInfo());

        mainPanel.add(studentLabel);
        mainPanel.add(studentsComboBox);
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(saveButton);

        add(mainPanel);
        setVisible(true);
    }

    private void populateStudentsComboBox() {
        ArrayList<Student> students = StudentsManagement.getAllStudents();
        for (Student student : students) {
            studentsComboBox.addItem(student.getFirstName() + " " + student.getLastName() + " (" + student.getID() + ")");
        }
    }

    private void updateStudentInfo() {
        try {
            int selectedStudentIndex = studentsComboBox.getSelectedIndex();
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();


            Student selectedStudent = null;
            if (selectedStudentIndex >= 0) {
                selectedStudent = StudentsManagement.getAllStudents().get(selectedStudentIndex);
            }
            if (selectedStudent == null) {
                throw new IllegalArgumentException("Please select a student to update.");
            }
            selectedStudent.setFirstName(firstName);
            selectedStudent.setLastName(lastName);
            JOptionPane.showMessageDialog(this, "Student information updated successfully!");
            dispose(); // Close the window after updating student info
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
