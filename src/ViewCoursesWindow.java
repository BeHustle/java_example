import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

public class ViewCoursesWindow extends JFrame {
    public ViewCoursesWindow() {
        setTitle("View Courses");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        var courses = CourseManagement.getAllCourses();
        String[] columnNames = {"Code", "Name", "Current Capacity", "Max Capacity"};
        var rowData = new Object[courses.size()][4];

        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            rowData[i][0] = course.getCode();
            rowData[i][1] = course.getName();
            rowData[i][2] = course.getCurrentCapacity();
            rowData[i][3] = course.getMaxCapacity();
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
                    var selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        var courseCode = (String) table.getValueAt(selectedRow, 0);
                        var selectedCourse = CourseManagement.getCourse(courseCode);
                        new ViewCourseInfoWindow(selectedCourse);
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
