import javax.swing.*;
import java.awt.*;

public class BuildingLayoutDiagram extends JFrame {
    public BuildingLayoutDiagram() {
        setTitle("Building Layout Diagram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1)); // Three floors

        // Create panels for each floor
        JPanel groundFloorPanel = createFloorPanel("Ground Floor", Color.YELLOW, 5); // 5 rooms
        JPanel firstFloorPanel = createFloorPanel("First Floor", Color.GREEN, 7); // 7 rooms
        JPanel secondFloorPanel = createFloorPanel("Second Floor", Color.BLUE, 4); // 4 rooms

        // Add floor panels to main panel
        mainPanel.add(groundFloorPanel);
        mainPanel.add(firstFloorPanel);
        mainPanel.add(secondFloorPanel);

        // Set main panel as content pane
        setContentPane(mainPanel);

        // Set window size and make it visible
        pack(); // Automatically adjust window size based on components
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    private JPanel createFloorPanel(String floorName, Color color, int numRooms) {
        JPanel floorPanel = new JPanel();
        floorPanel.setBackground(color);
        floorPanel.setBorder(BorderFactory.createTitledBorder(floorName));
        floorPanel.setLayout(new GridLayout(1, numRooms)); // Layout rooms in a row

        // Add rooms to the floor panel
        for (int i = 1; i <= numRooms; i++) {
            JLabel roomLabel = new JLabel("Room " + i);
            roomLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center text
            roomLabel.setOpaque(true); // Make label opaque to show background color
            roomLabel.setBackground(Color.WHITE); // Room color
            roomLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Room border
            floorPanel.add(roomLabel);
        }

        return floorPanel;
    }

    public static void main(String[] args) {
        BuildingLayoutDiagram b=new BuildingLayoutDiagram();
        b.createFloorPanel("Ground Floor", Color.YELLOW, 4);
    }
}