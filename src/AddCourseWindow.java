import javax.swing.*;

public class AddCourseWindow extends JFrame {
    private JTextField codeField;
    private JTextField nameField;
    private JTextField maxCapacityField;

    public AddCourseWindow() {
        setTitle("Add Course");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel codeLabel = new JLabel("Code:");
        codeField = new JTextField(20);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel maxCapacityLabel = new JLabel("Max Capacity:");
        maxCapacityField = new JTextField(20);

        JButton addButton = new JButton("Add Course");
        addButton.addActionListener(e -> addCourse());

        mainPanel.add(codeLabel);
        mainPanel.add(codeField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(maxCapacityLabel);
        mainPanel.add(maxCapacityField);
        mainPanel.add(addButton);

        add(mainPanel);
        setVisible(true);
    }

    private void addCourse() {
        try {
            String code = codeField.getText();
            String name = nameField.getText();
            int maxCapacity = Integer.parseInt(maxCapacityField.getText());

            CourseManagement.addCourse(code, name, maxCapacity);
            JOptionPane.showMessageDialog(this, "Course added successfully!");
            dispose(); // Close the window after adding course
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
