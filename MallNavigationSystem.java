import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MallNavigationSystem extends JFrame {
    private Connection connection;
    private JTextField usernameField, shopNameField, shopLocationField;
    private JPasswordField passwordField;
    private JTextArea mallLayoutArea;

    public MallNavigationSystem() {
        initializeDatabase();
        initializeGUI();

        setTitle("Shopping Mall Navigation System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/mall_database";
            String username = "admin";
            String password = "admin";
            connection = DriverManager.getConnection(url, username, password);
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    private void createTables() {
        try {
            Statement stmt = connection.createStatement();
            String createShopsTableSQL = "CREATE TABLE IF NOT EXISTS shops (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(100) NOT NULL," +
                    "location VARCHAR(100) NOT NULL)";
            stmt.executeUpdate(createShopsTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to create tables in the database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initializeGUI() {
        JPanel mallLayoutPanel = new JPanel();
        mallLayoutArea = new JTextArea(20, 50);
        mallLayoutArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(mallLayoutArea);
        mallLayoutPanel.add(scrollPane);

        JPanel adminPanel = new JPanel(new GridLayout(5, 2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JLabel shopNameLabel = new JLabel("Shop Name:");
        shopNameField = new JTextField();
        JLabel shopLocationLabel = new JLabel("Shop Location:");
        shopLocationField = new JTextField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> adminLogin());
        JButton signupButton = new JButton("Signup");
        signupButton.addActionListener(e -> adminSignup());

        adminPanel.add(usernameLabel);
        adminPanel.add(usernameField);
        adminPanel.add(passwordLabel);
        adminPanel.add(passwordField);
        adminPanel.add(shopNameLabel);
        adminPanel.add(shopNameField);
        adminPanel.add(shopLocationLabel);
        adminPanel.add(shopLocationField);
        adminPanel.add(loginButton);
        adminPanel.add(signupButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mallLayoutPanel, BorderLayout.CENTER);
        getContentPane().add(adminPanel, BorderLayout.SOUTH);
    }

    private void adminLogin() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String passwordString = new String(password);

        try {
            String query = "SELECT * FROM admins WHERE username=? AND password=?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, passwordString);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                openAdminDashboard();
            } else {
                displayLoginErrorMessage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error executing SQL query.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adminSignup() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();
        String passwordString = new String(password);

        try {
            String query = "INSERT INTO admins (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, passwordString);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Admin account created successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error creating admin account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openAdminDashboard() {
        // Implement admin dashboard functionality here
    }

    private void displayLoginErrorMessage() {
        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MallNavigationSystem::new);
    }
}
