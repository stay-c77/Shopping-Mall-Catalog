import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewMap extends JFrame implements ActionListener {
    private JLabel imagelabel;
    private JPanel panel, buttonPanel;
    private JButton gf, ff, sf, tf, fourf, zoomInButton, zoomOutButton;
    private ImageIcon imageGround, imageFirst, imageSecond, imageThird, imageFourth;
    private double scale = 1.0;

    public ViewMap() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);

        imageGround = new ImageIcon(ClassLoader.getSystemResource("omallnew.jpg"));
        imageFirst = new ImageIcon(ClassLoader.getSystemResource("omallnew.jpg"));
        imageSecond = new ImageIcon(ClassLoader.getSystemResource("omallnew.jpg"));
        imageThird = new ImageIcon(ClassLoader.getSystemResource("omallnew.jpg"));
        imageFourth = new ImageIcon(ClassLoader.getSystemResource("omallnew.jpg"));

        // Create buttons for floor selection
        gf = createButton("Ground Floor");
        ff = createButton("First Floor");
        sf = createButton("Second Floor");
        tf = createButton("Third Floor");
        fourf = createButton("Fourth Floor");

        // Create buttons for zoom in and zoom out
        zoomInButton = createButton("Zoom In");
        zoomOutButton = createButton("Zoom Out");

        // Add action listeners
        gf.addActionListener(this);
        ff.addActionListener(this);
        sf.addActionListener(this);
        tf.addActionListener(this);
        fourf.addActionListener(this);
        zoomInButton.addActionListener(this);
        zoomOutButton.addActionListener(this);

        // Create panel to hold buttons
        buttonPanel = new JPanel(new GridLayout(1, 6, 10, 10));
        buttonPanel.add(gf);
        buttonPanel.add(ff);
        buttonPanel.add(sf);
        buttonPanel.add(tf);
        buttonPanel.add(fourf);
        buttonPanel.add(zoomInButton);
        buttonPanel.add(zoomOutButton);

        // Create panel to hold image label
        imagelabel = new JLabel();
        imagelabel.setHorizontalAlignment(JLabel.CENTER);
        imagelabel.setVerticalAlignment(JLabel.CENTER);

        // Add panels to main content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(imagelabel), BorderLayout.CENTER);

        // Display the initial image
        displayImage(imageGround);

        setVisible(true);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
        setIconImage(icon.getImage());
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewMap();
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gf) {
            displayImage(imageGround);
        } else if (e.getSource() == ff) {
            displayImage(imageFirst);
        } else if (e.getSource() == sf) {
            displayImage(imageSecond);
        } else if (e.getSource() == tf) {
            displayImage(imageThird);
        } else if (e.getSource() == fourf) {
            displayImage(imageFourth);
        } else if (e.getSource() == zoomInButton) {
            scale *= 0.9; // Decrease scale by 10%
            displayImage(getCurrentImage());
        } else if (e.getSource() == zoomOutButton) {
            scale *= 1.1; // Increase scale by 10%
            displayImage(getCurrentImage());
        }
    }

    private ImageIcon getCurrentImage() {
        Icon icon = imagelabel.getIcon();
        if (icon != null && icon instanceof ImageIcon) {
            return (ImageIcon) icon;
        }
        return null;
    }

    private void displayImage(ImageIcon imageIcon) {
        if (imageIcon != null) {
            // Resize image to fit the available space
            int newWidth = (int) (imageIcon.getIconWidth() * scale);
            int newHeight = (int) (imageIcon.getIconHeight() * scale);
            Image scaledImage = imageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            imagelabel.setIcon(new ImageIcon(scaledImage));
        }
    }
}
