import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;

public class ViewStudentsWindow extends JFrame {
    public ViewStudentsWindow() {
        setTitle("View Students");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ArrayList<Student> students = StudentsManagement.getAllStudents();
        String[] columnNames = {"ID", "First Name", "Last Name", "Courses", "Grades"};
        Object[][] rowData = new Object[students.size()][5];

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            StringBuilder coursesStringBuilder = new StringBuilder();
            StringBuilder gradesStringBuilder = new StringBuilder();
            for (Map.Entry<Course, Integer> entry : student.getGrades().entrySet()) {
                coursesStringBuilder.append(entry.getKey().getName()).append(", ");
                gradesStringBuilder.append(entry.getValue()).append(", ");
            }
            rowData[i][0] = student.getID();
            rowData[i][1] = student.getFirstName();
            rowData[i][2] = student.getLastName();
            rowData[i][3] = coursesStringBuilder.toString();
            rowData[i][4] = gradesStringBuilder.toString();
        }

        var model = new DefaultTableModel(rowData, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make all cells non-editable
            }
        };
        JTable table = new JTable(model);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        int studentId = (int) table.getValueAt(selectedRow, 0);
                        var selectedStudent = StudentsManagement.getStudent(studentId);
                        new ViewStudentInfoWindow(selectedStudent);
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
}
