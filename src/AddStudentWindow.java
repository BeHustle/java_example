import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentWindow extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField idField;

    public AddStudentWindow() {
        setTitle("Add Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(20);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);
        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(addButton);

        add(mainPanel);
        setVisible(true);
    }

    private void addStudent() {
        // Add student to the store
        try {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            int id = Integer.parseInt(idField.getText());

            StudentsManagement.addStudent(firstName, lastName, id);
            JOptionPane.showMessageDialog(this, "Student added successfully!");
            dispose(); // Close the window after adding student
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
