import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

public class ImageViewer extends JFrame {
    private JLabel imageLabel;
    private BufferedImage originalImage;
    private double scale = 1.0;

    public ImageViewer() {
        setTitle("Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create a JLabel for the image
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Load the image
        try {
            originalImage = ImageIO.read(new File("omallnew.jpg")); // Change the path to your image file
            displayImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create buttons for zoom in and zoom out
        JButton zoomInButton = new JButton("Zoom In");
        zoomInButton.addActionListener(e -> {
            scale *= 1.1; // Increase scale by 10%
            displayImage();
        });

        JButton zoomOutButton = new JButton("Zoom Out");
        zoomOutButton.addActionListener(e -> {
            scale /= 1.1; // Decrease scale by 10%
            displayImage();
        });

        // Add buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(zoomInButton);
        buttonPanel.add(zoomOutButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private void displayImage() {
        int newWidth = (int) (originalImage.getWidth() * scale);
        int newHeight = (int) (originalImage.getHeight() * scale);
        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageViewer().setVisible(true);
        });
    }
}