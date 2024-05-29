import javax.swing.*;
import java.awt.*;

public class ViewCourseInfoWindow extends JFrame {
    public ViewCourseInfoWindow(Course course) {
        JFrame infoFrame = new JFrame();
        infoFrame.setTitle("Course Information");
        infoFrame.setSize(400, 300);
        infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel infoPanel = new JPanel(new GridLayout(0, 1));

        JLabel nameLabel = new JLabel("Name: " + course.getName());
        JLabel codeLabel = new JLabel("Code: " + course.getCode());
        JLabel currentCapacityLabel = new JLabel("Current Capacity: " + course.getCurrentCapacity());
        JLabel maxCapacityLabel = new JLabel("Max Capacity: " + course.getMaxCapacity());

        infoPanel.add(nameLabel);
        infoPanel.add(codeLabel);
        infoPanel.add(currentCapacityLabel);
        infoPanel.add(maxCapacityLabel);

        mainPanel.add(infoPanel, BorderLayout.CENTER);

        infoFrame.add(mainPanel);
        infoFrame.setVisible(true);
    }
}
