import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class ViewStudentInfoWindow extends JFrame {
    public ViewStudentInfoWindow(Student student) {
        JFrame infoFrame = new JFrame();
        infoFrame.setTitle("Student Information");
        infoFrame.setSize(400, 300);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel infoPanel = new JPanel(new GridLayout(0, 1));

        JLabel nameLabel = new JLabel("Name: " + student.getFirstName() + " " + student.getLastName());
        JLabel idLabel = new JLabel("ID: " + student.getID());

        StringBuilder coursesStringBuilder = new StringBuilder();
        StringBuilder gradesStringBuilder = new StringBuilder();
        for (Map.Entry<Course, Integer> entry : student.getGrades().entrySet()) {
            coursesStringBuilder.append(entry.getKey().getName()).append(", ");
            gradesStringBuilder.append(entry.getValue()).append(", ");
        }
        JLabel coursesLabel = new JLabel("Courses: " + coursesStringBuilder.toString());
        JLabel gradesLabel = new JLabel("Grades: " + gradesStringBuilder.toString());

        infoPanel.add(nameLabel);
        infoPanel.add(idLabel);
        infoPanel.add(coursesLabel);
        infoPanel.add(gradesLabel);

        mainPanel.add(infoPanel, BorderLayout.CENTER);

        infoFrame.add(mainPanel);
        infoFrame.setVisible(true);
    }
}
